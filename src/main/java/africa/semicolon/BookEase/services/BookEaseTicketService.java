package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.data.repositories.TicketRepository;
import africa.semicolon.BookEase.dtos.request.CancelReservationRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.exceptions.CannotCancelZeroTicket;
import africa.semicolon.BookEase.exceptions.CannotReserveZeroTicket;
import africa.semicolon.BookEase.exceptions.TicketCannotBeReservedAnymoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class BookEaseTicketService implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Event reserveTicket(Event event, ReserveTicketRequest reserveTicketRequest) {
        if (event.getAvailableAttendees() == 1000) throw new
                TicketCannotBeReservedAnymoreException("Ticket Not Available Anymore");
        if (reserveTicketRequest.getNumberOfReservedTicket()  < 1) throw new
                CannotReserveZeroTicket("Cannot reserve Zero Ticket");
        List<Ticket> tickets = IntStream.range(0,reserveTicketRequest.getNumberOfReservedTicket())
                        .parallel()
                                .mapToObj(count -> createTicket(event,count, reserveTicketRequest.getAttendeesEmail()))
                                        .peek(ticket -> ticket.setEvent(event))
                                                .toList();
        ticketRepository.saveAll(tickets);
        event.setAvailableAttendees(((event.getAvailableAttendees()+
                reserveTicketRequest.getNumberOfReservedTicket())));
        return event;
    }
    @Override
    public List<Ticket> findByEmail(String userEmail) {
        return ticketRepository.findByEmail(userEmail);
    }
    @Override
    public Event cancelReservedTicket(Event event, CancelReservationRequest cancelReservationRequest) {
        List<Ticket> tickets = ticketRepository.findByEmail(cancelReservationRequest.getAttendeesEmail());
        if (cancelReservationRequest.getNumberOfReservedTicket()  < 1) throw new
                CannotCancelZeroTicket("Cannot Cancel Zero Ticket");
        tickets.stream().filter(e -> e.getEventName().equals(event.getEventName()))
                .parallel()
                .forEach(ticket -> cancelTicket(event,ticket));
        int updatedAvailableAttendees = event.getAvailableAttendees() -
                cancelReservationRequest.getNumberOfReservedTicket();
        event.setAvailableAttendees(updatedAvailableAttendees);
        return event;
    }
    private void cancelTicket(Event event, Ticket ticket) {
            ticketRepository.delete(ticket);
            event.getTickets().remove(ticket);
    }
//    @Transactional
    public Ticket createTicket(Event event, int count, String email) {
        Ticket ticket = new Ticket();
        ticket.setEventName(event.getEventName());
        ticket.setTicketId(count +1);
        ticket.setEmail(email);
        return ticket;
    }
}

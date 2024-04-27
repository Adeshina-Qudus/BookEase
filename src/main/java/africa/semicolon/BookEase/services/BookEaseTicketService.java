package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.data.repositories.TicketRepository;
import africa.semicolon.BookEase.dtos.request.CancelReservationRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
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
        for (int count = 0 ; count < cancelReservationRequest.getNumberOfReservedTicket();count ++){
            cancelTicket(event, tickets, count);
        }
        event.setAvailableAttendees(event.getAvailableAttendees()-
                cancelReservationRequest.getNumberOfReservedTicket());
        return event;
    }
    private void cancelTicket(Event event, List<Ticket> tickets, int count) {
        if (tickets.get(count).getEventName().equals(event.getEventName())){
            ticketRepository.delete(tickets.get(count));
            event.getTickets().remove(tickets.get(count));
        }
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

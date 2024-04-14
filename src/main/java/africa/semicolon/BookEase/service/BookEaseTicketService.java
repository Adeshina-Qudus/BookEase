package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.data.repositories.TicketRepository;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;
import africa.semicolon.BookEase.exception.TicketCannotBeReservedAnymoreException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookEaseTicketService implements TicketService{

    @Autowired
    TicketRepository ticketRepository;
    @Override
    public ReserveTicketResponse reserveTicket(Event event, Integer numberOfReservedTicket) {
        ReserveTicketResponse response = new ReserveTicketResponse();
        if (ticketRepository.count() == 100) throw new
                TicketCannotBeReservedAnymoreException("Ticket Not Available Anymore");

        for (int count = 0 ; count < numberOfReservedTicket; count++){
            createTicket(event, count);
        }

        event.setAvailableAttendees((int) ticketRepository.count());
        response.setEventName(event.getEventName());
        response.setNumberOfReservedTicked(numberOfReservedTicket);
        return response;
    }

    private void createTicket(Event event, int count) {
        Ticket ticket = new Ticket();
        ticket.setEventName(event.getEventName());
        ticket.setTickedId(count +1);
        ticketRepository.save(ticket);
    }


}

package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.data.repositories.TicketRepository;
import africa.semicolon.BookEase.exception.TicketCannotBeReservedAnymoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEaseTicketService implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Event reserveTicket(Event event, Integer numberOfReservedTicket, String attendeesEmail) {
        if (ticketRepository.count() == 1000) throw new
                TicketCannotBeReservedAnymoreException("Ticket Not Available Anymore");

        for (int count = 0 ; count < numberOfReservedTicket; count++){
            createTicket(event, count,attendeesEmail);
        }

        event.setAvailableAttendees((int) (event.getAvailableAttendees()+ ticketRepository.count()));
        return event;
    }

    @Override
    public List<Ticket> findByEmail(String userEmail) {
        return ticketRepository.findByEmail(userEmail);

    }

    @Override
    public Event cancelReservedTicket(Event event, Integer numberOfReservedTicket, String attendeesEmail) {
        List<Ticket> tickets = ticketRepository.findByEmail(attendeesEmail);
        for (int count = 0 ; count < numberOfReservedTicket;count ++){
            cancelTicket(event, tickets, count);
        }
        event.setAvailableAttendees((int) event.getAvailableAttendees() - numberOfReservedTicket);
        return event;
    }

    private void cancelTicket(Event event, List<Ticket> tickets, int count) {
        if (tickets.get(count).getEventName().equals(event.getEventName())){
            ticketRepository.delete(tickets.get(count));
        }
    }


    private void createTicket(Event event, int count,String email) {
        Ticket ticket = new Ticket();
        ticket.setEventName(event.getEventName());
        ticket.setTicketId(count +1);
        ticket.setEmail(email);
        ticketRepository.save(ticket);
    }


}

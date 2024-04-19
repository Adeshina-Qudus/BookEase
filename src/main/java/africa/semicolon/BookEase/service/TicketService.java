package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;

import java.util.List;

public interface TicketService {

    Event reserveTicket(Event event, Integer numberOfReservedTicket, String attendeesEmail);

    List<Ticket> findByEmail(String userEmail);

    Event cancelReservedTicket(Event event, Integer numberOfReservedTicket, String attendeesEmail);
}

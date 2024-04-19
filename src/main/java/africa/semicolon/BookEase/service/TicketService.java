package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;

public interface TicketService {

    Event reserveTicket(Event event, Integer numberOfReservedTicket, String attendeesEmail);
}

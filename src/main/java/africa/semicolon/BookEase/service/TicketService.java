package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;

public interface TicketService {

    Event reserveTicket(Event event, Integer numberOfReservedTicket);
}

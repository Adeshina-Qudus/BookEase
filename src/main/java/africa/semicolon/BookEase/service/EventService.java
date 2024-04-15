package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.request.SearchEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest request);

    SearchEventResponse searchEvent(SearchEventRequest searchEventRequest);

    ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    void save(Event event);
}

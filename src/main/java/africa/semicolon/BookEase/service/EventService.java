package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.request.SearchEventRequest;
import africa.semicolon.BookEase.dtos.request.ViewBookedEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;
import africa.semicolon.BookEase.dtos.response.ViewBookedEventResponse;

import java.util.List;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest request);

    SearchEventResponse searchEvent(SearchEventRequest searchEventRequest);

    ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    void save(Event event);

    List<ViewBookedEventResponse> viewBookedEvent(ViewBookedEventRequest viewBookedEventRequest);
}

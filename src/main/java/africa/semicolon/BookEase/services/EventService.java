package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.*;

import java.util.List;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest request);

    SearchEventResponse searchEvent(SearchEventRequest searchEventRequest);

    ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    void save(Event event);

    List<ViewBookedEventResponse> viewBookedEvent(ViewBookedEventRequest viewBookedEventRequest);

    CancelReservationResponse cancelReservation(CancelReservationRequest cancelReservationRequest);
}

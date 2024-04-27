package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.*;

import java.util.List;


public interface UserService {
    CreateAccountResponse createAccount(CreateAccountRequest request);

    CreateEventResponse createEvent(CreateEventRequest request);

    SearchEventResponse searchEvent(SearchEventRequest searchEventRequest);

    ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    List<ViewBookedEventResponse> viewBookedEvent(ViewBookedEventRequest viewBookedEventRequest);

    CancelReservationResponse cancelReservation(CancelReservationRequest cancelReservationRequest);
}

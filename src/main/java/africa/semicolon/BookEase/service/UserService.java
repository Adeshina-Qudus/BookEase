package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.*;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserService {
    CreateAccountResponse createAccount(CreateAccountRequest request);

    CreateEventResponse createEvent(CreateEventRequest request);

    SearchEventResponse searchEvent(SearchEventRequest searchEventRequest);

    ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    List<ViewBookedEventResponse> viewBookedEvent(ViewBookedEventRequest viewBookedEventRequest);
}

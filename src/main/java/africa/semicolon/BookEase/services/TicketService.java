package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.dtos.request.CancelReservationRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;

import java.util.List;

public interface TicketService {

    Event reserveTicket(Event event, ReserveTicketRequest reserveTicketRequest);

    List<Ticket> findByEmail(String userEmail);

    Event cancelReservedTicket(Event event, CancelReservationRequest cancelReservationRequest);
}

package africa.semicolon.BookEase.exceptions;

public class TicketCannotBeReservedAnymoreException extends BookEaseException {
    public TicketCannotBeReservedAnymoreException(String ticketNotAvailableAnymore) {
        super(ticketNotAvailableAnymore);
    }
}

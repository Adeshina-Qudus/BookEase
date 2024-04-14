package africa.semicolon.BookEase.exception;

public class TicketCannotBeReservedAnymoreException extends BookEaseException {
    public TicketCannotBeReservedAnymoreException(String ticketNotAvailableAnymore) {
        super(ticketNotAvailableAnymore);
    }
}

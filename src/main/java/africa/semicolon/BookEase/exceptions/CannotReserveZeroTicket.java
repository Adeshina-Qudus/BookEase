package africa.semicolon.BookEase.exceptions;

public class CannotReserveZeroTicket extends BookEaseException {
    public CannotReserveZeroTicket(String message) {
        super(message);
    }
}

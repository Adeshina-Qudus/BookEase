package africa.semicolon.BookEase.exceptions;

public class CannotCancelZeroTicket extends BookEaseException {
    public CannotCancelZeroTicket(String message) {
        super(message);
    }
}

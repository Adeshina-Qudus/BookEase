package africa.semicolon.BookEase.exceptions;

public class UserDoesntExistException extends BookEaseException {
    public UserDoesntExistException(String message) {
        super(message);
    }
}

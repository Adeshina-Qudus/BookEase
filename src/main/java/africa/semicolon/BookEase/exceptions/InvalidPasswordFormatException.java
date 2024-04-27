package africa.semicolon.BookEase.exceptions;

public class InvalidPasswordFormatException extends BookEaseException {
    public InvalidPasswordFormatException(String invalidPasswordFormat) {
        super(invalidPasswordFormat);
    }
}

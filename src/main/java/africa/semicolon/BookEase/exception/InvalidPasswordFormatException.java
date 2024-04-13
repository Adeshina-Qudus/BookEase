package africa.semicolon.BookEase.exception;

public class InvalidPasswordFormatException extends BookEaseException {
    public InvalidPasswordFormatException(String invalidPasswordFormat) {
        super(invalidPasswordFormat);
    }
}

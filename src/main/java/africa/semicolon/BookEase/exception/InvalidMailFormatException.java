package africa.semicolon.BookEase.exception;

public class InvalidMailFormatException extends BookEaseException {
    public InvalidMailFormatException(String invalidEmailFormat) {
        super(invalidEmailFormat);
    }
}

package africa.semicolon.BookEase.exceptions;

public class InvalidMailFormatException extends BookEaseException {
    public InvalidMailFormatException(String invalidEmailFormat) {
        super(invalidEmailFormat);
    }
}

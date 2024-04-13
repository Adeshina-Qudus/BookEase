package africa.semicolon.BookEase.exception;

public class InvalidPasswordFormat extends BookEaseException {
    public InvalidPasswordFormat(String invalidPasswordFormat) {
        super(invalidPasswordFormat);
    }
}

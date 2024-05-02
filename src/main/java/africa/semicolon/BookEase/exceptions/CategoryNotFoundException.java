package africa.semicolon.BookEase.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String categoryDoesntExist) {
        super(categoryDoesntExist);
    }
}

package africa.semicolon.BookEase.utils;

import africa.semicolon.BookEase.data.model.User;
import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;

public class BookEaseUserMapper {


    public static User map(CreateAccountRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }
}

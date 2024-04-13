package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import org.springframework.stereotype.Repository;


public interface UserService {
    void createAccount(CreateAccountRequest request);
}

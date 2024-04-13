package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.dtos.response.CreateAccountResponse;
import org.springframework.stereotype.Repository;


public interface UserService {
    CreateAccountResponse createAccount(CreateAccountRequest request);
}

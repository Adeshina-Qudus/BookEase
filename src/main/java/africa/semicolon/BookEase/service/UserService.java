package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;

public interface UserService {
    void createAccount(CreateAccountRequest request);
}

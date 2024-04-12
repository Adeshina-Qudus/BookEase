package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookEaseUserService implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public void createAccount(CreateAccountRequest request) {
        if(userExist(request.getEmail())) throw new UserAlreadyExistException(
                request.getEmail()+" already exist"
        );
    }

    private boolean userExist(String email) {
        return userRepository.findByMail(email);
    }
}

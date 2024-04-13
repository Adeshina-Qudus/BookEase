package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.repositories.UserRepository;
import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.data.model.User;
import africa.semicolon.BookEase.dtos.response.CreateAccountResponse;
import africa.semicolon.BookEase.exception.InvalidMailFormatException;
import africa.semicolon.BookEase.exception.InvalidPasswordFormat;
import africa.semicolon.BookEase.exception.LengthMoreThan100Exception;
import africa.semicolon.BookEase.utils.BookEaseUserMapper;
import africa.semicolon.BookEase.utils.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.BookEase.exception.UserAlreadyExistException;
@Service
public class BookEaseUserService implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        CreateAccountResponse response = new CreateAccountResponse();
        if (request.getName().length() > 100) throw new LengthMoreThan100Exception(
          "Name is limited to 100 characters"
        );
        if(userExist(request.getEmail())) throw new UserAlreadyExistException(
                request.getEmail()+" already exist"
        );
        if (!(Verification.verifyEmail(request.getEmail()))) throw new InvalidMailFormatException(
                "Invalid Email Format"
        );
        if(!(Verification.verifyPassword(request.getPassword()))) throw new InvalidPasswordFormat(
                "Invalid Password Format"
        );
        User user = BookEaseUserMapper.map(request);
        userRepository.save(user);
        response.setMessage("Account Created");
        return response;
    }

    private boolean userExist(String email) {
        User user =  userRepository.findByEmail(email);
        return user != null;
    }
}

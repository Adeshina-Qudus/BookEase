package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.repositories.UserRepository;
import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.data.model.User;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.request.SearchEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateAccountResponse;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;
import africa.semicolon.BookEase.exception.InvalidMailFormatException;
import africa.semicolon.BookEase.exception.InvalidPasswordFormatException;
import africa.semicolon.BookEase.utils.BookEaseUserMapper;
import africa.semicolon.BookEase.utils.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.BookEase.exception.UserAlreadyExistException;
@Service
public class BookEaseUserService implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    EventService eventService;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        CreateAccountResponse response = new CreateAccountResponse();
        if(userExist(request.getEmail())) throw new UserAlreadyExistException(
                request.getEmail()+" already exist"
        );
        verifyEmail(request);
        verifyPassword(request);
        User user = BookEaseUserMapper.map(request);
        userRepository.save(user);
        response.setMessage("Account Created");
        return response;
    }

    private static void verifyPassword(CreateAccountRequest request) {
        if(!(Verification.verifyPassword(request.getPassword()))) throw new InvalidPasswordFormatException(
                "Invalid Password Format"
        );
    }

    private static void verifyEmail(CreateAccountRequest request) {
        if (!(Verification.verifyEmail(request.getEmail()))) throw new InvalidMailFormatException(
                "Invalid Email Format"
        );
    }

    @Override
    public CreateEventResponse createEvent(CreateEventRequest request) {
        User user = userRepository.findByEmail(request.getUserEmail());
        return eventService.createEvent(request);
    }

    @Override
    public SearchEventResponse searchEvent(SearchEventRequest searchEventRequest) {
        return eventService.searchEvent(searchEventRequest);
    }

    @Override
    public ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest) {
        return eventService.reserveTicket(reserveTicketRequest);
    }

    private boolean userExist(String email) {
        User user =  userRepository.findByEmail(email);
        return user != null;
    }
}

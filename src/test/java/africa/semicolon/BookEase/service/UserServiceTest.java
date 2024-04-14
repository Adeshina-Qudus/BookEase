package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.repositories.UserRepository;
import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.request.SearchEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateAccountResponse;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;
import africa.semicolon.BookEase.exception.InvalidMailFormatException;
import africa.semicolon.BookEase.exception.InvalidPasswordFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void deleteAll(){
        userRepository.deleteAll();
    }

    @Test
    public void userCreatingAccountTest(){
        CreateAccountRequest request = new CreateAccountRequest();

        request.setName("Femi");
        request.setEmail("djfemz22@gmail.com");
        request.setPassword("Femzy12@");

        CreateAccountResponse response =  userService.createAccount(request);

        assertEquals("Account Created",response.getMessage());
    }

    @Test
    public void userCreateAccountWithInvalidEmailFormat(){

        CreateAccountRequest request = new CreateAccountRequest();

        request.setName("Femi");
        request.setEmail("djfemz22@gmail.");
        request.setPassword("Femzy12@");

         assertThrows(InvalidMailFormatException.class,()->userService.createAccount(request));
    }

    @Test
    public void userCreateAccountWithInvalidPasswordFormat(){

        CreateAccountRequest request = new CreateAccountRequest();

        request.setName("Femi");
        request.setEmail("djfemz22@gmail.com");
        request.setPassword("Femzy12");

        assertThrows(InvalidPasswordFormatException.class,()->userService.createAccount(request));
    }

    @Test
    public void userCreateEventTest(){

        CreateAccountRequest accountRequest = new CreateAccountRequest();
        accountRequest.setName("Femi");
        accountRequest.setEmail("djfemz22@gmail.com");
        accountRequest.setPassword("Femzy12@");
        userService.createAccount(accountRequest);
        CreateEventRequest request = new CreateEventRequest();
        request.setEventName("Mr Money With The Vibe Concert");

        String dateInput = "01/13/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateInput,formatter);
        request.setDate(date);

        request.setAvailableAttendees(20);
        request.setEventDescription("description");
        request.setCategory("concert");
        request.setUserEmail("djfemz22@gmail.com");

        CreateEventResponse response = userService.createEvent(request);

        assertThat(response).isNotNull();

    }

    @Test
    public void searchEventTest(){
        CreateAccountRequest accountRequest = new CreateAccountRequest();
        accountRequest.setName("Femi");
        accountRequest.setEmail("djfemz22@gmail.com");
        accountRequest.setPassword("Femzy12@");
        userService.createAccount(accountRequest);

        CreateEventRequest request = new CreateEventRequest();
        request.setEventName("Mr Money With The Vibe Concert");

        String dateInput = "01/13/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateInput,formatter);
        request.setDate(date);

        request.setAvailableAttendees(20);
        request.setEventDescription("description");
        request.setCategory("concert");
        request.setUserEmail("djfemz22@gmail.com");

        userService.createEvent(request);

        SearchEventRequest searchEventRequest = new SearchEventRequest();
        searchEventRequest.setEventName("Mr Money With The Vibe Concert");
        searchEventRequest.setUserEmail("djfemz22@gmail.com");
        SearchEventResponse response = userService.searchEvent(searchEventRequest);
        System.out.println(response);
        assertThat(response).isNotNull();
    }

    @Test
    public void userReserveTicketTest(){

        CreateAccountRequest accountRequest = new CreateAccountRequest();
        accountRequest.setName("Femi");
        accountRequest.setEmail("djfemz22@gmail.com");
        accountRequest.setPassword("Femzy12@");
        userService.createAccount(accountRequest);

        CreateEventRequest request = new CreateEventRequest();
        request.setEventName("Mr Money With The Vibe Concert");

        String dateInput = "01/13/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateInput,formatter);
        request.setDate(date);

        request.setAvailableAttendees(20);
        request.setEventDescription("description");
        request.setCategory("concert");
        request.setUserEmail("djfemz22@gmail.com");

        userService.createEvent(request);

        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setNumberOfReservedTicked(3);
        reserveTicketRequest.setEventName("Mr Money With The Vibe Concert");
        reserveTicketRequest.setAttendeesEmail("djfemz22@gmail.com");

        ReserveTicketResponse ticketResponse = userService.reserveTicket(reserveTicketRequest);

    }
}

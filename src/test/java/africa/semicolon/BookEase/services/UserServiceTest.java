package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.repositories.TicketRepository;
import africa.semicolon.BookEase.data.repositories.UserRepository;
import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.*;
import africa.semicolon.BookEase.exceptions.InvalidMailFormatException;
import africa.semicolon.BookEase.exceptions.InvalidPasswordFormatException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @AfterEach
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

        request.setAvailableAttendees(0);
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
        SearchEventRequest searchEventRequest = new SearchEventRequest();
        searchEventRequest.setEventName("Mr Money With The Vibe Concert");
//        searchEventRequest.setUserEmail("djfemz22@gmail.com");
        SearchEventResponse response = userService.searchEvent(searchEventRequest);
        System.out.println(response);
        assertThat(response).isNotNull();
    }

    @Test
    public void userReserveTicketTest(){

        CreateAccountRequest accountRequest = new CreateAccountRequest();
        accountRequest.setName("Femi");
        accountRequest.setEmail("djfem5z123422@gmail.com");
        accountRequest.setPassword("Femzy12@");
        userService.createAccount(accountRequest);

        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setNumberOfReservedTicket(3);
        reserveTicketRequest.setEventName("Mr Money With The Vibe Concert");
        reserveTicketRequest.setAttendeesEmail("djfemz22@gmail.com");

        ReserveTicketResponse ticketResponse = userService.reserveTicket(reserveTicketRequest);

        System.out.println(ticketResponse);

        assertThat(ticketResponse).isNotNull();
    }

    @Test
    public void viewBookedEventTest(){

        CreateAccountRequest accountRequest = new CreateAccountRequest();
        accountRequest.setName("Femi");
        accountRequest.setEmail("djfem154z1123422@gmail.com");
        accountRequest.setPassword("Femzy12@");
        userService.createAccount(accountRequest);

        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setNumberOfReservedTicket(3);
        reserveTicketRequest.setEventName("Mr Money With The Vibe Concert");
        reserveTicketRequest.setAttendeesEmail("djfemz22@gmail.com");
        userService.reserveTicket(reserveTicketRequest);

        ViewBookedEventRequest viewBookedEventRequest = new ViewBookedEventRequest();

        viewBookedEventRequest.setUserEmail("djfemz22@gmail.com");

       List<ViewBookedEventResponse> response =
                userService.viewBookedEvent(viewBookedEventRequest);

        System.out.println(response.toString());

        assertThat(response).isNotNull();
    }



    @Test
    public void cancelReservationTest(){
        CreateAccountRequest accountRequest = new CreateAccountRequest();
        accountRequest.setName("Femi");
        accountRequest.setEmail("qudusa55@gmail.com");
        accountRequest.setPassword("Femzy12@");
        userService.createAccount(accountRequest);
        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setNumberOfReservedTicket(3);
        reserveTicketRequest.setEventName("Mr Money With The Vibe Concert");
        reserveTicketRequest.setAttendeesEmail("djfemz22@gmail.com");
        userService.reserveTicket(reserveTicketRequest);

        CancelReservationRequest cancelReservationRequest = new CancelReservationRequest();
        cancelReservationRequest.setNumberOfReservedTicket(2);
        cancelReservationRequest.setEventName("Mr Money With The Vibe Concert");
        cancelReservationRequest.setAttendeesEmail("djfemz22@gmail.com");

        CancelReservationResponse response =
                userService.cancelReservation(cancelReservationRequest);
        assertThat(response).isNotNull();

    }
}

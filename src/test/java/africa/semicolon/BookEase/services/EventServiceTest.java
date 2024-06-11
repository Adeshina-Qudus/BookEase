package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.repositories.EventRepository;
import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;
import africa.semicolon.BookEase.dtos.response.ViewBookedEventResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventServiceTest {

//    @Autowired
//    private EventService eventService;
//    @Autowired
//    private EventRepository repository;
//
//    @Each
//    public void deleteAll() {
//        repository.deleteAll();
//    }
//
//    @Test
//    public void userCreateEventTest(){
//        CreateEventRequest request = new CreateEventRequest();
//        request.setEventName("Mr Money With The Vibe Concert494");
//        String dateInput = "01/13/2024";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDate date = LocalDate.parse(dateInput,formatter);
//        request.setDate(String.valueOf(date));
//        request.setAvailableAttendees(0);
//        request.setEventDescription("description");
//        request.setCategory("concert");
//        request.setUserEmail("djfemz22@gmail.com");
//        CreateEventResponse response = eventService.createEvent(request);
//        assertThat(response).isNotNull();
//
//    }
//
//    @Test
//    public void searchEventTest(){
//        CreateEventRequest request = new CreateEventRequest();
//        request.setEventName("Mr Money With The Vibe Concert4400");
//        String dateInput = "01/13/2024";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDate date = LocalDate.parse(dateInput,formatter);
//        request.setDate(String.valueOf(date));
//        request.setAvailableAttendees(0);
//        request.setEventDescription("description");
//        request.setCategory("concert");
//        request.setUserEmail("qudusa55@gmail.com");
//        CreateEventResponse response = eventService.createEvent(request);
//        SearchEventRequest searchEventRequest = new SearchEventRequest();
//        searchEventRequest.setEventName("Mr Money With The Vibe Concert4400");
//        SearchEventResponse searchEventResponse = eventService.searchEvent(searchEventRequest);
//        assertThat(response).isNotNull();
//    }


}

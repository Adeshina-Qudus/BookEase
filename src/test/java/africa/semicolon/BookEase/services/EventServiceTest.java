package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;
import africa.semicolon.BookEase.dtos.response.ViewBookedEventResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Test
    public void userCreateEventTest(){
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
        CreateEventResponse response = eventService.createEvent(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void searchEventTest(){
        SearchEventRequest searchEventRequest = new SearchEventRequest();
        searchEventRequest.setEventName("Mr Money With The Vibe Concert");
        SearchEventResponse response = eventService.searchEvent(searchEventRequest);
        assertThat(response).isNotNull();
    }


}

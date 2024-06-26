package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CreateEventRequest {
    private String eventName;
    private String date;
    private Integer availableAttendees;
    private String eventDescription;
    private String category;
    private String userEmail;
}

package africa.semicolon.BookEase.dtos.request;

import africa.semicolon.BookEase.data.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CreateEventRequest {
    private String name;
    private LocalDate date;
    private int availableAttendees;
    private String description;
    private String category;
    private String userEmail;
}

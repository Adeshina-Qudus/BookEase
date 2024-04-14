package africa.semicolon.BookEase.dtos.response;

import africa.semicolon.BookEase.data.model.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class SearchEventResponse {
    private String eventName;
    private LocalDate date;
    private int availableAttendees;
    private String eventDescription;
    private Category category;
}

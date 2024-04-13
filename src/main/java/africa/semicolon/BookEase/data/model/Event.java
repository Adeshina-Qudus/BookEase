package africa.semicolon.BookEase.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String eventName;
    private LocalDate date;
    private int availableAttendees;
    private String eventDescription;
    private Category category;
}

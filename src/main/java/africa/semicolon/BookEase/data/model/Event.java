package africa.semicolon.BookEase.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

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
    @Column(name ="availableAttendees")
    private Integer availableAttendees;
    private String eventDescription;
    private Category category;
//    @OneToMany(cascade = {CascadeType.MERGE})
    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Ticket> tickets;
}

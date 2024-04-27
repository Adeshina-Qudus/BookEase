package africa.semicolon.BookEase.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String eventName;
    private Integer ticketId;
    private String email;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}

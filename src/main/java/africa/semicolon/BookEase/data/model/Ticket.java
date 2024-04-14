package africa.semicolon.BookEase.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String eventName;
    private int numberOfReservedTicket;
}

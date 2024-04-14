package africa.semicolon.BookEase.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReserveTicketRequest {

    private int numberOfReservedTicked;
    private String   eventName;
    private String attendeesEmail;
}

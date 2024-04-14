package africa.semicolon.BookEase.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReserveTicketResponse {

    private String eventName;
    private String numberOfReservedTicked;
}

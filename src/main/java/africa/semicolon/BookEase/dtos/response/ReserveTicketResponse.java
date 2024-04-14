package africa.semicolon.BookEase.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReserveTicketResponse {

    private String eventName;
    private Integer numberOfReservedTicked;
}

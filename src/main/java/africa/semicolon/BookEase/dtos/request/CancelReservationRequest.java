package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CancelReservationRequest {

    private Integer numberOfReservedTicket;
    private String   eventName;
    private String attendeesEmail;
}

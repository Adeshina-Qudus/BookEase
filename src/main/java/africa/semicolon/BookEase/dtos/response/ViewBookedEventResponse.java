package africa.semicolon.BookEase.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ViewBookedEventResponse {

    private String eventName;
    private String eventDescription;
}

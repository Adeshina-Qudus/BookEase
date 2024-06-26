package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class NotificationSenderRequest {
    private String name;
    private String email;
    private String eventName;
    private String date;
    private List<ReceiverRequest> to;
}

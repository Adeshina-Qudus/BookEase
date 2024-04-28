package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationSenderRequest {
    private String name;
    private String email;
}

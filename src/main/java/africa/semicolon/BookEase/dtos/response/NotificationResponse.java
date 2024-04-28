package africa.semicolon.BookEase.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationResponse {
    private String subject;
    private String htmlContent;
}

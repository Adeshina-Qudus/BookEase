package africa.semicolon.BookEase.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NotificationResponse {
    private String subject;
    private String htmlContent;
}

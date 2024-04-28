package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataSender {
    private NotificationSenderRequest sender;
    private ReceiverRequest to;
}

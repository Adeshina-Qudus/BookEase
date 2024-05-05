package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DataSender {
    private NotificationSenderRequest sender;
    private List<ReceiverRequest> to = new ArrayList<>();
    private String subject;
    private String htmlContent;
}

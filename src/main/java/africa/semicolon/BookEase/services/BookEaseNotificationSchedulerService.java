package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.dtos.request.NotificationSenderRequest;
import africa.semicolon.BookEase.dtos.request.ReceiverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookEaseNotificationSchedulerService {

    @Autowired
    private EventService eventService;
    @Autowired
    private NotificationSender notificationSender;
    @Scheduled(fixedRate = 2 * 60 * 1000)
    public void send() {
        List<Event> event = eventService.getAllEvent();
        event.stream().parallel().forEach(eachEvent -> {
            NotificationSenderRequest senderRequest = new NotificationSenderRequest();
            senderRequest.setDate(String.valueOf(eachEvent.getDate()));
            senderRequest.setName(eachEvent.getEventName());
            senderRequest.setEmail("qudusa55@gmail.com");
            List<ReceiverRequest> receivers = new ArrayList<>();
            eachEvent.getTickets().stream().parallel().forEach(eachTicket ->{
                ReceiverRequest request =  new ReceiverRequest();
                request.setName(eachTicket.getEmail());
                request.setEmail(eachTicket.getEmail());
                receivers.add(request);
            });
            senderRequest.setTo(receivers);
            notificationSender.sendNotification(senderRequest);
        });
    }
}

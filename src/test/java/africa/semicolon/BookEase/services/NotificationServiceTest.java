package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.data.repositories.UserRepository;
import africa.semicolon.BookEase.dtos.request.NotificationSenderRequest;
import africa.semicolon.BookEase.dtos.request.ReceiverRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.response.NotificationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationSender notificationSender;

    @Test
    public void sendReminderNotificationTest(){
        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setNumberOfReservedTicket(3);
        reserveTicketRequest.setEventName("Mr Money With The Vibe Concert");
        reserveTicketRequest.setAttendeesEmail("qudusa55@gmIL.com");
        userService.reserveTicket(reserveTicketRequest);

        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setName("Bllizz");
        senderRequest.setEmail("alimotadeshina03@gmail.com");

        List<ReceiverRequest> receiverRequestList = new ArrayList<>();

        ReceiverRequest request = new ReceiverRequest();
        request.setName(reserveTicketRequest.getAttendeesEmail());
        request.setEmail(reserveTicketRequest.getAttendeesEmail());

        receiverRequestList.add(request);

        senderRequest.setTo(receiverRequestList);

        NotificationResponse response = notificationSender.sendNotification(senderRequest);
        System.out.println(response.toString());
        assertThat(response).isNotNull();
    }
}

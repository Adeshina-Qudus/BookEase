package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.dtos.request.DataSender;
import africa.semicolon.BookEase.dtos.request.NotificationSenderRequest;
import africa.semicolon.BookEase.dtos.response.NotificationResponse;
import africa.semicolon.BookEase.utils.NotificationContent;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ejb.Schedule;

import static africa.semicolon.BookEase.utils.NotificationContent.htmlContent;

@Service
public class BookEaseNotificationSender implements NotificationSender {
    @Value("${brevo.base.url}")
    private String url;
    @Value("${brevo.api.key}")
    private String apiKey;


    @Override
//    @Schedule(second="0", minute="0", hour="8", dayOfWeek="Mon-Fri", persistent=false)
    public NotificationResponse sendNotification(NotificationSenderRequest senderRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("api-key", apiKey);
        DataSender dataSender = new DataSender();
        dataSender.setSender(senderRequest);
        dataSender.setTo(senderRequest.getTo());
        dataSender.setSubject("Reminder");
        dataSender.setHtmlContent(htmlContent(senderRequest.getEventName(),senderRequest.getName(),
                senderRequest.getDate()));
        HttpEntity<?> httpEntity = new HttpEntity<>(dataSender, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NotificationResponse> response = restTemplate.postForEntity(url, httpEntity,
                NotificationResponse.class);
        return response.getBody();
    }
}

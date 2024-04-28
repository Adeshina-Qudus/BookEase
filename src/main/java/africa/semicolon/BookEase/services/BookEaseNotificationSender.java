package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.dtos.request.DataSender;
import africa.semicolon.BookEase.dtos.request.NotificationSenderRequest;
import africa.semicolon.BookEase.dtos.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

public class BookEaseNotificationSender implements NotificationSender {
    @Value("${brevo.url}")
    private String url;
    @Value("${brevo.api.key}")
    private String apiKey;


    @Override
    public NotificationResponse sendNotification(NotificationSenderRequest senderRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("accept", "application/json");
        httpHeaders.set("api-key", apiKey);
        httpHeaders.set("content-type", "application/json");

        DataSender dataSender = new DataSender();



        return null;
    }
}

package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.dtos.request.NotificationSenderRequest;
import africa.semicolon.BookEase.dtos.response.NotificationResponse;

public interface NotificationSender {

    NotificationResponse sendNotification(NotificationSenderRequest senderRequest);
}

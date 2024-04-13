package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest request);
}

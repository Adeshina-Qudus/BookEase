package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.config.ModelMapperConfig;
import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.repositories.EventRepository;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
public class BookEaseEventService implements EventService{

    @Autowired
    EventRepository eventRepository;
    @Override
    public CreateEventResponse createEvent(CreateEventRequest request) {
        CreateEventResponse response = new CreateEventResponse();
         Event event = ModelMapperConfig.modelMapper().map(request,Event.class);
         eventRepository.save(event);
         response.setMessage("The "+event.getName()+" Created");
         return response;
    }
}

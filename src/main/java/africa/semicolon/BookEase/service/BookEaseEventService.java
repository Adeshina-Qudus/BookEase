package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.config.ModelMapperConfig;
import africa.semicolon.BookEase.data.model.Category;
import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.data.repositories.EventRepository;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.request.SearchEventRequest;
import africa.semicolon.BookEase.dtos.request.ViewBookedEventRequest;
import africa.semicolon.BookEase.dtos.response.CreateEventResponse;
import africa.semicolon.BookEase.dtos.response.ReserveTicketResponse;
import africa.semicolon.BookEase.dtos.response.SearchEventResponse;
import africa.semicolon.BookEase.dtos.response.ViewBookedEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class BookEaseEventService implements EventService{

    @Autowired
    EventRepository eventRepository;
    @Autowired
    TicketService ticketService;
    @Override
    public CreateEventResponse createEvent(CreateEventRequest request) {
        CreateEventResponse response = new CreateEventResponse();
         Event event = ModelMapperConfig.modelMapper().map(request,Event.class);
         event.setAvailableAttendees(0);
         for (Category category : Category.values()) {
             if (request.getCategory().toUpperCase().equals(category.name())) {
                 event.setCategory(category);
             }
         }
         eventRepository.save(event);
         response.setMessage("The "+event.getEventName()+" Created");
         return response;
    }

    @Override
    public SearchEventResponse searchEvent(SearchEventRequest searchEventRequest) {
        SearchEventResponse searchEventResponse = new SearchEventResponse();

        for (Event event : eventRepository.findAll()){
            if (event.getEventName().equals(searchEventRequest.getEventName())){
                searchEventResponse = ModelMapperConfig.modelMapper().map(event,SearchEventResponse.class);
            }
        }
        return searchEventResponse;
    }

    @Override
    public ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest) {
        ReserveTicketResponse response ;
        Event event = eventRepository.findByEventName(reserveTicketRequest.getEventName());
        event =  ticketService.reserveTicket(event,reserveTicketRequest.
                getNumberOfReservedTicket(),reserveTicketRequest.getAttendeesEmail());
        eventRepository.save(event);
        response = ModelMapperConfig.modelMapper().map(event,ReserveTicketResponse.class);
        response.setNumberOfReservedTicked(response.getNumberOfReservedTicked());
        return response;
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public List<ViewBookedEventResponse> viewBookedEvent(ViewBookedEventRequest viewBookedEventRequest) {
        List<ViewBookedEventResponse> bookedEventResponses = new ArrayList<>();
        List<Ticket> tickets = ticketService.findByEmail(viewBookedEventRequest.getUserEmail());
        return mappingEachEvent(bookedEventResponses,tickets);
    }

    private List<ViewBookedEventResponse> mappingEachEvent(List<ViewBookedEventResponse> bookedEventResponses,
                                                           List<Ticket> tickets) {
        ViewBookedEventResponse viewBookedEventResponse = new ViewBookedEventResponse();
        for (Ticket ticket : tickets){
            Event event = eventRepository.findByEventName(ticket.getEventName());
            viewBookedEventResponse.setEventName(event.getEventName());
            viewBookedEventResponse.setEventDescription(event.getEventDescription());
            bookedEventResponses.add(viewBookedEventResponse);
        }
        return bookedEventResponses;
    }
}

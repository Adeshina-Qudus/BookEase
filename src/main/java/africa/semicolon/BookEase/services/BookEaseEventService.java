package africa.semicolon.BookEase.services;

import africa.semicolon.BookEase.config.ModelMapperConfig;
import africa.semicolon.BookEase.data.model.Category;
import africa.semicolon.BookEase.data.model.Event;
import africa.semicolon.BookEase.data.model.Ticket;
import africa.semicolon.BookEase.data.repositories.EventRepository;
import africa.semicolon.BookEase.dtos.request.*;
import africa.semicolon.BookEase.dtos.response.*;
import africa.semicolon.BookEase.exceptions.*;
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
        if (eventExist(request.getEventName())) throw new EventAlreadyExistException(request.getEventName()+
                " already exist");
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

    private boolean eventExist(String eventName) {
        Event event = eventRepository.findByEventName(eventName);
        return event != null;
    }

    @Override
    public SearchEventResponse searchEvent(SearchEventRequest searchEventRequest) {
        if (!eventExist(searchEventRequest.getEventName())) throw new EventDoesntExistException(
                searchEventRequest.getEventName()+" doesnt exist ");
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
        if (!eventExist(reserveTicketRequest.getEventName())) throw new EventDoesntExistException(
                reserveTicketRequest.getEventName()+" doesnt exist ");
        ReserveTicketResponse response ;
        Event event = eventRepository.findByEventName(reserveTicketRequest.getEventName());
        event =  ticketService.reserveTicket(event,reserveTicketRequest);
        eventRepository.save(event);
        response = ModelMapperConfig.modelMapper().map(event,ReserveTicketResponse.class);
        response.setNumberOfReservedTicked(reserveTicketRequest.getNumberOfReservedTicket());
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

    @Override
    public CancelReservationResponse cancelReservation(CancelReservationRequest cancelReservationRequest) {
        if (!eventExist(cancelReservationRequest.getEventName())) throw new EventDoesntExistException(
                cancelReservationRequest.getEventName()+" doesnt exist ");
        CancelReservationResponse response = new CancelReservationResponse();
        Event event = eventRepository.findByEventName(cancelReservationRequest.getEventName());
        event = ticketService.cancelReservedTicket(event,cancelReservationRequest);
        eventRepository.save(event);
        response.setMessage("Canceled");
        return response;
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

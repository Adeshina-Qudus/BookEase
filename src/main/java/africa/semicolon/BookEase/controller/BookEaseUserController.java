package africa.semicolon.BookEase.controller;

import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.dtos.request.CreateEventRequest;
import africa.semicolon.BookEase.dtos.request.ReserveTicketRequest;
import africa.semicolon.BookEase.dtos.request.SearchEventRequest;
import africa.semicolon.BookEase.dtos.response.*;
import africa.semicolon.BookEase.exception.BookEaseException;
import africa.semicolon.BookEase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class BookEaseUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request){
        CreateAccountResponse response = new CreateAccountResponse();
        try {
            response.setMessage(userService.createAccount(request).getMessage());
            return new ResponseEntity<>(new ApiResponse(true,response), HttpStatus.CREATED);
        }catch (BookEaseException exception){
            response.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false,response),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/createEvent")
    public ResponseEntity<?> createEvent(@RequestBody CreateEventRequest request){
        CreateEventResponse response = new CreateEventResponse();
        try{
            response.setMessage(userService.createEvent(request).getMessage());
            return new ResponseEntity<>(new ApiResponse(true,response),HttpStatus.CREATED);
        }catch (BookEaseException exception){
            response.setMessage(exception.getMessage());
            return new ResponseEntity<>(new ApiResponse(false,response),HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PostMapping("/searchEvent")
    public ResponseEntity<?> searchEvent(@RequestBody SearchEventRequest request){
        try{
            return new ResponseEntity<>(new ApiResponse(true,userService.searchEvent(request)
            ),HttpStatus.FOUND);
        }catch (BookEaseException exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reserveTicket")
    public ResponseEntity<?> reserveTicket(@RequestBody ReserveTicketRequest request){
        try {
            return new ResponseEntity<>(new ApiResponse(true,userService.reserveTicket(request)
            ),HttpStatus.OK);
        }catch (BookEaseException exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),HttpStatus.NOT_IMPLEMENTED);
        }
    }


}

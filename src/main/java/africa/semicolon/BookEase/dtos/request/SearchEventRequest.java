package africa.semicolon.BookEase.dtos.request;

import africa.semicolon.BookEase.data.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Setter
@Getter
public class SearchEventRequest {

    private String eventName;
//    private String userEmail;
}

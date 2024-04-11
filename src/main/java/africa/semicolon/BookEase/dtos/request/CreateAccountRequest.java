package africa.semicolon.BookEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAccountRequest {
    private String name;
    private String email;
    private String password;
}

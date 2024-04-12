package africa.semicolon.BookEase.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}

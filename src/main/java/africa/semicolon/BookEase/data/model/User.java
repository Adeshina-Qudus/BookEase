package africa.semicolon.BookEase.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Size(min = 3,message = "cannot be less than 3")
    @Size(max = 100 , message = "limited to 100 characters")
    private String name;
    private String email;
    private String password;
}

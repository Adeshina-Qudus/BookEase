package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.data.repositories.UserRepository;
import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import africa.semicolon.BookEase.dtos.response.CreateAccountResponse;
import africa.semicolon.BookEase.exception.InvalidMailFormatException;
import africa.semicolon.BookEase.exception.InvalidPasswordFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void deleteAll(){
        userRepository.deleteAll();
    }

    @Test
    public void userCreatingAccountTest(){
        CreateAccountRequest request = new CreateAccountRequest();

        request.setName("Femi");
        request.setEmail("djfemz22@gmail.com");
        request.setPassword("Femzy12@");

        CreateAccountResponse response =  userService.createAccount(request);

        assertEquals("Account Created",response.getMessage());
    }

    @Test
    public void userCreateAccountWithInvalidEmailFormat(){

        CreateAccountRequest request = new CreateAccountRequest();

        request.setName("Femi");
        request.setEmail("djfemz22@gmail.");
        request.setPassword("Femzy12@");

         assertThrows(InvalidMailFormatException.class,()->userService.createAccount(request));
    }

    @Test
    public void userCreateAccountWithInvalidPasswordFormat(){

        CreateAccountRequest request = new CreateAccountRequest();

        request.setName("Femi");
        request.setEmail("djfemz22@gmail.");
        request.setPassword("Femzy12");

        assertThrows(InvalidPasswordFormatException.class,()->userService.createAccount(request));
    }
}

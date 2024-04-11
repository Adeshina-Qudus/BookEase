package africa.semicolon.BookEase.service;

import africa.semicolon.BookEase.dtos.request.CreateAccountRequest;
import org.junit.jupiter.api.Test;

public class UserServiceTest {



    @Test
    public void userCreatingAccountTest(){

        CreateAccountRequest request = new CreateAccountRequest();
        request.setName("Femi");
        request.setEmail("djfemz22@gmail.com");
        request.setPassword("Femzy12345");

    }
}

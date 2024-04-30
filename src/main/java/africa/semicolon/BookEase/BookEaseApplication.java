package africa.semicolon.BookEase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookEaseApplication.class, args);
	}

}

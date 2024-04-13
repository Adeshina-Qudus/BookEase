package africa.semicolon.BookEase.data.repositories;

import africa.semicolon.BookEase.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

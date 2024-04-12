package africa.semicolon.BookEase.repository;

import africa.semicolon.BookEase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

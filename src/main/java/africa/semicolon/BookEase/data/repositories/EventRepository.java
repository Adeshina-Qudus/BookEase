package africa.semicolon.BookEase.data.repositories;

import africa.semicolon.BookEase.data.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}

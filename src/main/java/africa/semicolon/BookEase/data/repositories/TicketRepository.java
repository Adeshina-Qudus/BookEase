package africa.semicolon.BookEase.data.repositories;

import africa.semicolon.BookEase.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long>{
}

package africa.semicolon.BookEase.data.repositories;

import africa.semicolon.BookEase.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long>{
//    List<Ticket> findAllTicketThatBelongsTo(String userEmail);

    List<Ticket> findByEmail(String userEmail);
}

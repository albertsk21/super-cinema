package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.SuperCinema.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query("FROM Ticket AS t WHERE t.id = ?1")
    Ticket findTicketById(Long id);

    @Query("FROM Ticket")
    Ticket[] findAllTickets();

    @Query("FROM Ticket AS t WHERE t.category = ?1")
    Ticket findTicketByCategory(String category);

}

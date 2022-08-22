package project.SuperCinema.services.interfaces;

import project.SuperCinema.dtos.TicketDtoJson;
import project.SuperCinema.entities.Ticket;

import java.io.IOException;

public interface TicketService {

    void saveTicket(Ticket ticket);
    TicketDtoJson findTicketById(Long id);
    TicketDtoJson[] findAll();
    TicketDtoJson createTicket(TicketDtoJson ticketJson);
    TicketDtoJson deleteById(Long id);
    TicketDtoJson editTicket(Long id,TicketDtoJson ticketJson);
    void importTicketsToDatabase() throws IOException;
    String readFile() throws IOException;
    boolean isTicketsEmpty();
}

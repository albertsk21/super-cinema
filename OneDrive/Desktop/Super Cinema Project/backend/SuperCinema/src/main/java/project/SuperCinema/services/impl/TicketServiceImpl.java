package project.SuperCinema.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.constraints.GlobalConstraints;
import project.SuperCinema.dtos.TicketDtoJson;
import project.SuperCinema.entities.Ticket;
import project.SuperCinema.repositories.TicketRepository;
import project.SuperCinema.services.interfaces.TicketService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {


    private TicketRepository ticketRepository;
    private ModelMapper modelMapper;
    private Gson gson;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper, Gson gson) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void saveTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public TicketDtoJson findTicketById(Long id) {
       return this.modelMapper.map(this.ticketRepository.findTicketById(id),TicketDtoJson.class);
    }

    @Override
    public TicketDtoJson[] findAll(){
        Ticket[] tickets = this.ticketRepository.findAllTickets();
        return this.modelMapper.map(tickets,TicketDtoJson[].class);
    }

    @Override
    public TicketDtoJson createTicket(TicketDtoJson ticketJson) {
        Ticket ticket = this.modelMapper.map(ticketJson,Ticket.class);
        Ticket created = this.ticketRepository.save(ticket);
        return this.modelMapper.map(created,TicketDtoJson.class);
    }

    @Override
    public TicketDtoJson deleteById(Long id){
        Ticket ticket = this.ticketRepository.findTicketById(id);
        TicketDtoJson ticketJson = this.modelMapper.map(ticket,TicketDtoJson.class);
        this.ticketRepository.deleteById(id);
        return ticketJson;
    }

    @Override
    public TicketDtoJson editTicket(Long id, TicketDtoJson ticketJson) {
        ticketJson.setId(id);
        Ticket ticket = this.modelMapper.map(ticketJson,Ticket.class);
        Ticket saveTicket =  this.ticketRepository.save(ticket);
        return this.modelMapper.map(saveTicket,TicketDtoJson.class);
    }

    @Override
    public void importTicketsToDatabase() throws IOException {
        TicketDtoJson[] ticketsJson = this.gson.fromJson(this.readFile(), TicketDtoJson[].class);
        for (TicketDtoJson ticketJson : ticketsJson) {
            this.createTicket(ticketJson);
        }
    }
    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.TICKETS_FILE_JSON_PATH));
    }

    @Override
    public boolean isTicketsEmpty() {
        return this.ticketRepository.count() == 0;
    }
}

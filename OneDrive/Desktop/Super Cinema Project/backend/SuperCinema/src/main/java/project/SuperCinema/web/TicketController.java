package project.SuperCinema.web;


import org.springframework.web.bind.annotation.*;
import project.SuperCinema.dtos.TicketDtoJson;
import project.SuperCinema.services.interfaces.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {


    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("")
    public TicketDtoJson[] getAll(){
        return this.ticketService.findAll();
    }


    @PostMapping("")
    public TicketDtoJson createTicket(@RequestBody TicketDtoJson ticketJson){
        return this.ticketService.createTicket(ticketJson);
    }
    @GetMapping("/{id}")
    public TicketDtoJson createTicket(@PathVariable("id") Long id){
        return this.ticketService.findTicketById(id);
    }
    @DeleteMapping("/{id}")
    public TicketDtoJson deleteTicketById(@PathVariable("id") Long id){
        return this.ticketService.deleteById(id);
    }


    @PutMapping("/{id}")
    public TicketDtoJson editTicketById(@PathVariable("id") Long id,  @RequestBody TicketDtoJson ticketJson){
        return this.ticketService.editTicket(id,ticketJson);
    }
}

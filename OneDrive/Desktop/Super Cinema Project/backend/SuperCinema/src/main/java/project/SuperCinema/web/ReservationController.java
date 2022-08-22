package project.SuperCinema.web;
import org.springframework.web.bind.annotation.*;
import project.SuperCinema.dtos.ReservationDtoJson;
import project.SuperCinema.dtos.create.ReservationCreate;
import project.SuperCinema.services.interfaces.ReservationService;

import java.text.ParseException;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("")
    public ReservationDtoJson[] getAllReservations() throws ParseException {
        return this.reservationService.getAllReservations();
    }

  @GetMapping("/{id}")
    public ReservationDtoJson getReservationById(@PathVariable("id") Long id){
        return this.reservationService.exportReservationById(id);
    }



    @GetMapping(value = "/create")
    public ReservationDtoJson createReservation(@RequestParam(value = "date" , defaultValue = "")String date,
                                                @RequestParam(value = "hall" , defaultValue = "")String hall,
                                                @RequestParam(value = "seatNumber" , defaultValue = "")String seatNumber,
                                                @RequestParam(value = "firstName" , defaultValue = "")String  firstName,
                                                @RequestParam(value = "lastName" , defaultValue = "")String  lastName,
                                                @RequestParam(value = "customerEmail" , defaultValue = "")String  customerEmail,
                                                @RequestParam(value = "phoneNumber" , defaultValue = "")String  phoneNumber,
                                                @RequestParam(value = "hour" , defaultValue = "") String  hour,
                                                @RequestParam(value = "availabilityId" , defaultValue = "") Long availabilityId,
                                                @RequestParam(value = "ticket" , defaultValue = "")String  ticket) throws ParseException {


        ReservationCreate reservation = new ReservationCreate();
        reservation.setDate(date);
        reservation.setHall(Integer.parseInt(hall));
        reservation.setSeatNumber(Integer.parseInt(seatNumber));
        reservation.setFirstName(firstName);
        reservation.setLastName(lastName);
        reservation.setCustomerEmail(customerEmail);
        reservation.setPhoneNumber(phoneNumber);
        reservation.setHour(hour);
        reservation.setTicket(ticket);
        reservation.setAvailabilityId(availabilityId);
        return this.reservationService.createReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable("id") Long id){
        this.reservationService.deleteReservationById(id);
    }


    @GetMapping("/seats")
    public String[] getSeats(@RequestParam(value = "availabilityId" , defaultValue = "") Long availabilityId){

        return this.reservationService.getSeatsByAvailabilityId(availabilityId);
    }


}

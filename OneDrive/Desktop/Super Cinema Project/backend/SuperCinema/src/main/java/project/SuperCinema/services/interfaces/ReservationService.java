package project.SuperCinema.services.interfaces;


import project.SuperCinema.dtos.ReservationDtoJson;
import project.SuperCinema.dtos.create.ReservationCreate;
import project.SuperCinema.entities.Reservation;

import java.text.ParseException;
import java.util.Date;

public interface ReservationService {

    void saveReservation(Reservation reservation);
    ReservationDtoJson[] getAllReservations() ;
    ReservationDtoJson createReservation(ReservationCreate reservation) throws ParseException;
    void deleteReservationById(Long id);
    String[] getSeatsByAvailabilityId(Long id);
    ReservationDtoJson exportReservationById(Long id);

}

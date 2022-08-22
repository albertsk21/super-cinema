package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.SuperCinema.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {



    @Query("FROM Reservation ")
    Reservation[] findReservations();

    @Query("FROM Reservation AS r WHERE r.id = ?1")
    Reservation findReservationById(Long id);

    @Transactional
    @Modifying
    void deleteReservationById(Long id);


    @Query("SELECT r.seatNumber FROM Reservation AS r " +
           "JOIN r.availability AS a " +
            "WHERE a.id = :id " +
            "ORDER BY r.seatNumber ASC")
    String[] findSeatsByAvailabilityId(Long id);

}

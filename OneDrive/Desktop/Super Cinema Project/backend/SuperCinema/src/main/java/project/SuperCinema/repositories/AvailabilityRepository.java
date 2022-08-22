package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.SuperCinema.entities.Availability;

import java.util.Date;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability,Long> {

    @Query(" FROM Availability ")
    Availability[] getAllAvailabilities();

    @Query("FROM Availability AS a " +
           "JOIN a.cinemaBuilding AS ab " +
           "JOIN ab.city AS c " +
           "WHERE c.name = :city AND a.movie.title = :title " +
           "ORDER BY a.date ASC , a.time ASC")
    Availability[] findAvailabilityByCityAndMovieTitle(String city, String title);

   @Query("FROM Availability AS a " +
           "JOIN a.cinemaBuilding AS ab " +
           "JOIN ab.city AS c " +
           "WHERE c.name = :city AND a.movie.title = :title AND a.date = :date")
   Availability[] findAvailabilityByCityAndMovieTitleAndDate(String city, String title, Date date);



    @Query("SELECT a.time, a.id FROM Availability AS a " +
            "JOIN a.cinemaBuilding AS ab " +
            "JOIN a.movie AS m " +
            "WHERE m.title = :title AND a.date = :date AND ab.name = :cinemaName")
    String[] findHoursByMovieTitleAndDateAndCinema(String title, Date date, String cinemaName );


    @Query("SELECT a.time, a.id FROM Availability AS a " +
            "JOIN a.cinemaBuilding AS ab " +
            "JOIN a.movie AS m " +
            "WHERE m.title = :title AND a.date = :date AND ab.name = :cinemaName")
    Object[] findHoursAndIdByMovieTitleAndDateAndCinema(String title, Date date, String cinemaName );


    @Query("FROM Availability AS a " +
            "JOIN a.cinemaBuilding AS ab " +
            "JOIN ab.city AS c " +
            "WHERE c.name = :city")
    Availability[] findAvailabilityByCity(String city);


    @Query("FROM Availability AS a WHERE a.id = ?1")
    Availability findAvailabilityById(Long id);


    @Query("FROM Availability as a " +
           "WHERE a.cinemaBuilding.name = :name " +
           "ORDER BY a.cinemaBuilding.name ASC , a.movie.title ASC ")
    Availability[] findAvailabilityByCinemaBuildingName(String name);



    @Query("FROM Availability AS a " +
           "WHERE a.cinemaBuilding.name = :cinemaName AND a.movie.title = :movieName " +
           "ORDER BY a.date DESC ")
    Availability[] findAvailabilityByCinemaBuildingNameAndMovie(String cinemaName, String movieName);
}

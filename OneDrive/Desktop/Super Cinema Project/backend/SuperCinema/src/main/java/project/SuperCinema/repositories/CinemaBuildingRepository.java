package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.SuperCinema.entities.CinemaBuilding;

@Repository
public interface CinemaBuildingRepository  extends JpaRepository<CinemaBuilding,Long> {


    @Query("FROM CinemaBuilding AS cb WHERE cb.name = ?1")
    CinemaBuilding findCinemaBuildingByName(String name);

    @Query("FROM CinemaBuilding ")
    CinemaBuilding[] findAllCinemaBuildings();
}

package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.SuperCinema.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    @Query("FROM City AS c WHERE c.name = ?1")
    City findCityByName(String name);

    @Query("FROM City ")
    City[] findAllCities();
}

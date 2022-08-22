package project.SuperCinema.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import project.SuperCinema.entities.City;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
class CityRepositoryTest {


    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void findAllCities() {


        City city = new City();
        city.setName("San Andreas");this.cityRepository.save(city);
    }
}
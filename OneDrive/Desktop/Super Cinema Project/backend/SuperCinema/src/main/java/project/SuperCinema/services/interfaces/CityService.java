package project.SuperCinema.services.interfaces;

import project.SuperCinema.dtos.CityDtoJson;
import project.SuperCinema.entities.City;

import java.io.IOException;

public interface CityService {

    void saveCity(City city);
    City findCityByName(String name);
    void importToDatabase() throws IOException;
    String readFile() throws IOException;
    CityDtoJson[] exportCities();
    boolean isCitiesEmpty();

}

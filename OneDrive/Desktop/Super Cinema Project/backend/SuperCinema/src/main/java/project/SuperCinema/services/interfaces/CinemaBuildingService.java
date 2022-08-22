package project.SuperCinema.services.interfaces;

import project.SuperCinema.dtos.CinemaBuildingDtoJson;
import project.SuperCinema.entities.CinemaBuilding;

import java.io.IOException;

public interface CinemaBuildingService {

    void saveCinema(CinemaBuilding cinemaBuilding);
    CinemaBuilding findCinemaByName(String name);
    CinemaBuildingDtoJson[] getAllCinemas();
    String readFile() throws IOException;
    void importToDatabase() throws IOException;
    boolean isCinemaBuildingsEmpty();

}

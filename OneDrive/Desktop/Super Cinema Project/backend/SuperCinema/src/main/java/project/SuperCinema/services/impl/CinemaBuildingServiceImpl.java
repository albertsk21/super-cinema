package project.SuperCinema.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.constraints.GlobalConstraints;
import project.SuperCinema.dtos.CinemaBuildingDtoJson;
import project.SuperCinema.entities.CinemaBuilding;
import project.SuperCinema.entities.City;
import project.SuperCinema.repositories.CinemaBuildingRepository;
import project.SuperCinema.repositories.CityRepository;
import project.SuperCinema.services.interfaces.CinemaBuildingService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CinemaBuildingServiceImpl implements CinemaBuildingService {


    private CinemaBuildingRepository cinemaBuildingRepository;
    private CityRepository cityRepository;
    private ModelMapper modelMapper;

    private Gson gson;
    public CinemaBuildingServiceImpl(CinemaBuildingRepository cinemaBuildingRepository, CityRepository cityRepository, ModelMapper modelMapper, Gson gson) {
        this.cinemaBuildingRepository = cinemaBuildingRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void saveCinema(CinemaBuilding cinemaBuilding) {
        this.cinemaBuildingRepository.save(cinemaBuilding);
    }

    @Override
    public CinemaBuilding findCinemaByName(String name) {
        return this.cinemaBuildingRepository.findCinemaBuildingByName(name);
    }

    @Override
    public CinemaBuildingDtoJson[] getAllCinemas() {
        CinemaBuilding[] cinemaBuildings = this.cinemaBuildingRepository.findAllCinemaBuildings();
        return this.modelMapper.map(cinemaBuildings,CinemaBuildingDtoJson[].class);
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.CINEMAS_FILES_JSON_PATH));
    }

    @Override
    public void importToDatabase() throws IOException {
        CinemaBuildingDtoJson[] cinemaBuildingsJson = this.gson.fromJson(this.readFile(),CinemaBuildingDtoJson[].class);

        for (CinemaBuildingDtoJson cinemaBuildingJson : cinemaBuildingsJson) {
            City city = this.cityRepository.findCityByName(cinemaBuildingJson.getCity().getName());
            CinemaBuilding cinemaBuilding = this.modelMapper.map(cinemaBuildingJson,CinemaBuilding.class);
            cinemaBuilding.setCity(city);
            this.cinemaBuildingRepository.save(cinemaBuilding);
        }

    }

    @Override
    public boolean isCinemaBuildingsEmpty() {
        return this.cinemaBuildingRepository.count() == 0;
    }


}

package project.SuperCinema.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.constraints.GlobalConstraints;
import project.SuperCinema.dtos.CityDtoJson;
import project.SuperCinema.entities.City;
import project.SuperCinema.repositories.CityRepository;
import project.SuperCinema.services.interfaces.CityService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    private CityRepository cityRepository;
    private Gson gson;
    private ModelMapper modelMapper;

    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveCity(City city) {
        this.cityRepository.save(city);
    }

    @Override
    public City findCityByName(String name) {
        return this.cityRepository.findCityByName(name);
    }

    @Override
    public void importToDatabase() throws IOException {
        CityDtoJson[] citiesJson = this.gson.fromJson(this.readFile(),CityDtoJson[].class);
        for (CityDtoJson cityDtoJson : citiesJson) {
            City city = this.modelMapper.map(cityDtoJson,City.class);
            this.cityRepository.save(city);
        }
    }
    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.CITIES_FILES_JSON_PATH));
    }

    @Override
    public CityDtoJson[] exportCities() {
        City[] cities = this.cityRepository.findAllCities();
        List<CityDtoJson> citiesToExport = new ArrayList<>();
        for (City city : cities) {
            CityDtoJson cityDtoJson = this.modelMapper.map(city,CityDtoJson.class);
            citiesToExport.add(cityDtoJson);
        }
        return citiesToExport.toArray(CityDtoJson[]::new);
    }

    @Override
    public boolean isCitiesEmpty() {
        return this.cityRepository.count() == 0;
    }


}

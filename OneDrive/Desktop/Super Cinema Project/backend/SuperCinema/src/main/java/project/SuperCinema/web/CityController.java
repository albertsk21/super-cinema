package project.SuperCinema.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.SuperCinema.dtos.CityDtoJson;
import project.SuperCinema.services.interfaces.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("")
    public CityDtoJson[] getAllCities(){
        return this.cityService.exportCities();
    }
}

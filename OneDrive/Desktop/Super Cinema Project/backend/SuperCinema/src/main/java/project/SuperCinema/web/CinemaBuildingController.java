package project.SuperCinema.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.SuperCinema.dtos.CinemaBuildingDtoJson;
import project.SuperCinema.services.interfaces.CinemaBuildingService;

@RestController
@RequestMapping("/cinemaBuildings")
public class CinemaBuildingController {

    private CinemaBuildingService cinemaBuildingService;
    public CinemaBuildingController(CinemaBuildingService cinemaBuildingService) {
        this.cinemaBuildingService = cinemaBuildingService;
    }

    @GetMapping("")
    private CinemaBuildingDtoJson[] getCinemaBuildings(){
        return this.cinemaBuildingService.getAllCinemas();
    }
}

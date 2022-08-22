package project.SuperCinema.web;

import org.springframework.web.bind.annotation.*;
import project.SuperCinema.dtos.AvailabilityDtoJson;
import project.SuperCinema.dtos.create.AvailabilityDefault;
import project.SuperCinema.dtos.export.AvailabilityExport;
import project.SuperCinema.dtos.export.AvailabilitySearch;
import project.SuperCinema.dtos.export.MovieSearchJson;
import project.SuperCinema.services.interfaces.AvailabilityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@RestController
@RequestMapping("/availabilities")
public class AvailabilityController {

    private AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping("/")
    public AvailabilityDtoJson[] getAvailabilityByParameters(@RequestParam(value = "city" , defaultValue = "") String city,
                                                             @RequestParam(value = "title", defaultValue = "" ) String title,
                                                             @RequestParam(value = "date", defaultValue = "") String date) throws ParseException {
        AvailabilityDtoJson[] availabilities = new AvailabilityDtoJson[]{};


        if(city.equals("") && title.equals("") && date.equals("")){
            availabilities = this.availabilityService.getAllAvailabilitiesFormatJson();

        }else if((!city.equals("")) && title.equals("") && date.equals("")){
            availabilities = this.availabilityService.getAllAvailabilitiesByCity(city);

        }else if(date.equals("")){
            availabilities = this.availabilityService.findAvailabilityByCityAndMovie(city,title);

        }else {
            String replacement = date.replaceAll("-","/");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                availabilities = this.availabilityService.findAvailabilityByCityAndMovieTitleAndDate(city,title,simpleDateFormat.parse(replacement));
            } catch (ParseException e) {
                throw e;
            }
        }
        return availabilities;
    }

    @GetMapping("/{id}")
    public AvailabilitySearch getAvailabilityById(@PathVariable("id")Long id){
        return this.availabilityService.findAvailabilityById(id);
    }

    @GetMapping("/default-availabilities")
    public AvailabilityDefault[] getAllAvailabilityByDefault(){
        return this.availabilityService.exportAllAvailabilitiesByDefault();
    }

    @PutMapping("/{id}")
    public AvailabilityDtoJson editAvailability(@RequestBody AvailabilityExport availability) throws ParseException {
        return this.availabilityService.editAvailability(availability);
    }

    @PostMapping("/")
    public AvailabilityDtoJson addAvailability(@RequestBody AvailabilityDefault availability) throws ParseException {
        AvailabilityDtoJson availabilityDtoJson = this.availabilityService.createAvailability(availability);
        return availabilityDtoJson;
    }

    @DeleteMapping("/{id}")
    public AvailabilityDtoJson deleteAvailabilityById(@PathVariable("id")Long id){
        return this.availabilityService.deleteAvailabilityById(id);
    }

    @GetMapping("/hours")
    public String[] getHoursByCriteria(@RequestParam(value = "title" , defaultValue = "")String title,
                                       @RequestParam(value = "date" , defaultValue = "") String date,
                                       @RequestParam(value = "cinema" , defaultValue = "") String cinema) throws ParseException {

        if(title.equals("") || date.equals("") || cinema.equals("")){
            throw new IllegalArgumentException("All fields cannot be empty");
        }


        return this.availabilityService.findHoursByDateCinemaAndMovieTitle(title,date,cinema);
    }

    @GetMapping("/movies")
    public MovieSearchJson[] getMovieByCinema(@RequestParam(value = "cinemaName" , defaultValue = "") String cinemaName,
                                              @RequestParam(value = "movieName") String movieName) throws ParseException {



        return this.availabilityService.getMovieByNameAndCinema(cinemaName,movieName);
    }
}

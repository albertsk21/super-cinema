package project.SuperCinema.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.SuperCinema.services.interfaces.*;

import java.io.IOException;
import java.text.ParseException;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private CityService cityService;
    private TicketService ticketService;
    private CinemaBuildingService cinemaBuildingService;
    private MovieService movieService;
    private AvailabilityService availabilityService;


    public ConsoleRunner(CityService cityService, TicketService ticketService, CinemaBuildingService cinemaBuildingService, MovieService movieService, AvailabilityService availabilityService) {
        this.cityService = cityService;
        this.ticketService = ticketService;
        this.cinemaBuildingService = cinemaBuildingService;
        this.movieService = movieService;
        this.availabilityService = availabilityService;

    }

    @Override
    public void run(String... args) throws ParseException, IOException {

        this.addJsonFilesToDB();
    }


    private void addJsonFilesToDB() throws ParseException, IOException{

        if (this.cityService.isCitiesEmpty()) {
            this.cityService.importToDatabase();
        }

        if (this.cinemaBuildingService.isCinemaBuildingsEmpty()) {
            this.cinemaBuildingService.importToDatabase();
        }

        if (this.ticketService.isTicketsEmpty()) {
            this.ticketService.importTicketsToDatabase();
        }

        if (this.movieService.isMovieEmpty()) {
            this.movieService.importMovieToDatabase();
        }

        if(this.availabilityService.isAvailabilityEmpty()){
            this.availabilityService.importAvailabilitiesToDatabase();
        }

    }



}

package project.SuperCinema.services.interfaces;


import project.SuperCinema.dtos.AvailabilityDtoJson;
import project.SuperCinema.dtos.create.AvailabilityDefault;
import project.SuperCinema.dtos.export.AvailabilityExport;
import project.SuperCinema.dtos.export.AvailabilitySearch;
import project.SuperCinema.dtos.export.MovieSearchJson;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public interface AvailabilityService {
    AvailabilitySearch findAvailabilityById(Long id);
    AvailabilityDtoJson[] findAvailabilityByCityAndMovie(String city, String title);
    AvailabilityDtoJson[] findAvailabilityByCityAndMovieTitleAndDate(String city, String title,Date date);
    AvailabilityDtoJson createAvailability(AvailabilityDefault availability) throws ParseException;
    AvailabilityDtoJson deleteAvailabilityById(Long id);
    AvailabilityDtoJson[] getAllAvailabilitiesByCity(String city);
    AvailabilityDtoJson[] getAllAvailabilitiesFormatJson();
    String[] findHoursByDateCinemaAndMovieTitle(String title, String date, String cinema) throws ParseException;
    MovieSearchJson[] getMovieByNameAndCinema(String cinemaName,String movieName)throws ParseException ;
    AvailabilityDtoJson editAvailability(AvailabilityExport availability) throws ParseException;



    AvailabilityDefault[] exportAllAvailabilitiesByDefault();
    boolean isAvailabilityEmpty();
    void importAvailabilitiesToDatabase() throws IOException, ParseException;
    String readFile() throws IOException;
}

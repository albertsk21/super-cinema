package project.SuperCinema.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.constraints.GlobalConstraints;
import project.SuperCinema.dtos.AvailabilityDtoJson;
import project.SuperCinema.dtos.create.AvailabilityDefault;
import project.SuperCinema.dtos.export.AvailabilityExport;
import project.SuperCinema.dtos.export.AvailabilitySearch;
import project.SuperCinema.dtos.export.MovieSearchJson;
import project.SuperCinema.entities.Availability;
import project.SuperCinema.entities.CinemaBuilding;
import project.SuperCinema.entities.Movie;
import project.SuperCinema.repositories.AvailabilityRepository;
import project.SuperCinema.repositories.CinemaBuildingRepository;
import project.SuperCinema.repositories.MovieRepository;
import project.SuperCinema.services.interfaces.AvailabilityService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private AvailabilityRepository availabilityRepository;
    private ModelMapper modelMapper;
    private Gson gson;
    private MovieRepository movieRepository;
    private CinemaBuildingRepository cinemaBuildingRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository, ModelMapper modelMapper, Gson gson, MovieRepository movieRepository, CinemaBuildingRepository cinemaBuildingRepository) {
        this.availabilityRepository = availabilityRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.movieRepository = movieRepository;
        this.cinemaBuildingRepository = cinemaBuildingRepository;
    }
    @Override
    public AvailabilitySearch findAvailabilityById(Long id) {
        try {

            Availability availability = this.availabilityRepository.findAvailabilityById(id);
            AvailabilitySearch availabilitySearch = this.modelMapper.map(availability, AvailabilitySearch.class);
            String date = availability.getDate().toString();


            String[] detailsDate = date.split(" ")[0].split("-");
            String formattedDate = detailsDate[2] + "/" + detailsDate[1] + "/" + detailsDate[0];
            availabilitySearch.setDate(formattedDate);

            return availabilitySearch;

        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public AvailabilityDtoJson[] findAvailabilityByCityAndMovie(String city, String title) {
        Availability[] availabilities = this.availabilityRepository.findAvailabilityByCityAndMovieTitle(city,title);
        AvailabilityDtoJson[] availabilitiesJson = this.modelMapper.map(availabilities,AvailabilityDtoJson[].class);
        return availabilitiesJson;
    }

    @Override
    public AvailabilityDtoJson[] findAvailabilityByCityAndMovieTitleAndDate(String city, String title, Date date) {
        Availability[] availabilities = this.availabilityRepository.findAvailabilityByCityAndMovieTitleAndDate(city,title,date);
        AvailabilityDtoJson[] availabilityJson = this.modelMapper.map(availabilities,AvailabilityDtoJson[].class);
        return availabilityJson;
    }

    @Override
    public AvailabilityDtoJson createAvailability(AvailabilityDefault availability) throws ParseException {

        Availability createAvailability = new Availability();

        Movie movie = this.movieRepository.findMovieByTitle(availability.getMovieTitle());
        CinemaBuilding cinemaBuilding = this.cinemaBuildingRepository.findCinemaBuildingByName(availability.getCinemaBuildingName());

        String replacement = availability.getDate().replaceAll("-","/");
        SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormatDate.parse(replacement);

        createAvailability.setMovie(movie);
        createAvailability.setCinemaBuilding(cinemaBuilding);
        createAvailability.setDate(date);
        createAvailability.setTime(availability.getTime());
        createAvailability.setHall(availability.getHall());

        Availability availabilityToExport = this.availabilityRepository.save(createAvailability);
        AvailabilityDtoJson exportAvailabilityJson = this.modelMapper.map(availabilityToExport,AvailabilityDtoJson.class);

        return exportAvailabilityJson;
    }

    @Override
    public AvailabilityDtoJson deleteAvailabilityById(Long id) {

        Availability availability = this.availabilityRepository.findAvailabilityById(id);
        AvailabilityDtoJson availabilityDtoJson = this.modelMapper.map(availability,AvailabilityDtoJson.class);
        this.availabilityRepository.deleteById(id);
        return availabilityDtoJson;
    }

    @Override
    public AvailabilityDtoJson[] getAllAvailabilitiesByCity(String city){
        Availability[] availabilities = this.availabilityRepository.findAvailabilityByCity(city);
        AvailabilityDtoJson[] availabilitiesJson = this.modelMapper.map(availabilities,AvailabilityDtoJson[].class);
        return availabilitiesJson;
    }

    @Override
    public AvailabilityDtoJson[] getAllAvailabilitiesFormatJson() {

        Availability[] availabilities = this.availabilityRepository.getAllAvailabilities();
        AvailabilityDtoJson[] availabilitiesJson = this.modelMapper.map(availabilities,AvailabilityDtoJson[].class);


        return availabilitiesJson;
    }


    @Override
    public String[] findHoursByDateCinemaAndMovieTitle(String title, String date, String cinema) throws ParseException {


        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date importDate = formatDate.parse(date);

        return this.availabilityRepository.findHoursByMovieTitleAndDateAndCinema(title, importDate,cinema);
    }

    @Override
    public MovieSearchJson[] getMovieByNameAndCinema(String cinemaName, String movieName) throws ParseException {
        Availability[] availabilities = this.availabilityRepository.findAvailabilityByCinemaBuildingName(cinemaName);

        if(!movieName.equals("")){
            availabilities = this.availabilityRepository.findAvailabilityByCinemaBuildingNameAndMovie(cinemaName,movieName);
        }

        Map<String, List<MovieSearchJson>> movies = new LinkedHashMap<>();

        for (Availability availability : availabilities) {

            String[] infoDates = availability.getDate().toString().split(" ")[0].split("-");
            String currentDate = infoDates[2] + "/" + infoDates[1] + "/" + infoDates[0];
            MovieSearchJson movie = new MovieSearchJson();
            movie.setDate(currentDate);
            movie.setUrlImage(availability.getMovie().getUrlImage());
            movie.setTitle(availability.getMovie().getTitle());

            List<MovieSearchJson> movieSearchJsons;
            if (!movies.containsKey(currentDate)) {
                movieSearchJsons = new ArrayList<>();
                movieSearchJsons.add(movie);
            }else{
                movieSearchJsons = movies.get(currentDate);
                if(!containsMovie(movie.getTitle(),movieSearchJsons)){
                    movieSearchJsons.add(movie);
                }
            }
            movies.put(currentDate, movieSearchJsons);

        }


        List<MovieSearchJson> exportMovies = new ArrayList<>();

        for ( String key : movies.keySet()) {
            List<MovieSearchJson> movieList = movies.get(key);
            for (MovieSearchJson movie : movieList) {
                movie.setHours(this.findHoursByDateCinemaAndMovieTitle(movie.getTitle(),key,cinemaName));
                exportMovies.add(movie);
            }
        }

        return exportMovies.toArray(MovieSearchJson[]::new);
    }

    @Override
    public AvailabilityDtoJson editAvailability( AvailabilityExport availability) throws ParseException {
        Availability editAvailability = this.availabilityRepository.findAvailabilityById(availability.getId());
        editAvailability.setHall(availability.getHall());
        SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormatDate.parse(availability.getDate());

        editAvailability.setDate(date);
        editAvailability.setTime(availability.getTime());

        Movie movie = this.movieRepository.findMovieByTitle(availability.getMovieTitle());
        CinemaBuilding cinemaBuilding = this.cinemaBuildingRepository.findCinemaBuildingByName(availability.getCinemaBuilding());

        editAvailability.setMovie(movie);
        editAvailability.setCinemaBuilding(cinemaBuilding);


       Availability savedAvailability =  this.availabilityRepository.save(editAvailability);
       AvailabilityDtoJson availabilityToJson = this.modelMapper.map(savedAvailability,AvailabilityDtoJson.class);
        return availabilityToJson;
    }

    @Override
    public AvailabilityDefault[] exportAllAvailabilitiesByDefault() {
        Availability[] availabilities = this.availabilityRepository.getAllAvailabilities();
        List<AvailabilityDefault> availabilitiesList = new ArrayList<>();

        for ( Availability availability : availabilities ) {
            availabilitiesList.add(this.convertToDefaultAvailabilityJson(availability));
        }
        return availabilitiesList.toArray(AvailabilityDefault[]::new);
    }

    @Override
    public boolean isAvailabilityEmpty() {
        return this.availabilityRepository.count() == 0;
    }

    @Override
    public void importAvailabilitiesToDatabase() throws IOException, ParseException {
        AvailabilityDefault[] availabilitiesJson = this.gson.fromJson(this.readFile(),AvailabilityDefault[].class);

        for (AvailabilityDefault availability : availabilitiesJson) {

            this.createAvailability(availability);
        }

    }


    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.AVAILABILITIES_FILE_JSON_PATH));
    }

    private AvailabilityDefault convertToDefaultAvailabilityJson(Availability availability){
        AvailabilityDefault defaultAvailability = new AvailabilityDefault();
        defaultAvailability.setCinemaBuildingName(availability.getCinemaBuilding().getName());
        defaultAvailability.setHall(availability.getHall());

        String[] infoDates = availability.getDate().toString().split(" ")[0].split("-");
        String currentDate = infoDates[2] + "/" + infoDates[1] + "/" + infoDates[0];
        defaultAvailability.setDate(currentDate);
        defaultAvailability.setTime(availability.getTime());
        defaultAvailability.setMovieTitle(availability.getMovie().getTitle());


        return defaultAvailability;
    }

    private Boolean containsMovie(String title,List<MovieSearchJson>  movies ){

        for (MovieSearchJson movie : movies) {
            if (movie.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }



}

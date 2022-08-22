package project.SuperCinema.services.impl;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.constraints.GlobalConstraints;
import project.SuperCinema.constraints.Output;
import project.SuperCinema.dtos.MovieDtoJson;
import project.SuperCinema.entities.Movie;
import project.SuperCinema.repositories.MovieRepository;
import project.SuperCinema.services.interfaces.MovieService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private Gson gson;
    private ModelMapper modelMapper;

    public MovieServiceImpl(MovieRepository movieRepository, Gson gson, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public Movie findMovieByName(String name) {
        return this.movieRepository.findMovieByTitle(name);
    }

    @Override
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public MovieDtoJson[]  getAllMovieFormatJson() {
        List<Movie> movies = this.getAllMovies();
        MovieDtoJson[] moviesJson = this.modelMapper.map(movies.toArray(Movie[]::new),MovieDtoJson[].class);
        return moviesJson;
    }

    @Override
    public MovieDtoJson addJsonMovie(MovieDtoJson movieDtoJson) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Movie movie = this.modelMapper.map(movieDtoJson,Movie.class);
        Date date = format.parse(movieDtoJson.getReleaseDate());
        movie.setReleaseDate(date);
        this.saveMovie(movie);
        Movie existMovie = this.findMovieByName(movie.getTitle());
        return this.modelMapper.map(existMovie,MovieDtoJson.class);
    }

    @Override
    public MovieDtoJson getMovieById(Long id) {





        Movie movie = this.movieRepository.findMovieById(id);

        if(movie == null){
            throw new IllegalArgumentException(String.format(Output.INVALID_OBJECT,Movie.class.getSimpleName()));
        }

        MovieDtoJson movieDtoJson = this.modelMapper.map(movie,MovieDtoJson.class);



        String[] dateElements =  movie.getReleaseDate().toString().split(" ")[0].split("-");
        String format = String.format("%s/%s/%s",dateElements[2],dateElements[1],dateElements[0]);
        movieDtoJson.setReleaseDate(format);



        return movieDtoJson;
    }

    @Override
    public MovieDtoJson deleteMovieById(Long id) {
        MovieDtoJson movie = this.getMovieById(id);
        this.movieRepository.deleteMovieById(id);
        return movie;
    }

    @Override
    public MovieDtoJson[] findByCriteria(String type, String ageRestriction, String production, String language) {
        MovieDtoJson[] movies = this.getAllMovieFormatJson();
        List<MovieDtoJson> containerMovies = new ArrayList<>();
        List<String[]> criteriaList = new ArrayList<>();
        String[] arr = new String[1];
        if(!type.equals("")){
             arr = new String[]{type, "type"};
            criteriaList.add(arr);
        }
        if(!ageRestriction.equals("")){
            arr = new String[]{ageRestriction, "ageRestriction"};
            criteriaList.add(arr);
        }
        if(!production.equals("")){
            arr = new String[]{production, "production"};
            criteriaList.add(arr);
        }
        if(!language.equals("")){
            arr = new String[]{language, "language"};
            criteriaList.add(arr);
        }


        for (MovieDtoJson movie : movies) {
            if (movieIsValid(criteriaList, movie)) {
                containerMovies.add(movie);
            }
        }


        return containerMovies.toArray(MovieDtoJson[]::new);
    }

    @Override
    public void importMovieToDatabase() throws IOException, ParseException {
        MovieDtoJson[] moviesJson = this.gson.fromJson(this.readFile(),MovieDtoJson[].class);
        for (MovieDtoJson movieJson : moviesJson) {
            this.addJsonMovie(movieJson);
        }
    }
    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.MOVIES_JSON_FORMAT));
    }

    @Override
    public boolean isMovieEmpty() {
        return this.movieRepository.count() == 0;
    }

    private boolean movieIsValid(List<String[]> criteriaList ,MovieDtoJson movie){
        boolean check = false;

        List<Boolean> checks = new ArrayList<>();

        for (String[] currentDetails : criteriaList) {

            String value = currentDetails[0];
            String typeValue = currentDetails[1];

            switch (typeValue) {
                case "type":
                    if (movie.getMovieGenre().contains(value)) {
                        check = true;
                    }
                    break;
                case "ageRestriction":
                    if (movie.getAgeRestriction().contains(value)) {
                        check = true;
                    }
                    break;
                case "production":
                    if (movie.getProduction().contains(value)) {
                        check = true;
                    }
                    break;
                case "language":
                    if (movie.getNativeLanguage().contains(value)) {
                        check = true;
                    }
                    break;
            }

            checks.add(check);
            check = false;
        }


        for (Boolean currentCheck : checks) {

            if (!currentCheck) {
                return false;
            }
        }

        return true;
    }

}

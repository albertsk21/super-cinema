package project.SuperCinema.services.interfaces;

import project.SuperCinema.dtos.MovieDtoJson;
import project.SuperCinema.entities.Movie;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface MovieService {
    void saveMovie(Movie movie);
    Movie findMovieByName(String name);
    List<Movie> getAllMovies();
    MovieDtoJson[] getAllMovieFormatJson();
    MovieDtoJson addJsonMovie(MovieDtoJson movieDtoJson) throws ParseException;

    MovieDtoJson getMovieById(Long id);
    MovieDtoJson deleteMovieById(Long id);


    MovieDtoJson[] findByCriteria(String type, String ageRestriction, String production, String language);
    void importMovieToDatabase() throws IOException, ParseException;
    String readFile() throws IOException;
    boolean isMovieEmpty();
}

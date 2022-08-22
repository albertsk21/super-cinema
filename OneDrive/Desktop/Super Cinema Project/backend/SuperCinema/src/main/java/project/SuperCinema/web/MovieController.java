package project.SuperCinema.web;

import org.springframework.web.bind.annotation.*;
import project.SuperCinema.dtos.MovieDtoJson;
import project.SuperCinema.services.interfaces.MovieService;

import java.text.ParseException;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public MovieDtoJson[] getAllMoviesByCriteria(@RequestParam(value = "type", defaultValue = "") String type,
                                       @RequestParam(value = "age", defaultValue = "")String age,
                                       @RequestParam(value = "production")String production,
                                       @RequestParam(value = "language", defaultValue = "")String language){

        if(type.equals("") && age.equals("") && production.equals("") && language.equals("")){
            return new MovieDtoJson[]{};
        }

        return this.movieService.findByCriteria(type,age,production,language);
    }

    @GetMapping("/all-movies")
    public MovieDtoJson[] getAllMovies(){
            return this.movieService.getAllMovieFormatJson();

    }
    @GetMapping("/{id}")
    public MovieDtoJson getMovieById(@PathVariable("id") Long id){
        return this.movieService.getMovieById(id);
    }

    @PostMapping("")
    public MovieDtoJson add(@RequestBody MovieDtoJson movieDtoJson) throws ParseException {
        return this.movieService.addJsonMovie(movieDtoJson);
    }

    @PutMapping("")
    public MovieDtoJson put(@RequestBody MovieDtoJson movieDtoJson) throws ParseException {
        return this.movieService.addJsonMovie(movieDtoJson);
    }

    @DeleteMapping("/{id}")
    public MovieDtoJson deleteMovieByID(@PathVariable("id") Long id){
        return this.movieService.deleteMovieById(id);
    }






}

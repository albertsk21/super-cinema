package project.SuperCinema.dtos.export;

import project.SuperCinema.dtos.CinemaBuildingDtoJson;

public class AvailabilitySearch {
    private Long id;
    private String date;
    private String time;
    private MovieSearchJson movie;
    private CinemaBuildingDtoJson cinemaBuilding;
    private int hall;


    public AvailabilitySearch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MovieSearchJson getMovie() {
        return movie;
    }

    public void setMovie(MovieSearchJson movie) {
        this.movie = movie;
    }

    public CinemaBuildingDtoJson getCinemaBuilding() {
        return cinemaBuilding;
    }

    public void setCinemaBuilding(CinemaBuildingDtoJson cinemaBuilding) {
        this.cinemaBuilding = cinemaBuilding;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }
}

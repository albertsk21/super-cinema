package project.SuperCinema.dtos;

import java.util.Date;

public class AvailabilityDtoJson {

    private Long id;
    private Date date;
    private String time;
    private MovieDtoJson movie;
    private CinemaBuildingDtoJson cinemaBuilding;
    private int hall;


    public AvailabilityDtoJson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MovieDtoJson getMovie() {
        return movie;
    }

    public void setMovie(MovieDtoJson movie) {
        this.movie = movie;
    }

    public CinemaBuildingDtoJson getCinemaBuilding() {
        return cinemaBuilding;
    }

    public void setCinemaBuilding(CinemaBuildingDtoJson cinemaBuilding) {
        this.cinemaBuilding = cinemaBuilding;
    }

    public String getTime() {
        return time;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

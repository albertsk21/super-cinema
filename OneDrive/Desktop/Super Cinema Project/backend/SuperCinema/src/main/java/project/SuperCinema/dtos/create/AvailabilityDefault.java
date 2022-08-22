package project.SuperCinema.dtos.create;

import com.google.gson.annotations.Expose;

public class AvailabilityDefault {

    @Expose
    private String date;
    @Expose
    private String time;
    @Expose
    private String movieTitle;
    @Expose
    private String cinemaBuildingName;
    @Expose
    private int hall;


    public AvailabilityDefault() {
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
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


    public String getCinemaBuildingName() {
        return cinemaBuildingName;
    }

    public void setCinemaBuildingName(String cinemaBuildingName) {
        this.cinemaBuildingName = cinemaBuildingName;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }
}

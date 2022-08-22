package project.SuperCinema.dtos.export;

public class AvailabilityExport {



    private Long id;
    private String date;
    private String time;
    private String movieTitle;
    private String cinemaBuilding;
    private int hall;

    public AvailabilityExport(String date, String time, String movieTitle, String cinemaBuilding) {
        this.date = date;
        this.time = time;
        this.movieTitle = movieTitle;
        this.cinemaBuilding = cinemaBuilding;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCinemaBuilding() {
        return cinemaBuilding;
    }

    public void setCinemaBuilding(String cinemaBuilding) {
        this.cinemaBuilding = cinemaBuilding;
    }
}

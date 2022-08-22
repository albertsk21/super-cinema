package project.SuperCinema.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "availabilities")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String time;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private int hall;

    @ManyToOne
    @JoinColumn(name = "cinema_buildings_id")
    private CinemaBuilding cinemaBuilding;

    @OneToMany(mappedBy = "availability")
    private Set<Reservation> reservations;
    public Availability() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CinemaBuilding getCinemaBuilding() {
        return cinemaBuilding;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public void setCinemaBuilding(CinemaBuilding cinemaBuildings) {
        this.cinemaBuilding = cinemaBuildings;
    }



    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }





}

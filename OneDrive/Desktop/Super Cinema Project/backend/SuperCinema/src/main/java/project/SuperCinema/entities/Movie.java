package project.SuperCinema.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int duration;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "native_language")
    private String nativeLanguage;
    private String cast;
    private String production;
    @Column(name = "movie_genre")
    private String movieGenre;
    @Column(name = "age_restrictions")
    private String ageRestriction;
    @Column(length = 1500)
    private String description;
    @Column(name = "url_image")
    private String urlImage;
    @Column(name = "url_video")
    private String urlVideo;

    @OneToMany(mappedBy = "movie")
    private Set<Availability> availabilities;


    public Movie() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }



    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getUrlVideo() {
        return urlVideo;
    }



    public String getCast() {
        return cast;
    }

    public String getProduction() {
        return production;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }



}

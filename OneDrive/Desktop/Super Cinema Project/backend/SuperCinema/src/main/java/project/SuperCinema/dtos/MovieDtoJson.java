package project.SuperCinema.dtos;


import com.google.gson.annotations.Expose;

public class MovieDtoJson {

    @Expose
    private Long id;
    @Expose
    private String title;
    @Expose
    private int duration;
    @Expose
    private String releaseDate;
    @Expose
    private String nativeLanguage;
    @Expose
    private String cast;
    @Expose
    private String production;
    @Expose
    private String movieGenre;
    @Expose
    private String ageRestriction;
    @Expose
    private String description;
    @Expose
    private String urlImage;
    @Expose
    private String urlVideo;



    public MovieDtoJson() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
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
    public void setDescription(String description) {
        this.description = description;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setReleaseDate(String date) {
        this.releaseDate = date;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
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
    public String getDescription() {
        return description;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public String getUrlVideo() {
        return urlVideo;
    }
    public int getDuration() {
        return duration;
    }
}

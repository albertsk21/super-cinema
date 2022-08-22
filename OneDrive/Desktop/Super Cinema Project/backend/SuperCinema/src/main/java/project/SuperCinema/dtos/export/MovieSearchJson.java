package project.SuperCinema.dtos.export;

public class MovieSearchJson {


    private String urlImage;
    private String date;
    private Object[] hours;
    private String title;


    public MovieSearchJson() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object[] getHours() {
        return hours;
    }

    public void setHours(Object[] hours) {
        this.hours = hours;
    }
}

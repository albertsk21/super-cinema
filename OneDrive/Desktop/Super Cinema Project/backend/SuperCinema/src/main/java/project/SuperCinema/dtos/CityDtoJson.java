package project.SuperCinema.dtos;


import com.google.gson.annotations.Expose;

public class CityDtoJson {

    @Expose
    private String name;

    public CityDtoJson() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

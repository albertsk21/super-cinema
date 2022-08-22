package project.SuperCinema.dtos;


import com.google.gson.annotations.Expose;

public class CinemaBuildingDtoJson {

    @Expose
    private String name;
    @Expose
    private String addressDetails;
    @Expose
    private CityDtoJson city;


    public CinemaBuildingDtoJson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public CityDtoJson getCity() {
        return city;
    }

    public void setCity(CityDtoJson city) {
        this.city = city;
    }
}

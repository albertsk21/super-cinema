package project.SuperCinema.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cinema_buildings")
public class CinemaBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "address_details")
    private String addressDetails;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(cascade = {CascadeType.REMOVE},mappedBy = "cinemaBuilding")
    private Set<Availability> availabilities;


    public CinemaBuilding() {
    }

    public CinemaBuilding(String name, String addressDetails, City city) {
        this.name = name;
        this.addressDetails = addressDetails;
        this.city = city;
    }


    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public String getAddressDetails() {
        return addressDetails;
    }

    public City getCity() {
        return city;
    }


}

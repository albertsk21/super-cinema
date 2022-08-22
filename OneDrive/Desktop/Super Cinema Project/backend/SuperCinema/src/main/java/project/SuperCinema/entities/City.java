package project.SuperCinema.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "city")
    private Set<CinemaBuilding> cinemaBuildings;


    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setCinemaBuildings(Set<CinemaBuilding> cinemaBuildings) {
        this.cinemaBuildings = cinemaBuildings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<CinemaBuilding> getCinemaBuildings() {
        return cinemaBuildings;
    }
}

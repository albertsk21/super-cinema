package project.SuperCinema.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tickets")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private double price;
    @OneToMany(mappedBy = "ticket")
    private Set<Reservation> reservations;



    public Ticket() {
    }

    public Ticket(String category, double price) {
        this.category = category;
        this.price = price;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}

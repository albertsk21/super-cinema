package project.SuperCinema.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int hall;
    @Column(name = "seat_number")
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "availability_id")
    private Availability availability;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date hour;


    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    public Reservation() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getHall() {
        return hall;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getHour() {
        return hour;
    }

    public Ticket getTicket() {
        return ticket;
    }
}

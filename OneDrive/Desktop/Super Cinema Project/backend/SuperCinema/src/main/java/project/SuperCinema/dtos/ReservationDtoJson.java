package project.SuperCinema.dtos;

public class ReservationDtoJson {

    private Long id;
    private String date;
    private int hall;
    private int seatNumber;
    private CustomerDtoJson customer;
    private String hour;

    private TicketDtoJson ticket;


    public ReservationDtoJson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public CustomerDtoJson getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDtoJson customer) {
        this.customer = customer;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


    public TicketDtoJson getTicket() {
        return ticket;
    }

    public void setTicket(TicketDtoJson ticket) {
        this.ticket = ticket;
    }
}

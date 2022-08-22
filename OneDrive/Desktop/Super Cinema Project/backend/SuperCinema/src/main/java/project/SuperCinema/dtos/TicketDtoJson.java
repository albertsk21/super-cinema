package project.SuperCinema.dtos;

import com.google.gson.annotations.Expose;

public class TicketDtoJson {


    @Expose
    private Long id;
    @Expose
    private String category;
    @Expose
    private double price;

    public TicketDtoJson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

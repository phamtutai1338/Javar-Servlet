package car_list;

import java.awt.*;

public class Car {

    private int id;
    private String carName;
    private Double price;

    private String color;
    private String imageUrl;

    private String details;

    public Car(int id, String carName, Double price, String color, String imageUrl, String details) {
        super();
        this.id = id;
        this.carName = carName;
        this.price = price;
        this.color = color;
        this.imageUrl = imageUrl;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {

        this.carName = carName;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

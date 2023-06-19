package com.example.hotels1.entity;

public class Room {
    private int roomId;
    private String name;
    private String description;
    private double price;
    private String img;
    private boolean status;
    private int hotelId;

    public Room(int roomId, String name, String description, double price, String img, boolean status, int hotelId) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.status = status;
        this.hotelId = hotelId;
    }

    public Room(String name, String description, double price, String img, boolean status, int hotelId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.status = status;
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", status=" + status +
                ", hotelId=" + hotelId +
                '}';
    }
}

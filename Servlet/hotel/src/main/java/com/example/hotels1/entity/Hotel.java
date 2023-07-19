package com.example.hotels1.entity;

public class Hotel {
    private int hotelId;
    private String name;

    private String phone;
    private String email;
    private String address;
    private String img;
    private int roomId;


    public Hotel(String name, String phone, String email, String address, String img, int roomId){
        this.name=name;
        this.phone = phone;
        this.email = email;
        this.address=address;
        this.img=img;
        this.roomId=roomId;
    }
    public Hotel(int hotelId, String name, String phone, String email, String address, String img, int roomId){
        this.hotelId = hotelId;
        this.name=name;
        this.phone = phone;
        this.email = email;
        this.address=address;
        this.img=img;
        this.roomId=roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    @Override
    public String toString(){
        return "Hotel [hotelId="+ hotelId +", name=" + name +", phone=" +phone + "," +
                "email=" + email + ",address=" + address +",img=" + img + ",roomId=" + roomId +"  ]";
    }
}

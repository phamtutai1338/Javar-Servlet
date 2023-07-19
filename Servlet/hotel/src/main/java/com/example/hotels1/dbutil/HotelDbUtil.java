package com.example.hotels1.dbutil;


import com.example.hotels1.entity.Hotel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDbUtil {
    private DataSource dataSource;
    public HotelDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Hotel> getHotels() throws Exception {
        List<Hotel> hotelList = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            String sql = "select * from hotels order by  name";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int hotelId = myRs.getInt("hotelId");
                String name = myRs.getString("name");
                String phone = myRs.getString("phone");
                String email = myRs.getString("email");
                String address = myRs.getString("address");
                String img = myRs.getString("img");
                int roomId = myRs.getInt("roomId");

                Hotel tempHotel = new Hotel(hotelId, name, phone, email,address,img,roomId);

                hotelList.add(tempHotel);
            }
            return hotelList;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    public List<Hotel> searchByNameAddress(String txt) throws Exception {
        List<Hotel> hotelList = new ArrayList<>();

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String search;
        try{
            search = txt;
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            String sql = "SELECT * FROM `hotels` WHERE name LIKE ? or address LIKE ? ";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,"%"+search+"%");
            myStmt.setString(2,"%"+search+"%");
            myRs = myStmt.executeQuery();

            while (myRs.next()){
                int hotelId = myRs.getInt("hotelId");
                String name = myRs.getString("name");
                String phone = myRs.getString("phone");
                String email = myRs.getString("email");
                String address = myRs.getString("address");
                String img = myRs.getString("img");
                int roomId = myRs.getInt("roomId");

                Hotel tempHotel = new Hotel(hotelId, name, phone, email,address,img,roomId);

                hotelList.add(tempHotel);
            }
            return hotelList;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try{
            if (myRs != null){
                myRs.close();
            }

            if (myStmt != null){
                myStmt.close();
            }

            if (myConn != null){
                myConn.close();
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }
    public void addHotel(Hotel theHotel) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "insert into hotels" + "(name, phone, email,address,img,roomId)" + "values (?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theHotel.getName());
            myStmt.setString(2, theHotel.getPhone());
            myStmt.setString(3, theHotel.getEmail());
            myStmt.setString(4, theHotel.getPhone());
            myStmt.setString(5, theHotel.getImg());
            myStmt.setInt(6, theHotel.getRoomId());

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
    public Hotel getHotel(String theHotelId) throws Exception{
        Hotel theHotel = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int hotelId;

        try{
            hotelId = Integer.parseInt(theHotelId);

            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "select * from hotel where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, hotelId);

            myRs = myStmt.executeQuery();

            if (myRs.next()){
                String name = myRs.getString("name");
                String phone = myRs.getString("phone");
                String email = myRs.getString("email");
                String address = myRs.getString("address");

                String img = myRs.getString("img");
                Integer roomdId =myRs.getInt("roomId");


                theHotel = new Hotel(hotelId, name, phone, email,address,img,roomdId);
            }
            else {
                throw new Exception("Could not find student id: " + hotelId);
            }
            return theHotel;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    public void updateHotel(Hotel theHotel) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "update hotel " + "set name=?, phone=?, email=?, address=?, img=?, roomId=?" + "where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theHotel.getName());
            myStmt.setString(2, theHotel.getPhone());
            myStmt.setString(3, theHotel.getEmail());
            myStmt.setString(4, theHotel.getAddress());
            myStmt.setString(5, theHotel.getImg());
            myStmt.setInt(6, theHotel.getRoomId());;
            myStmt.setInt(7, theHotel.getHotelId());

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
    public void deleteHotel(String theHotelId) throws Exception{
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            int hotelId = Integer.parseInt(theHotelId);

            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "delete from hotel where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, hotelId);

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
}

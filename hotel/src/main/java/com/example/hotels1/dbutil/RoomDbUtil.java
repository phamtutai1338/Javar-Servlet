package com.example.hotels1.dbutil;

import com.example.hotels1.entity.Hotel;
import com.example.hotels1.entity.Room;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDbUtil {
    private DataSource dataSource;
    public RoomDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Room> getRooms() throws Exception {
        List<Room> roomList = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            String sql = "select * from rooms order by  name";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int roomId = myRs.getInt("roomid");
                String name = myRs.getString("name");
                String description = myRs.getString("description");
                double price = myRs.getDouble("price");
                String img = myRs.getString("img");
                boolean status = myRs.getBoolean("status");
                int hotelId = myRs.getInt("hotelId");

                Room tempRoom = new Room(roomId, name, description,price,img,status,hotelId);

                roomList.add(tempRoom);
            }
            return roomList;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    public List<Room> getRoomsByHotelId(String theHotelId) throws Exception {
        List<Room> roomListByHotelId = new ArrayList<>();

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int hotelid ;
        try{
            hotelid = Integer.parseInt(theHotelId);
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            String sql = "select * from rooms where hotelId=? ";

            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1,hotelid);
            myRs = myStmt.executeQuery();
            while (myRs.next()){
                int roomId = myRs.getInt("roomid");
                String name = myRs.getString("name");
                String description = myRs.getString("description");
                double price = myRs.getDouble("price");
                String img = myRs.getString("img");
                boolean status = myRs.getBoolean("status");
                int hotelId = myRs.getInt("hotelId");

                Room tempRoom = new Room(roomId, name, description,price,img,status,hotelId);

                roomListByHotelId.add(tempRoom);
            }
            return roomListByHotelId;
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
    public void addRoom(Room theRoom) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "insert into rooms" + "(name, description, price,img,status,hotelId)" + "values (?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theRoom.getName());
            myStmt.setString(2, theRoom.getDescription());
            myStmt.setDouble(3, theRoom.getPrice());
            myStmt.setString(4, theRoom.getImg());
            myStmt.setBoolean(5, theRoom.isStatus());
            myStmt.setInt(6, theRoom.getHotelId());

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
    public Room getRoom(String theRoomId) throws Exception{

        Room theRoom = null;
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int roomId;

        try{
            roomId = Integer.parseInt(theRoomId);

            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "select * from rooms where roomid=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, roomId);

            myRs = myStmt.executeQuery();

            if (myRs.next()){
                String name = myRs.getString("name");
                String description = myRs.getString("description");
                double price = myRs.getDouble("price");
                String img = myRs.getString("img");
                boolean status = myRs.getBoolean("status");
                Integer hotelId =myRs.getInt("hotelId");


                theRoom = new Room(roomId, name, description, price,img,status,hotelId);
            }
            else {
                throw new Exception("Could not find room id: " + roomId);
            }
            return theRoom;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    public void updateRoom(Room theRoom) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "update rooms " + "set name=?, description=?, price=?, img=?, status=?, hotelId=? " + "where roomid=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, theRoom.getName());
            myStmt.setString(2, theRoom.getDescription());
            myStmt.setDouble(3, theRoom.getPrice());
            myStmt.setString(4, theRoom.getImg());
            myStmt.setBoolean(5, theRoom.isStatus());
            myStmt.setInt(6, theRoom.getHotelId());;

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
    public void deleteRoom(String theRoomId) throws Exception{
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            int roomId = Integer.parseInt(theRoomId);

            String url = "jdbc:mysql://localhost:3306/hotel_asm_ky4";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "delete from rooms where roomid=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, roomId);

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
}

package com.example.hotels1.controller;

import com.example.hotels1.dbutil.HotelDbUtil;
import com.example.hotels1.dbutil.RoomDbUtil;
import com.example.hotels1.entity.Hotel;
import com.example.hotels1.entity.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RoomControllerServlet", value = "/RoomControllerServlet")
public class RoomControllerServlet extends HttpServlet {
    private static final long serialVersionUID =  1L;
    private RoomDbUtil roomDbUtil;
    @Resource(name="jdbc/hotel_asm_ky4")
    private DataSource dataSource;
    private List<Room> roomList;
    @Override
    public void init() throws ServletException{
        super.init();
        roomList = new ArrayList<>();


        try {

            roomDbUtil = new RoomDbUtil(dataSource);
        }catch (Exception exc){
            throw new ServletException(exc);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null){
                theCommand = "list";
            }
            switch (theCommand){
                case "DETAIL":
                    detailRoom(request,response);
                    break;
                case "ADD":
                    addRoom(request, response);
                    break;
                case "LOAD":
                    loadRoom(request, response);
                    break;
                case "UPDATE":
                    updateRoom(request, response);
                    break;
                case "DELETE":
                    deleteRoom(request, response);
                    break;
                default:
                    listRooms(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
    }
    private void listRooms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theHotelId = request.getParameter("theHotelId");
        List<Room> rooms = roomDbUtil.getRoomsByHotelId(theHotelId);

        request.setAttribute("ROOM_LIST", rooms);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-room.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theRoomsId = request.getParameter("roomsId");

        roomDbUtil.deleteRoom(theRoomsId);

        listRooms(request, response);
    }
    public void updateRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price =Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));

        Room theRoom = new Room(roomId, name, description, price,img,status,hotelId);

        roomDbUtil.updateRoom(theRoom);
        listRooms(request, response);
    }
    public void loadRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theRoomsId = request.getParameter("roomsId");

        Room theRoom = roomDbUtil.getRoom(theRoomsId);

        request.setAttribute("THE_ROOM", theRoom);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-room-form.jsp");
        dispatcher.forward(request, response);
    }
    public void detailRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theRoomsId = request.getParameter("roomsId");
        Room theRoom = roomDbUtil.getRoom(theRoomsId);
        request.setAttribute("THE_ROOM_DETAIL",theRoom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/detail-room.jsp");
        dispatcher.forward(request,response);
    }
    public void addRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        boolean status = Boolean.parseBoolean(request.getParameter("status")) ;
        String img = request.getParameter("img");
        Integer hotelId = Integer.valueOf(request.getParameter("hotelId"));
        Room theRoom = new Room(name, description, price,img,status,hotelId);

        roomDbUtil.addRoom(theRoom);

        listRooms(request, response);
    }
}

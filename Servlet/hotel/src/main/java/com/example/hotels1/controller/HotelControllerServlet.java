package com.example.hotels1.controller;

import com.example.hotels1.dbutil.HotelDbUtil;
import com.example.hotels1.entity.Hotel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/HotelControllerServlet")
public class HotelControllerServlet extends HttpServlet{
    private static final long serialVersionUID =  1L;
    private HotelDbUtil hotelDbUtil;
    @Resource(name="jdbc/hotel_asm_ky4")
   private DataSource dataSource;
    private List<Hotel> hotelList;
    @Override
    public void init() throws ServletException{
        super.init();
        hotelList = new ArrayList<>();
        hotelList.add(new Hotel("Hotel","1234","hotel@gmail.com","Hà Nội","img/room/room-1.jpg",1));

        try {

            hotelDbUtil = new HotelDbUtil(dataSource);
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

                case "ADD":
                    addHotel(request, response);
                    break;
                case "LOAD":
                    loadHotel(request, response);
                    break;
                case "UPDATE":
                    updateHotel(request, response);
                    break;
                case "DELETE":
                    deleteHotel(request, response);
                    break;
                default:
                    listHotels(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
    }
    private void listHotels(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Hotel> hotels = hotelDbUtil.getHotels();

        request.setAttribute("HOTEL_LIST", hotels);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-hotel.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theHotelsId = request.getParameter("hotelsId");

        hotelDbUtil.deleteHotel(theHotelsId);

        listHotels(request, response);
    }
    public void updateHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String img = request.getParameter("img");
        int roomId = Integer.parseInt(request.getParameter("roomId"));

        Hotel theHotel = new Hotel(hotelId, name, phone, email,address,img,roomId);

        hotelDbUtil.updateHotel(theHotel);
        listHotels(request, response);
    }
    public void loadHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theHotelsId = request.getParameter("hotelsId");

        Hotel theHotel = hotelDbUtil.getHotel(theHotelsId);

        request.setAttribute("THE_HOTEL", theHotel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-hotel-form.jsp");
        dispatcher.forward(request, response);
    }
    public void addHotel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String img = request.getParameter("img");
        Integer roomId = Integer.valueOf(request.getParameter("roomId"));
        Hotel theHotel = new Hotel(name, phone, email,address,img,roomId);

        hotelDbUtil.addHotel(theHotel);

        listHotels(request, response);
    }

}

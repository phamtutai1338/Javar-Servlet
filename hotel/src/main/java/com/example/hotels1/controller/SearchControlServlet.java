package com.example.hotels1.controller;

import com.example.hotels1.dbutil.HotelDbUtil;
import com.example.hotels1.entity.Hotel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchControlServlet", value = "/SearchControlServlet")
public class SearchControlServlet extends HttpServlet {

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
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            processRequest(request,response);
        }
        catch (Exception e){

        }

    }
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String txtSearch = request.getParameter("txt");
        List<Hotel> hotelList = hotelDbUtil.searchByNameAddress(txtSearch);
        request.setAttribute("HOTEL_LIST",hotelList);
        request.getRequestDispatcher("list-hotel.jsp").forward(request,response);

    }
}

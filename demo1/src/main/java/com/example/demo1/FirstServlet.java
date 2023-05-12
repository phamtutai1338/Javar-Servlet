package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out= response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FirstServlet at"+request.getContextPath()+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        processRequest(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        processRequest(request,response);
    }
}

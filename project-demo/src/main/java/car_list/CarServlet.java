package car_list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import car_list.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.Part;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.OutputStream;
@WebServlet("/cars")
public class CarServlet extends HttpServlet {
    private List<Car> carList;

    public void init() throws ServletException{
        super.init();
        carList = new ArrayList<>();
        carList.add(new Car(1,"...",0.0,"red","image/service-3.jsp"));
        carList.add(new Car(2,"...",0.0, "blue",""));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");

        if(action == null){
            action = "list";
        }

        switch (action){
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createCar(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateCar(request, response);
                break;
            case "delete":
                deleteCar(request, response);
                break;
            default:
                listCars(request, response);
                break;
        }
//        String imageName = request.getParameter("imageName");
//        String imagePath = getServletContext().getRealPath("/image/" + imageName);
//
//        Path imageFilePath = Paths.get(imagePath);
//
//
//        response.setContentType("image/jpeg");
//        response.setContentLength((int) Files.size(imageFilePath));
//
//        // Gửi dữ liệu ảnh về client
//        Files.copy(imageFilePath, response.getOutputStream());


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
//        String uploadPath = getServletContext().getRealPath("") + File.separator + "cars";
//        String imagePath = getServletContext().getRealPath("image");
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
//
//        Part filePart = request.getPart("file");
//        String fileName = filePart.getSubmittedFileName();
//        String filePath = uploadPath + File.separator + fileName;
//        filePart.write(filePath);
//
//        response.getWriter().println("Upload thành công: " + fileName);
//        doGet(request, response);

    }

    private void listCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("carList", carList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String carName = request.getParameter("carName");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        String image = request.getParameter("image");
        int id = carList.size() + 1;

        Car newCar = new Car(id, carName, price, color,image);
        carList.add(newCar);

        response.sendRedirect("cars");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = getCarById(id);

        request.setAttribute("car", car);
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String carName = request.getParameter("carName");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        String image = request.getParameter("image");
        Car car = getCarById(id);

        car.setCarName(carName);
        car.setPrice(price);
        car.setColor(color);
        car.setImage(image);
        response.sendRedirect("cars");
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = getCarById(id);
        carList.remove(car);

        response.sendRedirect("cars");
    }



    private Car getCarById(int id){
        for(Car car : carList){
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }
}
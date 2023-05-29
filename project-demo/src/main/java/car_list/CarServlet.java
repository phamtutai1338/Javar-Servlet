package car_list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.Part;

@WebServlet("/cars")
@MultipartConfig
public class CarServlet extends HttpServlet {
    private List<Car> carList;

    public void init() throws ServletException{
        super.init();
        carList = new ArrayList<>();
        carList.add(new Car(1,"Mazda3",594.0 ,"white","images/mazda3-1-1093.jpg","Bước sang thế hệ thứ 4, Mazda 3 đã có sự thay đổi về kích thước xe Mazda 3. Cụ thể, mẫu xe này tăng thêm về chiều dài tầm 80 mm, chiều cao lại hạ thấp 10mm với biến thể Sedan và 30mm với biến thể Mazda 3 hatchback 2023. Nhờ vào sự điều chỉnh này mà Mazda 3 đã sở hữu hình ảnh thể thao, cuốn hút hơn. Tuy nhiên, không gian nội thất của Mazda 3 cũng kích thước Mazda 3 mà bị hạn chế một chút."));


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
            case"show":
                showCar(request,response);
                break;
            default:
                listCars(request, response);
                break;
        }

    }





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


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
    private void showCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = getCarById(id);

        request.setAttribute("car", car);
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-info.jsp");
        dispatcher.forward(request, response);
    }
    private void createCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String carName = request.getParameter("carName");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        String details= request.getParameter("details");
        int id = carList.size() + 1;

        Part filePart = request.getPart("image");
        String fileName = getFileName(filePart);
        String  uploadDirectory = getServletContext().getRealPath("/images");
        String filePath = uploadFile( filePart, fileName,uploadDirectory);
        String fileURL = "/images/"+fileName;

        Car newCar = new Car(id, carName, price, color,details,fileURL);
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
        String details = request.getParameter("details");
        Car carToUpdate = getCarById(id);

        carToUpdate.setCarName(carName);
        carToUpdate.setPrice(price);
        carToUpdate.setColor(color);
        carToUpdate.setDetails(details);


        Part filePart = request.getPart("image");
        if(filePart != null && filePart.getSize() >0){
            deleteImage(carToUpdate.getImageUrl(), request);

            String fileName = getFileName(filePart);

            String uploadDirectory = getServletContext().getRealPath("/images");


            String filePath = uploadFile( filePart,fileName, uploadDirectory);

            String fileURL = "images/" + fileName;

            carToUpdate.setImageUrl(fileURL);
        }
        response.sendRedirect("cars");
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Car carToDelete = getCarById(id);
        if (carToDelete != null){

            deleteImage(carToDelete.getImageUrl(), request);
            carList.remove(carToDelete);
        }

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
    private void deleteImage(String imageUrl,HttpServletRequest request){
        String uploadDirectory = request.getServletContext().getRealPath("")+ File.separator+"image";
        String imagePath = uploadDirectory +File.separator + imageUrl;
        File imageFile = new File(imagePath);
        if(imageFile.exists()){
            imageFile.delete();
        }
    }
    private String uploadFile(Part filePart,String fileName, String uploadDirectory)throws IOException{
        String filePath = uploadDirectory + File.separator + fileName;
        try (InputStream inputStream = filePart.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(filePath)){
            byte[]buffer = new byte[8192];
            int bytesRead;

            while((bytesRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0 ,bytesRead);
            }
        }
        return filePath;
    }
    private String getFileName(Part part){
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");

        for (String element : elements){
            if(element.trim().startsWith("filename")){
                return element.substring(element.indexOf("=") +1).trim().replace("\"","");
            }
        }
        return "";
    }
}
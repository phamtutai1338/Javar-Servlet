package com.example.studentexam;
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
@WebServlet("/students")
@MultipartConfig
public class StudentServlet  extends HttpServlet {
    private List<Student> studentList;


    public void init() throws ServletException{
        super.init();
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Tai","12" ,"images/anh.jpg",""));

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
                createStudent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case"show":
                showStudent(request,response);
                break;
            default:
                listStudents(request, response);
                break;
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }
    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }
    private void showStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudentById(id);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-details.jsp");
        dispatcher.forward(request, response);
    }
    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        String details= request.getParameter("details");
        int id = studentList.size() + 1;

        Part filePart = request.getPart("image");
        String fileName = getFileName(filePart);
        String  uploadDirectory = getServletContext().getRealPath("/images");
        String filePath = uploadFile( filePart, fileName,uploadDirectory);
        String fileURL = "/images/"+fileName;

        Student newStudent = new Student(id,name,grade,fileURL,details);
        studentList.add(newStudent);

        response.sendRedirect("students");
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudentById(id);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        String grade = request.getParameter("grade");
        String details = request.getParameter("details");
        Student studentToUpdate = getStudentById(id);

        studentToUpdate.setName(name);

        studentToUpdate.setGrade(grade);
        studentToUpdate.setDetails(details);


        Part filePart = request.getPart("image");
        if(filePart != null && filePart.getSize() >0){
            deleteImage(studentToUpdate.getImageUrl(), request);

            String fileName = getFileName(filePart);

            String uploadDirectory = getServletContext().getRealPath("/images");


            String filePath = uploadFile( filePart,fileName, uploadDirectory);

            String fileURL = "images/" + fileName;

            studentToUpdate.setImageUrl(fileURL);
        }
        response.sendRedirect("students");
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student studentToDelete = getStudentById(id);
        if (studentToDelete != null){

            deleteImage(studentToDelete.getImageUrl(), request);
            studentList.remove(studentToDelete);
        }

        response.sendRedirect("students");
    }
    private Student getStudentById(int id){
        for(Student student : studentList){
            if(student.getId() == id){
                return student;
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

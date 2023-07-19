<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 31/05/2023
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Student</title>
    <style>
        .add-button {

            border: solid;
            background-color: green;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            padding: 12px;
            margin-bottom: 0;
            display: inline-block;
            border-radius: 10px;
            text-decoration: none;

        }
        .button {
            border: solid;
            background-color: green;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            display: inline-block;
            border-radius: 10px;
            text-decoration: none;
            padding: 10px;
        }
        show-button{
            background-color: aqua;
        }
        .delete-button {
            background-color: red;
        }
        .edit-button {
            background-color: darkorange;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }
        tr{
            border-bottom: 1px solid grey;
        }
        th {
            text-align: left;
        }
        th,td{
            border-bottom: 1px solid grey;
            padding: 12px;
        }
        .image-container{
            width: 100px;
            height: 100px;
            border: 1px solid #ccc;
            border-radius: 5px;
            overflow: hidden;
        }
        .image-container img {
            width: 50%;
            height: 50%;
            object-fit: cover;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Student List</h1>
<a class="button add-button" href="students?action=new">Add new product</a>
<table>
    <tr>
        <th>Id</th>
        <th> Name</th>
        <th>Grade</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.grade}</td>

            <td><img src="${student.imageUrl}" alt="Student Image" class="image-container"></td>

            <td>
                <a class="button edit-button" href="students?action=edit&id=${student.id}">Edit</a>
                <a class="button delete-button" href="students?action=delete&id=${student.id}" onclick="return confirm('Are you sure you want to delete this StudentList ?')">Delete</a>
                <a class="button show-button" href="students?action=show&id=${student.id}">Show</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

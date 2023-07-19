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
    <title>Detail</title>
    <style>
        a {
            text-decoration: none;
            border: solid;
            background-color: green;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            display: inline-block;
            border-radius: 10px;

            padding: 10px;

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
        table{
            width: 100%;
            border-collapse: collapse;
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
<a href="students">Home</a>
<h2 style="text-align: center">Details</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Grade</th>
        <th>Image</th>
        <th>Detail</th>
    </tr>

        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.details}</td>

            <td><img src="${student.imageUrl}" alt="Student Image" class="image-container"> </td>


        </tr>




</table>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Car List</title>
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

  </style>

</head>
<body>
<h1>Car List</h1>
<a class="button add-button" href="cars?action=new">Add new product</a>
<table>
    <tr>
        <th>Id</th>
        <th>Car Name</th>
        <th>Price</th>
        <th>Color</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach var="car" items="${carList}">
        <tr>
            <td>${car.id}</td>
            <td>${car.carName}</td>
            <td>${car.price}</td>
            <th>${car.color}</th>
            <th>${car.image}</th>



            <td>
                <a class="button edit-button" href="cars?action=edit&id=${car.id}">Edit</a>
                <a class="button delete-button" href="cars?action=delete&id=${car.id}" onclick="return confirm('Are you sure you want to delete this CarList ?')">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
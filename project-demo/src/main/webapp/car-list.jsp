<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Car List</title>
   <link rel="stylesheet" href="css/car.css">

</head>
<body>
<h1 style="text-align: center">Car List</h1>
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
            <td>${car.color}</td>
            <td><img src="${car.imageUrl}" alt="Car Image" class="image-container"> </td>
            <td>
                <a class="button edit-button" href="cars?action=edit&id=${car.id}">Edit</a>
                <a class="button delete-button" href="cars?action=delete&id=${car.id}" onclick="return confirm('Are you sure you want to delete this CarList ?')">Delete</a>
                <a class="button show-button" href="cars?action=show&id=${car.id}">Show</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
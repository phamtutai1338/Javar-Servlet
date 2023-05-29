<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 29/05/2023
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
    <style>

        h2{
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
    </style>
</head>
<body>

<h2>Details</h2>
<table>
<tr>
    <th>Id</th>
    <th>Car Name</th>
    <th>Price</th>
    <th>Color</th>
    <th>Image</th>
    <th>Details</th>
</tr>
<c:forEach var="car" items="${carList}">
<tr>
    <td>${car.id}</td>
    <td>${car.carName}</td>
    <td>${car.price}</td>
    <td>${car.color}</td>
    <td><img src="${car.imageUrl}" alt="Car Image"></td>
    <td>${car.details}</td>
</tr>

</c:forEach>


</table>

</body>
</html>
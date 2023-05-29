<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Add New </title>

</head>
<body>
<h1>Add New</h1>
<c:choose>
  <c:when test="${empty car.id}">
    <form method="POST" action="cars?action=create">
      <label for="carName">Car name: </label>
      <input type="text" id="carName" name="carName">
      <br><br>
      <label for="price">Price: </label>
      <input type="text" id="price" name="price">
      <label for="color">Color: </label>

      <select name="color" id="color-select">
        <option value="">--Hãy chọn một màu sắc--</option>
        <option value="blue">blue</option>
        <option value="black">black</option>
        <option value="red">red</option>
      </select>

      <br><br>
      <br><br>
      <input  type="submit" value="Create">
      <a class="button" href="cars">Cancels</a>
    </form>

  </c:when>
  <c:otherwise>
    <form method="POST" action="cars?action=update" enctype="multipart/form-data">
      <input type="hidden" name="id" value="${car.id}">
      <label for="carName">Car name: </label>
      <input type="text" id="productName" name="productName" value="${car.carName}">
      <br><br>
      <label for="price">Price: </label>
      <input type="text" id="price" name="price" value="${car.price}">
      <br><br>
      <label for="color">Color: </label>
      <select name="color" id="color-select">
        <option value="">--Hãy chọn một màu sắc--</option>
        <option value="blue">blue</option>
        <option value="black">black</option>
        <option value="red">red</option>

      </select>



      <br><br>
      <input type="submit" value="Update">
      <a class="button" href="cars">Cancel</a>
    </form>

    <form method="POST" action="cars?action=delete"><br>
      <input type="hidden" name="id" value="${car.id}">
      <input class="button" type="submit" value="Delete">
    </form>
  </c:otherwise>
</c:choose>

</body>
</html>
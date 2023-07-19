<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 31/05/2023
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student</title>

</head>
<body>
<h1>Student Form</h1>
<c:choose>
    <c:when test="${empty student.id}">
        <h1>Add New</h1>
        <form method="POST" action="students?action=create" enctype="multipart/form-data">
            <label for="name">Student name: </label>
            <input type="text" id="name" name="name">
            <br><br>
            <label for="grade">Grade: </label>
            <input type="text" id="grade" name="grade">

            <label for ="image">Image</label>
            <input type="file" id="image" name="image">
            <br><br>
            <label for="details" >Detail:</label>
            <input type="text" id ="details" name="details">

            <br><br>
            <input  type="submit" value="Create">
            <a class="button" href="students">Cancels</a>
        </form>

    </c:when>
    <c:otherwise>
        <h1>Edit</h1>
        <form method="POST" action="students?action=update" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${student.id}">
            <label for="name"> Name: </label>
            <input type="text" id="name" name="name" value="${student.name}">
            <br><br>
            <label for="grade">Grade: </label>
            <input type="text" id="grade" name="grade" value="${student.grade}">
            <br><br>

            <br><br>
            <label for="image">Image:</label>
            <input type="file" id="image " name="image">
            <br><br>
            <label for="details" id ="details">Detail:</label>
            <input type="text" id ="details" name="details" value="${student.details}">
            <br><br>
            <input type="submit" value="Update">
            <a class="button" href="students">Cancel</a>
        </form>

        <form method="POST" action="students?action=delete"><br>
            <input type="hidden" name="id" value="${student.id}">
            <input class="button" type="submit" value="Delete">
        </form>
    </c:otherwise>

</c:choose>
</body>
</html>

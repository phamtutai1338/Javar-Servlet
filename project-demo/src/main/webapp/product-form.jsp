<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Product Form</title>

</head>
<body>
<h1>Product Form</h1>
<c:choose>
    <c:when test="${empty product.id}">
        <form method="POST" action="products?action=create">
            <label for="productName">Product name: </label>
            <input type="text" id="productName" name="productName">
            <br><br>
            <label for="price">Price: </label>
            <input type="text" id="price" name="price">
            <br><br>
            <input  type="submit" value="Create">
            <a class="button" href="products">Cancels</a>
        </form>
    </c:when>
    <c:otherwise>
        <form method="POST" action="products?action=update">
            <input type="hidden" name="id" value="${product.id}">
            <label for="productName">Product name: </label>
            <input type="text" id="productName" name="productName" value="${product.productName}">
            <br><br>
            <label for="price">Price: </label>
            <input type="text" id="price" name="price" value="${product.price}">
            <br><br>
            <input type="submit" value="Update">
            <a class="button" href="products">Cancel</a>
        </form>
        <form method="POST" action="products?action=delete">
            <input type="hidden" name="id" value="${product.id}">
            <input class="button" type="submit" value="Delete">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
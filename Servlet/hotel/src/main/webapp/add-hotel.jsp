<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 14/06/2023
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Hotel</title>
<%--    <link type="text/css" rel="stylesheet" href="css/style.css">--%>
<%--    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">--%>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2> add hotel</h2>
    </div>
</div>

<div id="container">
    <h3>Add Hotel</h3>

    <form action="HotelControllerServlet" method="GET">
        <input type="hidden" name="command" value="ADD"/>
        <table>
            <tbody>
            <tr>
                <td><label> Name:</label></td>
                <td><input type="text" name="name"/></td>
            </tr>

            <tr>
                <td><label>Phone:</label></td>
                <td><input type="text" name="phone"/></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td><label>Address:</label></td>
                <td><input type="text" name="address"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div  style="clear: both;"></div>

    <p>
        <a href="HotelControllerServlet">Back to List</a>
    </p>
</div>
</body>
</html>

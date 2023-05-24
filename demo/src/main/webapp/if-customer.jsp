<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 19/05/2023
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tagdemo.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
  List <Customer> data = new ArrayList<>();

  data.add(new Customer("Pham","Tai",false));
  data.add(new Customer("Nguyen","Minh",false));
  data.add(new Customer("Chau","Anh",true));

  pageContext.setAttribute("myCustomer",data);
%>

<html>

<body>
<table border="1">
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Gold Customer</th>
  </tr>
  <c:forEach var="tempCustomer" items="${myCustomer}">
    <tr>
      <td>${tempCustomer.firstName}</td>
      <td>${tempCustomer.lastName}</td>
      <td>
        <c:if test="${tempCustomer.goldCustomer}">
          Special Discount
        </c:if>
        <c:if test="${not tempCustomer.goldCustomer}">
          -
        </c:if>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

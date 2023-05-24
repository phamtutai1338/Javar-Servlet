<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 19/05/2023
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-TAG</title>
</head>
<%
  String[] cities={"Mumbai","Singapore","Philadelphia"} ;
  pageContext.setAttribute("myCities",cities);
%>

<body>
<c:forEach var="tempCity" items="${myCities}">
  ${tempCity}<br/>
</c:forEach>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>

<body>
<c:set var="stuff" value="<%= new java.util.Date()%>"/>
Time on the server is ${stuff}


</body>
</html>
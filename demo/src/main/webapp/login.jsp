<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 15/05/2023
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form method="post" action="login.jsp">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <input type="submit" value="Login">
</form>
<%
  String username = request.getParameter("username");
  String password =request.getParameter("password");
  Cookie theCookie = new Cookie("myapp.username",username);
  Cookie theCookiepass = new Cookie("myapp.password",password);
  theCookie.setMaxAge(60*60*24*365); // <---For one year
  theCookiepass.setMaxAge(60*60*24*365);
  //send cookie to browser
  response.addCookie(theCookie);
  response.addCookie(theCookiepass);
%>
<%
  String name = request.getParameter("username");
  out.print("Welcome " + name);

  session.setAttribute("user", name);
%>
<br/>
<%
  String name1 = (String) session.getAttribute("user");
  out.print("Hello " + name1);
%>





</body>
</html>

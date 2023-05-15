<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 12/05/2023
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<%
  // read form data
  String favLang = request.getParameter("favoriteLanguage");
  // create the cookie
     Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);
  // set the life span ... total number of seconds ( yuk!)
  theCookie.setMaxAge(60*60*24*365);    // <-- for one year
   // send cookie to browser
   response.addCookie(theCookie);
%>
<body>


        Thanks! We set your favorite language to: ${param.favoriteLanguage}

        <br/><br/>

        <a href="cookies-homepage.jsp">Return to homepage</a>


</body>


</html>

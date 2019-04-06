<%-- 
    Document   : Error
    Created on : 24-Sep-2018, 15:54:33
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error!</title>
    </head>
    <body>
        <h1 style="color:royalblue">ERROR !!!</h1>
        <%
            String error = (String) request.getAttribute("Error");
        %>
        <h3><%= error%></h3>
        <a href="index.jsp">Back to home page</a>
    </body>
</html>

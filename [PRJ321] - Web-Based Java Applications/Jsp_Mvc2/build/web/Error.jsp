<%-- 
    Document   : Error
    Created on : 21-Sep-2018, 13:30:11
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error Page!</h1>
        <h2>
            <%
                String error = (String)request.getAttribute("Error");
            %>
            <font color="red">
                <%= error %>
            </font>
        </h2>
            <a href="index.jsp">back to login page</a>
    </body>
</html>

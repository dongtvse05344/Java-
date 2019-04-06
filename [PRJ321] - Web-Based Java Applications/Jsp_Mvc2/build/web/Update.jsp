<%-- 
    Document   : Update
    Created on : 24-Sep-2018, 13:27:21
    Author     : xhunt
--%>

<%@page import="dongtv.dto.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update</h1>
        <%
            RegistrationDTO dto = (RegistrationDTO) request.getAttribute("DTO");
        %>
        <form action="MainController" method="POST">
            Username : <input type="text" name="username" value="<%= dto.getUsername()%>" /></br><br>
            
            Name : <input type="text" name="name" value="<%= dto.getName()%>"/></br><br>
            
            Role : <input type="text" name="role" value="<%= dto.getRole()%>"/></br><br>
            
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>

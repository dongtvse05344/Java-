<%-- 
    Document   : create
    Created on : 11-Oct-2018, 13:23:09
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
        <h1>Create Restaurant </h1>
        <p style="color:greenyellow">${requestScope.MESS}</p>
        <form action="MainController" method="POST">
            ID : <input type="text" name="id" value="${requestScope.DTO.restaurantID}"/> </br>
            <p style="color:red">${requestScope.ERROR.restaurantID}</p>
            Name : <input type="text" name="name" value="${requestScope.DTO.restaurantName}"/> </br>
            <p style="color:red">${requestScope.ERROR.restaurantName}</p>
            Address : <input type="text" name="address" value="${requestScope.DTO.address}"/> </br>
            <p style="color:red">${requestScope.ERROR.address}</p>
            District : <input type="text" name="district" value="${requestScope.DTO.district}"/> </br>
            <p style="color:red">${requestScope.ERROR.district}</p>
            <input type="submit" value="Create" name="action"/>
        </form>
            <a href="index.jsp">Back to home</a>
    </body>
</html>

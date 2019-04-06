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
        <h1>Update Restaurant </h1>
        <form action="MainController" method="POST">
            ID : <input type="text" name="id" value="${requestScope.DTO.restaurantID}" readonly="true"/> </br>
            <p style="color:red">${requestScope.ERROR.restaurantID}</p>
            Name : <input type="text" name="name" value="${requestScope.DTO.restaurantName}"/> </br>
            <p style="color:red">${requestScope.ERROR.restaurantName}</p>
            Address : <input type="text" name="address" value="${requestScope.DTO.address}"/> </br>
            <p style="color:red">${requestScope.ERROR.address}</p>
            District : <input type="text" name="district" value="${requestScope.DTO.district}"/> </br>
            <p style="color:red">${requestScope.ERROR.district}</p>
            <input type="submit" value="Update" name="action"/>
            <input type="hidden" name="districtSearch" value="${param.districtSearch}"/> </br>
        </form>
    </body>
</html>

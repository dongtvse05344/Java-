<%-- 
    Document   : setFly
    Created on : 29-Oct-2018, 23:06:27
    Author     : xhunt
--%>

<%@page import="dongtv.dto.ErrorObj"%>
<%@page import="dongtv.dto.FlightDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <%
            FlightDTO dto = (FlightDTO)request.getAttribute("DTO");
            ErrorObj error = (ErrorObj) request.getAttribute("ERROR");
            if(error == null) error = new ErrorObj();
        %>
        
        <h1>Set Fly!</h1>
        <table border="1" cellpadding="5">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Color</th>
                <th>Chair Number</th>
            </tr>
            <tr>
                <td><%= dto.getCode()%></td>
                <td><%= dto.getName()%></td>
                <td><%= dto.getColor()%></td>
                <td><%= dto.getChairNo()%></td>
            </tr>
            
        </table>
            <hr/>
            <form action="InsertFlyController" method="POST">
                Flight Code : <input type="text" name="flightCode" value="<%= dto.getCode()%>" readonly=""/><br/>
                Date Flye : <input type="text" name="dateFly" value="" /><br/>
                <p style="color:red"><%= error.getDateFlyError()%></p>
                Customer Number : <input type="text" name="customerNo" value="" /><br/>
                <p style="color:red"><%= error.getCustomerNoError()%></p>
                <input type="hidden" name="chairNo" value="${requestScope.DTO.chairNo}"/>
                <input type="submit" value="Insert"/>
            </form>
    </body>
</html>

<%-- 
    Document   : setFly
    Created on : 29-Oct-2018, 23:06:27
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
        <h1>Hello ${requestScope.DTO.name}!</h1>
        <table border="1" cellpadding="5">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Color</th>
                <th>Chair Number</th>
            </tr>
            <tr>
                <td>${requestScope.DTO.code}</td>
                <td>${requestScope.DTO.name}</td>
                <td>${requestScope.DTO.color}</td>
                <td>${requestScope.DTO.chairNo}</td>
            </tr>
            
        </table>
            <hr/>
            <form action="InsertFlyController" method="POST">
                Flight Code : <input type="text" name="flightCode" value="${requestScope.DTO.code}" readonly=""/><br/>
                Date Flye : <input type="text" name="dateFly" value="${param.dateFly}" /><br/>
                <p style="color:red">${requestScope.ERROR.dateFlyError}</p>
                Customer Number : <input type="text" name="customerNo" value="${param.customerNo}" /><br/>
                <p style="color:red">${requestScope.ERROR.customerNoError}</p>
                <input type="hidden" name="chairNo" value="${requestScope.DTO.chairNo}"/>
                <input type="submit" value="Insert"/>
            </form>
    </body>
</html>

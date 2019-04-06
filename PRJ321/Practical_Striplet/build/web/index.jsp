<%-- 
    Document   : index
    Created on : 29-Oct-2018, 22:43:14
    Author     : xhunt
--%>

<%@page import="java.util.List"%>
<%@page import="dongtv.dto.FlightDTO"%>
<%@page import="dongtv.dto.FlightDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<FlightDTO> list = (List<FlightDTO>) request.getAttribute("LIST");
        %>
        <h1>Hello World!</h1>
        <%
            if (list != null) {
        %>

        <table border="1" cellpadding="5">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Set Fly</th>
            </tr>
            <%
                for (FlightDTO dto : list) {


            %>

            <tr>
                <td><%= dto.getCode()%></td>
                <td><%= dto.getName()%></td>
                <td>
                    <a href="SetFlyFor?flightCode=<%= dto.getCode()%>">Set Fly</a>
                </td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>

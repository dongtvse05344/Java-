<%-- 
    Document   : index
    Created on : 11-Oct-2018, 13:09:27
    Author     : xhunt
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="shuu" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <a href="create.jsp">Create</a>
        <form action="MainController" method="POST">
            <input type="text" name="districtSearch" value="${param.districtSearch}"/>
            <p style="color:red">${requestScope.ERROR_Search}</p>
            <input type="submit" name="action" value="Search"/>
        </form>
            <shuu:if test="${requestScope.LIST != null}">
                <shuu:if test="${not empty requestScope.LIST}" var="testRecord">
                    <table cellpadding="5" border="1">
                        <tr>
                            <th>No</th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>District</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <shuu:forEach items="${requestScope.LIST}" var="DTO" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${DTO.restaurantID}</td>
                                <td>${DTO.restaurantName}</td>
                                <td>${DTO.address}</td>
                                <td>${DTO.district}</td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="Submit" name="action" value="Edit"/>
                                        <input type="hidden" name="districtSearch" value="${param.districtSearch}"/>
                                        <input type="hidden" name="id" value="${DTO.restaurantID}"/>
                                    </form> 
                                </td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="Submit" name="action" value="Delete"/>
                                        <input type="hidden" name="districtSearch" value="${param.districtSearch}"/>
                                        <input type="hidden" name="id" value="${DTO.restaurantID}"/>
                                    </form> 
                                </td>
                            </tr>
                        </shuu:forEach>
                        
                    </table>
                </shuu:if>
                <shuu:if test="${testRecord == false}">
                    No record found
                </shuu:if>
            </shuu:if>
    </body>
</html>

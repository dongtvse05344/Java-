<%-- 
    Document   : index
    Created on : 29-Oct-2018, 22:43:14
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${requestScope.LIST != null}">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Set Fly</th>
                </tr>
                <c:forEach items="${requestScope.LIST}" var="dto">
                    <tr>
                        <td>${dto.code}</td>
                        <td>${dto.name}</td>
                        <td>
                            <a href="SetFlyFor?flightCode=${dto.code}">Set Fly</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>

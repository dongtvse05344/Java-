<%-- 
    Document   : RegistrationView
    Created on : 16-Sep-2018, 09:42:41
    Author     : xhunt
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration List</title>
    </head>
    <body>
        <h3>Product List</h3>

        <p style="color: red;">${errorString}</p>
        
        <table border="1" cellpadding="5" cellspacing="1" >
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Name</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${list}" var="dto" >
          <tr>
             <td>${dto.username}</td>
             <td>${dto.password}</td>
             <td>${dto.name}</td>
             <td>${dto.role}</td>
             <td>
                <a href="RegistrationEdit?username=${dto.username}>Edit</a>
             </td>
             <td>
                <a href="RegistrationDelete?username=${dto.username}">Delete</a>
             </td>
          </tr>
       </c:forEach>
        </table>
        <jsp:include page="_Footer.jsp"></jsp:include>
    </body>
</html>

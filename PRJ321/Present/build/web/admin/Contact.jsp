<%-- 
    Document   : Home
    Created on : Oct 2, 2018, 9:26:10 AM
    Author     : linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager</title>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/bootstrap.min.css"/>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-2">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="col-10 content">
                    <h1 class="title">Welcome ${sessionScope.USERNAME}</h1>
                    <table class="table">
                        <tr>
                            <th>No</th>
                            <th>Full name</th>
                            <th>Phone</th>
                            <th>Detail</th>
                            <th>Delete</th>
                        </tr>
                        
                    
                    
                        <shuu:forEach items="${requestScope.LIST_CONTACT}" var="dto" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.fullname}</td>
                            <td>${dto.phone}</td>
                            <td><a href="ContactDetail?id=${dto.id}" class="btn btn-outline-info contact-detail">Preview</a></td>
                            <td><a href="ContactDelete?id=${dto.id}" class="btn btn-outline-danger contact-delete">Delete</a></td>
                        </tr>
                    </shuu:forEach>
                        </table>
                </div>
            </div>
        </div>

        <script src="http://localhost:8084/Present/js/jquery-3.1.1.min.js"></script>
        <script src="http://localhost:8084/Present/js/popper.min.js"></script>
        <script src="http://localhost:8084/Present/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="http://localhost:8084/Present/js/contact.js"></script>
    </body>
</html>

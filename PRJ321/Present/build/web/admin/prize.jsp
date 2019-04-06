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
        <title>Admin Home</title>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/prize.css"/>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-2">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="col-10 content">
                    <h1 class="title">Welcome ${sessionScope.USERNAME}</h1>
                    <a href="CreatePrize">Create Prize</a>
                    <div class="row">
                        <shuu:forEach items="${requestScope.LIST}" var="dto">
                            <div class="col-3">
                                <div class="card " style="width: 18rem;">
                                    <img class="card-img-top" src="${dto.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">${dto.name}</h5>
                                        <p class="card-text">${dto.description}..</p>
                                        <a href="EditPrize?id=${dto.id}" class="btn btn-outline-warning">Edit</a>
                                    </div>
                                </div>
                            </div>
                        </shuu:forEach>

                    </div>
                </div>
            </div>
        </div>

        <script src="http://localhost:8084/Present/js/jquery-3.1.1.min.js"></script>
        <script src="http://localhost:8084/Present/js/popper.min.js"></script>
        <script src="http://localhost:8084/Present/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script src="http://localhost:8084/Present/js/prize.js"></script>
    </body>
</html>

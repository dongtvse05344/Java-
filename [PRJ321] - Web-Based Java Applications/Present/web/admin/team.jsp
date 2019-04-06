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
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/team.css"/>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-2">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="col-10 content">
                    <h1 class="title">Welcome ${sessionScope.USERNAME}</h1>
                    <div class="row">
                        <shuu:forEach items="${requestScope.LIST}" var="dto">
                            <shuu:if test="${dto.username == sessionScope.USERNAME}" var="checkAdmin">
                                <div class="col-4 box box-admin">
                                    <div class="card">
                                        <div class="card-header">
                                            ${dto.username}
                                        </div>
                                        <div class="card-body">
                                            <h5 class="card-title">${dto.name}</h5>
                                            <p class="card-text">${dto.email}</p>
                                            <a href="" class="btn btn-outline-success disabled ">Disabled</a>
                                        </div>
                                    </div>
                                </div>
                            </shuu:if>
                            <shuu:if test="${checkAdmin == false}">
                                <div class="col-4 box">
                                    <div class="card">
                                        <div class="card-header">
                                            ${dto.username}
                                        </div>
                                        <div class="card-body">
                                            <h5 class="card-title">${dto.name}</h5>
                                            <p class="card-text">${dto.email}</p>
                                            <a href="unManager?username=${dto.username}" class="btn btn-outline-success lock">Disabled</a>
                                        </div>
                                    </div>
                                </div>
                            </shuu:if>
                            
                        
                        </shuu:forEach>
                        
                    </div>
                </div>
            </div>
        </div>

        <script src="http://localhost:8084/Present/js/jquery-3.1.1.min.js"></script>
        <script src="http://localhost:8084/Present/js/popper.min.js"></script>
        <script src="http://localhost:8084/Present/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        
        <script src="http://localhost:8084/Present/js/team.js"></script>
    </body>
</html>

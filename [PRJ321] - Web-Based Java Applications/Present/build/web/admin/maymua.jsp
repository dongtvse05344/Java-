<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suicide Squad</title>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/event.css"/>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-2">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="col-10 content">
                    <h1 class="title">Welcome ${sessionScope.USERNAME}</h1>
                    
                    <table class="table" id="table-detail">
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Date Started</th>
                            <th>Preview</th>
                        </tr>
                        <shuu:forEach items="${requestScope.LISTEVENT}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.name}</td>
                                <td><fmt:formatDate pattern = "HH:mm dd-MM-yyyy"   value = "${dto.dateStarted}" /></td>
                                <td><a class="btn btn-outline-info" href="Ranking?eventId=${dto.id}">Preview</a></td>
                            </tr>
                        </shuu:forEach>

                    </table>
                </div>
            </div>
        </div>

        <script src="http://localhost:8084/Present/js/jquery-3.1.1.min.js"></script>
        <script src="http://localhost:8084/Present/js/popper.min.js"></script>
        <script src="http://localhost:8084/Present/js/bootstrap.min.js"></script>
        <script src="http://localhost:8084/Present/js/eventAdmin.js"></script>
    </body>
</html>
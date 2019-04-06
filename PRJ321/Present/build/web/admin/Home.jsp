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
                    <a href="CreateEventController">Create event</a>
                    <div class="row search-group">
                        <div class="col-3">
                            <select class="form-control" id="search-event-time">
                                <option selected disabled="">Event time</option>
                                <option value="1">Future</option>
                                <option value="2">Now</option>
                                <option value="3">Past</option>
                                <option value="4">All</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <input type="text" id="search-event-name" class="form-control" placeholder="Enter name event"/>
                        </div>
                    </div>
                    <table class="table box-content" id="table-detail">
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Manager</th>
                            <th>Date Started</th>
                            <th>Preview</th>
                        </tr>
                        <shuu:forEach items="${requestScope.LISTEVENT}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.name}</td>
                                <td>${dto.managerId}</td>
                                <td><fmt:formatDate pattern = "dd MMMM"   value = "${dto.dateStarted}" /></td>
                                <td>
                                    
                                    <a class="btn btn-outline-info" href="DetailAdmin?eventId=${dto.id}">Preview</a>
                                </td>
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

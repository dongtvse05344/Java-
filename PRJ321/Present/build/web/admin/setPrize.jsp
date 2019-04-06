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
        <title>Set Ranking</title>
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
                    <h1 class="title">${requestScope.DTO.name}</h1>
                    <div class="row">
                        <form action="AdminController" method="POST" style="width: 100%">
                        <table class="table table-rank">
                            <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Name</th>
                                    <th>Point</th>
                                    <th>Ranking</th>
                                    <th>Prize</th>
                                </tr>
                            </thead>
                            <tbody>
                                <shuu:if test="${not empty requestScope.RANKS}" var="if1">
                                    <shuu:forEach items="${requestScope.RANKS}" var="user" varStatus="counter">
                                        <tr>
                                            <td>${user.username}</td>
                                            <td>${user.name}</td>
                                            <td>${user.point}</td>
                                            <td>${counter.count}</td>
                                            <td>
                                                <select class="form-control" name="prize">
                                                    <option value="-1" disabled="" selected=>None</option>
                                                    <shuu:forEach items="${requestScope.PRIZES}" var="prize">
                                                        <shuu:if test="${prize.id == user.prizeId}">
                                                            <option value="${prize.id}" selected="">${prize.name}</option>
                                                        </shuu:if>
                                                        <shuu:if test="${prize.id != user.prizeId}">
                                                            <option value="${prize.id}">${prize.name}</option>
                                                        </shuu:if>
                                                    </shuu:forEach>
                                                </select>
                                                <input type="hidden" value="${user.username}" name="username"/>
                                            </td>
                                        </tr>
                                    </shuu:forEach>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>
                                                <input type="submit" name="action" value="Set_Prize" class="btn btn-danger"/>
                                            </td>
                                        </tr>
                                </shuu:if>

                                <shuu:if test="${if1 == false}">

                                    <tr>
                                        <td colspan="3"><p>So sorry !! No one joined this event</p></td>
                                    </tr>
                                </shuu:if>

                            </tbody>
                        </table>
                            <input type="hidden" value="${param.eventId}" name="eventId"/>
                        </form>
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

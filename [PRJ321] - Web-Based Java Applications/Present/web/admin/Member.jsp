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
        <title>Admin Member</title>
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
                    <div class="row search-group">

                        <div class="col-3">
                            <input type="text" id="search-mem-name" class="form-control" placeholder="Enter name member" value="${param.nameSearch}"/>
                        </div>
                    </div>
                    <div id="partial-view">
                        <table class="table" id="table-detail">
                            <tr>
                                <th>No</th>
                                <th>Name</th>
                                <th>Username</th>
                                <th>Active</th>
                                <th>Manager</th>
                            </tr>
                            <shuu:forEach items="${requestScope.PAGE.list}" var="dto" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${dto.name}</td>
                                    <td>${dto.username}</td>
                                    <td>
                                        <shuu:if test="${dto.active == true}">
                                            <input type="submit" value="${dto.active}" class="btn btn-outline-success" id="btnActive"/>
                                        </shuu:if>
                                        <shuu:if test="${dto.active == false}">
                                            <input type="submit" value="${dto.active}" class="btn btn-outline-danger" id="btnActive"/>
                                        </shuu:if>
                                        <input type="hidden" value="${dto.username}"/>
                                    </td>
                                    <td>
                                        <input value="Add" class="btn btn-outline-warning" style="width:80px" id="addManager" />
                                        <input type="hidden" value="${dto.username}"/>
                                    </td>
                                </tr>
                            </shuu:forEach>
                        </table>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <shuu:forEach begin="${requestScope.PAGE.left}" end="${requestScope.PAGE.right}" var="count">
                                    <shuu:if test="${requestScope.PAGE.index == count}">
                                        <li class="page-item disabled"><a class="page-link " href="Member?count=${count}">${count}</a></li>
                                        </shuu:if>
                                        <shuu:if test="${requestScope.PAGE.index != count}">
                                                <li class="page-item"><a class="page-link" href="Member?count=${count}&nameSearch=${param.nameSearch}">${count}</a></li>
                                        </shuu:if>
                                    </shuu:forEach>

                            </ul>
                        </nav>
                    </div>

                </div>
            </div>
        </div>

        <script src="http://localhost:8084/Present/js/jquery-3.1.1.min.js"></script>
        <script src="http://localhost:8084/Present/js/popper.min.js"></script>
        <script src="http://localhost:8084/Present/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="http://localhost:8084/Present/js/member.js"></script>
    </body>
</html>

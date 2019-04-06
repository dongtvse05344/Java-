<%-- 
    Document   : admin
    Created on : Oct 3, 2018, 1:42:44 PM
    Author     : linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:blue">${sessionScope.USER}</h1>
        <h2>Search Form :</h2>
        <form action="MainController" method="POST">
            Fullname :<input type="text" name="txtSearch" value="${param.txtSearch}"/>
            <p style="color:red">${requestScope.INVALID.fullnameError}</p>
            <input type="submit" name="action" value="Search"/>
        </form>
            <c:if test="${requestScope.INFO != null}">
                <c:if test="${not empty requestScope.INFO}" var="data">
                    <table>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.username}</td>
                            <td>${dto.fullname}</td>
                            <td>${dto.role}</td>
                            <td>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="txtUsername" value="${dto.username}"/>
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="submit" value="Delete" name="action"/>
                                </form>
                            </td>
                            <td>
                                <c:url value="MainController" var="Edit">
                                    <c:param name="action" value="Edit"/>
                                    <c:param name="Username" value="${dto.username}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}"/>
                                </c:url>
                                <a href="${Edit}">Edit</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${data == false }">
                    
                </c:if>
            </c:if>
            
        
    </body>
</html>

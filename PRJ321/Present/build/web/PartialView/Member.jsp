
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="shuu"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
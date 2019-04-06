<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
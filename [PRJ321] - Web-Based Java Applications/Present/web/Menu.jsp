<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="shuu"%>
<link rel="stylesheet" type="text/css" href="css/menu.css"/>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
<ul class="menu" style="font-family: 'Indie Flower', cursive!important;">
    <li><a href="Home">Home</a></li>
    <li><a>About</a></li>
    <li><a href="#">Contact</a></li>
    <li><a>Team</a></li>
    <li>
        <shuu:if test="${sessionScope.USERNAME != null}" var="if1">
            <p id="sub">${sessionScope.USERNAME}</p>
            <ul class="sub-menu">
                <li><a href="Profile">Profile</a></li>
                <li><a href="logOut">Log out</a></li>
            </ul>
        </shuu:if>
        <shuu:if test="${if1 == false}">
            <a href="Login">Sign in</a>
        </shuu:if>
    </li>
</ul>

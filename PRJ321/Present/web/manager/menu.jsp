<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="shuu"%>
<link rel="stylesheet" type="text/css" href="css/menuAdmin.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
<ul class="menu">
    <li class="avt text-center">
        <i class="fa fa-user-circle"></i>
        <shuu:if test="${sessionScope.USERNAME != null}" var="if1">
            <a href="logOut">Sign out</a>
        </shuu:if>
        <shuu:if test="${if1 == false}">
            <a href="Login">Sign in</a>
        </shuu:if>
    </li>
    <li ><i class="fa fa-user-tie"></i> ${sessionScope.USERNAME}</li>
    <li class="active"><a href="Manager"><i class="fa fa-tint"></i> Mây Mưa</a></li>
   
</ul>


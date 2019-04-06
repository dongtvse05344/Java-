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
            <a href="Admin">Sign in</a>
        </shuu:if>
    </li>
    
    <shuu:if test="${sessionScope.TOOL == 'MayMua'}" var="if_MayMua">
        <li class="active"><a href="MayMua"><i class="fa fa-tint"></i> Suicide Squad</a></li>
    </shuu:if>
    <shuu:if test="${if_MayMua == false}">
        <li><a href="MayMua"><i class="fa fa-tint"></i> Mây Mưa</a></li>
    </shuu:if>
    
    <shuu:if test="${sessionScope.TOOL == 'Event'}" var="if_Event">
        <li class="active"><a href="Admin"><i class="fa fa-calendar-alt"></i> Event</a></li>
    </shuu:if>
    <shuu:if test="${if_Event == false}">
        <li><a href="Admin"><i class="fa fa-calendar-alt"></i> Event</a></li>
    </shuu:if>
        
    <shuu:if test="${sessionScope.TOOL == 'Member'}" var="if_Member">
        <li class="active"><a href="Member"><i class="fa fa-user-alt"></i> Member</a></li>
    </shuu:if>
    <shuu:if test="${if_Member == false}">
        <li><a href="Member"><i class="fa fa-user-alt"></i> Member</a></li>
    </shuu:if>
    
    <shuu:if test="${sessionScope.TOOL == 'Prize'}" var="if_Prize">
        <li class="active"><a href="Prize"><i class="fa fa-award"></i> Prize</a></li>
    </shuu:if>
    <shuu:if test="${if_Prize == false}">
        <li ><a href="Prize"><i class="fa fa-award"></i> Prize</a></li>
    </shuu:if>
        
    <shuu:if test="${sessionScope.TOOL == 'Team'}" var="if_Team">
        <li class="active"><a href="Team"><i class="fa fa-terminal"></i> Team</a></li>
    </shuu:if>
    <shuu:if test="${if_Team  == false}">
        <li><a href="Team"><i class="fa fa-terminal"></i> Team</a></li>
    </shuu:if>
        
        <shuu:if test="${sessionScope.TOOL == 'Contact'}" var="if_Contact">
        <li class="active"><a href="Contact"><i class="fa fa-file-contract"></i> Contact</a></li>
    </shuu:if>
    <shuu:if test="${if_Contact  == false}">
        <li><a href="Contact"><i class="fa fa-file-contract"></i> Contact</a></li>
    </shuu:if>
</ul>


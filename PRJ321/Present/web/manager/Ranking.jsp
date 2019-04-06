<%-- 
    Document   : DetailRanking
    Created on : 07-Oct-2018, 11:07:26
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
        <link rel="stylesheet" type="text/css" href="css/detailRanking.css"/>
        <style>
            .main{
                height: 100vh;
                background: url('${requestScope.DTO.banner}');
                background-size: cover;
                padding-top: 60px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid main text-center">
            <div class="main-bg"></div>
            <div class="container">
                <div class="row text-center head">
                    <div class="col-6"><p class="Eventname">${requestScope.DTO.name}</p>
                    </div>

                    <div class="col-6">
                        <shuu:if test="${requestScope.EXPIRED != null}" var="if2">
                            <p id="time-left" class="hide">0 : 21 : 4 : 9  </p>
                            <p><fmt:formatDate pattern = "hh:mm dd-MM-yyyy"   value = "${requestScope.DTO.dateEnded}" /></p>
                        </shuu:if>
                        <shuu:if test="${if2 == false}" var="if2">
                            <p id="time-left">0 : 21 : 4 : 9  </p>
                        </shuu:if>


                    </div>

                </div>
                <div class="row">
                    <table class="table table-rank">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Point</th>
                                <th>Ranking</th>
                            </tr>
                        </thead>
                        <tbody>
                            <shuu:if test="${not empty requestScope.RANKS}" var="if1">
                            <form action="updateRanking" method="POST">
                                <input type="hidden" name="eventId" value="${requestScope.DTO.id}"/>
                                <shuu:forEach items="${requestScope.RANKS}" var="dto" varStatus="counter">
                                    <tr>
                                        <td><input type="text" class="form-control-sm" readonly name="username" value="${dto.username}"/></td>
                                        <td><input type="number" class="form-control-sm" name="point" value="${dto.point}"/></td>
                                        <td>${counter.count}</td>
                                    </tr>
                                </shuu:forEach>
                                <tr>
                                    <td colspan="2"><input type="submit" class="btn btn-info" value="Update"/></td>
                                    <td>
                                        <a class="btn btn-outline-dark" href="Profile">Back to home</a>   
                                    </td>   

                                </tr>
                            </form>
                        </shuu:if>

                        <shuu:if test="${if1 == false}">

                            <tr>
                                <td colspan="2"><p>So sorry !! No one joined this event</p></td>
                                <td>
                                    <a class="btn btn-outline-dark" href="Profile">Back to home</a>   
                                </td>   

                            </tr>
                        </shuu:if>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>

        <script src="js/jquery-3.2.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            var countDown =  new Date("${requestScope.DTO.dateEnded}").getTime();
            var x = setInterval(function(){
                var now = new Date().getTime();
                var temp = countDown - now;
                var d = Math.floor(temp / (1000*60*60*24));
                temp = temp % (1000*60*60*24);
                
                var h = Math.floor(temp / (1000*60*60));
                temp = temp % (1000*60*60);
                
                var m = Math.floor(temp / (1000*60));
                temp = temp % (1000*60);
                
                var s = Math.floor(temp / (1000));
                
                document.getElementById("time-left").innerHTML = d + " : " + h + " : " + m +" : " + s ;
                if(temp <0)
                {
                    clearInterval(x);
                    document.getElementById("time-left").innerHTML =  "HET GIO";
                }
             },1000)
        </script>
        <script src="js/ranking.js"></script>
    </body>
</html>

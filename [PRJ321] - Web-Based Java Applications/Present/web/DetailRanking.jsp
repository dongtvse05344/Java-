<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>dongtv | Ranking Page</title>
        <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min_1.css">
        <link rel="stylesheet" type="text/css" href="css/animate.css">
        <link rel="stylesheet" type="text/css" href="css/eventDetail.css">

    </head>

    <body  style="background: url('assets/img/bg_detail.jpg');" >
        <%@include file="Menu.jsp" %>
        <div class="content">
            <div class="container wow fadeInUp delay-03s">
                <div class="row">
                    <h1 class="text-center">${requestScope.DTO.name}</h1>
                    <div id="countdown" data-wow-delay=".3s" data-date="<fmt:formatDate pattern = "MMMM dd, yyyy hh:mm:ss"   value = "${requestScope.DTO.dateEnded}" />"></div>
                </div>
            </div>
            <section>
                <div class="container">
                    <div class="row bort">
                        <table class="table ">
                            <tr>
                                <th>Username</th>
                                <th>Name</th>
                                <th>Point</th>
                                <th>Rank</th>
                            </tr>
                            <shuu:if test="${not empty requestScope.RANKS}" var="if1">
                                <shuu:forEach items="${requestScope.RANKS}" var="dto" varStatus="counter">
                                    <shuu:if test="${dto.username ==sessionScope.USERNAME}" var="if3">
                                        <tr class="highlight">
                                            <td>${dto.username}</td>
                                            <td>${dto.name}</td>
                                            <td>${dto.point}</td>
                                            <td>NO ${counter.count}</td>
                                        </tr>
                                    </shuu:if>
                                    <shuu:if test="${if3== false}">
                                        <tr>
                                            <td>${dto.username}</td>
                                            <td>${dto.name}</td>
                                            <td>${dto.point}</td>
                                            <td>No ${counter.count}</td>
                                        </tr>
                                    </shuu:if>
                                </shuu:forEach>
                            </shuu:if>

                            <shuu:if test="${if1 == false}">

                                <tr>
                                    <td colspan="4" class="text-center"><p>So sorry !! No one joined this event</p></td>
                                </tr>
                            </shuu:if>

                        </table>
                    </div>
                </div>
            </section>
            <section id="about" class="section-padding">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 text-center">
                            <div class="about-title">
                                <h2>Description</h2>
                                <p>${requestScope.DTO.description}</p>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-02s">
                                <div class="img">
                                    <i class="fa fa-map"></i>
                                </div>
                                <h3 class="abt-hd">Location</h3>
                                <p>${requestScope.DTO.location}</p>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-04s">
                                <div class="img">
                                    <i class="fa fa-clock"></i>
                                </div>
                                <h3 class="abt-hd">Date Start </h3>
                                <p><fmt:formatDate pattern = "hh:mm MMMM dd,yyyy"   value = "${requestScope.DTO.dateStarted}" /></p>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-06s">
                                <div class="img">
                                    <i class="fa fa-clock"></i>
                                </div>
                                <h3 class="abt-hd">Date End</h3>
                                <p><fmt:formatDate pattern = "hh:mm MMMM dd,yyyy"   value = "${requestScope.DTO.dateEnded}" /></p>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-08s">
                                <div class="img">
                                    <i class="fa fa-users"></i>
                                </div>
                                <h3 class="abt-hd">Users</h3>
                                <p>${requestScope.DTO.noUser}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
        <footer class="footer">
            <div class="container">
                <div class="row bort">

                    <div class="copyright">
                        © Copyright Maundy Theme. All rights reserved.
                        <div class="credits">
                            <!--
                              All the links in the footer should remain intact. 
                              You can delete the links only if you purchased the pro version.
                              Licensing information: https://bootstrapmade.com/license/
                              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Maundy
                            -->
                            Ăn cắp by <a href="#">dongtvse05344</a>
                        </div>
                    </div>

                </div>
            </div>
        </footer>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/wow.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>

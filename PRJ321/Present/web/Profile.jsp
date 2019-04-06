<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Profile || Present PRJ321</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" >

        <!-- Custom styles for this template -->
        <link href="css/resume.min.css" rel="stylesheet">

    </head>

    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Clarence Taylor</span>
                <span class="d-none d-lg-block">
                    <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="assets/img/profile.jpg" alt="">
                </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#experience">Experience</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#skills">Password</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#awards">Awards</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="Home">Home</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid p-0">

            <section class="resume-section p-3 p-lg-5 d-flex d-column" id="about">
                <div class="my-auto">
                    <h1 class="mb-0">${requestScope.ACCOUNT.username}
                        <span class="text-primary">${requestScope.ACCOUNT.name}</span>
                    </h1>
                    <div class="subheading mb-5">Lô E2a-7, Đường D1 Khu Công nghệ cao, P.Long Thạnh Mỹ, Q.9, TP.HCM , CO 80810 · (028) 7300 5588 ·
                        <a href="mailto:name@email.com">${requestScope.ACCOUNT.email}</a>
                    </div>
                    <p class="lead mb-5">I am experienced in leveraging agile frameworks to provide a robust synopsis for high level overviews. Iterative approaches to corporate strategy foster collaborative thinking to further the overall value proposition.</p>
                    <div class="social-icons">
                        <a href="#">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a href="#">
                            <i class="fab fa-github"></i>
                        </a>
                        <a href="#">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="#">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                    </div>
                </div>
            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="experience">
                <div class="my-auto">
                    <h2 class="mb-5">Experience</h2>

                    <shuu:forEach items="${requestScope.RANKS}" var="rank">
                        <div class="resume-item d-flex flex-column flex-md-row mb-5">
                            <div class="resume-content mr-auto">
                                <h3 class="mb-0">${rank.event.name}</h3>
                                <div class="subheading mb-3">${rank.event.managerId}</div>
                                <p>${rank.event.description}</p>
                            </div>
                            <div class="resume-date text-md-right">
                                <span class="text-primary"><fmt:formatDate pattern = "MMMM yyyy"   value = "${rank.event.dateEnded}" /></span>
                            </div>
                        </div>
                    </shuu:forEach>

                </div>

            </section>

            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="skills">
                <div class="row">
                    <div class="col-md-6">
                        <form action="ChangePasswordController" method="POST">
                            <input type="hidden" name="username" value="${requestScope.ACCOUNT.username}"/>
                            <div class="form-group">
                                <label>Old Password</label>
                                <input name="oldPassword" type="password" class="form-control" placeholder="Enter your password">
                                <p class="text-danger">${requestScope.ERROR.password}</p>
                                <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input name="newPassword" type="password" class="form-control" placeholder="Password">
                                <p class="text-danger">${requestScope.ERROR.newPassword}</p>
                            </div>
                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input name="confirmPassword" type="password" class="form-control" placeholder="Confirm Password">
                                <p class="text-danger">${requestScope.ERROR.confirmPassword}</p>
                            </div>
                            
                            <button type="submit" class="btn btn-outline-dark">Submit</button>
                        </form>
                    </div>
                </div>

            </section>



            <hr class="m-0">

            <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="awards">
                <div class="my-auto">
                    <h2 class="mb-5">Awards &amp; Certifications</h2>
                    <ul class="fa-ul mb-0">
                        <shuu:forEach items="${requestScope.RANKS}" var="rank">
                            <shuu:if test="${rank.prize != null}">
                                <li>
                                    <i class="fa-li fa fa-trophy text-warning"></i>
                                    ${rank.prize.name}</li>
                                </shuu:if>
                            </shuu:forEach>
                    </ul>
                </div>
            </section>

        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="js/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/resume.min.js"></script>
        <script src="js/menu.js"></script>
    </body>

</html>

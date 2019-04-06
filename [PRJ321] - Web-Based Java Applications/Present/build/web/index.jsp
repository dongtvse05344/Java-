<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <link rel="shortcut icon" href="assets/img/logo-icon.png" type="image/x-icon"/>
        <title>HOME || Present PRJ321</title>

        <!-- Google font -->
        <link href="css/font-awesome.min.css" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min_index.css" />
        <link href="https://fonts.googleapis.com/css?family=Charmonman" rel="stylesheet">

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">

        <link rel="stylesheet" href="https://cdn.rawgit.com/daneden/animate.css/v3.1.0/animate.min.css">
        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/index.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <!-- Header -->
        <header id="home">
            <!-- Background Image -->
            <div class="bg-img" style="background-image: url('./assets/img/background1.jpg');">
                <div class="overlay"></div>
            </div>
            <!-- /Background Image -->

            <!-- Nav -->
            <nav id="nav" class="navbar nav-transparent">
                <div class="container">

                    <div class="navbar-header">
                        <!-- Logo -->
                        <div class="navbar-brand">
                            <a href="Profile">
                                <shuu:if test="${sessionScope.USERNAME != null}" var="if1">
                                    <p id="sub" style="font-family: 'Charmonman', cursive;color:white;font-size: 20px;line-height: 40px;">${sessionScope.USERNAME}</p>
                                </shuu:if>
                                <shuu:if test="${if1 == false}">
                                    <img class="logo" src="assets/img/logo.png" alt="logo">
                                    <img class="logo-alt" src="assets/img/logo-alt.png" alt="logo">
                                </shuu:if>

                            </a>
                        </div>
                        <!-- /Logo -->

                        <!-- Collapse nav button -->
                        <div class="nav-collapse">
                            <span></span>
                        </div>
                        <!-- /Collapse nav button -->
                    </div>

                    <!--  Main navigation  -->
                    <ul class="main-nav nav navbar-nav navbar-right">
                        <li><a href="#home">Home</a></li>
                        <li><a href="#future">Comming!</a>
                        </li>
                        <li><a href="#now">Now!</a></li>
                        <li><a href="#past">Past</a></li>

                        <li><a href="#contact">Contact</a></li>
                        <li><a href="Profile">Profile</a></li>
                            <shuu:if test="${sessionScope.USERNAME != null}" var="if1">
                            <li>
                                <a href="logOut">Log Out</a>
                            </li>
                        </shuu:if>
                        <shuu:if test="${if1 == false}">
                            <li>
                                <a href="Login">Sign in</a>
                            </li>
                        </shuu:if>


                    </ul>
                    <!-- /Main navigation -->

                </div>
            </nav>
            <!-- /Nav -->

            <!-- home wrapper -->
            <div class="home-wrapper">
                <div class="container">
                    <div class="row">

                        <!-- home content -->
                        <div class="col-md-10 col-md-offset-1">
                            <div class="home-content">
                                <h1 class="white-text">CLB Suicide Squad <span class="type-text" id="typed3"></span></h1>
                                <h2>FPT <span style="color:#d6d6d6">UNIVERSITY</span></h2>
                                <p class="white-text">Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere.
                                </p>
                                <a href="Register.jsp" class="white-btn">Đăng kí!</a>
                            </div>
                        </div>
                        <!-- /home content -->

                    </div>
                </div>
            </div>
            <!-- /home wrapper -->

        </header>
        <!-- /Header -->


        <!-- Future -->
        <div id="future" class="section md-padding bg-grey">

            <!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <!-- Section header -->
                    <div class="section-header text-center">
                        <h2 class="title">Comming!!...</h2>
                    </div>
                    <!-- /Section header -->
                    <div class="row">
                        <shuu:forEach items="${requestScope.LISTFUTURE.list}" var="dto" varStatus="counter">
                            <!-- blog -->
                            <div class="col-md-4 wow bounceInUp" data-wow-delay="${counter.count/2-0.4}s">
                                <div class="blog">
                                    <div class="blog-img">
                                        <img class="img-responsive" src="${dto.banner}" alt="">
                                    </div>
                                    <div class="blog-content">
                                        <ul class="blog-meta">
                                            <li><i class="fa fa-user"></i>${dto.managerId}</li>
                                            <li><i class="fa fa-clock-o"></i><fmt:formatDate pattern = "MMMM dd"   value = "${dto.dateStarted}" /></li>
                                            <li><i class="fa fa-comments"></i>${dto.noUser}</li>
                                        </ul>
                                        <h3>${dto.name}</h3>
                                        <p class="description">${dto.description}</p>
                                        <a href="MainController?action=Detail&eventId=${dto.id}" class="btn btn-outline-light">Read more</a>
                                    </div>
                                </div>
                            </div>
                            <!-- /blog -->
                        </shuu:forEach>
                    </div>
                    <div class="row">
                        <nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <shuu:forEach begin="${requestScope.LISTFUTURE.left}" end="${requestScope.LISTFUTURE.right}" var="i">
                                    <shuu:if test="${i == requestScope.LISTFUTURE.index}" var="checkIndex2">
                                        <li class="page-item disabled">
                                            <a class="page-link" href="#" tabindex="-1">${i}</a>
                                        </li>

                                    </shuu:if>
                                    <shuu:if test="${checkIndex2 == false}">
                                        <li class="page-item"><a class="page-link future">${i}</a></li>
                                        </shuu:if>
                                    </shuu:forEach>
                            </ul>
                        </nav>
                    </div>



                </div>

                <!-- /Row -->

            </div>
            <!-- /Container -->

        </div>
        <!-- /Blog -->

        <!-- Now -->
        <div id="now" class="section md-padding bg-grey">

            <!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <!-- Section header -->
                    <div class="section-header text-center">
                        <h2 class="title">- Now -</h2>
                    </div>
                    <!-- /Section header -->
                    <div class="row"><shuu:forEach items="${requestScope.LISTNOW.list}" var="dto" varStatus="counter">
                            <!-- Work -->
                            <div class="col-md-6 col-xs-6 work wow bounceInRight" data-wow-delay="${counter.count/2-0.4}s">
                                <img class="img-responsive" src="${dto.banner}" alt="">
                                <div class="overlay"></div>
                                <div class="work-content">
                                    <span>${dto.managerId}</span>
                                    <h3>${dto.name}</h3>
                                    <div class="work-link">
                                        <a class="lightbox" href="MainController?action=Detail&eventId=${dto.id}"><i class="fa fa-search"></i></a>
                                    </div>
                                </div>
                            </div>
                            <!-- /Work -->
                        </shuu:forEach></div>
                    <div class="row"> <nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <shuu:forEach begin="${requestScope.LISTNOW.left}" end="${requestScope.LISTNOW.right}" var="i">
                                    <shuu:if test="${i == requestScope.LISTNOW.index}" var="checkIndex1">
                                        <li class="page-item disabled">
                                            <a class="page-link" href="#" tabindex="-1">${i}</a>
                                        </li>

                                    </shuu:if>
                                    <shuu:if test="${checkIndex1 == false}">
                                        <li class="page-item"><a class="page-link now"">${i}</a></li>
                                        </shuu:if>
                                    </shuu:forEach>

                            </ul>
                        </nav>
                    </div>


                </div>
                <!-- /Row -->

            </div>
            <!-- /Container -->

        </div>
        <!-- /Now -->




        <!-- Past -->
        <div id="past" class="section md-padding">

            <!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <!-- Section header -->
                    <div class="section-header text-center">
                        <h2 class="title">Past</h2>
                    </div>
                    <!-- /Section header -->
                    <div class="row">
                        <shuu:forEach items="${requestScope.LISTPAST.list}" var="dto" varStatus="counter">
                            <!-- team -->
                            <div class="col-sm-6 wow bounceInLeft" data-wow-delay="${counter.count/2-0.4}s">
                                <div class="team">
                                    <div class="team-img">
                                        <img class="img-responsive" src="${dto.banner}" alt="">
                                        <div class="overlay">
                                            <div class="team-social">
                                                <a href="MainController?action=Detail&eventId=${dto.id}"><i class="fa fa-search"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="team-content">
                                        <h3>${dto.name}</h3>
                                        <span>${dto.managerId}</span>
                                    </div>
                                </div>
                            </div>
                            <!-- /team -->
                        </shuu:forEach>
                    </div>
                    <div class="row"><nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <shuu:forEach begin="${requestScope.LISTPAST.left}" end="${requestScope.LISTPAST.right}" var="i">
                                    <shuu:if test="${i == requestScope.LISTPAST.index}" var="checkIndex">
                                        <li class="page-item disabled">
                                            <a class="page-link" href="#" tabindex="-1">${i}</a>
                                        </li>

                                    </shuu:if>
                                    <shuu:if test="${checkIndex == false}">
                                        <li class="page-item"><a class="page-link past">${i}</a></li>
                                        </shuu:if>
                                    </shuu:forEach>

                            </ul>
                        </nav>
                    </div>



                </div>
                <!-- /Row -->

            </div>
            <!-- /Container -->

        </div>
        <!-- /Past -->




        <!-- Numbers -->
        <div id="numbers" class="section sm-padding">

            <!-- Background Image -->
            <div class="bg-img" style="background-image: url('./assets/img/background2.jpg');">
                <div class="overlay"></div>
            </div>
            <!-- /Background Image -->

            <!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <!-- number -->
                    <div class="col-sm-3 col-xs-6">
                        <div class="number">
                            <i class="fa fa-users"></i>
                            <h3 class="white-text"><span class="counter">451</span></h3>
                            <span class="white-text">Happy clients</span>
                        </div>
                    </div>
                    <!-- /number -->

                    <!-- number -->
                    <div class="col-sm-3 col-xs-6">
                        <div class="number">
                            <i class="fa fa-trophy"></i>
                            <h3 class="white-text"><span class="counter">12</span></h3>
                            <span class="white-text">Awards won</span>
                        </div>
                    </div>
                    <!-- /number -->

                    <!-- number -->
                    <div class="col-sm-3 col-xs-6">
                        <div class="number">
                            <i class="fa fa-coffee"></i>
                            <h3 class="white-text"><span class="counter">154</span>K</h3>
                            <span class="white-text">Cups of Coffee</span>
                        </div>
                    </div>
                    <!-- /number -->

                    <!-- number -->
                    <div class="col-sm-3 col-xs-6">
                        <div class="number">
                            <i class="fa fa-file"></i>
                            <h3 class="white-text"><span class="counter">45</span></h3>
                            <span class="white-text">Projects completed</span>
                        </div>
                    </div>
                    <!-- /number -->

                </div>
                <!-- /Row -->

            </div>
            <!-- /Container -->

        </div>
        <!-- /Numbers -->






        <!-- Contact -->
        <div id="contact" class="section md-padding">

            <!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <!-- Section-header -->
                    <div class="section-header text-center">
                        <h2 class="title">Get in touch</h2>
                    </div>
                    <!-- /Section-header -->

                    <!-- contact -->
                    <div class="col-sm-4">
                        <div class="contact">
                            <i class="fa fa-phone"></i>
                            <h3>Phone</h3>
                            <p>512-421-3940</p>
                        </div>
                    </div>
                    <!-- /contact -->

                    <!-- contact -->
                    <div class="col-sm-4">
                        <div class="contact">
                            <i class="fa fa-envelope"></i>
                            <h3>Email</h3>
                            <p>dongtvse05344@fpt.edu.vn</p>
                        </div>
                    </div>
                    <!-- /contact -->

                    <!-- contact -->
                    <div class="col-sm-4">
                        <div class="contact">
                            <i class="fa fa-map-marker"></i>
                            <h3>Address</h3>
                            <p>FPT University</p>
                        </div>
                    </div>
                    <!-- /contact -->

                    <!-- contact form -->
                    <div class="col-md-8 col-md-offset-2" onsubmit="return validate()">
                        <form action="MainController"  method="POST" class="contact-form">
                            <input type="text" class="input" name="name" placeholder="Name" >
                            <input type="email" class="input" name="email" placeholder="Email" >
                            <input type="text" class="input" name="phone" placeholder="Phone" >
                            <textarea class="input" name="message" placeholder="Message" ></textarea>
                            <button class="main-btn">Send message</button>
                            <input type="hidden" name="action" value="CreateContact"/>
                        </form>
                    </div>
                    <script>
                        function validate()
                        {
                            var name = document.getElementsByName("name")[0].value;
                            var email = document.getElementsByName("email")[0].value;
                            var phone = document.getElementsByName("phone")[0].value;
                            var message = document.getElementsByName("message")[0].value;
                            if(name.length <5)
                            {
                                alert("Name is invalid ");
                                return false;
                            }
                            if(email.length == 0)
                            {
                                alert("Email is invalid ");
                                return false;
                            }
                            
                            var patt = new RegExp("^\\d{3}-\\d{7}$");
                            if(!patt.test(phone))
                            {
                                alert("Your phone is invalid ");
                                return false;
                            }
                            if(message.length <10)
                            {
                                alert("Message is invalid ");
                                return false;
                            }
                            return true;
                        }
                    </script>
                    <!-- /contact form -->

                </div>
                <!-- /Row -->

            </div>
            <!-- /Container -->

        </div>
        <!-- /Contact -->


        <!-- Footer -->
        <footer id="footer" class="sm-padding bg-dark">

            <!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <div class="col-md-12">

                        <!-- footer logo -->
                        <div class="footer-logo">
                            <a href="index.html"><img src="assets/img/logo-alt.png" alt="logo"></a>
                        </div>
                        <!-- /footer logo -->


                        <!-- /footer follow -->

                        <!-- footer copyright -->
                        <div class="footer-copyright">
                            <p>Copyright © 2017. All Rights Reserved. Designed by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        </div>
                        <!-- /footer copyright -->

                    </div>

                </div>
                <!-- /Row -->

            </div>
            <!-- /Container -->

        </footer>
        <!-- /Footer -->

        <!-- /Back to top -->

        <!-- Preloader -->
        <div id="preloader">
            <div class="preloader">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </div>
        <!-- /Preloader -->

        <!-- jQuery Plugins -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="https://cdn.rawgit.com/matthieua/WOW/1.0.1/dist/wow.min.js"></script>
        <script>
            new WOW().init();
        </script>
        <script type="text/javascript" src="js/index.js"></script>
        <script src="js/typed.js"></script>
        <script src="js/home.js"></script>

    </body>

</html>

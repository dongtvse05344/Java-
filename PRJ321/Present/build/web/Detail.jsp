
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>dongtv | Comming Soon Page</title>
  <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min_1.css">
  <link rel="stylesheet" type="text/css" href="css/animate.css">
  <link rel="stylesheet" type="text/css" href="css/eventDetail.css">
  
</head>

<body  style="" >
  <%@include file="Menu.jsp" %>
  <div class="content">
    <div class="container wow fadeInUp delay-03s">
      <div class="row">
        <div class="logo text-center">
          <h2>${requestScope.DTO.name}!! Comming Soon</h2>
        </div>
          <div id="countdown" data-wow-delay=".3s" data-date="${requestScope.START}"></div>
        <h2 class="subs-title text-center">Subscribe now to get Recent updates!!!</h2>
        <div class="subcription-info text-center">
          <form class="subscribe_form" action="MainController" method="post">
            
            <shuu:if test="${requestScope.POINT == null}" var="if1">
              <input  value="" placeholder="Register now ..." type="email">
              <input class="subscribe "value="Subscribe!" type="submit">
              <input type="hidden" name="action" value="RE"/>
              <input type="hidden" name="eventId" value="${requestScope.DTO.id}"/>
            </shuu:if>
            <shuu:if test="${if1 == false}">
              <input required="" value="Event is comming ..." name="email" type="email">
              <input disabled="" class="subscribe" name="email" value="Subscribe!" type="submit">
            </shuu:if>


          </form>
          <p class="sub-p">We Promise to never span you.</p>
        </div>
      </div>
    <section>
   </div>
    <section id="about" class="section-padding">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-sm-12 text-center">
            <div class="about-title">
              <h2>How about that</h2>
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
              <p>0 / ${requestScope.DTO.noUser}</p>
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
            Stolen by <a href="#">dongtvse05344</a>
          </div>
        </div>

      </div>
    </div>
  </footer>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/wow.js"></script>
  <script src="js/custom.js"></script>
</body>

</html>

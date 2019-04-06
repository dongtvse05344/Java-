<%-- 
    Document   : login
    Created on : Oct 2, 2018, 9:39:18 AM
    Author     : linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    </head>
    <body style="background: #f3f3f4">
        <%@include file="Menu.jsp" %>
        <div class="container">
            <div class="row content">
                <div class="col-md-6 box-des">
                    <h2>Welcome to <span class="main-color">Mây Mưa</span> Club</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    <small>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</small>
                </div>
                <div class="col-md-6 box-login">
                    <p class="text-danger">${requestScope.error.getMess()}</p>
                    <form action="MainController" method="POST">
                        <div class="form-group">
                            <label >Name :</label>
                            <input name="name" type="text" class="form-control" value="${requestScope.DTO.name}" placeholder="Name">
                            <p class="text-danger">${requestScope.ERROR.getName()}</p>
                        </div>
                        <div class="form-group">
                            <label >Username :</label>
                            <input name="username" type="text" class="form-control" value="${requestScope.DTO.username}" placeholder="Username">
                            <p class="text-danger">${requestScope.ERROR.getUsername()}</p>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input id="password" name="password" type="password" class="form-control" value="${requestScope.DTO.password}"  placeholder="Password">
                            <small class="form-text text-muted">We'll never share your password with anyone else.</small>
                            <p class="text-danger">${requestScope.ERROR.getPassword()}</p>
                        </div>
                        <div class="form-group">
                            <label>Confirm Password</label>
                            <input name="confirmPassword" type="password" class="form-control" placeholder="Confirm Password">
                            <p class="text-danger">${requestScope.ERROR.getConfirmPassword()}</p>
                        </div>
                        <div class="form-group">
                            <label>Email :</label>
                            <input name="email" type="email" class="form-control" value="${requestScope.DTO.email}"  placeholder="Email">
                            <p class="text-danger">${requestScope.ERROR.getEmail()}</p>
                        </div>
                        <input type="submit" name="action" value="Register" class="btn btn-primary"/>
                        <hr/>
                        <a href="Login" class="text-muted ">Login</a>
                        <hr/>
                        <a href="Home" class="text-muted ">Back to home</a>
                        
                    </form>
                        
                </div>
            </div>
        </div>

        <script src="js/jquery-3.2.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/register.js"></script>
    </body>
</html>

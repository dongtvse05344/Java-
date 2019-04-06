<%-- 
    Document   : CreateEvent
    Created on : Oct 2, 2018, 11:32:43 AM
    Author     : linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Event</title>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/Present/css/event.css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-2">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="col-10 content" >
                    <h1 class="title">Create Event!</h1>
                    <p class="text-danger">${requestScope.ERROR.mess}</p>
                    <div class="container">
                        <form action="" method="POST" encType="multipart/form-data">
                            <div class="row">

                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="col-md-6"><div class="form-group">
                                                <label>Banner :</label>
                                                <input onchange="readURL(this);" id="imgUpload" name="file" type="file" accept="image/*" class="form-control-file">
                                            </div>
                                        </div>
                                        <div class="col-md-6">                                        
                                            <img id="example_img" src="assets/img/default.jpg" width="200" height="120"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Description :</label>
                                        <p class="text-danger">${requestScope.ERROR.description}</p>
                                        <textarea name="description" rows="12">${requestScope.DTO.description}</textarea>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input name="name" type="text" class="form-control"  placeholder="Unit,Subject,.." value="${requestScope.DTO.name}">
                                        <p class="text-danger">${requestScope.ERROR.name}</p>
                                    </div>
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label >Date Started</label>
                                                <input name="dateStarted" type="datetime-local" class="form-control" value="${requestScope.timeStart}" >
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label >Date Ended</label>
                                                <input name="dateEnded" type="datetime-local" class="form-control"  value="${requestScope.timeEnd}">
                                                <p class="text-danger">${requestScope.ERROR.dateEnded}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="form-group">
                                                <label class="mr-sm-2" >Manager</label>
                                                <select name="managerId" class="custom-select mr-sm-2" >
                                                    <shuu:forEach var="dto" items="${sessionScope.list}">
                                                        <option value="${dto.username}" >${dto.name}</option>
                                                    </shuu:forEach>
                                                </select>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-8">
                                            <div class="form-group">
                                                <label >Location</label>
                                                <input name="location" type="text" class="form-control" value="${requestScope.DTO.location}"> 
                                                <p class="text-danger">${requestScope.ERROR.location}</p>
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="form-group">
                                                <label >Max User</label>
                                                <input name="NoUser" type="number" class="form-control" value="${requestScope.DTO.noUser}">
                                                <p class="text-danger">${requestScope.ERROR.noUser}</p>
                                            </div>
                                        </div>
                                    </div>

                                    <input type="submit" name="action" value="Create Event" class="btn btn-primary"/>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>



        <script src="http://localhost:8084/Present/js/jquery-3.2.1.slim.min.js"></script>
        <script src="http://localhost:8084/Present/js/popper.min.js"></script>
        <script src="http://localhost:8084/Present/js/bootstrap.min.js"></script>
        <script src="https://cdn.ckeditor.com/4.10.1/standard/ckeditor.js"></script>
        <script src="http://localhost:8084/Present/js/eventAdmin.js"></script>
        <script>
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#example_img')
                                .attr('src', e.target.result)
                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }
        </script>
    </body>
</html>

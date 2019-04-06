
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="shuu"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
            <shuu:forEach items="${requestScope.LISTPAST.list}" var="dto">
                <!-- team -->
                <div class="col-sm-6">
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
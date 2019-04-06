<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
            <shuu:forEach items="${requestScope.LISTFUTURE.list}" var="dto">
                <!-- blog -->
                <div class="col-md-4">
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
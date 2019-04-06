<%@taglib prefix="shuu" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- Container -->
            <div class="container">

                <!-- Row -->
                <div class="row">

                    <!-- Section header -->
                    <div class="section-header text-center">
                        <h2 class="title">- Now -</h2>
                    </div>
                    <!-- /Section header -->
                    <div class="row"><shuu:forEach items="${requestScope.LISTNOW.list}" var="dto">
                            <!-- Work -->
                            <div class="col-md-6 col-xs-6 work">
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
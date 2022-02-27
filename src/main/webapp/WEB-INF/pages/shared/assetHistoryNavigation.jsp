<%--
  Created by IntelliJ IDEA.
  User: uppert
  Date: 10/24/2019
  Time: 5:30 AM
  To change this template use File | Settings | File Templates.
--%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<s:url var ="customMainurl" value ="/resource/css/custom/main.css"/>
<link href="${customMainurl}" rel="stylesheet" type="text/css">
<div class="container" style="margin-top: 50px;">
    <nav aria-label="Users search navigation">
        <ul class="">








            <c:if test="${param.catagoryId == null }">
                <c:choose>
                    <c:when test="${param.pageNo == 1}">
                        <c:set var="previousPage" scope="request" value="1"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="previousPage" scope="request" value="${param.pageNo-1}"/>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${param.pageNo == pageCount}">
                        <c:set var="nextPage" scope="request" value="${param.pageNo}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="nextPage" scope="request" value="${param.pageNo+1}"/>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${param.pageNo <= 3}">
                        <c:set var="firstPage" scope="request" value="1" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="firstPage" scope="request" value="${param.pageNo-2}" />
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${pageCount <= 5}">
                        <c:set var="lastPage" scope="request" value="${pageCount}" />
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${pageCount-param.pageNo == 0}">
                                <c:set var="lastPage" scope="request" value="${param.pageNo}" />
                            </c:when>
                            <c:when test="${pageCount-param.pageNo == 1}">
                                <c:set var="lastPage" scope="request" value="${param.pageNo+1}" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="lastPage" scope="request" value="${param.pageNo+2}" />
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <li class="pagination">
                    <a class="page-link" href="${pageContext.request.contextPath}/asset/assetHistoryPage?pageNo=1">First</a>
                </li>

                <li class="pagination">
                    <a class="page-link" aria-label="Previous"

                       href="${pageContext.request.contextPath}/asset/assetHistoryPage?pageNo=<c:out value="${previousPage}"/>">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>

                <c:forEach begin="${firstPage}" end="${lastPage}" varStatus="loop">

                    <li class="pagination">
                        <a class="page-link" href="${pageContext.request.contextPath}/asset/assetHistoryPage?pageNo=<c:out value="${loop.index}"/>">
                            <c:choose>
                                <c:when test="${loop.index == param.pageNo}">
                                    <b>${loop.index}</b>
                                </c:when>
                                <c:otherwise>
                                    ${loop.index}
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </li>
                </c:forEach>



                <li class="pagination">
                    <a class="page-link" aria-label="Next"
                       href="${pageContext.request.contextPath}/asset/assetHistoryPage?pageNo=<c:out value="${nextPage}"/>">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>

                <li class="pagination">
                    <a class="page-link" href="${pageContext.request.contextPath}/asset/assetHistoryPage?pageNo=<c:out value="${pageCount}"/>">Last </a>
                </li>
            </c:if>
            <c:if test="${param.catagoryId != null }">
                <c:choose>
                    <c:when test="${param.pageNo == 1}">
                        <c:set var="previousPage" scope="request" value="1"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="previousPage" scope="request" value="${param.pageNo-1}"/>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${param.pageNo == pageCount}">
                        <c:set var="nextPage" scope="request" value="${param.pageNo}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="nextPage" scope="request" value="${param.pageNo+1}"/>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${param.pageNo <= 3}">
                        <c:set var="firstPage" scope="request" value="1" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="firstPage" scope="request" value="${param.pageNo-2}" />
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${pageCount <= 5}">
                        <c:set var="lastPage" scope="request" value="${pageCount}" />
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${pageCount-param.pageNo == 0}">
                                <c:set var="lastPage" scope="request" value="${param.pageNo}" />
                            </c:when>
                            <c:when test="${pageCount-param.pageNo == 1}">
                                <c:set var="lastPage" scope="request" value="${param.pageNo+1}" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="lastPage" scope="request" value="${param.pageNo+2}" />
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <li class="pagination">
                    <a class="page-link" href="${pageContext.request.contextPath}/asset/searchAssetHistoryByCatagoryId?catagoryId=<c:out value="${param.catagoryId}"/>&pageNo=1">First</a>
                </li>

                <li class="pagination">
                    <a class="page-link" aria-label="Previous"

                       href="${pageContext.request.contextPath}/asset/searchAssetHistoryByCatagoryId?catagoryId=<c:out value="${param.catagoryId}"/>&pageNo=<c:out value="${previousPage}"/>">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>

                <c:forEach begin="${firstPage}" end="${lastPage}" varStatus="loop">

                    <li class="pagination">
                        <a class="page-link" href="${pageContext.request.contextPath}/asset/searchAssetHistoryByCatagoryId?catagoryId=<c:out value="${param.catagoryId}"/>&pageNo=<c:out value="${loop.index}"/>">
                            <c:choose>
                                <c:when test="${loop.index == param.pageNo}">
                                    <b>${loop.index}</b>
                                </c:when>
                                <c:otherwise>
                                    ${loop.index}
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </li>
                </c:forEach>



                <li class="pagination">
                    <a class="page-link" aria-label="Next"
                       href="${pageContext.request.contextPath}/asset/searchAssetHistoryByCatagoryId?catagoryId=<c:out value="${param.catagoryId}"/>&pageNo=<c:out value="${nextPage}"/>">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>

                <li class="pagination">
                    <a class="page-link" href="${pageContext.request.contextPath}/asset/searchAssetHistoryByCatagoryId?catagoryId=<c:out value="${param.catagoryId}"/>&pageNo=<c:out value="${pageCount}"/>">Last </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
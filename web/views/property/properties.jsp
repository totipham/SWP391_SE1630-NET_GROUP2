<%-- 
    Document   : properties.jsp
    Created on : Jun 19, 2022, 11:18:51 AM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discover - Hostalpy</title>
        <c:import url="../base/headerImport.jsp" />
        <style>
            .card-property {
                border-radius: 15px;
                cursor: pointer;
                transition: 0.05s;
            }

            .card-property:hover {
                transform: scale(1.005);
            }

            .card-property img.thumbnail {
                border-radius: 10px;
            }

            .card-property p {
                font-weight: bold;
                font-size: 24px;
                margin-bottom: 10px;
            }

            .card-property span:first-child {
                font-weight: bold;
                font-size: 24px;
                color: var(--main-bg-color);
            }

            .page-link {
                color: #525252;
            }

            .page-link:hover {
                color: #306844;

            }

            .page-link:focus {
                box-shadow: none;

            }

            .page-item.active .page-link {
                background: #306844;
                border-color: #306844;

            }
        </style>
    </head>
    <body>
        <c:import url="../component/navbar-nosearch.jsp" />
        <div id="main">
            <div class="container mb-4">
                <div class="row">
                    <div class="col-md-4">
                        <%@include file="filter.jsp" %>
                    </div>
                    <div class="col-md-8">
                        <c:if test="${requestScope.keyword != null}">
                            <div class="search-keyword mt-3 mb-4">
                                <span>Search result for</span>
                                <span>"${requestScope.keyword}"</span>
                            </div>
                        </c:if>
                        <c:if test="${requestScope.keyword == null}">
                            <div class="search-keyword mt-3 mb-4">
                                <span>All </span>
                                <span><b>Properties</b></span>
                            </div>
                        </c:if>
                        <div class="search-result">
                            <nav aria-label="...">
                                <ul class="pagination">
                                    <c:set value="${requestScope.page}" var="page" />
                                    <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                        <li class="page-item ${i==page?"active":""}">

                                            <c:if test="${requestScope.advancedSearch != null}">
                                                <a class="page-link" href="properties?keyword=${requestScope.keyword}&created-date-sort=${requestScope.dateSort}&price-sort=${requestScope.priceSort}&fromPrice=${requestScope.minPrice}&toPrice=${requestScope.maxPrice}&kitchen-num=${requestScope.kitchen}&bed-num=${requestScope.bed}&area-num=${requestScope.area}&advanced-search=${requestScope.advancedSearch}&page=${i}">${i}</a>
                                            </c:if>
                                            <c:if test="${requestScope.advancedSearch == null}">
                                                <a class="page-link" href="properties?page=${i}">${i}</a>
                                            </c:if>
                                        </li>
                                    </c:forEach>
                                </ul>

                            </nav>
                            <c:forEach items="${requestScope.listProperty}" var="p">
                                <a href="property?id=${p.id}" class="d-flex flex-row p-3 my-4 card-property bg-white shadow">
                                    <div style="height: 160px; width: 260px; background: url(${baseURL}/assets/images/${p.getImages().get(0).getFileName()});background-repeat: no-repeat;background-size: 100% 100%; border-radius: 10px;"></div>
                                    <div class="px-4 d-flex flex-column aligns-items-center">
                                        <p style="margin-bottom: 0">${p.name}</p>
                                        <p style="font-weight: 400; font-size: 18px;">${p.address}</p>
                                        <div>
                                            <span>₫${p.price}</span>
                                            <span>/month</span>
                                        </div>
                                        <div class="d-flex flex-row mt-auto justify-content-between w-100">

                                            <div>
                                                <img src="${baseURL}/assets/images/area-icon.png" alt="">
                                                <span>${p.area}m2</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                            <nav aria-label="...">
                                <ul class="pagination">
                                    <c:set value="${requestScope.page}" var="page" />
                                    <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                        <li class="page-item ${i==page?"active":""}">

                                            <c:if test="${requestScope.advancedSearch != null}">
                                                <a class="page-link" href="properties?keyword=${requestScope.keyword}&created-date-sort=${requestScope.dateSort}&price-sort=${requestScope.priceSort}&fromPrice=${requestScope.minPrice}&toPrice=${requestScope.maxPrice}&kitchen-num=${requestScope.kitchen}&bed-num=${requestScope.bed}&area-num=${requestScope.area}&advanced-search=${requestScope.advancedSearch}&page=${i}">${i}</a>
                                            </c:if>
                                            <c:if test="${requestScope.advancedSearch == null}">
                                                <a class="page-link" href="properties?page=${i}">${i}</a>
                                            </c:if>
                                        </li>
                                    </c:forEach>
                                </ul>

                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>

            const labels = [
            <c:forEach items="${requestScope.priceTrendingList}" var="pt">
                '₫${pt.price}',
            </c:forEach>
            ]; //Change label for x-axis here

            const data = {
                labels: labels,
                datasets: [
                    {
                        label: 'Frequency',
                        data: [
            <c:forEach items="${requestScope.priceTrendingList}" var="pt">
                ${pt.frequency},
            </c:forEach>

                        ], //Dataset relate to each label
                        borderColor: "",
                                backgroundColor: "#b0b0b0"
                    }
                ]
            };

            const config = {
                type: 'bar',
                data: data,
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        title: {
                            display: true,
                            text: ''
                        }
                    }
                }
            };

            const myChart = new Chart(
                    document.getElementById('myAreaChart'),
                    config
                    );
        </script>

        <jsp:include page="../base/footerImport.jsp" />
    </body>
</html>

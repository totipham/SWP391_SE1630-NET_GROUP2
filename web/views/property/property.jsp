<%-- 
    Document   : property
    Created on : Sep 30, 2022, 1:02:59 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>
        <title>${requestScope.property.name} - Hostalpy</title>
        <style>
            .utilities-fee {
                border-radius: 20px;
            }

            .utilities-fee .utilities-fee--row span:nth-of-type(2){
                float: right;
            }

            .request-status {
                border-radius: 20px;
                padding: 25px;
            }

            .property-image {
                position: relative;
            }

            .property-image a {
                color: #fff;
                font-size: 24px;
                position: absolute;
                top: 10px;
                right: 10px;
                z-index: 9;
            }

            .property-image i:hover {
                color: #e8e8e8;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar.jsp" />
        <c:set var="p" scope="request" value="${property}" />
        <div class="container mt-4">
            <div class="row">
                <div class="col-md-7">
                    <div class="property-image">
                        <a href="report?type=property&id=${p.id}" title="Report ${p.name}"><i class="fa-solid fa-flag"></i></a>
                        <div class="fotorama">
                            <c:forEach items="${p.images}" var="i">
                                <img src="${baseURL}/assets/images/${i.fileName}">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="row my-5">
                        <div class="col-md-7">
                            <h3><b>🏡${p.name}</b></h3>
                            <p style="font-weight: 400; font-size: 16px;">${p.address}</p>
                            <div class="my-3">
                                <span style="font-size: 20px"><b>₫${p.price}</b></span>
                                <span>/month</span>
                            </div>
                            <p><i>${p.description}</i></p>
                        </div>
                        <div class="col-md-5">

                            <h5 class="mb-3">Owner</h5>
                            <div
                                class="d-flex flex-row align-items-center justify-content-between shadow p-3 mb-5 owner-info">
                                <img 
                                    src="${baseURL}/assets/images/${p.host.avatar != null ? p.host.avatar : "avatar.png"}" 
                                    alt="Host Avatar" 
                                    class="rounded-circle" 
                                    width="60"
                                    />
                                <div>
                                    <p><b>${p.host.name}</b></p>
                                    <p>@${p.host.username}</p>
                                </div>
                                <div>
                                    <button class="btn btn-message">
                                        <a href="mailto:${p.host.email}">
                                            <i class="fa-solid fa-message"></i>
                                        </a>
                                    </button>
                                    <button class="btn btn-call">
                                        <a href="tel:${p.host.phone}">
                                            <i class="fa-solid fa-phone"></i>
                                        </a>
                                    </button>
                                </div>
                            </div>
                            <h5 class="mb-3">Utilities Fee</h5>
                            <div class="utilities-fee bg-white shadow p-3">
                                <c:forEach items="${p.utilities}" var="u">
                                    <div class="my-2 utilities-fee--row">
                                        <span><b>${u.name}:</b></span><span>${u.price}VND/${u.period}</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <iframe style="border-radius: 20px" class="shadow mb-4" width="100%" height="30%" style="border:0"
                            loading="lazy" allowfullscreen referrerpolicy="no-referrer-when-downgrade"
                            src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAVR2X4a2N4zwtogFLmFXeOjbbIKqW06iw&q=`${p.name}, ${p.name}`">
                    </iframe>
                    <div class="text-center my-3">
                        <button class="btn btn-success my-3">Send Renting Request</button>
                    </div>
                    <%--<c:if test="${requestScope.state != null}">--%>
                    <jsp:include page="requeststatus.jsp" />
                    <%--</c:if>--%>
                    <%--<c:if test="${requestScope.state == null}">--%>
                    <%--<jsp:include page="requestStatus.jsp" />--%>
                    <%--</c:if>--%>
                    <!--                    <div class="recommend-list">
                                            <h5 class="mb-3">Recommend List</h5>
                                            <a href="property.html" class="d-flex flex-row p-3 my-4 card-property bg-white shadow">
                                                <div style="height: 140px; width: 240px; background: url(images/hlap.jpg);background-repeat: no-repeat;background-size: 100% 100%; border-radius: 10px;"></div>
                                                <div class="px-4 d-flex flex-column aligns-items-center">
                                                    <p style="margin-bottom: 0">Hoa Lac Apartment</p>
                                                    <p style="font-weight: 400; font-size: 14px;">Thạch Hoà, Thạch Thất, Hà Nội</p>
                                                    <div>
                                                        <span>₫4,000,000</span>
                                                        <span>/month</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>-->
                </div>
            </div>
        </div>
    </body>
</html>

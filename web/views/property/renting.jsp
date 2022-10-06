<%-- 
Document   : property
Created on : Sep 30, 2022, 1:02:59 PM
Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>
        <title>Request ${requestScope.property.name} - Hostalpy</title>
        <style>
            .form-container {
                padding: 30px;
                border-radius: 20px;

            }

            .form-container span{
                font-weight: 500;
            }

            .form-container input{
                background: #f7f7f7;
                width: 100%;
                display: block;
                margin-block: 10px;
            }

            .form-container input[type='submit']{
                width: 30%;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar-nosearch.jsp" />
        <c:set var="p" scope="request" value="${property}" />
        <c:set var="u" scope="request" value="${user}" />
        <div class="container mt-2">
            <div class="row">
                <div class="col-md-4">
                    <div class="property-card shadow my-2">
                        <a href="property?id=${p.id}">
                            <div class="property-card__thumbnail">
                                <img src="${baseURL}/assets/images/${p.getImages().get(0).getFileName()}" alt="Thumbnail">
                            </div>
                            <div class="property-card__information">
                                <div class="property-card__information__short">
                                    <span>${p.getType().getType()}</span>
                                    <span>•</span>
                                    <span>${p.area}m2</span>
                                </div>
                                <span class="property-card__information__name">${p.name}</span>
                                <span class="property-card__information__address">${p.address}</span>
                                <div class="property-card__information__bottom">
                                    <span>${p.price}₫/month</span>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="form-container shadow">
                        <div class="text-center">
                            <h3 class="mb-3">Renting Request Form</h3>
                        </div>
                        <form action="renting" method="POST">
                            <input type="text" name="pid" value="${p.id}" hidden />
                            <input type="text" name="uid" value="${u.id}" hidden />
                            <span>Fullname:</span>
                            <input type="text" name="name" value="${u.name}" placeholder="Name *" minlength="3" maxlength="20" required />
                            <span>Email:</span>
                            <input type="email" name="email" value="${u.email}" placeholder="Email *" minlength="11" maxlength="200"
                                   required />
                            <span>Phone:</span>
                            <input type="text" name="phone" value="${u.phone}" placeholder="Phone *" pattern="0[35789]{1}[0-9]{8}" />
                            <span>Address:</span>
                            <input type="text" name="address" value="${u.address}" placeholder="Address *" minlength="10" maxlength="30"
                                   required />
                            <p style="color: red">${requestScope.error}</p>
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary mt-5 mx-auto" value="Send Renting Request">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

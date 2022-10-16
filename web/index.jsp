<%-- 
    Document   : index
    Created on : Sep 27, 2022, 3:11:50 PM
    Author     : DucPTMHE160517
--%>
<%@page import="dal.IPropertyDAO"%>
<%@page import="dal.impl.PropertyDAOImpl"%>
<%@page import="model.Property"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hostalpy</title>
    <%
            IPropertyDAO pd = new PropertyDAOImpl();
            
            List <Property> list = pd.getAllProperties();
            request.setAttribute("list", list);
    %>
    <jsp:include page="views/base/headerImport.jsp" />
    <style>

    </style>
</head>


<body>
    <jsp:include page="views/component/navbar.jsp" />
    <div id="main">
        <div class="container-fluid">
            <span class="text-2xl font-semibold">Rental Spaces</span>
            <div class="grid grid-cols-4 gap-4 my-3">


                <c:forEach items="${requestScope.list}" var="p">
                    <div class="col-span-1">
                        <div class="property-card shadow-lg border-none my-2">
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
                                    <span class="text-2xl font-semibold">${p.name}</span>
                                    <span class="property-card__information__address">${p.address}</span>
                                    <div class="property-card__information__bottom">
                                        <span>${p.price}₫/month</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="footer">

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
    crossorigin="anonymous"></script>
</body>

</html>
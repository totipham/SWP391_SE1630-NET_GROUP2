<%-- 
    Document   : index
    Created on : Sep 27, 2022, 3:11:50 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hostalpy</title>
    <jsp:include page="views/base/headerImport.jsp" />
    <style>
        
    </style>
</head>


<body>
    <jsp:include page="views/component/navbar.jsp" />
    <div id="main">
        <div class="container-fluid">
            <span class="part-title">Rental Spaces</span>
            <div class="row my-3">
                <div class="col-md-3">
                    <div class="property-card shadow my-2">
                        <div class="property-card__thumbnail">
                            <img src="${baseURL}/assets/images/thumbnail.jpg" alt="Thumbnail">
                        </div>
                        <div class="property-card__information">
                            <div class="property-card__information__short">
                                <span>APARTMENT</span>
                                <span>•</span>
                                <span>150m2</span>
                            </div>
                            <span class="property-card__information__name">KTX Ông Bà</span>
                            <span class="property-card__information__address">Thạch Hoà, Thạch Thất, Hà Nội</span>
                            <div class="property-card__information__bottom">
                                <span>3,000,000đ</span>
                                <a href="property.html">View Details</a>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        <div class="footer">
            
        </div>
    </div>
    <script>
        window.onload = function(){
            var popup = document.getElementById('alert-box');
            var overlay = document.getElementById('backgroundOverlay');
            var openButton = document.getElementById('alert-btn');
            backgroundOverlay.style.display = "none";
            document.onclick = function(e){
                if(e.target.id === 'backgroundOverlay'){
                    popup.style.display = 'none';
                    overlay.style.display = 'none';
                }
                if(e.target === openButton){
                    popup.style.display = 'block';
                    overlay.style.display = 'block';
                }
            };
        };

    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
        crossorigin="anonymous"></script>
</body>

</html>
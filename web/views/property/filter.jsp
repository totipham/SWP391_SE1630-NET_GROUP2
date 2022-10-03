<%-- 
    Document   : filter.jsp
    Created on : Jun 19, 2022, 11:18:51 AM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="${baseURL}/assets/css/slider.css">
<form action="properties" method="GET">
    <input type="text" class="shadow mb-4 w-100" name="keyword" value="${requestScope.keyword}" placeholder="Enter keyword..." required/>
    <c:if test="${requestScope.keyword != null}">
        <iframe class="shadow" width="100%" height="30%" style="border:0" loading="lazy"
                allowfullscreen referrerpolicy="no-referrer-when-downgrade"
                src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAVR2X4a2N4zwtogFLmFXeOjbbIKqW06iw&q=${requestScope.keyword}">
        </iframe>
    </c:if>
    <div class="d-flex flex-row justify-content-between align-items-center mt-3">
        <button class="btn btn-light shadow-sm disabled mx-1"><b>Sort</b></button>
        <select class="btn btn-light shadow-sm form-select mx-1" name="created-date-sort">
            <option ${requestScope.dateSort == -1 ? "selected" : null}>Created</option>
            <option value="lastest" ${requestScope.dateSort == 0 ? "selected" : null}>Lastest</option>
            <option value="oldest" ${requestScope.dateSort == 1 ? "selected" : null}>Oldest</option>
        </select>
        <select class="btn btn-light shadow-sm form-select mx-1" name="price-sort">
            <option ${requestScope.dateSort == -1 ? "selected" : null}>Price</option>
            <option value="lowest-first" ${requestScope.priceSort == 1 ? "selected" : null}><b>$</b> Lowest</option>
            <option value="highest-first" ${requestScope.priceSort == 0 ? "selected" : null}><b>$</b> Highest</option>
        </select>
    </div>
    <div class="chart-area">
        <canvas  style="width: 100%; height:100%" id="myAreaChart" />
    </div>
    <div class="price-range-filter">
        <div class="range_container mx-auto mt-5">
            <div class="sliders_control">
                <input id="fromSlider" type="range" value="${requestScope.minPrice == null ? 600000 : requestScope.minPrice}" min="0" max="10000000" />
                <input id="toSlider" type="range" value="${requestScope.maxPrice == null ? 3000000 : requestScope.maxPrice}" min="0" max="10000000" />
            </div>
            <div class="form_control">
                <div class="form_control_container">
                    <div class="form_control_container__time">Min Price:</div>
                    <input name="fromPrice" class="form_control_container__time__input bg-white shadow-sm mx-1" style="width: 200px"
                           type="text" id="fromInput" value="${requestScope.minPrice == null ? 600000 : requestScope.minPrice}" min="0" max="10000000" />
                </div>
                <div class="form_control_container">
                    <div class="form_control_container__time">Max Price:</div>
                    <input name="toPrice" class="form_control_container__time__input bg-white shadow-sm mx-1" style="width: 200px"
                           type="text" id="toInput" value="${requestScope.maxPrice == null ? 3000000 : requestScope.maxPrice}" min="0" max="10000000" />
                </div>
            </div>
        </div>
    </div>
    <div class="utilities-filter d-flex flex-row justify-content-between mt-2">
        <div>
            <img src="${baseURL}/assets/images/area-icon.png" alt="">
            <input type="text" pattern="\d*" class="shadow mb-4 d-inline" name="area-num" value="${requestScope.area == -1 ? '': requestScope.area}"
                   maxlength="2" />
        </div>
    </div>
    <input name="advanced-search" value="1" hidden />
    <button type="submit" class="btn btn-primary">Search</button>
</form>
<script src="${baseURL}/assets/js/slider.js"></script>
<%-- 
    Document   : filter.jsp
    Created on : Jun 19, 2022, 11:18:51 AM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="${baseURL}/assets/css/slider.css">

<form action="search" method="GET">
    <div class="flex flex-row gap-3">
        <input type="text" class="mb-4 w-[100%] px-3 bg-[#eee]" name="keyword" value="${requestScope.keyword}" placeholder="Enter keyword..." required/>
        <input type="submit" class="bg-primary cursor-pointer text-white px-5 py-3 rounded" value="Search" />

    </div>
</form>
<c:if test="${requestScope.keyword != null}">
    <iframe class="shadow rounded-lg" width="100%" height="30%" style="border:0" loading="lazy"
            allowfullscreen referrerpolicy="no-referrer-when-downgrade"
            src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAVR2X4a2N4zwtogFLmFXeOjbbIKqW06iw&q=${requestScope.keyword}">
    </iframe>
</c:if>
<form class="bg-white px-5 py-3 border border-5 border-[#ddd] mt-5 rounded-lg" action="filter" method="GET">
    <div class="flex flex-row justify-between items-center mt-3">
        <div class="bg-transparent mx-1 inline px-5 py-3 rounded"><b>Sort By</b></div>
        <select class="btn btn-light bg-[#eee] form-select mx-1 border border-[3px] border-[#ddd] outline-none rounded" name="created-date-sort">
            <option ${requestScope.dateSort == -1 ? "selected" : null}>Created</option>
            <option value="lastest" ${requestScope.dateSort == 0 ? "selected" : null}>Lastest</option>
            <option value="oldest" ${requestScope.dateSort == 1 ? "selected" : null}>Oldest</option>
        </select>
        <select class="btn btn-light bg-[#eee] form-select mx-1 border border-[3px] border-[#ddd] outline-none rounded" name="price-sort">
            <option ${requestScope.dateSort == -1 ? "selected" : null}>Price</option>
            <option value="lowest-first" ${requestScope.priceSort == 1 ? "selected" : null}><b>$</b> Lowest Price</option>
            <option value="highest-first" ${requestScope.priceSort == 0 ? "selected" : null}><b>$</b> Highest Price</option>
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
                    <span class="text-black">Min Price:</span>
                    <input name="fromPrice" class="text-black px-3 form_control_container__time__input bg-white shadow-sm mx-1 text-center" style="width: 200px; background: #eee"
                           type="text" id="fromInput" value="${requestScope.minPrice == null ? 600000 : requestScope.minPrice}" min="0" max="10000000" />
                </div>
                <div class="form_control_container">
                    <span class="text-black">Max Price:</span>
                    <input name="toPrice" class="text-black px-3 form_control_container__time__input bg-white shadow-sm mx-1 text-center" style="width: 200px; background: #eee"
                           type="text" id="toInput" value="${requestScope.maxPrice == null ? 3000000 : requestScope.maxPrice}" min="0" max="10000000" />
                </div>
            </div>
        </div>
    </div>
    <div class="flex flex-col mt-3">
        <span>Area: </span>
        <input type="text" pattern="\d*" class="text-black px-3 shadow mb-4 w-24 text-center bg-[#eee]" name="area-num" value="${requestScope.area == -1 ? '': requestScope.area}"
               maxlength="2" />
    </div>
    <input name="advanced-search" value="1" hidden />
    <button type="submit" class="bg-primary text-white px-5 py-3 rounded ">Filter</button>
</form>
<script src="${baseURL}/assets/js/slider.js"></script>

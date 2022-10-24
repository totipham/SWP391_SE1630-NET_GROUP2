<%-- 
    Document   : host/dashboard
    Created on : Oct 9, 2022, 9:39:50 PM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!--begin::Head-->
    <head>
        <jsp:include page="../base/headImport.jsp" />
    </head>
    <!-- end::Header -->
    <!--begin::Body-->
    <body id="kt_body" class="header-fixed header-tablet-and-mobile-fixed aside-fixed">
        <!--begin::Main-->
        <div class="d-flex flex-column flex-root">
            <!--begin::Page-->
            <div class="page d-flex flex-row flex-column-fluid">
                <jsp:include page="../component/aside.jsp" />
                <!--begin::Wrapper-->
                <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
                    <jsp:include page="../component/header.jsp" />
                    <!--begin::Content-->
                    <div class="content d-flex flex-column flex-column-fluid fs-6" id="kt_content">
                        <!--begin::Container-->
                        <div class="container" id="kt_content_container">
                            <!--begin::Row-->
                            <div class="row g-5 g-xl-10 mb-xl-10">
                                <!--begin::Col-->
                                <div class="col-md-6 col-lg-6 col-xl-6 col-xxl-3 mb-md-5 mb-xl-10">
                                    <!--begin::Card widget 6-->
                                    <div class="card card-flush h-md-50 mb-5 mb-xl-10">
                                        <!--begin::Header-->
                                        <div class="card-header pt-5">
                                            <!--begin::Title-->
                                            <div class="card-title d-flex flex-column">
                                                <!--begin::Info-->
                                                <div class="d-flex align-items-center">
                                                    <!--begin::Amount-->
                                                    <span class="fs-2hx fw-bold text-dark me-2 lh-1 ls-n2">${requestScope.numberOfReq}</span>
                                                    <!--end::Amount-->
                                                </div>
                                                <!--end::Info-->
                                                <!--begin::Subtitle-->
                                                <span class="text-gray-400 pt-1 fw-semibold fs-6">Request (last 7 days)</span>
                                                <!--end::Subtitle-->
                                            </div>
                                            <!--end::Title-->
                                        </div>
                                        <!--end::Header-->
                                        <!--begin::Card body-->
                                        <div class="card-body d-flex align-items-end px-0 pb-0">
                                            <!--begin::Chart-->
                                            <div id="request_daily_chart" class="w-100" style="height: 80px"></div>
                                            <!--end::Chart-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Card widget 6-->
                                    <!--begin::Card widget 7-->
                                    <div class="card card-flush h-md-50 mb-xl-10">
                                        <!--begin::Header-->
                                        <div class="card-header pt-5">
                                            <!--begin::Title-->
                                            <div class="card-title d-flex flex-column">
                                                <!--begin::Amount-->
                                                <span class="fs-2hx fw-bold text-dark me-2 lh-1 ls-n2">${requestScope.numberOfRents}</span>
                                                <!--end::Amount-->
                                                <!--begin::Subtitle-->
                                                <span class="text-gray-400 pt-1 fw-semibold fs-6">New Renters This
                                                    Month</span>
                                                <!--end::Subtitle-->
                                            </div>
                                            <!--end::Title-->
                                        </div>
                                        <!--end::Header-->
                                        <!--begin::Card body-->
                                        <div class="card-body d-flex flex-column justify-content-end pe-0">
                                            <!--begin::Title-->
                                            <span class="fs-6 fw-bolder text-gray-800 d-block mb-2">Today’s Renter</span>
                                            <!--end::Title-->
                                            <!--begin::Users group-->
                                            <div class="symbol-group symbol-hover flex-nowrap">
                                                <c:set var="remain" value="0" />
                                                <c:forEach var="user" items="${requestScope.todayRenterList}"  varStatus="theCount">
                                                    <c:if test="${theCount.count >= 8}">
                                                        <c:set var="remain" value="${remain+1}" />
                                                    </c:if>
                                                    <c:if test="${theCount.count < 8}">
                                                        <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                             title="${user.name}">
                                                            <img alt="Pic" src="${baseURL}/assets/images/${user.avatar}" />
                                                        </div>
                                                    </c:if>

                                                </c:forEach>
                                                <c:if test="${remain > 0}">
                                                    <a href="#" class="symbol symbol-35px symbol-circle" data-bs-toggle="modal"
                                                       data-bs-target="#kt_modal_view_users">
                                                        <span
                                                            class="symbol-label bg-light text-gray-400 fs-8 fw-bold">+${remain}</span>
                                                    </a>
                                                </c:if>
                                            </div>
                                            <!--end::Users group-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Card widget 7-->
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-lg-12 col-xl-12 col-xxl-9 mb-5 mb-xl-0">
                                    <!--begin::Chart widget 3-->
                                    <div class="card card-flush overflow-hidden h-md-100">
                                        <!--begin::Header-->
                                        <div class="card-header py-5">
                                            <!--begin::Title-->
                                            <h3 class="card-title align-items-start flex-column">
                                                <span class="card-label fw-bold text-dark">Income This Months</span>
                                            </h3>
                                            <!--end::Title-->
                                        </div>
                                        <!--end::Header-->
                                        <!--begin::Card body-->
                                        <div class="card-body d-flex justify-content-between flex-column pb-1 px-0">
                                            <!--begin::Statistics-->
                                            <div class="px-9 mb-1">
                                                <!--begin::Statistics-->
                                                <div class="d-flex mb-2">
                                                    <span class="fs-4 fw-semibold text-gray-400 me-1">đ</span>
                                                    <span class="fs-2hx fw-bold text-gray-800 me-2 lh-1 ls-n2">${requestScope.totalIncome}M</span>
                                                </div>
                                                <!--end::Statistics-->
                                            </div>
                                            <!--end::Statistics-->
                                            <!--begin::Chart-->
                                            <div id="rents_this_month_chart" class="min-h-auto ps-4 pe-6" style="height: 300px">
                                            </div>
                                            <!--end::Chart-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Chart widget 3-->
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Row-->
                            <!--begin::Row-->
                            <div class="row g-xl-8">
                                <!--begin:::Col-->
                                <div class="">
                                    <!--begin::List Widget 3-->
                                    <div class="card card-flush mb-5 mb-xl-8">
                                        <!--begin::Card header-->
                                        <div class="card-header pt-7">
                                            <!--begin::Card title-->
                                            <h3 class="card-label fw-bold text-dark">Trending Property</h3>
                                            <!--end::Card title-->

                                        </div>
                                        <!--end::Card header-->
                                        <!--begin::Body-->
                                        <div class="card-body pt-1">
                                            <!--begin::Section-->
                                            <div class="mb-7">
                                                <!--begin::Items-->
                                                <div class="overflow-auto mb-10">
                                                    <c:forEach var="property" items="${requestScope.setTrendingProperty}">
                                                        <!--begin::Item-->
                                                        <div class="d-flex align-items-center mb-7">
                                                            <!--begin::Thumbnail-->
                                                            <div class="symbol symbol-60px symbol-2by3 me-4">
                                                                <img alt="Pic" src="${baseURL}/assets/images/${property.getImages().get(0).getFileName()}"
                                                                     style="border-radius: 10px;" />
                                                            </div>
                                                            <!--end::Thumbnail-->
                                                            <!--begin::List content-->
                                                            <div class="d-flex flex-column min-w-150px me-4">
                                                                <a href="#"
                                                                   class="fw-bold text-gray-800 text-hover-primary fs-4">${property.name}</a>
                                                                <div class="fw-semi fs-6 text-gray-400">
                                                                    ${property.address}</div>
                                                            </div>
                                                            <!--end::List content-->
                                                            <!--begin::Frequency-->
                                                            <div
                                                                class="ms-auto rounded-pill bg-light fw-bolder text-gray-600 py-1 px-3">
                                                                ${mapTrendingProperty.get(property)} contracts</div>
                                                            <!--Frequency-->
                                                        </div>
                                                        <!--end::Item-->
                                                    </c:forEach>


                                                </div>
                                                <!--end::Items-->
                                            </div>
                                            <!--end::Section-->
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::List Widget 3-->
                                </div>
                                <!--end:::Col-->
                                
                            </div>
                            <!--end::Row-->
                        </div>
                        <!--end::Container-->
                    </div>
                    <!--end::Content-->
                    <jsp:include page="../component/footer.jsp" />
                </div>
                <!--end::Wrapper-->
            </div>
            <!--end::Page-->
        </div>
        <!--end::Main-->
        <!--end::Drawers-->
        <jsp:include page="../component/scrolltop.jsp" />
        <jsp:include page="../base/footImport.jsp" />

        <jsp:include page="./datachart.jsp" />
    </body>
    <!--end::Body-->

</html>

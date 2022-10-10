<%-- 
    Document   : header
    Created on : Oct 10, 2022, 8:40:47 AM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--begin::Header-->
<div id="kt_header" class="header" data-kt-sticky="true" data-kt-sticky-name="header"
     data-kt-sticky-offset="{default: '200px', lg: '300px'}">
    <!--begin::Container-->
    <div class="container-fluid d-flex align-items-stretch justify-content-between"
         id="kt_header_container">
        <!--begin::Page title-->
        <div class="page-title d-flex flex-column align-items-start justify-content-center flex-wrap me-2 mb-5 mb-lg-0"
             data-kt-swapper="true" data-kt-swapper-mode="prepend"
             data-kt-swapper-parent="{default: '#kt_content_container', lg: '#kt_header_container'}">
            <!--begin::Heading-->
            <h1 class="text-dark fw-bolder mt-1 mb-1 fs-2">${pageTitle}
                <small class="text-muted fs-6 fw-normal ms-1"></small>
            </h1>
            <!--end::Heading-->
            <!--begin::Breadcrumb-->
            <ul class="breadcrumb fw-bold fs-base mb-1">
                <li class="breadcrumb-item text-muted">
                    <a href="${baseURL}" class="text-muted text-hover-primary">Home</a>
                </li>
                <li class="breadcrumb-item text-dark">${pageTitle}</li>
            </ul>
            <!--end::Breadcrumb-->
        </div>
        <!--end::Page title=-->
        <!--begin::Logo bar-->
        <div class="d-flex d-lg-none align-items-center flex-grow-1">
            <!--begin::Aside Toggle-->
            <div class="btn btn-icon btn-circle btn-active-light-primary ms-n2 me-1"
                 id="kt_aside_toggle">
                <!--begin::Svg Icon | path: icons/duotone/Text/Menu.svg-->
                <i class="fa-solid fa-bars"></i>
                <!--end::Svg Icon-->
            </div>
            <!--end::Aside Toggle-->
            <!--begin::Logo-->
            <a href="${baseURL}" class="d-lg-none">
                <img alt="Logo" src="${baseURL}/assets/images/logo.png" style="width: 40%;" class="max-h-40px" />
            </a>
            <!--end::Logo-->
        </div>
        <!--end::Logo bar-->
        <!--begin::Toolbar wrapper-->
        <div class="d-flex align-items-stretch flex-shrink-0">
            <jsp:include page="../component/notification.jsp" />
            <jsp:include page="../component/user.jsp" />
        </div>
        <!--end::Toolbar wrapper-->
    </div>
    <!--end::Container-->
</div>
<!--end::Header-->

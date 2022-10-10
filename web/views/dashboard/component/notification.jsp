<%-- 
    Document   : notification
    Created on : Oct 10, 2022, 8:38:20 AM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin::Notifications-->
<div class="d-flex align-items-center ms-1 ms-lg-3">
    <!--begin::Menu wrapper-->
    <div class="btn btn-icon btn-active-light-primary position-relative w-30px h-30px w-md-40px h-md-40px"
         data-kt-menu-trigger="click" data-kt-menu-attach="parent"
         data-kt-menu-placement="bottom-end" data-kt-menu-flip="bottom">
        <i class="fa-solid fa-bell"></i>
    </div>
    <!--begin::Menu-->
    <div class="menu menu-sub menu-sub-dropdown menu-column w-350px" data-kt-menu="true">
        <!--begin::Card-->
        <div class="card">
            <!--begin::Card header-->
            <div class="card-header">
                <h3 class="card-title">Notifications</h3>
            </div>
            <!--end::Card header-->
            <!--begin::Card body-->
            <div class="card-body p-0">
                <!--begin::Notifications-->
                <div class="mh-350px scroll-y py-3">
                    <!--begin::Item-->
                    <div class="d-flex align-items-center bg-hover-lighten py-3 px-9">
                        <!--begin::Title-->
                        <div class="mb-1 pe-3 flex-grow-1">
                            <a href="#"
                               class="fs-6 text-dark text-hover-primary fw-bold"><b>Admin</b>
                                replied your report!</a>
                            <div class="text-gray-400 fw-bold fs-7">2 hours ago</div>
                        </div>
                        <!--end::Title-->
                    </div>
                    <!--end::Item-->
                </div>
                <!--end::Notifications-->
            </div>
            <!--end::Card header-->
            <!--begin::Card footer-->
            <div class="card-footer text-center py-5">
                <a href="#" class="btn btn-light btn-active-light-primary btn-sm">All
                    Notifications</a>
            </div>
            <!--end::Card footer-->
        </div>
        <!--end::Card-->
    </div>
    <!--end::Menu-->
    <!--end::Menu wrapper-->
</div>
<!--end::Notifications-->

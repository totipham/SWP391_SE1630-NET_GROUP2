<%-- 
    Document   : user
    Created on : Oct 10, 2022, 8:39:08 AM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin::User-->
<div class="d-flex align-items-center ms-1 ms-lg-3" id="kt_header_user_menu_toggle">
    <!--begin::Menu wrapper-->
    <div class="cursor-pointer symbol symbol-circle symbol-30px symbol-md-40px border border-3 border-primary"
         data-kt-menu-trigger="click" data-kt-menu-attach="parent"
         data-kt-menu-placement="bottom-end" data-kt-menu-flip="bottom">
        <img alt="Pic" src="${baseURL}/assets/images/avatar.jpg" />
    </div>
    <!--begin::Menu-->
    <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-bold py-4 fs-6 w-275px"
         data-kt-menu="true">
        <!--begin::Menu item-->
        <div class="menu-item px-3">
            <div class="menu-content d-flex align-items-center px-3">
                <!--begin::Avatar-->
                <div class="symbol symbol-50px symbol-circle me-5">
                    <img alt="Logo" src="${baseURL}/assets/images/avatar.jpg" />
                </div>
                <!--end::Avatar-->
                <!--begin::Username-->
                <div class="d-flex flex-column">
                    <div class="fw-bolder d-flex align-items-center fs-5">Host Le</div>
                    <a href="#"
                       class="fw-bold text-muted text-hover-primary fs-7">hostle@hostalpy.com</a>
                </div>
                <!--end::Username-->
            </div>
        </div>
        <!--end::Menu item-->
        <!--begin::Menu separator-->
        <div class="separator my-2"></div>
        <!--end::Menu separator-->
        <!--begin::Menu item-->
        <div class="menu-item px-5">
            <a href="account/overview.html" class="menu-link px-5">Profile
            </a>
        </div>
        <!--end::Menu item-->
        <!--begin::Menu item-->
        <div class="menu-item px-5">
            <a href="#" class="menu-link px-5"><span class="menu-text">Reports</span>
                <span class="menu-badge">
                    <span
                        class="badge badge-light-danger badge-circle fw-bolder fs-7">3</span>
                </span></a>
        </div>
        <!--end::Menu item-->
        <!--begin::Menu separator-->
        <div class="separator my-2"></div>
        <!--end::Menu separator-->
        <!--begin::Menu item-->
        <div class="menu-item px-5">
            <a href="#" class="menu-link px-5">Sign Out</a>
        </div>
        <!--end::Menu item-->
    </div>
    <!--end::Menu-->
    <!--end::Menu wrapper-->
</div>
<!--end::User -->

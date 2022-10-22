<%-- 
    Document   : aside
    Created on : Oct 10, 2022, 8:35:42 AM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin::Aside-->
<div id="kt_aside" class="aside bg-white" data-kt-drawer="true" data-kt-drawer-name="aside"
     data-kt-drawer-activate="{default: true, lg: false}" data-kt-drawer-overlay="true"
     data-kt-drawer-width="{default:'200px', '300px': '250px'}" data-kt-drawer-direction="start"
     data-kt-drawer-toggle="#kt_aside_toggle">
    <!--begin::Brand-->
    <div class="aside-logo flex-column-auto pt-9 pb-7 px-9" id="kt_aside_logo">
        <!--begin::Logo-->
        <a href="${baseURL}">
            <img alt="Logo" src="${baseURL}/assets/images/logo.png" style="width: 70%;"
                 class="max-h-50px logo-default" />
            <img alt="Logo" src="${baseURL}/assets/images/logo-minimized.png" class="max-h-50px logo-minimize" />
        </a>
        <!--end::Logo-->
    </div>
    <!--end::Brand-->
    <!--begin::Aside menu-->
    <div class="aside-menu flex-column-fluid px-3 px-lg-6">
        <!--begin::Aside Menu-->
        <!--begin::Menu-->
        <div class="menu menu-column menu-pill menu-title-gray-600 menu-icon-gray-400 menu-state-primary menu-arrow-gray-500 menu-active-bg-primary fw-semibold fs-5 my-5 mt-lg-2 mb-lg-0"
             id="kt_aside_menu" data-kt-menu="true">
            <div class="hover-scroll-y me-n3 pe-3" id="kt_aside_menu_scroll" data-kt-scroll="true"
                 data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-height="auto"
                 data-kt-scroll-wrappers="#kt_aside_menu"
                 data-kt-scroll-dependencies="#kt_aside_logo, #kt_aside_footer" data-kt-scroll-offset="20px">
                <div class="menu-item mb-1">
                    <a class="menu-link ${pageTitle == "Dashboard" ? "active":"" }" href="${baseURL}/dashboard">
                        <span class="menu-icon">
                            <i class="fa-solid fa-chart-line"></i>
                        </span>
                        <span class="menu-title">Dashboards</span>
                    </a>
                </div>
                <div class="menu-item mb-1">
                    <a class="menu-link ${pageTitle == "Users" ? "active":"" }" href="${baseURL}/dashboard/users">
                        <span class="menu-icon">
                            <i class="fa-solid fa-chart-line"></i>
                        </span>
                        <span class="menu-title">Users</span>
                    </a>
                </div>
                <div data-kt-menu-trigger="click" class="menu-item menu-accordion mb-1">
                    <span class="menu-link ${pageTitle == "Property List" ? "active":"" } ${pageTitle == "Property Categories" ? "active":"" }">
                        <span class="menu-icon">
                            <i class="fa-solid fa-house"></i>
                        </span>
                        <span class="menu-title">Property</span>
                        <span class="menu-arrow"></span>
                    </span>
                    <div class="menu-sub menu-sub-accordion">
                        <div class="menu-item">
                            <a class="menu-link " href="${baseURL}/dashboard/properties">
                                <span class="menu-bullet">
                                    <span class="bullet bullet-dot"></span>
                                </span>
                                <span class="menu-title active">Property List</span>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a class="menu-link" href="${baseURL}/dashboard/propertycategories">
                                <span class="menu-bullet">
                                    <span class="bullet bullet-dot"></span>
                                </span>
                                <span class="menu-title">Property Category</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div data-kt-menu-trigger="click" class="menu-item menu-accordion mb-1">
                    <span class="menu-link ${pageTitle == "Report List" ? "active":"" } ${pageTitle == "Report Replies" ? "active":"" }">
                        <span class="menu-icon">
                            <i class="fa-solid fa-file-contract"></i>
                        </span>
                        <span class="menu-title">Report</span>
                        <span class="menu-arrow"></span>
                    </span>
                    <div class="menu-sub menu-sub-accordion">
                        <div class="menu-item">
                            <a class="menu-link" href="${baseURL}/dashboard/reports">
                                <span class="menu-bullet">
                                    <span class="bullet bullet-dot"></span>
                                </span>
                                <span class="menu-title">Report List</span>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a class="menu-link" href="${baseURL}/dashboard/reportreplies">
                                <span class="menu-bullet">
                                    <span class="bullet bullet-dot"></span>
                                </span>
                                <span class="menu-title">Report Replies</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--end::Menu-->
    </div>
    <!--end::Aside menu-->
    <!--begin::Footer-->
    <div class="aside-footer flex-column-auto px-6 pb-5" id="kt_aside_footer">
        <a href="${baseURL}" class="btn btn-light-primary w-100">Back to Homepage</a>
    </div>
    <!--end::Footer-->
</div>
<!--end::Aside-->

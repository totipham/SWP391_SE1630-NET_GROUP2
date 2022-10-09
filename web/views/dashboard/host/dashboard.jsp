<%-- 
    Document   : host_dashboard
    Created on : Oct 9, 2022, 9:39:50 PM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!--begin::Head-->

    <head>
        <base href="">
        <meta charset="utf-8" />
        <title>Dashboard - Hostalpy</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,600,700" />
        <link href="${baseURL}/assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
        <link href="${baseURL}/assets/css/dashboard.bundle.css" rel="stylesheet" type="text/css" />
        <link href="${baseURL}/assets/css/dashboard2.bundle.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <!--end::Head-->
    <!--begin::Body-->
    <body id="kt_body" class="header-fixed header-tablet-and-mobile-fixed aside-fixed">
        <!--begin::Main-->
        <div class="d-flex flex-column flex-root">
            <!--begin::Page-->
            <div class="page d-flex flex-row flex-column-fluid">
                <!--begin::Aside-->
                <div id="kt_aside" class="aside bg-white" data-kt-drawer="true" data-kt-drawer-name="aside"
                     data-kt-drawer-activate="{default: true, lg: false}" data-kt-drawer-overlay="true"
                     data-kt-drawer-width="{default:'200px', '300px': '250px'}" data-kt-drawer-direction="start"
                     data-kt-drawer-toggle="#kt_aside_toggle">
                    <!--begin::Brand-->
                    <div class="aside-logo flex-column-auto pt-9 pb-7 px-9" id="kt_aside_logo">
                        <!--begin::Logo-->
                        <a href="index.html">
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
                        <div class="menu menu-column menu-pill menu-title-gray-600 menu-icon-gray-400 menu-state-primary menu-arrow-gray-500 menu-active-bg-primary fw-bold fs-5 my-5 mt-lg-2 mb-lg-0"
                             id="kt_aside_menu" data-kt-menu="true">
                            <div class="hover-scroll-y me-n3 pe-3" id="kt_aside_menu_scroll" data-kt-scroll="true"
                                 data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-height="auto"
                                 data-kt-scroll-wrappers="#kt_aside_menu"
                                 data-kt-scroll-dependencies="#kt_aside_logo, #kt_aside_footer" data-kt-scroll-offset="20px">
                                <div class="menu-item mb-1">
                                    <a class="menu-link active" href="index.html">
                                        <span class="menu-icon">
                                            <i class="fa-solid fa-chart-line"></i>
                                        </span>
                                        <span class="menu-title">Dashboards</span>
                                    </a>
                                </div>
                                <div data-kt-menu-trigger="click" class="menu-item menu-accordion mb-1">
                                    <span class="menu-link">
                                        <span class="menu-icon">
                                            <i class="fa-solid fa-house"></i>
                                        </span>
                                        <span class="menu-title">Properties</span>
                                        <span class="menu-arrow"></span>
                                    </span>
                                    <div class="menu-sub menu-sub-accordion">
                                        <div class="menu-item">
                                            <a class="menu-link" href="#">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">My Properties</span>
                                            </a>
                                        </div>
                                        <div class="menu-item">
                                            <a class="menu-link" href="#">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Create New Property</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div data-kt-menu-trigger="click" class="menu-item menu-accordion mb-1">
                                    <span class="menu-link">
                                        <span class="menu-icon">
                                            <i class="fa-solid fa-file-contract"></i>
                                        </span>
                                        <span class="menu-title">Contracts</span>
                                        <span class="menu-arrow"></span>
                                    </span>
                                    <div class="menu-sub menu-sub-accordion">
                                        <div class="menu-item">
                                            <a class="menu-link" href="#">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">My Contracts</span>
                                            </a>
                                        </div>
                                        <div class="menu-item">
                                            <a class="menu-link" href="#">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Contract History</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div data-kt-menu-trigger="click" class="menu-item menu-accordion mb-1">
                                    <span class="menu-link">
                                        <span class="menu-icon">
                                            <i class="fa-solid fa-file-circle-question"></i>
                                        </span>
                                        <span class="menu-title">Requests</span>
                                        <span class="menu-arrow"></span>
                                    </span>
                                    <div class="menu-sub menu-sub-accordion">
                                        <div class="menu-item">
                                            <a class="menu-link" href="#">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Request List</span>
                                            </a>
                                        </div>
                                        <div class="menu-item">
                                            <a class="menu-link" href="#">
                                                <span class="menu-bullet">
                                                    <span class="bullet bullet-dot"></span>
                                                </span>
                                                <span class="menu-title">Request History</span>
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
                        <a href="#" class="btn btn-light-primary w-100">Back to Homepage</a>
                    </div>
                    <!--end::Footer-->
                </div>
                <!--end::Aside-->
                <!--begin::Wrapper-->
                <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
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
                                <h1 class="text-dark fw-bolder mt-1 mb-1 fs-2">Dashboard
                                    <small class="text-muted fs-6 fw-normal ms-1"></small>
                                </h1>
                                <!--end::Heading-->
                                <!--begin::Breadcrumb-->
                                <ul class="breadcrumb fw-bold fs-base mb-1">
                                    <li class="breadcrumb-item text-muted">
                                        <a href="index.html" class="text-muted text-hover-primary">Home</a>
                                    </li>
                                    <li class="breadcrumb-item text-dark">Dashboards</li>
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
                                <a href="index.html" class="d-lg-none">
                                    <img alt="Logo" src="${baseURL}/assets/images/logo.png" style="width: 40%;" class="max-h-40px" />
                                </a>
                                <!--end::Logo-->
                            </div>
                            <!--end::Logo bar-->
                            <!--begin::Toolbar wrapper-->
                            <div class="d-flex align-items-stretch flex-shrink-0">
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
                            </div>
                            <!--end::Toolbar wrapper-->
                        </div>
                        <!--end::Container-->
                    </div>
                    <!--end::Header-->
                    <!--begin::Content-->
                    <div class="content d-flex flex-column flex-column-fluid fs-6" id="kt_content">
                        <!--begin::Container-->
                        <div class="container" id="kt_content_container">
                            <!--begin::Row-->
                            <div class="row g-xl-8">
                                <!--begin:::Col-->
                                <div class="col-xxl-5">
                                    <!--begin::Slider Widget 1-->
                                    <div class="card mb-5 mb-xl-8">
                                        <!--begin::Body-->
                                        <div class="card-body pt-5">
                                            <div id="kt_stats_widget_8_carousel"
                                                 class="carousel carousel-custom carousel-stretch slide"
                                                 data-bs-ride="carousel" data-bs-interval="8000">
                                                <!--begin::Heading-->
                                                <div class="d-flex flex-stack flex-wrap">
                                                    <span class="fs-4 text-gray-400 fw-boldest pe-2">Announcements</span>
                                                    <!--begin::Carousel Indicators-->
                                                    <ol class="p-0 m-0 carousel-indicators carousel-indicators-dots">
                                                        <li data-bs-target="#kt_stats_widget_8_carousel"
                                                            data-bs-slide-to="0" class="ms-1 active"></li>
                                                        <li data-bs-target="#kt_stats_widget_8_carousel"
                                                            data-bs-slide-to="1" class="ms-1"></li>
                                                    </ol>
                                                    <!--end::Carousel Indicators-->
                                                </div>
                                                <!--end::Heading-->
                                                <!--begin::Carousel-->
                                                <div class="carousel-inner pt-6">
                                                    <!--begin::Item-->
                                                    <div class="carousel-item active">
                                                        <div class="carousel-wrapper">
                                                            <div
                                                                class="d-flex flex-column justify-content-between flex-grow-1">
                                                                <a href=""
                                                                   class="fs-2 text-gray-800 text-hover-primary fw-boldest">Announcements
                                                                    Title 1</a>
                                                                <p class="text-gray-600 fs-6 fw-bold pt-4 mb-0">Lorem ipsum
                                                                    dolor, sit amet consectetur adipisicing elit. Suscipit
                                                                    nam similique accusantium non aliquam nobis rem
                                                                    recusandae eveniet, laboriosam omnis inventore,
                                                                    asperiores voluptas minima voluptatem, architecto
                                                                    dignissimos. Earum, cum dolorum!</p>
                                                            </div>
                                                            <!--begin::Info-->
                                                            <div class="d-flex flex-stack pt-8">
                                                                <span
                                                                    class="badge badge-light-primary fs-7 fw-boldest me-2">OCT
                                                                    05, 10</span>
                                                            </div>
                                                            <!--end::Info-->
                                                        </div>
                                                    </div>
                                                    <!--end::Item-->
                                                    <!--begin::Item-->
                                                    <div class="carousel-item">
                                                        <div class="carousel-wrapper">
                                                            <!--begin::Title-->
                                                            <div
                                                                class="d-flex flex-column justify-content-between flex-grow-1">
                                                                <a href=""
                                                                   class="fs-2 text-gray-800 text-hover-primary fw-boldest">Announcements
                                                                    Title 2</a>
                                                                <p class="text-gray-600 fs-6 fw-bold pt-4 mb-0">Lorem ipsum
                                                                    dolor, sit amet consectetur adipisicing elit. Suscipit
                                                                    nam similique accusantium non aliquam nobis rem
                                                                    recusandae eveniet, laboriosam omnis inventore,
                                                                    asperiores voluptas minima voluptatem, architecto
                                                                    dignissimos. Earum, cum dolorum!</p>
                                                            </div>
                                                            <!--end::Title-->
                                                            <!--begin::Info-->
                                                            <div class="d-flex flex-stack pt-8">
                                                                <span
                                                                    class="badge badge-light-primary fs-7 fw-boldest me-2">DEC
                                                                    03, 20</span>
                                                            </div>
                                                            <!--end::Info-->
                                                        </div>
                                                    </div>
                                                    <!--end::Item-->
                                                </div>
                                                <!--end::Carousel-->
                                            </div>
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::Slider Widget 1-->
                                    <!--begin::List Widget 3-->
                                    <div class="card card-flush mb-5 mb-xl-8">
                                        <!--begin::Card header-->
                                        <div class="card-header">
                                            <!--begin::Card title-->
                                            <h3 class="card-title fw-boldest">Trending Property</h3>
                                            <!--end::Card title-->

                                        </div>
                                        <!--end::Card header-->
                                        <!--begin::Body-->
                                        <div class="card-body pt-1">
                                            <!--begin::Section-->
                                            <div class="mb-7">
                                                <!--begin::Items-->
                                                <div class="overflow-auto mb-10">
                                                    <!--begin::Item-->
                                                    <div class="d-flex align-items-center mb-7">
                                                        <!--begin::Thumbnail-->
                                                        <div class="symbol symbol-60px symbol-2by3 me-4">
                                                            <img alt="Pic" src="${baseURL}/assets/images/thumbnail.jpg"
                                                                 style="border-radius: 10px;" />
                                                        </div>
                                                        <!--end::Thumbnail-->
                                                        <!--begin::List content-->
                                                        <div class="d-flex flex-column min-w-150px me-4">
                                                            <a href="#"
                                                               class="fw-boldest text-gray-800 text-hover-primary fs-4">Kí
                                                                Túc Xá Ông Bà</a>
                                                            <div class="fw-bold fs-6 text-gray-400">
                                                                Thạch Hoà, Thạch Thất, Hà Nội</div>
                                                        </div>
                                                        <!--end::List content-->
                                                        <!--begin::Price-->
                                                        <div
                                                            class="ms-auto rounded-pill bg-light fw-bolder text-gray-600 py-1 px-3">
                                                            3,000,000đ</div>
                                                        <!--end::Price-->
                                                    </div>
                                                    <!--end::Item-->
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
                                <!--begin:::Col-->
                                <div class="col-xxl-7">
                                    <!--begin::Row-->
                                    <div class="row g-xl-8">
                                        <!--begin:::Col-->
                                        <div class="col">
                                            <!--begin::Chart Widget 1-->
                                            <div class="card card-xl-stretch mb-5 mb-xl-8">
                                                <!--begin::Body-->
                                                <div class="card-body p-0 d-flex justify-content-between flex-column">
                                                    <div class="d-flex flex-stack card-p flex-grow-1">
                                                        <!--begin::Icon-->
                                                        <div class="symbol symbol-45px symbol-circle">
                                                            <div class="symbol-label">
                                                                <!--begin::Svg Icon | path: icons/duotone/Shopping/Cart4.svg-->
                                                                <i class="fa-solid fa-dollar-sign"></i>
                                                                <!--end::Svg Icon-->
                                                            </div>
                                                        </div>
                                                        <!--end::Icon-->
                                                        <!--begin::Text-->
                                                        <div class="d-flex flex-column text-end">
                                                            <a href="#"
                                                               class="fw-boldest text-gray-800 text-hover-primary fs-2">Daily Income</a>
                                                            <span class="text-gray-400 fw-bold fs-6">Oct 1 - Oct 16
                                                                2022</span>
                                                        </div>
                                                        <!--end::Text-->
                                                    </div>
                                                    <!--begin::Chart-->
                                                    <div class="pt-1">
                                                        <div id="kt_chart_widget_1_chart"
                                                             class="card-rounded-bottom h-125px">
                                                        </div>
                                                    </div>
                                                    <!--end::Chart-->
                                                </div>
                                            </div>
                                            <!--end::Chart Widget 1-->
                                        </div>
                                        <!--end:::Col-->
                                    </div>
                                    <!--end::Row-->
                                    <!--begin::Row-->
                                    <div class="row g-xl-8">
                                        <!--begin:::Col-->
                                        <div class="col">
                                            <!--begin::Table Widget 1-->
                                            <div class="card card-xxl-stretch mb-5 mb-xl-3">
                                                <!--begin::Header-->
                                                <div class="card-header border-0 pt-5 pb-3">
                                                    <!--begin::Card title-->
                                                    <h3 class="card-title align-items-start flex-column">
                                                        <span class="card-label fw-boldest text-gray-800 fs-2">Contract
                                                            List</span>
                                                        <span class="text-gray-400 fw-bold mt-2 fs-6">890 contracts</span>
                                                    </h3>
                                                    <!--end::Card title-->
                                                </div>
                                                <!--end::Header-->
                                                <!--begin::Body-->
                                                <div class="card-body py-0">
                                                    <!--begin::Table-->
                                                    <div class="table-responsive">
                                                        <table
                                                            class="table align-middle table-row-bordered table-row-dashed gy-5"
                                                            id="kt_table_widget_1">
                                                            <!--begin::Table body-->
                                                            <tbody>
                                                                <!--begin::Table row-->
                                                                <tr
                                                                    class="text-start text-gray-400 fw-boldest fs-7 text-uppercase">
                                                                    <th class="min-w-200px px-0">Renter</th>
                                                                    <th class="min-w-200px">Property</th>
                                                                    <th class="min-w-70px">Day</th>
                                                                    <th class="text-end pe-2 min-w-70px">Action</th>
                                                                </tr>
                                                                <!--end::Table row-->
                                                                <!--begin::Table row-->
                                                                <tr>
                                                                    <!--begin::Author=-->
                                                                    <td class="p-0">
                                                                        <div class="d-flex align-items-center">
                                                                            <!--begin::Avatar-->
                                                                            <div
                                                                                class="symbol symbol-circle symbol-50px me-2">
                                                                                <div
                                                                                    class="symbol symbol-50px symbol-circle me-5">
                                                                                    <img alt="Logo"
                                                                                         src="${baseURL}/assets/images/avatar.jpg" />
                                                                                </div>
                                                                            </div>
                                                                            <!--end::Avatar-->
                                                                            <div class="ps-3">
                                                                                <a href="#"
                                                                                   class="text-gray-800 fw-boldest fs-5 text-hover-primary mb-1">Renter
                                                                                    Le</a>
                                                                                <span
                                                                                    class="text-gray-400 fw-bold d-block">Hà
                                                                                    Đông, Hà Nội</span>
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                    <!--end::Author=-->
                                                                    <!--begin::Company=-->
                                                                    <td>
                                                                        <span
                                                                            class="text-gray-800 fw-boldest fs-5 d-block">Kí
                                                                            Túc Xá Ông Bà</span>
                                                                        <span class="text-gray-400 fw-bold">Thạch Hoà, Thạch Thất, Hà
                                                                            Nội</span>
                                                                    </td>
                                                                    <!--end::Company=-->
                                                                    <!--begin::Progress=-->
                                                                    <td>
                                                                        <div class="d-flex flex-column w-100 me-2 mt-2">
                                                                            <span
                                                                                class="text-gray-400 me-2 fw-boldest mb-2">65 days</span>
                                                                            <!-- <div
                                                                                    class="progress bg-light-danger w-100 h-5px">
                                                                                    <div class="progress-bar bg-danger"
                                                                                            role="progressbar" style="width: 65%">
                                                                                    </div>
                                                                            </div> -->
                                                                        </div>
                                                                    </td>
                                                                    <!--end::Company=-->
                                                                    <!--begin::Action=-->
                                                                    <td class="pe-0 text-end">
                                                                        <a href="#"
                                                                           class="btn btn-light text-muted fw-boldest btn-sm px-5">View</a>
                                                                    </td>
                                                                    <!--end::Action=-->
                                                                </tr>
                                                                <!--end::Table row-->
                                                            </tbody>
                                                            <!--end::Table body-->
                                                        </table>
                                                    </div>
                                                    <!--end::Table-->
                                                </div>
                                                <!--end::Body-->
                                            </div>
                                            <!--end::Table Widget 1-->
                                        </div>
                                        <!--end:::Col-->
                                    </div>
                                    <!--end::Row-->
                                </div>
                                <!--end:::Col-->
                            </div>
                            <!--end::Row-->
                        </div>
                        <!--end::Container-->
                    </div>
                    <!--end::Content-->
                </div>
                <!--end::Wrapper-->
            </div>
            <!--end::Page-->
        </div>
        <!--end::Main-->

        <!--end::Drawers-->
        <!--begin::Scrolltop-->
        <div id="kt_scrolltop" class="scrolltop rounded-circle" data-kt-scrolltop="true">
            <!--begin::Svg Icon | path: icons/duotone/Navigation/Up-2.svg-->
            <span class="svg-icon">
                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px"
                     height="24px" viewBox="0 0 24 24" version="1.1">
                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                <polygon points="0 0 24 0 24 24 0 24" />
                <rect fill="#000000" opacity="0.5" x="11" y="10" width="2" height="10" rx="1" />
                <path
                    d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z"
                    fill="#000000" fill-rule="nonzero" />
                </g>
                </svg>
            </span>
            <!--end::Svg Icon-->
        </div>
        <!--end::Scrolltop-->
        <!--begin::Javascript-->
        <!--begin::Global Javascript Bundle(used by all pages)-->
        <script src="${baseURL}/assets/plugins/global/plugins.bundle.js"></script>
        <script src="${baseURL}/assets/js/scripts.bundle.js"></script>
        <!--end::Global Javascript Bundle-->
        <!--begin::Page Custom Javascript(used by this page)-->
        <script src="${baseURL}/assets/js/custom/widgets.js"></script>
        <!--end::Page Custom Javascript-->
        <!--end::Javascript-->
    </body>
    <!--end::Body-->

</html>

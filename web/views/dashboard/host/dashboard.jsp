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
        <jsp:include page="../component/scrolltop.jsp" />
        <jsp:include page="../base/footImport.jsp" />
    </body>
    <!--end::Body-->

</html>

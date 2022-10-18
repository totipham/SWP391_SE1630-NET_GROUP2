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
                                    <!--begin::Card widget 4-->
                                    <div class="card card-flush h-md-50 mb-5 mb-xl-10">
                                        <!--begin::Header-->
                                        <div class="card-header pt-5">
                                            <!--begin::Title-->
                                            <div class="card-title d-flex flex-column">
                                                <!--begin::Info-->
                                                <div class="d-flex align-items-center">
                                                    <!--begin::Currency-->
                                                    <span
                                                        class="fs-4 fw-semibold text-gray-400 me-1 align-self-start">$</span>
                                                    <!--end::Currency-->
                                                    <!--begin::Amount-->
                                                    <span class="fs-2hx fw-bold text-dark me-2 lh-1 ls-n2">69,700</span>
                                                    <!--end::Amount-->
                                                </div>
                                                <!--end::Info-->
                                                <!--begin::Subtitle-->
                                                <span class="text-gray-400 pt-1 fw-semibold fs-6">Expected Earnings</span>
                                                <!--end::Subtitle-->
                                            </div>
                                            <!--end::Title-->
                                        </div>
                                        <!--end::Header-->
                                        <!--begin::Card body-->
                                        <div class="card-body pt-2 pb-4 d-flex align-items-center">
                                            <!--begin::Chart-->
                                            <div class="d-flex flex-center me-5 pt-2">
                                                <div id="expected_earning_chart" style="min-width: 70px; min-height: 70px"
                                                     data-kt-size="70" data-kt-line="11"></div>
                                            </div>
                                            <!--end::Chart-->
                                            <!--begin::Labels-->
                                            <div class="d-flex flex-column content-justify-center w-100">
                                                <!--begin::Label-->
                                                <div class="d-flex fs-6 fw-semibold align-items-center">
                                                    <!--begin::Bullet-->
                                                    <div class="bullet w-8px h-6px rounded-2 bg-danger me-3"></div>
                                                    <!--end::Bullet-->
                                                    <!--begin::Label-->
                                                    <div class="text-gray-500 flex-grow-1 me-4">Motel</div>
                                                    <!--end::Label-->
                                                    <!--begin::Stats-->
                                                    <div class="fw-bolder text-gray-700 text-xxl-end">$7,660</div>
                                                    <!--end::Stats-->
                                                </div>
                                                <!--end::Label-->
                                                <!--begin::Label-->
                                                <div class="d-flex fs-6 fw-semibold align-items-center my-3">
                                                    <!--begin::Bullet-->
                                                    <div class="bullet w-8px h-6px rounded-2 bg-primary me-3"></div>
                                                    <!--end::Bullet-->
                                                    <!--begin::Label-->
                                                    <div class="text-gray-500 flex-grow-1 me-4">Dorm</div>
                                                    <!--end::Label-->
                                                    <!--begin::Stats-->
                                                    <div class="fw-bolder text-gray-700 text-xxl-end">$2,820</div>
                                                    <!--end::Stats-->
                                                </div>
                                                <!--end::Label-->
                                                <!--begin::Label-->
                                                <div class="d-flex fs-6 fw-semibold align-items-center">
                                                    <!--begin::Bullet-->
                                                    <div class="bullet w-8px h-6px rounded-2 me-3"
                                                         style="background-color: #E4E6EF"></div>
                                                    <!--end::Bullet-->
                                                    <!--begin::Label-->
                                                    <div class="text-gray-500 flex-grow-1 me-4">House</div>
                                                    <!--end::Label-->
                                                    <!--begin::Stats-->
                                                    <div class="fw-bolder text-gray-700 text-xxl-end">$45,257</div>
                                                    <!--end::Stats-->
                                                </div>
                                                <!--end::Label-->
                                            </div>
                                            <!--end::Labels-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Card widget 4-->
                                    <!--begin::Card widget 5-->
                                    <div class="card card-flush h-md-50 mb-xl-10">
                                        <!--begin::Header-->
                                        <div class="card-header pt-5">
                                            <!--begin::Title-->
                                            <div class="card-title d-flex flex-column">
                                                <!--begin::Info-->
                                                <div class="d-flex align-items-center">
                                                    <!--begin::Amount-->
                                                    <span class="fs-2hx fw-bold text-dark me-2 lh-1 ls-n2">1,836</span>
                                                    <!--end::Amount-->
                                                </div>
                                                <!--end::Info-->
                                                <!--begin::Subtitle-->
                                                <span class="text-gray-400 pt-1 fw-semibold fs-6">Rents This Month</span>
                                                <!--end::Subtitle-->
                                            </div>
                                            <!--end::Title-->
                                        </div>
                                        <!--end::Header-->
                                        <!--begin::Card body-->
                                        <div class="card-body d-flex align-items-end pt-0">
                                            <!--begin::Progress-->
                                            <div class="d-flex align-items-center flex-column mt-3 w-100">
                                                <div class="d-flex justify-content-between w-100 mt-auto mb-2">
                                                    <span class="fw-bolder fs-6 text-dark">1,048 to Goal</span>
                                                    <span class="fw-bold fs-6 text-gray-400">62%</span>
                                                </div>
                                                <div class="h-8px mx-3 w-100 bg-light-success rounded">
                                                    <div class="bg-success rounded h-8px" role="progressbar"
                                                         style="width: 62%;" aria-valuenow="50" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                            <!--end::Progress-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Card widget 5-->
                                </div>
                                <!--end::Col-->
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
                                                    <!--begin::Currency-->
                                                    <span
                                                        class="fs-4 fw-semibold text-gray-400 me-1 align-self-start">$</span>
                                                    <!--end::Currency-->
                                                    <!--begin::Amount-->
                                                    <span class="fs-2hx fw-bold text-dark me-2 lh-1 ls-n2">2,420</span>
                                                    <!--end::Amount-->
                                                </div>
                                                <!--end::Info-->
                                                <!--begin::Subtitle-->
                                                <span class="text-gray-400 pt-1 fw-semibold fs-6">Average Daily</span>
                                                <!--end::Subtitle-->
                                            </div>
                                            <!--end::Title-->
                                        </div>
                                        <!--end::Header-->
                                        <!--begin::Card body-->
                                        <div class="card-body d-flex align-items-end px-0 pb-0">
                                            <!--begin::Chart-->
                                            <div id="average_daily_chart" class="w-100" style="height: 80px"></div>
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
                                                <span class="fs-2hx fw-bold text-dark me-2 lh-1 ls-n2">6.3k</span>
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
                                                <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                     title="Alan Warden">
                                                    <span
                                                        class="symbol-label bg-warning text-inverse-warning fw-bold">A</span>
                                                </div>
                                                <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                     title="Michael Eberon">
                                                    <img alt="Pic" src="${baseURL}/assets/images/avatar.jpg" />
                                                </div>
                                                <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                     title="Susan Redwood">
                                                    <span
                                                        class="symbol-label bg-primary text-inverse-primary fw-bold">S</span>
                                                </div>
                                                <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                     title="Susan Redwood">
                                                    <span
                                                        class="symbol-label bg-primary text-inverse-primary fw-bold">S</span>
                                                </div>
                                                <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                     title="Perry Matthew">
                                                    <span
                                                        class="symbol-label bg-danger text-inverse-danger fw-bold">P</span>
                                                </div>
                                                <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                                     title="Susan Redwood">
                                                    <span
                                                        class="symbol-label bg-primary text-inverse-primary fw-bold">S</span>
                                                </div>
                                                <a href="#" class="symbol symbol-35px symbol-circle" data-bs-toggle="modal"
                                                   data-bs-target="#kt_modal_view_users">
                                                    <span
                                                        class="symbol-label bg-light text-gray-400 fs-8 fw-bold">+42</span>
                                                </a>
                                            </div>
                                            <!--end::Users group-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Card widget 7-->
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-lg-12 col-xl-12 col-xxl-6 mb-5 mb-xl-0">
                                    <!--begin::Chart widget 3-->
                                    <div class="card card-flush overflow-hidden h-md-100">
                                        <!--begin::Header-->
                                        <div class="card-header py-5">
                                            <!--begin::Title-->
                                            <h3 class="card-title align-items-start flex-column">
                                                <span class="card-label fw-bold text-dark">Rents This Months</span>
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
                                                    <span class="fs-4 fw-semibold text-gray-400 me-1">$</span>
                                                    <span class="fs-2hx fw-bold text-gray-800 me-2 lh-1 ls-n2">14,094</span>
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
                                <div class="col-xxl-5">
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
                                                               class="fw-bold text-gray-800 text-hover-primary fs-4">Kí
                                                                Túc Xá Ông Bà</a>
                                                            <div class="fw-semi fs-6 text-gray-400">
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
                                            <!--begin::Table Widget 1-->
                                            <div class="card card-xxl-stretch mb-5 mb-xl-3">
                                                <!--begin::Header-->
                                                <div class="card-header border-0 pt-5 pb-3">
                                                    <!--begin::Card title-->
                                                    <h3 class="card-title align-items-start flex-column">
                                                        <span class="card-label fw-bold text-dark">Contract
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
                                                                    class="text-start text-gray-400 fw-bold fs-7 text-uppercase gs-0">
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
                                                                                         src="../images/avatar.jpg" />
                                                                                </div>
                                                                            </div>
                                                                            <!--end::Avatar-->
                                                                            <div class="ps-3">
                                                                                <a href="#"
                                                                                   class="text-gray-800 fw-bold fs-5 text-hover-primary mb-1">Renter
                                                                                    Le</a>
                                                                                <span
                                                                                    class="text-gray-400 fw-semi d-block">Hà
                                                                                    Đông, Hà Nội</span>
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                    <!--end::Author=-->
                                                                    <!--begin::Company=-->
                                                                    <td>
                                                                        <span
                                                                            class="text-gray-800 fw-bold fs-5 d-block">Kí
                                                                            Túc Xá Ông Bà</span>
                                                                        <span class="text-gray-400 fw-semi">Thạch Hoà, Thạch
                                                                            Thất, Hà
                                                                            Nội</span>
                                                                    </td>
                                                                    <!--end::Company=-->
                                                                    <!--begin::Progress=-->
                                                                    <td>
                                                                        <div class="d-flex flex-column w-100 me-2 mt-2">
                                                                            <span
                                                                                class="text-gray-400 me-2 fw-semi mb-2">65
                                                                                days</span>
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
                                                                           class="btn btn-light text-muted fw-bold btn-sm px-5">View</a>
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
        
        <jsp:include page="./datachart.jsp" />
    </body>
    <!--end::Body-->

</html>

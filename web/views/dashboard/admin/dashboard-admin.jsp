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
                <jsp:include page="../component/aside_admin.jsp" />
                <!--begin::Wrapper-->
                <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
                    <jsp:include page="../component/header.jsp" />
                    <!--begin::Content-->
                    <div class="content d-flex flex-column flex-column-fluid fs-6" id="kt_content">
                        <!--begin::Container-->
                        <div class="container" id="kt_content_container">
                            <!--begin::Row-->
                            <div class="row gy-5 g-xl-10">
                                <!--begin::Col-->
                                <div class="col-sm-6 col-xl-3 mb-xl-10">
                                    <!--begin::Card widget 2-->
                                    <div class="card h-lg-100">
                                        <!--begin::Body-->
                                        <div class="card-body d-flex justify-content-between align-items-start flex-column">
                                            <!--begin::Icon-->
                                            <div class="m-0">
                                                <!--begin::Svg Icon | path: icons/duotune/maps/map004.svg-->
                                                <span class="svg-icon svg-icon-2hx svg-icon-gray-600">
                                                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path opacity="0.3" d="M18.4 5.59998C21.9 9.09998 21.9 14.8 18.4 18.3C14.9 21.8 9.2 21.8 5.7 18.3L18.4 5.59998Z" fill="currentColor" />
                                                    <path d="M12 2C6.5 2 2 6.5 2 12C2 17.5 6.5 22 12 22C17.5 22 22 17.5 22 12C22 6.5 17.5 2 12 2ZM19.9 11H13V8.8999C14.9 8.6999 16.7 8.00005 18.1 6.80005C19.1 8.00005 19.7 9.4 19.9 11ZM11 19.8999C9.7 19.6999 8.39999 19.2 7.39999 18.5C8.49999 17.7 9.7 17.2001 11 17.1001V19.8999ZM5.89999 6.90002C7.39999 8.10002 9.2 8.8 11 9V11.1001H4.10001C4.30001 9.4001 4.89999 8.00002 5.89999 6.90002ZM7.39999 5.5C8.49999 4.7 9.7 4.19998 11 4.09998V7C9.7 6.8 8.39999 6.3 7.39999 5.5ZM13 17.1001C14.3 17.3001 15.6 17.8 16.6 18.5C15.5 19.3 14.3 19.7999 13 19.8999V17.1001ZM13 4.09998C14.3 4.29998 15.6 4.8 16.6 5.5C15.5 6.3 14.3 6.80002 13 6.90002V4.09998ZM4.10001 13H11V15.1001C9.1 15.3001 7.29999 16 5.89999 17.2C4.89999 16 4.30001 14.6 4.10001 13ZM18.1 17.1001C16.6 15.9001 14.8 15.2 13 15V12.8999H19.9C19.7 14.5999 19.1 16.0001 18.1 17.1001Z" fill="currentColor" />
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                            </div>
                                            <!--end::Icon-->
                                            <!--begin::Section-->
                                            <div class="d-flex flex-column my-7">
                                                <!--begin::Number-->
                                                <span class="fw-semibold fs-3x text-gray-800 lh-1 ls-n2">${requestScope.numberOfUser}</span>
                                                <!--end::Number-->
                                                <!--begin::Follower-->
                                                <div class="m-0">
                                                    <span class="fw-medium fs-6 text-gray-400">Users</span>
                                                </div>
                                                <!--end::Follower-->
                                            </div>
                                            <!--end::Section-->
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::Card widget 2-->
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-sm-6 col-xl-3 mb-xl-10">
                                    <!--begin::Card widget 2-->
                                    <div class="card h-lg-100">
                                        <!--begin::Body-->
                                        <div class="card-body d-flex justify-content-between align-items-start flex-column">
                                            <!--begin::Icon-->
                                            <div class="m-0">
                                                <!--begin::Svg Icon | path: icons/duotune/graphs/gra001.svg-->
                                                <span class="svg-icon svg-icon-2hx svg-icon-gray-600">
                                                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path opacity="0.3" d="M14 3V21H10V3C10 2.4 10.4 2 11 2H13C13.6 2 14 2.4 14 3ZM7 14H5C4.4 14 4 14.4 4 15V21H8V15C8 14.4 7.6 14 7 14Z" fill="currentColor" />
                                                    <path d="M21 20H20V8C20 7.4 19.6 7 19 7H17C16.4 7 16 7.4 16 8V20H3C2.4 20 2 20.4 2 21C2 21.6 2.4 22 3 22H21C21.6 22 22 21.6 22 21C22 20.4 21.6 20 21 20Z" fill="currentColor" />
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                            </div>
                                            <!--end::Icon-->
                                            <!--begin::Section-->
                                            <div class="d-flex flex-column my-7">
                                                <!--begin::Number-->
                                                <span class="fw-semibold fs-3x text-gray-800 lh-1 ls-n2">${requestScope.numberOfProperty}</span>
                                                <!--end::Number-->
                                                <!--begin::Follower-->
                                                <div class="m-0">
                                                    <span class="fw-medium fs-6 text-gray-400">Properties</span>
                                                </div>
                                                <!--end::Follower-->
                                            </div>
                                            <!--end::Section-->
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::Card widget 2-->
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-sm-6 col-xl-3 mb-xl-10">
                                    <!--begin::Card widget 2-->
                                    <div class="card h-lg-100">
                                        <!--begin::Body-->
                                        <div class="card-body d-flex justify-content-between align-items-start flex-column">
                                            <!--begin::Icon-->
                                            <div class="m-0">
                                                <!--begin::Svg Icon | path: icons/duotune/abstract/abs048.svg-->
                                                <span class="svg-icon svg-icon-2hx svg-icon-gray-600">
                                                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path opacity="0.3" d="M12 22C17.5228 22 22 17.5228 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 17.5228 6.47715 22 12 22Z" fill="currentColor" />
                                                    <path d="M8.70001 6C8.10001 5.7 7.39999 5.40001 6.79999 5.10001C7.79999 4.00001 8.90001 3 10.1 2.2C10.7 2.1 11.4 2 12 2C12.7 2 13.3 2.1 13.9 2.2C12 3.2 10.2 4.5 8.70001 6ZM12 8.39999C13.9 6.59999 16.2 5.30001 18.7 4.60001C18.1 4.00001 17.4 3.6 16.7 3.2C14.4 4.1 12.2 5.40001 10.5 7.10001C11 7.50001 11.5 7.89999 12 8.39999ZM7 20C7 20.2 7 20.4 7 20.6C6.2 20.1 5.49999 19.6 4.89999 19C4.59999 18 4.00001 17.2 3.20001 16.6C2.80001 15.8 2.49999 15 2.29999 14.1C4.99999 14.7 7 17.1 7 20ZM10.6 9.89999C8.70001 8.09999 6.39999 6.9 3.79999 6.3C3.39999 6.9 2.99999 7.5 2.79999 8.2C5.39999 8.6 7.7 9.80001 9.5 11.6C9.8 10.9 10.2 10.4 10.6 9.89999ZM2.20001 10.1C2.10001 10.7 2 11.4 2 12C2 12 2 12 2 12.1C4.3 12.4 6.40001 13.7 7.60001 15.6C7.80001 14.8 8.09999 14.1 8.39999 13.4C6.89999 11.6 4.70001 10.4 2.20001 10.1ZM11 20C11 14 15.4 9.00001 21.2 8.10001C20.9 7.40001 20.6 6.8 20.2 6.2C13.8 7.5 9 13.1 9 19.9C9 20.4 9.00001 21 9.10001 21.5C9.80001 21.7 10.5 21.8 11.2 21.9C11.1 21.3 11 20.7 11 20ZM19.1 19C19.4 18 20 17.2 20.8 16.6C21.2 15.8 21.5 15 21.7 14.1C19 14.7 16.9 17.1 16.9 20C16.9 20.2 16.9 20.4 16.9 20.6C17.8 20.2 18.5 19.6 19.1 19ZM15 20C15 15.9 18.1 12.6 22 12.1C22 12.1 22 12.1 22 12C22 11.3 21.9 10.7 21.8 10.1C16.8 10.7 13 14.9 13 20C13 20.7 13.1 21.3 13.2 21.9C13.9 21.8 14.5 21.7 15.2 21.5C15.1 21 15 20.5 15 20Z" fill="currentColor" />
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                            </div>
                                            <!--end::Icon-->
                                            <!--begin::Section-->
                                            <div class="d-flex flex-column my-7">
                                                <!--begin::Number-->
                                                <span class="fw-semibold fs-3x text-gray-800 lh-1 ls-n2">${requestScope.numberOfReport}</span>
                                                <!--end::Number-->
                                                <!--begin::Follower-->
                                                <div class="m-0">
                                                    <span class="fw-medium fs-6 text-gray-400">Reports</span>
                                                </div>
                                                <!--end::Follower-->
                                            </div>
                                            <!--end::Section-->
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::Card widget 2-->
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-sm-6 col-xl-3 mb-xl-10">
                                    <!--begin::Card widget 2-->
                                    <div class="card h-lg-100">
                                        <!--begin::Body-->
                                        <div class="card-body d-flex justify-content-between align-items-start flex-column">
                                            <!--begin::Icon-->
                                            <div class="m-0">
                                                <!--begin::Svg Icon | path: icons/duotune/maps/map002.svg-->
                                                <span class="svg-icon svg-icon-2hx svg-icon-gray-600">
                                                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M8.7 4.19995L4 6.30005V18.8999L8.7 16.8V19L3.1 21.5C2.6 21.7 2 21.4 2 20.8V6C2 5.4 2.3 4.89995 2.9 4.69995L8.7 2.09998V4.19995Z" fill="currentColor" />
                                                    <path d="M15.3 19.8L20 17.6999V5.09992L15.3 7.19989V4.99994L20.9 2.49994C21.4 2.29994 22 2.59989 22 3.19989V17.9999C22 18.5999 21.7 19.1 21.1 19.3L15.3 21.8998V19.8Z" fill="currentColor" />
                                                    <path opacity="0.3" d="M15.3 7.19995L20 5.09998V17.7L15.3 19.8V7.19995Z" fill="currentColor" />
                                                    <path opacity="0.3" d="M8.70001 4.19995V2L15.4 5V7.19995L8.70001 4.19995ZM8.70001 16.8V19L15.4 22V19.8L8.70001 16.8Z" fill="currentColor" />
                                                    <path opacity="0.3" d="M8.7 16.8L4 18.8999V6.30005L8.7 4.19995V16.8Z" fill="currentColor" />
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon-->
                                            </div>
                                            <!--end::Icon-->
                                            <!--begin::Section-->
                                            <div class="d-flex flex-column my-7">
                                                <!--begin::Number-->
                                                <span class="fw-semibold fs-3x text-gray-800 lh-1 ls-n2">${requestScope.numberOfContract}</span>
                                                <!--end::Number-->
                                                <!--begin::Follower-->
                                                <div class="m-0">
                                                    <span class="fw-medium fs-6 text-gray-400">Contracts</span>
                                                </div>
                                                <!--end::Follower-->
                                            </div>
                                            <!--end::Section-->
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::Card widget 2-->
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Row-->
                            <!--begin::Row-->
                            <div class="row g-5 g-xl-10 mb-xl-10">
                                <!--begin::Col-->
                                <div class="col-lg-12 col-xl-12 col-xxl-6 mb-5 mb-xl-0">
                                    <!--begin::Chart widget 3-->
                                    <div class="card card-flush overflow-hidden h-md-100">
                                        <!--begin::Header-->
                                        <div class="card-header py-5">
                                            <!--begin::Title-->
                                            <h3 class="card-title align-items-start flex-column">
                                                <span class="card-label fw-bold text-dark">Incomes</span>
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
                                                    <span class="fs-2hx fw-bold text-gray-800 me-2 lh-1 ls-n2">${requestScope.totalIncome}M</span>
                                                </div>
                                                <!--end::Statistics-->
                                            </div>
                                            <!--end::Statistics-->
                                            <!--begin::Chart-->
                                            <div id="admin_income_chart" class="min-h-auto ps-4 pe-6" style="height: 300px">
                                            </div>
                                            <!--end::Chart-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Chart widget 3-->
                                </div>
                                <!--end::Col-->
                                <!--begin::Col-->
                                <div class="col-lg-12 col-xl-12 col-xxl-6 mb-5 mb-xl-0">
                                    <!--begin::Table Widget 4-->
                                    <div class="card card-flush h-xl-100">
                                        <!--begin::Card header-->
                                        <div class="card-header pt-7">
                                            <!--begin::Title-->
                                            <h3 class="card-title align-items-start flex-column">
                                                <span class="card-label fw-bold text-gray-800">Reports</span>
                                            </h3>
                                            <!--end::Title-->
                                            <!--begin::Actions-->
                                            <div class="card-toolbar">
                                                <!--begin::Filters-->
<!--                                                <div class="d-flex flex-stack flex-wrap gap-4">
                                                    begin::Destination
                                                    <div class="d-flex align-items-center fw-bold">
                                                        begin::Label
                                                        <div class="text-gray-400 fs-7 me-2">Status</div>
                                                        end::Label
                                                        begin::Select
                                                        <select class="form-select form-select-transparent text-gray-800 fs-base lh-1 fw-bold py-0 ps-3 w-auto" data-control="select2" data-hide-search="true" data-dropdown-css-class="w-150px" data-placeholder="Select an option">
                                                            <option></option>
                                                            <option value="Show All" selected="selected">Show All</option>
                                                            <option value="a">Unseen</option>
                                                            <option value="b">Seen</option>
                                                        </select>
                                                        end::Select
                                                    </div>
                                                    end::Destination
                                                </div>-->
                                                <!--begin::Filters-->
                                            </div>
                                            <!--end::Actions-->
                                        </div>
                                        <!--end::Card header-->
                                        <!--begin::Card body-->
                                        <div class="card-body pt-2">
                                            <!--begin::Table-->
                                            <table class="table align-middle table-row-dashed fs-6 gy-3" id="kt_table_widget_4_table">
                                                <!--begin::Table head-->
                                                <thead>
                                                    <!--begin::Table row-->
                                                    <tr class="text-start fw-bold fs-7 text-uppercase gs-0">
                                                        <th class="min-w-50px">#</th>
                                                        <th class="text-center min-w-125px">Name</th>
                                                        <th class="text-center min-w-50px">Report Type</th>
                                                        <th class="text-center min-w-50px">Status</th>
                                                        <th class="text-center min-w-50px">Action</th>

                                                        <!--end::Table row-->
                                                </thead>
                                                <!--end::Table head-->
                                                <!--begin::Table body-->
                                                <tbody class="fw-semibold text-gray-600">
                                                    <c:forEach items="${requestScope.reportList}" var="report">
                                                        <tr>
                                                            <td>
                                                                <span class="text-gray-800 text-hover-primary">${report.id}</span>
                                                            </td>
                                                            <td class="text-center">
                                                                <img src="" class="w-[30px] rounded-full">
                                                                ${report.sender.name}
                                                            </td>
                                                            <td class="text-center">
                                                                Property
                                                            </td>
                                                            <td class="text-center">Seen</td>
                                                            <td class="text-center">
                                                                <a href="">View</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>

                                                </tbody>
                                                <!--end::Table body-->
                                            </table>
                                            <!--end::Table-->
                                        </div>
                                        <!--end::Card body-->
                                    </div>
                                    <!--end::Table Widget 4-->
                                </div>
                                <!--end::Col-->
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

<%-- 
    Document   : host/properties
    Created on : Oct 9, 2022, 10:39:52 PM
    Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!--begin::Head-->
    <head>
        <jsp:include page="../base/headImport.jsp" />
        <style>
            .property-card {
                background: #fff;
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                cursor: pointer;
            }

            .property-card:hover {
                transition: 0.3s;
                transform: scale(1.01);
            }

            .property-card .property-card__thumbnail img {
                width: 100%;
                height: 280px;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }

            .property-card .property-card__information {
                min-height: 200px;
                padding: 20px;
                border-bottom-left-radius: 10px;
                border-bottom-right-radius: 10px;

                display: flex;
                flex-direction: column;
                gap: 1px;
            }

            .property-card .property-card__information .property-card__information__short {
                display: flex;
                flex-direction: row;
                gap: 5px;
            }

            .property-card .property-card__information .property-card__information__short span {
                color: #0b3a24;
                font-weight: 500;
            }

            .property-card__information__name {
                font-weight: bold;
                font-size: 24px;
            }

            .property-card__information__bottom {
                display: flex;
                justify-content: flex-end;
                gap: 10px;
                height: 30px;
                margin-top: auto;
                align-items: center;
            }
        </style>
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
                        <div class="container-fluid" id="kt_content_container">
                            <div class="row g-xl-8">
                                <c:forEach items="${requestScope.requestlist}" var="request">
                                    <div class="col-md-4">
                                        <div class="property-card shadow my-2">
                                            <div class="property-card__thumbnail">
                                                <img src="${baseURL}/assets/images/${request.getProperty().getImages().get(0).getFileName()}" alt="Thumbnail">
                                            </div>
                                            <div class="property-card__information" style="height: fit-content; padding: 20px;">
                                                <div style="display: flex; align-items: center; gap: 10px">
                                                    <span class="property-card__information__name">${request.getProperty().getName()}</span>
                                                    <span class="text-white bg-primary rounded px-5 py-1"
                                                          style="width: fit-content">${request.getProperty().getAddress()}</span>
                                                </div>
                                                <div>
                                                    <span>Renter Name: </span>
                                                    <span class=""><b>${request.getRenter().getName()}</b></span>
                                                </div>
                                                <div>
                                                    <span>Renter Address: </span>
                                                    <span class=""><b>${request.getRenter().getAddress()}</b></span>
                                                </div>
                                                <div>
                                                    <span>Renter Phone: </span>
                                                    <span class=""><b>${request.getRenter().getPhone()}</b></span>
                                                </div>
                                                <div>
                                                    <span>Renter Email: </span>
                                                    <span class=""><b>${request.getRenter().getEmail()}</b></span>
                                                </div>
                                                <div>
                                                    <span>Renter Time: </span>
                                                    <span class=""><b>${request.getRequestDate()}</b></span>
                                                </div>
                                                <div class="property-card__information__bottom mt-10">
                                                    <a href="tel:${request.getRenter().getPhone()}" class="btn btn-outline btn-outline-primary btn-icon"><i
                                                            class="fa-solid fa-phone"></i></a>
                                                    <a href="mailto:${request.getRenter().getEmail()}" class="btn btn-outline btn-outline-primary btn-icon btn-primary"><i
                                                            class="fa-solid fa-envelope"></i></a>
                                                    <a href="${baseURL}/dashboard/requests/accept?requestid=${request.getId()}" class="btn btn-primary"><i class="fa-solid fa-check"></i>
                                                        Accept</a>
                                                    <a href="#" class="btn btn-danger" style="background: #ce0000"><i class="fa-solid fa-x"></i> End</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
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

            <script>
                function askToDelete(pid) {
                    if (confirm("Are you sure to delete this property ?") == true) {
                        window.location.replace("${baseURL}/dashboard/deleteproperty?pid=" + pid)
                    }
                }

            </script>
    </body>
    <!--end::Body-->

</html>

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
                            <!--begin::Row-->
                            <div class="row g-xl-8">

                                <c:forEach items="${requestScope.listProperty}" var="property">
                                    <!--begin::Col-->
                                    <div class="col-xxl-4">
                                        <!--begin::Property-->
                                        <div class="property-card shadow my-2">
                                            <div class="property-card__thumbnail">
                                                <img src="${baseURL}/assets/images/${property.getImages().get(0).getFileName()}" alt="Thumbnail">
                                            </div>
                                            <div class="property-card__information">
                                                <div class="property-card__information__short">
                                                    <span>${property.type.type}</span>
                                                    <span>•</span>
                                                    <span>${property.area}m2</span>
                                                </div>
                                                <span class="property-card__information__name">${property.name}</span>
                                                <span class="property-card__information__address mb-2">${property.address}</span>
                                                    <span><b class="text-primary">${property.price}đ</b>/month</span>
                                                    <div class="property-card__information__bottom">
                                                        <a href="editproperty?pid=${property.id}" class="btn btn-icon btn-primary"><i
                                                                class="fa-solid fa-pen"></i></a>
                                                                <a onclick="askToDelete(${property.id})" class="btn btn-icon btn-danger"><i
                                                                class="fa-solid fa-trash"></i></a>
                                                    </div>
                                            </div>
                                        </div>
                                        <!--end::Property-->
                                    </div>
                                    <!--end::Col-->
                                </c:forEach>

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
        
        <script>
            function askToDelete(pid){
                if (confirm("Are you sure to delete this property ?") == true) {window.location.replace("${baseURL}/dashboard/deleteproperty?pid=" + pid)}
            }
            
        </script>
    </body>
    <!--end::Body-->

</html>

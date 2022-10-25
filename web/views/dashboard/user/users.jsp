<%-- 
    Document   : host/properties
    Created on : Oct 9, 2022, 10:39:52 PM
    Author     : ThuongTTHE163555
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!--begin::Head-->
    <head>
        <jsp:include page="../base/headImport.jsp" />
        <style>

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
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr class="fw-bold fs-6 text-gray-800">
                                            <th>#</th>
                                            <th>Avatar</th>
                                            <th>Name</th>
                                            <th>Username</th>
                                            <th>Phone</th>
                                            <th>Email</th>
                                            <th>Address</th>
                                            <th>Role</th>
                                            <th>Is Verify</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${requestScope.userList}" var="user" varStatus="theCount">
                                        <tr style="width: 30px; vertical-align: middle;">
                                            <td>${theCount.count}</td>
                                            <td>
                                                <img 
                                                    src="${baseURL}/assets/images/${user.avatar}" 
                                                    class="rounded-circle border border-3 border-black"
                                                    height="45rem"/>
                                            </td>
                                            <td>${user.name}</td>
                                            <td>${user.username}</td>
                                            <td>${user.phone}</td>
                                            <td>${user.email}</td>
                                            <td>${user.address}</td>
                                            <td>
                                                <c:choose>

                                                    <c:when test = "${user.role == 3}">
                                                        Admin
                                                    </c:when>

                                                    <c:when test = "${user.role == 2}">
                                                        Host
                                                    </c:when>

                                                    <c:otherwise>
                                                        Renter
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${user.verify}</td>
                                            <td><div class="dropdown">
                                                    <button class="btn" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                       <i class="fa-solid fa-ellipsis-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                                                        <a class="dropdown-item" href="${baseURL}/profile?uid=${user.id}">Update</a>
                                                        <a class="dropdown-item" href="#">Delete</a>
                                                    </div>
                                                </div></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
    <!--end::Body-->

</html>

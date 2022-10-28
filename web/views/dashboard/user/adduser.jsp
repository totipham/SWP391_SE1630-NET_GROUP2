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
                <jsp:include page="../component/aside_admin.jsp" />
                <!--begin::Wrapper-->
                <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
                    <jsp:include page="../component/header.jsp" />
                    <!--begin::Content-->
                    <div class="content d-flex flex-column flex-column-fluid fs-6" id="kt_content">
                        <!--begin::Container-->
                        <div class="container-fluid" id="kt_content_container">
                            <form action="adduser" method="post">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">Add User</h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="name">Name <span style="color: red">*</span></label>
                                                    <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="username">Username <span style="color: red">*</span></label>
                                                    <input type="text" class="form-control" name="username" id="username" placeholder="Enter Username" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="phone">Phone <span style="color: red">*</span></label>
                                                    <input type="phone" class="form-control" name="phone" id="phone" placeholder="Enter Phone" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="email">Email <span style="color: red">*</span></label>
                                                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter Email" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="address">Address <span style="color: red">*</span></label>
                                                    <input type="address" class="form-control" name="address" id="address" placeholder="Enter Address" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="password">Password <span style="color: red">*</span></label>
                                                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter Password" required>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="password_confirmation">Confirm Password <span style="color: red">*</span></label>
                                                    <input type="password" class="form-control" name="password_confirmation" id="password_confirmation" placeholder="Enter Confirm Password">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group m-3">
                                                    <label class="fw-bold mb-2" for="role">Role <span style="color: red">*</span></label>
                                                    <select class="form-control" name="role" id="role">
                                                        <option value="renter">Renter</option>
                                                        <option value="host">Host</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary">Add</button>
                                    </div>
                                </div>
                            </form>
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

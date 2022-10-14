<%-- 
    Document   : host/addproperties
    Created on : Oct 9, 2022, 10:39:52 PM
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
                        <div class="container-fluid" id="kt_content_container">
                            <!--begin::Stepper-->
                            <div class="stepper stepper-pills" id="add-property-stepper">
                                <!--begin::Nav-->
                                <div class="stepper-nav flex-center flex-wrap mb-10">
                                    <!--begin::Step 1-->
                                    <div class="stepper-item mx-2 my-4 current" data-kt-stepper-element="nav"
                                         data-kt-stepper-action="step">
                                        <!--begin::Line-->
                                        <div class="stepper-line w-40px"></div>
                                        <!--end::Line-->

                                        <!--begin::Icon-->
                                        <div class="stepper-icon w-40px h-40px">
                                            <i class="stepper-check fas fa-check"></i>
                                            <span class="stepper-number">1</span>
                                        </div>
                                        <!--end::Icon-->

                                        <!--begin::Label-->
                                        <div class="stepper-label">
                                            <h3 class="stepper-title">
                                                Step 1
                                            </h3>

                                            <div class="stepper-desc">
                                                Information
                                            </div>
                                        </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Step 1-->

                                    <!--begin::Step 2-->
                                    <div class="stepper-item mx-2 my-4" data-kt-stepper-element="nav"
                                         data-kt-stepper-action="step">
                                        <!--begin::Line-->
                                        <div class="stepper-line w-40px"></div>
                                        <!--end::Line-->

                                        <!--begin::Icon-->
                                        <div class="stepper-icon w-40px h-40px">
                                            <i class="stepper-check fas fa-check"></i>
                                            <span class="stepper-number">2</span>
                                        </div>
                                        <!--begin::Icon-->

                                        <!--begin::Label-->
                                        <div class="stepper-label">
                                            <h3 class="stepper-title">
                                                Step 2
                                            </h3>

                                            <div class="stepper-desc">
                                                Description
                                            </div>
                                        </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Step 2-->

                                    <!--begin::Step 3-->
                                    <div class="stepper-item mx-2 my-4" data-kt-stepper-element="nav"
                                         data-kt-stepper-action="step">
                                        <!--begin::Line-->
                                        <div class="stepper-line w-40px"></div>
                                        <!--end::Line-->

                                        <!--begin::Icon-->
                                        <div class="stepper-icon w-40px h-40px">
                                            <i class="stepper-check fas fa-check"></i>
                                            <span class="stepper-number">3</span>
                                        </div>
                                        <!--begin::Icon-->

                                        <!--begin::Label-->
                                        <div class="stepper-label">
                                            <h3 class="stepper-title">
                                                Step 3
                                            </h3>

                                            <div class="stepper-desc">
                                                Renting Fee
                                            </div>
                                        </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Step 3-->

                                    <!--begin::Step 4-->
                                    <div class="stepper-item mx-2 my-4" data-kt-stepper-element="nav"
                                         data-kt-stepper-action="step">
                                        <!--begin::Line-->
                                        <div class="stepper-line w-40px"></div>
                                        <!--end::Line-->

                                        <!--begin::Icon-->
                                        <div class="stepper-icon w-40px h-40px">
                                            <i class="stepper-check fas fa-check"></i>
                                            <span class="stepper-number">4</span>
                                        </div>
                                        <!--begin::Icon-->

                                        <!--begin::Label-->
                                        <div class="stepper-label">
                                            <h3 class="stepper-title">
                                                Step 4
                                            </h3>

                                            <div class="stepper-desc">
                                                Some Images
                                            </div>
                                        </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Step 4-->
                                </div>
                                <!--end::Nav-->

                                <!--begin::Form-->
                                <form class="form w-lg-500px mx-auto" id="add-property-stepper" action="a" method="get">
                                    <!--begin::Group-->
                                    <div class="mb-5">
                                        <!--begin::Step 1-->
                                        <div class="flex-column current" data-kt-stepper-element="content">
                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Property Name</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter your property full name"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <input type="text" class="form-control form-control-solid" name="name"
                                                       placeholder="" value="" />
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->

                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Property Address</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter your property full address"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <input type="text" class="form-control form-control-solid" name="address"
                                                       placeholder="" value="" />
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->
                                        </div>
                                        <!--end::Step 1-->

                                        <!--begin::Step 2-->
                                        <div class="flex-column" data-kt-stepper-element="content">
                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Property Type</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Select your property type"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Combo Box-->
                                                <select class="form-select" aria-label="Select property type" name="type">
                                                    <option>Select Type</option>
                                                    <option value="1">Motel</option>
                                                    <option value="2">Dorm</option>
                                                    <option value="3">Private House</option>
                                                </select>
                                                <!--end::Combo Box-->
                                            </div>
                                            <!--end::Input group-->

                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Property Description</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter your property description"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <textarea class="form-control form-control-solid" rows="3"
                                                          name="description" placeholder=""></textarea>
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->

                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Total Property</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter price for renting one month"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <input type="number" class="form-control form-control-solid" name="total"
                                                       placeholder="" value="" />
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->
                                        </div>
                                        <!--end::Step 2-->

                                        <!--begin::Step 3-->
                                        <div class="flex-column" data-kt-stepper-element="content">
                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Monthly Price</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter price for renting one month"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <input type="number" class="form-control form-control-solid" name="price"
                                                       placeholder="" value="" />
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->

                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Repeater-->
                                                <div id="utility-form-repeater">
                                                    <!--begin::Form group-->
                                                    <div class="repeater"  data-limit="5">
                                                        <div data-repeater-list="utility-form-repeater">
                                                            <div id="form-repeater" data-repeater-item>
                                                                <div class="form-group row">
                                                                    <div class="col-md-4">
                                                                        <label class="form-label">Name:</label>
                                                                        <input type="text"
                                                                               name="uname"
                                                                               class="form-control mb-2 mb-md-0"
                                                                               placeholder="Name" />
                                                                    </div>
                                                                    <div class="col-md-3">
                                                                        <label class="form-label">Fee:</label>
                                                                        <input type="number"
                                                                               name="ufee"
                                                                               class="form-control mb-2 mb-md-0"
                                                                               placeholder="Fee" />
                                                                    </div>
                                                                    <div class="col-md-3">
                                                                        <label class="form-label">Period:</label>
                                                                        <input type="text"
                                                                               name="uperiod"
                                                                               class="form-control mb-2 mb-md-0"
                                                                               placeholder="Period" />
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <a href="javascript:;" data-repeater-delete
                                                                           class="btn btn-sm btn-light-danger mt-3 mt-md-8">
                                                                            <i class="la la-trash-o"></i>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!--end::Form group-->

                                                    <!--begin::Form group-->
                                                    <div class="form-group mt-5">
                                                        <a href="javascript:;" data-repeater-create
                                                           class="btn btn-light-primary">
                                                            <i class="la la-plus"></i>Add
                                                        </a>
                                                    </div>
                                                    <!--end::Form group-->
                                                </div>
                                                <!--end::Repeater-->


                                            </div>
                                            <!--end::Input group-->
                                        </div>
                                        <!--end::Step 3-->

                                        <!--begin::Step 4-->
                                        <div class="flex-column" data-kt-stepper-element="content">
                                            <!--begin::Input group-->
                                            <div class="fv-row">
                                                <!--begin::Dropzone-->
                                                <div class="dropzone" id="upload-image-dropzone">
                                                    <!--begin::Message-->
                                                    <div class="dz-message needsclick">
                                                        <!--begin::Icon-->
                                                        <i class="bi bi-file-earmark-arrow-up text-primary fs-3x"></i>
                                                        <!--end::Icon-->

                                                        <!--begin::Info-->
                                                        <div class="ms-4">
                                                            <h3 class="fs-5 fw-bold text-gray-900 mb-1">Drop files here or
                                                                click to upload.</h3>
                                                            <span class="fs-7 fw-semibold text-gray-400">Upload up to 10
                                                                files</span>
                                                        </div>
                                                        <!--end::Info-->
                                                    </div>
                                                </div>
                                                <!--end::Dropzone-->
                                            </div>
                                            <!--end::Input group-->
                                        </div>
                                        <!--end::Step 4-->
                                    </div>
                                    <!--end::Group-->

                                    <!--begin::Actions-->
                                    <div class="d-flex flex-stack">
                                        <!--begin::Wrapper-->
                                        <div class="me-2">
                                            <button type="button" class="btn btn-light btn-active-light-primary"
                                                    data-kt-stepper-action="previous">
                                                Back
                                            </button>
                                        </div>
                                        <!--end::Wrapper-->

                                        <!--begin::Wrapper-->
                                        <div>
                                            <button type="submit" class="btn btn-primary" data-kt-stepper-action="submit">
                                                <span class="indicator-label">
                                                    Submit
                                                </span>
                                                <span class="indicator-progress">
                                                    Please wait... <span
                                                        class="spinner-border spinner-border-sm align-middle ms-2"></span>
                                                </span>
                                            </button>

                                            <button type="button" class="btn btn-primary" data-kt-stepper-action="next">
                                                Continue
                                            </button>
                                        </div>
                                        <!--end::Wrapper-->
                                    </div>
                                    <!--end::Actions-->
                                </form>
                                <!--end::Form-->
                            </div>
                            <!--end::Stepper-->
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
        <!--begin::Page Custom Javascript(used by this page)-->
        <script src="${baseURL}/views/js/custom/widgets.js"></script>
        <script src="${baseURL}/views/js/custom/dropzonejs.js"></script>
        <script src="${baseURL}/views/plugins/custom/prismjs/prismjs.bundle.js"></script>
        <script src="${baseURL}/views/plugins/custom/formrepeater/formrepeater.bundle.js"></script>
        <script src="${baseURL}/views/plugins/custom/formrepeater/basic.js"></script>
        <!--end::Page Custom Javascript-->
        <script>
            // Stepper lement
            var element = document.querySelector("#add-property-stepper");

            // Initialize Stepper
            var stepper = new KTStepper(element);

            // Handle navigation click
            stepper.on("kt.stepper.click", function (stepper) {
                stepper.goTo(stepper.getClickedStepIndex()); // go to clicked step
            });

            // Handle next step
            stepper.on("kt.stepper.next", function (stepper) {
                stepper.goNext(); // go next step
            });

            // Handle previous step
            stepper.on("kt.stepper.previous", function (stepper) {
                stepper.goPrevious(); // go previous step
            });

            var myDropzone = new Dropzone("#upload-image-dropzone", {
                url: "uploadimage", // Set the url for your upload script location
                paramName: "thumbnail", // The name that will be used to transfer the file
                maxFiles: 3,
                maxFilesize: 10, // MB
                addRemoveLinks: true,
                accept: function (file, done) {
                    if (file.name == "wow.jpg") {
                        done("Naha, you don't.");
                    } else {
                        done();
                    }
                }
            });
        </script>
    </body>
    <!--end::Body-->

</html>
<%-- 
    Document   : host/addproperties
    Created on : Oct 9, 2022, 10:39:52 PM
    Author     : ThuongTTHE163555
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <!--begin::Head-->
    <head>
        <jsp:include page="../base/headImport.jsp" />
        <style>
            input, select, textarea {
                border-radius: 16px !important;
            }

            .upload-group label {
                background-color: #306844;
                color: white;
                padding: 0.5rem;
                font-family: sans-serif;
                border-radius: 0.3rem;
                cursor: pointer;
                margin-top: 1rem;
            }

            .upload-group #file-chosen{
                margin-left: 0.3rem;
                font-family: sans-serif;
            }

            .utility-row {
                background: #fff;
                padding: 16px;
                border: 1px solid #eee;
                border-radius: 16px;
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
                <jsp:include page="../component/aside_admin.jsp" />
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
                                <c:set var="property" scope="request" value="${property}" />
                                <!--begin::Form-->
                                <form class="form w-lg-500px mx-auto" id="add-property-stepper" action="addproperty" enctype="multipart/form-data" method="post">
                                    <!--begin::Group-->
                                    <div class="mb-5">
                                        <!--begin::Step 1-->
                                        <div class="flex-column current" data-kt-stepper-element="content">
                                            <input name="id" value="${property.id}" hidden />
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
                                                <input type="text" class="form-control form-control-solid bg-white border" name="name"
                                                       placeholder="" value="${property.name}"/>
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
                                                <input type="text" class="form-control form-control-solid bg-white border" name="address"
                                                       placeholder="" value="${property.address}"/>
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->

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
                                                <select class="form-select bg-white border" aria-label="Select property type" name="typeid">
                                                    <option>Select Type</option>
                                                    <option value="1" ${property.type.id == 1 ? " selected" : ""}>Dorm</option>
                                                    <option value="2" ${property.type.id == 2 ? " selected" : ""}>Motel</option>
                                                    <option value="3" ${property.type.id == 3 ? " selected" : ""}>Private House</option>
                                                </select>
                                                <!--end::Combo Box-->
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
                                                    <span class="required">Property Description</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter your property description"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <textarea class="form-control form-control-solid bg-white border" rows="3"
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
                                                <input type="number" class="form-control form-control-solid bg-white border" name="total"
                                                       placeholder="" value="${property.total}"/>
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->

                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Label-->
                                                <label class="form-label d-flex align-items-center">
                                                    <span class="required">Property Area</span>
                                                    <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                       title="Enter property area"></i>
                                                </label>
                                                <!--end::Label-->

                                                <!--begin::Input-->
                                                <input type="number" class="form-control form-control-solid bg-white border" name="area"
                                                       placeholder="" value="${property.area}"/>
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
                                                <input type="number" class="form-control form-control-solid bg-white border" name="price"
                                                       placeholder="" value="${property.price}"/>
                                                <!--end::Input-->
                                            </div>
                                            <!--end::Input group-->

                                            <!--begin::Input group-->
                                            <div class="fv-row mb-10">
                                                <!--begin::Repeater-->
                                                <div id="utility-form-repeater">
                                                    <!--begin::Label-->
                                                    <label class="form-label d-flex align-items-center">
                                                        <span class="">Utility Fee</span>
                                                        <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip"
                                                           title="Enter property utility fee"></i>
                                                    </label>
                                                    <!--end::Label-->
                                                    <!--begin::Form group-->
                                                    <div class="repeater" data-limit="5">
                                                        <div data-repeater-list="utility-form-repeater">
                                                            <c:forEach items="${property.utilities}" var="u">
                                                                <div id="form-repeater" class="utility-row my-3" data-repeater-item>
                                                                    <div class="form-group row">
                                                                        <div class="col-md-4">
                                                                            <label class="form-label required">Name:</label>
                                                                            <input type="text"
                                                                                   name="uname"
                                                                                   value="${u.name}"
                                                                                   class="form-control mb-2 mb-md-0 bg-white border"
                                                                                   placeholder="Name" />
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <label class="form-label required">Fee:</label>
                                                                            <input type="number"
                                                                                   name="ufee"
                                                                                   value="${u.price}"
                                                                                   class="form-control mb-2 mb-md-0 bg-white border"
                                                                                   placeholder="Fee" />
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <label class="form-label required">Period:</label>
                                                                            <input type="text"
                                                                                   name="uperiod"
                                                                                   value="${u.period}"
                                                                                   class="form-control mb-2 mb-md-0 bg-white border"
                                                                                   placeholder="Period" />
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <a href="javascript:;" data-repeater-delete
                                                                               class="btn btn-light-danger mt-3 mt-md-8">
                                                                                <i class="la la-trash-o"></i>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:forEach>

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
                                                <div class="upload-group">
                                                    <!-- actual upload which is hidden -->
                                                    <input type="file" accept="image/png, image/jpeg" name="images" multiple multiple id="actual-btn" hidden/>

                                                    <!-- our custom upload button -->
                                                    <label for="actual-btn">Choose File</label>

                                                    <!-- name of file chosen -->
                                                    <span id="file-chosen">No file chosen</span>
                                                </div>
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
                                            <p id="error"></p>
                                            <button id="submit-btn" type="submit" class="btn btn-primary" data-kt-stepper-action="submit">
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
        <script src="${baseURL}/assets/js/custom/widgets.js"></script>
        <script src="${baseURL}/assets/js/custom/dropzonejs.js"></script>
        <script src="${baseURL}/assets/plugins/custom/prismjs/prismjs.bundle.js"></script>
        <script src="${baseURL}/assets/plugins/custom/formrepeater/formrepeater.bundle.js"></script>
        <script src="${baseURL}/assets/plugins/custom/formrepeater/basic.js"></script>
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

            const actualBtn = document.getElementById('actual-btn');

            const fileChosen = document.getElementById('file-chosen');

            actualBtn.addEventListener('change', function () {
                var files = $(this)[0].files;
                fileChosen.textContent = "You have selected " + files.length + " images for this property"
            })


            // Define form element
            const form = document.getElementById('add-property-stepper');

            // Init form validation rules. For more info check the FormValidation plugin's official documentation:https://formvalidation.io/
            var validator = FormValidation.formValidation(
                    form,
                    {
                        fields: {
//                            'name': {
//                                validators: {
//                                    notEmpty: {
//                                        message: 'Name input is required'
//                                    }
//                                }
//                            },
//                            'address': {
//                                validators: {
//                                    notEmpty: {
//                                        message: 'Address input is required'
//                                    }
//                                }
//                            },
//                            'type': {
//                                validators: {
//                                    notEmpty: {
//                                        message: 'Text input is required'
//                                    }
//                                }
//                            },
//                            'description': {
//                                validators: {
//                                    notEmpty: {
//                                        message: 'Text input is required'
//                                    }
//                                }
//                            },
//                            'total': {
//                                validators: {
//                                    notEmpty: {
//                                        message: 'Text input is required'
//                                    }
//                                }
//                            },
//                            'price': {
//                                validators: {
//                                    notEmpty: {
//                                        message: 'Text input is required'
//                                    }
//                                }
//                            },
                        },

                        plugins: {
                            trigger: new FormValidation.plugins.Trigger(),
                            bootstrap: new FormValidation.plugins.Bootstrap5({
                                rowSelector: '.fv-row',
                                eleInvalidClass: '',
                                eleValidClass: ''
                            })
                        }
                    }
            );

            // Submit button handler
            const submitButton = document.getElementById('submit-btn');
            submitButton.addEventListener('click', function (e) {


                // Validate form before submit
                if (validator) {
                    validator.validate().then(function (status) {
                        console.log('validated!');

                        if (status == 'Valid') {
                            e.currentTarget.submit(); // Submit form

                            // Show loading indication
                            submitButton.setAttribute('data-kt-indicator', 'on');

                            // Disable button to avoid multiple click
                            submitButton.disabled = true;

                            // Simulate form submission. For more info check the plugin's official documentation: https://sweetalert2.github.io/
                            setTimeout(function () {
                                // Remove loading indication
                                submitButton.removeAttribute('data-kt-indicator');


                            }, 1000);
                        } else {
                            // Prevent default button action
                            e.preventDefault();
                            submitButton.style.background = "#ae2012";

                        }
                    });
                }
            });
        </script>
    </body>
    <!--end::Body-->

</html>

<%-- 
Document   : property
Created on : Sep 30, 2022, 1:02:59 PM
Author     : DucPTMHE160517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>
        <title>Request ${requestScope.property.name} - Hostalpy</title>
        <style>
            .form-container {
                padding: 30px;
                border-radius: 20px;

            }

            .form-container span{
                font-weight: 500;
            }

            .form-container input[type='text'], .form-container input[type='email']{
                background: #f7f7f7;
                width: 100%;
                display: block;
                margin-block: 10px;
            }

            .form-container input[type='submit']{
                width: 30%;
            }
            .rating-input {
                position: absolute !important;
                left: -9999px !important;
            }

            .rating-input[disabled] {
                display: none;
            }

            .rating-label {
                padding: 0;
                margin: 0;
            }

            .rating-label>i,
            .rating-label>.svg-icon {
                font-size: 2.5rem;
                line-height: 1;
                color: var(--rating-color-default);
            }

            label.rating-label {
                cursor: pointer;
            }

            div.rating-label.checked>i,
            div.rating-label.checked>.svg-icon,
            label.rating-label>i,
            label.rating-label>.svg-icon {
                color: var(--rating-color-active);
            }

            .rating-input:checked~.rating-label>i,
            .rating-input:checked~.rating-label>.svg-icon {
                color: var(--rating-color-default);
            }

            .rating:hover label.rating-label>i,
            .rating:hover label.rating-label>.svg-icon {
                color: var(--rating-color-active);
            }

            label.rating-label:hover~.rating-label {
                color: var(--rating-color-default);
            }

            label.rating-label:hover~.rating-label>i,
            label.rating-label:hover~.rating-label>.svg-icon {
                color: var(--rating-color-default);
            }
        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar-nosearch.jsp" />
        <c:set var="p" scope="request" value="${property}" />
        <c:set var="u" scope="request" value="${user}" />
        <div class="mt-2 px-10">
            <div class="grid grid-cols-3 gap-10">
                <div class="col-span-1">
                    <div class="property-card shadow-xl my-2">
                        <a href="property?id=${p.id}">
                            <div class="property-card__thumbnail">
                                <img src="${baseURL}/assets/images/${p.getImages().get(0).getFileName()}" alt="Thumbnail">
                            </div>
                            <div class="property-card__information">
                                <div class="property-card__information__short text-primary">
                                    <span>${p.getType().getType()}</span>
                                    <span>•</span>
                                    <span>${p.area}m2</span>
                                </div>
                                <span class="property-card__information__name">${p.name}</span>
                                <span class="property-card__information__address">${p.address}</span>
                                <div class="property-card__information__bottom">
                                    <span>${p.price}₫/month</span>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-span-2">
                    <div class="border border-[1px] border-[#eee] rounded-xl p-7 shadow-xl">
                        <div class="text-left">
                            <h3 class="text-2xl font-bold">Let’s other renter<br>know your feedback</h3>
                        </div>
                        <form class="mt-5" action="feedback" method="POST">
                            <input type="hidden" name="pid" value="${p.id}" />
                            <div class="mb-5">
                                <span class="text-base font-semibold">Overall rate: <span
                                        class="text-red-400">*</span></span>
                                <div class="relative px-3 my-3" style="width: fit-content">
                                    <div class="flex items-center">
                                        <!--begin::Star 1-->
                                        <label class="rating-label" for="rating_input_1">
                                            <span class="svg-icon mx-2"><i
                                                    class="fa-solid fa-star"></i></span>
                                        </label>
                                        <input class="rating-input" name="rating" value="1" type="radio"
                                               id="rating_input_1" />
                                        <!--end::Star 1-->

                                        <!--begin::Star 2-->
                                        <label class="rating-label" for="rating_input_2">
                                            <span class="svg-icon mx-2"><i
                                                    class="fa-solid fa-star"></i></span>
                                        </label>
                                        <input class="rating-input" name="rating" value="2" type="radio"
                                               id="rating_input_2" />
                                        <!--end::Star 2-->

                                        <!--begin::Star 3-->
                                        <label class="rating-label" for="rating_input_3">
                                            <span class="svg-icon mx-2"><i
                                                    class="fa-solid fa-star"></i></span>
                                        </label>
                                        <input class="rating-input" name="rating" value="3" type="radio"
                                               id="rating_input_3" />
                                        <!--end::Star 3-->

                                        <!--begin::Star 4-->
                                        <label class="rating-label" for="rating_input_4">
                                            <span class="svg-icon mx-2"><i
                                                    class="fa-solid fa-star"></i></span>
                                        </label>
                                        <input class="rating-input" name="rating" value="4" type="radio"
                                               id="rating_input_4" />
                                        <!--end::Star 4-->

                                        <!--begin::Star 5-->
                                        <label class="rating-label" for="rating_input_5">
                                            <span class="svg-icon mx-2"><i
                                                    class="fa-solid fa-star"></i></span>
                                        </label>
                                        <input class="rating-input" name="rating" value="5" type="radio"
                                               id="rating_input_5" />
                                        <!--end::Star 5-->
                                    </div>
                                    <div class="absolute top-[50%] left-0 right-0"  style="z-index: -1">
                                        <div class="bg-[#eee] h-[30px] rounded-xl"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-5">
                                <span class="text-base font-semibold">Header:</span><br>
                                <input class="px-5 mt-3 w-[100%] rounded-lg" type="text" name="header" placeholder="Enter your feedback header"
                                       minlength="11" maxlength="200" />
                            </div>
                            <span class="text-base font-semibold">Content:</span>
                            <div class="mt-3">
                                <textarea class="p-5 bg-[#f7f7f7] h-[150px] w-[100%] outline-none rounded-lg"
                                          name="content" id="" placeholder="Enter your feedback content"></textarea>
                            </div>
                            <div class="text-left mt-10">
                                <input type="submit" class="bg-primary rounded-xl text-white text-base font-medium mx-auto px-5 cursor-pointer"
                                       value="Send Feedback">
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

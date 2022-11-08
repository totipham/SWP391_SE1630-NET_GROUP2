<%-- 
Document   : property
Created on : Sep 30, 2022, 1:02:59 PM
Author     : ThuongTTHE163555
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
                    <div class="property-card shadow-2xl my-2">
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
                    <!-- begin::Filter -->
                    <div class="float-right mb-5">
                        <div class="flex flex-row items-center gap-4">
                            <span class="text-black font-semibold">Sort by:</span>
                            <div class="relative">
                                <select name="sortby" class="border border-gray-300 rounded-md px-4 py-2 focus:outline-none focus:border-primary text-base">
                                    <option value="1">Best Star</option>
                                    <option value="2">Worst Star</option>
                                </select>
                                <div class="absolute right-2 top-2 pointer-events-none">
                                    <svg class="w-4 h-4 fill-current text-gray-400" xmlns="http://www.w3.org/2000/svg"
                                        viewBox="0 0 20 20">
                                        <path
                                            d="M7.293 7.707a1 1 0 0 1 1.414 0L12 10.586V3a1 1 0 0 1 2 0v7.586l2.293-2.293a1 1 0 0 1 1.414 1.414l-4 4a1 1 0 0 1-1.414 0l-4-4a1 1 0 0 1 0-1.414z" />
                                    </svg>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clear-both"></div>
                    <!-- end::Filter  -->
                    <!-- begin::Comment Section -->
                    <div class="bg-white border border-gray-200 rounded-2xl p-5 shadow-xl mb-3">
                        <div>
                            <span class="font-semibold text-xl text-black">Alexander</span>
                            <span class="text-base">26/10/2022</span>
                        </div>
                        <div class="text-yellow-500">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                        </div>
                        <div class="py-3">
                            <span class="font-semibold">Nice, good time here</span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis sint impedit,
                                perferendis dolorum itaque quam harum facilis qui consequuntur, doloremque distinctio
                                corrupti! Quasi perspiciatis fugiat, hic ratione voluptatem voluptas accusantium.</p>
                        </div>
                        <!-- begin::Owner Feedback Part -->
                        <div class="flex flex-row gap-5">
                            <a href="editfeedback" title="Edit Feedback"><i class="fa-solid fa-pen text-primary"></i></a>
                            <a href="deletefeedback" title="Delete Feedback"><i class="fa-solid fa-trash text-red-700"></i></a>
                        </div>
                        <!-- end::Owner Feedback Part  -->
                    </div>
                    <!-- end::Comment Section -->
                </div>
            </div>
        </div>
    </body>
</html>

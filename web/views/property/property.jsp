<%-- 
    Document   : property
    Created on : Sep 30, 2022, 1:02:59 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>
        <title>${requestScope.property.name} - Hostalpy</title>
        <style>
            .utilities-fee {
                border-radius: 20px;
            }

            .utilities-fee .utilities-fee--row span:nth-of-type(2){
                float: right;
            }

            .request-status {
                border-radius: 20px;
                padding: 25px;
            }

            .property-image {
                position: relative;
            }

            .property-image .report {
                color: #fff;
                font-size: 24px;
                position: absolute;
                top: 10px;
                right: 10px;
                z-index: 9;
            }

            .btn-disable {
                pointer-events: none;
                color: gray !important;
                border-color: gray !important;
            }

            .btn-disable.bg-primary {
                pointer-events: none;
                color: gray !important;
                border-color: gray !important;
                background: lightgray !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar.jsp" />
        <c:set var="p" scope="request" value="${property}" />
        <div class="container mx-auto mt-4 px-20">
            <div class="grid grid-cols-3 gap-7">
                <div class="col-span-2 mb-5">
                    <div class="property-image">
                        <div class="report bg-white hover:bg-gray-100 cursor-pointer rounded-full w-fit text-center px-3">
                            <a class="text-black text-base font-medium flex items-center gap-2" href="sendreport?target=property&targetid=${p.id}" title="Report ${p.name}"><i class="fa-solid fa-flag text-[#b41410]"></i> Report</a>
                        </div>

                        <div class="fotorama" >
                            <c:forEach items="${p.images}" var="i">
                                <img src="${baseURL}/assets/images/${i.fileName}">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="grid grid-cols-5 my- gap-7">
                        <div class="col-span-3">
                            <h3 class="text-2xl my-3"><b>🏡${p.name}</b></h3>
                            <p class=" my-3" style="font-weight: 400; font-size: 16px;">${p.address}</p>
                            <p><i>${p.description}</i></p>
                        </div>
                        <div class="col-span-2">

                            <h5 class="mb-3 font-semibold">Owner</h5>
                            <div
                                class="flex flex-row gap-3 items-center justify-between shadow-lg p-3 mb-5 owner-info border">
                                <img 
                                    src="${baseURL}/assets/images/${p.host.avatar != null ? p.host.avatar : "avatar.png"}" 
                                    alt="Host Avatar" 
                                    class="rounded-full" 
                                    width="60"
                                    />
                                <div>
                                    <div class="flex flex-col justify-between">
                                        <div>
                                            <a class="no-underline font-semibold" href="${baseURL}/profile?uid=${p.host.id}">${p.host.name}</a>
                                            <c:if test="${p.host.verify == true}">
                                                <span class="text-blue-900" title="This account has been verified"><i class="fa-solid fa-circle-check"></i></span>
                                                </c:if>
                                                <c:if test="${p.host.verify != true}">
                                                <span class="text-gray-600" title="This account is not verified yet"><i class="fa-solid fa-circle-xmark"></i></span>
                                                </c:if>
                                        </div>
                                    </div>
                                    <p>@${p.host.username}</p>
                                </div>
                                <div>
                                    <button class="btn btn-message">
                                        <a href="mailto:${p.host.email}">
                                            <i class="fa-solid fa-message"></i>
                                        </a>
                                    </button>
                                    <button class="btn btn-call">
                                        <a href="tel:${p.host.phone}">
                                            <i class="fa-solid fa-phone"></i>
                                        </a>
                                    </button>
                                </div>
                            </div>
                            <h5 class="mb-3 font-semibold">Utilities Fee</h5>
                            <div class="utilities-fee bg-white shadow-lg border p-3">
                                <c:forEach items="${p.utilities}" var="u">
                                    <div class="my-2 utilities-fee--row">
                                        <span><b>${u.name}:</b></span><span>${u.price}VND/${u.period}</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-span-1">
                    <iframe style="border-radius: 20px" class="shadow-2xl mb-4 border border-[#eee]" width="100%" height="30%" style="border:0"
                            loading="lazy" allowfullscreen referrerpolicy="no-referrer-when-downgrade"
                            src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAVR2X4a2N4zwtogFLmFXeOjbbIKqW06iw&q=`${p.name}, ${p.address}`">
                    </iframe>
                    <c:if test="${p.host.id == u.id}">
                        <div class="bg-white border rounded-xl p-5 shadow-2xl flex flex-col gap-5 items-center mt-5">
                            <div class="text-center">
                                <span class="font-semibold">You are owner of this property</span>
                            </div>
                            <div class="flex flex-row gap-5">
                                <button type="button" class="bg-green-900 hover:bg-green-800 px-5 py-3 rounded-xl">
                                    <a href="#" class="font-semibold text-white hover:text-white">Edit</a>
                                </button>
                                <button type="button" class="border border-10 border-red-600 hover:bg-gray-100 px-5 py-3 rounded-xl">
                                    <a href="#" class="font-semibold text-red-600 hover:text-red-600">Remove</a>
                                </button>


                            </div>
                        </div>
                    </c:if>
                    <div class="flex flex-col bg-white rounded-2xl shadow-xl border border-[#eee] p-7 mx-auto mt-5 ">
                        <div class="flex flex-row justify-between mb-7">
                            <div>
                                <span class="text-black font-semibold text-2xl" id="price">${p.price}</span>
                                <span>/month</span>
                            </div>
                            <div>
                                <span>★ 5.0 • <a class="no-underline" href="${baseURL}/feedback?pid=${p.id}"><u>15 reviews</u></a></span>
                            </div>
                        </div>
                        <div class="flex flex-col items-center justify-center gap-3">
                            <span>Love this property ?</span>
                            <c:if test ="${requestScope.hasRequest==true}">
                                <a href="deleterentingrequest?pid=${p.id}" class="bg-primary px-5 py-3 text-white hover:text-gray-200 rounded-2xl font-semibold w-[50%] text-center ${p.host.id == u.id ? "btn-disable" : ""}">
                                DELETE REQUEST
                            </a>
                            </c:if>
                            <c:if test ="${requestScope.hasRequest==false}">
                                <a href="sendrenting?pid=${p.id}" class="bg-primary px-5 py-3 text-white hover:text-gray-200 rounded-2xl font-semibold w-[50%] text-center ${p.host.id == u.id ? "btn-disable" : ""}">
                                RESERVE NOW
                            </a>
                            </c:if>
                            
                        </div>
                    </div>
                    <%--<c:if test="${requestScope.state != null}">--%>
                    <%--<jsp:include page="requeststatus.jsp" />--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${requestScope.state == null}">--%>
                    <%--<jsp:include page="requestStatus.jsp" />--%>
                    <%--</c:if>--%>
                    <!--                    <div class="recommend-list">
                                            <h5 class="mb-3">Recommend List</h5>
                                            <a href="property.html" class="d-flex flex-row p-3 my-4 card-property bg-white shadow">
                                                <div style="height: 140px; width: 240px; background: url(images/hlap.jpg);background-repeat: no-repeat;background-size: 100% 100%; border-radius: 10px;"></div>
                                                <div class="px-4 d-flex flex-column aligns-items-center">
                                                    <p style="margin-bottom: 0">Hoa Lac Apartment</p>
                                                    <p style="font-weight: 400; font-size: 14px;">Thạch Hoà, Thạch Thất, Hà Nội</p>
                                                    <div>
                                                        <span>₫4,000,000</span>
                                                        <span>/month</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>-->
                </div>
            </div>
        </div>
        <jsp:include page="../base/footer.jsp" />

        <script>
            var formatter = new Intl.NumberFormat('en-US', {
                style: 'currency',
                currency: 'VND',

                // These options are needed to round to whole numbers if that's what you want.
                //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
                //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
            });

            const price = document.getElementById('price').innerHTML;
            document.getElementById("price").innerHTML = formatter.format(price);
        </script>
    </body>
</html>

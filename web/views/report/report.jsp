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
        <title>Report ${requestScope.reportedProperty == null ? requestScope.reportedUser.name : requestScope.reportedProperty.name} - Hostalpy</title>
        <style>
            .form-container {
                padding: 30px;
                border-radius: 20px;

            }

            .form-container span{
                font-weight: 500;
            }

            .form-container input[type='text']{
                background: #f7f7f7;
                width: 100%;
                display: block;
                margin-block: 10px;
            }

            .form-container input[type='submit']{
                width: 30%;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar-nosearch.jsp" />
        <c:set var="targetid" scope="request" value="${target.id}" />
        <div class="mt-2 px-10">
            <div class="grid grid-cols-3 gap-10">
                <div class="col-span-1">
                    <c:if test="${requestScope.reportedProperty == null && requestScope.reportedUser != null}">
                        <c:set var="user" scope="request" value="${reportedUser}" />
                        <!--begin::option:Report user-->
                        <div class="border border-5 border-[#eee] rounded-2xl shadow-xl p-5">
                            <h3 class="text-md font-medium mb-2">Report on User:</h3>
                            <div class="flex flex-row items-center gap-10 border border-[1px] border-[#eee] rounded-2xl h-[100px] p-5 mb-5">
                                <img src="${baseURL}/assets/images/${reportedUser.avatar != null ? reportedUser.avatar : "avatar.png"}" alt="Avatar" class="rounded-full border border-[3px] border-primary" width="60">
                                <div>
                                    <p class="text-black"><b>${reportedUser.name}</b></p>
                                    <p>@${reportedUser.username}</p>
                                </div>
                            </div>
                        </div>
                        <!--end::option:Report user-->
                    </c:if>
                    <c:if test="${requestScope.reportedProperty != null && requestScope.reportedUser == null}">
                        <c:set var="property" scope="request" value="${reportedProperty}" />
                        <!--begin::option:Report property-->
                        <div class="property-card my-2 shadow-xl">
                            <div class="property-card__thumbnail">
                                <img src="${baseURL}/assets/images/${reportedProperty.getImages().get(0).getFileName()}" alt="Thumbnail">
                            </div>
                            <div class="property-card__information">
                                <div class="property-card__information__short text-primary">
                                    <span>${reportedProperty.type.type}</span>
                                    <span>•</span>
                                    <span>${reportedProperty.area}m2</span>
                                </div>
                                <span class="property-card__information__name">${reportedProperty.name}</span>
                                <span class="property-card__information__address">${reportedProperty.address}</span>
                                <div class="property-card__information__bottom">
                                    <span>${reportedProperty.price}đ</span>
                                </div>
                            </div>
                        </div>
                        <!--end::option:Report property-->
                    </c:if>

                </div>
                <div class="col-span-2">
                    <div class="form-container shadow-xl">
                        <div class="text-center">
                            <h3 class="text-2xl font-semibold">Report</h3>
                        </div>
                        <form class="mt-5" action="sendreport" method="POST">
                            <input name="targetid" value="${targetid}" hidden/>
                            <span class="text-base">Type: <span class="text-red-400">*</span></span>
                            <select name="type"
                                    class="bg-[#f7f7f7] px-5 w-[100%] h-12 rounded my-3 outline-none cursor-pointer"
                                    required>
                                <option>Select type of your report</option>
                                <c:forEach items="${requestScope.reportTypeList}" var="reportType">
                                    <option value="${reportType.id}">${reportType.type}</option>
                                </c:forEach>
                            </select><br>
                            <span class="text-base">Header: <span class="text-red-400">*</span></span>
                            <input class="px-5" type="text" name="header" placeholder="Enter your report header" minlength="11"
                                   maxlength="200" required />
                            <span class="text-base">Content: <span class="text-red-400">*</span></span>
                            <div class="mt-3">
                                <textarea class="p-5 bg-[#f7f7f7] h-[150px] w-[100%] outline-none rounded-lg" name="content" placeholder="Enter your report content" required></textarea>
                            </div>
                            <div class="text-center mt-10">
                                <input type="submit" class="bg-primary text-white mx-auto cursor-pointer"
                                       value="Report">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

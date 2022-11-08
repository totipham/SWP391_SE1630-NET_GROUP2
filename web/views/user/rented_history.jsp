<%-- 
    Document   : profile
    Created on : Sep 30, 2022, 11:05:12 PM
    Author     : AnhVHHE160580
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <title>Hostalpy - Profile</title>
        <style>
            table th:first-child {
                border-radius: 10px 0 0 10px;
            }

            table th:last-child {
                border-radius: 0 10px 10px 0;
            }

            th {
                padding-inline: 10px;
                padding-block: 5px;
            }

            td {
                padding-inline: 10px;
                padding-block: 20px;
            }

            tbody tr {
                border-bottom: 1px solid #e5e7eb;
            }
        </style>
    </head>

    <body>
        <jsp:include page="../component/navbar.jsp" />
        <div class="mt-2 px-10">
            <div class="flex flex-row items-center gap-3 mt-5">
                <h1 class="text-2xl font-bold">Rented History</h1>
                <div class="flex flex-row items-center gap-3">
                    <span class="text-gray-500">Sort by:</span>
                    <select name="" id="" class="border border-gray-300 rounded-md px-3 py-1">
                        <option value="">Date</option>
                        <option value="">Price</option>
                    </select>
                </div>
            </div>
            <div class="flex flex-row items-center gap-3 mt-5">
                <div class="flex flex-row items-center gap-3">
                    <span class="text-gray-500">From:</span>
                    <input type="date" class="border border-gray-300 rounded-md px-3 py-1">
                </div>
                <div class="flex flex-row items-center gap-3">
                    <span class="text-gray-500">To:</span>
                    <input type="date" class="border border-gray-300 rounded-md px-3 py-1">
                </div>
            </div>
            <div class="flex flex-row items-center gap-3 mt-5">
                <div class="flex flex-row items-center gap-3">
                    <span class="text-gray-500">Status:</span>
                    <select name="" id="" class="border border-gray-300 rounded-md px-3 py-1">
                        <option value="">All</option>
                        <option value="">Pending</option>
                        <option value="">Accepted</option>
                        <option value="">Rejected</option>
                    </select>
                </div>
            </div>
            <div>
                
                    <table class="w-[100%] my-3 border-collapse">
                        <thead class="bg-primary text-white">
                            <tr class="h-fit">
                                <th>#</th>
                                <th>Property</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody class="text-black text-center py-3">
                            <c:forEach items="${requestScope.listContract}" var="c">
                            <tr>
                                <td>${c.id}</td>
                                <td>
                                    <span class="text-lg font-medium text-black">${c.property.name}</span>
                                </td>
                                <td>
                                    <span class="text-lg font-medium text-black">
                                        <c:if test="${c.date != null}">
                                            ${c.date}
                                        </c:if>
                                    </span>
                                </td>
                                <td>
                                    <span class="text-lg font-medium text-black">
                                        <c:if test="${c.date != null}">
                                            ${c.date}
                                        </c:if>
                                    </span>
                                </td>
                                <td>
                                    <span class="text-lg font-medium text-primary">${c.status.status}</span>
                                </td>
                                <td>
                                    <i class="fa-solid fa-ellipsis-vertical"></i>
                                </td>
                            </tr>
                            </c:forEach>                            
                    </table>
                    
                    </div>
                </div>
                <%--<jsp:include page="../base/footer.jsp" />--%>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
                crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
                crossorigin="anonymous"></script>
            </body>


        </html>

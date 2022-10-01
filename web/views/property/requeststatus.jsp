<%-- 
    Document   : requeststatus
    Created on : Oct 1, 2022, 6:44:22 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="request-status shadow">
    <h4 class="text-center mb-4">Requesting Status</h4>
    <div class="text-center">
        <img src="${baseURL}/assets/images/sent.png" alt="Sent" height="80" class="my-3">
        <p>Your renting information has sent to this property owner!</p>
        <c:choose>
            <%--<c:when test="${requestScope.state.name == 'sent'}">--%>

            <%--</c:when>--%>
            <c:when test="${requestScope.state.name == 'received'}">
                <img src="${baseURL}/assets/images/received.png" alt="Sent" height="80" class="my-3">
                <p>This property owner has received your renting information!</p>
            </c:when>
            <c:when test="${requestScope.state.name == 'success'}">
                <img src="${baseURL}/assets/images/welcome.png" alt="Sent" height="80" class="my-3">
                <p>Welcome to <b>${p.name}</b>.<br>We proud to be your second home!</p>
                </c:when>
            </c:choose>
    </div>
</div>


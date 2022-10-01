<%-- 
    Document   : navbar
    Created on : Sep 27, 2022, 4:13:50 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="header">
    <div class="left-header">
        <a href="${baseURL}">
            <img src="${baseURL}/assets/images/logo-minimized.png" alt="" class="logo">
        </a>
        <input type="text" name="" id="" placeholder="Keywords/City/Region">
        <button class="btn btn-light">
            <i class="fa-solid fa-filter"></i>
            Filter
        </button>
    </div>
    <div class="right-header">
        <c:if test="${sessionScope.user != null}">
            <jsp:include page="alert.jsp" />
        </c:if>
        <div class="user-wrapper">
            <c:if test="${sessionScope.user == null}">
                <button class="btn btn-success rounded-0 shadow-none">
                    <a style="color: #fff;" href="login">Sign In</a>
                </button>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <c:set var="u" scope="session" value="${user}" />
                <div class="user-wrapper">
                    <span style="font-weight: 500; color: #575757; margin-right: 5px">${u.name}</span>
                    <a class="navbar--user-menu">
                        <img src="${baseURL}/assets/images/${u.avatar != null ? u.avatar : "avatar.png"}" alt="Avatar" class="rounded-circle border border-3 border-success" width="60" height="60">
                    </a>
                    <ul class="user-wrapper--menu shadow">
                        <c:if test="${sessionScope.user.getRole() == 1 || requestScope.user.getRole() == 2}">
                            <li><a href="dashboard">Dashboard</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user.getRole() == 3}">
                            <li><a href="hosts">Become a Host</a></li>
                        </c:if>
                        <li><a href="profile">Profile</a></li>
                        <li><a href="chgpwd">Change Password</a></li>
                        <li><a href="logout">Logout</a></li>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</div>

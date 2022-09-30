<%-- 
    Document   : navbar
    Created on : Sep 27, 2022, 4:13:50 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="header">
    <div class="left-header">
        <a href="/">
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
            <a class="normal-link" href="hosts">Become a Host</a>
            <jsp:include page="alert.jsp" />
        </c:if>
        <div class="user-wrapper">
            <c:if test="${sessionScope.user == null}">
                <button class="btn bg-white shadow-none">
                    <a href="login">Login</a>
                </button>
                <button class="btn btn-success rounded-0 shadow-none">
                    <a style="color: #fff;" href="register">Sign Up</a>
                </button>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <c:set var="u" scope="session" value="${user}" />
                <div class="user-wrapper">
                    <span>${u.name}</span>
                    <a class="navbar--user-menu">
                        <img src="${baseURL}/assets/images/${u.avatar != null ? u.avatar : "avatar.png"}" alt="Avatar" class="rounded-circle border border-3 border-success" width="60" height="60">
                    </a>
                    <ul class="user-wrapper--menu shadow">
                        <li><a href="dashboard">Dashboard</a></li>
                        <li><a href="profile">Profile</a></li>
                        <li><a href="chgpwd">Change Password</a></li>
                        <li><a href="logout">Logout</a></li>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</div>

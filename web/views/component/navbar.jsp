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
        <form action="search" method="GET">
            <input style="width: 300px; color: #575757;" type="text" name="keyword" id="" placeholder="Keywords/City/Region">
            <button class="bg-[#eaeaea] h-[50px] px-3 rounded">
                <i class="fa-solid fa-magnifying-glass"></i>
                Search
            </button>
        </form>
    </div>
    <div class="right-header">
        <c:if test="${sessionScope.user != null}">
            <jsp:include page="alert.jsp" />
        </c:if>
        <div class="user-wrapper">
            <c:if test="${sessionScope.user == null}">
                <a style="color: #575757; margin-right: 15px; font-weight: 500" href="login">Sign In</a>
                <button class="btn btn-success rounded shadow-0">
                    <a style="color: #fff;" href="register">Sign Up</a>
                </button>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <div class="user-wrapper">
                    <div class="flex flex-row items-center gap-3">
                        <span style="font-weight: 500; color: #575757; margin-right: 5px">${sessionScope.user.name}</span>
                        <a class="navbar--user-menu">
                            <img src="${baseURL}/assets/images/${sessionScope.user.avatar != null ? sessionScope.user.avatar : "avatar.png"}" alt="Avatar" class="rounded-full border border-[3px] border-primary" width="60" height="60">
                        </a>
                    </div>
                    <ul class="user-wrapper--menu shadow">
                        <c:if test="${sessionScope.user.getRole() == 1 || sessionScope.user.getRole() == 2}">
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

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
        <a class="normal-link" href="hosts">Become a Host</a>
        <div class="alert-wrapper">
            <i id="alert-btn" class="fa-regular fa-bell alert-icon mx-4"></i>
            <div id="alert-box" class="alert-container">
                <div class="alert-list">
                    <div class="alert-detail">
                        <div class="alert-detail__title">
                            <span>Welcome to your new living place!</span>
                            <span>24/09/2022</span>
                        </div>
                        <div class="alert-detail__property">
                            <span>Property:</span>
                            <span>KTX Ông Bà</span>
                            <p>Your property request has been accepted by host.</p>
                        </div>
                        <button class="btn btn-danger">View Property</button>
                    </div>
                </div>
                <div class="my-2 text-center">
                    <a href="notifications" class="normal-link">View All</a>
                </div>
            </div>
            <div id="backgroundOverlay"></div>
        </div>
        <div class="user-wrapper">
            <span>Toti Pham</span>
            <a class="navbar--user-menu">
                <img src="${baseURL}/assets/images/avatar.png" alt="Avatar" class="rounded-circle border border-5 border-success" width="60">
            </a>
            <ul class="user-wrapper--menu shadow">
                <li><a href="dashboard.html">Dashboard</a></li>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
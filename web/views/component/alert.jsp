<%-- 
    Document   : alert
    Created on : Sep 30, 2022, 2:23:19 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <button class="btn btn-success">View Property</button>
            </div>
        </div>
        <div class="my-2 text-center">
            <a href="notifications" class="normal-link">View All</a>
        </div>
    </div>
    <div id="backgroundOverlay"></div>
</div>
<script>
    window.onload = function () {
        var popup = document.getElementById('alert-box');
        var overlay = document.getElementById('backgroundOverlay');
        var openButton = document.getElementById('alert-btn');
        backgroundOverlay.style.display = "none";
        document.onclick = function (e) {
            if (e.target.id === 'backgroundOverlay') {
                popup.style.display = 'none';
                overlay.style.display = 'none';
            }
            if (e.target === openButton) {
                popup.style.display = 'block';
                overlay.style.display = 'block';
            }
        };
    };

</script>
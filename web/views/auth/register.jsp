<%-- 
    Document   : login
    Created on : Jun 19, 2022, 1:32:16 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register - Hostalpy</title>
        <style>

            * {
                box-sizing: border-box;
            }

            body {
                background: #f6f5f7;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                font-family: 'Montserrat', sans-serif;
                height: 100vh;
                margin: -20px 0 50px;
            }

            h1 {
                font-weight: bold;
                margin: 0;
            }

            h2 {
                text-align: center;
            }

            p {
                font-size: 14px;
                font-weight: 100;
                line-height: 20px;
                letter-spacing: 0.5px;
                margin: 20px 0 30px;
            }

            span {
                font-size: 12px;
            }

            a {
                color: #fff;
                font-size: 14px;
                text-decoration: none;
                margin: 15px 0;
            }

            button, .button {
                border-radius: 20px !important;
                border: 1px solid #306844;
                background-color: #306844;
                color: #FFFFFF;
                font-size: 12px;
                font-weight: bold;
                padding: 12px 45px;
                letter-spacing: 1px;
                text-transform: uppercase;
                transition: transform 80ms ease-in;
            }

            button:active, .button:active {
                transform: scale(0.95);
            }

            button:focus {
                outline: none;
            }

            button.ghost, .button.ghost {
                background-color: transparent;
                border-color: #FFFFFF;
            }

            form {
                background-color: #FFFFFF;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 50px;
                height: 100%;
                text-align: center;
            }

            input {
                background-color: #eee;
                border: none;
                padding: 12px 15px;
                margin: 8px 0;
                width: 100%;
            }

            .container {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 14px 28px rgba(0,0,0,0.25),
                    0 10px 10px rgba(0,0,0,0.22);
                position: relative;
                overflow: hidden;
                width: 768px;
                max-width: 980px !important;
                min-height: 600px;
            }

            .form-container {
                position: absolute;
                top: 0;
                height: 100%;
                transition: all 0.6s ease-in-out;
            }
            
             input{
                margin-block: 5px !important;
                border: none !important;
            }


            .container.right-panel-active .sign-in-container {
                transform: translateX(100%);
            }

            .sign-up-container {
                left: 0;
                width: 50%;
                opacity: 0;
                z-index: 1;
            }

            .container.right-panel-active .sign-up-container {
                transform: translateX(100%);
                opacity: 1;
                z-index: 5;
                animation: show 0.6s;
            }

            .overlay-container {
                position: absolute;
                top: 0;
                left: 50%;
                width: 50%;
                height: 100%;
                overflow: hidden;
                transition: transform 0.6s ease-in-out;
                z-index: 100;
            }

            .container.right-panel-active .overlay-container{
                transform: translateX(-100%);
            }

            .overlay {
                background: #16702e;
                background: -webkit-linear-gradient(to right, #306844, #16702e);
                background: linear-gradient(to right, #306844, #16702e);
                background-repeat: no-repeat;
                background-size: cover;
                background-position: 0 0;
                color: #FFFFFF;
                position: relative;
                left: -100%;
                height: 100%;
                width: 200%;
                transform: translateX(0);
                transition: transform 0.6s ease-in-out;
            }

            .container.right-panel-active .overlay {
                transform: translateX(50%);
            }

            .overlay-panel {
                position: absolute;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 40px;
                text-align: center;
                top: 0;
                height: 100%;
                width: 50%;
                transform: translateX(0);
                transition: transform 0.6s ease-in-out;
            }
        </style>
    </head>
    <body>
        <% if (request.getAttribute("registerMessage")!=null) {%>  
             
            <script> alert("${requestScope.registerMessage}"); </script>
        
        <%    }%> 
        
        <jsp:include page="../base/headerImport.jsp" />
        <div class="container right-panel-active" id="container">
            <div class="form-container sign-up-container">
                <form action="register" method="POST">
                    <h1>Create Account</h1>
                    <input type="text" name="name" placeholder="Name *" />
                    <input type="text" name="username" placeholder="Username *" />
                    <input type="password" name="password" placeholder="Password *" />
                    <input type="email" name="email" placeholder="Email *" />
                    <input type="text" name="phone" placeholder="Phone *" pattern="0[35789]{1}[0-9]{8}"/>
                    <input type="text" name="address" placeholder="Address *" />
                    <p style="color: red">${requestScope.error}</p>
                    <p style="color: green">${requestScope.success}</p>
                    <button class="my-3">Sign Up</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Hello, Friend!</h1>
                        <p>Start to rent new living place from now easily!</p>
                        <a href="login" style="color: #fff" class="button ghost">Sign In</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

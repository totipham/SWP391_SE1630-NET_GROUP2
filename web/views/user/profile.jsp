<%-- 
    Document   : profile
    Created on : Sep 30, 2022, 11:05:12 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <title>Hostalpy - Profile</title>
        <style>
            .profile input:not([type="submit"]) {
                width: 100%;
                border: 1px solid #ccc;
                border-radius: 10px;
                background: #fff;
                margin: 10px 0;
            }

            .profile span {
                color: #575757;
                font-weight: 500;
            }
        </style>
    </head>

    <body>
        <jsp:include page="../component/navbar.jsp" />
        <div class="profile container p-5 mt-3" style="border-radius: 20px">
            <form action="editavatar" method="POST" enctype='multipart/form-data'>
                <span><b>Avatar</b></span>
                <div class="my-3">
                    <img src="${baseURL}/assets/images/${requestScope.user.avatar != null ? requestScope.user.avatar : "avatar.jpg"}" alt="Avatar" class="rounded-circle" height="150" width="150">
                    <input type='file' id="image-avatar-upload" accept=".png, .jpg, .jpeg" name="avatar" onchange="this.form.submit()" hidden/>
                    <label for="image-avatar-upload" class="btn btn-primary mx-3" style="padding-block: 13px;">Choose file</label>
                    <!--<button class="btn btn-outline-danger">Remove</button>-->
                </div>
            </form>
            <form action="profile" class="" method="POST" style="border-radius: 20px">
                <div class="row mt-5">
                    <div class="col-md-6">
                        <span><b>Fullname</b></span><br>
                        <input type="text" maxlength="255" name="name" class="border" value="${requestScope.user.name}"><br>
                        <span><b>Phone</b></span><br>
                        <input type="text" maxlength="11" name="phone" class="border" value="${requestScope.user.phone}"><br>
                    </div>
                    <div class="col-md-6">
                        <span><b>Email</b></span><br>
                        <input type="email" maxlength="255" name="email" class="border" value="${requestScope.user.email}"><br>
                        <span><b>Address</b></span><br>
                        <input type="text" maxlength="255" name="address" class="border" value="${requestScope.user.address}"><br>
                    </div>
                    <p style="color: red;">${requestScope.error}</p>
                    <p style="color: green;">${requestScope.message}</p>
                </div>
                <button type="submit" class="btn btn-primary mt-5" style="padding-inline: 20px;">Save</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
    </body>


</html>

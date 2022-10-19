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
                border: 1px solid #ddd;
                border-radius: 10px;
                background: #fff;
                margin: 10px 0;
            }
        </style>
    </head>

    <body>
        <jsp:include page="../component/navbar.jsp" />
        <div class="px-20">
            <div class="profile border border-2 border-[#eee] p-10 mt-10 mx-auto shadow-2xl" style="border-radius: 20px">
                <c:if test="${requestScope.user.verify == true}">
                    <span class="float-right bg-blue-900 text-white px-5 py-1 rounded-full" title="This account has been verified">Verified Account <i class="fa-solid fa-circle-check"></i></span>
                    </c:if>
                    <c:if test="${requestScope.user.verify != true}">
                    <span class="float-right bg-gray-600 text-white px-5 py-1 rounded-full" title="Click here to verify your account"><a class="hover:text-white" href="${baseURL}/verify">Unverified Account <i class="fa-solid fa-circle-xmark"></i></a></span>
                        </c:if>
                <form action="editavatar" method="POST" enctype='multipart/form-data'>
                    <span class="text-base text-[#575757]"><b>Avatar</b></span>
                    <div class="my-3 flex flex-row items-center">
                        <img src="${baseURL}/assets/images/${requestScope.user.avatar != null ? requestScope.user.avatar : "avatar.jpg"}" alt="Avatar" class="rounded-full border border-[2px] border-primary" height="150" width="150">
                        <input type='file' id="image-avatar-upload" accept=".png, .jpg, .jpeg" name="avatar" onchange="this.form.submit()" hidden/>
                        <label for="image-avatar-upload" class="bg-primary text-white px-3 rounded mx-3" style="padding-block: 13px;">Choose file</label>
                        <!--<button class="btn btn-outline-danger">Remove</button>-->
                    </div>
                </form>
                <form action="updateprofile" method="POST" style="border-radius: 20px">
                    <div class="grid grid-cols-2 gap-5 mt-5">
                        <div class="col-span-1">
                            <span class="text-base text-[#575757]"><b>Fullname</b> <span class="text-red-500">*</span></span><br>
                            <input type="text" minlength="3" maxlength="20" name="name" class="border px-3" value="${requestScope.user.name}" required><br>
                            <span class="text-base text-[#575757]"><b>Phone</b> <span class="text-red-500">*</span></span><br>
                            <input type="text" maxlength="10" pattern="0[35789]{1}[0-9]{8}" name="phone" class="border px-3" value="${requestScope.user.phone}" required><br>
                        </div>
                        <div class="col-span-1">
                            <span class="text-base text-[#575757]"><b>Email</b> <span class="text-red-500">*</span></span><br>
                            <input type="email" minlength="11" maxlength="200" name="email" class="border px-3" value="${requestScope.user.email}" required><br>
                            <span class="text-base text-[#575757]"><b>Address</b></span> <span class="text-red-500">*</span><br>
                            <input type="text" minlength="10" maxlength="30" name="address" class="border px-3" value="${requestScope.user.address}" required><br>
                        </div>
                        <c:if test="${requestScope.error != null}">
                            <p style="color: red;">${requestScope.error}</p>
                        </c:if>
                        <c:if test="${requestScope.message != null}">
                            <p style="color: green;">${requestScope.message}</p>
                        </c:if>
                    </div>
                    <button type="submit" class="bg-primary text-white px-6 py-3 rounded mt-5" style="padding-inline: 20px;">Save</button>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
    </body>


</html>

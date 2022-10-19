<%-- 
    Document   : chgpwd
    Created on : Sep 30, 2022, 11:20:44 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../base/headerImport.jsp" />
        <title>Verify - Hostalpy</title>
        <style>
            input[type='text'].token-input {
                border: 1px solid #ccc;
                padding: 0 5rem;
                text-align: center;
            }

            .btn-disable {
                pointer-events: none;
                color: gray !important;
                border-color: gray !important;
            }
            
            .btn-disable .verify-btn {
                pointer-events: none;
                color: gray !important;
                border-color: gray !important;
                background: lightgray !important;
            }

        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar.jsp" />
        <div class="bg-white shadow w-fit p-5 mx-auto rounded-2xl shadow-xl mt-5 border border-[#eee]" style="">
            <div class="text-center">
                <h1 class="mb-5 text-xl font-semibold">Verify</h1>
                <form id="verify-form" action="verify" method="POST">
                    <input type="text" name="token" class="token-input" placeholder="Enter token" size="6" maxlength="6" required/>
                    <button type="button" id="send-email-btn" class="border border-5 border-primary px-5 py-3 rounded text-primary">
                        <i id="load-icon" class="animate-spin fa-solid fa-spinner mr-3 hidden"></i>
                        <span id="send-email-btn-content">Send Token</span></button>
                    <p id='send-email-notification' class="my-3"></p>
                    <div class="mt-3"></div>
                    <p style="color: #575757">${requestScope.result}</p>
                    <button id="verify-btn" class="verify-btn bg-primary px-5 py-3 rounded-xl text-white hover:text-gray-200">Verify Account</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>
        <script>
            var count = 10;

            $(document).ready(function () {
                $('#verify-form').ajaxForm({
                    success: finishRes
                });
            });

            $(document).ready(function () {
                $('#send-email-btn').click(function () {
                    $('#send-email-btn').addClass('btn-disable');
                    $('#load-icon').removeClass('hidden');
                    $('#send-email-btn-content').html('Sending...');
                    $.ajax({
                        url: 'verify/sendtoken',
                        type: 'POST',
                        success: sendReply
                    });
                });
            });

            const sendReply = (data) => {
                $('#load-icon').addClass('hidden');
                var countDownTimer = setInterval(() => {
                    count--;
                    $('#send-email-btn-content').empty().html('Wait ' + count + 's to get new token');

                    if (count === -1) {
                        $('#send-email-btn-content').empty().html('Resend');
                        $('#send-email-btn').removeClass('btn-disable');
                        clearInterval(countDownTimer);
                        count = 10;
                    }
                }, 1000);
            };

            const finishRes = (data) => {
                if (data === 'success') {
                    $('#send-email-notification').removeClass('text-red-600').addClass('text-green-600').empty().html('Verify successfully!');
                    $('#verify-btn').addClass('btn-disable');
                    $('#send-email-btn').addClass('btn-disable');
                } else {
                    $('#send-email-notification').removeClass('text-green-600').addClass('text-red-600').html(data);
                }
            };
        </script>
    </body>


</html>

<%-- 
    Document   : forget
    Created on : Sep 30, 2022, 11:20:44 PM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bs-stepper/dist/css/bs-stepper.min.css" rel="stylesheet">
        <jsp:include page="../base/headerImport.jsp" />


        <title>Forget Password - Hostalpy</title>
        <style>
            .bs-stepper-content input[type='text'], input[type='email'], input[type='password'] {
                border: 1px solid #ccc;
            }

            .btn-disable {
                pointer-events: none;
                color: gray !important;
                border-color: gray !important;
            }

            .btn-disable.verify-btn {
                pointer-events: none;
                color: gray !important;
                border-color: gray !important;
                background: lightgray !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../component/navbar-nosearch.jsp" />
        <div class="px-10 mx-auto">
            <div class="bs-stepper" id="stepper">
                <div class="bs-stepper-header hidden" role="tablist">
                    <!-- your steps here -->



                    <div class="step" data-target="#mail-part">
                        <button type="button" class="step-trigger" role="tab" aria-controls="mail-part" id="mail-part-trigger">
                            <span class="bs-stepper-circle">1</span>
                            <span class="bs-stepper-label">Verify Email</span>
                        </button>
                    </div>
                    <div class="line"></div>


                    <div class="step" data-target="#captcha-part">
                        <button type="button" class="step-trigger" role="tab" aria-controls="captcha-part" id="captcha-part-trigger">
                            <span class="bs-stepper-circle">2</span>
                            <span class="bs-stepper-label">Check Token</span>
                        </button>
                    </div>

                    <div class="line"></div>
                    <div class="step" data-target="#password-part">
                        <button type="button" class="step-trigger" role="tab" aria-controls="password-part" id="password-part-trigger">
                            <span class="bs-stepper-circle">3</span>
                            <span class="bs-stepper-label">New Password</span>
                        </button>
                    </div>
                    <div class="line"></div>
                    <div class="step" data-target="#finish-part">
                        <button type="button" class="step-trigger" role="tab" aria-controls="finish-part" id="finish-part-trigger">
                            <span class="bs-stepper-circle">4</span>
                            <span class="bs-stepper-label">Finish</span>
                        </button>
                    </div>
                </div>
                <div class="bs-stepper-content mt-3">
                    <!-- your steps content here -->
                    <div id="mail-part" class="content" role="tabpanel" aria-labelledby="mail-part-trigger">
                        <div class="flex justify-center items-center flex-col border border-gray-100 w-fit mx-auto px-5 py-5 rounded-xl shadow-xl">
                            <h1 class="text-center text-3xl font-semibold mb-3">Reset Password</h1>
                            <p class="text-dark">Enter your email you signed up to our service.</p>
                            <form action="forget" method="post" id="checkmail-form" class="mt-3">
                                <div class="mb-3">
                                    <input type="email" id="email" class="px-3 text-center" name="email" placeholder="Email" required />
                                    <input type="hidden" name="step" value="checkmail"/>
                                    <div id="notiExistMail" class="text-danger small text-center mt-3"></div>
                                </div>
                                <div class="text-center">
                                    <button class="btn btn-primary px-3 py-1 verify-btn" id="verifymail-btn" type="submit">
                                        <i id="load-icon" class="animate-spin fa-solid fa-spinner mr-3 hidden"></i>
                                        <span id="send-email-btn-content">Get Reset Password Token</span>
                                    </button>
                                </div>
                            </form>

                        </div>
                    </div>


                    <div id="captcha-part" class="content" role="tabpanel" aria-labelledby="captcha-part-trigger"> 
                        <div class="flex justify-center items-center flex-col border border-gray-100 w-fit mx-auto px-5 py-5 rounded-xl shadow-xl">
                            <h1 class="text-center text-3xl font-semibold mb-3">Reset Password</h1>
                            <p class="text-dark">Input token we sent to your mail</p>
                            <form action="forget" method="post" id="checktoken-form" class="mt-3">
                                <div class="mb-3">
                                    <input type="text" id="captcha" class="px-3 text-center" maxlength="6" name="token" placeholder="Token" />
                                    <input type="hidden" name="step" value="checktoken"/>
                                </div>
                                <div id="notiCaptcha" class="small text-danger text-center"></div>
                                <div class="flex justify-center mt-5">
                                    <button onclick="previous()" class="bg-gray-100 border rounded px-3 py-1 mx-3">Back</button>
                                    <button type="submit" class="btn btn-primary px-3 py-1 verify-btn" id="checktoken-btn">
                                        <i id="checktoken-load-icon" class="animate-spin fa-solid fa-spinner mr-3 hidden"></i>
                                        Check
                                    </button>
                                </div>
                            </form>

                        </div>
                    </div>
                    <div id="password-part" class="content" role="tabpanel" aria-labelledby="password-part-trigger"> 
                        <div class="flex justify-center items-center flex-col border border-gray-100 w-fit mx-auto px-5 py-5 rounded-xl shadow-xl">
                            <h1 class="text-center text-3xl font-semibold mb-3">Reset Password</h1>
                            <p class="text-dark">Input new password for your account</p>
                            <form id="resetpassword-form" action="forget" method="POST" class="mt-3">
                                <div class="flex flex-col gap-3">
                                    <input type="password" name="password" id="password" class="px-3" placeholder="Password" minlength="3" maxlength="20" required />
                                    <input type="password" name="confirmPassword" id="confirmPassword" class="px-3" placeholder="Confirm Password" minlength="3" maxlength="20" required/>
                                </div>
                                <span id="resetpassword-message" class="text-center text-danger"></span>
                                <div class="flex justify-center mt-3">
                                    <button type="button" onclick="previous()" class="bg-gray-100 border rounded px-3 py-1 mx-3">Back</button>
                                    <button type="submit" class="btn btn-primary px-3 py-1 verify-btn" id="resetpassword-btn">Reset</button>
                                </div>
                                <input type="hidden" name="step" value="resetpassword">
                                <div class="text-danger small" id="resetPw-noti"></div>
                            </form>

                        </div>
                    </div>
                    <div id="finish-part" class="content" role="tabpanel" aria-labelledby="finish-part-trigger">
                        <div class="flex justify-center flex-col items-center border border-gray-100 w-fit mx-auto px-5 py-5 rounded-xl shadow-xl">
                            <i class="fa-solid fa-check text-3xl font-bold text-success"></i>
                            <div class="flex flex-col text-center my-3"><span class="text-success" id="resetpass-noti"></span><span>Let login to your account with new password.</span></div>
                            <a href="/hostalpy/login" class="btn btn-primary btn-lg">Return login screen</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bs-stepper/dist/js/bs-stepper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>
        <script>
                                        var stepper = new Stepper(document.querySelector("#stepper"));

                                        const next = () => {
                                            stepper.next();
                                        };

                                        const previous = () => {
                                            stepper.previous();
                                        };

                                        $(document).ready(function () {
                                            $('#verifymail-btn').click(function () {
                                                $('#load-icon').removeClass('hidden');
                                                $('#send-email-btn-content').empty().html('Sending Token')
                                                $('#verifymail-btn').addClass('btn-disable');

                                                $('#checkmail-form').ajaxForm({
                                                    // success identifies the function to invoke when the server response 
                                                    // has been received 

                                                    success: processMailVerify
                                                });
                                            })


                                        });

                                        $(document).ready(function () {
                                            $('#checktoken-btn').click(function () {
                                                $('#notiCaptcha').empty();
                                                $('#checktoken-load-icon').removeClass('hidden');
                                                $('#checktoken-btn').addClass('btn-disable');
                                                setTimeout(function () {
                                                    $('#checktoken-load-icon').addClass('hidden');
                                                    $('#checktoken-btn').removeClass('btn-disable');

                                                }, 300);

                                                $('#checktoken-form').ajaxForm({
                                                    // success identifies the function to invoke when the server response 
                                                    // has been received 
                                                    success: processTokenVerify
                                                });


                                            });


                                        });

                                        $(document).ready(function () {
                                            $('#resetpassword-form').ajaxForm({
                                                // success identifies the function to invoke when the server response 
                                                // has been received 
                                                success: processResetPassword
                                            });
                                        });

                                        const resendReply = (data) => {
                                            $('#notiCaptcha').removeClass('text-success').empty().html(data);
                                            $('#resend-btn').prop('disabled', true);
                                            setTimeout(function () {
                                                $('#resend-btn').prop("disabled", false);
                                            }, 10000);
                                        };

                                        const processResetPassword = (data) => {
                                            if (data === 'success') {
                                                $('#resetpass-noti').empty().html("Reset password successfully!");
                                                next();
                                            } else {
                                                $('#resetpass-noti').empty().html(data);
                                            }
                                        };

                                        const processTokenVerify = (data) => {
                                            if (data === 'success') {
                                                next();
                                            } else {
                                                $('#captcha').addClass('invalid');
                                                $('#notiCaptcha').empty().html(data);
                                            }
                                        };

                                        const processMailVerify = (data) => {
                                            if (data === 'success') {
                                                $('#load-icon').addClass('hidden');
                                                $('#send-email-btn-content').empty().html('Get Reset Password Token')
                                                $('#verifymail-btn').removeClass('btn-disable');
                                                next();
                                            } else {
                                                $('#email').addClass('invalid');
                                                $('#notiExistMail').empty().html(data);
                                            }
                                        };

                                        $('#password, #confirmpassword').on('keyup', function () {
                                            if ($('#password').val() === $('#confirmpassword').val()) {
                                                $('#resetpassword-message').empty();
                                                $('#resetpassword-btn').removeClass('btn-disable');
                                            } else
                                                $('#resetpassword-message').html('Password fields must same');
                                                $('#resetpassword-btn').addClass('btn-disable');
                                        });
        </script>
    </body>


</html>

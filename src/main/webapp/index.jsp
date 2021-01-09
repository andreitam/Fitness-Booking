<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom-style.css">

    <title>Fitness Booking SignIn</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="https://apis.google.com/js/client:platform.js?onload=start" async defer></script>
    <!-- END Pre-requisites -->
    <!-- Continuing the <head> section -->
    <script>
        function start() {
            gapi.load('auth2', function() {
                auth2 = gapi.auth2.init({
                    client_id: '464122252753-hhvsb9iv8c5an2h67084ara6et5n0mtp.apps.googleusercontent.com',
                    // Scopes to request in addition to 'profile' and 'email'
                    //scope: 'additional_scope'
                    scope: 'https://www.googleapis.com/auth/calendar',
                    /*scope: 'https://www.googleapis.com/auth/calendar.events.delete',*/
                    scope: 'https://www.googleapis.com/auth/user.phonenumbers.read',
                    scope: 'https://www.googleapis.com/auth/user.birthday.read',
                    scope: 'https://www.googleapis.com/auth/user.gender.read',
                });
            });
        }
    </script>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/images/crossfit2.jpg');">
<div>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <style>
            .login-form {
            width: 350px;
            margin: 30px auto;
            font-size: 15px;
            }
            .login-form form {
            margin-bottom: 15px;
            background: #eeeeee;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
            }
            .login-form h2 {
            margin: 0 0 15px;
            }
            .login-form .hint-text {
            color: #777;
            padding-bottom: 15px;
            text-align: center;
            font-size: 13px;
            }
            .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
            }
            .login-btn {
            font-size: 15px;
            font-weight: bold;
            }
            .or-seperator {
            margin: 20px 0 10px;
            text-align: center;
            border-top: 1px solid #ccc;
            }
            .or-seperator i {
            padding: 0 10px;
            background: #f7f7f7;
            position: relative;
            top: -11px;
            z-index: 1;
            }
            .social-btn .btn {
            margin: 10px 0;
            font-size: 15px;
            text-align: left;
            line-height: 24px;
            }
            .social-btn .btn i {
            float: left;
            margin: 4px 15px  0 5px;
            min-width: 15px;
            }
            .input-group-addon .fa{
            font-size: 18px;
            }
        </style>
    </head>
    <body>
    <div class="login-form">
        <form method="post">
            <h2 class="text-center">Fitness Booking Sign in</h2>
            <div class="text-center social-btn">
                <!-- Add where you want your sign-in button to render -->
                <!-- Use an image that follows the branding guidelines in a real app -->
                <a id="signinButton" class="btn btn-primary btn-block"><i class="fa fa-google"></i> Sign in with <b>Google</b></a>
                <script>
                    $('#signinButton').click(function() {
                        // signInCallback defined in step 6.
                        auth2.grantOfflineAccess().then(signInCallback);
                    });
                </script>
            </div>
            <div class="or-seperator"><i>or</i></div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                    <span class="input-group-text">
                        <span class="fa fa-user"></span>
                    </span>
                    </div>
                    <input type="email" class="form-control" name="email" id="email" placeholder="Email" required="required">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                    <span class="input-group-text">
                        <i class="fa fa-lock"></i>
                    </span>
                    </div>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password" required="required">
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success btn-block login-btn">Sign in</button>
            </div>
<%--            <div class="clearfix">
                <label class="float-left form-check-label">Remember me</label>
                <a href="#" class="float-right text-success">Forgot Password?</a>
            </div>--%>
            <div class="clearfix">
                <label class="float-left form-check-label">Don't have an account?</label>
                <a href='${pageContext.request.contextPath}/register' class="float-right text-success">Register Now!</a>
            </div>

        </form>
    </div>
    </body>
    </html>
</div>

<!-- Last part of BODY element in file index.html -->
<script>
    function signInCallback(authResult) {
        if (authResult['code']) {

            // Hide the sign-in button now that the user is authorized, for example:
            $('#signinButton').attr('style', 'display: none');

            // Send the code to the server
            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/FitnessBooking/signinGoogle',
                // Always include an `X-Requested-With` header in every AJAX request,
                // to protect against CSRF attacks.
                headers: {
                    'X-Requested-With': 'XMLHttpRequest'
                },
                contentType: 'application/octet-stream; charset=utf-8',
                data: { },
                dataType: "json",
                success: function(data) {
                    console.log(data);
                    window.location.href = data;
                },
                processData: false,
                data: authResult['code']
            });``
        } else {
            // There was an error.
        }
    }
</script>
</body>
</html>
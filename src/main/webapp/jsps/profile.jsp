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

    <title>Fitness Booking Profile</title>

</head>
<body style="background-image: url('${pageContext.request.contextPath}/images/crossfit2.jpg');">
<%--Form--%>
<div>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <title>Bootstrap Simple Registration Form</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #eeeeee;
                background: #eeeeee;
                font-family: 'Roboto', sans-serif;
            }
            .form-control {
                height: 40px;
                box-shadow: none;
                color: #969fa4;
            }
            .form-control:focus {
                border-color: #5cb85c;
            }
            .form-control, .btn {
                border-radius: 3px;
            }
            .signup-form {
                width: 450px;
                margin: 0 auto;
                padding: 30px 0;
                font-size: 15px;
            }
            .signup-form h2 {
                color: #636363;
                margin: 0 0 15px;
                position: relative;
                text-align: center;
            }
            .signup-form h2:before, .signup-form h2:after {
                content: "";
                height: 2px;
                width: 30%;
                background: #d4d4d4;
                position: absolute;
                top: 50%;
                z-index: 2;
            }
            .signup-form h2:before {
                left: 0;
            }
            .signup-form h2:after {
                right: 0;
            }
            .signup-form .hint-text {
                color: #999;
                margin-bottom: 30px;
                text-align: center;
            }
            .signup-form form {
                color: #999;
                border-radius: 3px;
                margin-bottom: 15px;
                background: #f2f3f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .signup-form .form-group {
                margin-bottom: 20px;
            }
            .signup-form input[type="checkbox"] {
                margin-top: 3px;
            }
            .signup-form .btn {
                font-size: 16px;
                font-weight: bold;
                min-width: 140px;
                outline: none !important;
            }
            .signup-form .row div:first-child {
                padding-right: 10px;
            }
            .signup-form .row div:last-child {
                padding-left: 10px;
            }
            .signup-form a {
                color: #fff;
                text-decoration: underline;
            }
            .signup-form a:hover {
                text-decoration: none;
            }
            .signup-form form a {
                color: #5cb85c;
                text-decoration: none;
            }
            .signup-form form a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
    <div class="signup-form">
        <form method="post">
            <h2>Profile</h2>
            <p class="hint-text">Here you can edit your profile.</p>
            <div class="form-group">
                <input type="text" class="form-control" name="inputName" placeholder="Name" required="required" value="${requestScope.fitnessClient.name}">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" name="inputEmail" placeholder="Email" required="required" value="${requestScope.fitnessClient.emailAddress}">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="inputPassword" placeholder="Password" required="required" value="${requestScope.fitnessClient.password}">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" required="required" value="${requestScope.fitnessClient.password}">
            </div>
            <div class="form-group">
                <input type="tel" class="form-control" name="inputPhone" placeholder="Phone Number" value="${requestScope.fitnessClient.phoneNumber}">
            </div>
            <div class="form-group">
                <input type="date" class="form-control" name="inputBirthday" placeholder="Birth Day" value="${requestScope.fitnessClient.birthDate}">
            </div>
            <div class="form-group">
                <label>Gender</label>
                <br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="exampleRadios" id="genderFemale" value="Female" ${requestScope.genderFemale}>
                    <label class="form-check-label" for="genderFemale">
                        Female
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="exampleRadios" id="genderMale" value="Male" ${requestScope.genderMale}>
                    <label class="form-check-label" for="genderMale">
                        Male
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="exampleRadios" id="genderNd" value="Rather not say" ${requestScope.genderNot}>
                    <label class="form-check-label" for="genderNd">
                        Rather not say
                    </label>
                </div>
            </div>
            <!--Privacy policy-->
            <%--            <div class="form-group">
                            <label class="form-check-label"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
                        </div>--%>
            <input type="hidden" name="id" id="id" value="${requestScope.fitnessClient.id}">
            <div class="form-group">
                <button type="submit" class="btn btn-success btn-lg btn-block">Edit</button>
            </div>
            <div class="text-center"><a href=${pageContext.request.contextPath}/main>Cancel</a></div>
        </form>

    </div>
    </body>
    </html>
</div>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
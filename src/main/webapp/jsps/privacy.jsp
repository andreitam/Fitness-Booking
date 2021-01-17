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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>Fitness Booking</title>

</head>
<body style="background-image: url('${pageContext.request.contextPath}/images/crossfit2.jpg');">
<%--Navbar--%>
<div>


    <html lang="en"><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap All in One Navbar</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Merienda+One">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                background: #eeeeee;
            }
            .form-inline {
                display: inline-block;
            }
            .navbar-header.col {
                padding: 0 !important;
            }
            .navbar {
                background: #fff;
                padding-left: 16px;
                padding-right: 16px;
                border-bottom: 1px solid #d6d6d6;
                box-shadow: 0 0 4px rgba(0,0,0,.1);
            }
            .nav-link img {
                border-radius: 50%;
                width: 36px;
                height: 36px;
                margin: -8px 0;
                float: left;
                margin-right: 10px;
            }
            .navbar .navbar-brand {
                color: #555;
                padding-left: 0;
                padding-right: 50px;
                font-family: 'Varela Round', sans-serif;
            }
            .navbar .navbar-brand i {
                font-size: 20px;
                margin-right: 5px;
            }
            .search-box {
                position: relative;
            }
            .search-box input {
                box-shadow: none;
                padding-right: 35px;
                border-radius: 3px !important;
            }
            .search-box .input-group-addon {
                min-width: 35px;
                border: none;
                background: transparent;
                position: absolute;
                right: 0;
                z-index: 9;
                padding: 7px;
                height: 100%;
            }
            .search-box i {
                color: #a0a5b1;
                font-size: 19px;
            }
            .navbar .nav-item i {
                font-size: 18px;
            }
            .navbar .dropdown-item i {
                font-size: 16px;
                min-width: 22px;
            }
            .navbar .nav-item.open > a {
                background: none !important;
            }
            .navbar .dropdown-menu {
                border-radius: 1px;
                border-color: #e5e5e5;
                box-shadow: 0 2px 8px rgba(0,0,0,.05);
            }
            .navbar .dropdown-menu a {
                color: #777;
                padding: 8px 20px;
                line-height: normal;
            }
            .navbar .dropdown-menu a:hover, .navbar .dropdown-menu a:active {
                color: #333;
            }
            .navbar .dropdown-item .material-icons {
                font-size: 21px;
                line-height: 16px;
                vertical-align: middle;
                margin-top: -2px;
            }
            .navbar .badge {
                color: #fff;
                background: #f44336;
                font-size: 11px;
                border-radius: 20px;
                position: absolute;
                min-width: 10px;
                padding: 4px 6px 0;
                min-height: 18px;
                top: 5px;
            }
            .navbar a.notifications, .navbar a.messages {
                position: relative;
                margin-right: 10px;
            }
            .navbar a.messages {
                margin-right: 20px;
            }
            .navbar a.notifications .badge {
                margin-left: -8px;
            }
            .navbar a.messages .badge {
                margin-left: -4px;
            }
            .navbar .active a, .navbar .active a:hover, .navbar .active a:focus {
                background: transparent !important;
            }
            @media (min-width: 1200px){
                .form-inline .input-group {
                    width: 300px;
                    margin-left: 30px;
                }
            }
            @media (max-width: 1199px){
                .form-inline {
                    display: block;
                    margin-bottom: 10px;
                }
                .input-group {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </body></html>

</div>
<%--Table--%>
<div>

    <html lang="en"><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 15px;
                background: #435d7d;
                color: #fff;
                padding: 16px 30px;
                min-width: 100%;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn-group {
                float: right;
            }
            .table-title .btn {
                color: #fff;
                float: right;
                font-size: 13px;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 200px;
            }
            table.table tr th:last-child {
                width: 80px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
                outline: none !important;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #F44336;
            }
            table.table td a.book {
                color: #00b300;
            }
            table.table td i {
                font-size: 19px;
            }
            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a, .pagination li.active a.page-link {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
            }
            /* Custom checkbox */
            .custom-checkbox {
                position: relative;
            }
            .custom-checkbox input[type="checkbox"] {
                opacity: 0;
                position: absolute;
                margin: 5px 0 0 3px;
                z-index: 9;
            }
            .custom-checkbox label:before{
                width: 18px;
                height: 18px;
            }
            .custom-checkbox label:before {
                content: '';
                margin-right: 10px;
                display: inline-block;
                vertical-align: text-top;
                background: white;
                border: 1px solid #bbb;
                border-radius: 2px;
                box-sizing: border-box;
                z-index: 2;
            }
            .custom-checkbox input[type="checkbox"]:checked + label:after {
                content: '';
                position: absolute;
                left: 6px;
                top: 3px;
                width: 6px;
                height: 11px;
                border: solid #000;
                border-width: 0 3px 3px 0;
                transform: inherit;
                z-index: 3;
                transform: rotateZ(45deg);
            }
            .custom-checkbox input[type="checkbox"]:checked + label:before {
                border-color: #03A9F4;
                background: #03A9F4;
            }
            .custom-checkbox input[type="checkbox"]:checked + label:after {
                border-color: #fff;
            }
            .custom-checkbox input[type="checkbox"]:disabled + label:before {
                color: #b8b8b8;
                cursor: auto;
                box-shadow: none;
                background: #ddd;
            }
            /* Modal styles */
            .modal .modal-dialog {
                max-width: 400px;
            }
            .modal .modal-header, .modal .modal-body, .modal .modal-footer {
                padding: 20px 30px;
            }
            .modal .modal-content {
                border-radius: 3px;
                font-size: 14px;
            }
            .modal .modal-footer {
                background: #ecf0f1;
                border-radius: 0 0 3px 3px;
            }
            .modal .modal-title {
                display: inline-block;
            }
            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }
            .modal textarea.form-control {
                resize: vertical;
            }
            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }
            .modal form label {
                font-weight: normal;
            }
        </style>
    </head>
    <body>
    <div class="container-xl">
        <div class="table-responsive">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Privacy <b>And Terms</b></h2>
                        </div>
                    </div>
                </div>
                    <div class="inner">
                        <h2>This app is a school project!</h2>
                        <p>Last updated <span style="color: #8351f9;">17.01.2021</span></p>
                        <p><strong>INTRODUCTION</strong></p>
                        <p>Firstly this app is a school project and will use your input data for testing purposes.</p>
                        <p><span style="color: #8351f9;">Fitness Booking Web App </span>(“we” or “us” or “our”) respects the privacy of our users (“user” or “you”). This Privacy Policy explains how we collect, use, disclose, and safeguard your information when you visit our website <span style="color: #8351f9;">immense-sierra-70031.herokuapp.com</span>, including any other media form, media channel, mobile website, or mobile application related or connected thereto (collectively, the “Site”). Please read this privacy policy carefully. If you do not agree with the terms of this privacy policy, please do not access the site.</p>
                        <p>We reserve the right to make changes to this Privacy Policy at any time and for any reason. We will alert you about any changes by updating the “Last Updated” date of this Privacy Policy. Any changes or modifications will be effective immediately upon posting the updated Privacy Policy on the Site, and you waive the right to receive specific notice of each such change or modification.</p>
                        <p>You are encouraged to periodically review this Privacy Policy to stay informed of updates. You will be deemed to have been made aware of, will be subject to, and will be deemed to have accepted the changes in any revised Privacy Policy by your continued use of the Site after the date such revised Privacy Policy is posted.</p>
                        <p>This Privacy Policy was generated by <span style="color: #000000;"><a style="color: #000000;" href="https://termly.io/products/privacy-policy-generator/">Termly’s Privacy Policy Generator</a></span>.</p>
                        <p><strong>COLLECTION OF YOUR INFORMATION</strong></p>
                        <p>We may collect information about you in a variety of ways. The information we may collect on the Site includes:</p>
                        <p><strong>Personal Data</strong></p>
                        <p>Personally identifiable information, such as your name, shipping address, email address, and telephone number, and demographic information, such as your age, gender, hometown, and interests, that you voluntarily give to us <span style="color: #8351f9;">immense-sierra-70031.herokuapp.com</span> when you choose to participate in various activities related to the Site <span style="color: #8351f9;">immense-sierra-70031.herokuapp.com</span>, such as online chat and message boards. You are under no obligation to provide us with personal information of any kind, however your refusal to do so may prevent you from using certain features of the Site <span style="color: #8351f9;">immense-sierra-70031.herokuapp.com</span>.</p>
                        <p><strong>Derivative Data</strong></p>
                        <p>Information our servers automatically collect when you access the Site, such as your IP address, your browser type, your operating system, your access times, and the pages you have viewed directly before and after accessing the Site. [If you are using our mobile application, this information may also include your device name and type, your operating system, your phone number, your country, your likes and replies to a post, and other interactions with the application and other users via server log files, as well as any other information you choose to provide.]</p>
                        <p><strong>Financial Data</strong></p>
                        <p>Financial information, such as data related to your payment method (e.g. valid credit card number, card brand, expiration date) that we may collect when you purchase, order, return, exchange, or request information about our services from the Site <span style="color: #8351f9;">immense-sierra-70031.herokuapp.com. [We store only very limited, if any, financial information that we collect. Otherwise, all financial information is stored by our payment processor, [</span><a href="https://pay.amazon.com/help/201491260">Amazon Payments,</a><span style="color: #8351f9;">] [</span><a href="https://www.authorize.net/about-us/privacy.html">Authorize.Net,</a><span style="color: #8351f9;">] [</span><a href="https://www.braintreepayments.com/legal">Braintree Payments,</a><span style="color: #8351f9;">] [</span><a href="https://www.chargify.com/privacy-policy/">Chargify,</a><span style="color: #8351f9;">] [</span><a href="https://www.dwolla.com/legal/privacy/">Dwolla,</a><span style="color: #8351f9;">] [</span><a href="https://payments.google.com/payments/apis-secure/get_legal_document?ldo=0&amp;ldt=privacynotice">Google Checkout,<span style="color: #8351f9;">]</span></a><span style="color: #8351f9;"> [</span><a href="https://www.paypal.com/us/webapps/mpp/ua/privacy-full">Paypal</a>,<span style="color: #8351f9;">] [</span><a href="https://www.safecharge.com/privacy-cookies-policy/">SafeCharge,</a><span style="color: #8351f9;">] [</span><a href="https://stripe.com/privacy">Stripe,</a><span style="color: #8351f9;">] [</span><a href="https://go.wepay.com/terms-of-service-us/#us">WePay,</a><span style="color: #8351f9;">] </span><a href="https://www.2checkout.com/legal/privacy/"><span style="color: #8351f9;">[</span>2Checkout,</a><span style="color: #339966;"><span style="color: #8351f9;">] [other], and you are encouraged to review their privacy policy and contact them directly for responses to your questions.]</span></span></p>
                        <p><strong>Facebook Permissions</strong></p>
                        <p>The Site <span style="color: #8351f9;">immense-sierra-70031.herokuapp.com</span> may by default access your <a href="https://www.facebook.com/about/privacy/">Facebook</a> basic account information, including your name, email, gender, birthday, current city, and profile picture URL, as well as other information that you choose to make public. We may also request access to other permissions related to your account, such as friends, checkins, and likes, and you may choose to grant or deny us access to each individual permission. For more information regarding Facebook permissions, refer to the <a href="https://developers.facebook.com/docs/permissions/reference" target="_blank" rel="noopener noreferrer">Facebook Permissions Reference</a> page.</p>
                        <p><strong>Data From Social Networks</strong></p>
                        <p>User information from social networking sites, such as <span style="color: #8351f9;">[Apple’s Game Center, Facebook, Google+, Instagram, Pinterest, Twitter]</span>, including your name, your social network username, location, gender, birth date, email address, profile picture, and public data for contacts, if you connect your account to such social networks. <span style="color: #8351f9;">[If you are using our mobile application, this information may also include the contact information of anyone you invite to use and/or join our mobile application.]</span></p>
                        <p><strong>Mobile Device Data</strong></p>
                        <p>Device information, such as your mobile device ID, model, and manufacturer, and information about the location of your device, if you access the Site from a mobile device.</p>
                        <p><strong>Third-Party Data</strong></p>
                        <p>Information from third parties, such as personal information or network friends, if you connect your account to the third party and grant the Site permission to access this information.</p>
                        <p><strong>Data From Contests, Giveaways, and Surveys</strong></p>
                        <p>Personal and other information you may provide when entering contests or giveaways and/or responding to surveys.</p>
                        <p><strong>Mobile Application Information</strong></p>
                        <p>If you connect using our mobile application:</p>
                        <ul>
                            <li>Geo-Location Information. We may request access or permission to and track location-based information from your mobile device, either continuously or while you are using our mobile application, to provide location-based services. If you wish to change our access or permissions, you may do so in your device’s settings.</li>
                            <li>Mobile Device Access. We may request access or permission to certain features from your mobile device, including your mobile device’s <span style="color: #8351f9;">[bluetooth, calendar, camera, contacts, microphone, reminders, sensors, SMS messages, social media accounts, storage,]</span> and other features. If you wish to change our access or permissions, you may do so in your device’s settings.</li>
                            <li>Mobile Device Data. We may collect device information (such as your mobile device ID, model and manufacturer), operating system, version information and IP address.</li>
                            <li>Push Notifications. We may request to send you push notifications regarding your account or the Application. If you wish to opt-out from receiving these types of communications, you may turn them off in your device’s settings.</li>
                        </ul>
                        <p><strong>USE OF YOUR INFORMATION</strong></p>
                        <p>Having accurate information about you permits us to provide you with a smooth, efficient, and customized experience. Specifically, we may use information collected about you via the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span> to:</p>
                        <ul>
                            <li>Administer sweepstakes, promotions, and contests.</li>
                            <li>Assist law enforcement and respond to subpoena.</li>
                            <li>Compile anonymous statistical data and analysis for use internally or with third parties.</li>
                            <li>Create and manage your account.</li>
                            <li>Deliver targeted advertising, coupons, newsletters, and other information regarding promotions and the Site<span style="color: #8351f9;"> https://immense-sierra-70031.herokuapp.com</span> to you.</li>
                            <li>Email you regarding your account or order.</li>
                            <li>Enable user-to-user communications.</li>
                            <li>Fulfill and manage purchases, orders, payments, and other transactions related to the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>.</li>
                            <li>Generate a personal profile about you to make future visits to the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com </span>more personalized.</li>
                            <li>Increase the efficiency and operation of the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>.</li>
                            <li>Monitor and analyze usage and trends to improve your experience with the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>.</li>
                            <li>Notify you of updates to the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>s.</li>
                            <li>Offer new products, services, <span style="color: #8351f9;">[mobile applications,]</span> and/or recommendations to you.</li>
                            <li>Perform other business activities as needed.</li>
                            <li>Prevent fraudulent transactions, monitor against theft, and protect against criminal activity.</li>
                            <li>Process payments and refunds.</li>
                            <li>Request feedback and contact you about your use of the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>.</li>
                            <li>Resolve disputes and troubleshoot problems.</li>
                            <li>Respond to product and customer service requests.</li>
                            <li>Send you a newsletter.</li>
                            <li>Solicit support for the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>.</li>
                            <li><span style="color: #8351f9;">[Other]</span></li>
                        </ul>
                        <p><strong>DISCLOSURE OF YOUR INFORMATION</strong></p>
                        <p>We may share information we have collected about you in certain situations. Your information may be disclosed as follows:</p>
                        <p><strong>By Law or to Protect Rights</strong></p>
                        <p>If we believe the release of information about you is necessary to respond to legal process, to investigate or remedy potential violations of our policies, or to protect the rights, property, and safety of others, we may share your information as permitted or required by any applicable law, rule, or regulation. This includes exchanging information with other entities for fraud protection and credit risk reduction.</p>
                        <p><strong>Third-Party Service Providers</strong></p>
                        <p>We may share your information with third parties that perform services for us or on our behalf, including payment processing, data analysis, email delivery, hosting services, customer service, and marketing assistance.</p>
                        <p><strong>Marketing Communications</strong></p>
                        <p>With your consent, or with an opportunity for you to withdraw consent, we may share your information with third parties for marketing purposes, as permitted by law.</p>
                        <p><strong>Interactions with Other Users</strong></p>
                        <p>If you interact with other users of the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>, those users may see your name, profile photo, and descriptions of your activity, including sending invitations to other users, chatting with other users, liking posts, following blogs.</p>
                        <p><strong>Online Postings</strong></p>
                        <p>When you post comments, contributions or other content to the Site<span style="color: #8351f9;"> [or our mobile applications]</span>, your posts may be viewed by all users and may be publicly distributed outside the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> in perpetuity.</p>
                        <p><strong>Third-Party Advertisers</strong></p>
                        <p>We may use third-party advertising companies to serve ads when you visit the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>. These companies may use information about your visits to the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> and other websites that are contained in web cookies in order to provide advertisements about goods and services of interest to you.</p>
                        <p><strong>Affiliates</strong></p>
                        <p>We may share your information with our affiliates, in which case we will require those affiliates to honor this Privacy Policy. Affiliates include our parent company and any subsidiaries, joint venture partners or other companies that we control or that are under common control with us.</p>
                        <p><strong>Business Partners</strong></p>
                        <p>We may share your information with our business partners to offer you certain products, services or promotions.</p>
                        <p><span style="color: #8351f9;"><strong>[Offer Wall&nbsp;</strong></span></p>
                        <p><span style="color: #8351f9;">Our mobile application may display a third-party hosted “offer wall.” Such an offer wall allows third-party advertisers to offer virtual currency, gifts, or other items to users in return for acceptance and completion of an advertisement offer. Such an offer wall may appear in our mobile application and be displayed to you based on certain data, such as your geographic area or demographic information. When you click on an offer wall, you will leave our mobile application. A unique identifier, such as your user ID, will be shared with the offer wall provider in order to prevent fraud and properly credit your account.]</span></p>
                        <p><span style="color: #8351f9;"><strong>[Social Media Contacts&nbsp;</strong></span></p>
                        <p><span style="color: #8351f9;">If you connect to the Site https://immense-sierra-70031.herokuapp.com/ through a social network, your contacts on the social network will see your name, profile photo, and descriptions of your activity.]</span></p>
                        <p><strong>Other Third Parties</strong></p>
                        <p>We may share your information with advertisers and investors for the purpose of conducting general business analysis. We may also share your information with such third parties for marketing purposes, as permitted by law.</p>
                        <p><strong>Sale or Bankruptcy</strong></p>
                        <p>If we reorganize or sell all or a portion of our assets, undergo a merger, or are acquired by another entity, we may transfer your information to the successor entity. If we go out of business or enter bankruptcy, your information would be an asset transferred or acquired by a third party. You acknowledge that such transfers may occur and that the transferee may decline honor commitments we made in this Privacy Policy.</p>
                        <p>We are not responsible for the actions of third parties with whom you share personal or sensitive data, and we have no authority to manage or control third-party solicitations. If you no longer wish to receive correspondence, emails or other communications from third parties, you are responsible for contacting the third party directly.</p>
                        <p><span style="color: #8351f9;"><strong>TRACKING TECHNOLOGIES</strong></span></p>
                        <p><strong>Cookies and Web Beacons</strong></p>
                        <p>We may use cookies, web beacons, tracking pixels, and other tracking technologies on the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> to help customize the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> and improve your experience. When you access the Site<span style="color: #8351f9;"> https://immense-sierra-70031.herokuapp.com/</span>, your personal information is not collected through the use of tracking technology. Most browsers are set to accept cookies by default. You can remove or reject cookies, but be aware that such action could affect the availability and functionality of the Site <span style="color: #339966;"><span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>.</span> You may not decline web beacons. However, they can be rendered ineffective by declining all cookies or by modifying your web browser’s settings to notify you each time a cookie is tendered, permitting you to accept or decline cookies on an individual basis.</p>
                        <p>[We may use cookies, web beacons, tracking pixels, and other tracking technologies on the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> to help customize the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> and improve your experience. For more information on how we use cookies, please refer to our Cookie Policy posted on the Site, which is incorporated into this Privacy Policy. By using the Site, you agree to be bound by our Cookie Policy.]</p>
                        <p><strong>Internet-Based Advertising</strong></p>
                        <p>Additionally, we may use third-party software to serve ads on the Site https://immense-sierra-70031.herokuapp.com, implement email marketing campaigns, and manage other interactive marketing initiatives. This third-party software may use cookies or similar tracking technology to help manage and optimize your online experience with us. For more information about opting-out of interest-based ads, visit the <a href="http://optout.networkadvertising.org/?c=1">Network Advertising Initiative Opt-Out Tool</a> or <a href="https://optout.aboutads.info/?c=2&amp;lang=EN">Digital Advertising Alliance Opt-Out Tool</a>.</p>
                        <p><strong>Website Analytics</strong></p>
                        <p>We may also partner with selected third-party vendors[, such as [<a href="https://www.adobe.com/privacy/policy.html" target="_blank" rel="noopener noreferrer">Adobe Analytics</a>,] [<a href="https://contentsquare.com/privacy-center/privacy-policy/" target="_blank" rel="noopener noreferrer">Clicktale,</a>] [<a href="https://clicky.com/terms" target="_blank" rel="noopener noreferrer">Clicky</a>,] [<a href="https://www.cloudflare.com/privacypolicy/" target="_blank" rel="noopener noreferrer">Cloudfare</a>,] [<a href="https://www.crazyegg.com/privacy/" target="_blank" rel="noopener noreferrer">Crazy Egg,</a>] [<a href="https://www.verizonmedia.com/policies/us/en/verizonmedia/privacy/products/developer/index.html" target="_blank" rel="noopener noreferrer">Flurry Analytics,</a>] [<a href="https://support.google.com/analytics/answer/6004245?hl=en" target="_blank" rel="noopener noreferrer">Google Analytics</a>,] [<a href="https://heap.io/privacy" target="_blank" rel="noopener noreferrer">Heap Analytics</a>,] [<a href="https://www.inspectlet.com/legal#privacy" target="_blank" rel="noopener noreferrer">Inspectlet,</a>] [<a href="https://www.kissmetrics.io/privacy/" target="_blank" rel="noopener noreferrer">Kissmetrics,]</a> [<a href="https://mixpanel.com/legal/privacy-policy/" target="_blank" rel="noopener noreferrer">Mixpanel,</a>] [<a href="https://matomo.org/privacy/" target="_blank" rel="noopener noreferrer">Piwik,</a>] and others], to allow tracking technologies and remarketing services on the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> through the use of first party cookies and third-party cookies, to, among other things, analyze and track users’ use of the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span>, determine the popularity of certain content and better understand online activity. By accessing the Site<span style="color: #8351f9;"> [,our mobile application,]</span>, you consent to the collection and use of your information by these third-party vendors. You are encouraged to review their privacy policy and contact them directly for responses to your questions. We do not transfer personal information to these third-party vendors. However, if you do not want any information to be collected and used by tracking technologies, you can visit the third-party vendor or the <a href="https://optout.networkadvertising.org/?c=1" target="_blank" rel="noopener noreferrer">Network Advertising Initiative Opt-Out Tool</a> or <a href="https://optout.aboutads.info/?c=2&amp;lang=EN" target="_blank" rel="noopener noreferrer">Digital Advertising Alliance Opt-Out Tool</a>.</p>
                        <p>You should be aware that getting a new computer, installing a new browser, upgrading an existing browser, or erasing or otherwise altering your browser’s cookies files may also clear certain opt-out cookies, plug-ins, or settings.</p>
                        <p><strong>THIRD-PARTY WEBSITES</strong></p>
                        <p>The Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com</span> may contain links to third-party websites and applications of interest, including advertisements and external services, that are not affiliated with us. Once you have used these links to leave the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>, any information you provide to these third parties is not covered by this Privacy Policy, and we cannot guarantee the safety and privacy of your information. Before visiting and providing any information to any third-party websites, you should inform yourself of the privacy policies and practices (if any) of the third party responsible for that website, and should take those steps necessary to, in your discretion, protect the privacy of your information. We are not responsible for the content or privacy and security practices and policies of any third parties, including other sites, services or applications that may be linked to or from the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>.</p>
                        <p><strong>SECURITY OF YOUR INFORMATION</strong></p>
                        <p>We use administrative, technical, and physical security measures to help protect your personal information. While we have taken reasonable steps to secure the personal information you provide to us, please be aware that despite our efforts, no security measures are perfect or impenetrable, and no method of data transmission can be guaranteed against any interception or other type of misuse. Any information disclosed online is vulnerable to interception and misuse by unauthorized parties. Therefore, we cannot guarantee complete security if you provide personal information.</p>
                        <p><strong>POLICY FOR CHILDREN</strong></p>
                        <p>We do not knowingly solicit information from or market to children under the age of 13. If you become aware of any data we have collected from children under age 13, please contact us using the contact information provided below.</p>
                        <p><strong>CONTROLS FOR DO-NOT-TRACK FEATURES</strong></p>
                        <p>Most web browsers and some mobile operating systems <span style="color: #8351f9;">[and our mobile applications]</span> include a Do-Not-Track (“DNT”) feature or setting you can activate to signal your privacy preference not to have data about your online browsing activities monitored and collected. No uniform technology standard for recognizing and implementing DNT signals has been finalized. As such, we do not currently respond to DNT browser signals or any other mechanism that automatically communicates your choice not to be tracked online. If a standard for online tracking is adopted that we must follow in the future, we will inform you about that practice in a revised version of this Privacy Policy. Most web browsers and some mobile operating systems <span style="color: #8351f9;">[and our mobile applications]</span> include a Do-Not-Track (“DNT”) feature or setting you can activate to signal your privacy preference not to have data about your online browsing activities monitored and collected. If you set the DNT signal on your browser, we will respond to such DNT browser signals.</p>
                        <p><strong>OPTIONS REGARDING YOUR INFORMATION</strong></p>
                        <p><strong>[Account Information]</strong></p>
                        <p>You may at any time review or change the information in your account or terminate your account by:</p>
                        <ul>
                            <li>Logging into your account settings and updating your account</li>
                            <li>Contacting us using the contact information provided below</li>
                            <li><span style="color: #8351f9;">[Other]</span></li>
                        </ul>
                        <p>Upon your request to terminate your account, we will deactivate or delete your account and information from our active databases. However, some information may be retained in our files to prevent fraud, troubleshoot problems, assist with any investigations, enforce our Terms of Use and/or comply with legal requirements.</p>
                        <p><strong>Emails and Communications</strong></p>
                        <p>If you no longer wish to receive correspondence, emails, or other communications from us, you may opt-out by:</p>
                        <ul>
                            <li>Noting your preferences at the time you register your account with the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>.</li>
                            <li>Logging into your account settings and updating your preferences.</li>
                            <li>Contacting us using the contact information provided below.</li>
                        </ul>
                        <p>If you no longer wish to receive correspondence, emails, or other communications from third parties, you are responsible for contacting the third party directly.</p>
                        <p><strong>CALIFORNIA PRIVACY RIGHTS</strong></p>
                        <p>California Civil Code Section 1798.83, also known as the “Shine The Light” law, permits our users who are California residents to request and obtain from us, once a year and free of charge, information about categories of personal information (if any) we disclosed to third parties for direct marketing purposes and the names and addresses of all third parties with which we shared personal information in the immediately preceding calendar year. If you are a California resident and would like to make such a request, please submit your request in writing to us using the contact information provided below.</p>
                        <p>If you are under 18 years of age, reside in California, and have a registered account with the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>, you have the right to request removal of unwanted data that you publicly post on the Site <span style="color: #8351f9;">https://immense-sierra-70031.herokuapp.com/</span>. To request removal of such data, please contact us using the contact information provided below, and include the email address associated with your account and a statement that you reside in California. We will make sure the data is not publicly displayed on the Site<span style="color: #8351f9;"> https://immense-sierra-70031.herokuapp.com/</span>, but please be aware that the data may not be completely or comprehensively removed from our systems.</p>
                        <p><strong>CONTACT US</strong></p>
                        <p>If you have questions or comments about this Privacy Policy, please contact us at:</p>
                        <p><span style="color: #8351f9;">andreitam2014@gmail.com</span></p>
                        <p>This app is a school project</p>
                    </div>
            </div>
        </div>
    </div>
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </body></html>

</div>


<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>

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
    <nav class="navbar navbar-expand-xl navbar-light bg-light">
        <a href="#" class="navbar-brand"><i class="fa fa-cube"></i>Fitness<b>Booking<c>WebApp</c></b></a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
            <div class="navbar-nav">
                <a href="${pageContext.request.contextPath}/main" class="nav-item nav-link active">Home</a>
                <a href="${pageContext.request.contextPath}/navclasses" class="nav-item nav-link">Fitness Classes</a>
                <a href="${pageContext.request.contextPath}/navbookings" class="nav-item nav-link">My Bookings</a>
                <a href="${pageContext.request.contextPath}/navmembers" class="nav-item nav-link">Members</a>
            </div>
            <div class="navbar-nav ml-auto">
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="${pageContext.request.contextPath}/images/fitnessavatar.jpg" class="avatar" alt="Avatar"> ${requestScope.userEmail} <b class="caret"></b></a>
                    <div class="dropdown-menu">
                        <a href="${pageContext.request.contextPath}/profile" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a>
                        <div class="dropdown-divider"></div>
                        <a href="${pageContext.request.contextPath}/logout" class="dropdown-item"><i class="material-icons"></i> Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
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
        <script type="text/javascript">
            $(document).ready(function(){
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();
                $(".delete").click(function () {
                    console.log("delete modal");
                    var id = $(this).parent().find('#id').val();
                    $('#deleteClassModal #idDelete').val(id);
                });
            });
        </script>
    </head>
    <body>
    <div class="container-xl">
        <div class="table-responsive">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>My Bookings</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <%--<a href="${pageContext.request.contextPath}/main" class="btn btn-success" ><i class="material-icons">home</i> <span>Home</span></a>--%>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Booking Date</th>
                        <th>Class Name</th>
                        <th>Max Participants</th>
                        <th>Registered</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="fitnessBooking" items="${requestScope.fitnessBookings}">
                            <tr>
                                <td>
                                    <c:out value="${fitnessBooking.dateTimeBooking}"/>
                                </td>
                                <td>
                                    <c:out value="${fitnessBooking.fitnessClass.className}"/>
                                </td>
                                <td>
                                    <c:out value="${fitnessBooking.fitnessClass.setParticipants}"/>
                                </td>
                                <td>
                                    <c:out value="${fitnessBooking.fitnessClass.registeredParticipants}"/>
                                </td>
                                <td>
                                    <c:out value="${fitnessBooking.fitnessClass.startDateTime}"/>
                                </td>
                                <td>
                                    <c:out value="${fitnessBooking.fitnessClass.endDateTime}"/>
                                </td>
                                <td>
                                    <%--<a href="#editClassModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit" data-original-title="Edit"></i></a>--%>
                                    <a href="#deleteClassModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete" data-original-title="Delete"></i></a>
                                    <%--<a href="#bookClassModal" class="book" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Book" data-original-title="Book">date_range</i></a>--%>
                                    <input type="hidden" name="id" id="id" value="${fitnessBooking.id}">
                                    <%--<input type="hidden" name="className" id="className" value="${fitnessClass.className}">
                                    <input type="hidden" name="maxPart" id="maxPart" value="${fitnessClass.setParticipants}">
                                    <input type="hidden" name="startDateTime" id="startDateTime" value="${fitnessClass.startDateTime}">
                                    <input type="hidden" name="stopDateTime" id="stopDateTime" value="${fitnessClass.endDateTime}">--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>${noOfRecordsPerPage}</b> out of <b>${noOfRecords}</b> entries</div>
                    <ul class="pagination">
                        <%--Previous link--%>
                        <c:if test="${currentPage != 1}">
                        <li class="page-item disabled"><a href="${pageContext.request.contextPath}/navbookings?page=${currentPage - 1}">Previous</a></li>
                        </c:if>
                        <%--Displaying page numbers--%>
                        <c:forEach begin="1" end="${noOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <li class="page-item active"><a class="page-link">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a href="${pageContext.request.contextPath}/navbookings?page=${i}" class="page-link">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                            <%--Next link--%>
                            <c:if test="${currentPage lt noOfPages}">
                                <li class="page-item disabled"><a href="${pageContext.request.contextPath}/navbookings?page=${currentPage + 1}">Next</a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Add Modal HTML -->
    <%--<div id="addClassModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post">
                    <input type="hidden" name="action" value="Add">
                    <div class="modal-header">
                        <h4 class="modal-title">Add Fitness Class</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" name="classNameAdd" id="classNameAdd" required="">
                        </div>
                        <div class="form-group">
                            <label>Maximum Participants</label>
                            <input type="text" class="form-control" name="maxPartAdd" id="maxPartAdd" required="">
                        </div>
                        <div class="form-group">
                            <label>Start Date & Time</label>
                            <input type="datetime-local" class="form-control" name="startDateTimeAdd" id="startDateTimeAdd" required="">
                        </div>
                        <div class="form-group">
                            <label>Stop Date & Time</label>
                            <input type="datetime-local" class="form-control" name="stopDateTimeAdd" id="stopDateTimeAdd" required="">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </div>--%>
    <!-- Edit Modal HTML -->
    <%--<div id="editClassModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post">
                    <input type="hidden" name="action" value="Edit">
                    <div class="modal-header">
                        <h4 class="modal-title">Edit Fitness Class</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" name="classNameEdit" id="classNameEdit" required="">
                        </div>
                        <div class="form-group">
                            <label>Maximum Participants</label>
                            <input type="text" class="form-control" name="maxPartEdit" id="maxPartEdit" required="">
                        </div>
                        <div class="form-group">
                            <label>Start Date & Time</label>
                            <input type="datetime-local" class="form-control" name="startDateTimeEdit" id="startDateTimeEdit" required="">
                        </div>
                        <div class="form-group">
                            <label>Stop Date & Time</label>
                            <input type="datetime-local" class="form-control" name="stopDateTimeEdit" id="stopDateTimeEdit" required="">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-info" value="Save">
                        <input type="hidden" name="idEdit" id="idEdit">
                    </div>
                </form>
            </div>
        </div>
    </div>--%>
    <!-- Delete Modal HTML -->
    <div id="deleteClassModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post">
                    <input type="hidden" name="action" value="Delete">
                    <div class="modal-header">
                        <h4 class="modal-title">Delete Fitness Booking</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete this Fitness Booking?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-danger" value="Delete">
                        <input type="hidden" name="idDelete" id="idDelete">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Book Modal HTML -->
    <%--<div id="bookClassModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h4 class="modal-title">Book Employee</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these Records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </div>
                </form>
            </div>
        </div>
    </div>--%>
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

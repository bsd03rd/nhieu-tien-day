<%-- 
    Document   : header
    Created on : Nov 30, 2022, 11:51:49 AM
    Author     : l
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Felicity</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="assets/images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/assets/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

    </head>
    <body>
        <!-- header -->
        <header>


            <!-- header inner -->
            <div class="header">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                            <div class="full">
                                <div class="center-desk">
                                    <div class="logo">
                                        <a href="home"><img src="assets/images/logo.png" alt="#" /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                        
                        <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                            <nav class="navigation navbar navbar-expand-md navbar-dark ">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarsExample04">
                                    <ul class="navbar-nav mr-auto">
                                        <li class="nav-item">
                                            <a class="nav-link" href="#about">About</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="hotel">Hotel</a>
                                        </li>
                                    </ul>
                                   

                                    <c:choose>
                                        <c:when test = "${account == null}">
                                            <div class="sign_btn"><a href="login"><i class="fa fa-user-circle" aria-hidden="true"></i> Sign in</a></div>
                                        </c:when>
                                        <c:otherwise>
                                            <c:if test = "${account.getRoleID() == 1}">
                                                <div class="sign_btn">
                                                    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                                        <i class="fa fa-user-circle" aria-hidden="true"></i> ${account.username}
                                                    </button>
                                                    <div class="dropdown-menu">
                                                        <a  class="dropdown-item" href="profile"> Xem hồ sơ </a>
                                                        <a  class="dropdown-item" href="logout"> Đăng xuất </a>
                                                        <a  class="dropdown-item" href="change"> Đổi mật khẩu </a>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                            </nav>
                        </div>

                    </div>
                </div>
            </div>
        </header>
        <!-- end header inner -->
        <!-- end header -->
    </body>
</html>

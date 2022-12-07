<%-- 
    Document   : login
    Created on : Sep 12, 2022, 1:19:33 PM
    Author     : vuman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="assets/css/Log-Reg.css">
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />

        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.3.0/mdb.min.css" rel="stylesheet" />

        <!-- Owl Carousel -->
        <link rel="stylesheet" href="lib/owlcarousel/assets/owl.carousel.min.css" />
        <link rel="stylesheet" href="lib/owlcarousel/assets/owl.theme.default.min.css" />
    </head>

    <body>
        <div class="body d-flex align-items-center min-vh-100 py-3 py-md-0">
            <div class="container">
                <div class="card login-card">
                    <div class="row no-gutters">
                        <div class="col-md-1">
                            <a href="home" style="color: black;" title="Return home">
                                <i class="fa-solid fa-circle-left home"></i>
                            </a>
                        </div>

                        <div class="col-md-5 form">
                            <div class="card-body">
                                <p class="login-card-description text">Welcome back</p>
                                <p style="color: rgb(179, 177, 177);">Welcome back! Please enter your detail</p>

                                <form action="login" method="post">

                                    <div class="form-outline mb-3">
                                        <input type="text" name="username" class="form-control enter">
                                        <label class="form-label">Username</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" name="password" class="form-control input">
                                        <label class="form-label">Password</label>
                                    </div>

                                    <div class="move mb-4">
                                        <a style="font-weight: bold; color: rgb(92, 88, 88); margin-left: 180px;" href="forgotpass">Forgot password</a>
                                    </div>

                                    <button class="btn mb-4" type="submit" style="background-color: black; color: white;">Sign in</button>                                                                           
                                </form>
                                <form action="login-google" method="POST">
                                    <a href="https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.profile+email&client_id=360712733433-c1sc36s6apgp7gvfojp8fj00er2art2e.apps.googleusercontent.com&response_type=code&redirect_uri=http://localhost:8080/LearningProject/login-google&approval_prompt=force" class="btn mb-4" type="submit" ><img
                                            src="assets/img/Log-Reg/Google-Icon.png" style="height: 18px">
                                        Sign in with Google</a>                                    
                                </form>

                                <div class="text-danger" style="margin-bottom: 20px">${result}</div>

                                <div>
                                    <span style="color: rgb(179, 177, 177);">Don't have an account?</span>
                                    <a class="move" href="register" style="color: rgb(92, 88, 88); font-weight: bold;">Sign up for free</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <img src="assets/img/Log-Reg/Log-Reg-Image.png"
                                 alt="login" class="img-fluid rounded-4" style="height: 700px; object-fit: cover;">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- MDB -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
    </body>
</html>

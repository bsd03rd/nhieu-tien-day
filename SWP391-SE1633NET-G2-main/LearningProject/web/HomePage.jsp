<%-- 
    Document   : HomePage
    Created on : Sep 18, 2022, 3:59:18 AM
    Author     : 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Course" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Elearning</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/homepage.css">
        <link rel="stylesheet" href="assets/css/header.css">
        <link rel="stylesheet" href="assets/css/footer.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css"
              integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
              integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap');
        </style>
    </head>

    <body>
        <%@include file="header.jsp"%>

        <div id="main" >            
            <div id="content" >
                <!-- Begin: Side Bar -->
                <div id="side-bar">
                    <c:if test="${user.role == 'Mentor'}">
                        <a style="
                           display: block;
                           width: 36px;
                           display: flex;
                           justify-content: center;
                           align-items: center;
                           height: 36px;
                           padding: 19px;
                           border-radius: 50%;
                           background-color: var(--bs-orange);
                           margin: 0 auto 10px auto;
                           " href="CreateCourse" data-bs-toggle="tooltip" data-bs-placement="right" title="Create Course">
                            <i class="fa-solid fa-plus" style="
                               font-size: 24px;
                               /* padding: 10px; */
                               color: white;
                               "></i>
                        </a>
                    </c:if>
                    <a class="bar-button button-hover" href="home">
                        <i class="fa-solid fa-house"></i>
                        <p class="button-title">Home</p>
                    </a>
                    <c:if test="${user.role == 'User'}">
                        <a class="bar-button " href="userdashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">User Dashboard</p>
                        </a>
                    </c:if>
                    <c:if test="${user.role == 'Admin'}">
                        <a class="bar-button " href="userdashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">User Dashboard</p>
                        </a>
                        <a class="bar-button" href="admindashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">Admin Dashboard</p>
                        </a>
                    </c:if>
                    <c:if test="${user.role == 'Mentor'}">
                        <a class="bar-button " href="userdashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">User Dashboard</p>
                        </a>
                        <a class="bar-button " href="mentordashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">Mentor Dashboard</p>
                        </a>
                    </c:if>
                    <!--                    <a class="bar-button" href="blog">
                                            <i class="fa-solid fa-newspaper"></i>
                                            <p class="button-title">Blog</p>
                                        </a>-->

                </div>
                <!-- End: Side Bar -->

                <!-- Begin: Section Content -->
                <section class="section-home show">
                    <div class="section-slider autoplay">
                        <div class="slider-content">
                            <div class="slider-content-left">
                                <h1>Become a mentor on our web</h1>
                                <p>Come and register as a mentor to post course on our website</p>
                                <!--<a href="becomementor">Register</a>-->
                                <a href="#">Register</a>
                            </div>
                            <div class="slider-content-right">
                                <img src="assets/img/slider-img/slide-img.png" alt=""
                                     style="height: 100%; object-fit: cover;">
                            </div>
                        </div>
                        <div class="slider-content-1">
                            <div class="slider-content-left">
                                <h1>Upgrade your learning skill</h1>
                                <p>Đây là khóa học đầy đủ và chi tiết nhất bạn có thể tìm thấy được ở trên Internet!</p>
                                <a href="#">Tìm hiểu thêm</a>
                            </div>
                            <div class="slider-content-right" style="height: 80%;">
                                <img src="assets/img/slider-img/slider1-img.png" alt=""
                                     style="height: 100%; object-fit: cover;">
                            </div>
                        </div>
                        <div class="slider-content-2">
                            <div class="slider-content-left">
                                <h1>Upgrade your learning skill</h1>
                                <p>Đây là khóa học đầy đủ và chi tiết nhất bạn có thể tìm thấy được ở trên Internet!</p>
                                <a href="#">Tìm hiểu thêm</a>
                            </div>
                            <div class="slider-content-right" style="height: 90%;">
                                <img src="assets/img/slider-img/slider2-img.png" alt=""
                                     style="height: 100%; object-fit: cover;">
                            </div>
                        </div>
                        <div class="slider-content-3">
                            <div class="slider-content-left">
                                <h1>Upgrade your learning skill</h1>
                                <p>Đây là khóa học đầy đủ và chi tiết nhất bạn có thể tìm thấy được ở trên Internet!</p>
                                <a href="#">Tìm hiểu thêm</a>
                            </div>
                            <div class="slider-content-right" style="height: 90%;">
                                <img src="assets/img/slider-img/slider3-img.png" alt=""
                                     style="height: 100%; object-fit: cover;">
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="row">
                            <h3 style="display: inline-block;" class="fw-bold my-3">Pro Course</h3>
                            <div class="custom-select" style="width:200px;">
                                <select id="selectBox" onchange="changeFunc();" style="width: 55%;">
                                    <option value="0">Sort by:</option>
                                    <option value="Newst">Newst</option>
                                    <option value="Oldest">Oldest</option>
                                </select>
                            </div>
                            <script>
                                function openURL() {
                                    window.open('https://www.youtube.com/');
                                }
                                function changeFunc() {
                                    var selectBox = document.getElementById("selectBox");
                                    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                                    window.location = 'home?sortby='+selectedValue;
                                }
                            </script>
                        </div>
                        <div class="row g-3">
                            <c:forEach items="${requestScope.courses}" var="course">
                                <div class="col-xl-3 col-lg-4 col-md-6" >
                                    <div class="card" style="min-height: 234px; height: 420px;">
                                        <div style="position: relative;" class="card-top-img">
                                            <img src="${course.getCourseImage()}" alt="" style="width: 100%; height: 200px; object-fit: cover">
                                            <p style=";font-size: 12px;position: absolute;bottom: 0px;left: 0px;border-radius: 25px;background: #73AD21;">Create date:${course.getDateCreate()}</p>
                                        </div>
                                        <div style="position: relative;" class="card-body">
                                            <a href="addcart?CourseID=${course.getCourseID()}"> <p  style=" cursor: pointer;font-size:24px;position:absolute;right: 5%;bottom: 5%;"  ><i class="fa-solid fa-cart-plus"></i></p></a>
                                            <h6 class="course-title"><a href="CourseDetails?id=${course.getCourseID()}">${course.getCourseName()}</a></h6>
                                            <div class="course-meta-info">
                                                <div class="course-meta-author">
                                                    <div class="author-avatar">
                                                        <img src="${course.getAuthor().getAvatar()}"
                                                             alt="" style="width: 40px; height: 40px; border-radius: 50%;">
                                                    </div>
                                                    <p>By <a href="profiledetails?id=${course.getAuthor().getUserId()}" class="author-name">${course.getAuthor().firstName}</a></p>
                                                </div>
                                                <div class="course-meta-student">
                                                    <i class="fa-solid fa-user"></i>
                                                    <p>${course.getNumberEnrolled()} Students</p>
                                                </div>
                                            </div>
                                            <div class="course-footer">
                                                <c:if test="${course.getCoursePrice() == 0}">
                                                    <div class="free" style="background-color: cornflowerblue; padding: 8px 18px; border-radius: 40px; color:  white;">Free</div>
                                                    <form id="enroll" action="enroll" method="POST" class="d-flex justify-content-between">                                                                             
                                                        <c:if test="${!courseIDs.contains(course.getCourseID())}">
                                                            <input name="op" type="submit" value="Enroll">
                                                        </c:if>

                                                        <c:if test="${courseIDs.contains(course.getCourseID())}">
                                                            <input name="op" type="submit" value="Go to Course">
                                                        </c:if>

                                                        <input type="hidden" name="courseID" value="${course.getCourseID()}">
                                                    </form>
                                                </c:if>
                                                <c:if test="${course.getCoursePrice() != 0}">
                                                    <div class="course-price">${course.getCoursePrice()} đ</div>
                                                    <form id="enroll" action="enroll" method="POST">
                                                        <c:if test="${!courseIDs.contains(course.getCourseID())}">

                                                            <input name="op" type="submit" value="Buy now" class="d-inline">
                                                        </c:if>
                                                        <c:if test="${courseIDs.contains(course.getCourseID())}">
                                                            <a style="display: inline-block;padding: 10px;" href="CourseDetails?id=${course.getCourseID()}">Go to Course</a>

                                                        </c:if>
                                                        <fmt:parseNumber var = "price" integerOnly = "true" type = "number" value = "${course.getCoursePrice()}" />
                                                        <input type="hidden" name="coursePrice" value="${price}">
                                                        <input type="hidden" name="courseID" value="${course.getCourseID()}">

                                                    </form>
                                                </c:if>


                                            </div>
                                            <div class="mt-2">
                                                <c:set var="isPresent" value="${false}"></c:set>

                                                <c:forEach items="${usercourselist}" var="usercourse">
                                                    <c:if test="${course.getCourseID() == usercourse.getCourseID()}">
                                                        <c:if test="${usercourse.isIsFavourite() == true}">
                                                            <form action="home" method="POST">
                                                                <input type="hidden" name="courseID" value="${course.getCourseID()}">
                                                                <button style="border: none;  background-color: transparent; outline: unset; font-size: 25px; color:red" type="button" name="favour" value="unlike" onclick="unlike(this.parentNode)"><i class="fa-solid fa-heart"></i></i></button>

                                                            </form>     
                                                            <c:set var="isPresent" value="${true}"></c:set>
                                                        </c:if>
                                                    </c:if> 

                                                </c:forEach>

                                                <c:if test="${isPresent == false}">
                                                    <form action="home" method="POST">
                                                        <input type="hidden" name="courseID" value="${course.getCourseID()}">
                                                        <button style="border: none; outline: unset;background: transparent; font-size: 25px" type="button" name="favour" value="like" onclick="like(this.parentNode)"><i class="fa-regular fa-heart"></i></button>
                                                    </form>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </section>
                <!-- End: Section Content -->
            </div>

            <!-- Begin: Footer -->
            <footer style="margin-left: 100px;">
                <footer class="new_footer_area bg_color">
                    <div class="new_footer_top">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6 col-md-12 text-center">
                                    <div class="f_widget company_widget wow fadeInLeft" data-wow-delay="0.2s"
                                         style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
                                        <h3 class="f-title f_600 t_color f_size_18">About us</h3>
                                        <p>We are group 2, class SE1633-NET. This is our project in subject SWP391. This
                                            project is guided by
                                            lecturer Pham Duc Thang. This is an online learning platform through video
                                            lectures. We hope this
                                            platform will help you learn better in programming, moreover in soft skills.
                                            Thank you!</p>
                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12 text-center">
                                    <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.6s"
                                         style="visibility: visible; animation-delay: 0.6s; animation-name: fadeInLeft;">
                                        <h3 class="f-title f_600 t_color f_size_18">Contact us</h3>
                                        <ul class="list-unstyled f_list">
                                            <li>
                                                <a href="#"><i class="lnr lnr-phone-handset"></i> +84 097 342 25334</a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="lnr lnr-envelope"></i>
                                                    user@fpt.edu.vn</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="footer_bg">
                            <div class="footer_bg_one"></div>
                            <div class="footer_bg_two"></div>
                        </div>
                    </div>
                </footer>
            </footer>
            <!-- End: Footer -->
        </div>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
                integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js"
                integrity="sha512-WNZwVebQjhSxEzwbettGuQgWxbpYdoLf7mH+25A7sfQbbxKeS5SQ9QBf97zOY4nOlwtksgDA/czSTmfj4DUEiQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script type="text/javascript">
                                                            $('.autoplay').slick({
                                                                slidesToShow: 1,
                                                                slidesToScroll: 1,
                                                                autoplay: true,
                                                                autoplaySpeed: 5000,
                                                                speed: 1500,
                                                                dots: true
                                                            });
        </script>

        <script>
            function like(form) {
                const courseID = form.querySelector("input[name='courseID']").value;
                const button = form.querySelector("button");

                $.ajax({
                    url: form.action,
                    type: form.method,
                    data: 'favour=like&courseID=' + courseID,
                    success: function (data) {
                        if (data === "true") {
                            button.remove();
                            form.innerHTML += `<button style="border: none;  background-color: transparent; outline: unset; font-size: 25px; color:red" type="button" name="favour" value="unlike" onclick="unlike(this.parentNode)"><i class="fa-solid fa-heart"></i></i></button>`;
                        }
                    },
                    error: function () {
                        console.log('Error');
                    }
                });
            }

            function unlike(form) {
                const courseID = form.querySelector("input[name='courseID']").value;
                const button = form.querySelector("button");

                $.ajax({
                    url: form.action,
                    type: form.method,
                    data: 'favour=unlike&courseID=' + courseID,
                    success: function (data) {
                        if (data === "false") {
                            button.remove();
                            form.innerHTML += `<button style="border: none; outline: unset;background: transparent; font-size: 25px" type="button" name="favour" value="like" onclick="like(this.parentNode)"><i class="fa-regular fa-heart"></i></button>`;
                        }
                    },
                    error: function () {
                        console.log('Error');
                    }
                });
            }
        </script>
    </body>

</html>

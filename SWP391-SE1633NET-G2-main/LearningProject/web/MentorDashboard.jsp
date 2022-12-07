<%-- 
    Document   : HomePage
    Created on : Sep 18, 2022, 3:59:18 AM
    Author     : HieuShin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <div id="main" >
            <%@include file="header.jsp"%>            
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
                    <a class="bar-button" href="home">
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
                        <a class="bar-button " href="#">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">Admin Dashboard</p>
                        </a>
                    </c:if>
                    <c:if test="${user.role == 'Mentor'}">
                        <a class="bar-button " href="userdashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">User Dashboard</p>
                        </a>
                        <a class="bar-button button-hover" href="mentordashboard">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title text-center">Mentor Dashboard</p>
                        </a>
                    </c:if>
                     <a class="bar-button" href="blog">
                            <i class="fa-solid fa-newspaper"></i>
                            <p class="button-title">Blog</p>
                        </a>


                </div>
                <!-- End: Side Bar -->

                <!-- Begin: Section Content -->
                <section class="section-home show">
                    <div class="section-slider autoplay">
                        <div class="slider-content">
                            <div class="slider-content-left">
                                <h1>Become a mentor on our web</h1>
                                <p>Come and register as a mentor to post course on our website</p>
                                <a href="becomementor">Register</a>
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
                    <div class="container-fluid" style="background-image: unset; height: unset;">
                        <div class="user-dashboard py-4">
                            <div class="row">
                                <div class="col-8">
                                    <h5 class="fw-bold">Overview</h5>
                                    <div class="row gy-3">
                                        <div class="col-6">
                                            <div class="overview p-4 bg-white">
                                                <div class="overview-header mb-2">
                                                    <h6>All number of course</h6>
                                                </div>
                                                <div class="overview-content d-flex justify-content-between">
                                                    <p>${numofcourses}</p>
                                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="overview p-4 bg-white">
                                                <div class="overview-header mb-2">
                                                    <h6>All number of account</h6>
                                                </div>
                                                <div class="overview-content d-flex justify-content-between">
                                                    <p>${numofstudents}</p>
                                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="overview p-4 bg-white">
                                                <div class="overview-header mb-2">
                                                    <h6>All number of blog</h6>
                                                </div>
                                                <div class="overview-content d-flex justify-content-between">
                                                    <p>${numofblogs}</p>
                                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="overview p-4 bg-white">
                                                <div class="overview-header mb-2">
                                                    <h6>All number of quiz</h6>
                                                </div>
                                                <div class="overview-content d-flex justify-content-between">
                                                    <p>${numofquizs}</p>
                                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12">
                        <h5 class="fw-bold">All course I have created</h5>
                        <div class="card card-body shadow-sm" style="border-radius: 12px;">
                            <div class="row">
                                <div class="col-12">
                                    <table class="table table-borderless">
                                        <thead>
                                        <th>Course Name</th>
                                        <th>Date Created</th>
                                        <th>Course Category</th>
                                        <th>Course Price</th>
                                        <th>Status</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.courses}" var="course"> 
                                                <tr>
                                                    <td style="max-width: 180px">
                                                        <div class="d-flex">
                                                            <img src="assets/img/Asset 1.png" alt="" style="width: 48px; height: 48px; object-fit: cover; border-radius: 10px;">
                                                            <div class="ms-2">
                                                                <div class="fw-bold">${course.getCourseName()}o</div>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div style="font-weight: 600">${course.getDateCreate()}</div>
                                                    </td>
                                                    <td>
                                                        <div>
                                                            <div style="background-color: #4dd4ac; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">${course.getCategory()}</div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div>
                                                            <c:if test="${course.getCoursePrice() == 0}">
                                                                <div style="background-color: #ccc; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">Free</div>

                                                            </c:if>
                                                            <c:if test="${course.getCoursePrice() != 0}">
                                                                <div style="background-color: #ccc; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">${course.getCoursePrice()}đ</div>

                                                            </c:if>    
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div>
                                                            <c:if test="${course.getStatus().trim() == 'Enabled'}">
                                                                <div style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;" class="bg-success">
                                                                    Disabled
                                                                </div>
                                                            </c:if>

                                                            <c:if test="${course.getStatus().trim() == 'Disabled'}">
                                                                <div style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;" class="bg-danger">
                                                                    Accepted
                                                                </div>
                                                            </c:if>
                                                            
                                                            <c:if test="${course.getStatus().trim() == 'Pending'}">
                                                                <div style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;" class="bg-warning">
                                                                    Pending
                                                                </div>
                                                            </c:if>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>


                                        </tbody>
                                    </table>
                                    <div class="d-flex justify-content-center">
                                        <a href="#">Load More...</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="container-fluid" style="background-image: unset; height: unset;">
                        <div class="row">
                            <h3 class="fw-bold my-3">All course still working</h3>
                        </div>
                        <div class="row g-3">
                            <c:forEach items="${requestScope.courses}" var="course">
                                <c:if test="${course.getStatus().trim() == 'Enabled'}">
                                    <div class="col-xl-3 col-lg-4 col-md-6" >
                                        <div class="card" style="min-height: 234px; height: 400px;">
                                            <div class="card-top-img">
                                                <img src="${course.getCourseImage()}" alt="" style="width: 100%; height: 200px; object-fit: cover">
                                            </div>
                                            <div class="card-body">
                                                <h5 class="course-title">${course.getCourseName()}</h5>
                                                <div class="course-meta-info">
                                                    <div class="course-meta-author">
                                                        <div class="author-avatar">
                                                            <img src="${course.getAuthor().getAvatar()}"
                                                                 alt="" style="width: 40px; height: 40px; border-radius: 50%;">
                                                        </div>
                                                        <p>By <a href="#" class="author-name">${course.getAuthor().firstName}</a></p>
                                                    </div>
                                                    <div class="course-meta-student">
                                                        <i class="fa-solid fa-user"></i>
                                                        <p>${course.getNumberEnrolled()} Students</p>
                                                    </div>
                                                </div>
                                                <div class="course-footer">
                                                    <form action="updatecourse">                                                        

                                                        <input type="submit" value="Update">


                                                        <input type="hidden" name="courseid" value="${course.getCourseID()}">
                                                    </form>

                                                    <form action="updatecourse" method="POST">                                                        

                                                        <input type="submit" name="button" value="Delete">


                                                        <input type="hidden" name="courseid" value="${course.getCourseID()}">
                                                    </form>
                                                    
                                                    <form action="quizdashboard" method="GET">  

                                                        <input type="submit" value="Quiz">


                                                        <input type="hidden" name="courseid" value="${course.getCourseID()}">
                                                    </form>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
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
                                                <a href="#"><i class="lnr lnr-phone-handset"></i> +84 988 561
                                                    896</a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="lnr lnr-envelope"></i>
                                                    hieunvhe163104@fpt.edu.vn</a>
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
    </body>

</html>

<%-- 
    Document   : ProfileDetails
    Created on : Oct 31, 2022, 2:46:44 AM
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
        <title>${user.getLastName()} ${user.getFirstName()}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
        <link rel="stylesheet" href="assets/css/header.css" />
        <link rel="stylesheet" href="assets/css/blog.css">
        <link rel="stylesheet" href="assets/css/homepage.css">

    </head>

    <body style="font-family: 'Montserrat'; width: 100vw; " class="bg-light ">

        <div id="main">
            <%@include file="header.jsp"%>
            <div id="blog" style="margin-left: 0px; width: 100%;">
                <div>
                    <div class="bg-white">
                        <img src="assets/img/pawel-czerwinski-QY5U8JD3-tk-unsplash.jpg" alt=""
                             style="width: 100%; height: 320px; object-fit: cover;">
                        <div class="content d-flex position-relative justify-content-center flex-column align-items-center"
                             style="top: -40px;">
                            <div class="avatar">
                                <img src="${user.getAvatar()}" alt=""
                                     style="width: 80px; height: 80px; object-fit: cover; border-radius: 50px;">
                            </div>
                            <div class="user-information mt-3">
                                <h3 class="text-center">${user.getLastName()} ${user.getFirstName()}</h3>
                                <p class="text-center text-black-50">${user.getEmail()}</p>
                                <div class="d-flex">
                                    <div style="font-size: 14px;" class="text-black-50">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span>${user.getAddress()}, ${user.getCountry()}</span>
                                    </div>
                                    <div class="ms-3 text-black-50" style="font-size: 14px;">
                                        <i class="fa-solid fa-phone"></i>
                                        <span>${user.getPhone()}</span>
                                    </div>
                                </div>

                            </div>
                            <nav class="mt-3 w-100">
                                <div class="nav nav-tabs d-flex justify-content-evenly" id="nav-tab" role="tablist">
                                    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab"
                                            data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home"
                                            aria-selected="true">Course</button>
                                    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab"
                                            data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile"
                                            aria-selected="false">Blog</button>
                                </div>
                            </nav>
                            <div class="tab-content w-100"  id="nav-tabContent">
                                <div class="tab-pane fade show active w-100" id="nav-home" role="tabpanel"
                                     aria-labelledby="nav-home-tab">
                                    <div class="row g-3 mt-5">

                                        <c:forEach items="${requestScope.courses}" var="course">
                                            <div class="col-xl-3 col-lg-4 col-md-6" >
                                                <div class="card" style="min-height: 234px; height: 400px;">
                                                    <div class="card-top-img">
                                                        <img src="${course.getCourseImage()}" alt="" style="width: 100%; height: 200px; object-fit: cover">
                                                    </div>
                                                    <div class="card-body">

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
                                                                        <input name="op" type="submit" value="Go to Course">                                                            
                                                                    </c:if>
                                                                    <fmt:parseNumber var = "price" integerOnly = "true" type = "number" value = "${course.getCoursePrice()}" />
                                                                    <input type="hidden" name="coursePrice" value="${price}">
                                                                    <input type="hidden" name="courseID" value="${course.getCourseID()}">

                                                                </form>
                                                            </c:if>


                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>

                                </div>
                                <div class="tab-pane fade" id="nav-profile" role="tabpanel"
                                     aria-labelledby="nav-profile-tab">
                                    <div class="w-100 row mt-3 justify-content-center">
                                        <!-- Blog -->
                                        <div class="col-10">
                                            <c:forEach items="${blogs}" var="blogs">
                                                <div class="card card-body p-3 shadow-sm mb-4"> 
                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <!-- User post -->
                                                        <div class="d-flex align-items-center">
                                                            <img src="${blogs.getUser().getAvatar()}" alt="" style="width: 24px; height: 24px; object-fit: cover; border-radius: 50%;">
                                                            <a style="font-size: 12px; font-weight: 600  ;" class="ms-2" href="profiledetails?id=${blogs.getUserid()}">${blogs.getUser().getLastName()} ${blogs.getUser().getFirstName()}</a>
                                                        </div>

                                                        <!-- User post -->

                                                        <!-- Action -->
                                                        <i class="fa-solid fa-ellipsis"></i>
                                                        <!-- Action -->
                                                    </div>

                                                    <!-- Content -->
                                                    <div class="mt-3 d-flex justify-content-between align-items-center">
                                                        <!-- Content left -->
                                                        <div class="" style="width: 78%;">
                                                            <a style="font-size: 20px;" class="fw-bolder" href="blogdetail?id=${blogs.getBlogid()}">${blogs.getTitle()}</a>
                                                            <p class="text-black-50" style="font-size: 15px;">${blogs.getDescription()}</p>
                                                        </div>
                                                        <!-- Content left -->
                                                        <div style="width: 20%; height: 80px;">
                                                            <img src="${blogs.getImage()}" class="rounded-3" alt="" style="width: 100%; max-height: 120px; object-fit: cover;">
                                                        </div>
                                                        <!-- Content right -->
                                                        <div>

                                                        </div>
                                                        <!-- Content right -->

                                                    </div>
                                                    <!-- Content -->

                                                    <div class="d-flex align-items-center">
                                                        <div class="tag bg-primary fw-bold text-white" style="padding: 6px 12px; width: fit-content; border-radius: 16px; font-size: 14px;">
                                                            ${blogs.getCategory()}
                                                        </div>
                                                        <span class="ms-2">
                                                            .
                                                        </span>
                                                        <div class="ms-2 d-inline-block" style="font-size: 14px;">
                                                            <fmt:formatDate type = "both" value = "${blog.getDate()}" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <!-- Blog -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>

</html>

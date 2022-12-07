<%-- 
    Document   : CourseDetails
    Created on : Sep 29, 2022, 8:32:15 PM
    Author     : Dung
--%>

<%@page import="Model.Lesson"%>
<%@page import="Model.Section"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Elearning</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="assets/css/header.css" />
        <link rel="stylesheet" href="assets/css/course_details.css" />
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap");
        </style>
    </head>

    <body>
        <div id="main">
        <%@include file="header.jsp"%>
            <header>
                <div class="header-content">
                    <div class="logo">
                        <img src="assets/img/Logo-FPT.webp" alt="" />
                        <div class="header-title">Học Lập Trình FPT</div>
                    </div>
                    <div class="header-search">
                        <div class="icon-search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </div>
                        <input
                            type="text"
                            placeholder="Tìm kiếm khóa học, bài viết, video..."
                            />
                    </div>
                    <div class="header-profile">
                        <div class="header-mycourse">Khóa học của tôi</div>
                        <div class="header-notification" onclick="event.stopPropagation()">
                            <i class="fa-solid fa-bell"></i>
                            <div
                                class="notification-cotainer"
                                onclick="event.stopPropagation()"
                                >
                                <div class="notification-header">
                                    <h3>Thông báo</h3>
                                    <i class="fa-solid fa-ellipsis"></i>
                                </div>
                                <div class="notification-list">
                                    <div class="notification">
                                        <div class="noti-icon">
                                            <img src="assets/img/f8-logo.png" alt="" />
                                        </div>
                                        <div class="noti-content">
                                            <p>
                                                Chào mừng <span>Le Dao Quang Dung</span> đã gia nhập F8.
                                                Hãy luôn đam mê, kiên trì và theo đuổi mục tiêu tới cùng
                                                bạn nhé ❤️
                                            </p>
                                            <div class="noti-time">một tháng trước</div>
                                        </div>
                                        <div class="noti-remind"></div>
                                    </div>
                                    <div class="notification">
                                        <div class="noti-icon">
                                            <img src="assets/img/f8-logo.png" alt="" />
                                        </div>
                                        <div class="noti-content">
                                            <p>
                                                Chào mừng <span>Le Dao Quang Dung</span> đã gia nhập F8.
                                                Hãy luôn đam mê, kiên trì và theo đuổi mục tiêu tới cùng
                                                bạn nhé ❤️
                                            </p>
                                            <div class="noti-time">một tháng trước</div>
                                        </div>
                                        <div class="noti-remind"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:if test="${user==null}">
                            <button class="btn btn-info"><a href="login" class="text-white fw-bold">Login</a></button>
                        </c:if>
                        <c:if test="${user!=null}">
                            <div class="avatar" onclick="event.stopPropagation()">
                                <c:if test="${user.getAvatar() != null}">
                                    <img src="${user.getAvatar()}" alt="">                                
                                </c:if>
                                <c:if test="${user.getAvatar() == null}">
                                    <img src="assets/img/user.png">
                                </c:if>
                                <div class="account-menu">
                                    <div class="menu-content">
                                        <div class="menu-element">
                                            <i class="fa-solid fa-user"></i>
                                            <a href="AccountProfile" class="menu-title">Trang cá nhân</a>
                                        </div>
                                        <div class="menu-element">
                                            <i class="fa-solid fa-list"></i>
                                            <a href="" class="menu-title">Khóa học của tôi</a>
                                        </div>
                                        <div class="menu-element">
                                            <i class="fa-solid fa-gear"></i>
                                            <a href="" class="menu-title">Cài đặt</a>
                                        </div>
                                        <div class="line">

                                        </div>
                                        <div class="menu-element">
                                            Account Balance:
                                            <a href="" class="menu-title">${user.getBalance()}</a>
                                        </div>
                                        <div class="menu-element menu-logout">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <a href="logout" class="menu-title">Đăng xuất</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </header>

            <section>
                <!-- Begin: Course Details -->
                <div class="course-details-container">
                    <div class="course-details">
                        <div class="course-details-left">

                            <h2 class="course-details-title">${course.getCourseName()}</h2>

                            <p class="course-details-description">
                                ${course.getDescription()}
                            </p>
                            <div class="course-objectives">
                                <div class="course-objective-title">Bạn sẽ học được gì?</div>
                                <div class="course-objective-list">
                                    <c:forEach items="${objective}" var="obj">
                                        <div class="objective">
                                            <i class="fa-solid fa-check"></i>
                                            <p>${obj}</p>
                                        </div>
                                    </c:forEach>                                            
                                </div>
                            </div>

                            <!-- Course Agenda -->
                            <div class="course-agenda">
                                <h3 class="course-agenda-title">Nội dung khóa học</h3>
                                <div class="course-agenda-description">
                                    <div class="course-agenda-left">
                                        <div class="course-chapter">
                                            <span class="fw-bold">${sectionList.size()}</span> Chapter
                                        </div>
                                        <span>.</span>
                                        <div class="course-lesson">
                                            <span class="fw-bold">${lessonList.size()}</span> lessons
                                        </div>
                                        <span>.</span>
                                        <div class="course-time">
                                            Time <span class="fw-bold">${totalTime}</span>
                                        </div>
                                    </div>
                                    <div class="course-agenda-right">
                                        <p>Expand all</p>
                                    </div>
                                </div>
                                <div class="course-agenda-section">
                                    <div class="section-list">
                                        <c:forEach items="${sectionList}" var="section">
                                            <!-- Course Chapter -->
                                            <div class="course-section-container">
                                                <div
                                                    class="course-section course-active d-flex justify-content-between flex-wrap"
                                                    >
                                                    <div
                                                        class="course-section-left d-flex justify-content-between align-items-center"
                                                        >
                                                        <i class="fa-solid fa-plus"></i>
                                                        <p>${section.getSectionName()}</p>
                                                    </div>
                                                    <%
                                                        int count = 0;
                                                    %>
                                                    <c:forEach items="${lessonList}" var="lesson">
                                                        <c:if test="${lesson.getSectionId() == section.getSectionId()}">
                                                            <%
                                                                count++;
                                                            %>
                                                        </c:if>
                                                    </c:forEach>

                                                    <div class="course-section-right"><%=count%> lesson</div>
                                                </div>
                                                <!-- Lesson content -->
                                                <div class="course-section-content" style="display: none">
                                                    <c:forEach items="${lessonList}" var="lesson">
                                                        <c:if test="${lesson.getSectionId() == section.getSectionId()}">
                                                            <div
                                                                class="course-content d-flex justify-content-between px-4 py-3"
                                                                >
                                                                <div
                                                                    class="course-content-left d-flex align-items-center"
                                                                    >
                                                                    <c:if test="${lesson.getType() == 'Video'}">
                                                                        <i class="fa-solid fa-play me-2"></i>
                                                                    </c:if>
                                                                    <c:if test="${lesson.getType() == 'Docs'}">
                                                                        <i class="fa-solid fa-file me-2"></i>
                                                                    </c:if>
                                                                    <p>${lesson.getLessonName()}</p>
                                                                </div>
                                                                <div class="course-content-right">11:02</div>
                                                            </div>
                                                        </c:if>

                                                    </c:forEach>
                                                </div>
                                                <!-- Lesson content -->


                                            </div>
                                            <!-- Course Chapter -->
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <!-- Course Agenda -->
                        </div>
                        <div class="course-details-right">
                            <div class="course-details-right-content">
                                <div class="course-details-thumbnail">
                                    <img src="${course.getCourseImage()}" alt="" />
                                </div>
                                <c:if test="${course.getCoursePrice() == 0}">
                                    <div class="course-details-price my-2">Free</div> 
                                </c:if>
                                    
                                <c:if test="${course.getCoursePrice() != 0}">
                                    <div class="course-details-price my-2">${course.getCoursePrice()}</div> 
                                </c:if>
                                  
                                <a class="enroll-button my-1" href="mentordashboard">Save</a>
                                <div class="course-details-description">
                                    <div class="description">
                                        <i class="fa-solid fa-signal"></i>
                                        ${course.getDifficulty()}
                                    </div>
                                    <div class="description">
                                        <i class="fa-solid fa-video"></i>
                                        This course have <span class="lessons">${lessonList.size()}</span> lessons
                                    </div>
                                    <div class="description">
                                        <i class="fa-solid fa-clock"></i>
                                        This course take                                        
                                        <span class="lessons">${totalTime}</span>
                                    </div>
                                    <div class="description">
                                        <i class="fa-solid fa-battery-full"></i>
                                        Learn any time, any where
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                                                   
                </div>
                <!-- End: Course Details -->
            </section>

            
            <!-- Begin: Footer -->
            <!-- End: Footer -->
        </div>
        <script>
            let course_chapter = document.querySelectorAll(
                    ".course-section-container"
                    );
            course_chapter.forEach(function (current) {
                current.onclick = function () {
                    let course_chapter = this.children[0];
                    let course_icon = course_chapter.children[0].children[0];
                    let course_lesson = this.children[1];
                    if (course_lesson.style.display === "none") {
                        course_lesson.style.display = "block";
                        course_icon.classList.remove("fa-plus");
                        course_icon.classList.add("fa-minus");
                    } else {
                        course_lesson.style.display = "none";
                        course_icon.classList.remove("fa-minus");
                        course_icon.classList.add("fa-plus");
                    }
                };
            });

            let expand_all = document.querySelector(".course-agenda-right p");
            let course_lesson = document.querySelectorAll(".course-section-content");
            let course_section_icon = document.querySelectorAll(".course-section i");
            expand_all.onclick = function () {
                if (expand_all.innerHTML == "Hide") {
                    course_lesson.forEach(function (current) {
                        current.style.display = "none";
                        course_section_icon.forEach(function (current) {
                            current.classList.remove("fa-minus");
                            current.classList.add("fa-plus");
                        });
                    });
                    expand_all.innerHTML = "Expand all";
                } else {
                    course_lesson.forEach(function (current) {
                        current.style.display = "block";
                        course_section_icon.forEach(function (current) {
                            current.classList.remove("fa-plus");
                            current.classList.add("fa-minus");
                        });
                    });
                    expand_all.innerHTML = "Hide";
                }
            };
        </script>

        <script
            src="https://kit.fontawesome.com/7562df3d9f.js"
            crossorigin="anonymous"
        ></script>
        <script src="assets/js/home_page.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/course_rating.js"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

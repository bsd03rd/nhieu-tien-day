<%-- 
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
            <section>
                <!-- Begin: Side Bar -->
                <div id="side-bar-container">
                    <div id="side-bar">
                        <div class="bar-button button-hover" onclick="activeHome()">
                            <i class="fa-solid fa-house"></i>
                            <p class="button-title">Home</p>
                        </div>
                        <div class="bar-button" onclick="activeCourse()">
                            <i class="fa-solid fa-road"></i>
                            <p class="button-title">My Course</p>
                        </div>
                        
                    </div>
                </div>
                <!-- End: Side Bar -->

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
                                <h3 class="course-agenda-title">Nội  khóa học</h3>
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
                                                                    <c:if test="${lesson.getType() == 'Quiz'}">
                                                                        <i class="fa-solid fa-clipboard-question me-2"></i>
                                                                    </c:if>
                                                                    <p>${lesson.getLessonName()}</p>
                                                                </div>
                                                                <div class="course-content-right">
                                                                    <fmt:parseNumber var="time" type="number" integerOnly="true" value="${lesson.getTime()}"/>
                                                                    <fmt:parseNumber var="minute" type="number" value="${(time/1000)/60%60}" pattern="#" integerOnly="true"/>
                                                                    <fmt:parseNumber var="second" type="number" integerOnly="true" value="${(time/1000)%60}"/>
                                                                    ${minute}:${second}
                                                                </div>
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

                                <form action="enroll" method="GET">
                                    <c:if test="${UserCourse == null }">
                                        <input name="id" type="hidden" value="<%= request.getParameter("id") %>"/>
                                        <input name="op"  type="submit" class="enroll-button my-1" value="Enroll">
                                    </c:if>
                                    <c:if test="${UserCourse != null }">
                                        <!--<a href="WatchCourse?courseID=${course.getCourseID()}" class="enroll-button my-1">Go To Course</a>-->
                                    </c:if>
                                </form>

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

            <!-- Modal Feedback-->
            <div
                class="modal fade"
                id="Feedback"
                tabindex="-1"
                aria-labelledby="Feedback"
                aria-hidden="true"
                >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title fw-bold" id="exampleModalLabel">Feedback</h5>
                            <button
                                type="button"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"
                                ></button>
                        </div>
                        <form action="CourseDetails" method="POST">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-12">
                                        <h5 class="mb-3">Rating</h5>
                                        <!-- <select name="" id="" class="form-select" aria-label="Default select example"> 
                                        <option selected>Open this select menu</option>
                                        <option value="">1 star</option>
                                        <option value="">2 star</option>
                                        <option value="">3 star</option>
                                        <option value="">4 star</option>
                                        <option value="">5 star</option>
                                      </select> -->
                                        <div class="star-rating mb-3">
                                            <i class="fa-solid fa-star fs-3 star-rating-element"></i>
                                            <i class="fa-solid fa-star fs-3 star-rating-element"></i>
                                            <i class="fa-solid fa-star fs-3 star-rating-element"></i>
                                            <i class="fa-solid fa-star fs-3 star-rating-element"></i>
                                            <i class="fa-solid fa-star fs-3 star-rating-element"></i>
                                        </div>
                                        <input type="text" name="star" value="0" id="rate-star" class="d-none">
                                        <h5 class="mb-3">Feedback</h5>
                                        <textarea name="feedback" id="" style="width: 100%; height: 200px; outline: none;"></textarea>
                                        <input type="hidden" name="courseid" value="${course.getCourseID()}"/>

                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button
                                    type="button"
                                    class="btn btn-secondary"
                                    data-bs-dismiss="modal"
                                    >
                                    Close
                                </button>
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
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

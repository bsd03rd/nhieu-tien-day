<%-- 
    Document   : AdminManageAccount
    Created on : Oct 13, 2022, 7:06:45 PM
    Author     : HieuShin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/header.css">
        <title>Admin Manage Account</title>
    </head>

    <body style="font-family: 'Montserrat', sans-serif;">
        <style>
            .overview {
                background-color: #fff;
                border-radius: 10px;
                border: solid;
                border-color: var(--bs-orange);
            }
        </style>
        <%@include file="header.jsp" %>
        <div class="container-fluid w-100" style="margin-top: 66px;">
            <div class="row py-3 px-4">
                <div class="col-lg-12">
                    <h4 class="fw-bold">Quiz Dashboard</h4>
                </div>
                <div class="col-6">
                    <h5 class="fw-bold">Course Details</h5>
                    <div class="row flex-column gy-2">
                        <div class="col-12">
                            <div class="card shadow-sm overflow-hidden">
                                <div class="row my-course g-0">
                                    <div class="col-3">
                                        <img src="${course.getCourseImage()}"
                                             alt="" style="width: 100%; height: 200px; object-fit: cover;">
                                    </div>
                                    <div class="col-9 px-3 m-auto">
                                        <div class="fw-bold mb-1">
                                            <a href="CourseDetails?id=${course.getCourseID()}">${course.getCourseName()}</a>
                                        </div>
                                        <div class="mb-2" style="font-size: 14px;">Number of Quizzes: ${quizdetaillist.size()}</div>
                                        <div class="mb-2" style="font-size: 14px;">Category: ${course.getCategory()}</div>
                                        <div class="mb-2" style="font-size: 14px;">Difficulty: ${course.getDifficulty()}</div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End admin tool -->
                    </div>
                </div>
                <div class="col-6">
                    <h5 class="fw-bold">Overview</h5>
                    <div class="row gy-3">
                        <div class="col-6">
                            <div class="overview p-4">
                                <div class="overview-header mb-2">
                                    <h6>Lowest Mark</h6>
                                </div>
                                <div class="overview-content d-flex justify-content-between">
                                    <p>${hardest.getLesson().getLessonName()}: ${hardest.getMark()}</p>
                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="overview p-4">
                                <div class="overview-header mb-2">
                                    <h6>Highest Mark</h6>
                                </div>
                                <div class="overview-content d-flex justify-content-between">
                                    <p>${easiest.getLesson().getLessonName()}: ${easiest.getMark()}</p>
                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="overview p-4">
                                <div class="overview-header mb-2">
                                    <h6>Most Attempt Quiz</h6>
                                </div>
                                <div class="overview-content d-flex justify-content-between">
                                    <p>${attempt.getLesson().getLessonName()}: ${attempt.getAttempt()}</p>
                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="overview p-4">
                                <div class="overview-header mb-2">
                                    <h6>Most Enroll Quiz</h6>
                                </div>
                                <div class="overview-content d-flex justify-content-between">
                                    <p>${enroll.getLesson().getLessonName()}: ${enroll.getEnrolled()}</p>
                                    <i class="fa-solid fa-laptop overview-content-img"></i>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col-lg-12">
                    <div class="card card-body shadow-sm" style="border-radius: 12px;">
                        <div class="row">

                            <div class="col-6">
                                <div class="d-flex justify-content-end" style="position: relative;">
                                    <i class="fa-solid fa-magnifying-glass" style="position: absolute; left: 12px; top: 50%; transform: translateY(-50%);"></i>
                                    <input class="w-100 form-control" type="text" style="border-radius: 30px; padding-left: 32px;">
                                </div>
                            </div>
                            <div class="col-12">
                                <table class="table table-borderless">
                                    <thead>
                                    <th>QuizID</th>
                                    <th>LessonName</th>
                                    <th>Accuracy</th>
                                    <th>Avarage Mark</th>
                                    <th>Enrolled</th>
                                    <th>Attempt</th>
                                    <th>Overview</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${quizdetaillist}" var="quiz">
                                            <tr>
                                                <td style="max-width: 180px">
                                                    <div class="d-flex align-items-center">                                                        
                                                        <div class="ms-2">
                                                            <div class="fw-bold">${quiz.getQuizid()}</div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <div style="background-color: #4dd4ac; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">${quiz.getLesson().getLessonName()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="font-weight: 600">${quiz.getAcc()}</div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <div
                                                            style="font-weight: 500;">${quiz.getMark()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <div
                                                            style="font-weight: 500;">${quiz.getEnrolled()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <div
                                                            style="background-color: #ccc; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">${quiz.getAttempt()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test = "${quiz.getAcc() <= 40}">
                                                            <div style="background-color: #ff001e; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">Hard</div>
                                                        </c:when>
                                                        <c:when test = "${quiz.getAcc() <= 60}">
                                                            <div style="background-color: #fff200; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">Medium</div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div style="background-color: #00ff2a; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">Easy</div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>

</html>

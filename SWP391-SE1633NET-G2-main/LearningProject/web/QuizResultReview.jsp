<%-- 
    Document   : QuizResultReview
    Created on : Oct 28, 2022, 5:13:54 PM
    Author     : vuman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Elearning</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
        <link rel="stylesheet" href="assets/css/header.css" />
        <link rel="stylesheet" href="assets/css/course_watch.css">
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap");
        </style>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    </head>

    <body>
        <%@include file="header.jsp"%>

        <div id="main">
            

            <section>
                <div class="course-watch-left" style="overflow-y: auto;" id="style-1">
                    <div class="course-watch-left-content">
                        <div class="lesson-content" id="result">
                            <div class="bg-primary py-5 px-4 fw-bold text-white fs-3">
                                Review attempt on Monday, 1 August 2022, 3:01 PM
                                <span class="btn-danger btn float-end"><a href="quizresult?quizid=${quizid}">Return to Quiz History</a></span>
                            </div>

                            <div class="">
                                <c:forEach items="${queslist}" var="question" varStatus="index">
                                    <div class="px-5 py-2">
                                        <div class="fw-bold mb-2" style="font-size: 20px;">
                                            Question ${index.count}
                                        </div>

                                        <div>
                                            ${question.getQuestionContent()}
                                        </div>

                                        <div class="mt-3">
                                            <c:forEach items="${answerlist}" var="answer">
                                                <c:set var="val" value="${0}"></c:set>
                                                <c:if test="${answer.getQuestionId() == question.getQuestionId()}">
                                                    <c:forEach items="${useranswerlist}" var="useranswer">
                                                        <c:if test="${useranswer == answer.getAnswerId()}">
                                                            <c:forEach items="${correctanswerlist}" var="correctanswer">
                                                                <c:if test="${useranswer == correctanswer.getAnswerId()}">
                                                                    <c:set var="val" value="${1}"></c:set>                                                                    
                                                                </c:if>

                                                                <c:if test="${val != 1}">
                                                                    <c:if test="${useranswer != correctanswer.getAnswerId()}">
                                                                        <c:set var="val" value="${2}"></c:set>                                                                    
                                                                    </c:if>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:if>

                                                        <c:if test="${val != 1 && val != 2}">
                                                            <c:if test="${useranswer != answer.getAnswerId()}">
                                                                <c:set var="val" value="${3}"></c:set>                                                            
                                                            </c:if>
                                                        </c:if>
                                                    </c:forEach>

                                                    <c:if test="${val == 1}">
                                                        <div class="mb-2"><input type="checkbox" class="form-check-input" disabled> ${answer.getAnswerContent()} <span><i class="fa-solid fa-check text-success"></i></span> </div>        
                                                            </c:if>

                                                    <c:if test="${val == 2}">
                                                        <div class="mb-2"><input type="checkbox" class="form-check-input" disabled> ${answer.getAnswerContent()}<span><i class="fa-solid fa-xmark text-danger"></i></span> </div>
                                                            </c:if>

                                                    <c:if test="${val == 3}">
                                                        <div class="mb-2"><input type="checkbox" class="form-check-input" disabled> ${answer.getAnswerContent()}</div>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                        </div>

                                        <div class="bg-success text-white py-3 px-3">
                                            <div>Correct Answer:
                                                <c:forEach items="${correctanswerlist}" var="correccontent">
                                                    <c:if test="${correccontent.getQuestionId() == question.getQuestionId() }">
                                                        ${correccontent.getAnswerContent() }<br>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <a href="quizresult?quizid=${quizid}" class="btn btn-success">Return</a>
                            </div>
                        </div>


                    </div>
                </div>
                <div class="course-watch-right">
                    <div class="course-watch-right-content">
                        <h4 class="course-content-title px-4 py-3">Course Content</h4>
                        <div class="course-lesson-list">
                            <c:forEach items="${listSection}" var="section">

                                <!-- Course section -->
                                <div class="course-lesson-container">
                                    <div class="course-lesson d-flex justify-content-between px-4 align-items-center">
                                        <div class="course-lesson-left">
                                            <div class="course-lesson-left-title">
                                                ${section.getSectionName()}
                                            </div>
                                            <div class="course-lesson-left-description">
                                                <c:set var="totalLesson" value="${0}"></c:set>
                                                <c:set var="userTotalLesson" value="${0}"></c:set>
                                                    <!-- Begin: Lesson Progress -->   
                                                <c:forEach items="${listLesson}" var="lesson">
                                                    <c:if test="${lesson.getSectionId() == section.getSectionId()}">                                                        
                                                        <c:set var="totalLesson" value="${totalLesson+1}"></c:set>
                                                        <c:if test="${lesson.getStatus() eq 'Done'}">
                                                            <c:set var="userTotalLesson" value="${userTotalLesson+1}"></c:set>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                                <div class="course-lesson-progress d-inline">${userTotalLesson}/${totalLesson}</div>
                                                <div class="d-inline">|</div>
                                                <!-- End: Lesson Progress -->

                                                <!-- Begin: Section Time -->
                                                <%
                                                    int sectionTime = 0;
                                                %>
                                                <c:forEach items="${listLesson}" var="lesson">
                                                    <c:if test="${lesson.getSectionId() == section.getSectionId()}">

                                                        <c:set var="lessonTime" value="${lesson.getTime()}"></c:set>
                                                        <%
                                                            int lessonTime = Integer.parseInt(pageContext.getAttribute("lessonTime").toString());
                                                            sectionTime +=  lessonTime;
                                                        %>
                                                    </c:if>
                                                </c:forEach>
                                                <%
                                                    int minute = sectionTime / 60 % 60;
                                                    int second = sectionTime % 60;
                                                %>
                                                <div class="course-lesson-time d-inline"><%=minute%>:<%=second%></div>
                                                <!-- End: Section Time -->
                                            </div>
                                        </div>
                                        <div class="course-lesson-right">
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </div>
                                    </div>
                                    <!-- Course lesson child container -->
                                    <div class="course-lesson-child-container" style="display: none;">        
                                        <c:forEach items="${listLesson}" var="lesson">
                                            <c:if test="${lesson.getSectionId() == section.getSectionId()}">




                                                <!-- course lesson child -->
                                                <c:if test="${lesson.getType() == 'Quiz'}">
                                                    <a href="WatchCourse?courseID=${course.getCourseID()}&sectionID=${section.getSectionId()}&lessonID=${lesson.getLessonId()}&questionID=0&count=0">
                                                        <div class="course-lesson-child  px-4 py-2">
                                                            <div class="course-lesson-child-content d-flex justify-content-between align-items-center">
                                                                <div class="course-lesson-child-content-title">${lesson.getLessonName()}</div>

                                                                <c:choose>
                                                                    <c:when test="${lesson.getStatus() eq 'Done'}">
                                                                        <i class="fa-solid fa-circle-check"></i>
                                                                    </c:when>                                                                
                                                                    <c:otherwise>
                                                                        <i class="fa-regular fa-circle"></i>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>

                                                            <div class="course-lesson-child-footer">
                                                                <i class="fa-solid fa-clipboard-question"></i>
                                                                <fmt:parseNumber var="time" type="number" integerOnly="true" value="${lesson.getTime()}"/>
                                                                <fmt:parseNumber var="minute" type="number" value="${time/60%60}" pattern="#" integerOnly="true"/>
                                                                <fmt:parseNumber var="second" type="number" integerOnly="true" value="${time%60}"/>
                                                                ${minute}:${second}

                                                            </div>
                                                        </div>
                                                    </a>
                                                </c:if>

                                                <c:if test="${lesson.getType() != 'Quiz'}">
                                                    <a href="WatchCourse?courseID=${course.getCourseID()}&sectionID=${section.getSectionId()}&lessonID=${lesson.getLessonId()}">
                                                        <div class="course-lesson-child  px-4 py-2">
                                                            <div class="course-lesson-child-content d-flex justify-content-between align-items-center">
                                                                <div class="course-lesson-child-content-title">${lesson.getLessonName()}</div>

                                                                <c:choose>
                                                                    <c:when test="${lesson.getStatus() eq 'Done'}">
                                                                        <i class="fa-solid fa-circle-check"></i>
                                                                    </c:when>                                                                
                                                                    <c:otherwise>
                                                                        <i class="fa-regular fa-circle"></i>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>

                                                            <div class="course-lesson-child-footer">
                                                                <i class="fa-solid fa-circle-play"></i>
                                                                <fmt:parseNumber var="time" type="number" integerOnly="true" value="${lesson.getTime()}"/>
                                                                <fmt:parseNumber var="minute" type="number" value="${time/60%60}" pattern="#" integerOnly="true"/>
                                                                <fmt:parseNumber var="second" type="number" integerOnly="true" value="${time%60}"/>
                                                                ${minute}:${second}

                                                            </div>    
                                                        </div>        

                                                    </a>
                                                </c:if>

                                                <!-- course lesson child -->







                                            </c:if>
                                        </c:forEach>
                                        <!-- Course lesson child container -->
                                    </div>
                                </div>    
                                <!-- Course section -->
                            </c:forEach>

                        </div>
                    </div>    
                </div>

            </section>

            <!-- Begin: Footer -->
            <!-- End: Footer -->
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/course_watch.js"></script>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="https://player.vimeo.com/api/player.js"></script>
        <script>
                                    function loadAll() {
                                        $.ajax({
                                            url: "/LearningProject/quizresult",
                                            type: 'GET',
                                            data: 'quizid=${quizid}',
                                            success: function (data) {
                                                var row = document.getElementById("result");
                                                row.innerHTML = data;
                                            },
                                            error: function () {
                                                console.log('Error');
                                            }
                                        });
                                    }
        </script>
    </body>


</html>

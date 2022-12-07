<%-- 
    Document   : QuizQuestion.jsp
    Created on : Oct 13, 2022, 3:01:54 PM
    Author     : Dung
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
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap");
        </style>
    </head>

    <body style="font-family: 'Montserrat', sans-serif;" onload="updateRowCount()">
        <div class="py-5" style="padding-left: 30px; padding-right: 30px;">
            <div class="row">
                <div class="col-8 d-flex justify-content-between align-items-center">
                    <div>
                        <h4 class="fw-bolder mb-2">Quiz Question</h4>
                        <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
                            <ol class="breadcrumb" style="font-size: 13px">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item"><a href="CreateSection?courseID=${courseID}">Create Course</a>
                                </li>
                                <li class="breadcrumb-item" aria-current="page">
                                    <a href="CreateSection?courseID=${courseID}">Create Lesson</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    Quiz Question
                                </li>
                            </ol>
                        </nav>
                        <p class="mb-2" style="color: rgba(0, 0, 0, 0.5); font-size: 15px;">Create
                            your quiz
                            below</p>
                    </div>
                    <div>
<!--                        <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                data-bs-target=".multi-collapse" aria-expanded="false">Show/Hide</button>-->
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-9">
                    <table class="table table-bordered">
                        <thead>
                        <th>Number</th>
                        <th>Question</th>
                        <th>Action</th>
                        </thead>
                        <tbody id="questionTable">
                            <c:forEach items="${questionList}" var="question">
                                
                                <!--Begin Question -->
                                <tr>
                                    <td class="index"></td>
                                    <td style="width: 80%;">
                                        <div class="card mb-2" style="border-radius: 8px;">
                                            <div class="card-body" >
                                                <input name="questionID" type="hidden" value="${question.getQuestionId()}">
                                                <textarea name="questionContent" class="fw-bold form-control" style="overflow-y: hidden;" oninput='this.style.height = "";this.style.height = this.scrollHeight + "px"'>${question.getQuestionContent()}</textarea>
                                                <c:forEach items="${answerList}" var="answer">
                                                    <c:if test="${answer.getQuestionId() == question.getQuestionId()}">
                                                        <div class="mt-3">
                                                            <div class="d-flex align-items-center">
                                                                <input name="answerID" type="hidden" value="${answer.getAnswerId()}">

                                                                <div class="form-check">
                                                                    <c:if test="${answer.isIsCorrect() == true}">
                                                                        <input class="form-check-input" type="checkbox" checked>
                                                                    </c:if>
                                                                    <c:if test="${answer.isIsCorrect() == false}">
                                                                        <input class="form-check-input" type="checkbox">
                                                                    </c:if>
                                                                    
                                                                </div>

                                                                <input type="text" class="card card-body mb-2" name="answer" value="${answer.getAnswerContent()}">

                                                                <button type="button" class="btn-close ms-3" aria-label="Close" onclick="$(this).parent().parent().remove()"></button>
                                                            </div>

                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                                <div class="btn btn-primary mt-2" onclick="addAnswerPrev(this)">Add answer</div>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="btn btn-outline-danger mb-2" onclick="deleteQuestion(this)">Delete</div>
                                    </td>
                                </tr>
                                <!-- End Question -->
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-3">
                    <div style="position: sticky; top: 0">
                        <div class="card w-100 shadow-sm" style="border-radius: 16px;">
                            <div class="card-body px-0">
                                <div class="p-3">
                                    <label for="lessonTime" class="form-label" style="font-weight: 600; font-size: 15px;">Quiz Title</label>
                                    <input type="text" class="form-control" id="lessonTime" value="${lesson.getLessonName()}" disabled>
                                </div>
                                <div class="p-3">
                                    <label for="lessonTime" class="form-label" style="font-weight: 600; font-size: 15px;">Lesson Time</label>
                                    <input type="text" class="form-control" id="lessonTime" value="${lesson.getTime()}" disabled>
                                </div>

                            </div>
                        </div>
                        <div class="btn btn-danger mt-3" onclick="addQuestion()">Add Question
                        </div>
                        <div class="btn btn-success mt-3" onclick="submit()">Save Changes
                        </div>
                    </div>
                </div>
            </div>
            <form id="submitForm" action="QuizQuestion?lessonID=${lessonID}&quizID=${quizID}" method="post">
                <input type="hidden" id="valueSubmit" name="jsonQuestions">
            </form>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
            <script src="assets/js/create_lesson_quiz.js"></script>
            <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    </body>

</html>
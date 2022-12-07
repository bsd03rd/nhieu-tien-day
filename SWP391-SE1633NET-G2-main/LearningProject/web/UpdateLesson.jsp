<%-- 
    Document   : CreateLesson
    Created on : Sep 30, 2022, 2:45:45 AM
    Author     : HieuShin
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
        <link rel="stylesheet" href="assets/css/create_course.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
        <link rel="stylesheet" href="assets/css/header.css" />
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap");
        </style>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <script>
            tinymce.init({
                selector: '.text-input'
            });


        </script>
    </head>

    <body>
        <div id="main">
            <header>
                <div class="header-content">
                    <div class="logo">
                        <img src="assets/img/Logo-FPT.webp" alt="" />
                        <div class="header-title">Học Lập Trình FPT</div>
                    </div>
                    <div class="header-search d-none">
                        <div class="icon-search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </div>
                        <input type="text" placeholder="Tìm kiếm khóa học, bài viết, video..." />
                    </div>
                    <div class="header-profile">
                        <div class="header-mycourse">Khóa học của tôi</div>
                        <div class="header-notification" onclick="event.stopPropagation()">
                            <i class="fa-solid fa-bell"></i>
                            <div class="notification-cotainer" onclick="event.stopPropagation()">
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
                        <div class="avatar" onclick="event.stopPropagation()">
                            <img src="assets/img/user.png" alt="" />
                            <div class="account-menu">
                                <div class="menu-content">
                                    <div class="menu-element">
                                        <i class="fa-solid fa-user"></i>
                                        <a href="" class="menu-title">Trang cá nhân</a>
                                    </div>
                                    <div class="menu-element">
                                        <i class="fa-solid fa-list"></i>
                                        <a href="" class="menu-title">Khóa học của tôi</a>
                                    </div>
                                    <div class="menu-element">
                                        <i class="fa-solid fa-gear"></i>
                                        <a href="" class="menu-title">Cài đặt</a>
                                    </div>
                                    <div class="line"></div>
                                    <div class="menu-element">
                                        Account Balance:
                                        <a href="" class="menu-title">200.000đ</a>
                                    </div>
                                    <div class="menu-element menu-logout">
                                        <i class="fa-solid fa-right-from-bracket"></i>
                                        <a href="" class="menu-title">Đăng xuất</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>

            <!-- Begin: Create Course -->
            <section>
                <div class="create-course px-5 py-3">
                    <div class="create-course-header mb-3">
                        <h3 class="fw-bold">Update Lesson</h3>
                        <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
                            <ol class="breadcrumb" style="font-size: 13px">
                                <li class="breadcrumb-item"><a href="updatecourse?button=.&courseid=${courseid}"">Home</a></li>
                                <li class="breadcrumb-item"><a href="updatesection?courseid=${courseid}">Update Section</a></li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    Update Lesson
                                </li>
                            </ol>
                        </nav>
                        <h4 class="mb-3 fw-bold mb-1">Create lesson for ${section.getSectionName()}</h4>
                    </div>
                    <table class="table table-striped">
                        <thead>
                        <th>Lesson No</th>
                        <th>Lesson Name</th>
                        <th>Action</th>
                        </thead>
                        <tbody>
                            <%!int i = 1;%>
                            <c:forEach items="${lessonlist}" var="lesson">
                            <form action="updatelesson" method="POST">
                                <tr>
                                    <td><%=i%></td>
                                    <td>${lesson.getLessonName()}</td>
                                    <td>
                                        <input type="hidden" name="lessonid" value="${lesson.getLessonId()}">
                                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                                        <input type="hidden" name="courseid" value="${courseid}">
                                        <input type="submit" class="btn btn-primary" name="button" value="Delete">

                                        <c:forEach items="${videolist}" var="video">
                                            <c:if test="${video.getLessonId() == lesson.getLessonId()}">
                                                <input type="button" class="btn btn-primary" value="Edit" data-bs-toggle="modal" data-bs-target="#${lesson.getType()}" data-lesson-name="${lesson.getLessonName()}" data-lesson-type="${lesson.getType()}" data-video-url="${video.getVideoLink()}" data-lesson-id="${lesson.getLessonId()}" onclick="Forward(this)">
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${docslist}" var="docs">
                                            <c:if test="${docs.getLessonId() == lesson.getLessonId()}">
                                                <input type="button" class="btn btn-primary" value="Edit" data-bs-toggle="modal" data-bs-target="#${lesson.getType()}" data-lesson-name="${lesson.getLessonName()}" data-lesson-type="${lesson.getType()}" data-lesson-time="${lesson.getTime()}" data-lesson-id="${lesson.getLessonId()}" onclick="Forward(this)">
                                                <textarea id="docs-content-${lesson.getLessonId()}" class="d-none">${docs.getContent()}</textarea>
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${quizlist}" var="quiz">
                                            <c:if test="${quiz.getLessonId() == lesson.getLessonId()}">
                                                <input type="button" class="btn btn-primary" value="Edit" data-bs-toggle="modal" data-bs-target="#${lesson.getType()}" data-lesson-name="${lesson.getLessonName()}" data-lesson-type="${lesson.getType()}" data-lesson-time="${lesson.getTime()}" data-lesson-id="${lesson.getLessonId()}" onclick="Forward(this)">
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${lesson.getType() == 'Quiz'}">
                                            <a class="btn btn-primary"href="updatelesson?lessonID=${lesson.getLessonId()}&button=quiz&courseid=${courseid}&sectionid=${section.getSectionId()}">Question</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                    <form action="updatelesson" method="POST">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Add New Lesson
                        </button>
                        <input type="submit" name="button" value="Save changes" class="btn btn-secondary">
                    </form>


                    <!-- Modal Main-->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-fullscreen">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title fw-bold" id="exampleModalLabel">Add Lesson</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <h3 class="text-center">Select type of lesson you want to add</h3>
                                    <div  class="type-lesson-list mt-5">
                                        <div style="margin: 0 auto;" class="type-lesson shadow" data-bs-toggle="modal" data-bs-target="#document"> 
                                            <img src="assets/img/Asset 1.png" alt="">
                                            <div class="type-lesson-title">Document</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>



                    <!-- Modal Document-->
                    <form action="updatelesson" method="POST">
                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <div class="modal fade" id="document" tabindex="-1" aria-labelledby="document" aria-hidden="true">
                            <div class="modal-dialog modal-fullscreen">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title fw-bold" id="exampleModalLabel">Add
                                            Document</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body py-5" style="padding-left: 240px; padding-right: 240px;">
                                        <h4 class="fw-bolder">Create Document</h4>
                                        <div class="row">
                                            <div class="col-12 mb-3">
                                                <label for="LessonTitle" class="form-label fw-bold">Lesson Title</label>
                                                <input type="text" class="form-control" name="lessondocsname">
                                            </div>
                                            <div hidden="" class="col-12 mb-3">
                                                <label for="LessonTitle" class="form-label fw-bold">Time to read (milliseconds)</label>
                                                <input type="number" class="form-control" value="0" name="time">
                                            </div>
                                            <div hidden="" class="col-12 mb-3">
                                                <label for="LessonTitle" class="form-label fw-bold">Lesson Content</label>
                                                <textarea name="lessondocscontent" id="lessondocscontent" cols="30" rows="10" class="form-control text-input"> </textarea>
                                            </div>
                                            <input type="text" value="Docs" class="d-none" name="type">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <input type="submit" name="button" class="btn btn-primary" value="Add document">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <!-- Modal Document-->




                    <!-- Modal Video-->
                    <form action="updatelesson" method="POST" data-type="video">
                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <div class="modal fade" id="video" tabindex="-1" aria-labelledby="video" aria-hidden="true">
                            <div class="modal-dialog modal-fullscreen">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title fw-bold" id="exampleModalLabel">Add
                                            Video</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body py-5" style="padding-left: 240px; padding-right: 240px;">
                                        <h4 class="fw-bolder">Create Video</h4>
                                        <div class="row">
                                            <div class="col-8">
                                                <div class="video-preview">
                                                    <iframe width="100%" height="420" src="https://www.youtube.com/embed/wHviCc5NZFQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" id="url-preview" style="display: none;"></iframe>   
                                                    <input name="video_url" type="hidden" value="" id="video-URL">
                                                    <i class="fa-brands fa-youtube icon-youtube"></i>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="col-12 mb-3">
                                                    <label for="Lesson title">Lesson title</label>
                                                    <input type="text" class="form-control" name="lessonvideoname">
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label for="Lesson title">Video URL</label>
                                                    <input name="videolink" type="text" class="form-control" id="video-url" oninput="video_preview_add()">
                                                </div>
                                                <input type="text" class="d-none" name="duration">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="button" value="Add video">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <input type="button" class="btn btn-primary" value="Add video" onclick="doSubmit()">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <!-- Modal Video-->




                    <!-- Modal Quiz-->
                    <form action="updatelesson" method="POST">
                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <div class="modal fade" id="quiz" tabindex="-1" aria-labelledby="quiz" aria-hidden="true">
                            <div class="modal-dialog modal-fullscreen">
                                <div class="modal-content bg-light">
                                    <div class="modal-header">
                                        <h5 class="modal-title fw-bold" id="exampleModalLabel">Add
                                            Quiz</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body py-5" style="padding-left: 120px; padding-right: 120px;">
                                        <div class="row">
                                            <div class="col-8 d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h4 class="fw-bolder mb-2">Create Quiz</h4>
                                                    <p class="mb-2" style="color: rgba(0, 0, 0, 0.5); font-size: 15px;">Create
                                                        your quiz
                                                        below</p>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-8">
                                                <img src="assets/img/undraw_questions_re_1fy7.svg" alt="alt" class="img-fluid"/>
                                            </div>
                                            <div class="col-4">
                                                <div class="card w-100 shadow-sm" style="border-radius: 16px;">
                                                    <div class="card-body px-0">
                                                        <div class="p-3">
                                                            <label for="lessonTitle" class="form-label"
                                                                   style="font-weight: 600; font-size: 15px;">Quiz Title</label>
                                                            <input type="text" class="form-control" id="lessonTitle" name="lessonTitle">
                                                            <input type="hidden" value="Quiz" name="type">
                                                        </div>
                                                        <div class="p-3">
                                                            <label for="lessonTime" class="form-label"
                                                                   style="font-weight: 600; font-size: 15px;">Lesson Time</label>
                                                            <input type="text" class="form-control" id="lessonTime" name="lessonTime">
                                                        </div>

                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <input type="submit" name="button" value="Add quiz" class="btn btn-primary">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- Modal Quiz-->




                    <!-- Modal Document-->
                    <form action="updatelesson" method="POST">
                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <input type="hidden" name="LessonDocsId" value="${courseid}" id="LessonDocsId">
                        <div class="modal fade" id="Docs" tabindex="-1" aria-labelledby="document" aria-hidden="true">
                            <div class="modal-dialog modal-fullscreen">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title fw-bold" id="exampleModalLabel">Update
                                            Document</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body py-5" style="padding-left: 240px; padding-right: 240px;">
                                        <h4 class="fw-bolder">Update Document</h4>
                                        <div class="row">
                                            <div class="col-12 mb-3">
                                                <label for="LessonTitle" class="form-label fw-bold">Lesson Title</label>
                                                <input type="text" class="form-control" name="LessonDocsName" id="LessonDocsName">
                                            </div>
                                            <div hidden="" class="col-12 mb-3">
                                                <label for="LessonTitle" class="form-label fw-bold">Time to read (milliseconds)</label>
                                                <input type="number" class="form-control" value="0" name="Time" id="Time">
                                            </div>
                                            <div hidden="" class="col-12 mb-3">
                                                <label for="LessonTitle" class="form-label fw-bold">Lesson Content</label>
                                                <textarea name="DocsContent" id="DocsContent" cols="30" rows="10" class="form-control text-input"> </textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <input type="submit" name="button" class="btn btn-primary" value="Update document">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <!-- Modal Document-->

                    <!-- Modal Video-->
                    <form action="updatelesson" method="POST" data-type="Video">
                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <input type="hidden" name="LessonVideoId" value="${courseid}" id="LessonVideoId">
                        <div class="modal fade" id="Video" tabindex="-1" aria-labelledby="video" aria-hidden="true">
                            <div class="modal-dialog modal-fullscreen">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title fw-bold" id="exampleModalLabel">Update
                                            Video</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body py-5" style="padding-left: 240px; padding-right: 240px;">
                                        <h4 class="fw-bolder">Edit Video</h4>
                                        <div class="row">
                                            <div class="col-8">
                                                <div class="video-preview">
                                                    <iframe width="100%" height="420" src="https://www.youtube.com/embed/wHviCc5NZFQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" id="Url-preview" style="display: none;"></iframe> 
                                                    <input name="videolink" type="hidden" value="" id="videolink">
                                                    <i class="fa-brands fa-youtube icon-youtube"></i>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="col-12 mb-3">
                                                    <label for="Lesson title">Lesson title</label>
                                                    <input type="text" class="form-control" name="LessonVideoName" id="LessonVideoName">
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label for="Lesson title">Video URL</label>
                                                    <input name="VideoLink" type="text" class="form-control" id="VideoLink" oninput="video_preview_update()">
                                                </div>
                                                <input type="text" class="d-none" name="time_duration">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="button" value="Update video">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <input type="button" class="btn btn-primary" value="Update video" onclick="doSubmit2()">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <!-- Modal Video-->

                    <!-- Modal Quiz-->
                    <form action="updatelesson" method="POST">
                        <input type="hidden" name="sectionid" value="${section.getSectionId()}">
                        <input type="hidden" name="courseid" value="${courseid}">
                        <input type="hidden" name="LessonQuizId" value="${courseID}" id="LessonQuizId">
                        <div class="modal fade" id="Quiz" tabindex="-1" aria-labelledby="quiz" aria-hidden="true">
                            <div class="modal-dialog modal-fullscreen">
                                <div class="modal-content bg-light">
                                    <div class="modal-header">
                                        <h5 class="modal-title fw-bold" id="exampleModalLabel">Edit
                                            Quiz</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body py-5" style="padding-left: 120px; padding-right: 120px;">
                                        <div class="row">
                                            <div class="col-8 d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h4 class="fw-bolder mb-2">Update Quiz</h4>
                                                    <p class="mb-2" style="color: rgba(0, 0, 0, 0.5); font-size: 15px;">Update
                                                        your quiz
                                                        below</p>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-8">
                                                <img src="assets/img/undraw_questions_re_1fy7.svg" alt="alt" class="img-fluid"/>
                                            </div>
                                            <div class="col-4">
                                                <div class="card w-100 shadow-sm" style="border-radius: 16px;">
                                                    <div class="card-body px-0">
                                                        <div class="p-3">
                                                            <label for="lessonTitle" class="form-label"
                                                                   style="font-weight: 600; font-size: 15px;">Quiz Title</label>
                                                            <input type="text" class="form-control" id="LessonQuizTitle" name="LessonQuizTitle">
                                                        </div>
                                                        <div class="p-3">
                                                            <label for="lessonTime" class="form-label"
                                                                   style="font-weight: 600; font-size: 15px;">Lesson Time</label>
                                                            <input type="text" class="form-control" id="LessonQuizTime" name="LessonQuizTime">
                                                        </div>

                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <input type="submit" name="button" value="Update quiz" class="btn btn-primary">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- Modal Quiz-->
                </div>













            </section>
            <!-- End: Create Course -->

            <!-- Begin: Footer -->
            <!-- End: Footer -->
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/create_video_lesson.js"></script>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>

        <script>
                                            function Forward(target) {
                                                if (target.getAttribute("data-lesson-type") == "Video") {
                                                    document.getElementById("LessonVideoName").value = target.getAttribute("data-lesson-name");
                                                    document.getElementById("VideoLink").value = target.getAttribute("data-video-url");
                                                    document.getElementById("LessonVideoId").value = target.getAttribute("data-lesson-id");
                                                } else if (target.getAttribute("data-lesson-type") == "Docs") {
                                                    tinyMCE.activeEditor.setContent('');
                                                    document.getElementById("LessonDocsName").value = target.getAttribute("data-lesson-name");
                                                    document.getElementById("Time").value = target.getAttribute("data-lesson-time");                                                                                   
                                                    document.getElementById("LessonDocsId").value = target.getAttribute("data-lesson-id");
                                                    tinymce.activeEditor.selection.setContent(document.getElementById("docs-content-" + document.getElementById("LessonDocsId").value).value);
                                                } else {
                                                    document.getElementById("LessonQuizTitle").value = target.getAttribute("data-lesson-name");
                                                    document.getElementById("LessonQuizTime").value = target.getAttribute("data-lesson-time");
                                                    document.getElementById("LessonQuizId").value = target.getAttribute("data-lesson-id");
                                                }
                                            }

                                            function video_preview_add() {
                                                // let src = current.value;
                                                console.log($('#video-url').val());
                                                let video_url = $('#video-url').val();
                                                let video_id = youtube_parser(video_url);
                                                $('#url-preview').attr('src', 'https://www.youtube.com/embed/' + video_id);
                                                $('#url-preview').css('display', 'block');
                                                console.log($('#url-preview').attr('src'));
                                                $('.icon-youtube').css('display', 'none');
                                                $('#video-URL').val($('#url-preview').attr('src'));
                                            }

                                            function video_preview_update() {
                                                // let src = current.value;
                                                console.log($('#VideoLink').val());
                                                let video_url = $('#VideoLink').val();
                                                let video_id = youtube_parser(video_url);
                                                $('#Url-preview').attr('src', 'https://www.youtube.com/embed/' + video_id);
                                                $('#Url-preview').css('display', 'block');
                                                console.log($('#Url-preview').attr('src'));
                                                $('.icon-youtube').css('display', 'none');
                                                $('#videolink').val($('#Url-preview').attr('src'));
                                            }

                                            function youtube_parser(url) {
                                                var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#&?]*).*/;
                                                var match = url.match(regExp);
                                                return (match && match[7].length == 11) ? match[7] : false;
                                            }

                                            function doSubmit() {
                                                // get video id from video-link

                                                const videoLink = document.querySelector('input[name="videolink"]').value;
                                                const videoId = videoLink.split('watch?v=')[1];

                                                const API_KEY = "AIzaSyBBcUOX-BytFmB96iWqMBIsRLzTgP0hhWQ"

                                                // use google api for get video detail
                                                fetch(`https://www.googleapis.com/youtube/v3/videos?id=${"${videoId}"}&part=contentDetails&key=${"${API_KEY}"}`)
                                                        .then(res => res.json())
                                                        .then(res => res.items[0].contentDetails.duration).then(duration => {
                                                    console.log(duration);
                                                    const parseDuration = (d) => {
                                                        const match = d.match(/PT(\d+H)?(\d+M)?(\d+S)?/);
                                                        const hours = (parseInt(match[1]) || 0);
                                                        const minutes = (parseInt(match[2]) || 0);
                                                        const seconds = (parseInt(match[3]) || 0);
                                                        return hours * 3600 + minutes * 60 + seconds;
                                                    };

                                                    // parse duration to seconds
                                                    const durationInSeconds = parseDuration(duration);

                                                    // set video-length value
                                                    document.querySelector('input[name="duration"]').value = durationInSeconds * 1000;
                                                    document.querySelector('form[data-type="video"]').submit();
                                                }).catch(error => alert('Invalid video link'));

                                            }

                                            function doSubmit2() {
                                                // get video id from video-link

                                                const videoLink = document.querySelector('input[name="VideoLink"]').value;
                                                const videoId = videoLink.split('watch?v=')[1];

                                                const API_KEY = "AIzaSyBBcUOX-BytFmB96iWqMBIsRLzTgP0hhWQ"

                                                // use google api for get video detail
                                                fetch(`https://www.googleapis.com/youtube/v3/videos?id=${"${videoId}"}&part=contentDetails&key=${"${API_KEY}"}`)
                                                        .then(res => res.json())
                                                        .then(res => res.items[0].contentDetails.duration).then(duration => {
                                                    console.log(duration);
                                                    const parseDuration = (d) => {
                                                        const match = d.match(/PT(\d+H)?(\d+M)?(\d+S)?/);
                                                        const hours = (parseInt(match[1]) || 0);
                                                        const minutes = (parseInt(match[2]) || 0);
                                                        const seconds = (parseInt(match[3]) || 0);
                                                        return hours * 3600 + minutes * 60 + seconds;
                                                    };

                                                    // parse duration to seconds
                                                    const durationInSeconds = parseDuration(duration);

                                                    // set video-length value
                                                    document.querySelector('input[name="time_duration"]').value = durationInSeconds * 1000;
                                                    document.querySelector('form[data-type="Video"]').submit();
                                                }).catch(error => alert('Invalid video link'));

                                            }

                                            
        </script>
    </body>

</html>
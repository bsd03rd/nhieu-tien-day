<%-- 
    Document   : CreatSection
    Created on : Oct 1, 2022, 5:03:30 PM
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
        <link rel="stylesheet" href="assets/css/header.css" />
        <link rel="stylesheet" href="assets/css/create_course.css" />
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap");
        </style>
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
                        <h3 class="fw-bold">Update Section</h3>
                        <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
                            <ol class="breadcrumb" style="font-size: 13px">
                                <li class="breadcrumb-item"><a href="updatecourse?button=.&courseid=${course.getCourseID()}">Home</a></li>
                                <li class="breadcrumb-item"><a href="updatecourse?courseid=${course.getCourseID()}">Update Course</a></li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    Update Section
                                </li>
                            </ol>
                        </nav>
                        <h4 class="mb-3 fw-bold mb-1">Update Section for ${course.getCourseName()}</h4>
                    </div>
                    <div class="create-course-content">
                        <div class="content-1" style="flex: 2;">
                            <div class="create-objectives">
                                <div class="create-section-title fw-bold mb-3">Section</div>
                                <table class="table table-striped" id="table">
                                    <thead>
                                    <th>Section No</th>
                                    <th>Section Name</th>
                                    <th>Lesson</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                        <%
                                            int count = 1;
                                        %>
                                        <c:forEach items="${sectionlist}" var="section">
                                            <tr>
                                                <td><%=count%></td>
                                        <form action="updatesection" method="POST">
                                            <input type="hidden" value="${course.getCourseID()}" name="courseid">
                                            <td><input type="text" name="sectionname" value="${section.getSectionName()}"></td>
                                            <td><a href="updatelesson?sectionid=${section.getSectionId()}&courseid=${course.getCourseID()}" class="btn btn-primary">Edit Lesson</a></td>
                                            <td>

                                                <input type="hidden" value="${section.getSectionId()}" name="sectionid">
                                                <input type="hidden" value="${course.getCourseID()}" name="courseid">
                                                <input type="submit" name="button" class="btn btn-primary" value="Delete">                                                        
                                                <input type="submit" name="button" class="btn btn-primary" value="Edit">

                                            </td>
                                        </form>
                                        </tr>

                                        <% 
                                            count++; 
                                        %>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <div class="add-section" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                    Add Section
                                </div>
                            </div>
                        </div>
                        <div class="content-2">
                            <div class="course-publish mb-3" style="margin-top: 80px;">
                                <form action="updatesection" method="POST">
                                    <input type="hidden" value="${course.getCourseID()}" name="courseid">
                                    <div class="publish-button d-flex justify-content-center p-4">
                                        <input type="submit" name="button" value="Save changes" class="btn btn-dark"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>



                <!-- Modal Add Section-->
                <form action="updatesection" method="post">
                    <input type="hidden" value="${course.getCourseID()}" name="courseid">
                    <div class="modal fade" id="staticBackdrop" data-bs-keyboard="true" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">
                                        Add Section
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <label for="Section name" class="form-label">Section Name</label>
                                    <!-- Section name must not null -->
                                    <input id="value" type="text" class="form-control" name="SectionName" required="true" />
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                        Close
                                    </button>
                                    <input type="submit" name="button" class="btn btn-primary" value="Add section">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </section>
            <!-- End: Create Course -->

            <!-- Begin: Footer -->
            <!-- End: Footer -->
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/create_section.js"></script>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>
    </body>

</html>

<%-- 
    Document   : CreateCourse
    Created on : Oct 1, 2022, 10:34:28 AM
    Author     : Dung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
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
            <!-- Begin: Create Course -->
            <section>
                <form action="updatecourse" method="POST">
                    <input type="hidden" name="courseid" value="${course.getCourseID()}">
                    <div class="create-course px-5 py-3">
                        <div class="create-course-header mb-3">
                            <h3 class="fw-bold">Create Course</h3>
                            <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
                                <ol class="breadcrumb" style="font-size: 13px">
                                    <li class="breadcrumb-item"><a href="updatecourse?button=.&courseid=${course.getCourseID()}">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">
                                        Update Course
                                    </li>
                                </ol>
                            </nav>
                            <h4 class="mb-3 fw-bold mb-1">Basic Information</h4>
                        </div>
                        <div class="create-course-content">
                            <div class="content-1">
                                <div class="create-course-title-container mb-3">
                                    <div class="create-course-title mb-1 fw-bold">Course Title</div>
                                    <input type="text" class="w-100 mb-1" name="CourseTitle" value="${course.getCourseName()}"/>
                                    <div class="description mb-1">
                                        Please enter your course title
                                    </div>
                                </div>
                                <div class="create-course-title-container mb-3">
                                    <div class="create-course-title mb-1 fw-bold">
                                        Course description
                                    </div>
                                    <textarea id="" class="w-100" style="height: 100px" name="CourseDes">${course.getDescription()}</textarea>
                                    <div class="description mb-1">
                                        Please enter your course description
                                    </div>
                                </div>
                                <div class="create-objectives">
                                    <div class="create-section-title fw-bold mb-3">Objectives</div>
                                    <div class="section-list">
                                        <c:forEach items="${objectivelist}" var="objective">
                                            <div class="section-create mb-2">
                                                <div class="section-title">${objective}</div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="add-section" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                        Add Objectives
                                    </div>
                                </div>
                            </div>
                            <div class="content-2">
                                <div class="course-thumbnail-header fw-bold">
                                    Course Thumbnail
                                </div>
                                <div class="course-thumbnail">
                                    <div class="course-thumbnail-content">
                                        <div class="course-thumbnail-img d-flex">
                                            <img src="" alt="" style="display: none" class="image-thumbnail" />
                                            <img src="${course.getCourseImage()}" alt="" class="icon img-fluid" />
                                        </div>
                                        <div class="course-thumbnail-footer p-3">
                                            <input type="file" id="thumbnail" onchange="UploadThumbnail(this)"/>
                                            <textarea id="imageBase64" name="imageBase64" rows="5" cols="10" class="d-none">${course.getCourseImage()}</textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="content-3">
                                <div class="course-publish mb-3">
                                    <div class="publish-button d-flex justify-content-center p-4">
                                        <a href="updatesection?courseid=${course.getCourseID()}"><input type="button" value="Edit section" class="btn btn-dark"/></a>
                                    </div>
                                    <input name="button" type="hidden" value=""/>
                                    <div class="save-draft px-3 py-3"><input type="button" value="Save changes" class="btn btn-dark" onclick="Submit(this)"/></div>
                                    <div class="save-draft px-3 py-3"><input type="button" value="Delete course" class="btn btn-dark" onclick="Submit(this)"/></div>
                                </div>
                                <div class="course-option p-3">
                                    <div class="course-option-content mb-2">
                                        <div class="course-option-content-title mb-1">Category</div>
                                        <div class="course-option-content-input mb-1">
                                            <select class="form-select w-100" aria-label="Default select example" name="category">
                                                <option selected>${course.getCategory()}</option>
                                                <option value="Front-end">Front-end</option>
                                                <option value="Back-end">Back-end</option>
                                                <option value="Database">Database</option>
                                            </select>
                                        </div>
                                        <div class="course-option-content-des">Select a Category</div>
                                    </div>
                                    <div class="course-option-content mb-2">
                                        <div class="course-option-content-title mb-1">Price</div>
                                        <div class="course-option-content-input mb-1">
                                            <input type="text" class="w-100" name="CoursePrice" value="${course.getCoursePrice()}"/>
                                        </div>
                                        <div class="course-option-content-des">
                                            Enter price of course
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal Add Section-->

                    <div class="modal fade" id="staticBackdrop" data-bs-keyboard="true" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">
                                        Add Objectives
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <label for="Section name" class="form-label">Objective Name</label>
                                    <!-- Section name must not null -->
                                    <input type="text" class="form-control" name="objectivename" required="true"/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                        Close
                                    </button>
                                    <input type="button" class="btn btn-primary" value="Add Objectives" onclick="Submit(this)">
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
        <script src="assets/js/create_course.js"></script>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>
        <script>
                                        function Submit(target) {
                                            document.querySelector('input[name="button"]').value = target.value;
                                            document.querySelector('#main > section > form').submit();
                                        }

                                        function UploadThumbnail(target) {
                                            var reader = new FileReader();
                                            var avatar = document.getElementById("imageBase64");

                                            reader.onloadend = function () {
                                                const img = new Image();
                                                img.src = reader.result;

                                                img.onload = function () {
                                                    const MAX_WIDTH = 128;
                                                    const MAX_HEIGHT = 128;

                                                    let width = img.width;
                                                    let height = img.height;

                                                    if (width > height) {
                                                        if (width > MAX_WIDTH) {
                                                            height *= MAX_WIDTH / width;
                                                            width = MAX_WIDTH;
                                                        }
                                                    } else {
                                                        if (height > MAX_HEIGHT) {
                                                            width *= MAX_HEIGHT / height;
                                                            height = MAX_HEIGHT;
                                                        }
                                                    }

                                                    const canvas = document.createElement('canvas');
                                                    canvas.width = width;
                                                    canvas.height = height;
                                                    const ctx = canvas.getContext("2d");
                                                    ctx.drawImage(this, 0, 0, width, height);
                                                    const b64 = canvas.toDataURL("image/jpeg");

                                                    avatar.innerText = b64;
                                                };
                                            };

                                            reader.readAsDataURL(target.files[0]);
                                        }
        </script>
    </body>

</html>
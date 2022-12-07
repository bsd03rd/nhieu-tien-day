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
            <%@include file="header.jsp"%>
            <!-- Begin: Create Course -->
            <section>
                <div class="create-course px-5 py-3">
                    <div class="create-course-header mb-3">
                        <h3 class="fw-bold">Create Section</h3>
                        <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
                            <ol class="breadcrumb" style="font-size: 13px">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    Create Section
                                </li>
                            </ol>
                        </nav>
                        <h4 class="mb-3 fw-bold mb-1">Create Section for ${course.getCourseName()}</h4>
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
                                        <c:forEach items="${listSection}" var="section">
                                            <tr>
                                                <td><%=count%></td>
                                                <td>${section.getSectionName()}</td>
                                                <td><a href="AddLesson?courseID=${courseID}&sectionID=${section.getSectionId()}" class="btn btn-primary">Add Lesson</a></td>
                                                <td>
                                                    <form action="CreateSection?sectionID=${section.getSectionId()}&delete='true'&courseId=${courseID}" method="POST" style="display: inline-block;">
                                                        <input type="submit" class="btn btn-primary" value="Delete">
                                                    </form>
                                                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#EditSection" onclick="khovloz(this)">Edit</button>
                                                </td>
                                                <td class="d-none">${section.getSectionId()}</td>
                                                <td class="d-none">${section.getSectionName()}</td>
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
                            <div class="course-container d-flex flex-column align-items-center">
                                <img src="${course.getCourseImage()}" alt="" style="width: 100%; height: 320px; object-fit: cover; border-radius: 16px;">
                                <a href="CreateCoursePreview?id=${courseID}" class="btn btn-primary mt-3">Next</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal Add Section-->
                <form action="CreateSection?courseId=${courseID}&addSection='true'" method="post">
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
                                    <input type="submit" class="btn btn-primary" value="Add Section" onclick="">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- Modal Edit Section-->
                <form action="CreateSection?courseId=${courseID}&edit='true'" method="post">
                    <div class="modal fade" id="EditSection" data-bs-keyboard="true" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">
                                        Edit Section
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <label for="Section name" class="form-label">Section Name</label>
                                    <!-- Section name must not null -->
                                    <input id="valueEdit" type="text" class="form-control" name="SectionNameModal" required="true" value="" autocomplete="off"/>
                                    <input type="hidden" id="SectionIDModal" value="" name="SectionIDModal"/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                        Close
                                    </button>
                                    <input type="submit" class="btn btn-primary" value="Edit Section">
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

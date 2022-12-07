<%-- 
    Document   : CreateCourse
    Created on : Oct 1, 2022, 10:34:28 AM
    Author     : Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    @@ -16,170 +19,334 @@
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
            <form action="CreateCourse" method="POST">
                <div class="create-course px-5 py-3">
                    <div class="create-course-header mb-3">
                        <h3 class="fw-bold">Create Course</h3>
                        <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
                            <ol class="breadcrumb" style="font-size: 13px">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">
                                    Create Course
                                </li>
                            </ol>
                        </nav>
                        <h4 class="mb-3 fw-bold mb-1">Basic Infromation</h4>
                    </div>
                    <div class="create-course-content">
                        <div class="content-1">
                            <div class="create-course-title-container mb-3">
                                <div class="create-course-title mb-1 fw-bold">Course Title</div>
                                <input type="text" class="w-100 mb-1" name="CourseTitle" required=""/>
                                <div class="description mb-1">
                                    Please enter your course title
                                </div>
                            </div>
                            <div class="create-course-title-container mb-3">
                                <div class="create-course-title mb-1 fw-bold">
                                    Course description
                                </div>
                                <textarea id="" class="w-100" style="height: 100px" name="CourseDes" required=""></textarea>
                                <div class="description mb-1">
                                    Please enter your course description
                                </div>
                            </div>
                            <div class="create-objectives">
                                <div class="create-section-title fw-bold mb-3">Objectives</div>
                                <div class="section-list">
                                </div>
                                <div class="add-section">
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
                                        <img src="assets/img/icon-image.png" alt="" class="icon" width="36px"
                                             height="36px" />
                                    </div>
                                    <div class="course-thumbnail-footer p-3">
                                        <input type="file" name="" id="thumbnail" onchange="upload(this)" accept="image/*" required=""/>
                                        <textarea id="imageBase64" name="imageBase64" rows="5" cols="10" class="d-none"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="content-3">
                            
                            <%
                                String idup = (String)request.getSession().getAttribute("idcup"); 
                                if(!idup.equals("-1")){
                                System.err.println("+++++++++++++++++++++++++++++++++++++++++++++"+idup);
                                request.getSession().setAttribute("idcup", null); 
                               
                            %>
                            <div class="course-publish mb-3">
                                <div class="publish-button d-flex justify-content-center p-4">
                                    <input type="button" value="Update Step" class="btn btn-primary nextStep" onclick="checkObjective()"/>
                                    <input type="text" value="<%=idup%>" name="idup" class="btn btn-primary nextStep" />
                                </div>
                            </div>
                            <%}else{%>
                            <div class="course-publish mb-3">
                                <div class="publish-button d-flex justify-content-center p-4">
                                    <input type="button" value="Next Step" class="btn btn-primary nextStep" onclick="checkObjective()"/>
                                </div>
                            </div>
                            <%}%>
                            
                            <div class="course-option p-3">
                                <div class="course-option-content mb-2">
                                    <div class="course-option-content-title mb-1">Category</div>
                                    <div class="course-option-content-input mb-1">
                                        <select class="form-select w-100" aria-label="Default select example" name="category" required>
                                            <option selected>Select course category</option>
                                            <option value="Front-end">Front-end</option>
                                            <option value="Back-end">Back-end</option>
                                            <option value="Database">Database</option>
                                            <option value="Music">Music</option>
                                        </select>
                                    </div>
                                    <div class="course-option-content-des">Select a Category</div>
                                </div>
                                <div class="course-option-content mb-2">
                                    <div class="course-option-content-title mb-1">Price</div>
                                    <div class="course-option-content-input mb-1">
                                        <input type="number" class="w-100" name="CoursePrice" required/>
                                    </div>
                                    <div class="course-option-content-des">
                                        Enter price of course
                                    </div>
                                </div>
                                <div class="course-option-content mb-2">
                                    <div class="course-option-content-title mb-1">Category</div>
                                    <div class="course-option-content-input mb-1">
                                        <select class="form-select w-100" aria-label="Default select example" name="difficulty">
                                            <option selected>Select course difficult0</option>
                                            <option value="easy">Easy</option>
                                            <option value="medium">Medium</option>
                                            <option value="hard">Hard</option>
                                        </select>
                                    </div>
                                    <div class="course-option-content-des">Select difficulty</div>
                                </div>
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
    <script>
        function checkObjective() {
            if ($('.section-list').children().length === 0) {
                alert("Objectives is empty");
            } else {
                $('.nextStep').attr('type', 'submit');
            }
        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="assets/js/create_course.js"></script>
    <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
    <script src="assets/js/home_page.js"></script>
</body>

</html>
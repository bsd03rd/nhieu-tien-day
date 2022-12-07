<%-- 
    Document   : UpdateBlog
    Created on : Oct 29, 2022, 9:12:29 PM
    Author     : vuman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" href="assets/css/header.css" />
    <link rel="stylesheet" href="assets/css/blog.css">
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
    <script>
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>
</head>

<body style="font-family: 'Montserrat';">
    <div id="main">

        <div id="blog">
            <div class="row g-2 py-3 px-4">
                <div class="col-12 fw-bolder fs-2 mb-2">Edit Blog</div>
                <div class="col-12 mb-2">Edit your blog below</div>
                <form action="updateblog" method="POST">
                    <input type="hidden" name="blogid" value="${blog.getBlogid()}">
                    <div class="col-12 row mt-2">
                        <div class="col-8">
                            <label class="form-label fw-bold">Blog title</label>
                            <input type="text" name="title" class="form-control mb-3" value="${blog.getTitle()}">

                            <label class="form-label fw-bold">Blog description</label>
                            <input type="text" class="form-control mb-3" name="description" value="${blog.getDescription()}">

                            <label class="form-label fw-bold">Category</label>
                            <select class="form-select" aria-label="Default select example" name="category">
                                <c:if test="${blog.getCategory().trim() == 'Front-end'}">
                                    <option value="Front-end" selected>Front-end</option>
                                </c:if>
                                <c:if test="${blog.getCategory().trim() != 'Front-end'}">
                                    <option value="Front-end">Front-end</option>
                                </c:if>

                                <c:if test="${blog.getCategory().trim() == 'Back-end'}">
                                    <option value="Back-end" selected>Back-end</option>
                                </c:if>
                                <c:if test="${blog.getCategory().trim() != 'Back-end'}">
                                    <option value="Back-end">Back-end</option>
                                </c:if>

                                <c:if test="${blog.getCategory().trim() == 'Database'}">
                                    <option value="Database" selected>Database</option>
                                </c:if>
                                <c:if test="${blog.getCategory().trim() != 'Database'}">
                                    <option value="Database">Database</option>
                                </c:if>
                            </select>

                            <label class="form-label fw-bold mt-3">Blog Content</label>
                            <textarea id="mytextarea" name="content">${blog.getContent()}</textarea>
                        </div>

                        <div class="col-4">
                            <div style="border: dashed 1px black; border-radius: 16px;">
                                <img src="${blog.getImage()}" alt="" style="width: 100%; height: 240px; object-fit: cover; border-radius: 16px;" class="image-thumbnail">
                            </div>
                            <div class="d-flex flex-column">
                                <input type="file" name="" id="thumbnail" onchange="upload(this)" class="form-control mt-3 mx-auto">
                                <textarea id="imageBase64" name="imageBase64" rows="5" cols="10" class="d-none"></textarea>                                
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-primary mt-3" value="Update Blog">
                </form>
            </div>

        </div>
    </div>
    <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="assets/js/create_course.js"></script>
    <script src="assets/js/home_page.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>

</html>

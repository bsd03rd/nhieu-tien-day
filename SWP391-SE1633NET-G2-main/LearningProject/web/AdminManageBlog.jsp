<%-- Document : AdminManageBlog Created on : Oct 30, 2022, 10:32:22 AM Author : Dung --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/header.css">
        <title>Admin Manage Blog</title>
    </head>

    <body style="font-family: 'Montserrat', sans-serif;">
        <%@include file="header.jsp" %>
        <div class="container-fluid w-100" style="margin-top: 66px;">
            <div class="row py-3 px-4">
                <div class="col-lg-12">
                    <h4 class="fw-bold">Blog Reported</h4>
                </div>
                <div class="col-lg-12">
                    <div class="card card-body shadow-sm" style="border-radius: 12px;">
                        <div class="row">
                            <div class="col-6">
                                <h6 class="fw-bold">Blog Reported List</h6>
                                <p style="color: rgba(0, 0, 0, 0.6)" class="text-danger">Have <span class="fw-bold">${blogListReported.size()} </span>blog are reported</p>
                            </div>
                            <div class="col-6">
                                <div class="d-flex justify-content-end" style="position: relative;">
                                    <i class="fa-solid fa-magnifying-glass" style="position: absolute; left: 12px; top: 50%; transform: translateY(-50%);"></i>
                                    <input class="w-100 form-control" type="text" style="border-radius: 30px; padding-left: 32px;">
                                </div>
                            </div>
                            <div class="col-12">
                                <table class="table table-borderless">
                                    <thead>
                                    <th>Blog title</th>
                                    <th>Author</th>
                                    <th>Date Created</th>
                                    <th>Blog Category</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${blogListReported}" var="blog">
                                            <tr>
                                                <td style="width: 28%">
                                                    <div>
                                                        <div class="fw-bold">
                                                            <a href>${blog.getTitle()}</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <img src="${blog.getUser().getAvatar()}" alt="" style="width: 32px; height: 32px; object-fit: cover; border-radius: 50%;">
                                                        <div class="d-inline-block" style="font-size: 14px; font-weight: 500;">${blog.getUser().getUserName()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="font-weight: 600">
                                                        <fmt:formatDate type = "both" 
                                                                        value = "${blog.getDate()}"/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <div style="background-color: #4dd4ac; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">${blog.getCategory()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        ${blog.getStatus()}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <form action="AdminManageBlog?blogID=${blog.getBlogid()}&enable='true'" method="POST" class="d-inline">
                                                            <input type="submit" value="Enable blog" class="bg-success" style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500; outline: none; border: none;">
                                                        </form>  
                                                        <form action="AdminManageBlog?blogID=${blog.getBlogid()}&disable='true'" method="POST" class="d-inline">
                                                            <input type="submit" value="Disable blog" class="bg-danger" style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500; outline: none; border: none;">
                                                        </form>  
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="d-flex justify-content-center">
                                    <a href="#">Load More...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12 mt-5">
                    <h4 class="fw-bold">All blog</h4>
                </div>
                <div class="col-lg-12">
                    <div class="card card-body shadow-sm" style="border-radius: 12px;">
                        <div class="row">
                            <div class="col-6">
                                <h6 class="fw-bold">All blog list on web</h6>
                                <p style="color: rgba(0, 0, 0, 0.6)" class="text-danger">Have <span class="fw-bold">${allBlogList.size()} </span>blogs on web</p>
                            </div>
                            <div class="col-6">
                                <div class="d-flex justify-content-end" style="position: relative;">
                                    <i class="fa-solid fa-magnifying-glass" style="position: absolute; left: 12px; top: 50%; transform: translateY(-50%);"></i>
                                    <input class="w-100 form-control" type="text" style="border-radius: 30px; padding-left: 32px;">
                                </div>
                            </div>
                            <div class="col-12">
                                <table class="table table-borderless">
                                    <thead>
                                    <th>Blog title</th>
                                    <th>Author</th>
                                    <th>Date Created</th>
                                    <th>Blog Category</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${allBlogList}" var="blog">
                                            <tr>
                                                <td style="width: 28%">
                                                    <div>
                                                        <div class="fw-bold">
                                                            <a href>${blog.getTitle()}</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <img src="${blog.getUser().getAvatar()}" alt="" style="width: 32px; height: 32px; object-fit: cover; border-radius: 50%;">
                                                        <div class="d-inline-block" style="font-size: 14px; font-weight: 500;">${blog.getUser().getUserName()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="font-weight: 600">
                                                        <fmt:formatDate type = "both" 
                                                                        value = "${blog.getDate()}" />
                                                        </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <div style="background-color: #4dd4ac; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;">${blog.getCategory()}</div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        ${blog.getStatus()}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <form action="AdminManageBlog?blogID=${blog.getBlogid()}&enable='true'" method="POST" class="d-inline">
                                                            <input type="submit" value="Enable blog" class="bg-success" style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500; outline: none; border: none;">
                                                        </form>  
                                                        <form action="AdminManageBlog?blogID=${blog.getBlogid()}&disable='true'" method="POST" class="d-inline">
                                                            <input type="submit" value="Disable blog" class="bg-danger" style="border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500; outline: none; border: none;">
                                                        </form>  
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="d-flex justify-content-center">
                                    <a href="#">Load More...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <script src="assets/js/home_page.js"></script>
        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>

</html>
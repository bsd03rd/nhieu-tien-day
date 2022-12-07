<%-- 
    Document   : AdminManageComment
    Created on : Oct 15, 2022, 2:21:03 PM
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
        <title>Admin Manage Comment</title>
    </head>

    <body style="font-family: 'Montserrat', sans-serif;">
        <%@include file="header.jsp" %>
        <div class="container-fluid w-100" style="margin-top: 66px;">
            <div class="row py-3 px-4">
                <div class="col-lg-12">
                    <h4 class="fw-bold">Comment</h4>
                </div>
                <div class="col-lg-12">
                    <div class="card card-body shadow-sm" style="border-radius: 12px;">
                        <div class="row">
                            <div class="col-6">
                                <h6 class="fw-bold">Comment Report</h6>
                                <p style="color: rgba(0, 0, 0, 0.6)">This is list of comment report</p>
                            </div>
                            <div class="col-6">
                                <div class="d-flex justify-content-end" style="position: relative;">
                                    <i class="fa-solid fa-magnifying-glass" style="position: absolute; left: 12px; top: 50%; transform: translateY(-50%);"></i>
                                    
                                    
                                    <form action="managecomment" method="GET">
                                        <input class="w-100 form-control" type="text" name="commentName" style="border-radius: 30px; padding-left: 32px;">
                                    <input type="submit" hidden>
                                    </form>
                                    
                                </div>
                            </div>
                            <div class="col-12">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <th>Account</th>
                                    <th>Comment Content</th>
                                    <th>Comment Date</th>
                                    <th>Action</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${comments}" var="comments">
                                            <tr>
                                                <td style="max-width: 180px">
                                                    <div class="d-flex align-items-center">
                                                        <img src="${comments.getUser().getAvatar()}" alt=""
                                                             style="width: 40px; height: 40px; object-fit: cover; border-radius: 50%;">
                                                        <div class="ms-2">
                                                            <a class="fw-bold" href="profiledetails?id=${comments.getUser().getUserId()}">${comments.getUser().getLastName()} ${comments.getUser().getFirstName()}</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td style="width: 50%;">
                                                    <div>
                                                        ${comments.getCommentContent()}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="font-weight: 600">${comments.getCommentDate()}</div>
                                                </td>
                                                <td>
                                                    <div>
                                                        <form action="managecomment" method="POST">
                                                            <c:if test="${comments.isIsDisable() == false}">
                                                                <input type="hidden" value="${comments.getCommentId()}" name="commentid">
                                                                <input type="hidden" value="${comments.isIsDisable()}" name="isdisable">
                                                                <button type="submit" class="bg-danger"
                                                                        style="border:none; border-radius: 32px; padding: 4px 8px; color: white; min-width: 100px; font-weight: 500;">Disable</button>
                                                            </c:if>
                                                            <c:if test="${comments.isIsDisable() == true}">
                                                                <input type="hidden" value="${comments.getCommentId()}" name="commentid">
                                                                <input type="hidden" value="${comments.isIsDisable()}" name="isdisable">
                                                                <button type="submit" class="bg-success"
                                                                        style="border:none; border-radius: 32px; padding: 4px 8px; color: white; min-width: 100px; font-weight: 500;">Enable</button>
                                                            </c:if>
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

        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>

</html>

<%-- 
    Document   : admin
    Created on : Aug 26, 2022, 12:39:52 AM
    Author     : l
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="../navigator/header.jsp" %>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 d-none d-md-block text-light sidebar" ">
                    <div class="">
                        <ul class="nav flex-column">
                            <br/>
                            <li class="nav-item">
                                <a class="nav-link " href="admin" style="color:#343A40;">                             
                                    Dashboard
                                </a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="movies" style="color:#343A40;">
                                    Add
                                </a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="genres" style="color:#343A40;">
                                    Update
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="persons" style="color:#343A40;">
                                    Delete
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="rates" style="color:#343A40;">
                                    Comments
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                        <h1 class="h2">Dashboard</h1>
                    </div>


                </div>
            </div>
        </div>

    </body>
    <%@include  file="../navigator/footer.jsp" %>
</html>

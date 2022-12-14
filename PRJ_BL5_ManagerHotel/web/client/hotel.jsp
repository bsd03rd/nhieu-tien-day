<%-- 
    Document   : hotel
    Created on : Dec 7, 2022, 11:21:28 AM
    Author     : l
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>

<%@include file="../navigator/header.jsp" %>

<body>
    <section class="jumbotron text-center" style=" background-color: #D86515;">
    </section>
    
    <h1></h1> 
    <div class="container">
        <c:forEach items="${listHotel}" var="a">
            <div class ="row">
                <div class="col-xs-12 col-md-12">
                    <!-- product -->
                    <div class="product-content product-wrap clearfix">
                        <div class="row">
                            <div class="col-md-6 col-sm-12 col-xs-12">
                                <div class="product-image"> 
                                    <img src="${a.imageURL}"  class="img-responsive"> 
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12 col-xs-12">
                                <div class="product-deatil">
                                    <h5 class="name">

                                        <a href="room?id=${a.hid}">
                                            ${a.hname} <span> ${a.typeid}</span>
                                        </a>
                                    </h5>
                                    <p class="price-container">
                                        <span>$99</span>
                                    </p>
                                    <span class="tag1"></span> 
                                </div>
                                <div class="description">
                                    <p>${a.description}</p>
                                </div>
                                 
                            </div>
                        </div>
                    </div>
                    <!-- end product -->
                </div>
            </div>
        </c:forEach>




    </div>
</body>

<%@include file="../navigator/footer.jsp" %>


<%-- 
    Document   : hotel
    Created on : Dec 7, 2022, 11:21:28 AM
    Author     : l
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>

<%@include file="../navigator/header.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
    <section class="jumbotron text-center" style=" background-color: #D86515;">
    </section>

    <div class ="row">
        <div class=" col-md-12">
            <form id="checkRoom" action="room" method="GET" >
                <input type="text" name="id" hidden value="${roomId}"/>
                <select hidden  name="opAsc" onchange="check()">
                    <option <c:if test="${opAsc}">
                            selected
                        </c:if>  value="A">Dsc</option>
                    <option <c:if test="${!opAsc}"> 
                            selected
                        </c:if>   value="B">Asc</option>
                </select>

            </form>
        </div>
    </div>
    <script>
        function check() {
            document.getElementById("checkRoom").submit();
        }
    </script>

    <c:forEach items="${room}" var="a">
        <div class ="row">
            <div class="col-xs-12 col-md-12">
                <!-- product -->
                <div class="product-content product-wrap clearfix">
                    <div class="row">
                        <div class="col-md-6 col-sm-12 col-xs-12">
                            <div class="product-image"> 
                                <img src="${a.rimageURL}"  class="img-responsive"> 
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12 col-xs-12">
                            <div class="product-deatil">
                                <h5 class="name">
                                    <a href="">
                                        ${a.rname} <span> ${a.roomtype}</span>
                                        
                                    </a>
                                </h5>
                                <p class="price-container">
                                    <span>${a.price}$/1d</span>
                                </p>
                                <span class="tag1"></span> 
                            </div>
                            <div class="description">   
                                <p style="font-size: 30px">${a.rdescription}</p>
                            </div>
                            <div class="product-info smart-form">
                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-xs-6 portfolio-link" data-bs-toggle="modal" href="#portfolioModal1"> 
                                        <a onclick="flagid(${a.rid})" href="#" class="btn btn-success">Book now</a>
                                        <input hidden=""  name="rid" value="${a.rid}"></input>
                                        <script>
                                            function flagid (id){
                                                 document.getElementById("id").value = id;
                                            }
                                            </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end product -->
            </div>
        </div>
    </c:forEach>           
</div>

<a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal1">
    Nhin tao ne    
</a>
<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">X</div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <h2 class="text-uppercase">Booking Form</h2>
                            <div class="disclaimer">
                                <form action="room" method="post">
                                   <label>Room ID</label>
                                    <input readonly="" name="id" id="id" type="text"></p>
                                    <label>Date From</label>
                                    <input readonly="" name="start" id="start" type="text"></p>
                                     <script>
                                        var today = new Date();
                                        var dd = String(today.getDate()).padStart(2, '0');
                                        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                                        var yyyy = today.getFullYear();

                                        today = yyyy + '-' + mm + '-' + dd;
                                        document.getElementById("start").value = today;
                                    </script>
                                    <label>Date End</label>
                                    <input onchange="checkdate()" required="" name="end" id="end" type="date"></p>
                                    <script>
                                        function checkdate(){
                                           var from = document.getElementById("start").value;
                                           var end = document.getElementById("end").value;
                                           let result = from.localeCompare(end);
                                            if(result!=-1){
                                                alert('End Date mus bigger than Start Date !');
                                                document.getElementById("end").value = '';
                                            }
                                        }
                                    </script>
                                     <label>Number of people</label>
                                    <input  name="num" required="" id="num" type="number"></p>
                                    <input name="sub" type="submit"></p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script src="jquery-3.6.1.min.js"></script>
</body>

<%@include file="../navigator/footer.jsp" %>
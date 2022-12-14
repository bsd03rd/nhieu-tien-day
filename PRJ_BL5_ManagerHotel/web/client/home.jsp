<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <%@include file="../navigator/header.jsp" %>
    <body class="main-layout">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="assets/images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->

        <!-- banner -->
        <section class="banner_main">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-bg">
                            <div class="padding_lert">
                                <h1>Đặt phòng khách sạn linh hoạt </h1>
                                <span>Giá tốt nhất</span>
                                <p>Felicity luôn đem tới trải nghiệm tốt nhất tới người dùng</p>
                                <a href="#">Đặt phòng ngay</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end banner -->
        <!-- form_lebal -->
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form_book">
                            <div class="row">
                                <div class="col-md-3">
                                    <label class="date">Địa điểm</label>
                                    <input class="book_n" placeholder="Bạn muốn đi đâu" type="text" name="">
                                </div>
                                <div class="col-md-2">
                                    <label class="date">Nhận phòng </label>
                                    <input class="book_n"  type="date" >
                                </div>
                                <div class="col-md-2">
                                    <label class="date">Trả phòng</label>
                                    <input class="book_n"  type="date" >
                                </div>
                                <div class="col-md-2">
                                    <label class="date">Khách</label>
                                    <input class="book_n" placeholder="Số lượng" type="type" name="2">
                                </div>
                                <div class="col-md-2">
                                    <button class="book_btn">Tìm kiếm</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <div class="choose">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="choose_box">
                            <div class="titlepage">
                                <h2><span class="text_norlam">Felicity room</span> <br></h2>

                            </div>
                            <p>Căn phòng đặc biệt nhất dành cho Joyer</p>
                            <a class="read_more" href="#">Tiếp tục</a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="img_box">
                                    <figure><img src="assets/images/img2.jpg" alt="#"/></figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="our">
            <div class="container">
                <div class="row d_flex">
                    <div class="col-md-6">
                        <div class="img_box">
                            <figure><img src="assets/images/img4.jpg" alt="#"/></figure>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="our_box">
                            <div class="titlepage">
                                <h2><span class="text_norlam">Tình yêu </span> <br>Breakfast</h2>
                            </div>
                            <p>Hơn 300 khách sạn kèm ưu đãi cho các cặp đôi</p>
                            <a class="read_more" href="#">Tiếp tục</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="choose">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="choose_box">
                            <div class="titlepage">
                                <h2><span class="text_norlam">Sang trọng</span> <br></h2>
                            </div>
                            <p>Trải nghiệm không gian đẳng cấp tại khách sạn 4* 5*</p>
                            <a class="read_more" href="#">Tiếp tục</a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="img_box">
                                    <figure><img src="assets/images/img2.jpg" alt="#"/></figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="our">
            <div class="container">
                <div class="row d_flex">
                    <div class="col-md-6">
                        <div class="img_box">
                            <figure><img src="assets/images/img4.jpg" alt="#"/></figure>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="our_box">
                            <div class="titlepage">
                                <h2><span class="text_norlam">Du lịch </span> <br></h2>
                            </div>
                            <p>Khám phá vùng đất mới với những chuyến đi</p>
                            <a class="read_more" href="#">Tiếp tục</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- about -->
        <div id="about"  class="about">
            <div class="container-fluid">
                <div class="row d_flex">
                    <div class="col-md-6">
                        <div class="about_text">
                            <div class="titlepage">
                                <h2>About Our Hotel</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit </p>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="about_img">
                            <figure><img src="assets/images/about_img.jpg" alt="#"/></figure>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end about -->

        <%@include file="../navigator/footer.jsp" %>
    </body>
</html>


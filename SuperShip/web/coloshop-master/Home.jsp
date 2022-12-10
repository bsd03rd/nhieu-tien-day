<%-- 
    Document   : home
    Created on : Jun 26, 2022, 5:58:36 PM
    Author     : BachDuc
--%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.Connection"%>
<%@page import="context.libDao"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product_Cloud"%>
<%@page import="context.DAO"%>
<%@page import="model.Acount_cloud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Colo Shop</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/bootstrap4/bootstrap.min.css">
        <link href="coloshop-master/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/main_styles.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/responsive.css">
    </head>

    <body>

        <div class="super_container">

            <!-- Header -->

            <header class="header trans_300">

                <!-- Top Navigation -->

                <div class="top_nav">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="top_nav_left">free shipping on all u.s orders over $50</div>
                            </div>
                            <div class="col-md-6 text-right">
                                <div class="top_nav_right">
                                    <ul class="top_nav_menu">

                                        <!-- Currency / Language / My Account -->

                                        <li class="currency">
                                            <a href="#">
                                                usd
                                                <i class="fa fa-angle-down"></i>
                                            </a>
                                            <ul class="currency_selection">
                                                <li><a href="#">cad</a></li>
                                                <li><a href="#">aud</a></li>
                                                <li><a href="#">eur</a></li>
                                                <li><a href="#">gbp</a></li>
                                            </ul>
                                        </li>
                                        <li class="language">
                                            <a href="#">
                                                English
                                                <i class="fa fa-angle-down"></i>
                                            </a>
                                            <ul class="language_selection">
                                                <li><a href="#">French</a></li>
                                                <li><a href="#">Italian</a></li>
                                                <li><a href="#">German</a></li>
                                                <li><a href="#">Spanish</a></li>
                                            </ul>
                                        </li>
                                        <li class="account">
                                            <a href="#">
                                                My Account
                                                <i class="fa fa-angle-down"></i>
                                            </a>
                                            <ul class="account_selection">
                                                <li><a href="Login"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                                <li><a href="Register"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Main Navigation -->

                <div class="main_nav_container">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-right">
                                <div class="logo_container">
                                    <a style="display: flex;" class="navbar-brand" href="Home">
                                        <!-- Logo icon -->
                                        <b class="logo-icon">
                                            <!-- Light Logo icon -->
                                            <img style="width: 80px;height:80px;" src="assets/images/bee.png" alt="homepage" class="light-logo" />
                                        </b>
                                        <!--End Logo icon -->
                                        <!-- Logo text -->
                                        <span class="logo-text">
                                            <!-- dark Logo text -->
                                            <h3 style="position: relative;top:24px;left: 12px;">Bee Music</h3>
                                        </span>
                                    </a>
                                </div>
                                <nav class="navbar">
                                    <ul class="navbar_menu">
                                        <li><a href="Proflie">home</a></li>
                                        <li><a href="categories">shop</a></li>
                                    </ul>
                                    <ul class="navbar_user">
                                        <li><a href="Proflie"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                                        <li class="checkout">
                                            <a href="Cart">
                                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                <%
                                                    int numItem = 0;
                                                    Acount_cloud acc = (Acount_cloud) request.getSession().getAttribute("ac");
                                                    Connection conn = null;
                                                    conn = new DAO().Connect();
                                                    PreparedStatement pr = null;
                                                    ResultSet rs = null;
                                                    pr = conn.prepareStatement("select * from Cart where gmail_Account like ?");
                                                    pr.setString(1, acc.getGmail_Account());
                                                    rs = pr.executeQuery();
                                                    while (rs.next()) {
                                                        numItem++;
                                                    }

                                                %>
                                                <span id="checkout_items" class="checkout_items"><%=numItem%></span>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="hamburger_container">
                                        <i class="fa fa-bars" aria-hidden="true"></i>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>

            </header>

            <div class="fs_menu_overlay"></div>
            <div class="hamburger_menu">
                <div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
                <div class="hamburger_menu_content text-right">
                    <ul class="menu_top_nav">
                        <li class="menu_item has-children">
                            <a href="#">
                                usd
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="menu_selection">
                                <li><a href="#">cad</a></li>
                                <li><a href="#">aud</a></li>
                                <li><a href="#">eur</a></li>
                                <li><a href="#">gbp</a></li>
                            </ul>
                        </li>
                        <li class="menu_item has-children">
                            <a href="#">
                                English
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="menu_selection">
                                <li><a href="#">French</a></li>
                                <li><a href="#">Italian</a></li>
                                <li><a href="#">German</a></li>
                                <li><a href="#">Spanish</a></li>
                            </ul>
                        </li>
                        <li class="menu_item has-children">
                            <a href="#">
                                My Account
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="menu_selection">
                                <li><a href="Login"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                <li><a href="Register"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                            </ul>
                        </li>
                        <li class="menu_item"><a href="#">home</a></li>
                        <li class="menu_item"><a href="#">shop</a></li>
                        <li class="menu_item"><a href="#">promotion</a></li>
                        <li class="menu_item"><a href="#">pages</a></li>
                        <li class="menu_item"><a href="#">blog</a></li>
                        <li class="menu_item"><a href="#">contact</a></li>
                    </ul>
                </div>
            </div>

            <!-- Slider -->

            <div class="main_slider" style="background-image:url(coloshop-master/images/home.jpg)">
                <div class="container fill_height">
                    <div class="row align-items-center fill_height">
                        <div class="col">
                            <div class="main_slider_content">
                                <h1 style="color: red;">50% FreeShip new Born Website</h1>
                                <div class="red_button shop_now_button"><a href="categories">shop now</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Banner -->

            <div class="banner">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="banner_item align-items-center" style="background-image:url(https://i.pinimg.com/564x/57/ad/af/57adaf2caecd92b6acb25544613abf9c.jpg)">
                                <div class="banner_category">
                                    <a href="categories">Guitar</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="banner_item align-items-center" style="background-image:url(https://i.pinimg.com/564x/cd/d7/52/cdd7522ce36edc6446e24224393c910d.jpg)">
                                <div class="banner_category">
                                    <a href="categories">Piano</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="banner_item align-items-center" style="background-image:url(https://i.pinimg.com/564x/e8/21/f0/e821f0197893399d658662f20f1bf260.jpg)">
                                <div class="banner_category">
                                    <a href="categories">Drum</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- New Arrivals -->

            <div class="new_arrivals">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title new_arrivals_title">
                                <h2>New Arrivals</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row align-items-center">
                        <div class="col text-center">
                            <div class="new_arrivals_sorting">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>

                                <%                                    Acount_cloud ac = ((Acount_cloud) request.getSession().getAttribute("ac"));
//                                    ArrayList<Product_Cloud> list = new DAO().GetAll_Product_Cloud(ac.getGmail_Account());
                                    ArrayList<Product_Cloud> list_itemnew = (ArrayList<Product_Cloud>) request.getAttribute("list_itemnew");
                                %>
                                <!-- Product 1 -->
                                <%
                                    
                                      Collections.sort(list_itemnew, new Comparator<Product_Cloud>() {
                @Override
                public int compare(Product_Cloud o1, Product_Cloud o2) {
                   return (Integer.parseInt( o2.getAmount_product()) - Integer.parseInt(o1.getAmount_product()) );
                }
        }); 
                                    for (Product_Cloud i : list_itemnew) {
                                        String url = "";
                                        if (i.getImg() == null) {
                                            url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                        }
                                        if (i.getImg() != null) {
                                            String encodedString = Base64.getEncoder().encodeToString(i.getImg());
                                            url = "data:image/png;base64," + encodedString;
                                        }
                                        String style="";
                                        if(Integer.parseInt(i.getAmount_product())==0){
                                        style="color: blue;";
                                        }

                                %>
                                <div class="product-item men">
                                    <div class="product discount product_filter">
                                        <div class="product_image" style="max-width: 250px;max-height: 260px;">
                                            <a style="<%=style%>" href="Single_Product?idpd=<%=i.getId_product()%>"> <img style="max-width: 250px;max-height: 260px;" src="<%=url%>" alt=""></a>
                                        </div>
                                        <div class="favorite favorite_left"></div>
                                        <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                        <div class="product_info">
                                            <h6 class="product_name"><a style="<%=style%>" href="Single_Product?idpd=<%=i.getId_product()%>" ><%=i.getName_product()%></a></h6>
                                            <div class="product_price"><%=i.getValue_product_unit()%></div>
                                        </div>
                                    </div>
                                    <div class="red_button add_to_cart_button"><a href="Add_Cart_Cookies?crpage=Home&idpd=<%=i.getId_product()%>">add to cart</a></div>
                                </div>
                                <%}%>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Deal of the week -->

            <div class="deal_ofthe_week">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-6">
                            <div class="deal_ofthe_week_img">
                                <img src="https://i.pinimg.com/564x/9b/a7/ab/9ba7ab0744355cb327de4c55ebebe727.jpg" alt="">
                            </div>
                        </div>
                        <div class="col-lg-6 text-right deal_ofthe_week_col">
                            <div class="deal_ofthe_week_content d-flex flex-column align-items-center float-right">
                                <div class="section_title">
                                    <h2>Deal Of The Week</h2>
                                </div>
                                <ul class="timer">
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="day" class="timer_num">03</div>
                                        <div class="timer_unit">Day</div>
                                    </li>
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="hour" class="timer_num">15</div>
                                        <div class="timer_unit">Hours</div>
                                    </li>
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="minute" class="timer_num">45</div>
                                        <div class="timer_unit">Mins</div>
                                    </li>
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="second" class="timer_num">23</div>
                                        <div class="timer_unit">Sec</div>
                                    </li>
                                </ul>
                                <div class="red_button deal_ofthe_week_button"><a href="categories">shop now</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Best Sellers -->

            <div class="best_sellers">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title new_arrivals_title">
                                <h2>Best Sellers</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="product_slider_container">
                                <div class="owl-carousel owl-theme product_slider">

                                    <%
                                        ArrayList<Product_Cloud> list_itempopular = (ArrayList<Product_Cloud>) request.getAttribute("list_itempopular");
                                        
                                        
                                        if (list_itempopular != null) {

                                            for (Product_Cloud i : list_itempopular) {

                                                String url = "";
                                                if (i.getImg() == null) {
                                                    url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                                }
                                                if (i.getImg() != null) {
                                                    String encodedString = Base64.getEncoder().encodeToString(i.getImg());
                                                    url = "data:image/png;base64," + encodedString;
                                                }
                                    %>

                                    <!-- Slide 1 -->
                                    <div class="owl-item product_slider_item">
                                        <div class="product-item">
                                            <div class="product_image" style="max-width: 250px;max-height: 260px;">
                                                <a href="Single_Product?idpd=<%=i.getId_product()%>"> <img style="max-width: 250px;max-height: 260px;" src="<%=url%>" alt=""></a>
                                            </div>
                                            <div class="favorite favorite_left"></div>
                                            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                            <div class="product_info">
                                                <h6 class="product_name"><a href="Single_Product?idpd=<%=i.getId_product()%>" ><%=i.getName_product()%></a></h6>
                                                <div class="product_price"><%=i.getValue_product_unit()%></div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}
                                        }%>

                                </div>

                                <!-- Slider Navigation -->

                                <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                </div>
                                <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-right" aria-hidden="true"></i>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- buy_againt -->

            <div class="buy_againt">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title new_arrivals_title">
                                <h2>Buy Againts</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="product_slider_container">
                                <div class="owl-carousel owl-theme product_slider">

                                    <%
                                        ArrayList<Product_Cloud> list_buyagaint = (ArrayList<Product_Cloud>) request.getAttribute("list_buyagaint");
                                        if (list_buyagaint != null) {

                                            for (Product_Cloud i : list_buyagaint) {

                                                String url = "";
                                                if (i.getImg() == null) {
                                                    url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                                }
                                                if (i.getImg() != null) {
                                                    String encodedString = Base64.getEncoder().encodeToString(i.getImg());
                                                    url = "data:image/png;base64," + encodedString;
                                                }
                                    %>

                                    <!-- Slide 1 -->
                                    <div class="owl-item product_slider_item">
                                        <div class="product-item">
                                            <div class="product_image" style="max-width: 250px;max-height: 260px;">
                                                <a href="Single_Product?idpd=<%=i.getId_product()%>"> <img style="max-width: 250px;max-height: 260px;" src="<%=url%>" alt=""></a>
                                            </div>
                                            <div class="favorite favorite_left"></div>
                                            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                            <div class="product_info">
                                                <h6 class="product_name"><a href="Single_Product?idpd=<%=i.getId_product()%>" ><%=i.getName_product()%></a></h6>
                                                <div class="product_price"><%=i.getValue_product_unit()%></div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}
                                        }%>

                                </div>

                                <!-- Slider Navigation -->

                                <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                </div>
                                <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-right" aria-hidden="true"></i>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- FOR YOU -->

            <div class="for_you">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title new_arrivals_title">
                                <h2>FOR YOU</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="product_slider_container">
                                <div class="owl-carousel owl-theme product_slider">

                                    <%
                                        ArrayList<Product_Cloud> list_search = (ArrayList<Product_Cloud>) request.getAttribute("list_search");
                                        if (list_search != null) {

                                            for (Product_Cloud i : list_search) {

                                                String url = "";
                                                if (i.getImg() == null) {
                                                    url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                                }
                                                if (i.getImg() != null) {
                                                    String encodedString = Base64.getEncoder().encodeToString(i.getImg());
                                                    url = "data:image/png;base64," + encodedString;
                                                }
                                    %>

                                    <!-- Slide 1 -->
                                    <div class="owl-item product_slider_item">
                                        <div class="product-item">
                                            <div class="product_image" style="max-width: 250px;max-height: 260px;">
                                                <a href="Single_Product?idpd=<%=i.getId_product()%>"> <img style="max-width: 250px;max-height: 260px;" src="<%=url%>" alt=""></a>
                                            </div>
                                            <div class="favorite favorite_left"></div>
                                            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                            <div class="product_info">
                                                <h6 class="product_name"><a href="Single_Product?idpd=<%=i.getId_product()%>" ><%=i.getName_product()%></a></h6>
                                                <div class="product_price"><%=i.getValue_product_unit()%></div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}
                                        }%>

                                </div>

                                <!-- Slider Navigation -->

                                <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                </div>
                                <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-right" aria-hidden="true"></i>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Benefit -->

            <div class="benefit">
                <div class="container">
                    <div class="row benefit_row">
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-truck" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>free shipping</h6>
                                    <p>Suffered Alteration in Some Form</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-money" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>cach on delivery</h6>
                                    <p>The Internet Tend To Repeat</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-undo" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>45 days return</h6>
                                    <p>Making it Look Like Readable</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-clock-o" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>opening all week</h6>
                                    <p>8AM - 09PM</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Blogs -->

            <div class="blogs">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title">
                                <h2>Latest Blogs</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row blogs_container">
                        <div class="col-lg-4 blog_item_col">
                            <div class="blog_item">
                                <div class="blog_background" style="background-image:url(https://i.pinimg.com/564x/5f/70/a2/5f70a29200d3e9ee33dbfaf853ec1009.jpg)"></div>
                                <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                                    <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                                    <span class="blog_meta">by admin | dec 01, 2017</span>
                                    <a class="blog_more" href="#">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 blog_item_col">
                            <div class="blog_item">
                                <div class="blog_background" style="background-image:url(https://i.pinimg.com/564x/50/28/be/5028be2960aa2373aae10bd4003eefa9.jpg)"></div>
                                <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                                    <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                                    <span class="blog_meta">by admin | dec 01, 2017</span>
                                    <a class="blog_more" href="#">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 blog_item_col">
                            <div class="blog_item">
                                <div class="blog_background" style="background-image:url(https://i.pinimg.com/564x/a8/51/b8/a851b887d1ecf796da489d25d3cdf637.jpg)"></div>
                                <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                                    <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                                    <span class="blog_meta">by admin | dec 01, 2017</span>
                                    <a class="blog_more" href="#">Read more</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Newsletter -->

            <div class="newsletter">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center">
                                <h4>Newsletter</h4>
                                <p>Subscribe to our newsletter and get 20% off your first purchase</p>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="post">
                                <div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
                                    <input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
                                    <button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Footer -->

            <footer class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
                                <ul class="footer_nav">
                                    <li><a href="#">Blog</a></li>
                                    <li><a href="#">FAQs</a></li>
                                    <li><a href="contact.html">Contact us</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div hidden="" class="row">
                        <div class="col-lg-12">
                            <div class="footer_nav_container">
                                Assigment by group 9 
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

        </div>

        <script src="coloshop-master/js/jquery-3.2.1.min.js"></script>
        <script src="coloshop-master/styles/bootstrap4/popper.js"></script>
        <script src="coloshop-master/styles/bootstrap4/bootstrap.min.js"></script>
        <script src="coloshop-master/plugins/Isotope/isotope.pkgd.min.js"></script>
        <script src="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
        <script src="coloshop-master/plugins/easing/easing.js"></script>
        <script src="coloshop-master/js/custom.js"></script>
    </body>

</html>

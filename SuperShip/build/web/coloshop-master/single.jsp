<%-- 
    Document   : single
    Author     : 
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="context.DAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="context.libDao"%>
<%@page import="model.Acount_cloud"%>
<%@page import="java.util.Base64"%>
<%@page import="model.Product_Cloud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Single Product</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/bootstrap4/bootstrap.min.css">
        <link href="coloshop-master/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" href="coloshop-master/plugins/themify-icons/themify-icons.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/single_styles.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/single_responsive.css">
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
                                                <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                                <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
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
                                    <a class="navbar-brand" href="Home">
                                        <!-- Logo icon -->
                                        <b class="logo-icon">
                                            <!-- Light Logo icon -->
                                            <img style="width: 80px;height:80px;" src="assets/images/bee.png" alt="homepage" class="light-logo" />
                                        </b>
                                        <!--End Logo icon -->
                                        <!-- Logo text -->
                                        <span class="logo-text">
                                            <!-- dark Logo text -->
                                            <img style="width: 150px;height: 60px;" src="assets/images/losip.png" alt="homepage" class="dark-logo" />
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
                                                    int numItem2 = 0;
                                                    Acount_cloud acc2 = (Acount_cloud) request.getSession().getAttribute("ac");
                                                    Connection conn2 = null;
                                                    conn2 = new DAO().Connect();
                                                    PreparedStatement pr2 = null;
                                                    ResultSet rs2 = null;
                                                    pr2 = conn2.prepareStatement("select * from Cart where gmail_Account like ?");
                                                    pr2.setString(1, acc2.getGmail_Account());
                                                    rs2 = pr2.executeQuery();
                                                    while (rs2.next()) {
                                                        numItem2++;
                                                    }

                                                %>
                                                <span id="checkout_items" class="checkout_items"><%=numItem2%></span>
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

            <!-- Hamburger Menu -->

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
                                <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
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

            <div class="container single_product_container">
                <div class="row">
                    <div class="col">

                        <!-- Breadcrumbs -->

                        <div class="breadcrumbs d-flex flex-row align-items-center">
                            <ul>
                                <li><a href="index.html">Home</a></li>
                                <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Single Item</a></li>
                            </ul>
                        </div>

                    </div>
                </div>


                <%
                    Product_Cloud pd = (Product_Cloud) request.getAttribute("singlePD");
                    String url = "";
                    if (pd.getImg().equals("")) {
                        url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                    } else {
                        String encodedString = Base64.getEncoder().encodeToString(pd.getImg());
                        url = "data:image/png;base64," + encodedString;
                    }


                %>
                <!--            // Product-->
                <div class="row">
                    <div class="col-lg-7">
                        <div class="single_product_pics">
                            <div class="row">
                                <div class="col-lg-9 image_col order-lg-2 order-1">
                                    <div class="single_product_image">
                                        <div class="single_product_image_background" style="background-image:url(<%=url%>)"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="product_details">
                            <div class="product_details_title">
                                <!--//Shop icon-->
                                
                                <%
                                    
                                    Acount_cloud iconShop=new DAO().Get_Account_CloudNOPASS(new libDao().Get_Product(request.getParameter("idpd"), "").getGmail_Account());
                                                
                                                String encodedString1 = Base64.getEncoder().encodeToString(iconShop.getAccount_info().getImg());
                                               String urlpr = "data:image/png;base64," + encodedString1;    
                                %>
                                <div class="user_review_container d-flex flex-column flex-sm-row">
                                            <div class="user">
<!--                                                <span style="font-size: 24px;"> Shop:</span>
                                               
                                                <div class="user_pic" style="display: inline-block;width: 20px;height: 20px;background-image:url(<%=urlpr%>)"></div>
                                                <div class="user_rating" style="display: inline-block;">
                                                    <a href="Shop_Profile?gmail=<%=iconShop.getGmail_Account()%>" target="target"><div style="font-size: 24px;color: black;"><%=iconShop.getGmail_Account()%></div></a>  
                                                </div>-->
                                            </div>
                                           
                                        </div>
                                <!--//-->
                                <h2><%=pd.getName_product()%></h2>
                                <p><%=pd.getDescription()%></p>
                            </div>
                            <div class="free_delivery d-flex flex-row align-items-center justify-content-center">
                                <span class="ti-truck"></span><span>free delivery</span>
                            </div>
                            <div class="product_price"><%=pd.getValue_product_perunit()%></div>
                            <ul class="star_rating">
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                            </ul>
                            <div class="product_color">
<!--                                <span>Select Color:</span>
                                <ul>
                                    <li style="background: #e54e5d"></li>
                                    <li style="background: #252525"></li>
                                    <li style="background: #60b3f3"></li>
                                </ul>-->
                            </div>
                            <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
<!--                                <span>Quantity:</span>
                                <div class="quantity_selector">
                                    <span class="minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                    <span id="quantity_value">1</span>
                                    <span class="plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                </div>-->
                                <div class="red_button add_to_cart_button"><a href="Add_Cart_Cookies?idpd=<%=pd.getId_product()%>&crpage=Single_Product?idpd=<%=pd.getId_product()%>">add to cart</a></div>
                                <div class="product_favorite d-flex flex-column align-items-center justify-content-center"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--            // Product-->
            </div>

            <!-- Tabs -->

            <div class="tabs_section_container">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="tabs_container">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">

                            <!-- Tab Description -->

                            <div id="tab_1" class="tab_container active">
                              <div class="row">

                                    <!-- User Reviews -->

                                    <div class="col-lg-6 reviews_col">
                                         <%
                                            Connection con1 = new DAO().Connect();
                                            PreparedStatement pr1 = null;
                                            ResultSet rs1 = null;
                                            String sql1 = "";
                                            sql1 = "select id_product,Account_info.gmail_Account,img,comment,date,grade from commentItems join Account_info on Account_info.gmail_Account=commentItems.gmail_Account where id_product like '" + request.getParameter("idpd") + "'";
                                            pr1 = con1.prepareStatement(sql1);
                                            rs1 = pr1.executeQuery();
                                            int count=0;
                                            while (rs1.next()) {
                                            count++;
                                             }
                                                
                                        %>
                                        
                                        <div class="tab_title reviews_title">
                                            <h4>Reviews (<%=count%>)</h4>
                                        </div>
                                        <%
                                            Connection con = new DAO().Connect();
                                            PreparedStatement pr = null;
                                            ResultSet rs = null;
                                            String sql = "";
                                            sql = "select id_product,Account_info.gmail_Account,img,comment,date,grade from commentItems join Account_info on Account_info.gmail_Account=commentItems.gmail_Account where id_product like '" + request.getParameter("idpd") + "'";
                                            pr = con.prepareStatement(sql);
                                            rs = pr.executeQuery();
                                            while (rs.next()) {
                                                String encodedString = Base64.getEncoder().encodeToString(rs.getBytes(3));
                                                url = "data:image/png;base64," + encodedString;
                                                
                                        %>
                                        
                                        
                                        <!-- User Review -->
                                        
                                        <div class="user_review_container d-flex flex-column flex-sm-row">
                                            <div class="user">
                                                <div class="user_pic" style=";width: 20px;height: 20px;background-image:url(<%=url%>)"></div>
                                                <div class="user_rating">
                                                    <div style="font-size: 14px;color: red">Rate:<%=rs.getString(6)%>/10</div>
                                                </div>
                                            </div>
                                            <div class="review">
                                                <div class="review_date"><%=rs.getString(5)%></div>
                                                <div class="user_name"><%=rs.getString(2)%></div>
                                                <p><%=rs.getString(4)%></p>
                                            </div>
                                        </div>
                                        <%}%>


                                        <!-- Add Review -->

                                        <div class="col-lg-6 add_review_col">

                                            <div class="add_review">
                                                <form id="review_form" action="Single_Product" method="GET">
                                                    <div>
                                                        <h1>Add Review</h1>
                                                        <input hidden="" id="review_form" name="idpd" value="<%=request.getParameter("idpd")%>">
                                                    </div>
                                                    <div>
                                                        Grade item:
                                                        <select id="review_form" name="grade" >
                                                            <option value="1">1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                            <option value="4">4</option>
                                                            <option value="5">5</option>
                                                            <option value="6">6</option>
                                                            <option value="7">7</option>
                                                            <option value="8">8</option>
                                                            <option value="9">9</option>
                                                            <option selected value="10">10</option>
                                                        </select>
                                                        <textarea id="review_form" class="input_review" name="comment"  placeholder="Your Review" rows="4" required data-error="Please, leave us a review."></textarea>
                                                    </div>
                                                    <div class="text-left text-sm-right">
                                                        <button id="review_form"  name="submitcomment" type="submit" class="red_button review_submit_btn trans_300" value="Submit">submit</button>
                                                    </div>
                                                </form>
                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>

                            <!-- Tab Additional Info -->
                            <!-- Tab Reviews -->

                            <div id="tab_3" class="tab_container">
                                

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
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="footer_nav_container">
                                    <div class="cr">©2018 All Rights Reserverd. This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="#">Colorlib</a> &amp; distributed by <a href="https://themewagon.com">ThemeWagon</a></div>
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
            <script src="coloshop-master/plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
            <script src="coloshop-master/js/single_custom.js"></script>
    </body>

</html>

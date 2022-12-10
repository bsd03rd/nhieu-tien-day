<%-- 
    Document   : categories
    Created on : Jul 5, 2022, 9:16:40 AM
    Author     : BachDuc
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Acount_cloud"%>
<%@page import="model.Category_product_Cloud"%>
<%@page import="context.libDao"%>
<%@page import="model.City_Address_model"%>
<%@page import="java.util.Base64"%>
<%@page import="context.DAO"%>
<%@page import="model.Product_Cloud"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Colo Shop Categories</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/bootstrap4/bootstrap.min.css">
        <link href="coloshop-master/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/categories_styles.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/categories_responsive.css">
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
                                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                                            <!-- Dark Logo icon -->
                                            <!--<img src="assets/images/bee.png" alt="homepage" class="dark-logo" />-->
                                            <!-- Light Logo icon -->
                                            <img style="width: 50px;height: 50px;" src="assets/images/bee.png" alt="homepage" class="light-logo" />
                                        </b>
                                        <!--End Logo icon -->
                                        <!-- Logo text -->
                                        <span class="logo-text">
                                            <!-- dark Logo text -->
                                            <h3 style="position: relative;top:14px;left: 12px;">Bee Music</h3>
                                        </span>
                                    </a>
                                </div>
                                <nav class="navbar">
                                    <ul class="navbar_menu">
                                        <li><a href="Home">home</a></li>
                                        <li><a href="Proflie">Profile</a></li>
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

            <div class="container product_section_container">
                <div class="row">
                    <div class="col product_section clearfix">

                        <!-- Breadcrumbs -->

                        <div class="breadcrumbs d-flex flex-row align-items-center">
                            <ul>
                                <li><a href="index.html">Home</a></li>
                                <li class="active"><a href="index.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
                            </ul>
                        </div>

                        <!-- Sidebar -->

                        <div class="sidebar">
                            <div style="width: 112%"class="sidebar_section">
                                <div class="sidebar_title">
                                    <h5>Product Category</h5>
                                </div>
                                <ul class="sidebar_categories">
                                    <li><input hidden="" form="search" id="selectcate" onclick="document.getElementById('search').submit();"  name="cate" value="<%=request.getAttribute("cate")%>"></li>
                                    <li><input form="none" id="allcate" onclick="document.getElementById('selectcate').value = '';document.getElementById('search').submit();" readonly="" class=" btn btn-cyan btn-light btn-success" name="cate" value="All Categories" ></li>
                                        <%
                                            ArrayList<Category_product_Cloud> list = (ArrayList<Category_product_Cloud>) new libDao().GetListCategory();
                                        %>
                                        <%
                                            for (int i = 0; i < list.size(); i++) {


                                        %>
                                    <li><input form="none" id="<%=list.get(i).getId_categories()%>" onclick="document.getElementById('selectcate').value =<%=list.get(i).getId_categories()%>;
                                            document.getElementById('search').submit();" readonly="" class=" btn btn-cyan btn-light btn-success" name="cate" value="<%=list.get(i).getCategoryName()%>" ></li>

                                    <%}%>
                                </ul>
                            </div>

                            <!-- Price Range Filtering -->
                            <div class="sidebar_section">
                                <div class="sidebar_title">
                                    <h5>Filter by Price</h5>
                                </div>
                                <!--                                <p>
                                                                    <input type="text" form="search" name="pricelimit" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
                                                                </p>-->
                                <%
                                    String min = (String) request.getParameter("minprice");
                                    String max = (String) request.getParameter("maxprice");
                                %>
                                <p> VND min:<input form="search" style="display: inline-block;"  type="text" id="textInput1" name="minprice" value="<%=min%>">
                                    VND max:<input form="search" style="display: inline-block;"  type="text" id="textInput2" name="maxprice" value="<%=max%>"></p>
                                <script>
                                    function updateTextInput1(val) {
                                        document.getElementById('textInput1').value = val;
                                    }
                                    function updateTextInput2(val) {
                                        document.getElementById('textInput2').value = val;
                                    }
                                </script>
                                <p>Min range Price</p>
                                <input type="range" name="rangeInput" min="0" max="1000000" onchange="updateTextInput1(this.value);">
                                <p>Max range Price</p>
                                <input type="range" name="rangeInput" min="0" max="1000000" onchange="updateTextInput2(this.value);">

                                <!--<div id="slider-range"></div>-->
                                <!--<div class="filter_button"><span>filter</span></div>-->
                                <input style="color: white;"type="submit" onclick ="document.getElementById('search').submit()" readonly="" class="filter_button" form="search" name="pricelimitbtn" value="Filter" >
                            </div>

                            <!-- Sizes -->


                            <!-- Color -->


                        </div>

                        <!-- Main Content -->

                        <div class="main_content">

                            <!-- Products -->
                            <div class="mysearch" style="display: block;padding-bottom: 150px;background-color: #f8f8f8">
                                <!--//........................................................................................................-->
                                <style>
                                    ::selection {
                                        background: #212129;
                                    }

                                    .search-wrapper {
                                        position: absolute;
                                        transform: translate(-50%, -50%);
                                        top:50%;
                                        left:50%;
                                    }
                                    .search-wrapper.active {
                                    }

                                    .search-wrapper .input-holder {
                                        height: 70px;
                                        width:70px;
                                        overflow: hidden;
                                        background: rgba(255,255,255,0);
                                        border-radius:6px;
                                        position: relative;
                                        transition: all 0.3s ease-in-out;
                                    }
                                    .search-wrapper.active .input-holder {
                                        width:450px;
                                        border-radius: 50px;
                                        background: rgba(0,0,0,0.5);
                                        transition: all .5s cubic-bezier(0.000, 0.105, 0.035, 1.570);
                                    }
                                    .search-wrapper .input-holder .search-input {
                                        width:100%;
                                        height: 50px;
                                        padding:0px 70px 0 20px;
                                        opacity: 0;
                                        position: absolute;
                                        top:0px;
                                        left:0px;
                                        background: transparent;
                                        box-sizing: border-box;
                                        border:none;
                                        outline:none;
                                        font-family:"Open Sans", Arial, Verdana;
                                        font-size: 16px;
                                        font-weight: 400;
                                        line-height: 20px;
                                        color:#FFF;
                                        transform: translate(0, 60px);
                                        transition: all .3s cubic-bezier(0.000, 0.105, 0.035, 1.570);
                                        transition-delay: 0.3s;
                                    }
                                    .search-wrapper.active .input-holder .search-input {
                                        opacity: 1;
                                        transform: translate(0, 10px);
                                    }
                                    .search-wrapper .input-holder .search-icon {
                                        width:70px;
                                        height:70px;
                                        border:none;
                                        border-radius:6px;
                                        background: #FFF;
                                        padding:0px;
                                        outline:none;
                                        position: relative;
                                        z-index: 2;
                                        float:right;
                                        cursor: pointer;
                                        transition: all 0.3s ease-in-out;
                                    }
                                    .search-wrapper.active .input-holder .search-icon {
                                        width: 50px;
                                        height:50px;
                                        margin: 10px;
                                        border-radius: 30px;
                                    }
                                    .search-wrapper .input-holder .search-icon span {
                                        width:22px;
                                        height:22px;
                                        display: inline-block;
                                        vertical-align: middle;
                                        position:relative;
                                        transform: rotate(45deg);
                                        transition: all .4s cubic-bezier(0.650, -0.600, 0.240, 1.650);
                                    }
                                    .search-wrapper.active .input-holder .search-icon span {
                                        transform: rotate(-45deg);
                                    }
                                    .search-wrapper .input-holder .search-icon span::before, .search-wrapper .input-holder .search-icon span::after {
                                        position: absolute;
                                        content:'';
                                    }
                                    .search-wrapper .input-holder .search-icon span::before {
                                        width: 4px;
                                        height: 11px;
                                        left: 9px;
                                        top: 18px;
                                        border-radius: 2px;
                                        background: #FE5F55;
                                    }
                                    .search-wrapper .input-holder .search-icon span::after {
                                        width: 14px;
                                        height: 14px;
                                        left: 0px;
                                        top: 0px;
                                        border-radius: 16px;
                                        border: 4px solid #FE5F55;
                                    }
                                    .search-wrapper .close {
                                        position: absolute;
                                        z-index: 1;
                                        top:24px;
                                        right:20px;
                                        width:25px;
                                        height:25px;
                                        cursor: pointer;
                                        transform: rotate(-180deg);
                                        transition: all .3s cubic-bezier(0.285, -0.450, 0.935, 0.110);
                                        transition-delay: 0.2s;
                                    }
                                    .search-wrapper.active .close {
                                        right:-50px;
                                        transform: rotate(45deg);
                                        transition: all .6s cubic-bezier(0.000, 0.105, 0.035, 1.570);
                                        transition-delay: 0.5s;
                                    }
                                    .search-wrapper .close::before, .search-wrapper .close::after {
                                        position:absolute;
                                        content:'';
                                        background: #FE5F55;
                                        border-radius: 2px;
                                    }
                                    .search-wrapper .close::before {
                                        width: 5px;
                                        height: 25px;
                                        left: 10px;
                                        top: 0px;
                                    }
                                    .search-wrapper .close::after {
                                        width: 25px;
                                        height: 5px;
                                        left: 0px;
                                        top: 10px;
                                        /*                                        ::placeholder {  Chrome, Firefox, Opera, Safari 10.1+ 
                                                                                    color: white;
                                                                                    opacity: 1;  Firefox 
                                                                                }*/
                                    }

                                </style>
                                <script>
                                    function searchToggle(obj, evt) {
                                        var container = $(obj).closest('.search-wrapper');
                                        if (!container.hasClass('active')) {
                                            container.addClass('active');
                                            evt.preventDefault();
                                        } else if (container.hasClass('active') && $(obj).closest('.input-holder').length == 0) {
                                            container.removeClass('active');
                                            // clear input
                                            container.find('.search-input').val('');
                                        }
                                    }

                                </script>
                                <div class="search-wrapper">
                                    <div class="input-holder">
                                        <input form="search" name="searchbar" value="${content}" type="text" style="color: white" class="search-input" placeholder="Type to search" />
                                        <button class="search-icon" form="search" name="searchbtn" value="searchbtn" type="submit" onclick="searchToggle(this, event);"><span></span></button>
                                    </div>
                                    <span class="close" onclick="searchToggle(this, event);"></span>
                                </div>
                                <!--//........................................................................................................-->
                            </div>

                            <div class="products_iso">

                                <div class="row">
                                    <div class="col">

                                        <%
                                            ArrayList<Product_Cloud> dflist = (ArrayList<Product_Cloud>) request.getAttribute("dflist");
                                            String orderby = String.valueOf(request.getAttribute("orderby"));
                                            int amount = (int) request.getAttribute("amount");
                                            int size = (int) request.getAttribute("size");
                                        %>
                                        <!-- Product Sorting -->

                                        <form id="search" action="categories" method="GET"></form>
                                        <div class="product_sorting_container product_sorting_container_top">
                                            <ul class="product_sorting">

                                                <li  >
                                                    <span style="width: 30%;"> Sort</span>
                                                    <select style="width: 70%;" onchange="document.getElementById('search').submit()" form="search" name="orderby" ">
                                                        <%
                                                            String displaycurrentsetting = "";
                                                            if (orderby.toLowerCase().equals("value_product_perunit asc")) {
                                                                displaycurrentsetting = "Sort by Price Increasing";
                                                            }
                                                            if (orderby.toLowerCase().equals("value_product_perunit desc")) {
                                                                displaycurrentsetting = "Sort by Price Decreasing";
                                                            }
                                                            if (orderby.toLowerCase().equals("name_product asc")) {
                                                                displaycurrentsetting = "Sort by Name";
                                                            }
                                                            if (orderby.toLowerCase().equals("create_date_product DESC")) {
                                                                displaycurrentsetting = "Sort by Newest";
                                                            }
                                                        %>
                                                        <option selected="" hidden="" value="<%=orderby%>"><%=displaycurrentsetting%></option>
                                                        <option value="value_product_perunit asc">Sort by Price Increasing</option>
                                                        <option value="value_product_perunit desc">Sort by Price Decreasing</option>
                                                        <option value="name_product asc">Sort by Name</option>
                                                        <option value="create_date_product DESC">Sort by Newest</option>
                                                    </select>
                                                </li>
                                                <li>
                                                    <span style="width: 30%">Show</span>
                                                    <select style="width: 70%" form="search" onchange="document.getElementById('search').submit()" name="amountitems" ">
                                                        <option selected="" hidden="" value="<%=amount%>"><%=amount%></option>
                                                        <option value="12">12</option>
                                                        <option value="24">24</option>
                                                        <option value="48">48</option>
                                                    </select>
                                                </li>
                                                <li style="width: 50%">
                                                    <span style="width: 60%">Area supplier </span>
                                                    <%
                                                        ArrayList<City_Address_model> list_city = new DAO().GetAll_City_Address_byName();
                                                        String city = (String) request.getParameter("city");
                                                        if (city == null || city.trim().equals("") || city.isEmpty()) {
                                                            city = "All region";
                                                        }
                                                    %>

                                                    <select style="width: 40%;" form="search"  onchange="document.getElementById('search').submit()" name="city">
                                                        <%
                                                            if (city.equals("All region")) {
                                                        %>
                                                        <option selected="" hidden="" value="">All region</option>
                                                        <%}%>
                                                        <%if (!city.equals("All region")) {
                                                        %>%>
                                                        <option selected="" hidden="" value="<%=city%>"><%=new libDao().GetNameCity(city)%></option>
                                                        <%}%>
                                                        <option  value="">All region</option>
                                                        <%
                                                            if (list_city
                                                                    != null) {
                                                                for (int i = 0; i < list_city.size(); i++) {
                                                        %>
                                                        <option value="<%=list_city.get(i).getID_City_Address()%>"><%=list_city.get(i).getName_City_Address()%></option>
                                                        <%}
                                                            }%>
                                                    </select>
                                                </li>
                                            </ul>


                                        </div>

                                        <!-- Product Grid -->

                                        <div class="product-grid">
                                            <%
                                                int count = 0;
                                                for (int i = 0; i < dflist.size(); i++) {
                                                    String url;
                                                    if (dflist.get(i).getImg().equals("")) {
                                                        url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                                    } else {
                                                        String encodedString = Base64.getEncoder().encodeToString(dflist.get(i).getImg());
                                                        url = "data:image/png;base64," + encodedString;
                                                    }
                                            %>
                                            <div class="product-item men">
                                                <div class="product discount product_filter">
                                                    <div class="product_image">
                                                        <!--<img style="max-height: 218px;" src="<%=url%>" alt="">-->
                                                        <a  href="Single_Product?idpd=<%=dflist.get(i).getId_product()%>"><img style="max-height: 218px;" src="<%=url%>" alt=""></a>
                                                    </div>
                                                    <div class="favorite favorite_left"></div>
                                                    <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                                    <div class="product_info">
                                                        <!--<h6 class="product_name"><a href="single.html"><%=dflist.get(i).getName_product()%></a></h6>-->
                                                        <h6 class="product_name"><a " href="Single_Product?idpd=<%=dflist.get(i).getId_product()%>" ><%=dflist.get(i).getName_product()%></a></h6>
                                                        <div class="product_price"><%=dflist.get(i).getValue_product_perunit()%></div>
                                                    </div>
                                                </div>
                                                <div class="red_button add_to_cart_button"><a href="Add_Cart_Cookies?crpage=categories&amp;idpd=<%=dflist.get(i).getId_product()%>">add to cart</a></div>

                                            </div>
                                            <%}%>
                                        </div>
                                        <%
                                            for (int i = 0; i <= size / amount; i++) {

                                        %>



                                        <input style="background-color: #555555;border: none;
                                               padding: 15px 32px;
                                               text-align: center;
                                               text-decoration: none;
                                               display: inline-block;
                                               font-size: 16px;
                                               margin: 4px 2px;
                                               cursor: pointer;color: white;text-decoration: none;"
                                               form="search" type="submit" name="page" value="<%=i%>">
                                        <%}%>


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
                                <div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
                                    <input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
                                    <button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
                                </div>
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
            <script src="coloshop-master/js/mycate.js"></script>

    </body>

</html>

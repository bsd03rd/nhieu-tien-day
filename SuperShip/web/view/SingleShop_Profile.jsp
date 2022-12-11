<%-- 
    Document   : SellerProfile
     10:02:01 PM
    Author     : 
--%>

<%@page import="model.Product_Cloud"%>
<%@page import="model.District_Address_model"%>
<%@page import="model.City_Address_model"%>
<%@page import="context.DAO"%>
<%@page import="model.Account_info_Cloud"%>
<%@page import="context.libDao"%>
<%@page import="model.Account_Address_Cloud"%>
<%@page import="model.Acount_cloud"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.All_Address_Account"%>
<%@page import="java.util.Base64"%>
<%@page import="model.All_In4_Account_Seller"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
        <title>Admin Template</title>
        
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/bootstrap4/bootstrap.min.css">
        <link href="coloshop-master/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/main_styles.css">
        <link rel="stylesheet" type="text/css" href="coloshop-master/styles/responsive.css">
        
        
        <link href="dist/css/style.min.css" rel="stylesheet">
        <link href="myCss/Mycss.css" rel="stylesheet">
        
        

        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

        <%
            Acount_cloud ac = (Acount_cloud) new DAO().Get_Account_CloudNOPASS(request.getParameter("gmail"));
            if (ac.getAccount_info() == null) {
                ac.setAccount_info(new Account_info_Cloud(ac.getGmail_Account(), "", "", "", "", "", "".getBytes(), ""));
            }
            if (ac.getAccount_Address_list() == null) {
                ac.setAccount_Address_list(new ArrayList<Account_Address_Cloud>());
            }
        %>
    </head>

    <body>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Main wrapper - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full" data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
            <header class="topbar" data-navbarbg="skin5">
                <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                    <div class="navbar-header" data-logobg="skin5">
                        <!-- ============================================================== -->
                        <!-- Logo -->
                        <!-- ============================================================== -->
                        <a class="navbar-brand" href="Home">
                            <!-- Logo icon -->
                            <b class="logo-icon">
                                <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                                <!-- Dark Logo icon -->
                                <img src="assets/images/bee.png" alt="homepage" class="dark-logo" />
                                <!-- Light Logo icon -->
                                <img style="width: 50px;height: 50px;" src="assets/images/bee.png" alt="homepage" class="light-logo" />
                            </b>
                            <!--End Logo icon -->
                            <!-- Logo text -->
                            <span class="logo-text">
                                <!-- dark Logo text -->
                                <img style="width: 150px;height: 60px;" src="assets/images/losip.png" alt="homepage" class="dark-logo" />
                                <!-- Light Logo text -->    
                                <img style="width: 150px;height: 60px;" src="assets/images/losip.png" class="light-logo" alt="homepage" />
                            </span>
                        </a>
                        <!-- ============================================================== -->
                        <!-- End Logo -->
                        <!-- ============================================================== -->
                        <!-- This is for the sidebar toggle which is visible on mobile only -->
                        <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="Home"><i class="ti-menu ti-close"></i></a>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End Logo -->
                    <!-- ============================================================== -->
                    <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                        <!-- ============================================================== -->
                        <!-- toggle and nav items -->
                        <!-- ============================================================== -->
                        <ul class="navbar-nav float-left mr-auto">
                            <!-- ============================================================== -->
                            <!-- Search -->
                            <!-- ============================================================== -->
                        </ul>
                        <!-- ============================================================== -->
                        <!-- Right side toggle and nav items -->
                        <!-- ============================================================== -->
                        <ul class="navbar-nav float-right">
                            <!-- ============================================================== -->
                            <!-- User profile and search -->
                            <!-- ============================================================== -->

                            <!-- ============================================================== -->
                            <!-- User profile and search -->
                            <!-- ============================================================== -->
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- ============================================================== -->
            <!-- End Topbar header -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->

            <!-- ============================================================== -->
            <!-- End Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page wrapper  -->
            <!-- ============================================================== -->
            <div class="page-wrapper">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="page-breadcrumb">
                    <div class="row align-items-center">
                        <div class="col-5">
                            <h4 class="page-title">Profile Shop</h4>
                            <div class="d-flex align-items-center">
                                <nav aria-label="breadcrumb">

                                </nav>
                            </div>
                        </div>
                        <div class="col-7">
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Container fluid  -->
                <!-- ============================================================== -->
                <div class="container-fluid">
                    <!-- ============================================================== -->
                    <!-- Start Page Content -->
                    <!-- ============================================================== -->
                    <!-- Row -->
                    <div class="row">
                        <!-- Column -->
                        <div class="col-lg-4 col-xlg-3 col-md-5">
                            <div class="card">
                                <div class="card-body">
                                    <%
                                        String url;
                                        if (ac.getAccount_info().getImg().equals("")) {
                                            url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                        } else {
                                            String encodedString = Base64.getEncoder().encodeToString(ac.getAccount_info().getImg());
                                            url = "data:image/png;base64," + encodedString;
                                        }

//                                        String MyURL = "data:image/png;base64," + encodedString;

                                    %>
                                    <center class="m-t-30"> <img src="<%=url%>" class="rounded-circle" width="150" />
                                        <h4 class="card-title m-t-10"><%=ac.getAccount_info().getFname()%></h4>
                                        <h6 class="card-subtitle">User Profile</h6>
                                        <div class="row text-center justify-content-md-center">
                                            <div class="col-4"><a href="javascript:void(0)" class="link"><i class="icon-people"></i> <font class="font-medium">254</font></a></div>
                                            <div class="col-4"><a href="javascript:void(0)" class="link"><i class="icon-picture"></i> <font class="font-medium">54</font></a></div>
                                        </div>
                                    </center>
                                </div>
                                <div>
                                    <hr> </div>
                                <div class="card-body"> <small class="text-muted">Email address </small>
                                    <h6><%=ac.getAccount_info().getGmail_Account()%></h6> <small class="text-muted p-t-30 db">Phone</small>
                                    <h6><%=ac.getAccount_info().getPhoneNumber()%></h6> <small class="text-muted p-t-30 db">Address</small>
                                    <%
                                        ArrayList< Account_Address_Cloud> acd = ac.getAccount_Address_list();
                                        if (acd != null) {
                                    %>
                                    <table class="styled-table">
                                        <tr>
                                            <th>City</th>
                                            <th>Address</th>
                                            <th>Street</th>
                                            <th></th>
                                        </tr>
                                        <% for (Account_Address_Cloud i : acd) {
                                                String city = new libDao().GetNameCity(i.getID_City_Address());
                                                String district = new libDao().GetNameDistrict(i.getID_City_Address(), i.getID_District_Address());
                                        %>
                                        <tr>
                                            <td><%=city%></td>
                                            <td><%=district%></td>
                                            <td><%=i.getStreet_Address()%></td>
                                        </tr>
                                        <%}%>
                                    </table>

                                    <%}%>

                                    <br/>
                                </div>
                            </div>
                        </div>
                        <!-- Column -->
                        <!-- Column -->
                        <div class="col-lg-8 col-xlg-9 col-md-7">
                            <div class="card">
                                  <div class="product_slider_container">
                                <div class="owl-carousel owl-theme product_slider">

                                    <%
                                        ArrayList<Product_Cloud> list_itempopular = new DAO().GetAll_Product_CloudCONSTGMAIL(ac.getGmail_Account());
                                        if(list_itempopular!=null){
                                        for (Product_Cloud i : list_itempopular) {
                                            String url2 = "";
                                            if (i.getImg() == null) {
                                                url2 = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                            }
                                            if (i.getImg() != null) {
                                                String encodedString = Base64.getEncoder().encodeToString(i.getImg());
                                                url2 = "data:image/png;base64," + encodedString;
                                            }
                                    %>

                                    <!-- Slide 1 -->
                                    <div class="owl-item product_slider_item">
                                        <div class="product-item">
                                            <div class="product_image" style="max-width: 250px;max-height: 260px;">
                                                <a href="Single_Product?idpd=<%=i.getId_product()%>"> <img style="max-width: 250px;max-height: 260px;" src="<%=url2%>" alt=""></a>
                                            </div>
                                            <div class="favorite favorite_left"></div>
                                            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                            <div class="product_info">
                                                <h6 class="product_name"><a href="Single_Product?idpd=<%=i.getId_product()%>" ><%=i.getName_product()%></a></h6>
                                                <div class="product_price"><%=i.getValue_product_unit()%></div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}}%>

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
                        <!-- Column -->
                    </div>
                    <!-- Row -->
                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <footer class="footer text-center">
                    Assigment copyright by Group9 
                </footer>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script src="assets/libs/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="assets/libs/popper.js/dist/umd/popper.min.js"></script>
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="dist/js/app-style-switcher.js"></script>
        <!--Wave Effects -->
        <script src="dist/js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="dist/js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="dist/js/custom.js"></script>
        <script>
            var loadFile = function (event) {
                var image = document.getElementById('output');
                image.src = URL.createObjectURL(event.target.files[0]);
            };
            var loadFile1 = function (event) {
                var image = document.getElementById('output1');
                image.src = URL.createObjectURL(event.target.files[0]);
            };
            function Close() {
                document.getElementById('Form_Edit').style.display = "none";
            }


        </script>
        <script src="coloshop-master/js/jquery-3.2.1.min.js"></script>
        <script src="coloshop-master/styles/bootstrap4/popper.js"></script>
        <script src="coloshop-master/styles/bootstrap4/bootstrap.min.js"></script>
        <script src="coloshop-master/plugins/Isotope/isotope.pkgd.min.js"></script>
        <script src="coloshop-master/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
        <script src="coloshop-master/plugins/easing/easing.js"></script>
        <script src="coloshop-master/js/custom.js"></script>
    </body>

</html>
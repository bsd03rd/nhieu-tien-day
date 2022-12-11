<%-- 
    Document   : SellerProfile
     10:02:01 PM
    Author     : 
--%>

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
        <link href="dist/css/style.min.css" rel="stylesheet">
        <link href="myCss/Mycss.css" rel="stylesheet">

        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

        <%
            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
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
                                <h3>Bee Music</h3>
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
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="assets/images/users/1.jpg" alt="user" class="rounded-circle" width="31"></a>
                                <div class="dropdown-menu dropdown-menu-right user-dd animated">
                                    <a class="dropdown-item" href="Proflie"><i class="ti-user m-r-5 m-l-5"></i> My Profile</a>
                                    <a class="dropdown-item" href="VNPAY/vnpay_index.jsp"><i class="ti-wallet m-r-5 m-l-5"></i> My Balance:<%=ac.getAccount_info().getBalance()%></a>
                                    <a class="dropdown-item" href="VNPAY/vnpay_index.jsp"><i class="ti-wallet m-r-5 m-l-5"></i> ReCharge</a>
                                    <a class="dropdown-item" href="javascript:void(0)"><i class="ti-email m-r-5 m-l-5"></i> Inbox</a>
                                    <a class="dropdown-item" href="Logout"><i class="ti-email m-r-5 m-l-5"></i> Log out</a>
                                </div>
                            </li>
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
            <aside class="left-sidebar" data-sidebarbg="skin6">
                <!-- Sidebar scroll-->
                <div class="scroll-sidebar">
                    <!-- Sidebar navigation-->
                    <nav class="sidebar-nav">
                        <ul id="sidebarnav">
                            <!-- User Profile-->
                            <li>
                                <!-- User Profile-->
                                <div class="user-profile d-flex no-block dropdown m-t-20">
                                    <div class="user-pic"><img src="assets/images/users/1.jpg" alt="users" class="rounded-circle" width="40" /></div>
                                    <div class="user-content hide-menu m-l-10">
                                        <a href="javascript:void(0)" class="" id="Userdd" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <h5 class="m-b-0 user-name font-medium"><%=ac.getAccount_info().getFname() + " " + ac.getAccount_info().getLname()%> <i class="fa fa-angle-down"></i></h5>
                                            <span class="op-5 user-email"><%=ac.getAccount_info().getGmail_Account()%> </span>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="Userdd">
                                            <a class="dropdown-item" href="javascript:void(0)"><i class="ti-user m-r-5 m-l-5"></i> My Profile</a>
                                            <a class="dropdown-item" href="javascript:void(0)"><i class="ti-wallet m-r-5 m-l-5"></i> My Balance</a>
                                            <a class="dropdown-item" href="javascript:void(0)"><i class="ti-email m-r-5 m-l-5"></i> Inbox</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="javascript:void(0)"><i class="ti-settings m-r-5 m-l-5"></i> Account Setting</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="javascript:void(0)"><i class="fa fa-power-off m-r-5 m-l-5"></i> Logout</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End User Profile-->
                            </li>
                            <li class="p-15 m-t-10"><a href="javascript:void(0)" class="btn btn-block create-btn text-white no-block d-flex align-items-center"><i class="fa fa-plus-square"></i> <span hidden="" class="hide-menu m-l-5">Create New</span> </a></li>
                            <!-- User Profile-->
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Proflie" aria-expanded="false"><i class="mdi mdi-view-dashboard"></i><span class="hide-menu">Profile</span></a></li>
                            <%
                            if(ac.getType_account().equals("admin")){
                            %>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Manager_Product" aria-expanded="false"><i class="mdi mdi-account-network"></i><span class="hide-menu">Manager Product</span></a></li>
                            <%}%>
                             <%
                                if (ac.getType_account().equals("user")) {
                            %>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Manager_Order" aria-expanded="false"><i class="mdi mdi-border-all"></i><span class="hide-menu">Manager Order</span></a></li>
                                        <%}%>
                            <%
                            if(ac.getType_account().equals("admin")){
                            %>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Manager_Shop" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Manager Shop</span></a></li>
                            <%}%>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Cart" aria-expanded="false"><i class="mdi mdi-file"></i><span class="hide-menu">My Cart</span></a></li>
                            <li class="text-center p-40 upgrade-btn">
                            </li>
                        </ul>

                    </nav>
                    <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </aside>
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
                            <h4 class="page-title">Profile Page</h4>
                            <div class="d-flex align-items-center">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                        <div class="col-7">
                            <div class="text-right upgrade-btn">
                            </div>
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
                                            <div class="col-4"><a hidden="" href="javascript:void(0)" class="link"><i class="icon-people"></i> <font class="font-medium">254</font></a></div>
                                            <div class="col-4"><a hidden="" href="javascript:void(0)" class="link"><i class="icon-picture"></i> <font class="font-medium">54</font></a></div>
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
                                            <th><a href="Delete_Address?gmail=<%=i.getGmail_Account()%>&idcity=<%=i.getID_City_Address()%>&iddis=<%=i.getID_District_Address()%>&address=<%=i.getStreet_Address()%>" >Delete</a></th>
                                        </tr>
                                        <%}%>
                                    </table>

                                    <%}%>
                                    <!--insert address-->
                                    <%
                                        ArrayList<City_Address_model> list_city = new DAO().GetAll_City_Address_byName();
                                        //City adress
                                        City_Address_model city = (City_Address_model) request.getAttribute("city");
                                        if (city == null) {
                                            city = new City_Address_model("none", "Select Your City");
                                        }
                                        //
                                        ArrayList<District_Address_model> list_district = new DAO().GetAll_District_Address_byCity(city.getID_City_Address());
                                        District_Address_model district = (District_Address_model) request.getAttribute("district");
                                        if (district == null) {
                                            district = new District_Address_model("none", "none", "Select Your District");
                                        }
                                    %>

                                    <div class="col-md-6 mb-4">
                                        <form id="LoadDistrict" action="LoadDistrict" method="POST" ></form>
                                        <select form="LoadDistrict" name="city_register" class="select" onchange="document.getElementById('LoadDistrict').submit()">
                                            <option value="<%=city.getID_City_Address()%>"><%=city.getName_City_Address()%></option>
                                            <%
                                                if (list_city
                                                        != null) {
                                                    for (int i = 0; i < list_city.size(); i++) {
                                            %>
                                            <option value="<%=list_city.get(i).getID_City_Address()%>"><%=list_city.get(i).getName_City_Address()%></option>
                                            <%}
                                                }%>
                                        </select>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <select form="LoadDistrict" name="district_register" class="select">
                                            <option value="<%=district.getID_District_Address()%>"><%= district.getName_District_Address()%></option>
                                            <%
                                                if (list_district
                                                        != null) {
                                                    for (int i = 0; i < list_district.size(); i++) {
                                            %>
                                            <option value="<%=list_district.get(i).getID_District_Address()%>"><%=list_district.get(i).getName_District_Address()%></option>
                                            <%}
                                                }%>
                                        </select>

                                    </div>
                                    <div  class="form-outline mb-4">
                                        <input form="LoadDistrict" type="text" name="Adress_register" value="" class="form-control form-control-lg" />
                                        <label class="form-label" for="form3Example8">Address</label>
                                    </div>
                                    <%
                                        String notice2 = (String) request.getSession().getAttribute("notice2");
                                        if (notice2 != null && !notice2.trim().isEmpty()) {
                                            request.getSession().setAttribute("notice2", "");
                                        }
                                        if (notice2 == null) {
                                            notice2 = "";
                                        }
                                    %>
                                    <label class="form-label" for="form3Example8" style="color: red;font-size: 18px;"><%=notice2%></label>
                                    <button form="LoadDistrict" type="submit" name="insertadress" value="submit" class="btn btn-warning btn-lg ms-2">Submit</button>


                                    <!--insert adress-->
                                    <br/>
                                </div>
                            </div>
                        </div>
                        <!-- Column -->
                        <!-- Column -->
                        <div class="col-lg-8 col-xlg-9 col-md-7">
                            <div class="card">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="col-md-12">First Name</label>
                                        <div class="col-md-12">
                                            <input type="text" name="fname" form="update_info" value="<%=ac.getAccount_info().getFname()%>" placeholder="<%=ac.getAccount_info().getFname()%>" class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Last Name</label>
                                        <div class="col-md-12">
                                            <input type="text" name="lname" form="update_info" value="<%= ac.getAccount_info().getLname()%>" placeholder="<%=ac.getAccount_info().getLname()%>" class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="example-email" class="col-md-12">Email</label>
                                        <div class="col-md-12">
                                            <input readonly="" type="text" name="email" form="update_info" value="<%=ac.getAccount_info().getGmail_Account()%>" placeholder="<%=ac.getAccount_info().getGmail_Account()%>" class="form-control form-control-line" name="example-email" id="example-email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Pass Word</label>
                                        <div class="col-md-12">
                                            <input type="text"readonly="" value="<%=ac.getPassword_account()%>" class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Phone Number</label>
                                        <div class="col-md-12">
                                            <input type="text" name="phone" form="update_info" value="<%=ac.getAccount_info().getPhoneNumber()%>" placeholder="<%=ac.getAccount_info().getPhoneNumber()%>" class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Gender</label>
                                        <div class="col-md-12">
                                            <select form="update_info" class="form-control form-control-line" name="gender" id="cars">
                                                <%
                                                    if (ac.getAccount_info().getGender().equals("maleGender")) {

                                                %>
                                                <option selected hidden value="maleGender">maleGender</option>
                                                <%}%>
                                                <%
                                                    if (ac.getAccount_info().getGender().equals("femaleGender")) {

                                                %>
                                                <option selected hidden value="maleGender">femaleGender</option>
                                                <%}%>
                                                <option value="maleGender">maleGender</option>
                                                <option value="femaleGender">femaleGender</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <form action="Proflie" id="update_info" method="POST"></form>
                                            <button name="update_info" value="update_info" form="update_info" type="submit" class="btn btn-success">Update Profile</button>
                                            <div style="margin-top: 12px;color: red;font-size: red;font-family: 24px;">${notice}</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Seller Image</label>
                                        <div class="col-md-12">
                                            <form id="imgupload" action="Proflie" method="post" enctype="multipart/form-data" ></form>
                                            <input class="btn btn-success" form="imgupload"  class="m-t-30" type="file"  accept="image/*" name="img_item" id="file"  onchange="loadFile(event)" style="display: block;">
                                            <input class="btn btn-secondary"  name="upload_img" value="Upload Image" type="submit" form="imgupload" />
                                            <img form="imgupload"  id="output" width="200" />
                                        </div>
                                    </div>
                                    <!--                                    <div class="form-group">
                                                                            <div class="col-sm-12">
                                                                                <button class="btn btn-success">Update Profile</button>
                                                                            </div>
                                                                        </div>-->
                                    <form id="repass" action="Proflie" method="POST"></form>
                                    <div class="form-group">
                                        <label class="col-md-12">NewPass</label>
                                        <div class="col-md-12">
                                            <input type="password" name="new" form="repass"  class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">ReNewPass</label>
                                        <div class="col-md-12">
                                            <input type="password" name="new" form="repass"  class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <%
                                        String noticepass = (String) request.getSession().getAttribute("noticepass");
                                        if (noticepass != null && !noticepass.trim().isEmpty()) {
                                            request.getSession().setAttribute("noticepass", "");
                                        }
                                        if (noticepass == null) {
                                            noticepass = "";
                                        }
                                    %>
                                    <label class="form-label" for="form3Example8" style="color: red;font-size: 18px;"><%=notice2%></label>
                                    <div style="color: red;font-size: 12px;"><%=noticepass%></div>
                                     <div class="col-md-12">
                                            <input type="submit" name="repass" form="repass" class="form-control form-control-line">
                                        </div>
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
            <footer hidden="" class="footer text-center">
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
</body>

</html>
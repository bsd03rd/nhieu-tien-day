<%-- 
    Document   : Manager_JSP
    Created on : Jun 21, 2022, 9:21:43 PM
    Author     : BachDuc
--%>

<%@page import="context.DAO"%>
<%@page import="context.libDao"%>
<%@page import="model.Category_product_Cloud"%>
<%@page import="java.util.Base64"%>
<%@page import="model.Product_Cloud"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Acount_cloud"%>
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
        <title>Xtreme Admin Template - The Ultimate Multipurpose admin template</title>
        <link href="assets/libs/chartist/dist/chartist.min.css" rel="stylesheet">
        <link href="dist/css/style.min.css" rel="stylesheet">
        <link href="myCss/Mycss.css" rel="stylesheet">
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <%
            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
        %>
    </head>

    <body>
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full" data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
            <header class="topbar" data-navbarbg="skin5">
                <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                    <div class="navbar-header" data-logobg="skin5">
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
                        <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                    </div>
                    <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                        <ul class="navbar-nav float-left mr-auto">
                            <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark" href="Home"><i class="ti-search"></i></a>
                                <form class="app-search position-absolute">
                                    <input type="text" class="form-control" placeholder="Search &amp; enter"> <a class="srh-btn"><i class="ti-close"></i></a>
                                </form>
                            </li>
                        </ul>
                        <ul class="navbar-nav float-right">
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
                        </ul>
                    </div>
                </nav>
            </header>
            <aside id="left-sidebar" class="left-sidebar" data-sidebarbg="skin6">
                <div class="scroll-sidebar">
                    <nav class="sidebar-nav">
                        <ul id="sidebarnav">
                            <li>
                                <div class="user-profile d-flex no-block dropdown m-t-20">
                                    <div class="user-pic"><img src="assets/images/users/1.jpg" alt="users" class="rounded-circle" width="40" /></div>
                                    <div class="user-content hide-menu m-l-10">
                                        <a href="javascript:void(0)" class="" id="Userdd" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <h5 class="m-b-0 user-name font-medium"><%=ac.getAccount_info().getFname() + " " + ac.getAccount_info().getLname()%> <i class="fa fa-angle-down"></i></h5>
                                            <span class="op-5 user-email"><%=ac.getGmail_Account()%></span>
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
                            </li>
                            <li class="p-15 m-t-10"><a href="javascript:void(0)" class="btn btn-block create-btn text-white no-block d-flex align-items-center"><i class="fa fa-plus-square"></i> <span class="hide-menu m-l-5">Create New</span> </a></li>
                            <!-- User Profile-->
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Proflie" aria-expanded="false"><i class="mdi mdi-view-dashboard"></i><span class="hide-menu">Profile</span></a></li>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Manager_Product" aria-expanded="false"><i class="mdi mdi-account-network"></i><span class="hide-menu">Manager Product</span></a></li>
                             <%
                                if (ac.getType_account().equals("user")) {
                            %>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Manager_Order" aria-expanded="false"><i class="mdi mdi-border-all"></i><span class="hide-menu">Manager Order</span></a></li>
                                        <%}%>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Manager_Shop" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Manager Shop</span></a></li>
                            <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="Cart" aria-expanded="false"><i class="mdi mdi-file"></i><span class="hide-menu">My Cart</span></a></li>
                            <li class="text-center p-40 upgrade-btn">
                            </li>
                        </ul>
                    </nav>
                </div>
            </aside>
            <div class="page-wrapper">
                <div class="page-breadcrumb">
                    <div class="row align-items-center">
                        <div class="col-5">
                            <h4 class="page-title">Product Manager</h4>
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
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-md-flex align-items-center">
                                        <div>
                                            <h4 class="card-title">Sales Summary</h4>
                                            <h5 class="card-subtitle">Overview of Latest Month</h5>
                                        </div>
                                        <div class="ml-auto d-flex no-block align-items-center">
                                            <ul class="list-inline font-12 dl m-r-15 m-b-0">
                                                <li class="list-inline-item text-info"><i class="fa fa-circle"></i> Iphone</li>
                                                <li class="list-inline-item text-primary"><i class="fa fa-circle"></i> Ipad</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <!-- column -->
                                        <div class="col-lg-12">
                                            <div class="campaign ct-charts"></div><!--
                                            <style>
body, html {
  height: 100%;
}

body {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-family: "fira-sans-2", Verdana, sans-serif;
}

#q-graph {
  display: block; /* fixes layout wonkiness in FF1.5 */
  position: relative; 
  width: 600px; 
  height: 300px;
  margin: 1.1em 0 0; 
  padding: 0;
  background: transparent;
  font-size: 11px;
}

#q-graph caption {
  caption-side: top; 
  width: 600px;
  text-transform: uppercase;
  letter-spacing: .5px;
  top: -40px;
  position: relative; 
  z-index: 10;
  font-weight: bold;
}

#q-graph tr, #q-graph th, #q-graph td { 
  position: absolute;
  bottom: 0; 
  width: 150px; 
  z-index: 2;
  margin: 0; 
  padding: 0;
  text-align: center;
}

#q-graph td {
  transition: all .3s ease;
  
  &:hover {
    background-color: desaturate(#85144b, 100);
    opacity: .9;
    color: white;
  }
}
  
#q-graph thead tr {
  left: 100%; 
  top: 50%; 
  bottom: auto;
  margin: -2.5em 0 0 5em;}
#q-graph thead th {
  width: 7.5em; 
  height: auto; 
  padding: 0.5em 1em;
}
#q-graph thead th.sent {
  top: 0; 
  left: 0; 
  line-height: 2;
}
#q-graph thead th.paid {
  top: 2.75em; 
  line-height: 2;
  left: 0; 
}

#q-graph tbody tr {
  height: 296px;
  padding-top: 2px;
  border-right: 1px dotted #C4C4C4; 
  color: #AAA;
}
#q-graph #q1 {
  left: 0;
}
#q-graph #q2 {left: 150px;}
#q-graph #q3 {left: 300px;}
#q-graph #q4 {left: 450px; border-right: none;}
#q-graph tbody th {bottom: -1.75em; vertical-align: top;
font-weight: normal; color: #333;}
#q-graph .bar {
  width: 60px; 
  border: 1px solid; 
  border-bottom: none; 
  color: #000;
}
#q-graph .bar p {
  margin: 5px 0 0; 
  padding: 0;
  opacity: .4;
}
#q-graph .sent {
  left: 13px; 
  background-color: #39cccc;
  border-color: transparent;
}
#q-graph .paid {
  left: 77px; 
  background-color: #7fdbff;
  border-color: transparent;
}


#ticks {
  position: relative; 
  top: -300px; 
  left: 2px;
  width: 596px; 
  height: 300px; 
  z-index: 1;
  margin-bottom: -300px;
  font-size: 10px;
  font-family: "fira-sans-2", Verdana, sans-serif;
}

#ticks .tick {
  position: relative; 
  border-bottom: 1px dotted #C4C4C4; 
  width: 600px;
}

#ticks .tick p {
  position: absolute; 
  left: -5em; 
  top: -0.8em; 
  margin: 0 0 0 0.5em;
}
                                            </style>
                                            <table id="q-graph">
                                                <caption>Most Sell Results</caption>
                                                <thead>
                                                  
                                                </thead>
                                                <tbody>
                                                    <tr class="qtr" id="q2">
                                                        <th scope="row">Q2</th>
                                                        <td class="sent bar" style="height: 206px;"><p>$34,340.72</p></td>
                                                        <td class="paid bar" style="height: 194px;"><p>$32,340.72</p></td>
                                                    </tr>
                                                    <tr class="qtr" id="q3">
                                                        <th scope="row">Q3</th>
                                                        <td class="sent bar" style="height: 259px;"><p>$43,145.52</p></td>
                                                        <td class="paid bar" style="height: 193px;"><p>$32,225.52</p></td>
                                                    </tr>
                                                    <tr class="qtr" id="q4">
                                                        <th scope="row">Q4</th>
                                                        <td class="sent bar" style="height: 110px;"><p>$18,415.96</p></td>
                                                        <td class="paid bar" style="height: 195px;"><p>$32,425.00</p></td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                            <div id="ticks">
                                                <div class="tick" style="margin-left: 50px; height: 59px;"><p>100%</p></div>
                                                <div class="tick" style="margin-left: 50px; height: 59px;"><p>80%</p></div>
                                                <div class="tick" style="margin-left: 50px; height: 59px;"><p>60%</p></div>
                                                <div class="tick" style="margin-left: 50px; height: 59px;"><p>40%</p></div>
                                                <div class="tick" style="margin-left: 50px; height: 59px;"><p>20%</p></div>
                                            </div>-->
                                        </div>
                                        <!-- column -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Feeds</h4>
                                    <div class="feed-widget">
                                        <ul class="list-style-none feed-body m-0 p-b-20">
                                            <li class="feed-item">
                                                <div class="feed-icon bg-info"><i class="far fa-bell"></i></div> You have 4 pending tasks. <span class="ml-auto font-12 text-muted">Just Now</span></li>
                                            <li class="feed-item">
                                                <div class="feed-icon bg-success"><i class="ti-server"></i></div> Server #1 overloaded.<span class="ml-auto font-12 text-muted">2 Hours ago</span></li>
                                            <li class="feed-item">
                                                <div class="feed-icon bg-warning"><i class="ti-shopping-cart"></i></div> New order received.<span class="ml-auto font-12 text-muted">31 May</span></li>
                                            <li class="feed-item">
                                                <div class="feed-icon bg-danger"><i class="ti-user"></i></div> New user registered.<span class="ml-auto font-12 text-muted">30 May</span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- column -->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <!-- title -->
                                    <div class="d-md-flex align-items-center">
                                        <div>
                                            <h4 class="card-title">Product Manager</h4>
                                        </div>

                                    </div>
                                    <!-- title -->
                                </div>
                                <!--WORKH-->
                                <div class="table-responsive">
                                    <%
                                        ArrayList<Product_Cloud> product_list = ac.getProduct_list();
                                        if (product_list != null) {
                                    %>
                                    <table class="table v-middle">
                                        <tr>
                                            <th>img</th>
                                            <th>modal</th>
                                            <th>id_product</th>
                                            <th>id_categories</th>
                                            <th>name_product</th>
                                            <th>value_product_unit</th>
                                            <th>value_product_perunit</th>
                                            <th>amount_product</th>
                                            <th>Description_product</th>
                                        </tr>
                                        <%
                                            for (Product_Cloud i : product_list) {
                                                String url = "";
                                                if (i.getImg() == null) {
                                                    url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                                }
                                                if (i.getImg() != null) {
                                                    String encodedString = Base64.getEncoder().encodeToString(i.getImg());
                                                    url = "data:image/png;base64," + encodedString;
                                                }
                                        %>
                                        <script>
                                            function EditFunction(idpd) {
                                                var srcimg = document.getElementsByClassName(idpd)[0].src
                                                var idproduct = document.getElementsByClassName(idpd)[1].value
                                                var idcate = document.getElementsByClassName(idpd)[2].value
                                                var nameproduct = document.getElementsByClassName(idpd)[3].value
                                                var prodcutunit = document.getElementsByClassName(idpd)[4].value
                                                var productcost = document.getElementsByClassName(idpd)[5].value
                                                var producamount = document.getElementsByClassName(idpd)[6].value
                                                var productdescription = document.getElementsByClassName(idpd)[7].value

                                                document.getElementById('output').src = srcimg;
                                                document.getElementById('edittitle').value = nameproduct.trim();
                                                document.getElementById('editpdcate').value = idcate.trim();
                                                document.getElementById('editpdname').value = nameproduct.trim();
                                                document.getElementById('editpdunit').value = prodcutunit.trim();
                                                document.getElementById('editpdcost').value = productcost.trim();
                                                document.getElementById('editpdamount').value = producamount.trim();
                                                document.getElementById('editpdid').value = idproduct.trim();
                                                document.getElementById('editpddescription').value = productdescription.trim();
                                            }
                                        </script>

                                        <tr>
                                            <td>
                                                <img class="<%=i.getId_product()%> class="btn btn-success"  src="<%=url%>" style=" width: 80px;height: 80px;" />
                                            </td>
                                            <td style="display: inline-flex;">
                                                <button  class="btn btn-success" onclick="EditFunction(<%=i.getId_product()%>)">Edit Product</button><br>
                                                <form id="deletepd<%=i.getId_product()%>" action="Manager_Product" method="POST"></form>
                                                <input form="deletepd<%=i.getId_product()%>" hidden=""  name="deletepd" value="<%=i.getId_product()%>"/>
                                                <button  form="deletepd<%=i.getId_product()%>" class="btn btn-success" name="delepdbtn" type="submit" >Delete Product</button>
                                            </td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value="<%=i.getId_product()%>" name="name"></td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value="<%=i.getId_categories()%>" name="name"></td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value="<%=i.getName_product()%>" name="name"></td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value="<%=i.getValue_product_unit()%>" name="name"></td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value=" <%=i.getValue_product_perunit()%>" name="name"></td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value=" <%=i.getAmount_product()%>" name="name"></td>
                                            <td ><input style="border: none;" class="<%=i.getId_product()%> col-form-label"  readonly=""  type="type" value=" <%=i.getDescription()%>" name="name"></td>
                                        </tr>
                                        <%}%>
                                    </table>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- Table -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Recent comment and chats -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <!-- column -->
                        <div class="col-lg-6">
                            <div class="card-body p-md-5 text-black">

                                <h3 class="mb-5 text-uppercase"> Edit Product:<input readonly="" style="border: none;background-color:#EEF5F9 ;" id="edittitle" class="col-form-label"  value="" > </h3>
                                <form id="editpd" action="Manager_Product" method="POST" enctype="multipart/form-data"></form>
                                <div class="form-outline mb-4">
                                    <select form="editpd" id="editpdcate" class="custom-select" name="editpdcate">

                                        <%
                                            ArrayList<Category_product_Cloud> list = new libDao().GetListCategory();
                                            if (list != null) {

                                        %>   
                                        <option hidden="" selected="" value="<%=list.get(0).getId_categories()%>"><%=list.get(0).getCategoryName()%></option>
                                        <% for (Category_product_Cloud i : list) {


                                        %>
                                        <option value="<%=i.getId_categories()%>" ><%=i.getCategoryName()%></option>
                                        <%}
                                            }%>

                                    </select>
                                    <label class="form-label" for="form3Example97"> Category Name</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input form="editpd" type="text" id="editpdname" name="editpdname" value="" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97"> Product Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input form="editpd"  type="text" id="editpdunit" name="editpdunit" value="" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Product Unit</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input form="editpd"  type="text" id="editpdcost" name="editpdcost" value=""  class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Cost Per Unit</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input form="editpd"  type="text" id="editpdamount" name="editpdamount" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Amount</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input form="editpd"  type="text" id="editpddescription" name="editpddescription" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Description</label>
                                </div>
                                <%
                                    String notice2="";
                                    if (request.getSession().getAttribute("notice2") != null) {
                                     notice2=(String)request.getSession().getAttribute("notice2");
                                        request.getSession().setAttribute("notice2", null);
                                    }
                                %>
                                <label class="form-label" style="color: red;font-size: 12px;" for="form3Example97"><%=notice2%></label>
                                <div class="form-outline mb-4" hidden="">
                                    <input form="editpd" id="editpdid" name="editpd" value="null" class="form-control form-control-lg" />
                                </div>

                                <div class="form-outline mb-4">
                                    <input form="editpd" hidden=""  type="text" id="editimgcheck" name="editimgcheck" value="null"/>
                                    <input class="EDITimg btn btn-success" form="editpd"  class="m-t-30" type="file"  accept="image/*" name="EDITimg_item" id="file"  onchange="loadFile(event)" style="display: block;">
                                    <img form="editpd"  id="output" width="200" />
                                </div>
                                <script>
                                    var loadFile = function (event) {
                                        var image = document.getElementById('output');
                                        image.src = URL.createObjectURL(event.target.files[0]);
                                        document.getElementById('editimgcheck').value = 'ok';
//                                        alert(document.getElementById('editimgcheck').value);
                                    };
                                </script>
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

                                <div class="d-flex justify-content-end pt-3">
                                    <button type="button" class="btn btn-light btn-lg">Reset all</button>
                                    <button form="editpd" type="submit" name="editpdbtn" value="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
                                </div>
                            </div>
                            //
                        </div>
                        <!-- column -->
                        <div class="col-lg-6">
                            <div class="card-body p-md-5 text-black">

                                <h3 class="mb-5 text-uppercase"> Adding Product </h3>
                                <form id="pd" action="Manager_Product" method="POST" enctype="multipart/form-data"></form>
                                <div class="form-outline mb-4">
                                    <select form="pd" class="custom-select" name="pdcate">

                                        <%
                                            if (list != null) {
                                        %>   
                                        <option hidden="" selected="" value="<%=list.get(0).getId_categories()%>"><%=list.get(0).getCategoryName()%></option>
                                        <% for (Category_product_Cloud i : list) {
                                        %>
                                        <option value="<%=i.getId_categories()%>" ><%=i.getCategoryName()%></option>
                                        <%}
                                            }%>


                                    </select>
                                    <label class="form-label" for="form3Example97"> Category Name</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input form="pd" type="text" name="pdname" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97"> Product Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input form="pd"  type="text" name="pdunit" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Product Unit</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input form="pd"  type="text" name="pdcost" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Cost Per Unit</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input form="pd"  type="text" name="pdamount" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Amount</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input form="pd"  type="text" name="pddescription" value="" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Description</label>
                                </div>

                                  <%
                                    String notice1="";
                                    if (request.getSession().getAttribute("notice1") != null) {
                                        notice1=(String)request.getSession().getAttribute("notice1");
                                        request.getSession().setAttribute("notice1", null);
                                    }
                                %> 
                                <label class="form-label" style="color: red;font-size: 12px;" for="form3Example97"><%=notice1%></label>

                                <div class="form-outline mb-4">
                                    <input class="btn btn-success" form="pd"  class="m-t-30" type="file"  accept="image/*" name="ADDimg_item" id="ADDfile"  onchange="addimg(event)" style="display: block;">
                                    <img form="pd"  id="addoutput" width="200" />
                                </div>
                                <script>
                                    function addimg(event) {
                                        var image = document.getElementById('addoutput');
                                        image.src = URL.createObjectURL(event.target.files[0]);
                                    }

                                </script>
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

                                <div class="d-flex justify-content-end pt-3">
                                    <button type="button" class="btn btn-light btn-lg">Reset all</button>
                                    <button form="pd" type="submit" name="ADDpdbtn" value="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
                                </div>
                            </div>
                            //
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer text-center">
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
    <!--This page JavaScript -->
    <!--chartis chart-->
    <script src="assets/libs/chartist/dist/chartist.min.js"></script>
    <script src="assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    <script src="dist/js/pages/dashboards/dashboard1.js"></script>
    <script src="myCss/myJS.js"></script>
    <script>

                                    var loadFile1 = function (event) {
                                        var image = document.getElementById('output1');
                                        image.src = URL.createObjectURL(event.target.files[0]);
                                    };
                                    function Close() {
                                        document.getElementById('Form_Edit').style.display = "none";
                                    }
                                    function DoPost() {
                                        $.post("Manager_Product", {name: "John", time: "2pm"});
                                    }

    </script>

</body>

</html>
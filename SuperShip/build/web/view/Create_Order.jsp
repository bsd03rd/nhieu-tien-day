<%-- 
    Document   : Create_Order
    Created on : Jun 6, 2022, 4:16:49 PM
    Author     : BachDuc
--%>

<%@page import="java.util.Base64"%>
<%@page import="context.libDao"%>
<%@page import="context.DAO"%>
<%@page import="model.Ship_info"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <%
            Ship_info sp = (Ship_info) request.getSession().getAttribute("sp");
        %>
    </head>
    <body>
        <h1>Create Order:</h1>

        <!--        <form id="Register_Form" action="../Create_Order" method="POST">
                    <input style="display: none;" type="text" name="Type_Login" value="Register" hidden  /><br/>
                    <p style="padding: 0;margin: 0;color: blue;">Create Order</p>
                    ShipVia<input type="text" name="username_register" id="username_register" /><br/>
                    Freight<input type="text" name="username_register" id="username_register" /><br/>
                    ShipName<input type="text" name="username_register" id="username_register" /><br/>
                    ShipAddress<input type="text" name="username_register" id="username_register" /><br/>
                    ShipCity<input type="text" name="username_register" id="username_register" /><br/>
                    ShipRegion<input type="text" name="username_register" id="username_register" /><br/>
                    ShipPostalCode<input type="text" name="username_register" id="username_register" /><br/>
                    ShipCountry<input type="text" name="username_register" id="username_register" /><br/>
                    <input type="button" value="Submit"  />
                </form>-->

        <section class="h-100 h-custom" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-8 col-xl-6">
                        <div class="card border-top border-bottom border-3" style="border-color: #f37a27 !important;">
                            <div class="card-body p-5">

                                <p class="lead fw-bold mb-5" style="color: #f37a27;">Purchase Reciept</p>

                                <div class="row">
                                    <div class="col mb-3">
                                        <p class="small text-muted mb-1">Date</p>
                                        <p><%=request.getSession().getAttribute("date")%></p>
                                    </div>
                                    <div class="col mb-3">
                                        <p class="small text-muted mb-1">Order No.</p>
                                        <p><%=request.getSession().getAttribute("idod")%></p>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    window.onbeforeunload = function () {
                                        window.alert("Dude, are you sure you want to leave? Think of the kittens!");
                                        return;
                                    }
                                </script>
                                <%
                                    String[] IDPD = (String[]) request.getSession().getAttribute("IDPD");
                                    String[] IDPD_value = (String[]) request.getSession().getAttribute("IDPD_value");
                                    for (int i = 0; i < IDPD.length; i++) {

                                        String url = "";
                                        if (new libDao().Get_Product(IDPD[i], "").getImg() == null) {
                                            url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                        }
                                        if (new libDao().Get_Product(IDPD[i], "") != null) {
                                            String encodedString = Base64.getEncoder().encodeToString(new libDao().Get_Product(IDPD[i], "").getImg());
                                            url = "data:image/png;base64," + encodedString;
                                        }
                                %>
                                <div class="mx-n5 px-5 py-4" style="background-color: #f2f2f2;">
                                    <div class="row">
                                        <div class="col-md-8 col-lg-9">
                                            <img   src="<%=url%>" style=" width: 80px;height: 80px;" />
                                        </div>
                                        <div class="col-md-8 col-lg-9">
                                            <p><%= new libDao().Get_Product(IDPD[i], "").getName_product()%> x<%=IDPD_value[i]%></p>
                                        </div>
                                        <div class="col-md-4 col-lg-3">
                                            <p><%= new libDao().Get_Product(IDPD[i], "").getValue_product_perunit()%></p>
                                        </div>
                                    </div>
<!--                                                                        <div class="row">
                                                                            <div class="col-md-8 col-lg-9">
                                                                                <p class="mb-0">Shipping</p>
                                                                            </div>
                                                                            <div class="col-md-4 col-lg-3">
                                                                                <p class="mb-0">£33.00</p>
                                                                            </div>
                                                                        </div>-->
                                </div>
                                <%}%>
                                <div class="row my-4">
                                    <div class="col-md-4 offset-md-8 ">
                                        <p class=" fw-bold mb-0" style="color: #f37a27;">Ship:<%=request.getSession().getAttribute("fee")%></p>
                                    </div>
                                </div>
                                <div class="row my-4">
                                    <div class="col-md-4 offset-md-8 ">
                                        <p class=" fw-bold mb-0" style="color: #f37a27;">TOTAL:<%=request.getSession().getAttribute("totalincludeship")%></p>
                                    </div>
                                </div>

                                <p class="lead fw-bold mb-4 pb-2" style="color: #f37a27;">Tracking Order</p>

                                <div class="row">
                                    <div class="col-lg-12">

                                        <div class="horizontal-timeline">

                                            <ul class="list-inline items d-flex justify-content-between">
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">Ordered</p
                                                    class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">Shipped</p
                                                    class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">On the way
                                                    </p>
                                                </li>
                                                <li class="list-inline-item items-list text-end" style="margin-right: 8px;">
                                                    <p style="margin-right: -8px;">Delivered</p>
                                                </li>
                                            </ul>

                                        </div>

                                    </div>
                                </div>

                                <p class="mt-4 pt-2 mb-0"> <a href="../Home" style="color: #f37a27;">Return Home</a></p>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


    </body>
</html>

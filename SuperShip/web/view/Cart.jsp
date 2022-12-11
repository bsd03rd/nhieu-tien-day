<%-- 
    Document   : Cart
    Author     : 
--%>

<%@page import="model.Account_Address_Cloud"%>
<%@page import="model.Cart_Model"%>
<%@page import="java.util.Base64"%>
<%@page import="model.Acount_cloud"%>
<%@page import="context.libDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product_Cloud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            @media (min-width: 1025px) {
                .h-custom {
                    height: 100vh !important;
                }
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: black;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                            <div class="card-body p-0">
                                <div class="row g-0">
                                    <div class="col-lg-8">
                                        <div class="p-5">
                                            <div class="d-flex justify-content-between align-items-center mb-5">
                                                <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                                <h6 class="mb-0 text-muted">3 items</h6>
                                            </div>
                                            <hr class="my-4">
                                            <!--item-->
                                            <%
                                                ArrayList<Cart_Model> list = (ArrayList<Cart_Model>) request.getAttribute("list");
                                                Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
                                            %>


                                            <%
                                                int index = 0;
                                                float total = 0;
                                                String currentgmail = "";
                                                for (Cart_Model i : list) {
                                                    total += (i.getAmoun()) * (Float.parseFloat(i.getPd().getValue_product_perunit()));
                                                    index += 1;
                                                    String url = "";
                                                    if (i.getPd().getImg().equals("")) {
                                                        url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
                                                    } else {
                                                        String encodedString = Base64.getEncoder().encodeToString(i.getPd().getImg());
                                                        url = "data:image/png;base64," + encodedString;
                                                    }
                                            %>

                                            <%
                                                if (!i.getPd().getGmail_Account().equals(currentgmail)) {
                                                    currentgmail = i.getPd().getGmail_Account();
                                            %>

                                            <script>
                                                function CheckShop(id)
                                                {
                                                    if (document.getElementById(id).checked)
                                                    {
                                                        document.getElementById(id).setAttribute('form', 'Pay_Cart');
                                                        //
                                                        for (let i = 0; i < document.getElementsByClassName('checkg').length; i++) {
                                                            if (document.getElementsByClassName('checkg')[i].value === id) {
                                                                var x = 0;
                                                                for (let i = 0; i <= document.getElementsByClassName('ampd:' + id).length; i++) {
                                                                    var num1 = document.getElementsByClassName('ampd:' + id)[i].value;
                                                                    var num2 = document.getElementsByClassName('vlpd:' + id)[i].value;
                                                                    x += num1 * num2;
                                                                    document.getElementById('total').value = x;
                                                                }
                                                            } else {
                                                                document.getElementsByClassName('checkg')[i].disabled = "disabled";
//                                                               // cal total payment item
                                                            }
                                                        }
                                                    } else {
                                                        document.getElementById(id).setAttribute('form', 'none');
                                                        document.getElementById('total').value = 0;
                                                        document.getElementById('totalincludeship').value = 0;
                                                        for (let i = 0; i < document.getElementsByClassName('checkg').length; i++) {
                                                            document.getElementsByClassName('checkg')[i].checked = false
                                                            document.getElementsByClassName('checkg')[i].disabled = "";
                                                        }
                                                    }
                                                }
                                            </script>  
                                            <span>Shop:<%=i.getPd().getGmail_Account()%></span>
                                            <input type="checkbox" onclick="CheckShop('<%=i.getPd().getGmail_Account()%>')" class="checkg" form="none" id="<%=i.getPd().getGmail_Account()%>"   name="Shop" value="<%=i.getPd().getGmail_Account()%>">
                                            <%}%>
                                            <input hidden="" class="text-muted" hidd form="Pay_Cart" name="IDPD"  value="<%=i.getPd().getId_product()%>">
                                            <input min="0" form="Pay_Cart" style="display: none;"   name="IDPD_value" value="<%=i.getAmoun()%>" >
                                            <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img
                                                        src="<%=url%>"
                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6 class="text-muted"><%=i.getPd().getName_product()%></h6>
                                                    <!--update element-->
                                                    <input hidden="" class="text-muted" readonly="" form="update_cart" id="index1<%=index%>" name="IDPD"  value="<%=i.getPd().getId_product()%>">

                                                    <h6 class="text-black mb-0"><%=i.getPd().getDescription()%></h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <script>
                                                        function ChangeAmoun(id, num) {
                                                            document.getElementById(id).value = num;
                                                            alert(num);
                                                        }
                                                    </script>
                                                    <input min="0" form="update_cart"   name="IDPD_value" value="<%=i.getAmoun()%>" type="number"
                                                           class="ampd:<%=i.getPd().getGmail_Account()%> form-control form-control-sm" />

                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <input style="border: none;" class="vlpd:<%=i.getPd().getGmail_Account()%> mb-0 col-form-label"  readonly=""  type="text" value="<%=i.getPd().getValue_product_perunit()%>">
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                </div>
                                            </div>
                                            <%}%>
                                            <!--end item-->
                                            <form id="update_cart"  action="UpdateCart" method="POST"></form>
                                            <input form="update_cart" class="btn btn-success" type="submit" name="updatecartbtn" value="Update Cart">
                                            <%
                                                String notice = "";
                                                if (request.getSession().getAttribute("notice") != null) {
                                                    notice = (String) request.getSession().getAttribute("notice");
                                                    request.getSession().setAttribute("notice", null);
                                                }
                                            %>
                                            <div style="color:red;font-size: 24px;"><%=notice%></div>
                                            <hr class="my-4">

                                            <div class="pt-5">
                                                <h6 class="mb-0"><a href="categories" class="text-body"><i
                                                            class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                            <h5 class="fw-bold">Your Credit:<%=ac.getAccount_info().getBalance()%></h5>
                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase">Total items:</h5>
                                                <h5 class="text-uppercase"><input style="border: none;"  readonly="" id="total" type="text" value=""></h5>
                                            </div>

                                            <div class=" justify-content-between mb-4">
                                                <h5 class="text-uppercase">Recevie Location</h5>
                                                <%
                                                    ArrayList< Account_Address_Cloud> acd = ac.getAccount_Address_list();
                                                    if (!acd.isEmpty()) {
                                                    int count=0;
                                                    
                                                %>
                                                <select form="Pay_Cart" name="Idadd">
                                                    <% for (Account_Address_Cloud i : acd) {
                                                            
                                                            String city = new libDao().GetNameCity(i.getID_City_Address());
                                                            String district = new libDao().GetNameDistrict(i.getID_City_Address(), i.getID_District_Address());
                                                            if(count==0){
                                                            count=1;
                                                        
                                                    %>
                                                    <option selected hidden value="<%=i.getIdadd()%>"><%=city%> <%=district%> <%=i.getStreet_Address()%></option>
                                                    <%}%>
                                                    <option value="<%=i.getIdadd()%>"><%=city%> <%=district%> <%=i.getStreet_Address()%></option>
                                                    <%}%>
                                                </select>
                                                <%}%>
                                                <%
                                                if (acd.isEmpty()) {
                                                %>
                                                <div>YOU DONT HAVE ANY ADRESS:<a href="Proflie" target="target">Add new Adress Profile</a></div>
                                                <%}%>
                                            </div>
                                            <h5 class="text-uppercase mb-3">Shipping</h5>

                                            <script>
                                                function phivanchuyen() {
                                                    var num1 = document.getElementById('total').value;
                                                    if(num1 == ''){
                                                         alert('Choose Product Order First !');
                                                    }else{
                                                        var num2 = document.getElementById('fee').value;
                                                    var num3 = parseFloat(num1) + parseFloat(num2);
                                                    document.getElementById('totalincludeship').value = num3;
                                                    }
                                                    
                                                }

                                            </script>
                                            <div class="mb-4 pb-2">
                                                <select form="Pay_Cart" onchange="phivanchuyen()"  id="fee" name="fee" class="select">
                                                    <option selected="" hidden="" value="null">Choose Ship method</option>
                                                    <option  value="30000">Save-Delivery- VND 30.000</option>
                                                    <option value="50000">Standard-Delivery- VND 50.000</option>
                                                    <option value="150000">Super-Delivery- VND 150.000</option>
                                                </select>
                                            </div>


                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Total price</h5>
          
                                                <h5 class="text-uppercase"><input style="border: none;"  readonly="" form="Pay_Cart" name="totalincludeship" id="totalincludeship" type="text" value=""></h5>
                                            </div>
                                            <%
                                                    String notice2 = "";
                                                    if (request.getSession().getAttribute("notice2") != null) {
                                                        notice2 = (String) request.getSession().getAttribute("notice2");
                                                        request.getSession().setAttribute("notice2", null);
                                                    }
                                                %>
                                                <div style="color:red;font-size: 24px;"><%=notice2%></div>
                                                <form id="Pay_Cart" action="Pay_Cart" method="POST"></form>
                                                <button type="submit" name="paybtn" value="paybtn" form="Pay_Cart" class="btn_pay btn btn- btn-lg btn-success"
                                                        data-mdb-ripple-color="dark">Register</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

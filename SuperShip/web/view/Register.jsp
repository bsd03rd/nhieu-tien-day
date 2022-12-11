<%-- 
    Document   : Register
     2:29:58 AM
    Author     : 
--%>

<%@page import="com.sun.org.apache.bcel.internal.generic.DADD"%>
<%@page import="model.District_Address_model"%>
<%@page import="context.DAO"%>
<%@page import="model.City_Address_model"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .card-registration .select-input.form-control[readonly]:not([disabled]) {
                font-size: 1rem;
                line-height: 2.15;
                padding-left: .75em;
                padding-right: .75em;
            }
            .card-registration .select-arrow {
                top: 13px;
            }
        </style>
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
    </head>
    <body>
        <!--        <form id="Register_Form" action="Register" method="POST">
                    <input style="display: none;" type="text" name="Type_Login" value="Register" hidden  /><br/>
                    <p style="padding: 0;margin: 0;color: blue;">Register Form</p>
                    Username:<input type="text" name="username_register" id="username_register" /><br/>
                    PassWord:<input type="password" name="password_register" id="password_register" ><br/>
                    Re-PassWord:<input type="password" name="re_password_register" id="re_password_register"><br/>
                    Gmail:<input type="text" name="gmail" ><br/>
                    <input type="button" value="Submit" onclick="CheckPass(this.form)" />
                </form>-->

        <section class="h-100 bg-dark">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col">
                        <div class="card card-registration my-4">
                            <div class="row g-0">
                                <div class="col-xl-6 d-none d-xl-block">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                                         alt="Sample photo" class="img-fluid"
                                         style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                                </div>

                                <div class="col-xl-6">
                                    <form action="Register" method="POST">
                                        <div class="card-body p-md-5 text-black">
                                            <h3 class="mb-5 text-uppercase">Seller registration form</h3>

                                            <div class="row">
                                                <div class="col-md-6 mb-4">
                                                    <div class="form-outline">
                                                        <input type="text" name="Fname_register" value="${Fname_register}"  id="form3Example1m" class="form-control form-control-lg" />
                                                        <label class="form-label" for="form3Example1m">First name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 mb-4">
                                                    <div class="form-outline">
                                                        <input type="text" name="Lname_register"  value="${Lname_register}" id="form3Example1n" class="form-control form-control-lg" />
                                                        <label class="form-label" for="form3Example1n">Last name</label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text" id="form3Example8" name="Adress_register" value="${Adress_register}" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example8">Address</label>
                                            </div>

                                            <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                                                <h6 class="mb-0 me-4">Gender: </h6>
                                                <%                                                    String check1="";
                                                    String check2="";
                                                    String check3="";
                                                    if (request.getAttribute("gender_register") != null) {

                                                        if (request.getAttribute("gender_register").equals("femaleGender")) {
                                                            check1 = "checked";
                                                        }
                                                        if (request.getAttribute("gender_register").equals("maleGender")) {
                                                            check2 = "checked";
                                                        }
                                                        if (request.getAttribute("gender_register").equals("otherGender")) {
                                                            check3 = "checked";
                                                        }
                                                    
                                                %>
                                                <div class="form-check form-check-inline mb-0 me-4">
                                                    <input class="form-check-input" type="radio" name="gender_register" <%=check1%> id="femaleGender"
                                                           value="femaleGender" />
                                                    <label class="form-check-label"  for="femaleGender" >Female</label>
                                                </div>

                                                <div class="form-check form-check-inline mb-0 me-4">
                                                    <input class="form-check-input" type="radio" name="gender_register" <%=check2%> id="maleGender"
                                                           value="maleGender" />
                                                    <label class="form-check-label" for="maleGender">Male</label>
                                                </div>

                                                <div class="form-check form-check-inline mb-0">
                                                    <input class="form-check-input" type="radio" name="gender_register" <%=check3%> id="otherGender"
                                                           value="otherGender" />
                                                    <label class="form-check-label" for="otherGender">Other</label>
                                                </div>
                                                <%}%>
                                                  <%
                                                      if (request.getAttribute("gender_register") == null) {
                                                              
                                                             
                                                  %>
                                                <div class="form-check form-check-inline mb-0 me-4">
                                                    <input class="form-check-input" type="radio" name="gender_register" id="femaleGender"
                                                           value="femaleGender" />
                                                    <label class="form-check-label"  for="femaleGender" >Female</label>
                                                </div>

                                                <div class="form-check form-check-inline mb-0 me-4">
                                                    <input class="form-check-input" type="radio" name="gender_register" id="maleGender"
                                                           value="maleGender" />
                                                    <label class="form-check-label" for="maleGender">Male</label>
                                                </div>

                                                <div class="form-check form-check-inline mb-0">
                                                    <input class="form-check-input" type="radio" name="gender_register" id="otherGender"
                                                           value="otherGender" />
                                                    <label class="form-check-label" for="otherGender">Other</label>
                                                </div>
                                                           <%}%>

                                            </div>

                                            <div class="row">

                                                <div class="col-md-6 mb-4">

                                                    <select name="city_register" class="select" onchange="this.form.submit()">
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
                                                    <select name="district_register" class="select">
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

                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text"name="shopdomain_register" value="${shopdomain_register}" id="form3Example9" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example9">Shop Domain</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text" name="PhoneNumber_register" value="${PhoneNumber_register}" id="form3Example90" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example90">Phone Number</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text" name="email_register" value="${email_register}" id="form3Example97" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example97">Email</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text" name="password_register" value="${password_register}" id="form3Example97" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example97">Password</label>
                                            </div>

                                            <div class="d-flex justify-content-end pt-3">
                                                <button type="button" class="btn btn-light btn-lg">Reset all</button>
                                                <button type="submit" name="btn" value="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
                                            </div>

                                        </div>
                                    </form>      
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>

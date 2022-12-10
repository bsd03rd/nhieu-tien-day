<%-- 
    Document   : Employees_Add
    Created on : Jun 5, 2022, 11:09:47 AM
    Author     : BachDuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="../Employees_Add" method="post" enctype="multipart/form-data">
            LastName <input type="text" name="LastName" /><br>
            FirstName<input type="text" name="FirstName" /><br>
            Title<input type="text" name="Title" /><br>
            TitleOfCourtesy<input type="text" name="TitleOfCourtesy" /><br>
            BirthDate<input type="text" name="BirthDate" /><br>
            HireDate<input type="text" name="HireDate" /><br>
            Address<input type="text" name="Address" /><br>
            City<input type="text" name="City" /><br>
            Region<input type="text" name="Region" /><br> 
            PostalCode<input type="text" name="PostalCode" /><br>
            Country<input type="text" name="Country" /><br> 
            HomePhone<input type="text" name="HomePhone" /><br>
            Extension<input type="text" name="Extension" /><br> 
            Notes<input type="text" name="Notes" /><br>
            ReportsTo<input type="text" name="ReportsTo" /><br>
            PhotoPath<input type="text" name="PhotoPath" /><br>

            Photo:<p><input type="file"  accept="image/*" name="Photo" id="file"  onchange="loadFile(event)" style="display: inline-block;"></p>
            <p><img id="output" width="200" /></p>
            <input type="submit" />
        </form>
        <script>
            var loadFile = function (event) {
                var image = document.getElementById('output');
                image.src = URL.createObjectURL(event.target.files[0]);
            };
        </script>

    </body>
</html>

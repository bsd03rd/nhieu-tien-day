<%-- 
    Document   : AccountTransactionHistory
    Created on : Oct 10, 2022, 12:49:10 PM
    Author     : Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Elearning</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/header.css">
        <link rel="stylesheet" href="assets/css/footer.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap');
        </style>
    </head>

    <body>        
        <%@include file="header.jsp"%>
        <section style="margin-top: 66px; overflow-x: hidden">
            <div class="row">
                <div class="col-6 p-5 d-flex flex-column align-items-center">
                    <div class="mb-3" style="border: 1px solid #1a1a1a; width: 50%; height: 60%;">   
                        <img src="https://img.vietqr.io/image/970422-69962345678910-VoAEB5A.jpg?accountName=NGO%20HAI%20NAM&addInfo=NAP%20${userid}" alt="alt" style="width:100%"/>
                        
                    </div>
                    <div class="mb-3">
                       Lưu ý: Nếu 5 phút mà không nhận được tiền thì vui lòng liên hệ admin
                    </div>
                        <button class="btn btn-primary mb-2" onclick="window.location.href='transaction'">
                        Go to transaction history
                    </button>
                    <div class="btn btn-secondary" onclick="window.location.href='home'">
                        Back to homepage
                    </div>
                </div>
                <div class="col-6">
                    <img src="https://img.freepik.com/free-vector/e-wallet-concept-illustration_114360-7561.jpg?w=740&t=st=1665382211~exp=1665382811~hmac=3bc693b7d2a79f623559c64132a31bd30346a9b2c1c7b13c5af876683379c1cf" alt="alt" style="width: 100%; height: calc(100vh - 66px);object-fit: contain"/>
                </div>
            </div>
        </section>
        

        <script src="https://kit.fontawesome.com/7562df3d9f.js" crossorigin="anonymous"></script>
        <script src="assets/js/home_page.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>
</html>


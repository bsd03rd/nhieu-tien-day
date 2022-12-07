<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="assets/css/login.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Montserrat:wght@400;500;600;700;800;900&display=swap');
        </style>
        <title>Change Password</title>
    </head>

    <body>
        <div class="d-flex justify-content-center vh-100 align-items-center">
            <div style="width: 300px;height: 400px; margin-bottom: 200px;">
                <div class="d-flex justify-content-center">
                    <i class="fa-solid fa-key my-3" style="padding: 14px; background-color: #f4eafe; color: #7f55da; border-radius: 30px; font-size: 20px;"></i>
                </div>
                <form action="changepassword" method="post">
                    <h3 class="text-center mb-3">Set a new password?</h3>
                    <p style="font-size: 14px; color: rgba( 0, 0, 0, 0.5); font-weight: 500;" class="text-center my-3">Your new password must be different to previously used password.</p>
                    <label for="oldpass"  class="form-label" style="font-size: 14px; font-weight: 500; color: rgba(0, 0, 0, 0.7)">Old password</label>
                    <input type="password" name="old-password" class="form-control form-control-sm w-100 mb-3" placeholder="Enter your old password">

                    <label for="newpass"  class="form-label" style="font-size: 14px; font-weight: 500; color: rgba(0, 0, 0, 0.7)">New password</label>
                    <input type="password" name="new-password" class="form-control form-control-sm w-100 mb-3" placeholder="Enter your new password">

                    <label for="newpass"  class="form-label" style="font-size: 14px; font-weight: 500; color: rgba(0, 0, 0, 0.7)">Confirm new password</label>
                    <input type="password" class="form-control form-control-sm w-100 mb-3" placeholder="Enter your new password again">
                    
                    <p class="text-center text-danger">${result}</p>
                    <button class="btn btn-info w-100 mb-4" style="font-size: 14px; color: white; font-weight: 500; background-color: #7f55da; border: #7f55da;" type="submit">Reset password</button>
                </form>

                <a href="login" class="text-center d-flex align-items-center justify-content-center" style="color:rgba(0, 0, 0, 0.5); font-size: 14px; font-weight: 500; text-decoration: none;"><i class="fa-solid fa-arrow-left me-2 text-center"></i>Back to log in</a>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>

</html>
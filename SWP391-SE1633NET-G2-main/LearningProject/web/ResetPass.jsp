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
        <title>Reset Password</title>
    </head>

    <body>
        <div class="d-flex justify-content-center vh-100 align-items-center">
            <div style="width: 300px;height: 400px; margin-bottom: 200px;">
                <div class="d-flex justify-content-center">
                    <i class="fa-solid fa-key my-3" style="padding: 14px; background-color: #f4eafe; color: #7f55da; border-radius: 30px; font-size: 20px;"></i>
                </div>
                <h3 class="text-center mb-3">Set a new password?</h3>
                <p style="font-size: 14px; color: rgba( 0, 0, 0, 0.5); font-weight: 500;" class="text-center my-3">Your new password must be different to previously used password.</p>
                <form action="resetpass" method="POST">
                    <label for="password"  class="form-label"  style="font-size: 14px; font-weight: 500; color: rgba(0, 0, 0, 0.7)">Password</label>
                    <input type="password" id="password" name="password" onkeyup="validate_password()" class="form-control form-control-sm w-100 mb-3" placeholder="Enter your new password">
                    <label for="password"  class="form-label" style="font-size: 14px; font-weight: 500; color: rgba(0, 0, 0, 0.7)">Confirm password</label>
                    <input type="password" id="confirm_password" onkeyup="validate_password()" class="form-control form-control-sm w-100 mb-3" placeholder="Enter your new password">
                    <p style="color:red">${status}</p>
                    <span id="wrong_pass_alert"></span>
                    <input type="submit" class="btn btn-info w-100 mb-4 btnLogin" id="create" disabled="true" style="font-size: 14px; color: white; font-weight: 500; background-color: #7f55da; border: #7f55da;">
                    <input type="hidden" name="token" value="${requestScope.token}">      
                </form>
                <p class="text-center" style="color:rgba(0, 0, 0, 0.5); font-size: 14px; font-weight: 500;"><i class="fa-solid fa-arrow-left me-2"></i><a href="login">Back to log in</a></p>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>
    <script>
        function validate_password() {
            var pass = document.getElementById('password').value;
            var confirm_pass = document.getElementById('confirm_password').value;
            if (pass != confirm_pass && pass!=='') {
                document.getElementById('wrong_pass_alert').style.color = 'red';
                document.getElementById('wrong_pass_alert').innerHTML
                        = 'Use same password';
                document.getElementById('create').disabled = true;
                document.getElementById('create').style.opacity = (0.4);
            } else {
                document.getElementById('wrong_pass_alert').style.color = 'green';
                document.getElementById('wrong_pass_alert').innerHTML =
                        'Password Matched';
                document.getElementById('create').disabled = false;
                document.getElementById('create').style.opacity = (1);
            }
        }

    </script>
</html>
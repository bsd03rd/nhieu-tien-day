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
        <title>Mentor sign up</title>
    </head>

    <body style="background-color: #E3E7EB;">
        <div class="container vh-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-xl-10 h-100 py-4">
                    <div class="card h-100 shadow" style="border-radius: 8px; overflow: hidden;">
                        <div class="row h-100">
                            <div class="col-lg-6 h-100">
                                <img src="assets/img/becomementor.jpg" alt="" class="w-100 h-100" style="object-fit: cover;">
                            </div>
                            <div class="col-lg-6">
                                <div class="h-100">
                                    <div class="card-body h-100 d-flex justify-content-between align-items-center">
                                        <div class="icon-test" style="position: absolute; top: 20px; left: 20px;">
                                            <i class="fa-solid fa-circle-chevron-left" style="font-size: 24px; transition: 0.2s;"></i>
                                        </div>
                                        <div class="col-md-12 px-3">
                                            <div class="text-start px-5">   
                                                <h2>Become a mentor</h2>
                                            </div>
                                            <div class="text-start mb-4 px-5">
                                                <p style="opacity: 0.8;">Start now and become our mentor</p>
                                            </div>

                                            <form action="becomementor" method="post">
                                                <div class="px-5 my-3">
                                                    <label for="Username">Username</label>
                                                    <input type="text" class="form-control" placeholder="Enter your username" name="username" required="true">
                                                </div>
                                                <div class="px-5 my-3">
                                                    <label for="Password">Password</label>
                                                    <input type="password" class="form-control"placeholder="Enter your password" name="password" required="true">
                                                </div>
                                                <div class="px-5 my-3">
                                                    <label for="Re-password">Re-password</label>
                                                    <input type="password" class="form-control" placeholder="Enter your re-password" name="cfpassword" required="true">
                                                </div>
                                                <div class="px-5 my-3">
                                                    <label for="DoB">Date of Birth</label>
                                                    <input type="date" class="form-control" placeholder="Enter your date of birth" name="dob" required="true">
                                                </div>
                                                <div class="px-5 my-3">
                                                    <label for="BankAccount">Bank account number</label>
                                                    <input type="text" class="form-control" placeholder="Enter your bank account number" name="banknumber" required="true">
                                                </div>
                                                <div class="px-5 my-3">
                                                    <label for="Bank">Bank</label>
                                                    <input type="text" class="form-control" placeholder="Enter your bank name" name="bankname" required="true">
                                                </div>

                                                <div class="px-5 my-3">
                                                    <button type="submit" class="btn btn-dark w-100 fs-6">SIGN UP</button>
                                                </div>
                                            </form>

                                            <div class="px-5 text-center ">
                                                <p>Already have an account ? <a href="" class="bold">Sign In</a></p>
                                            </div>
                                            
                                            <div class="px-5 text-danger text-center" style="margin-bottom: 20px">${result}</div>
                                        </div>

                                    </div>
                                </div>

                            </div>



                        </div>


                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>

</html>
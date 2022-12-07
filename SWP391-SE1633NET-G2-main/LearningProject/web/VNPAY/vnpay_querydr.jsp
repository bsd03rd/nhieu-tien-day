<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>qerydr</title>
        <!-- Bootstrap core CSS -->
       <!-- Bootstrap core CSS -->
        <link href="../vnpay_jsp/assets/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- Custom styles for this template -->
        <link href="../vnpay_jsp/assets/jumbotron-narrow.css" rel="stylesheet">    
        <link href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css" rel="stylesheet">
        <script src="../vnpay_jsp/assets/jquery-1.11.3.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>

    <body>

        <div class="container">
            <div class="header clearfix">

                <h3 class="text-muted">VNPAY DEMO</h3>
            </div>
            <h3>Query</h3>
            <div class="table-responsive">
            <form action="/vnpay_jsp/vnpayquery" id="frmQerydr" method="Get">
                <div class="form-group">
                <label for="order_id">OrderId</label>
                <input class="form-control" id="order_id"
                       name="order_id" type="text"/>
                </div>
                <div class="form-group">
                <label for="trans_date">Payment Date</label>
                <input class="form-control" id="trans_date"
                       name="trans_date" type="text" placeholder="yyyyMMddHHmmss"/>
            </div>
                <div class="form-group">
                <button type="submit" class="btn btn-primary">QueryDr</button>
            </div>
            </form>   
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2017</p>
            </footer>
        </div> 
        </div>
    </body>
</html>

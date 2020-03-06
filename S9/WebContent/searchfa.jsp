
<%


String date=(String)request.getAttribute("date");
String name=(String )request.getAttribute("name");
%>




<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Coustard">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body style="background-image:url(&quot;assets/img/lib.jpg&quot;);background-size:cover;background-position:center;background-repeat:no-repeat;">
    <div class="highlight-clean" style="margin:150px;margin-top:120px;width:50%;height:620px;margin-bottom:219px;margin-right:219px;margin-left:28%;">
        <div class="container">
            <div class="intro">
                
                
                <p align="center">
               <font  color="red"><b>
                Sorry we are out of your Request.....!!!!!!!!<br>
                <br>Your Requested Book will be Available from :<%=date %>
                </b></font>
                </p>
            </div>
            <div class="buttons"><a class="btn btn-outline-primary" role="button" href="booksearch.html">search Other</a></div>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>
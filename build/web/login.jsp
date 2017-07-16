<%-- 
    Document   : login
    Created on : May 22, 2017, 12:18:00 PM
    Author     : Savinda Keshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remember Me - Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css" rel="stylesheet">
    </head>
    <body style="background: url('images/background1.png') no-repeat center center fixed;-moz-background-size: cover;-webkit-background-size: cover;-o-background-size: cover;background-size: cover;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-4">
                        </div>
                        <div class="col-md-4" style="margin-top: 120px;">
                            <div class="col-md-12" style="padding: 60px; background-color: white; margin-top:30px; box-shadow: 5px 5px 3px #888888;">
                                <div><img src="images/logo.png" width="100%"/></div>
                                <div class="row">
                                    <div class="form-group" style="margin-top: 30px">
                                        <input type="email" class="form-control" id="email" placeholder="Enter email" onchange="checkEmail()" style="color: #489FDF;"/>
                                        <small id="emailHelp" class="form-text text-muted"></small>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="password" placeholder="Enter password." onchange="checkPassword()" style="color: #489FDF;"/>
                                        <small id="passwordHelp" class="form-text text-muted"></small>
                                    </div>
                                    <button class="btn btn-block" onclick="login();" style="background-color:#489FDF; color: white;">
                                        Login
                                    </button>
                                    <p class="form-text text-muted" style="margin-top: 10px">Not Registered? <a href="signup.jsp">Create an account</a></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                        </div>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/login.js"></script>
    </body>
</html>

<%-- 
    Document   : index.jsp
    Created on : May 22, 2017, 12:11:50 PM
    Author     : Savinda Keshan
--%>

<%@page import="Beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sessionUser = request.getSession(false);
    String email = (String) sessionUser.getAttribute("email");
    if (email == null) {
        response.sendRedirect("/RememberMe/login.jsp");
    }

    User user = new User();
    user.getUser(email);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid" style="background-color: #F5F5F5;">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
                        <div class="navbar-header">

                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button> <a class="navbar-brand" href="#">Brand</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="#">Link</a>
                                </li>
                            </ul>
                        </div>

                    </nav>
                </div>
            </div>
            <div class="row" style="margin-top: 100px;">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-1">
                        </div>
                        <div class="col-md-10">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="row" style="margin-top: 20px; padding: 20px; background-color: white; border-bottom-color: gray; border-radius: 5px;">
                                        <div class="col-md-12">

                                            <button type="button" class="btn btn-default btn-block">
                                                Default
                                            </button>
                                        </div>
                                    </div>
                                    <div class="row" style="margin-top: 20px; padding: 20px; background-color: white;">
                                        <div class="col-md-12">

                                            <a class="btn btn-block btn-social btn-twitter">
                                                <span class="fa fa-twitter"></span> Sign in with Twitter
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="row" style="margin-top: 20px; margin-left: 20px; margin-bottom: 20px; padding: 20px; background-color: white; border-bottom-color: gray; border-radius: 5px;">
                                        <div class="col-md-12">
                                            <form role="form">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">
                                                        Email address
                                                    </label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" />
                                                </div>
                                                <div class="form-group">

                                                    <label for="exampleInputPassword1">
                                                        Password
                                                    </label>
                                                    <input type="password" class="form-control" id="exampleInputPassword1" />
                                                </div>
                                                <button type="submit" class="btn btn-default">
                                                    Submit
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <h1>Hello! <%out.println(user.getName());%></h1>
        <form action="Logout" method="post">
            <input type="submit" name="logout" value="logout">
        </form>
        <br><br>
        <form action="GeneratePassword" method="post">
            <input type="hidden" name="user_email" value="<%out.print(email);%>">
            <input type="submit" name="genPassword" value="gen password">
        </form>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

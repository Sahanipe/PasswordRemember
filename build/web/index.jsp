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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css" rel="stylesheet">
    </head>
    <body style="background-color: #f7f6f6;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color: #489FDF;">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#" style="color:white">Remember Me</a>
                            </div>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#" style="color: white;"><b>Hello! <%out.println(user.getName());%></b></a></li>
                                <li><a href="Logout" style="color: white; "><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
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
                                <div class="col-md-5">
                                    <div class="row" style="margin-top: 20px; padding: 20px; background-color: white; border-radius: 5px; box-shadow: 2px 2px 1px #888888;">
                                        <div class="col-md-12">

                                            <button type="button" class="btn btn-block" onclick="generatePwd('<%out.print(email);%>')" style="background-color: #69b6ee; color: white;"><b>Generate new password</b></button>
                                            <button type="button" class="btn btn-block" onclick="addCustomQs('<%out.print(email);%>');" style="background-color: #489FDF; color: white;"><b>Add new custom question</b></button>
<!--                                            <button type="button" class="btn btn-block" style="background-color: #3786c0; color: white;"><b>Btn</b></button>
                                            <button type="button" class="btn btn-block" style="background-color: #2b79b2; color: white;">Btn</button>-->
                                        </div>
                                    </div>
                                    <div class="row" style="margin-top: 20px; margin-bottom: 20px; padding: 20px; background-color: white; border-radius: 5px; box-shadow: 2px 2px 1px #888888;">
                                        <div class="col-md-12">

                                            <a class="btn btn-block btn-social btn-twitter">
                                                <span class="fa fa-twitter"></span> Sign in with Twitter
                                            </a>
                                            <a class="btn btn-block btn-social btn-adn">
                                                <span class="fa fa-adn"></span> Sign in with Twitter
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7">
                                    <div class="row" style="margin-top: 20px; margin-left: 20px; margin-bottom: 20px; padding: 20px; background-color: white; border-bottom-color: gray; border-radius: 5px; box-shadow: 2px 2px 1px #888888;">
                                        <div class="col-md-12" id="displayDiv">
                                            <h3 style="color: #489FDF;">Add new Custom question</h3>
                                            <div style="margin-top: 30px; margin-bottom: 20px;">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="customQs" placeholder="Enter custom question.." onchange="changeQs();" style="color: #489FDF;"/>
                                                    <small id="questionHelp" class="form-text text-muted"></small>
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="customQsAns" placeholder="Enter answer.." onchange="changeAns();" style="color: #489FDF;"/>
                                                    <small id="answerHelp" class="form-text text-muted">Give single word answer.</small>
                                                </div>
                                                <button class="btn btn-block" onclick="submitCustomQs('<%out.print(email);%>');" style="background-color:#489FDF; color: white;">
                                                    Submit
                                                </button>
                                            </div>
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
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/validate.js"></script>
        <script src="js/home.js"></script>
    </body>
</html>

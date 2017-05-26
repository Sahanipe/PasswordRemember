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
    if(email==null){
        response.sendRedirect("/RememberMe/login.jsp");
    }
    
    User user = new User();
    user.getUser(email);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello! <%out.println(user.getName());%></h1>
        <form action="Logout" method="post">
            <input type="submit" name="logout" value="logout">
        </form>
        <br><br>
        <form action="GeneratePassword" method="post">
            <input type="hidden" name="user_email" value="<%out.print(email);%>">
            <input type="submit" name="genPassword" value="gen password">
        </form>
    </body>
</html>

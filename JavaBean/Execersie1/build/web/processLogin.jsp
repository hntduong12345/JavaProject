<%-- 
    Document   : processLogin
    Created on : Mar 11, 2023, 2:01:29 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing</title>
    </head>
    <body>
        <h1>Process Login</h1>
        <jsp:useBean id="loginAtt" class="sample.javabeans.LoginBean" scope="session"></jsp:useBean>
        <jsp:setProperty name="loginAtt" property="*"></jsp:setProperty>
        
        <%
            if(loginAtt.checkLogin()){
                response.sendRedirect("welcome.jsp");
            }
            else{
                out.println("Invalid username or password!!!");
            }
        %>
    </body>
</html>

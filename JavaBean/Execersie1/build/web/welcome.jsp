<%-- 
    Document   : welcome
    Created on : Mar 11, 2023, 2:07:00 PM
    Author     : ASUS
--%>

<%@page import="sample.javabeans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="loginAtt" class="sample.javabeans.LoginBean" scope="session"></jsp:useBean>
        
        <font color='blue'>
            Welcome, 
        <jsp:getProperty name="loginAtt" property="username"></jsp:getProperty>
        </font>
        <br/>
        
        <font color='red'>
            Welcome, 
        <%= ((LoginBean) session.getAttribute("loginAtt")).getUsername() %>
        </font>
        <br/>
        
        <form action="welcome.jsp">
            Name <input type="text" name="txtName" value="" /><br/>
            <input type="submit" value="Search" />
        </form>
    </body>
</html>

<%-- 
    Document   : Login
    Created on : Jan 12, 2023, 10:53:09 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>LOGIN PAGE</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        table{
            margin: 0px auto;
            border: solid black 2px;
            padding: 1%;
            border-radius: 10px;
            margin-top: 3%;
        }
        .btn {
            text-align: center;
        }
        input{
            margin-top: 10px;
        }
        button{
            margin-top: 10px;
        }
        .regist{
            text-align: center;
            margin-top: 2%;
        }
    </style>
</head>

<body>
    <h1>
        <center>LOGIN</center>
    </h1>
    
    <!--Print Login Error-->
    <c:set var="error" value="${requestScope.ERROR}"></c:set>
    <c:if test="${not empty error}">
        <center>
            <font color="red">
                ${error.authorizationError}
            </font>
        </center>
    </c:if> 
    
    <!--Form for inserting username and password-->
    <table>
        <form action="MainServlet" method="POST">
            <tr>
                <td><input type="text" name="txtUsername" placeholder="Username"></td>
            </tr>
            <tr>
                <td><input type="password" name="txtPassword" placeholder="Password"></td>
            </tr>
            <tr>
                <td class="btn"><button type="submit" name="btAction" value="Login">Login</button></td>
            </tr>
        </form>
    </table>
    <div class="regist">Don't have account? <a href="register.jsp">Sign In</a></div>
</body>
</html>

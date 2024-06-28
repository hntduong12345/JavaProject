<%-- 
    Document   : HomePage
    Created on : Jan 12, 2023, 10:54:36 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HOME PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .header{
                background-color: black;
                color: white;
                overflow: hidden;
            }
            .header p, .header form{
                display: inline-block;
            }
            .header p{
                padding-left: 2%;
            }
            .header form{
                float: right;
                padding: 1% 0px;
                padding-right: 2%;
            }
        </style>
    </head>
    <body>
        <h1><center>HOME PAGE</center></h1>

        <div class="header">
            <p>Welcome to our page</p>
            <form action="register.jsp">
                <button type="submit">Register</button>
            </form>
            <form action="login.jsp">
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>

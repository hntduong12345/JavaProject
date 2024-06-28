<%-- 
    Document   : Welcome
    Created on : Jan 10, 2023, 3:08:19 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>

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
        <p><center>TEST PAGE</center></p>
        <div class="header">
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = "";
            for (Cookie cookie : cookies) {
                String temp = cookie.getName();
                if (!temp.equals("JSESSIONID")) {
                    username = temp;
                }
            }
            if (username.isEmpty()) {
                response.sendRedirect("error.jsp");//need modified
            }
    %>
            <font color="white">
                <p>Welcome, <%= username%></p>
            </font>
    <%
        }
    %>
            <form action="MainServlet">
                <button type="submit" name="btAction" value="Logout">Log out</button>
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : Update
    Created on : Jan 25, 2023, 1:18:46 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Information Page</title>
        <style>
            table{
                margin: 0px auto;
                border: solid black 2px;
                padding: 1%;
                border-radius: 10px;
                margin-top: 3%;
            }
            .btn {
                text-align: left;
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
        <h1><center>UPDATE INFORMATION</center></h1>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
        %>
        <table>
            <form action="MainServlet" method="POST">
                <input type="hidden" name="lastUsername" value="<%= username%>">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="txtUsername" value="<%= username%>"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="txtPassword" value="<%= password%>"></td>
                </tr>
                <tr>
                    <td>Full name</td>
                    <td><input type="text" name="txtFullname" value="<%= fullname%>"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="txtEmail" value="<%= email%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="btn"><button type="submit" name="btAction" value="Update">Update</button></td>
                </tr>
            </form>
        </table>
    </body>
</html>

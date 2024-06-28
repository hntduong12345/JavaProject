<%-- 
    Document   : Register
    Created on : Jan 12, 2023, 10:53:52 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>REGISTER PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            table {
                margin: 0px auto;
                border: solid black 2px;
                padding: 1% 3%;
                border-radius: 10px;
                margin-top: 3%;
            }

            .btn {
                text-align: center;
            }

            input {
                margin-top: 10px;
            }

            button {
                margin-top: 10px;
            }
        </style>
    </head>

    <body>
        <h1>
            <center>SIGN IN</center>
        </h1>
        <c:set var="error" value="${requestScope.ERROR}"/>

        <c:if test="${not empty error.dupplicatedUsernameError}">
        <center>
            <font color="red">
            ${error.dupplicatedUsernameError}
            </font>
        </center>
    </c:if>

    <!--Register form-->
    <table>
        <form action="MainServlet" method="POST">
            <!--Username-->
            <tr>
                Username*: (5 - 20 characters)
            </tr>
            <tr>
                <td>
                    <input type="text" name="txtUsername" placeholder="Username">
                </td>
            </tr>
            <tr>
                <c:if test="${not empty error.usernameLengthError}">
                    <center>
                        <font color="red">
                        ${error.usernameLengthError}
                        </font>
                    </center>
                </c:if>
            </tr>
            <!--Password-->
            <tr>
                Password*: (Must have at least 1 uppercase, lowercase, number and special character)
            </tr>
            <tr>
                <td>
                    <input type="password" name="txtPassword" placeholder="Password">
                </td>
            </tr>
            <tr>
                <c:if test="${not empty error.passwordFormatError}">
                    <center>
                        <font color="red">
                        ${error.passwordFormatError}
                        </font>
                    </center>
                </c:if>
            </tr>
            <!--Confirm Password-->
            <tr>
                Confirm Password:
            </tr>
            <tr>
                <td>
                    <input type="password" name="txtRepeatPass" placeholder="Repeat Password">
                </td>
            </tr>
            <tr>
                <c:if test="${not empty error.confirmError}">
                    <center>
                        <font color="red">
                        ${error.confirmError}
                        </font>
                    </center>
                </c:if>
            </tr>
            <!--Full Name-->
            <tr>
                Full Name:
            </tr>
            <tr>
                <td>
                    <input type="text" name="txtFullname" placeholder="Fullname">
                </td>
            </tr>
            <tr>
                <c:if test="${not empty error.fullNameLengthError}">
                    <center>
                        <font color="red">
                        ${error.fullNameLengthError}
                        </font>
                    </center>
                </c:if>
            </tr>
            <!--Email-->
            <tr>
                Email:
            </tr>
            <tr>
                <td>
                    <input type="text" name="txtEmail" placeholder="Email">
                </td>
            </tr>
            <tr>
                <c:if test="${not empty error.emailError}">
                    <center>
                        <font color="red">
                        ${error.emailError}
                        </font>
                    </center>
                </c:if>
            </tr>
            <!--Register Button-->
            <tr>
                <td class="btn"><button type="submit" name="btAction" value="Register">Sign In</button></td>
            </tr>
        </form>
    </table>
</body>
</html>

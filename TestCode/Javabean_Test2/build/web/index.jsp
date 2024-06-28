<%-- 
    Document   : index
    Created on : Mar 11, 2023, 1:24:17 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EL Expression</h1>
        <table border="1">
            <tr>
                <td>Concept</td>
                <td>Expression</td>
                <td>Result</td>
            </tr>
            <tr>
                <td>Literal</td>
                <td>${"${"}10}</td>
                <td>${10}</td>
            </tr>
            <tr>
                <td>Addition</td>
                <td>${"${"}10 + 10}</td>
                <td>${10 + 10}</td>
            </tr>
            <tr>
                <td>Subtraction</td>
                <td>${"${"}10 - 10}</td>
                <td>${10 - 10}</td>
            </tr>
            <tr>
                <td>Multiplication</td>
                <td>${"${"}10 * 10}</td>
                <td>${10 * 10}</td>
            </tr>
            <tr>
                <td>Division</td>
                <td>${"${"}10 / 3}</td>
                <td>${10 / 3}</td>
            </tr>
            <tr>
                <td>Modulus</td>
                <td>${"${"}10 % 3}</td>
                <td>${10 % 3}</td>
            </tr>
            <tr>
                <td>Divided by Zero</td>
                <td>${"${"}10 / 0}</td>
                <td>${10 / 0}</td>
            </tr>
            <tr>
                <td>Exponential</td>
                <td>${"${"}2E2}</td>
                <td>${2E2}</td>
            </tr>
            <tr>
                <td>Unary Binary</td>
                <td>${"${"}-10}</td>
                <td>${-10}</td>
            </tr>
        </table>
                <jsp:forward page="practice1.jsp"></jsp:forward>
    </body>
</html>

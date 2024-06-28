<%-- 
    Document   : index
    Created on : Feb 23, 2023, 7:37:53 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie Test Page</title>
    </head>
    <body>
        <h1>Cookie Test!</h1>
        <form action="AddCookieServlet">
            Name <input type="text" name="txtName" value="" /><br/>
            <input type="submit" value="Submit" name="btAction" />
        </form>
    </body>
</html>

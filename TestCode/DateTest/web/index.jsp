<%-- 
    Document   : index
    Created on : Mar 1, 2023, 3:27:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <h1>TEST PAGE</h1>
        <form action="DateCheckController">
            Today time <input type="date" id="date">

            <input type="submit" value="Check" name="btAction" />
        </form>
        
    </body>
</html>

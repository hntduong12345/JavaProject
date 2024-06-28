<%-- 
    Document   : index
    Created on : Feb 26, 2023, 8:05:16 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store Page</title>
    </head>
    <body>
        <h1>Welcome To Book Store</h1>
        <br/>
        <form action="Controller">
        Choose book 
            <select name="books">
                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
                <option>E</option>
                <option>F</option>
                <option>G</option>
            </select><br/>
            <input type="submit" value="Add Book To Your Cart" name="btAction" />
            <input type="submit" value="View Your Cart" name="btAction" />
        </form>
    </body>
</html>

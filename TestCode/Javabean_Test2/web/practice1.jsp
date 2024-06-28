<%-- 
    Document   : practice1
    Created on : Mar 11, 2023, 1:43:36 PM
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
        <form method="POST">
            Num 1 <input type="text" name="num1" value="${param.num1}" /><br/>
            Num 2 <input type="text" name="num2" value="${param.num2}" /><br/>
            Total: ${param["num1"] + param.num2}<br/>
            Avg: ${(param.num1 + param["num2"])/2}<br/>
            <input type="submit" value="calculate" />
        </form>
    </body>
</html>

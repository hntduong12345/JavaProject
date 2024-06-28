<%-- 
    Document   : index
    Created on : Mar 11, 2023, 12:46:57 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <jsp:forward page="second.jsp" >
            <jsp:param name="username" value="ALO GAU GAU"></jsp:param>
            <jsp:param name="password" value="12345"></jsp:param>
        </jsp:forward>
    </body>
</html>

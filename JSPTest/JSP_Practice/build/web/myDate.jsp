<%-- 
    Document   : myDate
    Created on : Feb 15, 2023, 1:12:02 PM
    Author     : ASUS
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= new Date().toLocaleString()%>
    </body>
</html>

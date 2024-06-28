<%-- 
    Document   : implicitObject
    Created on : Feb 15, 2023, 2:02:57 PM
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
        <h1>Request - Response - Out Object</h1>
        <%
            response.setDateHeader("Expired", 0);
            response.setHeader("Pragma", "no-cache");
            if(request.getProtocol().equals("HTTP/1.1")){
                response.setHeader("Cache-Control", "no-cache");
                out.println("<b>The protocol used is: "+request.getProtocol());
            }
        %>
    </body>
</html>

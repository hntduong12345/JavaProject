<%-- 
    Document   : scriptletExpression
    Created on : Feb 15, 2023, 1:46:51 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Complex Expression Example</title>
    </head>
    <%
        String bgColor = request.getParameter("bgColor");
        boolean hasExplicitColor;
        if (bgColor != null) {
            hasExplicitColor = true;
        } else {
            hasExplicitColor = false;
            bgColor = "white";
        }
    %>
    <body bgColor="<%= bgColor%>">
    <center>
        <h1>Color Testing</h1>
        <%
            if(hasExplicitColor){
                out.println("Explicit color: " + bgColor);
            }else{
                out.println("Using default color");
            }
        %>
    </center>
    </body>
</html>

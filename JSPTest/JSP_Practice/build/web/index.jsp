<%-- 
    Document   : index
    Created on : Feb 15, 2023, 1:03:10 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page errorPage="error.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!String name;%>
        <%
            name = request.getParameter("name");
            if (name == null) {
                name = "World";
            }
        %>

        <h1>Hello, <%=name%></h1>
        <% out.println("<h1>Hello" + name + "</h1>");%>
        <% int num = Integer.parseInt("a");%>
    </body>
</html>

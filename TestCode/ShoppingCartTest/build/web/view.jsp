<%-- 
    Document   : view
    Created on : Feb 26, 2023, 10:38:57 AM
    Author     : ASUS
--%>

<%@page import="java.util.Map"%>
<%@page import="models.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>YOUR CART:</h1>

        <%
            if (session != null) {
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                if (cart != null) {
                    if (cart.getItems() != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action="Controller">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 1;
                    for (Map.Entry item : items.entrySet()) {
                %>

                <tr>
                    <td><%=count%></td>
                    <td><%= item.getKey()%></td>
                    <td><%= item.getValue()%></td>
                    <td>
                        <input type="checkbox" name="chkItem" value="<%=item.getKey()%>"/>
                    </td>
                </tr>

                <%
                    }
                %>

                <tr>
                    <td colspan="3">
                        <a href="index.jsp">Add more item  to your Cart</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove Selected Items" name="btAction">
                    </td>
                </tr>
            </form>
        </tbody>
    </table>

    <%              return;
                }
            }
        }
    %>
    
    <h2>No cart is existed</h2>
</body>
</html>

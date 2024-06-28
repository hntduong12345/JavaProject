<%-- 
    Document   : viewCart
    Created on : Mar 1, 2023, 1:19:53 PM
    Author     : ASUS
--%>

<%@page import="java.util.Map"%>
<%@page import="duonghnt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Cart Contains:</h1>
        <%
            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("CART");

                if (cart != null) {
                    if (cart.getItems() != null) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 0;
                    for (Map.Entry item : items.entrySet()) {
                %>
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= item.getKey()%>
                    </td>
                    <td>
                        <%= item.getValue()%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkItem" value="<%= item.getKey()%>" />
                    </td>
                </tr>
                <%
                    }//end for each.
                %>
                <tr>
                    <td colspan="3">
                        <a href="bookStore.html">Add more items to cart</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove Items" name="btAction" />
                    </td>
                </tr>
            </form>
        </tbody>
    </table>


    <%
    }//end get items
    else {
    %>
    <font color="orange"><b>EMPTY CART!</b></font><br/>
    <a href="bookStore.html">Add items to cart</a>
    <%
                }
            }//end cart
        }//end session
    %>
    <form action="login.html">
        <input type="submit" value="Quit" />
    </form>
</body>
</html>

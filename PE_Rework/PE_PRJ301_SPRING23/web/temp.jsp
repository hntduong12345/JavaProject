<%-- 
    Document   : temp
    Created on : Apr 1, 2023, 8:11:16 AM
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
        <%
            String action = request.getParameter("action");
            if (action != null) {
                List<Product> products = (List<Product>) request.getAttribute("LIST");
                if (products != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Add</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Product product : products) {
                        int count = 0;
                %>  
            <form action="MainController">
                <tr>
                    <td><%= ++count%></td>
                    <td>
                        <%= product.getProductID()%>
                        <input type="hidden" name="productID" value="<%= product.getProductID()%>" />
                    </td>
                    <td>
                        <%= product.getProductName()%>
                        <input type="hidden" name="productName" value="<%= product.getProductName()%>" />
                    </td>
                    <td>
                        <%= product.getDescription()%>
                        <input type="hidden" name="description" value="<%= product.getDescription()%>" />
                    </td>
                    <td>
                        <%= product.getPrice()%>
                        <input type="hidden" name="price" value="<%= product.getPrice()%>" />
                    </td>
                    <td>
                        <input type="submit" value="Add" name="action" />
                    </td>
                </tr>
            </form>
                <%
                    }
                %>
            </tbody>
        </table>

        <%
        } else {
        %>
        <h2>NO PRODUCT FOUND</h2>
        <%
                }
            }
        %>
        
        
        <!--SHOW ADD NOTE-->
        <%
            String addAction = request.getParameter("addAction");
            if(addAction!=null){
                Product product = (Product) request.getAttribute("ADDEDPRODUCT");
        %>      
        Added <%= product.getProductName() %> - 1 cái - <%= product.getPrice() %>
        <%        
            }
        %>
    </body>
</html>

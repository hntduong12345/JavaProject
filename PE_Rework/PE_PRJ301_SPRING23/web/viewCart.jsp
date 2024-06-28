<%-- 
    Document   : viewCart
    Created on : Feb 28, 2023, 9:07:46 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="pe.spring23.shopping.CART"%>
<%@page import="pe.spring23.shopping.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Shopping cart</h1>
        <!--your code here--> 
        <c:set var="products" value="${requestScope.LIST}"/>
        <c:if test="${not empty products}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}" varStatus="counter">
                    <form action="MainController">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${product.productID}
                                <input type="hidden" name="productID" value="${product.productID}" />
                            </td>
                            <td>
                                ${product.productName}
                                <input type="hidden" name="productName" value="${product.productName}" />
                            </td>
                            <td>
                                ${product.description}
                                <input type="hidden" name="description" value="${product.description}" />
                            </td>
                            <td>
                                ${product.price}
                                <input type="hidden" name="price" value="${product.price}" />
                            </td>
                            <td>
                                <input type="text" name="quantity" value="${product.quantity}" />
                            </td>
                            <td>
                                ${product.total}
                            </td>
                            <td>
                                <input type="submit" value="Update" name="action" />
                            </td>
                        </tr>
                    </form>
                    </c:forEach>
                </tbody>
            </table>
            <c:set var="totalPrice" value="${CART.total()}"/>
            <h1><b>Total: ${totalPrice} Triệu</b></h1>
        </c:if>
        <br/>
        
        <!--ADD MORE FUNCTION-->
        <c:url var="addMore" value="MainController">
            <c:param name="action" value="Search all"/>
        </c:url>
        <a href="${addMore}">Add More</a>
    </body>
</html>

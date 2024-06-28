<%-- 
    Document   : index
    Created on : Feb 28, 2023, 9:01:26 PM
    Author     : Hoadnt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="pe.spring23.shopping.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Welcome to Thinh's shop</h1>
        <!--your code here-->
        <form action="MainController">
            <input type="submit" value="Search all" name="action" />
            <input type="submit" value="View cart" name="action" />
        </form>

        <!--SHOW TABLE OF PRODUCTS-->
        <c:set var="action" value="${param.action}"/>
        <c:if test="${not empty action}">
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
                            <th>Add</th>
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
                                    <input type="submit" value="Add" name="action" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
        
    <!--SHOW NOTIFICATION-->
    <c:set var="addAction" value="${param.addAction}"/>
    <c:if test="${not empty addAction}">
        <c:set var="addedProduct" value="${requestScope.ADDEDPRODUCT}"/>
        Added ${addedProduct.productName} - 1 cái - ${addedProduct.price}
    </c:if>
</body>
</html>

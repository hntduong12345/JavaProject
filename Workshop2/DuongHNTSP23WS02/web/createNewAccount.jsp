<%-- 
    Document   : createNewAccount
    Created on : Mar 15, 2023, 1:17:18 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create new Account</h1><br/>
        
        <form action="MainController">
            <c:set var="errors" value="${requestScope.ERRORS}"/>
            <c:if test="${not empty errors.accountExistedErr}">
                <font color="red">${errors.accountExistedErr}</font>
            </c:if>
            <br/>
            Username: (*)
            <input type="text" name="txtUsername" value="${param.txtUsername}" /> (6 - 20 chars) 
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">${errors.usernameLengthErr}</font>
            </c:if>
            <br/>
            Password: (*)
            <input type="password" name="txtPassword" value="" /> (5 - 20 chars) 
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">${errors.passwordLengthErr}</font>
            </c:if>
            <br/>
            Confirm: (*)
            <input type="password" name="txtConfirm" value="" /> 
            <c:if test="${not empty errors.confirmErr}">
                <font color="red">${errors.confirmErr}</font>
            </c:if>
            <br/>
            Full Name: 
            <input type="text" name="txtFullname" value="${param.txtFullname}" />  (2 - 50 chars) 
            <c:if test="${not empty errors.fullnameLengthErr}">
                <font color="red">${errors.fullnameLengthErr}</font>
            </c:if>
            <br/>
            <input type="submit" value="Create" name="btAction" />
        </form>
    </body>
    </body>
</html>

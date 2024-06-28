<%-- 
    Document   : Admin
    Created on : Jan 14, 2023, 12:12:49 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="sample.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>

        <style>
            .header{
                background-color: black;
                color: white;
                overflow: hidden;
            }
            .header p, .header form{
                display: inline-block;
            }
            .header p{
                padding-left: 2%;
            }
            .header form{
                float: right;
                padding: 1% 0px;
                padding-right: 2%;
            }
        </style>
    </head>
    <body>
        <p><center>ADMINISTRATOR PAGE</center></p>
<div class="header">

    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = "";
            for (Cookie cookie : cookies) {
                String temp = cookie.getName();
                if (!temp.equals("JSESSIONID")) {
                    username = temp;
                }
            }
            if (username.isEmpty()) {
                response.sendRedirect("error.jsp");//need modified
            }
    %>
    <font color="white">
    <p>Welcome, <%= username%></p>
    </font>
    <%
        }
    %>
    <!--Logout-->
    <form action="MainServlet">
        <button type="submit" name="btAction" value="Logout">Log out</button>
    </form>
</div>
<br/>
<div>
    <form action="MainServlet">
        <button type="submit" name="btAction" value="ShowList">Show List</button>
    </form>
</div>

<!--USING SCRIPTLET-->
<!--<%
    String action = request.getParameter("btAction");

    if (action != null) {
        List<UserModel> list = (List<UserModel>) request.getAttribute("userList");

        if (list != null) {
%>
<table border="1">
    <thead>
        <tr>
            <th>No.</th>
            <th>Username</th>
            <th>Password</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
    </thead>
    <tbody>
<%
    int count = 0;
    for (UserModel user : list) {
%>
<tr>
    <td>
<%= ++count%>
</td>
<td>
<%= user.getUsername()%>
</td>
<td>
<%= user.getPassword()%>
</td>
<td>
<%= user.getFullname()%>
</td>
<td>
<%= user.getEmail()%>
</td>
<td>
<form action="MainServlet">
    <input type="hidden" name="removeValue" value="<%= user.getUsername()%>">
    <button type="submit" name="btAction" value="Remove">Delete</button>
</form>
</td>
<td>
<form action="update.jsp">
    <input type="hidden" name="username" value="<%= user.getUsername()%>">
    <input type="hidden" name="password" value="<%= user.getPassword()%>">
    <input type="hidden" name="fullname" value="<%= user.getFullname()%>">
    <input type="hidden" name="email" value="<%= user.getEmail()%>">
    <button type="submit">Update</button>
</form>
</td>
</tr>
<%
    }
%>
</tbody>
</table>
<%
} else {
%>
<h2>Empty</h2>
<%
        }
    }
%>
-->



<!--USING TABLIB-->
<c:set var="showList" value="${param.btAction}"/>
<c:if test="${not empty showList}">
    <c:set var="users" value="${requestScope.userList}"/>
    <c:if test="${not empty users}">
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}" varStatus="counter">
                    <form action="MainServlet">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${user.username}
                                <input type="hidden" name="txtUsername" value="${user.username}" />
                            </td>
                            <td>
                                ${user.password}
                            </td>
                            <td>
                                ${user.fullname}
                            </td>
                            <td>
                                ${user.email}
                            </td>
                            <td>DELETE</td>
                            <td>UPDATE</td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>
</body>
</html>

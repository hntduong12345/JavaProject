<%-- 
    Document   : search
    Created on : Jan 28, 2023, 9:19:44 PM
    Author     : ASUS
--%>

<%@page import="duonghnt.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <font color="red">
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
        %>
        Welcome, <%= username%>
        <%
            }
        %>
        </font>

        <br/><br/>
        <h1>Welcome to Search Page</h1>

        <form action="MainController" method="post">
            Search Value <input type="text" name="txtSearchValue" value=""/><br/>
            <input type="hidden" name="webUsername" value="<%=request.getAttribute("webUsername")%>">
            <input type="submit" name="btAction" value="Search">
        </form>

        <%
            String searchValue = request.getParameter("txtSearchValue");

            if (searchValue != null) {
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");

                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Last name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        StringBuilder deleteURL = new StringBuilder("MainController?btAction=Delete&dUsername=");
                        deleteURL.append(dto.getUsername());
                        deleteURL.append("&lastSearchValue=");
                        deleteURL.append(searchValue);
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getUsername()%>
                    </td>
                    <td>
                        <input type="password" name="txtPassword" value="<%= dto.getPassword()%>" />
                    </td>
                    <td>
                        <input type="text" name="txtLastname" value="<%= dto.getLastname()%>" />
                    </td>

                    <% if (dto.isRole()) { %>
                    <td>
                        <input type="checkbox" name="checkRole" checked="checked" />
                    </td>
                    <% } else { %>
                    <td>
                        <input type="checkbox" name="checkRole" />
                    </td>
                    <%}%>

                    <td>
                        <a href=<%=deleteURL%>>Delete</a>
                    </td>

                    <td>
                        <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>">
                        <input type="hidden" name="lastSearchValue" value="<%=searchValue%>">
                        <input type="submit" name="btAction" value="Update">
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
    <h2>No record is matched!!!</h2>
    <%
            }
        }
    %>

    <form action="login.html">
        <input type="submit" value="Log out" />
    </form>
</body>
</html>

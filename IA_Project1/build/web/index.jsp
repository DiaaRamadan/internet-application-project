<%-- 
    Document   : index
    Created on : Dec 15, 2018, 3:31:48 PM
    Author     : diaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="login-form">
    <h1 class="text-center">User login</h1>
        <form action="loginPage"  class="form-group">
            <input class="form-control" type="text" name="username" placeholder="User name" required="required">
            <input class = "form-control" type="password" name="password" placeholder="Password" required="required">
            <input class = "btn btn-primary"type="submit" value="Register">
     </form>
    <a href="register.jsp">Register</a>
</div>
<%@include file = "footer.jsp" %>

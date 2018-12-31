<%-- 
    Document   : register
    Created on : Dec 15, 2018, 3:02:58 PM
    Author     : diaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="register-form">
    <h1 class="text-center">User login</h1>
        <form action="register" class="form-group">
            <input class="form-control" type="text" name="username" placeholder="User name" required="required">
            <input class="form-control" type="email" name="email" placeholder="Email" required="required">
            <input class="form-control" type="password" name="password" placeholder="Password" required="required">
            <input class="form-control" type="text" name="telephone" placeholder="Your telephone">
            <select name="gender" class="form-control">
                <option value=male>Male</option>
                <option value="female">Female</option>
            </select>
            <input class="btn btn-success" type="submit" value="Register">
        </form>
    </div>
<%@include file="footer.jsp"  %>

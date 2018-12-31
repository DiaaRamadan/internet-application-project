<%-- 
    Document   : makeSure
    Created on : Dec 20, 2018, 10:05:47 PM
    Author     : diaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<% 
   String track_id = request.getParameter("trackid");
   int trackid = Integer.parseInt(track_id);
%>
<h3 class="text-center">Welcome candidate</h3>
<a href='exam.jsp?track_id=<%=trackid%>' class="btn btn-primary">Start Exam</a>

<%@include file="footer.jsp" %>
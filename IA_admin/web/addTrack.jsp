

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="nav.jsp" %>

<h1 class="text-center">Add new track</h1>

<div class="add-track">
    <form class="form-group" action="newTrack">
        <input class="form-control" type="text" name="track" placeholder="Track name">
        <input class="btn btn-primary" type="submit" value="Add">
    </form>
 ${message}    
</div>
<%@include file = "footer.jsp"%>

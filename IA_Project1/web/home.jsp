    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%-- 
    Document   : home
    Created on : Dec 15, 2018, 1:40:44 PM
    Author     : diaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@include file="nav.jsp" %>


<div class="cv-form">
   
    <h1 class="text-center">Upload your CV..</h1>
      
      <form action = "upload" method = "post" enctype = "multipart/form-data">
          <select name="track" class="form-control">
              <% 
                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/IA_Project";
                String user = "root";
                String password = "";

                Connection Con;
                Statement Stmt;
                ResultSet RS = null;

                Con = (Connection) DriverManager.getConnection(url, user, password);
                Stmt = (Statement) Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM Tracks");
                while(RS.next()){
                    
                    out.print("<option value = '"+RS.getInt("T_ID")+"'>");
                    out.print(RS.getString("track"));
                    out.print("</option>");
                }
              %>
          </select>
         <input type = "file" name = "file" size = "50" />
         <br />
         <input class="btn btn-primary" type = "submit" value = "Upload File" />
      </form>
</div>

 <%@include file = "footer.jsp"%>

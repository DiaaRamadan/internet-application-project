<%@page import="java.sql.DriverManager"%>
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


<table class="table table-striped">
  <thead class="thead-dark">
      <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Telephone</th>
      <th scope="col">Gender</th>
      <th scope="col">CV file</th>
      <th scope="col">Operation</th>
    </tr>
  </thead>
  <tbody>
   
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

                RS = Stmt.executeQuery("SELECT * from CV_files INNER JOIN users ON CV_files.user_id = users.ID");
                
                while(RS.next()){
                    
                    out.print("<tr>");
                    out.print("<td>"+RS.getString("ID")+"</td>");
                    out.print("<td>"+RS.getString("username")+"</td>");
                    out.print("<td>"+RS.getString("email")+"</td>");
                    out.print("<td>"+RS.getString("telephone")+"</td>");
                    out.print("<td>"+RS.getString("gender")+"</td>");
                    out.print("<td>"+RS.getString("cv")+"</td>");
                    out.print("<td>");
                    out.print("<a class = 'btn btn-primary' href='sendMail?id="+RS.getString("ID")+"'>Send mail</a>");
                    out.print("</td>");
                    out.print("</tr>");
                }
                   
                
        %>
        ${message}

        
  </tbody>
</table>

 <%@include file = "footer.jsp"%>

<%-- 
    Document   : exam
    Created on : Dec 20, 2018, 10:02:09 PM
    Author     : diaa
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<h3 class="text-center">Your exam</h3>



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
                
                String user_track = request.getParameter("track_id");
                
                int track_id = Integer.parseInt(user_track);
                RS = Stmt.executeQuery("SELECT * FROM questions INNER JOIN Tracks ON questions.track_id = Tracks.T_ID "
                        + "INNER JOIN incorrect_ans ON questions.Q_ID = incorrect_ans.Q_id WHERE track_id ="+track_id+" ORDER BY RAND() LIMIT 5");
                
                out.print("<form action='result.jsp?track_id="+user_track+"' method='post' >");
                int j =1;
                int x = 0;
                String ans = "";
                while(RS.next()){
                    
                    out.print("<p>"+RS.getString("Q_body")+"</p>");
                    String correct_ans = RS.getString("correct_ans");
                    
                    ans += correct_ans+";";
                    String incorrect_ans = RS.getString("inc_ans");
                    String[] parts = incorrect_ans.split(";");
                    
                    for(int i =0; i<parts.length; i++){
                        
                        String Qnum = "Q"+j;
                        
                        out.print("<input type ='radio' name='radio"+j+"' value='"+parts[i]+"' required = 'required'> "+parts[i]+"<br>");

                    }
                   
                    
                    
                    out.print("<br>");
                    j+=1;
                    x+=1;
                }
                out.print("<input type ='hidden' name='correct_ans' value = '"+ans+"'>");
                out.print("<input type= 'submit' value = 'Save'>");
               
            out.print("</form>");
            
 %>

<%@include file="footer.jsp" %>
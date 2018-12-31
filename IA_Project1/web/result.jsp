<%-- 
    Document   : result
    Created on : Dec 30, 2018, 10:21:04 PM
    Author     : diaa
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello User!</h1>
        <% 
            String[] user_ans = new String[5];
            
            for (int i = 0; i<5; i++){
               int j = i+1;
                user_ans[i]=request.getParameter("radio"+j);
            }
            String ans = request.getParameter("correct_ans");
            String[] correct_ans = ans.split(";");
            int correct_count = 0;
            int incorrect_count = 0;
            for (int i = 0; i<correct_ans.length; i++){
               
                String user_Q_A = user_ans[i];
                String lower_User_ans = user_Q_A.toLowerCase();
                
                String correct_Q_A = correct_ans[i];
                String lower_correct_ans = correct_Q_A.toLowerCase();
                if(lower_User_ans.equals(lower_correct_ans)){
                    correct_count+=1;
                }else{
                    incorrect_count +=1;
                }
            }
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
                String name = (String) request.getSession().getAttribute("name");
                RS = Stmt.executeQuery("SELECT * FROM users where  username= '"+name+"'");
                int user_id =0; 
                while(RS.next()){
                    user_id = RS.getInt("ID");
                }
                String result = correct_ans.toString();
                int x =5;
                Stmt.executeUpdate("INSERT INTO results(result,user_id,track_id) VALUES("+correct_count+","+user_id+","+track_id+")"); 
                out.print("Your Result = "+correct_count+"/5");
        %>
        
    </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diaa
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       try {
                String name =request.getParameter("username");
                String pass = request.getParameter("password");
                String email = request.getParameter("email");
                String tele = request.getParameter("telephone");
                String gender = request.getParameter("gender");                
                
                //hashing password
                byte[] bytesOfMessage = pass.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] thedigest = md.digest(bytesOfMessage);
                final String hash_pass = new String(HexBin.encode(thedigest));

                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/IA_Project";
                String user = "root";
                String password = "";

                Connection Con;
                Statement Stmt;
                ResultSet RS = null;

                Con = (Connection) DriverManager.getConnection(url, user, password);
                Stmt = (Statement) Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM users where  username= '"+name+"'");
                if(RS.next() == false){
                       RS = Stmt.executeQuery("SELECT * FROM users where  email= '"+email+"'");
                    if(RS.next() == true){
                        
                        out.print("This email is found");
                    }else{
                    
                   Stmt.executeUpdate("INSERT INTO users(username, email, password, telephone, gender) VALUES('"+name+"','"+email+"','"+hash_pass+"','"+tele+"','"+gender+"')");
                        HttpSession session = request.getSession();
                        session.setAttribute("loginSession", name);
                        response.sendRedirect("home.jsp");
                    }
                }else{
                    
                    // using ajax
                    out.println("ResultSet ont empty in Java");
                }
               
            } catch (Exception ex) {
                out.println(ex);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(urlPatterns = {"/sendMail"})
public class sendMail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String id = request.getParameter("id");
                    
            int user_id =Integer.parseInt(id);
            Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/IA_Project";
                String user = "root";
                String password = "";

                Connection Con;
                Statement Stmt;
                ResultSet RS = null;

                Con = (Connection) DriverManager.getConnection(url, user, password);
                Stmt = (Statement) Con.createStatement();

            RS = Stmt.executeQuery("SELECT * FROM CV_files "
                                        + "INNER JOIN users ON users.ID = CV_files.user_id \n" +
                                    "INNER JOIN Tracks ON Tracks.T_ID = CV_files.track_id");
              
            
            while(RS.next()){
                String to_email = RS.getString("email");
            int track_id = RS.getInt("track_id");
            String subject = "Exam Mail";
            String massage = "Follow the link<a href='http://localhost:8080/IA_Project1/makeSure.jsp?trackid="+track_id+"'>exam</a>";
            
            String mail_from = "deia.atiya100@gmail.com";
            String username = "deia.atiya100@gmail.com";
            String Emailpassword = "diaa161996999";
           
            Properties props = System.getProperties();
          
            
                props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
            
            Session mailsession = Session.getDefaultInstance(props,null);
            mailsession.setDebug(true);
            Message mailmessage = new MimeMessage(mailsession);
            mailmessage.setFrom(new InternetAddress(mail_from));
            mailmessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
            mailmessage.setContent(massage, "text/html");
            mailmessage.setSubject(subject);
            
            Transport transport = mailsession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, Emailpassword);
            
            transport.sendMessage(mailmessage, mailmessage.getAllRecipients());
            }
           String message = "<script>alert('Massage send successfull');</script>";
           request.setAttribute("message", message);
           request.getRequestDispatcher("/home.jsp").forward(request, response);
             
             
            
        } catch (Exception ex) {
           out.print(ex);
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

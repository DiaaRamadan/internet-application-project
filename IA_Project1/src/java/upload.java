/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig(location="/home/diaa/IA_Project1", fileSizeThreshold=1048576, maxFileSize=20848820, maxRequestSize=418018841)

@WebServlet(urlPatterns = {"/upload"})
public class upload extends HttpServlet {

    private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 300 * 1024;
   private int maxMemSize = 10 * 1024;
   private File file ;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = getServletContext().getInitParameter("/home/diaa/IA_Project1/CV_files"); 
   }
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Check that we have a file upload request
                       

      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      
   
      if( !isMultipart ) {
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }
  
      DiskFileItemFactory factory = new DiskFileItemFactory();
   
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
   
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("/home/diaa/IA_Project1/CV_files"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
   
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);
	
         // Process the uploaded file items
         Iterator i = fileItems.iterator();
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
               String fieldName = fi.getFieldName();
               
               String fileName = fi.getName();
               String randFileName = timeStamp+fileName;
               String filePath = "/home/diaa/IA_Project1/CV_files" + File.separator + randFileName;
               String contentType = fi.getContentType();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
               File uploadedFile = new File(filePath);
               fi.write(uploadedFile);
               
                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/IA_Project";
                String user = "root";
                String password = "";

                Connection Con;
                Statement Stmt;
                ResultSet RS = null;

                Con = (Connection) DriverManager.getConnection(url, user, password);
                Stmt = (Statement) Con.createStatement();
               String name = (String) request.getSession().getAttribute("name");
               
              RS = Stmt.executeQuery("SELECT * FROM users where  username= '"+name+"'");
              int id = 0;
              while(RS.next()){
                id = (int) RS.getInt("ID");
                
              }
              String track = request.getParameter("track");
              
              
              Stmt.executeUpdate("INSERT INTO CV_files(cv,user_id,track_id) VALUES('"+randFileName+"',"+id+",1)");
               // Write the file
            
               response.sendRedirect("home.jsp");
            }
         }
         
         } catch(Exception ex) {
            out.println(ex);
         }
        
             
                
                
        }catch(Exception ex){
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

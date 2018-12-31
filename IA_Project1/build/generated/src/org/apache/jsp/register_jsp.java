package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("         <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" \n");
      out.write("          integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" \n");
      out.write("          crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>       ");
      out.write("\n");
      out.write("<div class=\"register-form\">\n");
      out.write("    <h1 class=\"text-center\">User login</h1>\n");
      out.write("        <form action=\"register\" class=\"form-group\">\n");
      out.write("            <input class=\"form-control\" type=\"text\" name=\"username\" placeholder=\"User name\" required=\"required\">\n");
      out.write("            <input class=\"form-control\" type=\"email\" name=\"email\" placeholder=\"Email\" required=\"required\">\n");
      out.write("            <input class=\"form-control\" type=\"password\" name=\"password\" placeholder=\"Password\" required=\"required\">\n");
      out.write("            <input class=\"form-control\" type=\"text\" name=\"telephone\" placeholder=\"Your telephone\">\n");
      out.write("            <select name=\"gender\" class=\"form-control\">\n");
      out.write("                <option value=male>Male</option>\n");
      out.write("                <option value=\"female\">Female</option>\n");
      out.write("            </select>\n");
      out.write("            <input class=\"btn btn-success\" type=\"submit\" value=\"Register\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" \n");
      out.write("    integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" \n");
      out.write("    crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" \n");
      out.write("        integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" \n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

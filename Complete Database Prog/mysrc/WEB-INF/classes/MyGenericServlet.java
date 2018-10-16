import javax.servlet.*;
import  java.io.*;

public  class MyGenericServlet    extends  GenericServlet
{
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("MyGenericServlet is initialized");
     }
     public  void  service(ServletRequest  req,ServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       pw.println("<html><body>");
       pw.println("<h1><font color='red'>Hello friends  ! this is my first generic Servlet");
       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");
     }
}
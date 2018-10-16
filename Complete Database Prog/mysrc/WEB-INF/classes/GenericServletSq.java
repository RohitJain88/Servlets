import javax.servlet.*;
import  java.io.*;

public  class GenericServletSq    extends  GenericServlet
{
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("MyGenericServletSq is initialized");
     }
     public  void  service(ServletRequest  req,ServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       pw.println("<html><body>");
       int  a=Integer.parseInt(req.getParameter("num"));
       //int  b=Integer.parseInt(req.getParameter("t2"));
       pw.println("<h1><font color='red'>Hello friends  ! this is my first generic Servlet");
          pw.println("Square of "+a+" = "+(a*a));
          pw.println("<a  href='Square.html'>Another num Square</a>");
       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");
     }
}
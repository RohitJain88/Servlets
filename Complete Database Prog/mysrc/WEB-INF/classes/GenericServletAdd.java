import javax.servlet.*;
import  java.io.*;

public  class GenericServletAdd    extends  GenericServlet
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
       int  a=Integer.parseInt(req.getParameter("t1"));
       int  b=Integer.parseInt(req.getParameter("t2"));
       pw.println("<h1><font color='red'>Hello friends  ! this is my first generic Servlet");
          pw.println("sum of "+a+" and "+b+" = "+(a+b));
          pw.println("<a  href='AddDemo.html'>Add Another num</a>");
       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");
     }
}
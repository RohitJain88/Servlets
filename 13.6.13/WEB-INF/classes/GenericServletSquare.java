import javax.servlet.*;
import  java.io.*;

public  class GenericServletSquare    extends  GenericServlet
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
       int  a=Integer.parseInt(req.getParameter("num"));
       //int  b=Integer.parseInt(req.getParameter("t2"));
          pw.println("square of "+a+" = "+(a*a));
          pw.println("<a  href='Square.html'>Another num square</a>");
       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");
     }
}
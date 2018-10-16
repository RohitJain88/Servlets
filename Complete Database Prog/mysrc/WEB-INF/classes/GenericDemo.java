import javax.servlet.*;
import java.io.*;

public class GenericDemo extends GenericServlet
{
	public void init(ServletConfig sconfig)throws ServletException
	{
		System.out.println("Servlet is initialized");
	}
	public void service(ServletRequest sreq,ServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		pw.println("<h1><font face='Jokermen' color='green'>This is my Generic Servlet Demo");
		pw.println("</html></body>");
		pw.close();
		System.out.println("Service is called");
	}
}
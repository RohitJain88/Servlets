import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.*;
import javax.swing.*;
import java.sql.*;

public  class GenericServletHome    extends  HttpServlet
{
	Connection con;
PreparedStatement  pst;
ResultSet  rs;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("MyGenericServlet is initialized");
            try{
	 	   		con=MyConnection.createConnection();

	 	   	System.out.println("Database connected");
	 	   	//	pst=con.prepareStatement("Select  id,pwd from Login where id=? and pwd=?");
	 	   	pst=con.prepareStatement("Select  username,password from userdetails where username=? and password=?");

	 	   	 }catch(Exception  e)
	 	   	  {
	 	   		    	System.out.println("Error in Connection");
	  }
     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       pw.println("<html><body>");
       String a=req.getParameter("num1");
       String  b=req.getParameter("num2");
try{
		pst.setString(1,a);
		pst.setString(2,b);
		rs=pst.executeQuery();

		if(rs.next())
		{
			res.sendRedirect("http://localhost:8080/mysrc/LoginDemo.html");
		}
		else
		{
			res.sendRedirect("http://localhost:8080/mysrc/LoginDemo1.html");
		}
}
catch(Exception e)
{
	System.out.println("Error in Connection dgd tgse m");
}

       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");


     }
}
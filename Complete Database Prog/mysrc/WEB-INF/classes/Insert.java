import javax.swing.*;
import javax.servlet.*;
import  java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.awt.*;

public  class Insert extends  HttpServlet
{
     Connection con;
	 PreparedStatement  pst;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("LoginServlet is initialized");
     try{
	 		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:abc");

			System.out.println("Database Connected");
	 		pst=con.prepareStatement("insert into Student values(?,?,?)");

	 	 }catch(Exception  e)
	 	  {
	 		  System.out.println("Error in Connection");
	 	  }

     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       String roll=req.getParameter("num");
       String name=req.getParameter("s");
       String addr=req.getParameter("a");
       try
       {
       	pst.setString(1,roll);
		pst.setString(2,name);
		pst.setString(3,addr);
		int r=pst.executeUpdate();
		if(r>=1)
		{
			System.out.println("Record is inserted");
			pw.println("<html><body>");
			pw.println("<h1 align='center'><font color='red' face='stencil'>Record is Inserted</h1></br>");
			pw.println("<form>");
			pw.println("<table align='center' border='5' bordercolor='green' bgcolor='aabbcc'>");
			pw.println("<tr><td><a href='Insert.html'><input type='button' value='Back to Insert'></a></td></tr>");
			pw.println("<tr><td><a href='HomePage.html'><input type='button' value='Back to Home'></a></td></tr></table>");
			pw.println("</form></body></html>");
	}
	else
	{
		System.out.println("Record is not inserted");

     }
 }catch(Exception e)
 {
 		System.out.println("Error"+e);
 }
 }
}
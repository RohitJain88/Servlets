import javax.swing.*;
import javax.servlet.*;
import  java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.awt.*;

public  class Delete extends  HttpServlet
{
     Connection con;
	 PreparedStatement  pst;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("LoginServlet is initialized");
     try{
	 		con=MyConnection.createConnection();
			System.out.println("Database Connected");
	 		pst=con.prepareStatement("delete from student where rollno=?");

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

       try
       {
       pst.setString(1,roll);

		int r=pst.executeUpdate();
		if(r>=1)
		{
			System.out.println("Record is Deleted");
						pw.println("<html><body>");
						pw.println("<h1 align='center'><font color='red' face='stencil'>Record is Deleted</br>");
									pw.println("<table align='center' border='5' bordercolor='green' bgcolor='aabbcc'>");
									pw.println("<tr><td><a href='Delete.html'><input type='button' value='Back to Delete'></a></td></tr>");
									pw.println("<tr><td><a href='HomePage.html'><input type='button' value='Back to Home'></a></td></tr></table>");
			pw.println("</body></html>");
	}
	else
	{
		System.out.println("Record is not Deleted");

     }
 }catch(Exception e)
 {
 		System.out.println("Error"+e);
 }
 }
}
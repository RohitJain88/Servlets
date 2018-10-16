import javax.swing.*;
import javax.servlet.*;
import  java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.awt.*;

public  class ShowServlet extends  HttpServlet
{
     Connection con;
	 PreparedStatement  pst;
	 ResultSet rs;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("LoginServlet is initialized");
     try{
	 		con=MyConnection.createConnection();
			System.out.println("Database Connected");
	 		pst=con.prepareStatement("select * from Student");
			rs=pst.executeQuery();
	 	 }catch(Exception  e)
	 	  {
	 		  System.out.println("Error in Connection");
	 	  }

     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();

       try
       {

		while(rs.next())
		{
			System.out.println("Record is shown");
			pw.println("<html><body>");
			pw.println("<table border='5' bordercolor='green' bgcolor='aabbcc'>");
			pw.println("<tr><td>Roll.No<input name='t1' value='"+rs.getInt(1)+"'></td>");
			pw.println("<td>Name<input name='t2' value='"+rs.getString(2)+"'></td>");
			pw.println("<td>Address<input name='t3' value='"+rs.getString(3)+"'></td></tr></table>");
			pw.println("</body></html>");
			//pw.println("<a href='HomePage.html'><------Back to Home</a>");

	}

 }catch(Exception e)
 {
 		System.out.println("Error"+e);
 }
 }
}
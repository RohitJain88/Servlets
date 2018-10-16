import javax.swing.*;
import javax.servlet.*;
import  java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.awt.*;

public  class Search extends  HttpServlet
{
     Connection con;
	 PreparedStatement  pst;
	 ResultSet rs;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("SearchServlet is initialized");
     try{
	 		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:abc");

			System.out.println("Database Connected");
	 		pst=con.prepareStatement("select * from Student where rollno=?");


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
       pst.setInt(1,Integer.parseInt(roll));

		rs=pst.executeQuery();
		if(rs.next())
		{
			System.out.println("Record is Searched");
			pw.println("<html><body><form action='http://localhost:8080/mysrc/UpdateServlet'>");
			pw.println("Roll.No<input name='t1' value='"+rs.getInt(1)+"'></br>");
			pw.println("Name<input name='t2' value='"+rs.getString(2)+"'></br>");
			pw.println("Address<input name='t3' value='"+rs.getString(3)+"'></br>");
			pw.println("<a href='Search.html'><------Back to Search</a></br>");
			pw.println("<a href='HomePage.html'><------Back to Home</a>");
			pw.println("<a href='Update.html'><input type='submit' value='update'></a></br>");
			pw.println("</form></body></html>");
			pw.close();
	}
	else
	{
		System.out.println("Record is not Available");

     }
 }catch(Exception e)
 {
 		System.out.println("Error"+e);
 }
 }

}
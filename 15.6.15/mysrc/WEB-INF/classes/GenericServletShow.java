import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.*;
import javax.swing.*;
import java.sql.*;

public  class GenericServletShow extends  HttpServlet
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
	 		pst=con.prepareStatement("Select * from student");
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
       pw.println("<html><body bgcolor='aabbdd'><table bgcolor='aabbcc' border='5'  bordercolor='green' align='center' cellpadding='6' cellspacing='6'>");

try{

				while(rs.next())
				{
pw.println("<tr><td>Rollno<input  name='t1' value=' " +rs.getString(1)+" '></td>");
pw.println("<td>Name<input  name='t2' value=' " +rs.getString(2)+" '></td>");
pw.println("<td>Address<input  name='t3' value=' " +rs.getString(3)+" '></td></tr>");

System.out.println("Record is displayed");
}






}
catch(Exception e)
{
	System.out.println("Record is already present");
	res.sendRedirect("http://localhost:8080/mysrc/show.html");
}

       pw.println("</table></body></html>");
       pw.close();
       System.out.println("Service is called");


     }
}
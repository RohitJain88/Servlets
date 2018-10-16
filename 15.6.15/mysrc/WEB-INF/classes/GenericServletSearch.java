import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.*;
import javax.swing.*;
import java.sql.*;

public  class GenericServletSearch extends  HttpServlet
{
	Connection con;
PreparedStatement  pst,pst1;
ResultSet  r;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("MyGenericServlet is initialized");
          try{
	 		  		con=MyConnection.createConnection();
	 		  		System.out.println("Database connected");
	 		  		pst=con.prepareStatement("Select * from student where rollno=?");


	 		  	 }catch(Exception  e)
			 	  {
			 		 System.out.println("Error in Search");
	 	  }
     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       pw.println("<html><body>");
       String a=req.getParameter("b1");

try{


			pst.setInt(1,Integer.parseInt(a));
        	r=pst.executeQuery();
			if(r.next())
			{
			 // res.sendRedirect("http://localhost:8080/mysrc/search.html");
		  	System.out.println("Record is present");
pw.println("<html><body bgcolor='aabbdd'><table bgcolor='aabbcc' border='5'  bordercolor='green' align='center'><form action='http://localhost:8080/mysrc/GenericServletUpdate'>");
																	 pw.println("<tr><td>Rollno<input  name='t1' value=' " +r.getInt(1)+" '></td></tr>");
																	 pw.println("<tr><td>Name<input  name='t2' value=' " +r.getString(2)+" '></td></tr>");
 pw.println("<tr><td>Address<input  name='t3' value=' " +r.getString(3)+" '></td></tr>");
	 pw.println("<tr><td colspan='2' align='center'><a href='search.html' ><input type='button' value='Back'></a></td></tr>");

	pw.println("<tr><td colspan='2' align='center'><input type='submit' value='Update'></td></tr>");
pw.println("</form></table></body></html>");


	}

	else
	{
	System.out.println( "Record does contain Rollno");
	res.sendRedirect("http://localhost:8080/mysrc/search.html");

				  				}

}
catch(Exception e)
{
	System.out.println("Error in search");
}

       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");


     }
}
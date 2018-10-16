import javax.swing.*;
import javax.servlet.*;
import  java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.awt.*;

public  class UpdateServlet extends  HttpServlet
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

	 		pst=con.prepareStatement("update Student set sname=?,address=? where rollno=?");

	 	 }catch(Exception  e)
	 	  {
	 		  System.out.println("Error in Connection");
	 	  }

     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
      String roll=req.getParameter("t1");
	   String name=req.getParameter("t2");
       String addr=req.getParameter("t3");
        try
	           {
	           //pst.setInt(1,Integer.parseInt(roll));
	    		pst.setString(1,name);
	   		pst.setString(2,addr);
	   		pst.setInt(3,Integer.parseInt(roll));
	    		int r=pst.executeUpdate();
	    		if(r>=1)
	    		{
	    			System.out.println("Record is Updated");
	    			/*pw.println("<html><body><form>");
	    			pw.println("Roll.No<input name='t1' value='"+rs.getInt(3)+"'></br>");
	    			pw.println("Name<input name='t2' value='"+rs.getString(1)+"'></br>");
	    			pw.println("Address<input name='t3' value='"+rs.getString(2)+"'></br>");
	    			//pw.println("<a href='Update.html'><input type='submit' value='update'></a></br>");
	    			//pw.println("<a href='Search.html'><------Back to Search</a></br>");

	    			//pw.println("<a href='HomePage.html'><------Back to Home</a>");
	    			pw.println("</form></body></html>");
	    			pw.close();*/
	    			res.sendRedirect("http://localhost:8080/mysrc/Updatee.html");
	    	}
	    	else
	    	{
	    		System.out.println("Record is not available");

	         }
	     }catch(Exception e)
	     {
	     		System.out.println("Error"+e);
	     }
 }
}
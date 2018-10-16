import javax.swing.*;
import javax.servlet.*;
import  java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.awt.*;

public  class LoginServlet extends  HttpServlet
{
     Connection con;
	 PreparedStatement  pst;
	 ResultSet  rs;
	 Component c;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("LoginServlet is initialized");
     try{
	 		con=MyConnection.createConnection();
			System.out.println("Database Connected");
	 		pst=con.prepareStatement("Select  Userid,password from userdetails where Userid=? and password=?");

	 	 }catch(Exception  e)
	 	  {
	 		  System.out.println("Error in Connection");
	 	  }

     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       String user=req.getParameter("t1");
       String pass=req.getParameter("t2");
       try
       {
       pst.setString(1,user);
		pst.setString(2,pass);
		rs=pst.executeQuery();
		if(rs.next())
		{
			res.sendRedirect("http://localhost:8080/mysrc/HomePage.html");
	}
	else
	{
		res.sendRedirect("http://localhost:8080/mysrc/Login1.html");

     }
 }catch(Exception e)
 {
 		System.out.println("Error"+e);
 }
 }
}
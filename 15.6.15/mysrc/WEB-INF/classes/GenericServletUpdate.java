import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.*;
import javax.swing.*;
import java.sql.*;

public  class GenericServletUpdate extends  HttpServlet
{
	Connection con;
PreparedStatement pst1;
ResultSet  r;
     public  void  init(ServletConfig  sc) throws  ServletException
     {
     System.out.println("MyGenericServlet is initialized");
          try{
	 		  		con=MyConnection.createConnection();
	 		  		System.out.println("Database connected");

	 		  		pst1=con.prepareStatement("update student set sname=?,address=? where rollno=?" );

	 		  	 }catch(Exception  e)
			 	  {
			 		 System.out.println("Error in Search");
	 	  }
     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {

	          String  a=req.getParameter("t1");
	        String b=req.getParameter("t2");
       String  c=req.getParameter("t3");

try{


					pst1.setString(3,a);
															pst1.setString(1,b);
										pst1.setString(2,c);
int    r=	pst1.executeUpdate();

	if(r>=1)
	        {
				System.out.println("Record is updated");
				//res.sendRedirect("http://localhost:8080/mysrc/update.html");


			}
			else
			{
				 System.out.println("Record is not updated");
				 //es.sendRedirect("http://localhost:8080/mysrc/update.html");
		}


}
catch(Exception e)
{
	System.out.println("error"+e);
}



       System.out.println("Service is called");


     }
}
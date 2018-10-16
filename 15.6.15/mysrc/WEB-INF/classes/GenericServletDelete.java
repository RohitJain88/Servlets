import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.*;
import javax.swing.*;
import java.sql.*;

public  class GenericServletDelete   extends  HttpServlet
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
			 		pst=con.prepareStatement("delete from student where rollno=?");

			 	 }catch(Exception  e)
			 	  {
			 		 System.out.println("Error in Deletion");
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
        								int    r=	pst.executeUpdate();

	if(r>=1)
	        {
				System.out.println("Record is Deleted");
				res.sendRedirect("http://localhost:8080/mysrc/delete.html");


			}
			else
			{
				 System.out.println("Record does not Exist");
				 res.sendRedirect("http://localhost:8080/mysrc/delete.html");
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
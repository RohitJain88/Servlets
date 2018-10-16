import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.*;
import javax.swing.*;
import java.sql.*;

public  class GenericServletInsert   extends  HttpServlet
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
	 		pst=con.prepareStatement("insert into student values(?,?,?)");

	 	 }catch(Exception  e)
	 	   	  {
	 	   		    	System.out.println("Error in Connection");
	  }
     }
     public  void  doGet(HttpServletRequest  req,HttpServletResponse  res) throws  ServletException,IOException
       {
       res.setContentType("text/html");
       PrintWriter   pw=res.getWriter();
       pw.println("<html><body>");
       String a=req.getParameter("b1");
     String b=req.getParameter("b2");
       String  c=req.getParameter("b3");
try{


			pst.setInt(1,Integer.parseInt(a));
										pst.setString(2,b);
										pst.setString(3,c);
        								int    r=	pst.executeUpdate();

	if(r>=1)
	        {
				System.out.println("Record is Inserted");
				 pw.println("<html><body color='aabbdd'><table bgcolor='aabbcc' border='5'  bordercolor='green' align='center' cellpadding='6' cellspacing='6'>");

				 pw.println("<tr><td>Record is Inserted </td></tr>");
				  pw.println("<tr><td><a href='insert.html'><input type='button' value='Insert another data'></a></td></tr>");
				  pw.println("<tr><td><a href='Home.html'><input type='button' value='Home '></a></td></tr>");
				 pw.println("</body></html>");

				//res.sendRedirect("http://localhost:8080/mysrc/insert.html");



			}
			else
			{
				System.out.println("Record is not Inserted");
								 pw.println("<html><body color='aabbdd'><table bgcolor='aabbcc' border='5'  bordercolor='green' align='center' cellpadding='6' cellspacing='6'>");

								 pw.println("<tr><td>Record is not Inserted </td></tr>");
								  pw.println("<tr><td><a href='insert.html'><input type='button' value='Insert another data'></a></td></tr>");
								  pw.println("<tr><td><a href='Home.html'><input type='button' value='Home '></a></td></tr>");
								 pw.println("</body></html>");
				 pw.println("</body></html>");
				 //res.sendRedirect("http://localhost:8080/mysrc/insert.html");
		}
}
catch(Exception e)
{
	System.out.println("Record is already present");

					 pw.println("<html><body color='aabbdd'><table bgcolor='aabbcc' border='5'  bordercolor='green' align='center' cellpadding='6' cellspacing='6'>");

					 pw.println("<tr><td>Record is already present </td></tr>");
					  pw.println("<tr><td><a href='insert.html'><input type='button' value='Insert another data'></a></td></tr>");
					  pw.println("<tr><td><a href='Home.html'><input type='button' value='Home '></a></td></tr>");
					 pw.println("</body></html>");

	//res.sendRedirect("http://localhost:8080/mysrc/insert.html");
}

       pw.println("</body></html>");
       pw.close();
       System.out.println("Service is called");


     }
}
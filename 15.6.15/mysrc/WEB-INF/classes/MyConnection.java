import  java.sql.*;

public class  MyConnection
{
static Connection con;
  public static  Connection  createConnection()
  {
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:abc");

		}catch(Exception e)
		 {
		 System.out.println("Error in MyConnection"+e);
		 e.printStackTrace();
		 con=null;
		 }
		 return con;
  }
}
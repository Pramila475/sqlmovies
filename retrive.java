import java.util.*;
import java.lang.*;
import java.sql.*;

public class retrive
{
  public static void main(String[] args)throws ClassNotFoundException,SQLException
 {
  try
  {

  //register the driver using mySql here
  Class.forName("com.mysql.jdbc.Driver");
	
  //create a connection to the database 'db1'
  Connection con=DriverManager.getConnection("java:mysql://localhost:3306/db1","root","Tiger123");
  
  //Create a prepare statement interface
  PreparedStatement ps=con.prepareStatement("select * from MOVIES;");
  
  //storing the result into a result set and displaying it
  ResultSet rs=ps.executeQuery();
  
  //getting metadata
  ResultSetMetaData rsmd=rs.getMetaData();
  
  //printing column names
  for(int i=1;i<=rsmd.getColumnCount();i++)
  {
    System.out.println(rsmd.getColumnName(i)+"\t");
  }
 
  //printing values present in result set
  while(rs.next())
  {
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDate(4)+"\t"+rs.getString(5));
  }
 }
 catch(Exception e)
 {
   System.out.println(e.StackTrace());
 }
 finally
 {
   //close the connection
   con.close();
 }

}

}

    
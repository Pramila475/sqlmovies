import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 class movies{
   public static void main(String[] args)throws ClassNotFoundException,SQLException{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Tiger123");
     System.out.println("connection is established");
     Statement st=con.createStatement();
     String query = "CREATE TABLE MOVIES("
         + "NAME VARCHAR(20) NOT NULL, "
         + "ACTOR VARCHAR(20) NOT NULL, "
         + "ACTRESS VARCHAR(20) NOT NULL, "
         + "YEAR DATE NOT NULL, "
         + "DIRECTOR VARCHAR (20) NOT NULL, )"
         ;
     st.execute(query);
     int re=st.executeUpdate("insert into MOVIES values('HARRYPOTTER','DANIEL','EMMA','1999-11-01','J.K');");
      re=st.executeUpdate("insert into MOVIES values('SITARAMAM','DQ','MRUNAL','2022-08-05','ANIL');");
      re=st.executeUpdate("insert into MOVIES values('MAGADHEERA','RAM','KAJAL','2010-10-12','RAJAMOULI');");
     
     System.out.println(re + "no of rows affected");
     st.close();
     con.close();
}
}
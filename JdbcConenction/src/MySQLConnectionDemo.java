import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MySQLConnectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/advancedjava","root","root");
			System.out.println("Connected to the database sucessfully");
			
		
			//DDL -Data definition langugae : DBA
			//DML - Data manipulation language : Developer
			
			
			//1.insert operation
			Statement stmt= con.createStatement();
			stmt.executeUpdate("insert into emp values(567,'John','23')");
			
			
			//2.Update operation
			int result=stmt.executeUpdate("update emp set name ='john kumar' where id=567");
			
			
			//3.select
			ResultSet rs=stmt.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
				
			//4.delete
			int delResult= stmt.executeUpdate("delete from  emp where id=567");
			
			
		}catch(Exception e)
		{
			
		}
		
		

	}

}

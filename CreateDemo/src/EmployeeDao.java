import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
	
	
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			 con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/advancedjava","root","root");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	public static Employee getEmployeeById(int id){
		Employee e=new Employee();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				//e.setPassword(rs.getString(3));
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	
	
	public static int update(Employee e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update employee set name=? where id=?");
			ps.setString(1,e.getName());
			
			ps.setInt(2,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	
	public static List<Employee> getAllEmployees(){
		List<Employee> list=new ArrayList<Employee>();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	} static int save(Employee e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into employee(id,name) values (?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
					
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	

}

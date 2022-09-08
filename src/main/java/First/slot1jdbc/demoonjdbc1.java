package First.slot1jdbc;
import java.sql.*;

public class demoonjdbc1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); // this is  loading and register driver 
		String url = "jdbc:mysql://localhost:3306/capegemini"; // this is our database url
		String username = "root"; //this is our username
		String password = "Rahul123@";//this is our password
		String query = "select * from employee where Empid=103";//this is the query we want from the database
		Connection con = DriverManager.getConnection(url,username,password); //this is connection setup 
		Statement st = con.createStatement(); //this is the statement 
		 ResultSet rs =st.executeQuery(query); //to store the result here we use result set
		 rs.next();
		 String employeename = rs.getString("EmpName"); // here what we get from the database
		 System.out.println ("employee name  is " + employeename); //here we print the data we get from database
		 con.close();
		
		
		
	}

}

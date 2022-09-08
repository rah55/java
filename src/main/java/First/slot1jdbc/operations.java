package First.slot1jdbc;
import java.sql.*;


public class operations {
    Connection con= null;
	public void connect() throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");// here we load and register the driver
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capegemini","root","Rahul123@"); //here we set up the connection with database
	}
	
	// here we register account
	public int registerAccount(entities e1)throws Exception {
		String query = " insert into EMS (name,phone,balance,password) values(?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(query);
	
		pst.setString(1,e1.name);
		pst.setString(4,e1.password);
		pst.setString(2,e1.phone);
		pst.setInt(3,e1.balance);
		int count = pst.executeUpdate();
		return count;
		
		}
	
		public int login(String name, String cpassword)throws Exception{
			//fetching the account details by name
			
			String query="select * from EMS where name= '"+name+"'";
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			if(rs.next()) {
			//fetching the password from db
				
				String password=rs.getString(5);
				//matching the database password with entered password
				if(cpassword.equals(password)) {
				int id=rs.getInt(1);
				//if login success we can return id
				return id;
				}
				else {
				return 0;
					}
				}
				else {
				return -1;
				}
		}

	
		public int withdraw(int id,int amount)throws Exception {
			//getting account details based on id
			String query="select * from EMS where id="+id;
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			//fetching account balance
			int balance=rs.getInt(4);
			//if account balance is greater than withdraw amount we can allow to withdraw
			if(balance>amount) {
				balance-=amount;
				String query2="update EMS set balance="+balance+" where id="+id;
				//updating the balance after withdraw
				Statement st2=con.createStatement();
				int res=st2.executeUpdate(query2);
				return res;
			}	
			else {
				return -1;
			}
		}

			public int deposit(int id,int amount)throws Exception {
				//getting account details based on id
				String query="select * from EMS where id="+id;
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
			
			
				
				if(rs.next()) 
				{
				int balance=rs.getInt(4);  //here we get account balance from database	
				 balance+=amount; //here we add amount into account
					String query2="update EMS set balance="+balance+" where id="+id;
					//updating the balance after withdraw
					PreparedStatement pst=con.prepareStatement(query2);
					 pst.executeUpdate(query2);
					return balance;
				}	
				else {
					return -1;
				}
			}
			
			
				public int checkBalance(int id)throws Exception{
					//Here we we perform operations related to Check account balance 
					String query="select * from EMS where id="+id;
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					rs.next();
					int balance=rs.getInt(4);          // Here also we get account balance from database 
					return balance;                    // Here we return updated balance to the user 
					
				}
				
				public int passwordChange(int id, String oldpassword,String newpassword)throws Exception{
					//Here we we perform operations related to Change user's Password 
					String query="select * from EMS where id="+id;
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					rs.next();
					String password=rs.getString(5);      // Here also we get account password from database
					
					if(newpassword.equals(oldpassword)) {    // Here we match old password with database password
						String query2="update EMS set password="+newpassword+" where id="+id;
						PreparedStatement pst=con.prepareStatement(query2);
						int Password=pst.executeUpdate();
						return Password;            // Here we return new password to the user
					}
					else {
						return -1;
					}
					

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
		
		
		}



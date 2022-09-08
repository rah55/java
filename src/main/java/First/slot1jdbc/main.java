package First.slot1jdbc;
import java.util.Scanner;
public class main {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				entities e1 = new entities();
				operations o1 = new operations();
				
				System.out.println("-----welcome to capegimini bank----");
				System.out.println("select operation: ");
				System.out.println(" press 1.register");
				System.out.println("press  2.login");
				int op=sc.nextInt();
				switch(op) {
				
				case 1->{
				//creating new account
					System.out.println("Enter Customer Details to create new account");
					System.out.print("Enter Customer Name");
					String name=sc.next();
					System.out.print("Create Customer Password");
					String password=sc.next();
					System.out.print("Enter Cutstomer Phone");
					String phone=sc.next();
					System.out.print("Enter Acc balance");
					int balance=sc.nextInt();
					e1.name=name;
					e1.password=password;
					e1.phone=phone;
					e1.balance=balance;
					
					o1.connect();
					int res=o1.registerAccount(e1);
					if(res!=0) {
						System.out.println("Account Created");
					}
					else {
						System.out.println("Something went wrong, please tryagain");
					}
				}
				
				case 2->{
					//login into my account
					System.out.println("Enter Customer Details to Login");
					System.out.print("Enter Customer Name");
					String name=sc.next();
					System.out.print("Enter Customer Password");
					String password=sc.next();
					
					o1.connect();
					int res=o1.login(name,password);
					if(res==0) {
						System.out.println("Wrong Username or Password");
					}
					else if(res==-1) {
						System.out.println("account not found\n Please Register yourself");
					}
					else {
						System.out.println("Login Success");
						int op2=0;
						while(op2<5) {
						System.out.println("Select Operation : \n1 for Withdraw \n2 for deposit \n3 for checking balance \n4 to change your password \n5 for exit");
						 op2=sc.nextInt();
						switch(op2) {
						
						case 1->{
							//withdraw amounts
							System.out.println("Enter amount to withdraw");
							int amt=sc.nextInt();
						int res2=o1.withdraw(res, amt);
							if(res2<=0) {
								System.out.println("Something went wrong");
							}
							else {
								System.out.println("Withdraw done");
								
								}
						}
							case 2->{        // here we perform deposit operation
								System.out.println("enter the amount you want to deposit");
								int amount = sc.nextInt();
								int res2=o1.deposit(res,amount);
								if(res2==-1) {
									System.out.println("something went wrong ");
									
								}
								else {
									System.out.println("deposit done ,update balance is : " + res2);
									
								}
							}
								case 3->{          // here we check our balance
									System.out.println("your current balance is:" +o1.checkBalance(res));
								}
								case 4->{
									System.out.println("enter the old password:");
									String oldpassword = sc.next();
									System.out.println("enter the new password:");
									String newpassword = sc.next();
									int count =o1.passwordChange(res,oldpassword,newpassword);
									
								if(count<=0) {
									System.out.println("password not matched");
									
								}
								else {
									System.out.println("password update successfully");
								}
								
								}
							}			
							
							
							
							
						}
						
						}
						
					}
				}
					sc.close();
	
}
}
				
	




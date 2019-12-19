package lab05;
import java.util.ArrayList;
import java.util.Arrays;

public class BankTester {

	public static void main(String[] args) {
		ArrayList<BankAccount> accounts= new ArrayList<BankAccount>(Arrays.asList(new BankAccount(150.25),new SavingsAccount(135.23,0.10),
				new BankAccount(75.97),new CheckingAccount(120.56,1),
				 new SavingsAccount(123.56,0.16),new CheckingAccount(75.45,4)));
		System.out.println(accounts);
		
		for(BankAccount i : accounts){
			i.deposit(59.99);
		}
		System.out.println(accounts);
		
		try{
		for(BankAccount i : accounts){
			i.withdraw(59.99);
			i.withdraw(45.65);
		}
		}catch (IllegalArgumentException e){
			System.out.println("You can not withdraw more than your balance");
		}
		System.out.println(accounts);
	
	ArrayList<Object> objects = new ArrayList<>(Arrays.asList(new BankAccount(34),new SavingsAccount(43,0.23),new CheckingAccount(35,2),4,null,true,3.14,"Yavuz"));
	System.out.println(objects);
	}
}

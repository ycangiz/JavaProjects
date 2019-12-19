package lab05;

public class BankAccount {
	private double balance;
	private int idNum;
	private static int numAccounts=0;
	public BankAccount(double aBalance){
		if(aBalance<0) throw new IllegalArgumentException("Negative balance is illegal argument.");
		balance=aBalance;
		idNum = numAccounts;
		numAccounts++;		
	}
	public double getBalance(){
		return balance;
	}
	public int getIdNum(){
		return idNum;
	}
	@Override
	public String toString(){
		return "Account "+idNum+" has $"+balance+" ";
	}
	public void deposit(double amount){
		balance+=amount;
	}
	public double withdraw(double amount){
		if(amount>balance) throw new IllegalArgumentException("You can not withdraw more than your balance");
		else return balance-=amount;
	}
}

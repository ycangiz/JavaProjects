package lab05;

public class CheckingAccount extends BankAccount{
	private double withdrawLimit;
	private int withdrawCount=0;
	
	public CheckingAccount(double balance, int limit){
		super(balance);
		withdrawLimit = limit;
	}
	public double getWithdrawLimit(){
		return withdrawLimit;
	}
	public int getWithdrawCount(){
		return withdrawCount;
	}
	@Override
	public String toString(){
		
		return super.toString()+ withdrawCount+"/"+withdrawLimit;
	}
	@Override
	public double withdraw(double aWithdrawLimit){
		if(withdrawCount<withdrawLimit){
		withdrawCount++;
		return super.withdraw(aWithdrawLimit);
		}
		else return 0;
	}
}

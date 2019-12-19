package lab05;
/*Entering Greeter::sayHi
Hello, Bob.
Exiting Greeter::sayHi
Entering InquisitiveGreeter::sayHi
Entering Greeter::sayHi
Hello, Bob.
Exiting Greeter::sayHi
How are you, Bob?
Exiting InquisitiveGreeter::sayHi
*/
public class SavingsAccount extends BankAccount {
	private double rate;
	public SavingsAccount(double balance, double Arate){
		super(balance);
		rate = Arate;
	}
	@Override
	public void deposit(double amount){
		amount+=amount*rate;
		super.deposit(amount);
	}
	public double getRate(){
		return rate;
	}
	@Override
	public String toString(){
		
		return super.toString()+" @ "+ rate*100 + "%";
	}
}

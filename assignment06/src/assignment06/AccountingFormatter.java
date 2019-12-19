package assignment06;

public class AccountingFormatter implements NumberFormatter {
	
	public String format(int n){
		if(n<0) return "("+-n+")";
		return n+" ";
	}

}

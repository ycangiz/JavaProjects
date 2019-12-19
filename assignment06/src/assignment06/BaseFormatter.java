package assignment06;


public class BaseFormatter implements NumberFormatter {
	
	int base;
	
	public BaseFormatter(int aBase){
		 try {
			if(aBase<2 || aBase>36) throw new IllegalArgumentException("Upper result is not correct.Base can't be outside between 2 and 36");
			base = aBase;

		} catch (IllegalArgumentException e) {
		    System.err.println("IllegalArgumentException: " + e.getMessage());
		
		   
		}
	}
	public String format(int n){
		

		return Integer.toString(n,base);
	}
}

package assignment06;

public class FormatterDemo {
	
	
	public static void main(String[] args) {
		String a="";
		
		NumberFormatter nf1 = new DefaultFormatter(); 
		a=nf1.format(5);
		System.out.println(a);
		
		NumberFormatter nf2 = new AccountingFormatter();
		a=nf2.format(-19);
		System.out.println(a);
		
		NumberFormatter nf3 = new BaseFormatter(5); // you put the base in the constructor.
		a=nf3.format(5);
		System.out.println(a);
		
		
		NumberFormatter nf4 = new DecimalSeparatorFormatter();
		a = nf4.format(1059560);
		System.out.println(a);    
		
	}

}

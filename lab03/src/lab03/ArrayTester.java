package lab03;

public class ArrayTester {

	public static void main(String[] args) {
		
		if(args.length==1){
			ArrayFromFile test= new ArrayFromFile("input.txt");
			System.out.println("Expected array before removeOddElements:[20,8,13,46,7]");
			System.out.println(test);
			test.removeOddElements();
			System.out.println("Expected array after removeOddElements:[20,8,46]");
			System.out.println(test);
		}else{
			throw new IllegalArgumentException("This program must have exactly 1 argument");
		}
		
		
		
		
		
		String[] testStr = {"Miami","New York","Los Angeles","California"};
		for(String strPrinter : testStr){
			System.out.println(strPrinter+" "+strPrinter.length());
		}
	

	}

}

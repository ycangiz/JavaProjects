package lab08;

public class Bonus {
	
	public static void main(String[] args){
		printPascalsTriangle(5);
	}
	public static void printPascalsTriangle(int limit){
		
		for(int i=0;i<limit+1;i++)  //I wrote limit+1 because printPascalsTriangle(5) should print 6 rows as piazza said.
		{
			int number = 1;
			for(int j=0;j<=i;j++)
			{
				 System.out.print(number+ " ");
                 number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}

}

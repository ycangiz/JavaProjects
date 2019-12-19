package assignment03;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		double[] array1 = null;
		double[] array2 = {};
		double[] array3 = {1,2,3,4,5};
		double[] array4 = {1,2,3,5};
		
		System.out.println(Assig3.indexOf(4,array1));
		System.out.println(Assig3.indexOf(4, array2));
		System.out.println(Assig3.indexOf(4, array3));
		System.out.println(Assig3.indexOf(4, array4));
		
		System.out.println("IndexOf2");
		
		System.out.println(Assig3.indexOf2(4,array1));
		System.out.println(Assig3.indexOf2(4, array2));
		System.out.println(Assig3.indexOf2(4, array3));
		System.out.println(Assig3.indexOf2(4, array4));
		
		System.out.println("IndexOf3");
		
		int[] array01={5,6,7,8,10};
		int[] array02={1,2,3,4,5,7};
		int[] array03={1,3,4,5};
		int[] array04={1,2,3,5};
		
		System.out.println(Assig3.indexOf3(9,array01));
		System.out.println(Assig3.indexOf3(4, array02));
		System.out.println(Assig3.indexOf3(2, array03));
		System.out.println(Assig3.indexOf3(4, array04));
		
		System.out.println("InsertIfNeeded");
		
		System.out.println(Arrays.toString(Assig3.insertIfNeeded(11,array01)));
		System.out.println(Arrays.toString(Assig3.insertIfNeeded(6, array02)));
		System.out.println(Arrays.toString(Assig3.insertIfNeeded(2, array03)));
		System.out.println(Arrays.toString(Assig3.insertIfNeeded(4, array04)));
	}
}

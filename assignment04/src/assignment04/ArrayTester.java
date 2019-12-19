package assignment04;
import java.util.ArrayList;
import java.util.Arrays;
import static assignment04.ArrayPractice.*;
public class ArrayTester {

	public static void main(String[] args) {
		ArrayList<Integer> nullArray1=null;
		ArrayList<Integer> emptyArray1= new ArrayList<Integer>(Arrays.asList());
		ArrayList<Integer> testArray1= new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,4,3));
		ArrayList<Integer> testArray2= new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> testconca1= new ArrayList<Integer>(Arrays.asList(1,8,6,5,7,9)); 
		ArrayList<Integer> testconca2= new ArrayList<Integer>(Arrays.asList(7,8,6,5,2));
		ArrayList<Integer> reverseArray1= new ArrayList<Integer>(Arrays.asList(4,7,3,9,7,2));
		ArrayList<Integer> reverseArray2= new ArrayList<Integer>(Arrays.asList(2,3,6,5,4));
		ArrayList<Integer> endToEndArray1= new ArrayList<Integer>(Arrays.asList(1,6,4,9,6,5,4));
		ArrayList<Integer> endToEndArray2= new ArrayList<Integer>(Arrays.asList(2,6,3,0,8,7));
		
		
		System.out.println("**********Test for isNonDecreasing*********");
		test(true,isNonDecreasing(nullArray1));
		test(true,isNonDecreasing(emptyArray1));
		test(false,isNonDecreasing(testArray1));
		test(true,isNonDecreasing(testArray2));
		System.out.println("**********Test done for isNonDecreasing****\n");
		
		System.out.println("**********Test for isIncreasing************");
		test(true,isIncreasing(nullArray1));
		test(true,isIncreasing(emptyArray1));
		test(false,isIncreasing(testArray1));
		test(true,isIncreasing(testArray2));
		System.out.println("**********Test done for isIncreasing*******\n");
		
		System.out.println("**********Test for reverse*****************");
		test("null",reverse(nullArray1));
		test("[]",reverse(emptyArray1));
		test("[2,7,9,3,7,4]",reverse(reverseArray1));
		test("[4,5,6,3,2]",reverse(reverseArray2));
		System.out.println("**********Test done for reverse************\n");
		
		System.out.println("**********Test for concatenate*************");
		try {
		    concatenate(null, null);
		    System.out.println("test failed - exception not thrown");
		} catch(IllegalArgumentException e) {
		    System.out.println("caught the expected illegal argument exception");
		}
		test("[1,8,6,5,7,9]",concatenate(emptyArray1,testconca1));
		test("[7,8,6,5,2]",concatenate(testconca2,emptyArray1));
		test("[1,8,6,5,7,9,7,8,6,5,2]",concatenate(testconca1,testconca2));
		System.out.println("**********Test done for concatenate********\n");
		
		System.out.println("**********Test for endToEnd****************\n");
		try {
		    concatenate(null, null);
		    System.out.println("test failed - exception not thrown");
		} catch(IllegalArgumentException e) {
		    System.out.println("caught the expected illegal argument exception");
		}
		test("[1,6,4,9,6,5,4,7,8,0,3,6,2]",endToEnd(endToEndArray1,endToEndArray2));
		test("[1,6,4,9,6,5,4,7,2,6,3,0,8,7]",endToEnd(endToEndArray1,endToEndArray2));
		test("[4,5,6,9,4,6,1]",endToEnd(emptyArray1,endToEndArray1));
		test("[1,6,4,9,6,5,4]",endToEnd(emptyArray1,endToEndArray1));
		System.out.println("**********Test done for endToEnd****************\n");
		
		System.out.println("**********Test for reverseInPlace***************");
		reverseInPlace(reverseArray1);
		test("[2,7,9,3,7,4]",reverseArray1);
		reverseInPlace(reverseArray1);
		test("[4,7,3,9,7,2]",reverseArray1);
		reverseInPlace(testArray2);
		test("[5,4,3,2,1]",testArray2);
		reverseInPlace(testArray2);
		test("[1,2,3,4,5]",testArray2);
		System.out.println("**********Test done for reverseInPlace**********");
	
		
		

	}
	public static void test(String expected, ArrayList<Integer> testArray2) {
	    System.out.println("Expected: " + expected +
	                       ", received: " + testArray2);
	}

	public static void test(ArrayList<Integer> expected, ArrayList<Integer> actual) {
	    System.out.println("Expected: " + expected +
	                       ", received: " + actual);
	}

	public static void test(boolean expected, boolean actual) {
	    System.out.println("Expected: " + expected + ", received: " + actual);
	}

}

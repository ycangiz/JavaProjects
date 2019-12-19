package lab08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Tests {
	@Test
	public  void testFactorialSimple() {
	    assertEquals(120, Recursion.factorial(5));	   
	}
	@Test
	public void testFactorialSimple1(){
		 assertEquals(1, Recursion.factorial(0));		    
	}
	@Test
	public void testFactorialSimple2(){
		assertEquals(1, Recursion.factorial(1));
	}
	
	@Test
	public void testSquareRootSimple(){
		assertEquals(5, Recursion.squareRoot(25), 1e-6);
	}
	
	@Test
	public void testSquareRootSimple1(){
		assertEquals(0, Recursion.squareRoot(0), 1e-6);
	}
	
	@Test
	public void testSumSimple(){
		ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,2,3));
		assertEquals(6, Recursion.sum(intList));
	}
	
	@Test
	public void testSumSimple1(){
		int[] intList = {1,2,3};
		assertEquals(6, Recursion.sum(intList));
	}
	
	@Test
	public void testBinomialCoefficientSimple(){
		assertEquals(5, Recursion.binomialCoefficient(5,1));
	}
	
	
	
	
	
	
	
	
	

}

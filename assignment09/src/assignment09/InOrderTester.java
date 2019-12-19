package assignment09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class InOrderTester {
	
	ArrayList<Integer> nullArr = null;
	ArrayList<Integer> emptyArr = new ArrayList<Integer>();
	ArrayList<Integer> notEmpty = new ArrayList<Integer>(Arrays.asList(2,3,1,5,4));
	ArrayList<Integer> sortedNotEmpty = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

	@Test
	public void test1() {
		assertEquals(true,Sorting.inOrder(nullArr));
	}
	
	@Test
	public void test2() {
		assertEquals(true,Sorting.inOrder(emptyArr));
	}
	
	@Test
	public void test3() {
		assertEquals(false,Sorting.inOrder(notEmpty));
	}
	
	@Test
	public void test4() {
		assertEquals(true,Sorting.inOrder(sortedNotEmpty));
	}

}

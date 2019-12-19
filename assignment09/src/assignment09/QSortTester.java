package assignment09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class QSortTester {
	
	ArrayList<Integer> nullArr = null;
	ArrayList<Integer> emptyArr = new ArrayList<Integer>();
	ArrayList<Integer> notEmpty = new ArrayList<Integer>(Arrays.asList(2,3,1,5,4));
	ArrayList<Integer> sortedNotEmpty = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

	@Test
	public void test1() {
		assertEquals(null,Sorting.qsort(nullArr));
	}
	
	@Test
	public void test2() {
		assertEquals(new ArrayList<Integer>(),Sorting.qsort(emptyArr));
	}
	
	@Test
	public void test3() {
		assertEquals(sortedNotEmpty ,Sorting.qsort(notEmpty));
	}
	
	@Test
	public void test4() {
		assertEquals(sortedNotEmpty,Sorting.qsort(sortedNotEmpty));
	}
	
	

}

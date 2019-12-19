package assignment09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SelectionTester {
	
	ArrayList<Integer> nullArr = null;
	ArrayList<Integer> emptyArr = new ArrayList<Integer>();
	ArrayList<Integer> notEmpty = new ArrayList<Integer>(Arrays.asList(2,3,1,5,4));
	ArrayList<Integer> sortedNotEmpty = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	@Test
	public void testSelection1() {
		
		assertNull(null,Sorting.selection(nullArr));
	}
	
	@Test
	public void testSelection2() {
		
		assertEquals(new ArrayList<Integer>(),Sorting.selection(emptyArr));
	}
	
	@Test
	public void testSelection3() {
		
		assertEquals(sortedNotEmpty,Sorting.selection(notEmpty));
	}
	

}

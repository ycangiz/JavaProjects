package lab09pink;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question2and3Test {
	int[] test01 = null;
    int[] test02 = {};
    int[] test03 = {5, 2, -2, 7, -5, 2};
    int[] test04 = {3, 6, -7, 5, 3, 0, 2, 1};

	@Test
	public void test1() {
		assertEquals(0.0,new Top(test01).average(),1e-6);
	}
	
	@Test
	public void test2() {
		assertEquals(0.0,new Top(test02).average(),1e-6);
	}

	@Test
	public void test3() {
		assertEquals(1.5,new Top(test03).average(),1e-6);
	}
	
	@Test
	public void test4() {
		assertEquals(1.625,new Top(test04).average(),1e-6);
	}
	@Test
	public void test5() {
		assertEquals(1.5,new Lower(test01, test03).average(),1e-6);
	}
	
	@Test
	public void test6() {
		assertEquals(1.5,new Lower(test02, test03).average(),1e-6);
	}
	
	@Test
	public void test7() {
		assertEquals(0,new Lower(test03, test02).average(),1e-6);
	}
	
	@Test
	public void test8() {
		assertEquals(1.625,new Lower(test03, test04).average(),1e-6);
	}
	
	@Test
	public void test9() {
		assertEquals(1.5,new Lower(test04, test03).average(),1e-6);
	}
	
	
	
	@Test
	public void test10() {
		assertEquals(Integer.MIN_VALUE,new Top(test01).max());
	}
	
	@Test
	public void test11() {
		assertEquals(Integer.MIN_VALUE,new Top(test02).max());
	}
	
	@Test
	public void test12() {
		assertEquals(7,new Top(test03).max());
	}
	
	@Test
	public void test13() {
		assertEquals(6,new Top(test04).max());
	}
	
	@Test
	public void test14() {
		assertEquals(6,new Lower(test01, test04).max());
	}
	
	@Test
	public void test15() {
		assertEquals(Integer.MIN_VALUE,new Lower(test02, test02).max());
	}
	
	@Test
	public void test16() {
		assertEquals(7,new Lower(test02, test03).max());
	}
	
	@Test
	public void test17() {
		assertEquals(7,new Lower(test03, test04).max());
	}
	
	@Test
	public void test18() {
		assertEquals(7,new Lower(test04, test03).max());
	}
	
	
	
	
}

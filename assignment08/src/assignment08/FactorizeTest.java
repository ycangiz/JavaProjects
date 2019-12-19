package assignment08;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class FactorizeTest {

	@Test
	public void test1() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		assertEquals(temp, Factorize.factors(0));

	}
	
	@Test
	public void test2() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		assertEquals(temp, Factorize.factors(1));
	
	}
	
	@Test
	public void test3() {
		ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 8, 10, 12, 15, 20, 24, 30, 40, 60, 120));
		assertEquals(temp, Factorize.factors(120));
	
	}
	
	@Test
	public void test4() {
		ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(61));
		assertEquals(temp, Factorize.factors(61));
	
	}
	
	@Test
	public void testBinary1() {
		assertEquals("100110", Factorize.binary(38));

	}
	
	@Test
	public void testBinary2() {
		assertEquals("100111", Factorize.binary(39));

	}
	
	@Test
	public void testReverse1() {
		assertEquals(null, Factorize.reverse(null));

	}
	
	@Test
	public void testReverse2() {
		assertEquals("", Factorize.reverse(""));
	
	}
	
	@Test
	public void testReverse3() {
		assertEquals("102 htgnel fo gnirtS", Factorize.reverse("String of length 201"));
	
	}
	
	@Test
	public void indexOf1() {
		assertEquals(-1, Factorize.indexOf("String of length 201","abc"));
	
	}
	
	@Test
	public void indexOf2() {
		assertEquals(10, Factorize.indexOf("String of length 201","length"));
	
	}
	
	@Test
	public void indexOf3() {
		assertEquals(0, Factorize.indexOf("String of length 201","String"));
	
	}
	
	@Test
	public void areaTest() {
		Point2D.Double[] pts = 
			{new Point2D.Double(1,3), new Point2D.Double(2,2),
			new Point2D.Double(2,1), new Point2D.Double(1,0),
			new Point2D.Double(0,1), new Point2D.Double(0,2)};
		assertEquals(0.5, Factorize.area(pts),1e-6);
	
	}

	
	

}

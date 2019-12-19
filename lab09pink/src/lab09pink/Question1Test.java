package lab09pink;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question1Test {

	@Test
	public void test1() {
		assertEquals("0 = 0",new Question1(0).toString());
	}
	
	@Test
	public void test2() {
		assertEquals("1 = 1", new Question1(1).toString());
	}

	@Test
	public void test3() {
		assertEquals("31 = 31", new Question1(31).toString());
	}

	@Test
	public void test4() {
		assertEquals("120 = 2 x 2 x 2 x 3 x 5", new Question1(120).toString());
	}


}

package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeConstrainTest {

	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}
	
	/**tests that it works if the inputed range is greater then the ranges highest number */
	@Test
	public void inputedGreaterThanRange() {
		double expected=1;
		double actual=exampleRange.constrain(2);
		assertEquals("When constrained input is greater than range, the output must be 1", expected,actual, .000000001d);
	}
	/**tests that it works if the inputed number is one of the boundry valus of the range */
	@Test 
	public void inputedOnRangeBoundry() {
		double expected=1;
		double actual=exampleRange.constrain(1);
		assertEquals("When constrained input is on margin of than range, the output must be 1", expected,actual, .000000001d);
	}
	/**tests if it works when the input is within the range */
	@Test
	public void inputedWithinRange() {
		double expected=0;
		double actual=exampleRange.constrain(0);
		assertEquals("When constrained input is within range, the output must be 0", expected,actual, .000000001d);
	}
	
	/**tests if it works when the inputed is less than the range */
	@Test
	public void inputedLessThanRange() {
		double expected=-1;
		double actual=exampleRange.constrain(-2);
		assertEquals("When constrained input is less than range, the output must be -1", expected,actual, .000000001d);
	}

	//we originally had a test for not a number, but we decided that because it has no mention in the requirements, we did
	//not need to test it.
	@Test (expected = InvalidParameterException.class)
	public void inputedIsNaN() {
		double expected=Double.NaN;
		double actual=exampleRange.constrain(Double.NaN);
		//System.out.println(actual);
		
		assertEquals("When constrained input is less than range, the output must be -1", expected,actual, .000000001d);
	}
	
	@After
	public void tearDown() throws Exception {
	}
}

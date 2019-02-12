package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;

public class RangeShiftTest{
	
	/**
	 * Checks for exception thrown if input is null Range object  
	 */
	@Test (expected = InvalidParameterException.class)
	public void nullBase() {
		Range.shift(null, 1);
		fail("This test should catch InvalidParameterException."); //If correct exception is caught, fail won't execute
	}
	
	/**
	 * Tests a positive delta that won't result in the Range object crossing 0
	 */
	@Test
	public void positiveDeltaNotCrossingZero() {
		Range actual = Range.shift(new Range(1, 2), 1);
		Range expected = new Range(2,3);
		assertEquals("Positive delta not crossing zero: ", expected, actual);
	}
	
	/**
	 * Tests a positive delta that results in lower bound of the Range object crossing 0
	 */
	@Test
	public void positiveDeltaCrossingZeroOneBound() {
		Range actual = Range.shift(new Range(-2, 2), 4);
		Range expected = new Range(0,6);
		assertEquals("Positive delta crossing zero for one bound: ", expected, actual);
	}
	
	/**
	 * Tests a positive delta that results in both bounds of the Range object crossing 0
	 */
	@Test
	public void positiveDeltaCrossingZeroBothBounds() {
		Range actual = Range.shift(new Range(-2, -1), 4);
		Range expected = new Range(0,0);
		assertEquals("Positive delta crossing zero for both bounds: ", expected, actual);
	}
	
	/**
	 * Tests a negative delta that won't result in the Range object crossing 0
	 */
	@Test
	public void negativeDeltaNotCrossingZero() {
		Range actual = Range.shift(new Range(-2, -1), -1);
		Range expected = new Range(-3,-2);
		assertEquals("Negative delta not crossing zero: ", expected, actual);
	}
	
	/**
	 * Tests a negative delta that results in upper bound of the Range object crossing 0
	 */
	@Test
	public void negativeDeltaCrossingZeroOneBound() {
		Range actual = Range.shift(new Range(-2, 2), -4);
		Range expected = new Range(-6,0);
		assertEquals("Negative delta crossing zero for one bound: ", expected, actual);
	}
	
	/**
	 * Tests a negative delta that results in both bounds of the Range object crossing 0
	 */
	@Test
	public void negativeDeltaCrossingZeroBothBounds() {
		Range actual = Range.shift(new Range(1, 2), -4);
		Range expected = new Range(0,0);
		assertEquals("Negative delta crossing zero for both bounds: ", expected, actual);
	}
}

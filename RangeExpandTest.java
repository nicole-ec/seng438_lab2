package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeExpandTest {
	
	private Range range, output;

	/**
	 * Check if the range passed is null and fail
	 *  the program and throw exception
	 */
	@Test (expected = InvalidParameterException.class)
	public void nullRangeTest() {
			Range.expand(null, 0.25, 0.50);
			fail("Null not permitted");
	}
	
	/**
	 * Checks if the negative lower margin 
	 * gives the expected output
	 */
	@Test
	public void negativeLowerMarginTest() {
		range = new Range(2, 6);
		output = new Range(3, 8);
		assertEquals(Range.expand(range, -0.25, 0.50), output);
	}

	/**
	 * Checks if the negative upper margin
	 * gives the expected output
	 */
	@Test
	public void negativeUpperMarginTest() {
		range = new Range(2, 6);
		output = new Range(-1, 5.20);
		assertEquals(Range.expand(range, 0.75, -0.20), output);
	}

	/**
	 * Checks if the positive margin
	 * gives the expected output
	 */
	@Test
	public void positiveMarginTest() {
		range = new Range(2, 6);
		output = new Range(1, 8);
		assertEquals(Range.expand(range, 0.25, 0.50), output);
	}

	/**
	 * Checks if the zero margin 
	 * gives the expected output
	 */
	@Test
	public void zeroMarginTest() {
		range = new Range(2, 6);
		output = new Range(2, 6);
		assertEquals(Range.expand(range, 0, 0), output);
	}
	

}

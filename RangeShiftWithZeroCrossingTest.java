package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeShiftWithZeroCrossingTest {

	/**
	 * Checks for exception thrown if input is null Range object
	 */
	@Test(expected = InvalidParameterException.class)
	public void nullBase() {
		try {
			Range.shift(null, 1);
		} catch (InvalidParameterException ex) {
			throw ex;
		} catch (Exception ex) {
		}
	}


	/**
	 * Tests a positive delta that results in lower bound of the Range object
	 * crossing 0
	 */
	@Test
	public void positiveDeltaCrossingZeroOneBound() {
		Range actual = Range.shift(new Range(-2, 2), 4,true);
		Range expected = new Range(2, 6);
		assertEquals("Positive delta crossing zero for one bound: ", expected, actual);
	}

	/**
	 * Tests a positive delta that results in both bounds of the Range object
	 * crossing 0
	 */
	@Test
	public void positiveDeltaCrossingZeroBothBounds() {
		Range actual = Range.shift(new Range(-2, -1), 4,true);
		Range expected = new Range(2, 3);
		assertEquals("Positive delta crossing zero for both bounds: ", expected, actual);
	}

	

	/**
	 * Tests a negative delta that results in upper bound of the Range object
	 * crossing 0
	 */
	@Test
	public void negativeDeltaCrossingZeroOneBound() {
		Range actual = Range.shift(new Range(-2, 2), -4,true);
		Range expected = new Range(-6, -2);
		assertEquals("Negative delta crossing zero for one bound: ", expected, actual);
	}

	/**
	 * Tests a negative delta that results in both bounds of the Range object
	 * crossing 0
	 */
	@Test
	public void negativeDeltaCrossingZeroBothBounds() {
		Range actual = Range.shift(new Range(1, 2), -4,true);
		Range expected = new Range(-3,-2);
		assertEquals("Negative delta crossing zero for both bounds: ", expected, actual);
	}

}

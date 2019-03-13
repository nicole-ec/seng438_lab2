package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeIntersectsTest {

	private Range example;
	
	@Before
	public void setUp() throws Exception{
		
		example = new Range(-2, 2);
		
	}
	/**
	 * tests that when both of the inputs are less than the range,  
	 * it does not intersect.
	 */
	@Test
	public void bothBoundariesBelowObject() {
		
		boolean result = example.intersects(-4, -3);
		assertFalse("falsely thought intersected.",result);
		
	}
	/**
	 * tests that when both of the inputs are greater than the range, it does not intersect.
	 * 
	 */
	@Test
	public void bothBoundariesAboveObject() {
		
		boolean result = example.intersects(3, 4);
		
		assertFalse("falsely thought intersected.", result);
		
	}
	
	/**
	 * tests that when both inputs are within the range, it intersects
	 */
	@Test
	public void bothBoundariesWithinObject() {
		
		boolean result = example.intersects(-1, 1);
		
		assertTrue("falsely thought did not intersect.", result);
	}
	/**
	 * tests that when the lower input is less than the range, and the
	 * larger input is within than the range, it intersects
	 */
	@Test
	public void lowerBelowAndUpperWithin() {
		
		boolean result = example.intersects(-4, 0);
		
		assertTrue("falsely thought did not intersect.", result);
		
	}
	
	/**
	 * tests that when the lower input is within the range, and the
	 * larger input is greater than the range, it intersects
	 */
	@Test
	public void lowerWithinAndUpperAbove() {
		
		boolean result = example.intersects(0, 4);
		
		assertTrue("falsely thought did not intersect.", result);
		
	}
	/**
	 * tests that when the lower input is less than the range, and the
	 * larger input is greter than the range, it intersects
	 */
	@Test
	public void lowerBelowAndUpperAbove() {
		
		boolean result = example.intersects(4, 4);
		
		assertTrue("falsely thought did not intersect.", result);
	}
//	/**
//	 * tests that when the lower input is greater than the higher input, 
//	 * an invalidParameterException is thrown.
//	 */
//	@Test (expected = InvalidParameterException.class)
//	public void lowerIsGreaterThanHigher() {
//		
//		boolean result = example.intersects(4, 3);
//				
//	}
//	
	/**
	 * tests that when the lower input is greater than the range, and the
	 * upper input is within than the range, it does not intersect
	 */
	@Test
	public void lowerAboveAndUpperWithin() {
		
		boolean result = example.intersects(4, 0);
		
		assertFalse("falsely thought intersected.", result);
		
	}
	

}

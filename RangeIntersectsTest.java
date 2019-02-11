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
	
	@Test
	public void bothBoundariesBelowObject() {
		
		boolean result = example.intersects(-4, -3);
		
		assertFalse("falsely thought intersected.",result);
		
	}
	
	@Test
	public void bothBoundariesAboveObject() {
		
		boolean result = example.intersects(3, 4);
		
		assertFalse("falsely thought intersected.", result);
		
	}
	
	@Test
	public void bothBoundariesWithinObject() {
		
		boolean result = example.intersects(-1, 1);
		
		assertTrue("falsely thought did not intersect.", result);
	}
	
	@Test
	public void lowerBelowAndUpperWithin() {
		
		boolean result = example.intersects(-4, 0);
		
		assertTrue("falsely thought did not intersect.", result);
		
	}
	
	@Test
	public void lowerWithinAndUpperAbove() {
		
		boolean result = example.intersects(0, 4);
		
		assertTrue("falsely thought did not intersect.", result);
		
	}
	
	@Test
	public void lowerBelowAndUpperAbove() {
		
		boolean result = example.intersects(4, 4);
		
		assertTrue("falsely thought did not intersect.", result);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void lowerIsGreaterThanHigher() {
		
		boolean result = example.intersects(4, 3);
		
		fail("should catch that lower is greater than upper bound.");
		
	}
	
	

}

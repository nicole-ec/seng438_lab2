package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class RangeExpandToIncludeText {
	
	private Range example;
	
	@Before
	public void setUp() throws Exception{
		example = new Range(-2, 2);
	}
	
	@Test
	public void rangeIsNull() {
		Range actual = Range.expandToInclude(null, 5);
		Range expected = new Range(5,5);
		assertEquals("When the range is null",expected, actual);
	}
	
	@Test
	public void valueWithinRange() {
		Range actual = Range.expandToInclude(example, 0);
		Range expected = example;
		assertEquals("When the value is within the range",expected, actual);
	}
	
	@Test
	public void valeAboveRange() {
		Range actual = Range.expandToInclude(example, 5);
		Range expected = new Range(-2,5);
		assertEquals("When the value is above the range", expected, actual);
	}
	
	@Test
	public void valueBelowRange() {
		Range actual = Range.expandToInclude(example, -3);
		Range expected = new Range(-3,2);
		assertEquals("When the value is below the range", expected, actual);
	}
	
}

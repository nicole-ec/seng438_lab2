package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeCombineTest {

	@Test
	public void rangeOneIsNull() {
		Range actual = Range.combine(null, new Range(0,2));
		Range expected = new Range(0,2);
		assertEquals("When range one is null", expected, actual );
	}
	
	@Test
	public void rangeTwoIsNull() {
		Range actual = Range.combine(new Range(1,2), null);
		Range expected = new Range(1,2);
		assertEquals("When range two is null", expected, actual );
	}
	
	@Test
	public void rangeOneBiggerThanRangeTwo() {
		Range actual = Range.combine(new Range(-5,5), new Range(0,2));
		Range expected = new Range(-5,5);
		assertEquals("When range one is bigger than range two", expected, actual);
	}

}

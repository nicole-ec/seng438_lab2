package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeGetCentralValueTest {

private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}
	
	@Test 
	public void getCentralValueOfValidRange() {
		double actual = exampleRange.getCentralValue();
		double expected = 0;
		assertEquals("When range is valid and calculating the central value",expected, actual);
	}

}

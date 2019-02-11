package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Creates a sample object of the class being tested.
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
		
		
	}
	
	@Test
	public void compareTwo() {
		
		Range compare = new Range(-2, 1);
		assertEquals(exampleRange, compare);
		
	}

	
	/**
	 * Tests for values lower than the specified range.
	 */
	@Test
	public void outOfLowerRange() {

		boolean result = exampleRange.contains(-2);

		assertFalse("Value -2 should be out of range.", result);

	}

	/**
	 * Tests if lower bound is included in the range.
	 * 
	 */
	@Test
	public void lowerWithinRange() {

		boolean result = exampleRange.contains(-1);

		assertTrue("Lower bound value should be within range.", result);

	}

	/**
	 * Tests for values within the range
	 */
	@Test
	public void withinRange() {

		boolean result = exampleRange.contains(0);

		assertTrue("Value 0 should be within range.", result);

	}

	/**
	 * Tests if upper bound is within the specified range.
	 */
	@Test
	public void upperWithinRange() {

		boolean result = exampleRange.contains(1);

		assertTrue("Upper bound value should be within range.", result);

	}

	/**
	 * Tests for values greater than the specified range.
	 */
	@Test
	public void outOfUpperRange() {

		boolean result = exampleRange.contains(2);

		assertFalse("Value 2 should be out of range.", result);

	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
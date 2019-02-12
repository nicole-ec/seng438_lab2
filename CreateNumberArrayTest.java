package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.*;

public class CreateNumberArrayTest {
	
	/**
	 * Checks for exception thrown if input is null array 
	 */
	@Test (expected = InvalidParameterException.class)
	public void nullArray() {
		DataUtilities.createNumberArray(null);
		fail("This test should catch InvalidParameterException.");	//If correct exception is caught, fail won't execute
	}
	
	/**
	 * Tests an input of a valid array of doubles
	 */
	@Test
	public void filledArray() {
		double[] array = {1.0,2.5,3.7};
		Number[] expected = {1.0,2.5,3.7};
		Number[] actual = DataUtilities.createNumberArray(array);
		assertArrayEquals("Creation of valid array: ", expected, actual);
	}
	
	/**
	 * Tests an input of an empty array
	 */
	@Test
	public void emptyArray() {
		double[] array = {};
		Number[] expected = {};
		Number[] actual = DataUtilities.createNumberArray(array);
		assertArrayEquals("Creation of empty array: ", expected, actual);
	}
	
}

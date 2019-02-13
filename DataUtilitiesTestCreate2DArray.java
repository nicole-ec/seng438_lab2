package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesTestCreate2DArray {
	
	private double [][] arr1 = {}, arr2 = {
			{2.0,4.0,6.0,8.0},
			{3.0,6.0,9.0,12.0},
			{4.0,8.0,12.0,16.0}
	};
	
	
	private Number [][] numarr1 = {}, numarr2 = {
			{2.0,4.0,6.0,8.0},
			{3.0,6.0,9.0,12.0},
			{4.0,8.0,12.0,16.0}
	};
	
	/**
	 * Checks if double array is null and throw exception
	 */
	@Test (expected = InvalidParameterException.class)
	public void nullTest() {
		try {
			numarr1 = DataUtilities.createNumberArray2D(null);
		} catch(InvalidParameterException ex) {
			throw ex;
		} catch(Exception ex) {
		}
	}

	/**
	 * Check is the values are stored correctly in the array
	 */
	@Test 
	public void twoDimensionayArrayEqualsTest() {
		numarr1 = DataUtilities.createNumberArray2D(arr2);
		assertArrayEquals( numarr2, numarr1); 
	}
	
	/**
	 * Test an empty double array
	 */
	@Test
	public void emptyTest() {
		numarr1 = DataUtilities.createNumberArray2D(arr1);
		assertArrayEquals(arr1, numarr1);
	}
}

package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesCalculateRow {

	private Mockery mock;
	private Values2D values;
	
	@Before
	public void setUp() throws Exception {
		
		mock = new Mockery();
		values = mock.mock(Values2D.class);
		
	}

	/**
	 * Tests for an exception when a null object is passed.
	 */
	@Test (expected = InvalidParameterException.class)
	public void nullTable(){
		double result = DataUtilities.calculateRowTotal(null, 0);
		
		//if the exception is thrown, fail() should not execute.
		fail("This test should catch InvalidParameterException.");
	}
	
	/**
	 * Tests for an empty table with no values.
	 */
	@Test
	public void emptyTable() {
		
		mock.checking(new Expectations() {
			
			{
				one(values).getColumnCount();
				will(returnValue(0));
			}
			
		});
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		
		assertEquals(0, result, 0.000000001d);
		
	}
	
	/**
	 * Tests for a row index that is below zero.
	 * 
	 * 
	 */
	@Test 
	public void rowTotalForNegativeRow() {
		
		mock.checking(new Expectations() {
			
			{
				one(values).getColumnCount();
				will(returnValue(3));
				
				one(values).getValue(-1, 0);
				will(returnValue(null));
				
				one(values).getValue(-1, 1);
				will(returnValue(null));
				
				one(values).getValue(-1, 2);
				will(returnValue(null));
				
			}
			
		});
		
		double result = DataUtilities.calculateRowTotal(values, -1);
		
		assertEquals(0, result, 0.000000001d);
		
	}
	
	/**
	 * Tests for a valid row index and addition of negative values.
	 * 
	 * FAIL: FORGETS TO INCLUE THE LAST ROW
	 */
	@Test
	public void rowTotalForNegativeValues() {		
		
		mock.checking(new Expectations() {
			
			{
				one(values).getColumnCount();
				will(returnValue(4));
				
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				
				one(values).getValue(0, 1);
				will(returnValue(-2.5));
				
				one(values).getValue(0, 2);
				will(returnValue(-3));
				
				one(values).getValue(0, 3);
				will(returnValue(-3));
				
			}
			
		});
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		
		assertEquals(-16.0, result, 0.000000001d);
		
	}
	
	
	/**
	 * Tests for a valid row index and addition of positive values.
	 * 
	 * FAIL: FORGETS TO INCLUDE THE LAST ROW
	 */
	@Test
	public void rowTotalForPositiveValues() {
		
		mock.checking(new Expectations() {
			
			{
				one(values).getColumnCount();
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				
				one(values).getValue(0, 1);
				will(returnValue(2.5));
				
				one(values).getValue(0, 2);
				will(returnValue(3));
				
			}
			
		});
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		
		assertEquals(13.0, result, 0.000000001d);
		
	}
	
	/**
	 * Tests for a row index that is greater than the number of actual columns.
	 * 
	 * 
	 */
	@Test
	public void rowTotalForOutOfBoundsColumn() {
		
		mock.checking(new Expectations() {
			
			{
				one(values).getColumnCount();
				will(returnValue(3));
				
				one(values).getValue(1, 0);
				will(returnValue(null));
				
				one(values).getValue(1, 1);
				will(returnValue(null));
				
				one(values).getValue(1, 2);
				will(returnValue(null));
				
			}
			
		});
		
		double result = DataUtilities.calculateRowTotal(values, 1);
		
		assertEquals(0, result, 0.00000001d);
		
	}

}

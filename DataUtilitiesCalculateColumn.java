package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesCalculateColumn{

	private Mockery mock;
	private Values2D values;
	
	@Before
	public void setUp() throws Exception{
		
		mock = new Mockery();
		values = mock.mock(Values2D.class);
		
	}
	
	/**
	 * Tests for an exception when a null object is passed.
	 */
	@Test (expected = InvalidParameterException.class)
	public void nullTable(){
		double result = DataUtilities.calculateColumnTotal(null, 0);
		
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
				one(values).getRowCount();
				will(returnValue(0));
			}
			
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		assertEquals(0, result, 0.000000001d);
		
	}
	
	/**
	 * Tests for a column index that is below zero.
	 * 
	 * FAILS; RETURNS ROW COUNT
	 */
	@Test 
	public void columnTotalForNegativeColumn() {
		
		mock.checking(new Expectations() {
			
			{
				one(values).getRowCount();
				will(returnValue(3));
				
				one(values).getValue(0, -1);
				will(returnValue(null));
				
				one(values).getValue(1, -1);
				will(returnValue(null));
				
				one(values).getValue(2, -1);
				will(returnValue(null));
				
			}
			
		});
		
		double result = DataUtilities.calculateColumnTotal(values, -1);
		
		assertEquals(0, result, 0.000000001d);
		
	}
	
	/**
	 * Tests for a valid column index and addition of negative values.
	 */
	@Test
	public void columnTotalForNegativeValues() {
//		fail("Not yet implemented");
		
		
		mock.checking(new Expectations() {
			
			{
				one(values).getRowCount();
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				
				one(values).getValue(1, 0);
				will(returnValue(-2.5));
				
				one(values).getValue(2, 0);
				will(returnValue(-3));
				
			}
			
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		assertEquals(-13.0, result, 0.000000001d);
		
	}
	
	
	/**
	 * Tests for a valid column index and addition of positive values.
	 */
	@Test
	public void columnTotalForPositiveValues() {
//		fail("Not yet implemented");
		
		mock.checking(new Expectations() {
			
			{
				one(values).getRowCount();
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				
				one(values).getValue(1, 0);
				will(returnValue(2.5));
				
				one(values).getValue(2, 0);
				will(returnValue(3));
				
			}
			
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		assertEquals(13.0, result, 0.000000001d);
		
	}
	
	/**
	 * Tests for a column index that is greater than the number of actual columns.
	 * 
	 * FAILS: RETURNS ROW COUNT
	 */
	@Test
	public void columnTotalForOutOfBoundsColumn() {
		
		mock.checking(new Expectations() {
			
			{
				one(values).getRowCount();
				will(returnValue(3));
				
				one(values).getValue(0, 1);
				will(returnValue(null));
				
				one(values).getValue(1, 1);
				will(returnValue(null));
				
				one(values).getValue(2, 1);
				will(returnValue(null));
				
			}
			
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		
		assertEquals(0, result, 0.00000001d);
		
	}

}

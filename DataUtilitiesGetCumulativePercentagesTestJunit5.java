package org.jfree.data.test;

import static org.jfree.data.DataUtilities.getCumulativePercentages;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class DataUtilitiesGetCumulativePercentagesTestJunit5 {

	
	
/**
 * Creates a mock object simulating a KeyedValues object
 * @param keys the keys that each value would be mapped to
 * @param outputs the value that each key is mapped to
 * @return a KeyedValues mockery which has each key mapped to each output
 */
	public KeyedValues createMockery(List<String> keys, List<Double> outputs) {
		Mockery mockingContext = new Mockery();
		KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
		{
			//set the getIndex for each key to be its index
			for(int i=0;i<keys.size();i++) {
				allowing(values).getIndex(keys.get(i));
				will(returnValue(i));
			}
			//set the getKey for each index to be the respective key
			for(int i=0;i<keys.size();i++) {
				allowing(values).getKey(i);
				will(returnValue(keys.get(i)));
			}
			//set the getKeys to return the set of keys it has
			allowing(values).getKeys();
			will(returnValue(keys));
			//set the getValue for each key to return the respective value
			for(int i=0;i<outputs.size();i++) {
				allowing(values).getValue(keys.get(i));
				will(returnValue(outputs.get(i)));
			}
			//set the getValue for each index to return the respective value
			for(int i=0;i<outputs.size();i++) {
				allowing(values).getValue(i);
				will(returnValue(outputs.get(i)));
			}
			//set getItemCount to return the number of items
			allowing(values).getItemCount();
				will(returnValue(outputs.size()));
		}
		});
		return values;
	}
	/**
	 * tests if you input null as the parameter, it throws an InvalidParameterException
	 */
	@Test
	public void nullValues() {
		assertThrows(InvalidParameterException.class, ()->{
			getCumulativePercentages(null);
		});
		
	}
	
	/**
	 * tests if it handles an empty KeyedValues object
	 */
	@Test
	public void emptyValues() {
		List<String> keys= Arrays.asList();
		List<Double> doubleValues=Arrays.asList();
		KeyedValues values=createMockery(keys, doubleValues);

		
		
		KeyedValues output= getCumulativePercentages(values);
		int expected=0;
		int actual=output.getItemCount();
		
		assertEquals("entering an emtpy KeyedValues should give back an empty keyedValues", expected,actual);
	}
/**
 * tests if it throws an InvalidParameterException when you input an KeyedValues object that has
 * 0 as the sum of its valeus
 */
@Test
public void zeroValues() {	
	List<String> keys= Arrays.asList("key0");
	List<Double> doubleValues=Arrays.asList(0.0);
	KeyedValues mock=createMockery(keys, doubleValues);
 	
	assertThrows(InvalidParameterException.class, ()->{
		KeyedValues output=getCumulativePercentages(mock);
	});
}
/**
 * Tests that when a normal set of values is inputed, that it can calculate the percent of each correctly.
 * It does this by creating series of tests that each test if 1 input was calculated correctly.
 *  
 * @return a series of tests that each calculate if 1 value is inputed correctly. 
 */
@TestFactory
public List<DynamicTest> fullValues() {	
	List<String> fullKeyedKeys= Arrays.asList("key1","key2","key3","key4","key5");
	List<Double> fullKeyedDoubleValues=Arrays.asList(1.0,2.0,3.0,4.0,5.0);
	List<Double> fullKeyedExpectedValues=Arrays.asList(.066666666667,.13333333334,.2,.2666666666,.3333333334);
	ArrayList<DynamicTest> tests=new ArrayList<DynamicTest>();
	
	KeyedValues values=createMockery(fullKeyedKeys, fullKeyedDoubleValues);
	KeyedValues output= getCumulativePercentages(values);
		
		for(int i=0;i<fullKeyedKeys.size();i++) {
			String keyTested=fullKeyedKeys.get(i);
			double expected=fullKeyedExpectedValues.get(i);
			double actual=output.getValue(keyTested).doubleValue();
			tests.add(DynamicTest.dynamicTest("cumulative value for "+keyTested+" is inaccurate", ()->{
				assertEquals("Outputed percentages are inaccurate", expected,actual,.000000001d);
			}));
		}
		return tests;
	}
}

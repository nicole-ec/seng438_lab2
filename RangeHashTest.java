package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeHashTest {

	
	@Test
	public void sameHashCode() {
		
		Range obj1 = new Range(0,9);
		Range obj2 = new Range(0,9);
		
		int hash1 = obj1.hashCode();
		int hash2 = obj2.hashCode();
		
		assertEquals("The hash codes don't match.",hash1, hash2);
		
	}
	
	@Test
	public void diffHashCodes() {
		
		Range obj1 = new Range(0,9);
		Range obj2 = new Range(1,3);
		
		int hash1 = obj1.hashCode();
		int hash2 = obj2.hashCode();
		
		assertFalse("The two hash codes are the same.",hash1 == hash2);
		
		
	}
}

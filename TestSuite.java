package org.jfree.data.test;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	DataUtilitiesCalculateColumn.class, 
	DataUtilitiesCalculateRow.class,
	DataUtilitiesCreateNumberArrayTest.class,
	DataUtilitiesGetCumulativePercentagesTest.class,
	DataUtilitiesTestCreate2DArray.class,
	RangeConstrainTest.class,
	RangeContainsTest.class,
	RangeExpandTest.class,
	RangeIntersectsTest.class,
	RangeShiftTest.class,
	RangeExpandToIncludeTest.class,
	RangeCombineTest.class,
	RangeGetCentralValueTest.class,
	RangeHashCodeTest.class,
	RangeShiftWithZeroCrossingTest.class,
	})

public class TestSuite {
	public static void main(String[] args) {
		Result result=JUnitCore.runClasses(TestSuite.class);
		for(Failure f:result.getFailures()) {
			System.out.println(f.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}

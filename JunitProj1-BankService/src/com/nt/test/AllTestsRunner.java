package com.nt.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*@RunWith(Suite.class)
@SuiteClasses({ BankServiceTestCases.class })
*/public class AllTestsRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BankServiceTestCases.class);
		System.out.println("Run Count::"+result.getRunCount());
		System.out.println("Failure Count::"+result.getFailureCount());
		System.out.println("Ignore Count::"+result.getIgnoreCount());
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

	}

}

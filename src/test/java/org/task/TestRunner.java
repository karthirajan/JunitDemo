package org.task;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({Flipkart.class,Amazon.class})

public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(Flipkart.class,Amazon.class);
		
		int i = result.getFailureCount();
		System.out.println("Total failures are :"+i);
		
		List<Failure> failures = result.getFailures();
		for (Failure failure : failures) {
			
			System.out.println("Failures are :"+failure);
			
		}
		
		int j = result.getIgnoreCount();
		System.out.println("Total Ignore count :"+j);
		
		int k = result.getRunCount();
		System.out.println("Total run count :"+j);
		
		long l = result.getRunTime();
		System.out.println("Total run time :"+l);
		
	}

}

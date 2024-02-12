package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	//This method will check if the test result fails if it fails it reruns the method
	 private int retryCount = 0;
	  private static final int maxRetryCount = 3;

	  @Override
	  public boolean retry(ITestResult result) {
	    if(!result.isSuccess())
	    {
		  if (retryCount < maxRetryCount) {
	      retryCount++;
	      return true;
	    }
	    }
	    return false;
	  }
	}
	



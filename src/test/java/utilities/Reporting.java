package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Reporting implements ITestListener{
	
	private static ExtentReports extent;
	
	
	
	protected ExtentTest test;
	
    public static ExtentReports getInstance() {
    	
    	
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
            extent.attachReporter(sparkReporter);
            // Other configuration options
        }
        return extent;
    }

    public void onTestStart(ITestResult result) {
    	test = extent.createTest(result.getMethod().getMethodName());
      }

      public void onTestSuccess(ITestResult result) {
    	  test = extent.createTest(result.getMethod().getMethodName());
    	  
      }

      public void onTestFailure(ITestResult result) {
    	  test = extent.createTest(result.getMethod().getMethodName());
      }

      public void onTestSkipped(ITestResult result) {
    	  test = extent.createTest(result.getMethod().getMethodName());
      }

      public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    	  test = extent.createTest(result.getMethod().getMethodName());
      }

      public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
        test = extent.createTest(result.getMethod().getMethodName());
      }

      public void onFinish(ITestContext context) {
       
      }
    

}

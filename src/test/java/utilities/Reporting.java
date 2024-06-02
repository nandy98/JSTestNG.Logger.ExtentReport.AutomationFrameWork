package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Reporting {
	
	private static ExtentReports extent;

	
    public static ExtentReports getInstance() {
    	
    	
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
            extent.attachReporter(sparkReporter);
            // Other configuration options
        }
        return extent;
    }

}

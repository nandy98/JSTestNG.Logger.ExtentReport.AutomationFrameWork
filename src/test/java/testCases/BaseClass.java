package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ReadConfig;
import utilities.Reporting;


public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	protected ExtentReports extent = Reporting.getInstance();
    protected ExtentTest test;
	
    @BeforeClass
	@Parameters("br")
	
	public void setup(@Optional("chrome")String br) {
		
		
		if(br.equals("chrome")) {
		driver = new ChromeDriver();
		
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new InternetExplorerDriver();
		}
		System.setProperty("log4j.configurationFile", "log4j2.xml");
		logger = LogManager.getLogger(getClass());
		logger.info("Driver Launched");
		test = extent.createTest("Driver Launched");
		}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		logger.info("Driver quit");
		extent.flush();
	}
}


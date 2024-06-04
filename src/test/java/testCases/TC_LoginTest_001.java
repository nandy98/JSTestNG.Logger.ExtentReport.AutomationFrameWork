package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	
	
	@Test
	public void loginTest() throws IOException {
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		logger.info("baseUrl Openned");
		test = extent.createTest("baseUrl Openned");
		lp.setUserName(username);
		logger.info("Entered UserName");
		test = extent.createTest("Entered UserName");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Page submitted");
		
		//  HomePage
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Title matched");
			
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("title not matched");
			
		}
	}
}

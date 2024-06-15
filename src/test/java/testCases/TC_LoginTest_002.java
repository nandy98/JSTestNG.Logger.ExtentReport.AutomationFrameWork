package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_002 extends BaseClass {
	
	@Test
	public void loginAlertTest() throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		driver.get(baseUrl);
		lp.setUserName("UserName");
		logger.info("hard Coded-UserName");
		
		lp.setPassword("Password");
		logger.info("Hard corded-password");
		logger.info("Password provided");
		lp.clickSubmit();
		
		
		
		logger.info("Logged-In Again");
		//test = extent.createTest("Logged-In Again");
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			logger.warn("Login Failed");
			test = extent.createTest("Failed");
			Assert.assertTrue(false);
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			test = extent.createTest("Passed");
			lp.clickLogout();
			
			driver.switchTo().alert().accept();
			
			driver.switchTo().defaultContent();
			
		}
		
		System.out.println("Code executed til here");
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}

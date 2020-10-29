package com.netbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
	
		lp.clickSubmit();
		
		String HomePageActualTitle=driver.getTitle();
		
		System.out.println("Home Page Title is: "+HomePageActualTitle);
		
		if(HomePageActualTitle.equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}
		else {
			System.out.println("Failed test case");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
		
		//Assert.assertEquals(HomePageActualTitle, "Guru99 Bank Manager HomePage");
	}
}

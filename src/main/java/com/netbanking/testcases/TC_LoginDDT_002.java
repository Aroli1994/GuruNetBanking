package com.netbanking.testcases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPage;
import com.netbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("user name provided");
		
		lp.setPassword(pwd);
		logger.info("password provided");
		
		lp.clickSubmit();

		Thread.sleep(3000);
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept(); // close invalid credentials alert
			driver.switchTo().defaultContent(); // to focus back driver on login page from alert
			Assert.assertTrue(false); // because it is failure case
			logger.warn("login failed");
		} else {
			Assert.assertTrue(true); // because it is passed case
			logger.info("login passed");
			
			lp.explicitWait(driver);
			
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close the logout alert
			driver.switchTo().defaultContent(); //to focus driver back to login page
		}
	}

	public boolean isAlertPresent() { // user defined method to check alert present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/main/java/com/netbanking/testdata/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println("row: "+rownum);
		System.out.println("columns: "+colcount);

		String loginData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return loginData;
	}
}

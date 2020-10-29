package com.netbanking.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.AddCustomerPage;
import com.netbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");

		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addCust = new AddCustomerPage(driver);

		addCust.explicitWait(driver);
		
		
		addCust.clickAddCustomer();
		
		logger.info("providing customer details...");

		addCust.customerName("Vinay");
		addCust.customerGender("male");
		addCust.customerDob("20", "10", "1994");
		Thread.sleep(5000);
		addCust.customerAddress("INDIA");
		addCust.customerCity("BLR");
		addCust.customerState("KA");
		addCust.customerPinNo("560087");
		addCust.customerTelephoneNo("8197299756");

		// because email id is unique so created dynamic email id using
		// RandomeStringUtils class in java
		System.out.println("For reference only-->Random number generated: "+randomNumber());
		System.out.println("Random string generated: "+randomString());
		String email = randomString() + "@gmail.com";
		addCust.customerEmailId(email);
		addCust.customerPassword("abcdef");
		addCust.customerSubmit();

		WebElement customerIdValueEle=driver.findElement(By.xpath("//table[@id='customer']//tbody/tr[4]/td[2]"));
		WebElement customerIDNameEle=driver.findElement(By.xpath("//table[@id='customer']//tbody/tr[4]/td[1]"));
		System.out.println(customerIDNameEle.getText()+" : "+customerIdValueEle.getText());
		Thread.sleep(3000);

		
		
		logger.info("validation started...");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (result == true) {
			Assert.assertTrue(true);
			logger.info("addNewCustomer passed");
		} else {
			logger.info("addNewCustomer failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}

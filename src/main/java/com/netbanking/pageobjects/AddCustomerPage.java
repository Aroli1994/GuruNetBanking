package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

//	@FindBy(how = How.LINK_TEXT, using = "New Customer")
//	@CacheLookup
//	WebElement lnkAddCustomer;
	
	@FindBy(how=How.XPATH,using="//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinNo;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailID;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement btnReset;

	// Actions or methods

	
	public void clickAddCustomer() {
		lnkAddCustomer.click();
	}

	public void customerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void customerGender(String cgender) {
		rdGender.click();
	}

	public void customerDob(String mm, String dd, String yyyy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yyyy);
	}

	public void customerAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}

	public void customerCity(String ccity) {
		txtCity.sendKeys(ccity);
	}

	public void customerState(String cstate) {
		txtState.sendKeys(cstate);
	}

	public void customerPinNo(String cpinno) {
		txtPinNo.sendKeys(String.valueOf(cpinno)); // in case user passes value as Integer, we need to convert to String
													// because sendKeys only accepts String but not Integer
	}

	public void customerTelephoneNo(String ctelephoneno) {
		txtTelephoneNo.sendKeys(String.valueOf(ctelephoneno));
	}

	public void customerEmailId(String cemailid) {
		txtEmailID.sendKeys(cemailid);
	}

	public void customerPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}

	public void customerSubmit() {
		btnSubmit.click();
	}

	//Optional explicit wait method
	public void explicitWait(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(lnkAddCustomer));
	}

}

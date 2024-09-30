package com.comcast.crm.objectrepositoryutility.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement vendorPlus;

	public WebElement getvendorPlus() {
		return vendorPlus;
	}
}

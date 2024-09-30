package com.comcast.crm.objectrepositoryutility.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage {
	public VendorInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(@id,'dtlview_Vendor Name')]")
	private WebElement vINameTxtf;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement vIPhoneTxtf;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vIHeaderMsg;

	public WebElement getvINameTxtf() {
		return vINameTxtf;
	}

	public WebElement getvIPhoneTxtf() {
		return vIPhoneTxtf;
	}

	public WebElement getvIHeaderMsg() {
		return vIHeaderMsg;
	}


}

package com.comcast.crm.objectrepositoryutility.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	public CreateNewVendorPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "vendorname")
	private WebElement vNameTxtf;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement vSavebtn;
	
	@FindBy(id = "phone")
	private WebElement vPhoneTxtf;
	
	@FindBy(id="search_txt")
	private WebElement vSearchTxtf;
	
	@FindBy(xpath="//input[contains(@value,'  Search Now  ')]")
	private WebElement vSearchNowTxtf;
	
	
	public WebElement getvSearchTxtf() {
		return vSearchTxtf;
	}

	public WebElement getvSearchNowTxtf() {
		return vSearchNowTxtf;
	}

	public WebElement getvNameTxtf() {
		return vNameTxtf;
	}

	public WebElement getvSavebtn() {
		return vSavebtn;
	}

	public WebElement getvPhoneTxtf() {
		return vPhoneTxtf;
	}
	
	public void createVendor(String venName,String vphone)
	{
		getvNameTxtf().sendKeys(venName);
		getvPhoneTxtf().sendKeys(vphone);
		getvSavebtn().click();
	}
	
	
	
}

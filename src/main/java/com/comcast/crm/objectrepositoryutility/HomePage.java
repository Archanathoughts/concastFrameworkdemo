package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class HomePage {
	WebdriverUtility wLib=new WebdriverUtility();
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement OrgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campignlnk;
		
	@FindBy(linkText="Products")
	private WebElement productlnk;
	
	@FindBy(linkText="Vendors")
	private WebElement Vendorslnk;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OppLnk;
		
	@FindBy(linkText="Purchase Order")
	private WebElement PurOrdLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(linkText="Sales Order")
	private WebElement salesOrderLnk;
		
	
	public WebElement getSalesOrderLnk() {
		return salesOrderLnk;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVendorslnk() {
		return Vendorslnk;
	}

	public WebElement getProductlnk() {
		return productlnk;
	}
	
	public WebElement getPurOrdLnk() {
		return PurOrdLnk;
	}

	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOppLnk() {
		return OppLnk;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getCampignlnk() {
		return campignlnk;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	
	public void navigateToCampaginPage() throws InterruptedException
	{
		Actions act=new Actions(driver);
		//wLib.waitForElementPresent(driver, moreLink);
		act.moveToElement(moreLink).perform();
		Thread.sleep(1000);
		campignlnk.click();
		
	}
	public void navigateToVendorPage() throws InterruptedException
	{
		Actions act=new Actions(driver);
		//wLib.waitForElementPresent(driver, moreLink);
		act.moveToElement(moreLink).perform();
		Thread.sleep(2000);
		Vendorslnk.click();
		
	} 
	
	public void navigateToSalesOrder() throws InterruptedException
	{
		Actions act=new Actions(driver);
		//wLib.waitForElementPresent(driver, moreLink);
		
		act.moveToElement(moreLink).perform();
		Thread.sleep(2000);
		salesOrderLnk.click();
	}
	
	public void navigateToPurchaseOrderPage() throws InterruptedException
	{
		Actions act=new Actions(driver);
		//wLib.waitForElementPresent(driver, moreLink);
		act.moveToElement(moreLink).perform();
		Thread.sleep(2000);
		PurOrdLnk.click();
		
	}


	
	public void logout()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(adminImg).perform();
		signOutLnk.click();
	}
	

}

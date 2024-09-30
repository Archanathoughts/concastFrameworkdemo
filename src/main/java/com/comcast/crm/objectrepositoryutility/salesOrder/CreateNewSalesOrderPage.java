package com.comcast.crm.objectrepositoryutility.salesOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewSalesOrderPage {
	WebdriverUtility wLib=new WebdriverUtility();
	WebDriver driver;
	public CreateNewSalesOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement oppNamePlus;
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subjTxt;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[4]")
	private WebElement orgNamePlus;
	
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billTxtArea;
		
	@FindBy(xpath = "(//input[@name='cpy'])[2]")
	private WebElement copybillradio;
	
	
	@FindBy(xpath = "//img[@src='themes/images/products.gif']")
	private WebElement productImg;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	
	@FindBy(name="search_text")
	private WebElement oppSearchTxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement oppSearchNow;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement orgSearchTxt;
	
	@FindBy(id="search_txt")
	private WebElement orgSearchNow;
	
	@FindBy(id="search_txt")
	private WebElement proSearchTxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement proSearchNow;
	


	


	public WebdriverUtility getwLib() {
		return wLib;
	}

	public WebElement getProSearchTxt() {
		return proSearchTxt;
	}

	public WebElement getProSearchNow() {
		return proSearchNow;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOppSearchTxt() {
		return oppSearchTxt;
	}

	public WebElement getOppSearchNow() {
		return oppSearchNow;
	}

	public WebElement getOrgSearchTxt() {
		return orgSearchTxt;
	}

	public WebElement getOrgSearchNow() {
		return orgSearchNow;
	}

	public WebElement getOppNamePlus() {
		return oppNamePlus;
	}

	public WebElement getOrgNamePlus() {
		return orgNamePlus;
	}


	public WebElement getBillTxtArea() {
		return billTxtArea;
	}


	public WebElement getCopybillradio() {
		return copybillradio;
	}


	public WebElement getProductImg() {
		return productImg;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getSubjTxt() {
		return subjTxt;
	}
	
	public void createSalesOrder(String subj,String oppName,String orgName,String billAddr,String proName) throws InterruptedException
	{
		subjTxt.sendKeys(subj);
		oppNamePlus.click();
		wLib.switchToTabOnUrl(driver,"module=Potentials");
		
		oppSearchTxt.sendKeys(oppName);
		oppSearchNow.click();
		driver.findElement(By.xpath("//a[text()='"+oppName+"']")).click();
		wLib.switchToTabOnUrl(driver, "Sales Order");
		
		orgNamePlus.click();
		wLib.switchToTabOnTitle(driver, "Accounts&action");
		orgSearchTxt.sendKeys(orgName);
		orgSearchNow.click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//wLib.switchToAlertAndAccept(driver);
	wLib.switchToTabOnTitle(driver, "module=SalesOrder");
		
		billTxtArea.sendKeys(billAddr);
		copybillradio.click();
		
		productImg.click();
		wLib.switchToTabOnUrl(driver,"module=Products");
		proSearchTxt.sendKeys(proName);
		proSearchNow.click();
		driver.findElement(By.xpath("//a[text()='"+proName+"']")).click();
		wLib.switchToTabOnUrl(driver, "module=SalesOrder");
		saveBtn.click();
	
	}
	public void createSalesOrderWithOrg(String subj,String orgName,String billAddr,String proName) throws InterruptedException
	{
		subjTxt.sendKeys(subj);
				
		orgNamePlus.click();
		wLib.switchToTabOnTitle(driver, "Accounts&action");
		orgSearchTxt.sendKeys(orgName);
		orgSearchNow.click();	
		System.out.println("inside org window" +driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//wLib.switchToAlertAndAccept(driver);
	    wLib.switchToTabOnTitle(driver, "module=SalesOrder");
	    System.out.println("in sales order page  "+driver.getTitle());
		
		billTxtArea.sendKeys(billAddr);
		copybillradio.click();
		
		productImg.click();
		wLib.switchToTabOnUrl(driver,"module=Products");
		proSearchTxt.sendKeys(proName);
		proSearchNow.click();
		driver.findElement(By.xpath("//a[text()='"+proName+"']")).click();
		wLib.switchToTabOnUrl(driver, "module=SalesOrder");
		saveBtn.click();	
	}
	
}

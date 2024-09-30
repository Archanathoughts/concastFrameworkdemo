package com.comcast.crm.objectrepositoryutility.Opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewOppurtunityPage {
	WebDriver driver;
	WebdriverUtility wLib=new WebdriverUtility();
	public CreateNewOppurtunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "potentialname")
	private WebElement oppNameTxt;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relatedPlus;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement orgSearchtxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement orgsearchNowBtn;
		
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement campSourcePlus;
	
	@FindBy(id = "search_txt")
	private WebElement campSearchtxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement campsearchNowBtn;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement oppSaveBtn;


	public WebElement getOppNameTxt() {
		return oppNameTxt;
	}


	public WebElement getRelatedPlus() {
		return relatedPlus;
	}


	public WebElement getOrgSearchtxt() {
		return orgSearchtxt;
	}


	public WebElement getOrgsearchNowBtn() {
		return orgsearchNowBtn;
	}


	public WebElement getCampSourcePlus() {
		return campSourcePlus;
	}


	public WebElement getCampSearchtxt() {
		return campSearchtxt;
	}


	public WebElement getCampsearchNowBtn() {
		return campsearchNowBtn;
	}


	public WebElement getOppSaveBtn() {
		return oppSaveBtn;
	}
	
	public void createNewOppertunity(String OppName,String OrgName,String campName) throws InterruptedException
	{
		oppNameTxt.sendKeys(OppName);
		relatedPlus.click();
		wLib.switchToTabOnUrl(driver, "module=Accounts");
		orgSearchtxt.sendKeys(OrgName);
		orgsearchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		wLib.switchToTabOnUrl(driver, "module=Potentials");
		
		campSourcePlus.click();
		wLib.switchToTabOnUrl(driver,"module=Campaigns");
		campSearchtxt.sendKeys(campName);
		campsearchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+campName+"']")).click();
		wLib.switchToTabOnUrl(driver, "module=Potentials");
		oppSaveBtn.click();
	}
	
}

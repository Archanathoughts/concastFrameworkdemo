package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class OrganizationPage {

	WebDriver driver;
	
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement creatOrgImg;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searcFieldDropd;
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searcFieldTxt;
	
	@FindBy(xpath = "//input[contains(@name,'submit')]")
	private WebElement searcNow;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(xpath="//tr[@class='lvtColData']/td/input[@name='selected_id']")
	private WebElement selectcheckbox;
	
	public WebElement getSelectcheckbox() {
		return selectcheckbox;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getSearcFieldTxt() {
		return searcFieldTxt;
	}


	public WebElement getSearcNow() {
		return searcNow;
	}


	public WebElement getOrgLnk() {
		return orgLnk;
	}

	
	public WebElement getSearcFieldDropd() {
		return searcFieldDropd;
	}

	
	
	public WebElement getCreatOrgImg() {
		return creatOrgImg;
	}
	
	public void deleteOrg(WebElement searcFieldDropd,String OrgName )
	{
		//WebElement searcFieldDropd
		Select sel=new Select(searcFieldDropd);
		sel.selectByVisibleText("Organization Name");
		searcFieldTxt.sendKeys(OrgName);
		searcNow.click();
		//selectcheckbox.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']/../../td[8]/a[text()='del']")).click();
		WebdriverUtility wd=new WebdriverUtility();
		wd.switchToAlertAndAccept(driver);
	
	}

	
	
	
	
		
	

}

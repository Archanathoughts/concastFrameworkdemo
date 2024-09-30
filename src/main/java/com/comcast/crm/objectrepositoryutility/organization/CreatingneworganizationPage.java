package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingneworganizationPage {
	public CreatingneworganizationPage(WebDriver driver)
	{ 
				PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
//	@FindAll({@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]"),@FindBy(name = "button")})
//	private WebElement saveBtn;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industrydropdown;
	
	@FindBy(id ="phone")
	private WebElement phontEdt;
	
	public WebElement getPhontEdt() {
		return phontEdt;
	}


	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName,String industry)
	{
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industrydropdown);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	public void createOrgwithPhoneNo(String orgName,String phoneNum )
	{
		getOrgNameEdt().sendKeys(orgName);
	    getPhontEdt().sendKeys(phoneNum);
		getSaveBtn().click();
	}

}

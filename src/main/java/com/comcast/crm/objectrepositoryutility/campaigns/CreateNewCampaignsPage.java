package com.comcast.crm.objectrepositoryutility.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateNewCampaignsPage {
	JavaUtility jLib=new JavaUtility();

	public 	CreateNewCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy()
//	private WebElement 
	@FindBy(name = "campaignname")
	private WebElement campNameTxtf;
	
	@FindBy(xpath = "//input[contains(@class,'crmButton small save')]")
	private WebElement campSaveb;
	
	@FindBy(id = "jscal_field_closingdate")
	private WebElement expCloseDate;

	public WebElement getCampNameTxtf() {
		return campNameTxtf;
	}

	public WebElement getCampSaveb() {
		return campSaveb;
	}

	public WebElement getExpCloseDate() {
		return expCloseDate;
	}
	
	public void createNewCampaign(String campName)
	{
        getCampNameTxtf().sendKeys(campName);
		
		getExpCloseDate().clear();
		String reqCloseDate=jLib.getRequiredDateYYYYDDmm(10);
		getExpCloseDate().sendKeys(reqCloseDate);
		getCampSaveb().click();
	}

}

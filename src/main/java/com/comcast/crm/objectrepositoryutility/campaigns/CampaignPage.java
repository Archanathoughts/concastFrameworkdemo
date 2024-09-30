package com.comcast.crm.objectrepositoryutility.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCampPlus() {
		return campPlus;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	public WebElement campPlus;

}

package com.comcast.crm.objectrepositoryutility.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignInformationPage {
	public CreateCampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(@id,'dtlview_Campaign Name')]")
	private WebElement campInfoNameTxtf;
	
	@FindBy(xpath = "//span[contains(@class,'dvHeaderText')]")
	private WebElement campInfoHeaderMsg;
	
	@FindBy(xpath = "(//td[contains(@class,'dvtCellInfo')])[8]")
	private WebElement campInfoexpCloseDate;

	public WebElement getCampInfoNameTxtf() {
		return campInfoNameTxtf;
	}

	public WebElement getCampInfoHeaderMsg() {
		return campInfoHeaderMsg;
	}

	public WebElement getCampInfoexpCloseDate() {
		return campInfoexpCloseDate;
	}

}

package com.comcast.crm.objectrepositoryutility.Opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppurtunityInformationPage {
	
public OppurtunityInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement oppInfoHeadermsg;

@FindBy(xpath = "//span[@id='dtlview_Opportunity Name']")
private WebElement oppIName;

@FindBy(xpath="//span[@id='dtlview_Opportunity Name']")
private WebElement campIName;

public WebElement getOppInfoHeadermsg() {
	return oppInfoHeadermsg;
}

public WebElement getOppIName() {
	return oppIName;
}

public WebElement getCampIName() {
	return campIName;
}

}

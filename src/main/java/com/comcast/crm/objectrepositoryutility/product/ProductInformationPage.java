package com.comcast.crm.objectrepositoryutility.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	public void setPrIHeaderMsg(WebElement prIHeaderMsg) {
		this.prIHeaderMsg = prIHeaderMsg;
	}

	public WebElement getPrIHeaderMsg() {
		return prIHeaderMsg;
	}

	public ProductInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(@id,'dtlview_Product Name')]")
	private WebElement prINameTxtf;
	
	@FindBy(xpath = "//span[contains(@id,'dtlview_Unit Price')]")
	private WebElement prIUnitPriceTxtf;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement prIHeaderMsg;
	
	public WebElement getPrINameTxtf() {
		return prINameTxtf;
	}

	public WebElement getPrIUnitPriceTxtf() {
		return prIUnitPriceTxtf;
	}

	public WebElement getpIvendName() {
		return pIvendName;
	}

	@FindBy(xpath = "//td[contains(@id,'mouseArea_Vendor Name')]")
	private WebElement pIvendName;
		
	}



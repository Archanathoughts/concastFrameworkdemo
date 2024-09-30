package com.comcast.crm.objectrepositoryutility.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productPlus;

	public WebElement getproductPlus() {
		return productPlus;
	} 


}

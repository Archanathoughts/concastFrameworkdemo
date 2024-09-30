package com.comcast.crm.objectrepositoryutility.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewProductPage {
	WebDriver driver;
	WebdriverUtility wLib=new WebdriverUtility();
	public CreateNewProductPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "productname")
	private WebElement prNameTxtf;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement prSavebtn;
	
	@FindBy(id = "unit_price")
	private WebElement prUnitPriceTxtf;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement vendNamePlus;
	
	@FindBy(id = "phone")
	private WebElement vPhoneTxtf;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement vSearchTxtf;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vImg;
	
	public WebElement getvImg() {
		return vImg;
	}
	@FindBy(xpath="//input[contains(@value,'  Search Now  ')]")
	private WebElement vSearchNowTxtf;

	public WebElement getvPhoneTxtf() {
		return vPhoneTxtf;
	}

	public WebElement getvSearchTxtf() {
		return vSearchTxtf;
	}

	public WebElement getvSearchNowTxtf() {
		return vSearchNowTxtf;
	}

	public WebElement getPrNameTxtf() {
		return prNameTxtf;
	}

	public WebElement getPrSavebtn() {
		return prSavebtn;
	}

	public WebElement getPrUnitPriceTxtf() {
		return prUnitPriceTxtf;
	}

	public WebElement getVendNamePlus() {
		return vendNamePlus;
	}
	
	public void creatProduct(String proName,String unitPrice)
	{
		getPrNameTxtf().sendKeys(proName);
		getPrUnitPriceTxtf().sendKeys(unitPrice);
		getPrSavebtn().click();
	}
	
	public void createProductWithVendor(String proName,String unitPrice,String venName)
	{
		getPrNameTxtf().sendKeys(proName);
		getPrUnitPriceTxtf().sendKeys(unitPrice);
		vImg.click();
		
		wLib.switchToTabOnUrl(driver, "module=Vendors");
		getvSearchTxtf().sendKeys(venName);
		getvSearchNowTxtf().click();

		driver.findElement(By.xpath("//a[text()='" + venName + "']")).click();
		wLib.switchToTabOnUrl(driver, "module=Products");
		getPrSavebtn().click();
	}
	

}

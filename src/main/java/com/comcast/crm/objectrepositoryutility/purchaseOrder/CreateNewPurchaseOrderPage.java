package com.comcast.crm.objectrepositoryutility.purchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewPurchaseOrderPage {
	WebdriverUtility wLib=new WebdriverUtility();
	WebDriver driver;

	public CreateNewPurchaseOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement nameTxt;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement vendorImg;

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement venSearchTxt;

	@FindBy(name = "search")
	private WebElement venSearchNow;

	@FindBy(name = "bill_street")
	private WebElement purBillTxtArea;

	@FindBy(xpath="(//input[@name='cpy'])[2]")
	private WebElement copyBilAddRadioBtn;

	@FindBy(xpath = "//img[@src='themes/images/products.gif']")
	private WebElement prodImg;

	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement prodSearch;

	@FindBy(xpath="//input[@id='qty1']")
	private WebElement qtyTxt;
	
	public WebElement getQtyTxt() {
		return qtyTxt;
	}

	@FindBy(name = "search")
	private WebElement prodSearchNow;

	@FindBy(name = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getNameTxt() {
		return nameTxt;
	}

	public WebElement getVendorImg() {
		return vendorImg;
	}

	public WebElement getVenSearchTxt() {
		return venSearchTxt;
	}

	public WebElement getVenSearchNow() {
		return venSearchNow;
	}

	public WebElement getPurBillTxtArea() {
		return purBillTxtArea;
	}

	public WebElement getCopyBilAddRadioBtn() {
		return copyBilAddRadioBtn;
	}

	public WebElement getProdImg() {
		return prodImg;
	}

	public WebElement getProdSearch() {
		return prodSearch;
	}

	public WebElement getProdSearchNow() {
		return prodSearchNow;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createPurchaseOrder(String purchaseOrd,String vendor,String proName,String purOrdBillAdd,int qty) throws InterruptedException {
		nameTxt.sendKeys(purchaseOrd);
		vendorImg.click();
		
		wLib.switchToTabOnUrl(driver, "module=Vendors");
		venSearchTxt.sendKeys(vendor);
		venSearchNow.click();
		driver.findElement(By.xpath("//a[text()='"+vendor+"']")).click();
		wLib.switchToTabOnUrl(driver, "module=PurchaseOrder");
		
		purBillTxtArea.sendKeys(purOrdBillAdd);
		copyBilAddRadioBtn.click();
		prodImg.click();
		Thread.sleep(2000);
		wLib.switchToTabOnUrl(driver, "module=Products");
		prodSearch.sendKeys(proName);
		prodSearchNow.click();
		driver.findElement(By.xpath("//a[text()='"+proName+"']")).click();
		wLib.switchToTabOnUrl(driver, "module=PurchaseOrder");
		
		qtyTxt.sendKeys(null);
		
		saveBtn.click();
	}
}

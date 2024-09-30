
package com.comcast.crm.objectrepositoryutility.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreatingNewContactPage {
public	JavaUtility jlib=new JavaUtility();
public	WebdriverUtility wlib=new WebdriverUtility();
	
	WebDriver driver=null;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(name = "search")
	private WebElement searchNowTxt;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement creatcontactHeader;
	
	@FindBy(name = "lastname")
	private WebElement ccLastNameEdt;
	
	@FindBy(id = "phone")
	private WebElement cPhoneNumEdt;
	
	@FindBy(xpath = "//input[contains(@id,'jscal_field_support_start_date')]")
	private WebElement ccStartDateEdt;
	
	@FindBy(xpath = "//input[@id='jscal_field_support_end_date']")
	private WebElement ccEndDateEdt;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement ccSelectOrgImg;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement ccSaveEdt;
	
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	
	public WebElement getCcSelectOrgImg() {
		return ccSelectOrgImg;
	}
	public WebElement getSearchNowTxt() {
		return searchNowTxt;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	
	public WebElement getCcEndDateEdt() {
		return ccEndDateEdt;
	}

	public WebElement getCcStartDateEdt() {
		return ccStartDateEdt;
	}
	
	public WebElement getcPhoneNumEdt() {
		return cPhoneNumEdt;
	}

	
	public WebElement getCcLastNameEdt() {
		return ccLastNameEdt;
	}

	public WebElement getCcSaveEdt() {
		return ccSaveEdt;
	}

	public WebElement getCreatcontactHeader() {
		return creatcontactHeader;
		
	}
	public void creatNewContactSave(String lastName)
	{
		ccLastNameEdt.sendKeys(lastName);
		ccSaveEdt.click();
	}
	public void creatNewContactWithOrg(String lastName)
	{
		ccSelectOrgImg.click();
		
		wlib.switchToTabOnUrl(driver, "module=Accounts");
			
	}
	public void creatNewContactSave(String lastName,String PhoneNum)
	{
		ccLastNameEdt.sendKeys(lastName);
		cPhoneNumEdt.sendKeys(PhoneNum);
		ccSaveEdt.click();
	}
	public void creatNewContactSave(String lastName,String PhoneNum,WebElement startDate,WebElement endDate) throws InterruptedException
	{
		ccLastNameEdt.sendKeys(lastName);
		cPhoneNumEdt.sendKeys(PhoneNum);
		ccStartDateEdt.clear();
		
		String startd=jlib.getSystemDateYYYYDDmm();
		ccStartDateEdt.sendKeys(startd);
		
		ccEndDateEdt.clear();
		String endd=jlib.getRequiredDateYYYYDDmm(30);
		ccEndDateEdt.sendKeys(endd);
		Thread.sleep(1000);
		ccSaveEdt.click();
	}
	public void creatContactWithOrg(String lastName,String Phone,String orgName)
	{
		getCcLastNameEdt().sendKeys(lastName);
		getcPhoneNumEdt().sendKeys(Phone);
		
		
		getCcSelectOrgImg().click();
		wlib.switchToTabOnUrl(driver, "module=Accounts");
		getSearchTxt().sendKeys(orgName);
		getSearchNowTxt().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wlib.switchToTabOnUrl(driver,"module=Contacts");
		getCcSaveEdt().click();
		
	}
	
	public void creatContactWithSupportDate(String lastName,String startDate,String endDate)
	{
		getCcLastNameEdt().sendKeys(lastName);
		getCcStartDateEdt().clear();
		getCcStartDateEdt().sendKeys(startDate);
		getCcEndDateEdt().clear();
		getCcEndDateEdt().sendKeys(endDate);
		getCcSaveEdt().click();
		
	}	
		
}



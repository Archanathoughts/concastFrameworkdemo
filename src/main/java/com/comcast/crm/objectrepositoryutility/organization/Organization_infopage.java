package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Organization_infopage {
	WebDriver driver;
	 
	public Organization_infopage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerTxt;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgNameInfoTxt;

	@FindBy(id="dtlview_Phone")
	private WebElement PhoneInfoTxt;
	
	@FindBy(id="dtlview_Industry")
	private WebElement IndustryInfoDB;
	
	
	
	public WebElement getIndustryInfoDB() {
		return IndustryInfoDB;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameInfoTxt() {
		return orgNameInfoTxt;
	}

	public WebElement getPhoneInfoTxt() {
		return PhoneInfoTxt;
	}
	
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	
	public void Verify_OrgHdrMsg(String OrgName)
	{
		String orgHead =getHeaderTxt().getText();
		 boolean status = orgHead.contains(OrgName);
		 Assert.assertEquals(status, true, "creatOrganizationtest pass");
		
	}
	public void Verify_createOrganizationWithIndustriestest(String OrgName,String industry)
	{	
	
	String actual = getHeaderTxt().getText();
		boolean status = actual.contains(OrgName);
		Assert.fail();
		//Assert.assertEquals(status, true, "hearderVerified");
		
		String actualIndustry =getIndustryInfoDB().getText();
		Assert.assertEquals(actualIndustry, industry);
//	if (actual.contains(orgName))
//		System.out.println("createOrganizationWithIndustriestest actual matches the expected-verification--- pass   " + orgName);
//	else
//		System.out.println("createOrganizationWithIndustriestest actual doesnot match the expected-verification--- pass   " + orgName);
//
//	String actualIndustry = orgInfo.getIndustryInfoDB().getText();
//	if (actualIndustry.equals(industry))
//		System.out.println("createOrganizationWithIndustriestest Industry dropdown matching" + industry);
//	else
//		System.out.println("createOrganizationWithIndustriestest Industry dropdown does not matching" + industry);
}
		
		public void Verify_createOrganizationWithPhoneNumber(String OrgName,String phoneNum)
		{
		String actualOrgName = getOrgNameInfoTxt().getText();
		Assert.assertEquals(actualOrgName, OrgName);
//		if(actualOrgName.equals(orgName))
//			System.out.println("createOrganizationWithPhoneNumber OrgName matches with the expected "+actualOrgName);
//		else
//			System.out.println("createOrganizationWithPhoneNumber OrgName doesnot matches with the expected "+actualOrgName);
//		
//		String actPhoneNum=orgInfo.getPhoneInfoTxt().getText();
//		if(actPhoneNum.equals(phoneNum))
//			System.out.println("createOrganizationWithPhoneNumber actPhoneNum matches with the expected "+actPhoneNum);
//		else
//			System.out.println("createOrganizationWithPhoneNumber actPhoneNum doesnot matches with the expected "+actPhoneNum);
//			
		}
}


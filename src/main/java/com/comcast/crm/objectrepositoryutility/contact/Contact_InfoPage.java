package com.comcast.crm.objectrepositoryutility.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.organization.Organization_infopage;

public class Contact_InfoPage {
	SoftAssert soft=new SoftAssert();

	
	public Contact_InfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement cInfoheaderTxt;
	
	@FindBy(xpath="//span[contains(@id,'dtlview_Last')]")
	private WebElement cInfoLastName;
	
	@FindBy(xpath = "//span[contains(@id,'dtlview_Support Start Date')]")
	private WebElement cInfoStartDate;
	
	@FindBy(xpath="//span[contains(@id,'dtlview_Support End Date')]")
	private WebElement cInfoEndDate;

	public WebElement getcInfoStartDate() {
		return cInfoStartDate;
	}

	public WebElement getcInfoEndDate() {
		return cInfoEndDate;
	}

	public WebElement getcInfoheaderTxt() {
		return cInfoheaderTxt;
	}

	public WebElement getcInfoLastName() {
		return cInfoLastName;
	}
	
	public void verification_contact(String lastName)
	{
		
		String actcInfoHeader = getcInfoheaderTxt().getText().trim();
		Boolean lastNameStatus=actcInfoHeader.contains(lastName);
		soft.assertEquals(lastNameStatus, true);
		
		String actucInfoLastName =getcInfoLastName().getText().trim();
		Boolean actInfoLastnStatus=actucInfoLastName.equals(lastName);
		soft.assertEquals(actInfoLastnStatus, true);
		soft.assertAll();
		
//		if (actcInfoHeader.contains(lastName))
//			System.out.println("createcontacttest-contact Info header matches " + actcInfoHeader);
//		else
//			System.out.println("createcontacttest---contact Info header does not matches " + actcInfoHeader);
//
//		String actucInfoLastName =getcInfoLastName().getText().trim();
//
//		if (actucInfoLastName.equals(lastName)) 
//			System.out.println("createcontacttest----contact creation---actucInfoLastName matches " + actucInfoLastName);
//		 else {
//			System.out.println(actucInfoLastName);
//			System.out.println("createcontacttest-----actucInfoLastName does not matches " + actucInfoLastName);
//		}
	}
	
	public void verification_cotactWithSupportDate(String lastName,String start_Date,String reqEndDate )
	{
		String actLastName =getcInfoLastName().getText().trim();
	    String actualStartDate = getcInfoStartDate().getText().trim();
		String actualEndDate=getcInfoEndDate().getText();
		
		Boolean lastNameSatus=actLastName.equals(lastName );
		soft.assertEquals(lastNameSatus, true);
		
		Boolean startDateStatus=actualStartDate.equals(start_Date);
		soft.assertEquals(startDateStatus, true);
		
		Boolean reqEndDateStatus=actualEndDate.equals(reqEndDate);
		soft.assertEquals(reqEndDateStatus, true);
		soft.assertAll();
		
//		if(actLastName.equals(lastName ))
//			System.out.println("createContactWithSupportDate====last name is matching"+actLastName);
//		else
//			System.out.println("createContactWithSupportDate====last name not matching"+actLastName);
//
//		if(actualStartDate.equals(start_Date))
//			System.out.println("createContactWithSupportDate====actualStartDate is matching"+actualStartDate);
//		else
//			System.out.println("createContactWithSupportDate====actualStartDate not matching"+actualStartDate);
//
//		if(actualEndDate.equals(reqEndDate))
//			System.out.println("createContactWithSupportDate====actualEndDate  is matching"+actualEndDate);
//		else
//			System.out.println("createContactWithSupportDate====actualEndDate not matching"+actualEndDate);

	}
	
//	public void verification_createOrganization(WebDriver driver,String orgName)
//	{
//		Organization_infopage orgInfo = new Organization_infopage(driver);
//		String orgHead = orgInfo.getHeaderTxt().getText();
//		boolean status=orgHead.contains(orgName);
//		soft.assertEquals(status, true);
//		soft.assertAll();
////		if (orgHead.contains(orgName)) {
//			System.out.println(orgName
//					+ "createContactWithOrganizationtest====createContactWithOrganizationtest contactWithorg is created matches the hearder Info==pass");
//		} else {
//			System.out.println(orgName
//					+ "createContactWithOrganizationtest=====createContactWithOrganizationtest  is not created");
//		}
	
//	}
	
	public void verification_contactHeaderAndOrgName(WebDriver driver,String orgName,String lastName)
	{
	//	Organization_infopage orgInfo = new Organization_infopage(driver);
	//	String orgHead = orgInfo.getHeaderTxt().getText();
	//	boolean statusorg=orgHead.contains(orgName);
//		System.out.println(orgHead+"orgHead");
//		System.out.println(statusorg+"statusorgName");
//		soft.assertEquals(statusorg, true);
		
		String contactHeader = getcInfoheaderTxt().getText();
		Boolean status=contactHeader.contains(lastName);
		soft.assertEquals(status, true);
				
		soft.assertAll();
		
//		if (contactHeader.contains(lastName))
//			System.out.println(
//					"createContactWithOrganizationtest====contactWithorg contacHeard matches  " + contactHeader);
//		else
//			System.out.println("createContactWithOrganizationtest====contactWithorg contacHeard does not matches  "
//					+ contactHeader);
//
//		String actOrgNameInCon = driver.findElement(By.xpath("//a[text()='" + orgName + "']")).getText();
//
//		if (actOrgNameInCon.contains(orgName))
//			System.out.println(
//					"createContactWithOrganizationtest===actOrgNameInCon  match with OrgName " + actOrgNameInCon);
//		else
//			System.out.println(
//					"createContactWithOrganizationtest====actOrgNameInCon  match with OrgName " + actOrgNameInCon);
	}
}

package com.comcast.crm.contacttest;

/**
 * test class for contact module
 * @archana
 */
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.contact.ContactPage;
import com.comcast.crm.objectrepositoryutility.contact.Contact_InfoPage;
import com.comcast.crm.objectrepositoryutility.contact.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingneworganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.Organization_infopage;

public class CreateContactTest2 extends BaseClass {
	/**
	 * Scenario: Createcontacttest()===>navigate to contact====>create
	 * contact===verify
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test(groups = "smoke")
	public void createcontacttest() throws EncryptedDocumentException, IOException {
		/* Read test script data from excel file */
		int rand = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + rand;
		String lastName = eLib.getDataFromExcel("contact", 7, 4) + rand;

		/* Navigate to home page */
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* Navigate to contact page */
		ContactPage cp = new ContactPage(driver);
		cp.getContactImg().click();

		/* Navigate to create new contact page enter all details and save */
		CreatingNewContactPage creatCon = new CreatingNewContactPage(driver);
		creatCon.creatNewContactSave(lastName);

		/* verify the contact information page */
		Contact_InfoPage cip = new Contact_InfoPage(driver);
		cip.verification_contact(lastName);

	}

	@Test(groups = { "smoke", "regression" })
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		
		/* Read test script data from excel file */
		int rand = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + rand;
		String lastName = eLib.getDataFromExcel("contact", 7, 4) + rand;
		String Phone = eLib.getDataFromExcel("contact", 7, 3);

		/* Navigate to home page */
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* Navigate to contact page */
		ContactPage cp = new ContactPage(driver);
		cp.getContactImg().click();

		String start_Date = jLib.getSystemDateYYYYDDmm();
		String reqEndDate = jLib.getRequiredDateYYYYDDmm(30);
		CreatingNewContactPage creatCon = new CreatingNewContactPage(driver);
		creatCon.creatContactWithSupportDate(lastName, start_Date, reqEndDate);

		Contact_InfoPage cip = new Contact_InfoPage(driver);
		cip.verification_cotactWithSupportDate(lastName, start_Date, reqEndDate);
	}

	@Test(groups = "regression")
	public void createContactWithOrganizationtest() throws EncryptedDocumentException, IOException, InterruptedException {
		CreatingNewContactPage creatCon = new CreatingNewContactPage(driver);
		HomePage hp = new HomePage(driver);
		CreatingneworganizationPage cno = new CreatingneworganizationPage(driver);
		OrganizationPage orp = new OrganizationPage(driver);
		Contact_InfoPage cip = new Contact_InfoPage(driver);
		ContactPage cp = new ContactPage(driver);
		
		/* Read test script data from excel file */
		int rand = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + rand;
		String lastName = eLib.getDataFromExcel("contact", 7, 4) + rand;
		String Phone = eLib.getDataFromExcel("contact", 7, 3);
		
		/* Navigate to organization page */
		hp.getOrgLink().click();
		
		orp.getCreatOrgImg().click();

		/* Navigate to create new organization  page */
		cno.createOrg(orgName);

	    Thread.sleep(2000);
	    String actOrgNameInCon = driver.findElement(By.xpath("//span[text()='"+orgName+"']")).getText();
		Boolean actOrg=actOrgNameInCon.contains(orgName);
		System.out.println(actOrgNameInCon+"actOrgNameInCon");
		System.out.println(orgName+"orgName");
		
	    SoftAssert soft=new SoftAssert();
	    soft.assertEquals(actOrg, true);
		soft.assertAll();
		
		/* Navigate to contact page */
		hp.getContactLink().click();
		cp.getContactImg().click();
		
		/* create new contact with organization and phone no */
		creatCon.creatContactWithOrg(lastName, Phone, orgName);

		/* Verify contact header and organization name */
     	cip.verification_contactHeaderAndOrgName(driver,orgName,lastName);

	}

}

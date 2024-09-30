package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingneworganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.Organization_infopage;

public class CreateOrganizationTest2 extends BaseClass {
	@Test(groups="smoke") 
	public void creatOrganizationtest() throws EncryptedDocumentException, IOException {
		int randint = jLib.getRandomNumber();

		// Read test script data from excel
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String OrgName = eLib.getDataFromExcel("org", 1, 2) + randint;

		// Navigate to org module

		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to creat org img");
		OrganizationPage orp = new OrganizationPage(driver);
		orp.getCreatOrgImg().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to creat org page");
		CreatingneworganizationPage cno = new CreatingneworganizationPage(driver);
		cno.createOrg(OrgName);
		
		UtilityClassObject.getTest().log(Status.INFO, "verified org hdrMsg");
		Organization_infopage orgInfo = new Organization_infopage(driver);
		orgInfo.Verify_OrgHdrMsg(OrgName);
//		
	}

	@Test
	public void createOrganizationWithIndustriestest() throws EncryptedDocumentException, IOException {
		int rnum = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + rnum;
		String industry = eLib.getDataFromExcel("org", 4, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage orp = new OrganizationPage(driver);
		orp.getCreatOrgImg().click();

		CreatingneworganizationPage cno = new CreatingneworganizationPage(driver);
		cno.createOrg(orgName, industry);

		Organization_infopage orgInfo = new Organization_infopage(driver);
		orgInfo.Verify_createOrganizationWithIndustriestest(orgName, industry);
//		
	}
	@Test(groups="regression")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException
	{
		int rand=jLib.getRandomNumber();
		String orgName=eLib.getDataFromExcel("org", 1, 2)+rand;
		String phoneNum=eLib.getDataFromExcel("org", 7, 3);
		
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.getCreatOrgImg().click();
		
		CreatingneworganizationPage creatneworg=new CreatingneworganizationPage(driver);
		creatneworg.createOrgwithPhoneNo(orgName,phoneNum);
		
		Organization_infopage orgInfo=new Organization_infopage(driver);
		orgInfo.Verify_createOrganizationWithPhoneNumber(orgName, phoneNum);
		}

@Test(groups="regression")
public void creatOrgAndDeleteOrg() throws EncryptedDocumentException, IOException
{
	int randint = jLib.getRandomNumber();
	 
	String OrgName = eLib.getDataFromExcel("org", 1, 2)+randint;
	
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	
	OrganizationPage orp=new OrganizationPage(driver);
	orp.getCreatOrgImg().click();
	
	CreatingneworganizationPage cno=new CreatingneworganizationPage(driver);
	cno.createOrg(OrgName);
	
	Organization_infopage orgInfo=new Organization_infopage(driver);
	String orgHead=orgInfo.getHeaderTxt().getText();
	
	if(orgHead.contains(OrgName))
	{
		System.out.println(OrgName+"creatOrgAndDeleteOrg is created matches the hearder Info==pass");
	}
	else
	{
		System.out.println(OrgName+"creatOrgAndDeleteOrg is not created");
	}
	OrganizationPage op=new OrganizationPage(driver);
	op.getOrgLnk().click();
	op.deleteOrg(op.getSearcFieldDropd(), OrgName);
	
  }
}
	




package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.contact.ContactPage;
import com.comcast.crm.objectrepositoryutility.contact.Contact_InfoPage;
import com.comcast.crm.objectrepositoryutility.contact.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingneworganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.Organization_infopage;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws IOException, InterruptedException {

		FileUtility fUtil=new FileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		WebdriverUtility wUtil=new WebdriverUtility();
		
		String BROWSER=fUtil.getDataFromPropertyFile("browser");
		String URL=fUtil.getDataFromPropertyFile("url");
		String USERNAME=fUtil.getDataFromPropertyFile("usn");
		String PASSWORD=fUtil.getDataFromPropertyFile("psw");
		
		int rand=jUtil.getRandomNumber();
		String orgName=eUtil.getDataFromExcel("org", 1, 2)+rand;
		String lastName=eUtil.getDataFromExcel("contact", 7,4)+rand;
		String Phone=eUtil.getDataFromExcel("contact",7,3);
				
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equals("edge"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		wUtil.waitForPageToLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage orp=new OrganizationPage(driver);
		orp.getCreatOrgImg().click();
		
		CreatingneworganizationPage cno=new CreatingneworganizationPage(driver);
		cno.createOrg(orgName);
		
		Organization_infopage orgInfo=new Organization_infopage(driver);
		String orgHead=orgInfo.getHeaderTxt().getText();
		
		if(orgHead.contains(orgName))
		{
			System.out.println(orgName+" is created matches the hearder Info==pass");
		}
		else
		{
			System.out.println(orgName+" is not created");
		}
		
		
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getContactImg().click();
		
		CreatingNewContactPage creatCon=new CreatingNewContactPage(driver);
		//creatCon.creatNewContactSav
//		creatCon.getCcLastNameEdt().sendKeys(lastName);
//		creatCon.getcPhoneNumEdt().sendKeys(Phone);
//		
//		
//		creatCon.getCcSelectOrgImg().click();
//		wUtil.switchToTabOnUrl(driver, "module=Accounts");
//		creatCon.getSearchTxt().sendKeys(orgName);
//		creatCon.getSearchNowTxt().click();
//		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
//		
//		wUtil.switchToTabOnUrl(driver,"module=Contacts");
//		creatCon.getCcSaveEdt().click();
		creatCon.creatContactWithOrg(lastName, Phone, orgName);
		Contact_InfoPage cip=new Contact_InfoPage(driver);
		String contactHeader =cip.getcInfoheaderTxt() .getText();
		if(contactHeader.contains(lastName))
			System.out.println("contacHeard matches  "+contactHeader);
		else
			System.out.println("contacHeard does not matches  "+contactHeader);
		
		String actOrgNameInCon=driver.findElement(By.xpath("//a[text()='"+orgName+"']")).getText();
		
		if(actOrgNameInCon.contains(orgName))
			System.out.println("actOrgNameInCon  match with OrgName "+actOrgNameInCon);
		else
			System.out.println("actOrgNameInCon  match with OrgName "+actOrgNameInCon);
			
		}
		
		
	}



package com.comcast.crm.contacttest;



import java.io.IOException;

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

public class CreateContactTest {
	public static void main(String[] args) throws IOException {
		
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
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getContactImg().click();
		
		CreatingNewContactPage creatCon=new CreatingNewContactPage(driver);
		creatCon.creatNewContactSave(lastName);
		
		Contact_InfoPage cip=new Contact_InfoPage(driver);
		String actcInfoHeader=cip.getcInfoheaderTxt().getText();
		if(actcInfoHeader.contains(lastName))
			System.out.println("contact Info header matches "+actcInfoHeader);
		else
			System.out.println("contact Info header does not matches "+actcInfoHeader);
		
		String actucInfoLastName=cip.getcInfoLastName().getText();
		
		if(actucInfoLastName.equals(lastName))
		{
			System.out.println("actucInfoLastName matches " +actucInfoLastName);
		}
		else
		{
			System.out.println(actucInfoLastName);
			System.out.println("actucInfoLastName does not matches " +actucInfoLastName);
		}
		//hp.getSignOutLnk();
	}
}

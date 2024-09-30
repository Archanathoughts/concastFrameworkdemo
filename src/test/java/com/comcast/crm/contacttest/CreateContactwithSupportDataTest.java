package com.comcast.crm.contacttest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateContactwithSupportDataTest {
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
	hp.getContactLink().click();
	
	ContactPage cp=new ContactPage(driver);
	cp.getContactImg().click();
	
//	CreatingNewContactPage creatCon=new CreatingNewContactPage(driver);
//	creatCon.getCcLastNameEdt().sendKeys(lastName);
//	creatCon.getcPhoneNumEdt().sendKeys(Phone);
//	
//	creatCon.getCcStartDateEdt().clear();
	
//	String start_Date=jUtil.getSystemDateYYYYDDmm();
//	creatCon.getCcStartDateEdt().sendKeys(start_Date);
//	
//	 creatCon.getCcEndDateEdt().clear();
//	String reqEndDate= jUtil.getRequiredDateYYYYDDmm(30);
//	creatCon.getCcEndDateEdt().sendKeys(reqEndDate);
//	creatCon.getCcSaveEdt().click();
//	 WebElement cstart_Date = creatCon.getCcStartDateEdt();
//	 WebElement cendDate = creatCon.getCcEndDateEdt();
//	creatCon.creatNewContactSave(lastName, Phone,cstart_Date , cendDate);
	String start_Date=jUtil.getSystemDateYYYYDDmm();
	String reqEndDate= jUtil.getRequiredDateYYYYDDmm(30);
	CreatingNewContactPage creatCon=new CreatingNewContactPage(driver);
	creatCon.creatContactWithSupportDate(lastName, start_Date, reqEndDate);
//	String start_Date=creatCon.getCcStartDateEdt().getText();
//	String endDate=creatCon.getCcEndDateEdt().getText();
//	
//	Date d=new Date();
 //   SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
//	String start_Date=sdf.format(d);
//	
//	creatCon.getCcStartDateEdt().sendKeys(start_Date);
//	
//   creatCon.getCcEndDateEdt().clear();
//	String reqEndDate= jUtil.getRequiredDateYYYYDDmm(30);
//	creatCon.getCcEndDateEdt().sendKeys(reqEndDate);
//	creatCon.getCcSaveEdt();

	Contact_InfoPage cip=new Contact_InfoPage(driver);
	String actLastName =cip.getcInfoLastName() .getText();
     String actualStartDate = cip.getcInfoStartDate().getText();
	String actualEndDate=cip.getcInfoEndDate().getText();
	
	if(actLastName.equals(lastName))
		System.out.println("last name is matching"+actLastName);
	else
		System.out.println("last name not matching"+actLastName);

	if(actualStartDate.equals(start_Date))
		System.out.println("actualStartDate is matching"+actualStartDate);
	else
		System.out.println("actualStartDate not matching"+actualStartDate);

	if(actualEndDate.equals(reqEndDate))
		System.out.println("actualEndDate  is matching"+actualEndDate);
	else
		System.out.println("actualEndDate not matching"+actualEndDate);

}
	
	

}

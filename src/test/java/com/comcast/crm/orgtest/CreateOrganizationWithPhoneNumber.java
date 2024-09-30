package com.comcast.crm.orgtest;

import java.io.IOException;

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
import com.comcast.crm.objectrepositoryutility.organization.CreatingneworganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.Organization_infopage;

public class CreateOrganizationWithPhoneNumber{
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
	String phoneNum=eUtil.getDataFromExcel("org", 7, 3);
	
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
	
	OrganizationPage orgp=new OrganizationPage(driver);
	orgp.getCreatOrgImg().click();
	
	CreatingneworganizationPage creatneworg=new CreatingneworganizationPage(driver);
	
	creatneworg.getOrgNameEdt().sendKeys(orgName);
	creatneworg.getPhontEdt().sendKeys(phoneNum);
	creatneworg.getSaveBtn().click();
	
	Organization_infopage orgInfo=new Organization_infopage(driver);
	String actualOrgName = orgInfo.getOrgNameInfoTxt().getText();
	if(actualOrgName.equals(orgName))
		System.out.println("OrgName matches with the expected "+actualOrgName);
	else
		System.out.println("OrgName doesnot matches with the expected "+actualOrgName);
	
	String actPhoneNum=orgInfo.getPhoneInfoTxt().getText();
	if(actPhoneNum.equals(phoneNum))
		System.out.println("actPhoneNum matches with the expected "+actPhoneNum);
	else
		System.out.println("actPhoneNum doesnot matches with the expected "+actPhoneNum);
		
	}
}
package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

public class CreateOrganizationWithIndustriesTest {
	public static void main(String[] args) throws IOException {
		FileUtility fUtil=new FileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		WebdriverUtility wUtil=new WebdriverUtility();
		
		
		
		String BROWSER = fUtil.getDataFromPropertyFile("browser");
		String URL=fUtil.getDataFromPropertyFile("url");
		String USERNAME=fUtil.getDataFromPropertyFile("usn");
		String PASSWORD=fUtil.getDataFromPropertyFile("psw");
		
		int rnum = jUtil.getRandomNumber();
		String orgName=eUtil.getDataFromExcel("org", 1, 2)+rnum;
		String industry = eUtil.getDataFromExcel("org", 4,3);
		
		
		
	WebDriver driver=null;
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver();
	}else if(BROWSER.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}else if(BROWSER.equals("edge"))
	{
		driver=new EdgeDriver();
	}else {
		driver=new ChromeDriver();
	}
	wUtil.waitForPageToLoad(driver);
	driver.get(URL);
	
	LoginPage lg=new LoginPage(driver);
//	lg.getUsernametxt().sendKeys(USERNAME);
//	lg.getPasswordtxt().sendKeys(PASSWORD);
//	lg.getLoginbtn().click();
//	
	lg.loginToApp(USERNAME, PASSWORD);
	
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	
	OrganizationPage orp=new OrganizationPage(driver);
	orp.getCreatOrgImg().click();
	
	CreatingneworganizationPage cno=new CreatingneworganizationPage(driver);
	cno.createOrg(orgName, industry);
	
	Organization_infopage orgInfo=new Organization_infopage(driver);
	
	String actual=orgInfo.getHeaderTxt().getText();
	
	if(actual.contains(orgName))
		System.out.println("actual matches the expected-verification--- pass   "+orgName);
	else
		System.out.println("actual doesnot match the expected-verification--- pass   "+orgName);
	
	String actualIndustry = orgInfo.getIndustryInfoDB().getText();
	if(actualIndustry.equals(industry))
		System.out.println("Industry dropdown matching"+industry);
	else
		System.out.println("Industry dropdown does not matching"+industry);
	}

}

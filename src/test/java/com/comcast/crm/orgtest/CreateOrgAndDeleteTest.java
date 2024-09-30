package com.comcast.crm.orgtest;

import java.io.IOException;

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

public class CreateOrgAndDeleteTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fileutil=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebdriverUtility webUtil=new WebdriverUtility();
		JavaUtility javaUtil=new JavaUtility();
		
		int randint = javaUtil.getRandomNumber();
		 
		String OrgName = elib.getDataFromExcel("org", 1, 2)+randint;
		
			
		String BROWSER = fileutil.getDataFromPropertyFile("browser");
		String URL = fileutil.getDataFromPropertyFile("url");
		String USERNAME = fileutil.getDataFromPropertyFile("usn");
		String PASSWORD = fileutil.getDataFromPropertyFile("psw");
		
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
		webUtil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		LoginPage lg=new LoginPage(driver);
    	lg.loginToApp(USERNAME, PASSWORD);
		
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
			System.out.println(OrgName+" is created matches the hearder Info==pass");
		}
		else
		{
			System.out.println(OrgName+" is not created");
		}
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrgLnk().click();
		op.deleteOrg(op.getSearcFieldDropd(), OrgName);
		
	
	}
	

}

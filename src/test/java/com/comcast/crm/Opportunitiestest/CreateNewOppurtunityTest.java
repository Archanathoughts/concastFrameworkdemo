package com.comcast.crm.Opportunitiestest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import com.comcast.crm.objectrepositoryutility.Opportunities.CreateNewOppurtunityPage;
import com.comcast.crm.objectrepositoryutility.Opportunities.OppurtunitiesLookUpPage;
import com.comcast.crm.objectrepositoryutility.campaigns.CampaignPage;
import com.comcast.crm.objectrepositoryutility.campaigns.CreateNewCampaignsPage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingneworganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationPage;

public class CreateNewOppurtunityTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtility fileutil=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebdriverUtility webUtil=new WebdriverUtility();
		JavaUtility javaUtil=new JavaUtility();
		
		int randint = javaUtil.getRandomNumber();
		 
		String OrgName = elib.getDataFromExcel("org", 1, 2)+randint;
		String OppName = elib.getDataFromExcel("opportunity", 1, 2)+randint;
		String campName = elib.getDataFromExcel("campaign", 1, 2)+randint;
			
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
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage orp=new OrganizationPage(driver);
		orp.getCreatOrgImg().click();
		
		CreatingneworganizationPage cno=new CreatingneworganizationPage(driver);
		cno.createOrg(OrgName);
		Thread.sleep(2000);
		
		//webUtil.switchToTabOnUrl(driver,"module=Home");
		
		hp.navigateToCampaginPage();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.getCampPlus().click();
		
		CreateNewCampaignsPage campp=new CreateNewCampaignsPage(driver);
		campp.createNewCampaign(campName);
		
		//webUtil.switchToTabOnUrl(driver,"module=Home");

		hp.getOppLnk().click();
		
		OppurtunitiesLookUpPage olp=new OppurtunitiesLookUpPage(driver);
		olp.getOppPlus().click();
		
		CreateNewOppurtunityPage cop=new CreateNewOppurtunityPage(driver);
		cop.createNewOppertunity(OppName,OrgName,campName);
		hp.logout();
		//String actrelatedTo=driver.findElement(By.xpath("//a[text()='+OrgName+']")).getText();
		
	}

}

package com.comcast.crm.salesOrdertest;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import com.comcast.crm.objectrepositoryutility.product.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductPage;
import com.comcast.crm.objectrepositoryutility.salesOrder.CreateNewSalesOrderPage;
import com.comcast.crm.objectrepositoryutility.salesOrder.SalesOrderPage;

public class CreateNewSalesOrderTest {
	public static void main(String[] args) throws EncryptedDocumentException, InterruptedException, IOException {
		
	
	FileUtility fileutil=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	WebdriverUtility webUtil=new WebdriverUtility();
	JavaUtility javaUtil=new JavaUtility();
	
	int randint = javaUtil.getRandomNumber();
	 
	String OrgName = elib.getDataFromExcel("org", 1, 2)+randint;
	String subject = elib.getDataFromExcel("salesorder", 1, 2);
	String billAddr = elib.getDataFromExcel("salesorder", 1, 3);
	String OppName = elib.getDataFromExcel("opportunity", 1, 2)+randint;
	String campName = elib.getDataFromExcel("campaign", 1, 2)+randint;
	String proName = elib.getDataFromExcel("campaign", 1, 2)+randint;
	String unitPrice = elib.getDataFromExcel("product", 1, 4);
		
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
		
	Thread.sleep(3000);
	hp.getProductlnk().click();
	
	ProductPage prop=new ProductPage(driver);
	prop.getproductPlus().click();
	
	CreateNewProductPage pp=new CreateNewProductPage(driver);
	pp.creatProduct(proName, unitPrice);
		
//	hp.navigateToCampaginPage();
//	
//	CampaignPage cp=new CampaignPage(driver);
//	cp.getCampPlus().click();
//	
//	CreateNewCampaignsPage campp=new CreateNewCampaignsPage(driver);
//	campp.createNewCampaign(campName);
//	
//	
//	hp.getOppLnk().click();
//	
//	OppurtunitiesLookUpPage olp=new OppurtunitiesLookUpPage(driver);
//	olp.getOppPlus().click();
//	
//	CreateNewOppurtunityPage cop=new CreateNewOppurtunityPage(driver);
//	cop.createNewOppertunity(OppName,OrgName,campName);

	
	hp.navigateToSalesOrder();
	SalesOrderPage sp=new SalesOrderPage(driver);
	sp.getSalesPlus().click();
	
	CreateNewSalesOrderPage csop=new CreateNewSalesOrderPage(driver);
	//csop.createSalesOrder(subject, OppName, OrgName,billAddr,proName);
	csop.createSalesOrderWithOrg(subject, OrgName, billAddr, proName);
	
	
	
	}
}

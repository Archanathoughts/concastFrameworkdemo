package com.comcast.crm.campaigntest;

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
import com.comcast.crm.objectrepositoryutility.campaigns.CampaignPage;
import com.comcast.crm.objectrepositoryutility.campaigns.CreateCampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.campaigns.CreateNewCampaignsPage;

public class CreateNewCampaignTest {
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
		
		String campName=eUtil.getDataFromExcel("campaign", 1,2)+rand;
				
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
		hp.navigateToCampaginPage();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.getCampPlus().click();
		
		CreateNewCampaignsPage campp=new CreateNewCampaignsPage(driver);
		campp.createNewCampaign(campName);
//		campp.getCampNameTxtf().sendKeys(campName);
//		
//		campp.getExpCloseDate().clear();
//		String reqCloseDate=jUtil.getRequiredDateYYYYDDmm(10);
//		campp.getExpCloseDate().sendKeys(reqCloseDate);
//		String expcloseDate=campp.getExpCloseDate().getText();
		//campp.getCampSaveb().click();
		
		CreateCampaignInformationPage cmpInfo=new CreateCampaignInformationPage(driver);
		String actcmpInfoName=cmpInfo.getCampInfoNameTxtf().getText();
		String actcmpHeadMsg=cmpInfo.getCampInfoHeaderMsg().getText();
		String actcmpCloseDate=cmpInfo.getCampInfoexpCloseDate().getText();
		if(actcmpInfoName.equals(campName))
			System.out.println("actcmpInfoName matching---pass"+actcmpInfoName);
		else
			System.out.println("actcmpInfoName not matching---fail"+actcmpInfoName);
		
		
		if(actcmpHeadMsg.contains(campName))
			System.out.println("actcmpHeadMsg matching---pass"+actcmpHeadMsg);
		else
			System.out.println("actcmpHeadMsg not matching---fail"+actcmpHeadMsg);
		
//		System.out.println(actcmpCloseDate);
//		if(actcmpCloseDate.contains(expcloseDate))
//			System.out.println("actcmpCloseDate matching---pass"+actcmpCloseDate);
//		else
//			System.out.println("actcmpCloseDate not matching---fail"+actcmpCloseDate);
		
	}

}

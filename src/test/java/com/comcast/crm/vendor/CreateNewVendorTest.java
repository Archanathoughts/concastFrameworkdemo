package com.comcast.crm.vendor;

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
import com.comcast.crm.objectrepositoryutility.vendor.CreateNewVendorPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorInformationPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorPage;

public class CreateNewVendorTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fileutil=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebdriverUtility webUtil=new WebdriverUtility();
		JavaUtility javaUtil=new JavaUtility();
		
		int randint = javaUtil.getRandomNumber();
		 
		String venName = elib.getDataFromExcel("vendor", 1, 2)+randint;
		
		String vphone = elib.getDataFromExcel("vendor", 1, 4);
		
			
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
        hp.navigateToVendorPage();
		
        VendorPage vp=new VendorPage(driver);
		vp.getvendorPlus().click();
		
		CreateNewVendorPage cvp=new CreateNewVendorPage(driver);
		cvp.createVendor(venName, vphone);
		
		VendorInformationPage vip=new VendorInformationPage(driver);
		String actvIName = vip.getvINameTxtf().getText();
		String actvIphone = vip.getvIPhoneTxtf().getText();
		String actvIHeadMsg = vip.getvIHeaderMsg().getText();
		if(actvIName.equals(venName))
			System.out.println("actvIName is matching ----pass"+actvIName);
		else
			System.out.println("actvIName is not matching ----pass"+actvIName);
		
		if(actvIphone.contains(vphone))
			System.out.println("actvIphone is matching ----pass"+actvIphone);
		else
			System.out.println("actvIphone is not matching ----pass"+actvIphone);
		
		if(actvIHeadMsg.contains(venName))
			System.out.println("actvIHeadMsg is matching ----pass"+actvIHeadMsg);
		else
			System.out.println("actvIHeadMsg is not matching ----pass"+actvIHeadMsg);
	}
}

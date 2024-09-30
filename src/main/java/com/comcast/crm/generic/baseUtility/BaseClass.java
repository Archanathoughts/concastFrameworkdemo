package com.comcast.crm.generic.baseUtility;

import java.io.IOException; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass extends WebdriverUtility{ 
	public DatabaseUtility dbLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebdriverUtility wLib=new WebdriverUtility();  
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver=null;
		
	//if we make driver as static it will not participate in parallel execution
	public static WebDriver sessiondriver;
	
	@BeforeSuite(groups={"smoke","regression"})
	public void configBS()
	{
		System.out.println("===connect to DB, REport config===");
		//dbLib.getdbConnection(null, null, null);
		
				}
	
	
	@BeforeClass(groups={"smoke","regression"})
	public void configBC() throws IOException
	{
		System.out.println("=====Launch the browser=====");
		//String BROWSER = browser;
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		String URL = fLib.getDataFromPropertyFile("url");
		String PASSWORD = fLib.getDataFromPropertyFile("psw");
		
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
		sessiondriver=driver;
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		driver.get(URL);
		
	}
//	@Parameters("BROWSER")
//	@BeforeClass(groups={"smoke","regression"})
//	public void configBC(String browser) throws IOException
//	{
//		System.out.println("=====Launch the browser=====");
//		String BROWSER = browser;
//		//String BROWSER = fLib.getDataFromPropertyFile("browser");
//		String URL = fLib.getDataFromPropertyFile("url");
//		String PASSWORD = fLib.getDataFromPropertyFile("psw");
//		
//		if(BROWSER.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//		}else if(BROWSER.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}else if(BROWSER.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}else {
//			driver=new ChromeDriver();
//		}
//		driver.manage().window().maximize();
//		waitForPageToLoad(driver);
//		driver.get(URL);
//		
//	}
	@BeforeMethod(groups={"smoke","regression"})
	public void confifBM() throws IOException
	{
		System.out.println("===login===");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		
		String USERNAME = fLib.getDataFromPropertyFile("usn");
		String PASSWORD = fLib.getDataFromPropertyFile("psw");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	@AfterMethod(groups={"smoke","regression"})
	public void configAM()
	{
		System.out.println("===logout===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups={"smoke","regression"})
	public void configAS()
	{
		System.out.println("===disconnect browser  passss==");
		driver.quit();
	}
	
	@AfterSuite(groups={"smoke","regression"})
	public void confifAS()
	{
		System.out.println("===connect to DB, REport config===");
		//dbLib.closedbConnection();
		
	}
	

}

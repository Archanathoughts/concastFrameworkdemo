package com.comcast.crm.producttest;



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
import com.comcast.crm.objectrepositoryutility.product.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.product.ProductPage;

public class CreateNewProductTest {
	public static void main(String[] args) throws  InterruptedException, IOException {
		FileUtility fileutil=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebdriverUtility webUtil=new WebdriverUtility();
		JavaUtility javaUtil=new JavaUtility();
		
		int randint = javaUtil.getRandomNumber();
		 
		String proName = elib.getDataFromExcel("product", 1, 2)+randint;
		
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
		hp.getProductlnk().click();
		
		ProductPage prop=new ProductPage(driver);
		prop.getproductPlus().click();
		
		
		CreateNewProductPage pp=new CreateNewProductPage(driver);
		pp.creatProduct(proName, unitPrice);
//		pp.getPrNameTxtf().sendKeys(proName);
//		pp.getPrUnitPriceTxtf().sendKeys(unitPrice);
//		pp.getPrSavebtn().click();
		
		ProductInformationPage pip=new ProductInformationPage(driver);
		String actPrINameTxtf = pip.getPrINameTxtf().getText();
		String actprIUnit=pip.getPrIUnitPriceTxtf().getText();
		
		if(actPrINameTxtf.equals(proName))
			System.out.println("actPrINameTxtf is matching ----pass"+actPrINameTxtf);
		else
			System.out.println("actPrINameTxtf is not matching ----pass"+actPrINameTxtf);
		
		if(actprIUnit.contains(unitPrice))
			System.out.println("actprIUnit is matching ----pass"+actprIUnit);
		else
			System.out.println("actprIUnit is not matching ----pass"+actprIUnit);
	}
}

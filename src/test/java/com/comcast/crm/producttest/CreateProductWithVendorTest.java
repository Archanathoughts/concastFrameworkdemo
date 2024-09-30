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
import com.comcast.crm.objectrepositoryutility.vendor.CreateNewVendorPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorPage;

public class CreateProductWithVendorTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtility fileutil = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebdriverUtility webUtil = new WebdriverUtility();
		JavaUtility javaUtil = new JavaUtility();

		int randint = javaUtil.getRandomNumber();

		String proName = elib.getDataFromExcel("product", 1, 2) + randint;
		String unitPrice = elib.getDataFromExcel("product", 1, 4);

		String venName = elib.getDataFromExcel("vendor", 1, 2) + randint;
		String vphone = elib.getDataFromExcel("vendor", 1, 4);

		String BROWSER = fileutil.getDataFromPropertyFile("browser");
		String URL = fileutil.getDataFromPropertyFile("url");
		String USERNAME = fileutil.getDataFromPropertyFile("usn");
		String PASSWORD = fileutil.getDataFromPropertyFile("psw");

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		webUtil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);

		LoginPage lg = new LoginPage(driver);

		lg.loginToApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.navigateToVendorPage();

		VendorPage venp = new VendorPage(driver);
		venp.getvendorPlus().click();

		CreateNewVendorPage cvp=new CreateNewVendorPage(driver);
		cvp.createVendor(venName, vphone);

		hp.getProductlnk().click();

		ProductPage prop=new ProductPage(driver);
		prop.getproductPlus().click();
		

		
		CreateNewProductPage pp=new CreateNewProductPage(driver);
		pp.createProductWithVendor(proName, unitPrice, venName);

//		webUtil.switchToTabOnUrl(driver, "module=Vendors");
//		vp.getvSearchTxtf().sendKeys(venName);
//		vp.getvSearchNowTxtf().click();
//
//		driver.findElement(By.xpath("//a[text()='" + venName + "']")).click();
//		webUtil.switchToTabOnUrl(driver, "module=Products");
//		pp.getPrSavebtn().click();

		ProductInformationPage pip = new ProductInformationPage(driver);
		String actHeaderInfo = pip.getPrIHeaderMsg().getText();
		String actVendorName = pip.getpIvendName().getText();
		String actProName = pip.getPrINameTxtf().getText();

		if (actProName.contains(proName))
			System.out.println("actProName  match with actProName--pass " + actProName);
		else
			System.out.println("actProName  match with actProName--fail " + actProName);

		if (actVendorName.contains(venName))
			System.out.println("actVendorName  match with VendorName--pass " + actVendorName);
		else
			System.out.println("actVendorName  match with VendorName--fail " + actVendorName);

		if (actProName.contains(proName))
			System.out.println("actProName  match with ProName---pass " + actProName);
		else
			System.out.println("actProName  match with actProName---fail " + actProName);

	}
}

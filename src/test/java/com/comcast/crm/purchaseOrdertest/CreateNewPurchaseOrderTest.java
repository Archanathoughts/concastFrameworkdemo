package com.comcast.crm.purchaseOrdertest;

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
import com.comcast.crm.objectrepositoryutility.product.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductPage;
import com.comcast.crm.objectrepositoryutility.purchaseOrder.CreateNewPurchaseOrderPage;
import com.comcast.crm.objectrepositoryutility.purchaseOrder.PurchaseOrderPage;
import com.comcast.crm.objectrepositoryutility.vendor.CreateNewVendorPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorPage;

public class CreateNewPurchaseOrderTest {
	public static void main(String[] args) throws EncryptedDocumentException, InterruptedException, IOException {

		FileUtility fileutil = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebdriverUtility webUtil = new WebdriverUtility();
		JavaUtility javaUtil = new JavaUtility();

		int randint = javaUtil.getRandomNumber();

//		String OrgName = elib.getDataFromExcel("org", 1, 2) + randint;
//		String subject = elib.getDataFromExcel("salesorder", 1, 2);
//		String billAddr = elib.getDataFromExcel("salesorder", 1, 3);
//		String OppName = elib.getDataFromExcel("opportunity", 1, 2) + randint;
//		String campName = elib.getDataFromExcel("campaign", 1, 2) + randint;
		String proName = elib.getDataFromExcel("product", 1, 2) + randint;
		String unitPrice = elib.getDataFromExcel("product", 1, 4);
		String purchaseOrd = elib.getDataFromExcel("purchaseorder", 1, 2) + randint;
		String purOrdBillAdd = elib.getDataFromExcel("purchaseorder", 1, 3) + randint;
		String qty = elib.getDataFromExcel("purchaseorder", 1, 5);
		System.out.println(Integer.valueOf(qty));
		String vendor = elib.getDataFromExcel("vendor", 1, 2) + randint;
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
		cvp.createVendor(vendor, vphone);

		hp.getProductlnk().click();

		ProductPage prop=new ProductPage(driver);
		prop.getproductPlus().click();
		

		
		CreateNewProductPage pp=new CreateNewProductPage(driver);
		pp.createProductWithVendor(proName, unitPrice, vendor);
		
		Thread.sleep(2000);
		hp.navigateToPurchaseOrderPage();

		PurchaseOrderPage purop = new PurchaseOrderPage(driver);
		purop.getCreatPurImg().click();

		CreateNewPurchaseOrderPage cpop = new CreateNewPurchaseOrderPage(driver);
		cpop.createPurchaseOrder(purchaseOrd, vendor, proName, purOrdBillAdd,Integer.valueOf(qty));

	}
}

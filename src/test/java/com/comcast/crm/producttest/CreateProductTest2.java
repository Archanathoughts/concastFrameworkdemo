package com.comcast.crm.producttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.product.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.product.ProductPage;
import com.comcast.crm.objectrepositoryutility.vendor.CreateNewVendorPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorPage;

public class CreateProductTest2 extends BaseClass {
	@Test
	public void createNewProductTest() throws EncryptedDocumentException, IOException {
		// get the test data from excel
		int randint = jLib.getRandomNumber();
		String proName = eLib.getDataFromExcel("product", 1, 2) + randint;
		String unitPrice = eLib.getDataFromExcel("product", 1, 4);

		HomePage hp = new HomePage(driver);
		hp.getProductlnk().click();

		ProductPage prop = new ProductPage(driver);
		prop.getproductPlus().click();

		CreateNewProductPage pp = new CreateNewProductPage(driver);
		pp.creatProduct(proName, unitPrice);

		ProductInformationPage pip = new ProductInformationPage(driver);
		String actPrINameTxtf = pip.getPrINameTxtf().getText();
		String actprIUnit = pip.getPrIUnitPriceTxtf().getText();

		if (actPrINameTxtf.equals(proName))
			System.out.println("actPrINameTxtf is matching ----pass" + actPrINameTxtf);
		else
			System.out.println("actPrINameTxtf is not matching ----pass" + actPrINameTxtf);

		if (actprIUnit.contains(unitPrice))
			System.out.println("actprIUnit is matching ----pass" + actprIUnit);
		else
			System.out.println("actprIUnit is not matching ----pass" + actprIUnit);
	}
	
	@Test
	public void createProductWithVendor() throws EncryptedDocumentException, IOException, InterruptedException
	{
		int randint = jLib.getRandomNumber();

		String proName = eLib.getDataFromExcel("product", 1, 2) + randint;
		String unitPrice = eLib.getDataFromExcel("product", 1, 4);

		String venName = eLib.getDataFromExcel("vendor", 1, 2) + randint;
		String vphone = eLib.getDataFromExcel("vendor", 1, 4);
        
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
		
		ProductInformationPage pip = new ProductInformationPage(driver);
		String actHeaderInfo = pip.getPrIHeaderMsg().getText();
		String actVendorName = pip.getpIvendName().getText();
		String actProName = pip.getPrINameTxtf().getText();

		if (actHeaderInfo.contains(proName))
			System.out.println("actHeaderInfo  match with actProName--pass " + actProName);
		else
			System.out.println("actHeaderInfo  match with actProName--fail " + actProName);

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

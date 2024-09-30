package com.comcast.crm.purchaseOrdertest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.product.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductPage;
import com.comcast.crm.objectrepositoryutility.purchaseOrder.CreateNewPurchaseOrderPage;
import com.comcast.crm.objectrepositoryutility.purchaseOrder.PurchaseOrderPage;
import com.comcast.crm.objectrepositoryutility.vendor.CreateNewVendorPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorPage;

public class CreatePurchaseOrderTest2 extends BaseClass {
	@Test
	public void createPurchaseOrderTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		int randint = jLib.getRandomNumber();
		String proName = eLib.getDataFromExcel("product", 1, 2) + randint;
		String unitPrice = eLib.getDataFromExcel("product", 1, 4);
		String purchaseOrd = eLib.getDataFromExcel("purchaseorder", 1, 2) + randint;
		String purOrdBillAdd = eLib.getDataFromExcel("purchaseorder", 1, 3) + randint;
		String qty = eLib.getDataFromExcel("purchaseorder", 1, 5);
		System.out.println(Integer.valueOf(qty));
		String vendor = eLib.getDataFromExcel("vendor", 1, 2) + randint;
		String vphone = eLib.getDataFromExcel("vendor", 1, 4);
		
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

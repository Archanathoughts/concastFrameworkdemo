package com.comcast.crm.salesOrdertest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingneworganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.product.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductPage;
import com.comcast.crm.objectrepositoryutility.salesOrder.CreateNewSalesOrderPage;
import com.comcast.crm.objectrepositoryutility.salesOrder.SalesOrderPage;

public class CreateSalesOrderTest2 extends BaseClass{
	@Test
	public void createSalesOrderTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		int randint = jLib.getRandomNumber();
		 
		String OrgName = eLib.getDataFromExcel("org", 1, 2)+randint;
		String subject = eLib.getDataFromExcel("salesorder", 1, 2);
		String billAddr = eLib.getDataFromExcel("salesorder", 1, 3);
		String OppName = eLib.getDataFromExcel("opportunity", 1, 2)+randint;
		String campName = eLib.getDataFromExcel("campaign", 1, 2)+randint;
		String proName = eLib.getDataFromExcel("campaign", 1, 2)+randint;
		String unitPrice = eLib.getDataFromExcel("product", 1, 4);
		
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
			
		hp.navigateToSalesOrder();
		SalesOrderPage sp=new SalesOrderPage(driver);
		sp.getSalesPlus().click();
		
		CreateNewSalesOrderPage csop=new CreateNewSalesOrderPage(driver);
		csop.createSalesOrderWithOrg(subject, OrgName, billAddr, proName);
		
	}
	

}

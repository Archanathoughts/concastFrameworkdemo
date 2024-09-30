package com.comcast.crm.vendor;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.vendor.CreateNewVendorPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorInformationPage;
import com.comcast.crm.objectrepositoryutility.vendor.VendorPage;

public class CreateVendorTest2 extends BaseClass {
	@Test
	public void createVendorTest() throws EncryptedDocumentException, IOException, InterruptedException {
		int randint = jLib.getRandomNumber();

		String venName = eLib.getDataFromExcel("vendor", 1, 2) + randint;
		String vphone = eLib.getDataFromExcel("vendor", 1, 4);

		HomePage hp = new HomePage(driver);
		hp.navigateToVendorPage();

		VendorPage vp = new VendorPage(driver);
		vp.getvendorPlus().click();

		CreateNewVendorPage cvp = new CreateNewVendorPage(driver);
		cvp.createVendor(venName, vphone);

		VendorInformationPage vip = new VendorInformationPage(driver);
		String actvIName = vip.getvINameTxtf().getText();
		String actvIphone = vip.getvIPhoneTxtf().getText();
		String actvIHeadMsg = vip.getvIHeaderMsg().getText();
		if (actvIName.equals(venName))
			System.out.println("actvIName is matching ----pass" + actvIName);
		else
			System.out.println("actvIName is not matching ----pass" + actvIName);

		if (actvIphone.contains(vphone))
			System.out.println("actvIphone is matching ----pass" + actvIphone);
		else
			System.out.println("actvIphone is not matching ----pass" + actvIphone);

		if (actvIHeadMsg.contains(venName))
			System.out.println("actvIHeadMsg is matching ----pass" + actvIHeadMsg);
		else
			System.out.println("actvIHeadMsg is not matching ----pass" + actvIHeadMsg);
	}

}

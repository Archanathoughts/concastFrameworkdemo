package com.comcast.crm.campaigntest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.campaigns.CampaignPage;
import com.comcast.crm.objectrepositoryutility.campaigns.CreateNewCampaignsPage;

public class CreateNewCampaignTest2 extends BaseClass {
	@Test
	public void creatCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
	//test data
	int rand=jLib.getRandomNumber();
	String  campName=eLib.getDataFromExcel("campaign", 1,2)+rand;
	
	//navigate to campaign	
	
	HomePage hp=new HomePage(driver);
	hp.navigateToCampaginPage();
	
	CampaignPage cp=new CampaignPage(driver);
	cp.getCampPlus().click();
	
	CreateNewCampaignsPage campp=new CreateNewCampaignsPage(driver);
	campp.createNewCampaign(campName);
			
	}
}

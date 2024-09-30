package com.comcast.crm.practice.screenshot;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateSimRetry {
	@Test(retryAnalyzer = com.comcast.crm.generic.listenerUtility.RetryListenerImp.class)
	public void createInvoiceTest()
	{
		System.out.println("execute create Invoice");
	
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}

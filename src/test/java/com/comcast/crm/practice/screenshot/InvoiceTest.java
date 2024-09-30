package com.comcast.crm.practice.screenshot;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.BaseClass;

//@Listeners(com.comcast.crm.generic.listenerUtility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute create Invoce");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	@Test
	public void creatInvoiceWithConactTest()
	{
		System.out.println("execute creatInvoiceWithConactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}

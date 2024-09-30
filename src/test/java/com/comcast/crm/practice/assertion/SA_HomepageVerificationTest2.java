package com.comcast.crm.practice.assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SA_HomepageVerificationTest2 {
@Test
public void HomePageVerificationtest(Method med)
{
	SoftAssert saobj=new SoftAssert();
	System.out.println(med.getName()+"starts");
	System.out.println("step=1");
	System.out.println("step=2");
	saobj.assertEquals("home", "home");
	System.out.println("step=3");
	saobj.assertEquals("home1", "home");
	System.out.println("step=4");
	System.out.println(med.getName()+"=========ends=========");
	saobj.assertAll();
}
@Test
public void verifyLogo(Method med)
{
	SoftAssert saobj=new SoftAssert();
	System.out.println(med.getName()+"starts");
	System.out.println("step=1");
	System.out.println("step=2");
	saobj.assertEquals("home", "home");
	System.out.println("step=3");
	saobj.assertEquals("home1", "home1");
	System.out.println("step=4");
	System.out.println(med.getName()+"======ends========");
}
}


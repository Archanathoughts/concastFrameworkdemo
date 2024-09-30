package com.comcast.crm.practice.assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HA_HomepageVerificationTest {
@Test
public void HomePageVerificationtest(Method med)
{
	System.out.println(med.getName()+"starts======");
	System.out.println("step=1");
	System.out.println("step=2");
	Assert.assertEquals("home", "home");
	System.out.println("step=3");
	Assert.assertEquals("home1", "home");
	System.out.println("step=4");
	System.out.println(med.getName()+"ends=======");
}
@Test
public void verifyLogo(Method med)
{
	System.out.println(med.getName()+"starts=======");
	System.out.println("step=1");
	System.out.println("step=2");
	Assert.assertEquals("home", "home");
	System.out.println("step=3");
	Assert.assertEquals("home1", "home1");
	System.out.println("step=4");
	System.out.println(med.getName()+"ends====");
}
}


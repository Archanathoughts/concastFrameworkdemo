package com.comcast.crm.practice.assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HASA_HomepageVerificationTest2 {
@Test
public void HomePageVerificationtest(Method med)
{
	String expectedMsg="Home";
	System.out.println(med.getName()+"starts======");
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	String actHdrMsg=driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	Assert.assertEquals(actHdrMsg, expectedMsg);
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
@Test
public void verifyLogo2(Method med)
{
	Reporter.log(med.getName()+"starts=======");
	Reporter.log("step=1",true);
	Reporter.log("step=2",true);
	Assert.assertEquals("home", "home");
	Reporter.log("step=3",true);
	Assert.assertEquals("home1", "home1");
	Reporter.log("step=4");
	Reporter.log(med.getName()+"ends====");
}
}


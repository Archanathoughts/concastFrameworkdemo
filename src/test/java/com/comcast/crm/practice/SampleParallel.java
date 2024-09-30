package com.comcast.crm.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SampleParallel {
	@Test  //(invocationCount = 2,threadPoolSize = 2)
	public void sample() throws InterruptedException
	{  
//		ChromeOptions ch=new ChromeOptions();
//		ch.addArguments("--disable--notifications");
//		WebDriver d=new ChromeDriver(ch);
	  //  d.get("https://google.com");
		WebDriver d=new FirefoxDriver();
		System.out.println("hello");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get("https://www.clinique.in/");
		WebElement ele = d.findElement(By.linkText("Skin Concern"));
		Actions act=new Actions(d);
		act.moveToElement(ele).perform();
	  //  Thread.sleep(1000);
	  //  act.moveByOffset(50, 200).click();
	  
	  
	    
	    d.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		List<WebElement> eles = d.findElements(By.xpath("(//p[@class='gnav-desktop-sub-nav-category-title']/..)[1]/a"));
		for(WebElement el:eles)
		{
		
			System.out.println(el.getText());
	     }
	
	//d.quit();
	}
}

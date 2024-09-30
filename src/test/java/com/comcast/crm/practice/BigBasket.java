package com.comcast.crm.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {
	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.manage().window().maximize();
		d.get("https://www.bigbasket.com/");
		d.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']")).click();
		WebElement element = d.findElement(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs']/li/a)[1]"));
		Actions act=new Actions(d);
		act.moveToElement(element).perform();
		List<WebElement> elements = d.findElements(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800'])[2]/li"));
		System.out.println(elements.size());
		for(WebElement ele:elements)
		{
			System.out.println(ele.getText());
			act.moveToElement(ele).perform();
			WebElement ele1 = d.findElement(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs'])[1]/li/a"));
			
			System.out.println(ele1.getText());
//			WebElement element2 = d.findElement(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']/li/a)[1]"));
//			Actions act1=new Actions(d);
//			act1.moveToElement(element2).perform();
//			System.out.println(element2.getText());
//			WebElement ele3=d.findElement(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']/li/a)[1]"));
//			act1.moveToElement(ele3).perform();
//			System.out.println(ele3.getText());
			
		}
		d.close();
		
	
	
	}

}

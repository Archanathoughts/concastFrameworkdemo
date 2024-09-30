package com.comcast.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
	public static void main(String[] args) {
	WebDriver d=new ChromeDriver();
	d.get("https://www.flipkart.com/");
	d.findElement(By.xpath("//div[contains(@class='_3sdu8W')]/child::a[@Beauty='Beauty']")).click();
	
	
	
	}
}

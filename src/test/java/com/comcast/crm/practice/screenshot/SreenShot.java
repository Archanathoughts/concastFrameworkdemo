package com.comcast.crm.practice.screenshot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class SreenShot {
	@Test
	public void screenShot(Method med) throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
       // String FileName1 = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./screenshot/"+FileName));
		//FileHandler.copy(src, new File("./screenshot/"+med+".png"));
	}

}

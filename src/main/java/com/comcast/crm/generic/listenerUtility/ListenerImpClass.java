package com.comcast.crm.generic.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseUtility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass extends BaseClass implements ITestListener,ISuiteListener {

	public ExtentTest test;
	public ExtentSparkReporter spark;
	public static ExtentReports report;//make it static to use it in every test case
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// TODO Auto-generated method stub
		//spark report configuration
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
	    spark=new ExtentSparkReporter("./AdvanceReort/report"+time+".html");
		spark.config().setDocumentTitle("Crm Test Results");
		spark.config().setReportName("CrM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========>"+result.getMethod().getMethodName()+">===Start=====");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====started=====");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========>"+result.getMethod().getMethodName()+">===end=====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)sessiondriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":","_");
		try {
			System.out.println("============screenshot======");
			FileHandler.copy(src, new File("./screenshot/"+testName+"+"+time+".png"));
			test.addScreenCaptureFromBase64String(path,testName+"_"+time);
			test.log(Status.FAIL,result.getMethod().getMethodName()+"=====FAIL=====");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

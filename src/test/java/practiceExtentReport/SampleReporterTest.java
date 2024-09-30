package practiceExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseUtility.BaseClass;

//public class SampleReporterTest extends BaseClass {
public class SampleReporterTest{
	public ExtentTest test;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	@BeforeSuite
	
		public void configBS() {
		//spark report configuration
	    spark=new ExtentSparkReporter("./AdvanceReort/report.html");
		spark.config().setDocumentTitle("Crm Test Results");
		spark.config().setReportName("CrM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
@Test
public void CreatecontactTest(){
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	String filePath=ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test=report.createTest("CreatecontactTest");
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFCss".equals("HDC"))
	{
		test.log(Status.PASS,"contact ctreated");
	}
	else
	{
		test.addScreenCaptureFromBase64String(filePath,"Error File");
		//test.log(Status.FAIL,"contact not created");
	}
	
	}
@Test
public void CreatecontactTest3(){
	
	ExtentTest test=report.createTest("CreatecontactTest3");
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact ctreated");
	}
	else
	{
		test.log(Status.FAIL,"contact not created");
	}
	//report.flush();
	}
@Test
public void CreatecontactTest2(){
	
	ExtentTest test=report.createTest("CreatecontactTest2");
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact ctreated");
	}
	else
	{
		test.log(Status.FAIL,"contact not created");
	}
	//report.flush();
	}
}

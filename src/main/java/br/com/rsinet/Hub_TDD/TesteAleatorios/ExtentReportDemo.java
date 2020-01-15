package br.com.rsinet.Hub_TDD.TesteAleatorios;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.Utility.Utility;


public class ExtentReportDemo {
	
	private static  ExtentReports extent;
	private static  ExtentTest logger;
	private static  WebDriver driver;
	private static  ITestResult result;
	
        // This code will run before executing any testcase
	@BeforeClass
	public static void setup()
	{
	    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
		
	    extent = new ExtentReports();
	    
	    extent.attachReporter(reporter);
	    
	    logger=extent.createTest("LoginTest");
	}
 
	
        // Actual Test which will start the application and verify the title
	@Test
	public void loginTest() throws IOException
	{
	
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println("title is "+ driver.getTitle());
		Assert.assertFalse(driver.getTitle().contains("joice"));
	}
	
        // This will run after testcase and it will capture screenshot and add in report
	
	@AfterClass
	public static void tearDown() throws IOException
	{
		  if (result.getStatus() == ITestResult.SUCCESS) {
	            String temp = Utility.getScreenshot(driver);

	 

	            logger.pass(temp, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	         

	        } else if (result.getStatus() == ITestResult.FAILURE) {
	            String temp = Utility.getScreenshot(driver);

	 

	            logger.fail(result.getThrowable().getMessage(),
	                    MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	         
	        }
		
		
		
	
		
		extent.flush();
		driver.quit();
	}
	

}

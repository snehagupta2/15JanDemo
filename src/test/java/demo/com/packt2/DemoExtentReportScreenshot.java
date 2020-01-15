package demo.com.packt2;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoExtentReportScreenshot {
	
	         
		 ExtentReports extent;
		 ExtentTest logger;
		 WebDriver driver;
		
	      
		@BeforeMethod
		public  void setup()
		{
			 ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\sneha.gupta2\\Desktop\\TeamsStuff\\Reports\\learn_automation2.html");
				
			
		    extent = new ExtentReports();
		    
		    extent.attachReporter(reporter);
		    
		    logger=extent.createTest("LoginTest");
		}
	 
		
	       
		@Test
		public void loginTest() throws IOException
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sneha.gupta2\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.google.com");
			System.out.println("title is "+driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Mukesh"));
		}
		
	       
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException
		{
			
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String temp=Utility.getScreenshot(driver);
				
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}
			
			extent.flush();
			driver.quit();
			
		}
		
		
	}

	


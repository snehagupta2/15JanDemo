package demo.com.packt2;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
public class ExtentReportDemo 
{
	
		@Test
		public void loginTest() throws IOException
		{    
		    ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\sneha.gupta2\\Desktop\\TeamsStuff\\Reports\\learn_automation1.html");
			
	         
		    ExtentReports extent = new ExtentReports();
		    
	          
		    extent.attachReporter(reporter);
		    
	        
		    ExtentTest logger=extent.createTest("LoginTest");
		    
	         
		    logger.log(Status.INFO, "Login to amazon");
		   
		    logger.log(Status.PASS, "Title verified");
		   
	           
		    extent.flush();
			
	           
		    ExtentTest logger2=extent.createTest("Logoff Test");
		    
		    logger2.log(Status.FAIL, "Title verified");
		    
		    logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
	        
		    logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
	 
	           
		    extent.flush();
		    	
		}
		
	}



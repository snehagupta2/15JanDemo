package demo.com.packt1;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.TeamsHomePage;
import com.crm.qa.pages.TeamsLoginPage;
import com.crm.qa.util.Utility;



public class LoginPageTest extends TestBase{
	 
	TeamsLoginPage loginPage;
	TeamsHomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new TeamsLoginPage();	
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\sneha.gupta2\\Desktop\\TeamsStuff\\Reports\\teams_automation.html");
		
		extent = new ExtentReports();
	    
	    extent.attachReporter(reporter);
	    
	    logger=extent.createTest("loginTest");
		
	}
	
	
	
	
	
	@Test(priority=1)
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=Utility.getScreenshot(driver);
			
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		extent.flush();
		//driver.quit();
	}
	
	
	
	

}

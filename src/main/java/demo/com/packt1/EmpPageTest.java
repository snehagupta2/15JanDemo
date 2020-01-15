

package demo.com.packt1;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.TeamsEmpPage;
import com.crm.qa.pages.TeamsHomePage;
import com.crm.qa.pages.TeamsLoginPage;
import com.crm.qa.util.TestUtilForExcel;
import com.crm.qa.util.TestUtil;

public class EmpPageTest extends TestBase{

	TeamsLoginPage loginPage;
	TeamsHomePage homePage;
	TeamsEmpPage empPage;
	
	
	
	   
	public EmpPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		initialization();
		loginPage = new TeamsLoginPage();
		homePage = new TeamsHomePage();
		empPage = new TeamsEmpPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.passTextToSearchTab("create");
		
	}
	
	//@Test(priority=1)
	public void verifyUploadFile() throws Exception{
		 empPage.uploadFile();
	}
	
	
	

	
	
	
}

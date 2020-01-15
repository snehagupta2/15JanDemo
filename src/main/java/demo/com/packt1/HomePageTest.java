package demo.com.packt1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.TeamsEmpPage;
import com.crm.qa.pages.TeamsHomePage;
import com.crm.qa.pages.TeamsLoginPage;
import com.crm.qa.util.TestUtilForExcel;

public class HomePageTest extends TestBase {
	TeamsLoginPage loginPage;
	TeamsHomePage homePage;
	TestUtilForExcel testUtil;
	String sheetName = "searching";

	public HomePageTest() {
		super();
	}

	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
	    loginPage = new TeamsLoginPage();
		homePage = new TeamsHomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtilForExcel.getTestData(sheetName);
		return data;
	}
	
	//@Test(priority=1, dataProvider="getCRMTestData")
	public void loginTest(String searchKeyword){
		homePage.passTextToSearchTab(searchKeyword);
		
		
		
	
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}

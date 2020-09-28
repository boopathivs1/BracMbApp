package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class ProjectWrappers extends GenericWrappers {
	
	public String browserName;
	public String dataSheetName;

	@BeforeSuite(groups={"common"})
	public void beforeSuite(){
		startResult();
	}

@BeforeTest(groups={"common"})
public void beforeTest(){
	loadObjects();
	}
	
	@BeforeMethod(groups={"common"})
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		//invokeApp(browserName);
	}
		
	
	
	@AfterSuite(groups={"common"})
	public void afterSuite(){
		endResult();
		
	}

	@AfterTest(groups={"common"})
	public void afterTest() throws InterruptedException{
		

		unloadObjects();
	}
	
	@AfterMethod(groups={"common"})
	public void afterMethod() throws InterruptedException{
		
		
		endTestcase();
//		closeBrowser();	
	}
	
	@DataProvider(name="fetchData")


	public Object[][] getDataExcel() throws IOException{
		return DataInputProvider.geta("./data/"+dataSheetName+".xlsx",testKeyword);		
	}	
		
	}
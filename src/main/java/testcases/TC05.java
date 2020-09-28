package testcases;

import org.testng.annotations.Test;
import org.springframework.expression.spel.ast.Projection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC05 extends ProjectWrappers {


	@BeforeClass()
	public void setData() {
		testCaseName="TC05";
		testDescription="Verifying loan Summary";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC05";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username,
			String password,String nickname,String Beneficiaryname,String FromAccNo,String ToAccNo,String CurrencyType,
			String Amount,String Remarks,String BankName,String TransAppType,String FilterFromAmount,String FilterToAmount,
			String LastTrans) throws Exception{
	//test
		try{
		
		new LoginPage(driver, test)
		.getStartApp(Devicename, versionName, udid, portnumber)
		.LoginApp(username, password)
		.clickLoanSummary()
		.clickDetailsExpandButton()
		.clickMoreDetails();
//		.clickAccback()
//		.clickAccback()
//		.logoutApp();
		}
		catch (Exception e) {
//			logoutApp();
			throw new Exception();
		
		
		}
		
		
	//.//input[@id='loginaskno']	
	}
}
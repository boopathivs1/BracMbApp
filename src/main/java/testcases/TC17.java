package testcases;

import org.testng.annotations.Test;
import org.springframework.expression.spel.ast.Projection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC17 extends ProjectWrappers {


	@BeforeClass()
	public void setData() {
		testCaseName="TC17,18,19";
		testDescription="Beneficiary Maintainance Add, Edit and delete Within Brac bank Accounts";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC17";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username,String password,String accno,String nickname,String entermail,String otp,String shortname,String data1,String data2,String data3,String data4,String data5,String data6,String data67) throws Exception{
	
		String accountnumber=regvalue(accno);		
		try{
		
		new LoginPage(driver, test)
		.getStartApp(Devicename, versionName, udid, portnumber)
		.LoginApp(username, password)
.clickToggleLink()
.clickManageBeneficiaryLink()
.clickWithinbankLink()
.clickNextLink()
.deletebeneficiary(accountnumber)
.clickAddBeneficiaryButton()
.fillAccountnum(accountnumber)
.fillnickname(nickname)
.entermail(entermail)
.clickSmsNextButton()
.clickconfirm()
.EnterOtp(otp)
.submitAddBeneOtpconfirm()
.clickViewBeneButton()
.clickAddbeneNum(accountnumber)
.editbeneform(shortname)
.EnterOtp(otp)
.submitEditOtp()
.clickOK()
.accnunmberverify(accountnumber)
.clickback()
.clickback()
.logoutApp();

		}
		catch (Exception e) {
			//logoutApp();
			throw new Exception();
		
		}
		
	}
}
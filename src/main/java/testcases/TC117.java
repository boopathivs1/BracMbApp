package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC117 extends ProjectWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="TC117";
		testDescription="GuardianLife( One-off Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC117";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Billername,String fromAcc,String insuranceno,String amount,String Purpose,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String data6,String data7) throws Exception{
		
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	.clickBillandFeesLink()
	. clickInsurancebiller()
	.clickbillerNextbutton()
	.clickbillersubModule(Billername)
	.clickbillerNextbutton()
	.clickOnetimeBiller()
	.fillbillerForm("frombillonePay", fromAcc)
	.getAccountBalance()
	.fillbillerForm("enterPolicyno", insuranceno)
	//.fillbillerForm("enteramount", amount)
	.fillbillerForm("Purpose", Purpose)
	.doubleScroll()
	.fillbillerForm("Onetimenext", null)
	//.fillbillerForm("Onetimenext", null)
	.getamt()
	.singleScroll()
	.fillbillerForm("confirmbutton", null)
	//.fillbillerForm("onetimFinalconfirmbutton", null)
	.EnterOtp(otp)
	.submitAddBeneOtpconfirm()
	.clickmenu()
	.clickMoreMenu()
	.clickMoreMenuNext()
	.filterTransactionHistoryValue(fromAcc,toaccHistory,transtype,Benetype,channelid,Devicename)
	.verifyTransactionHistoryBillers(BillDueAmount)
	.clickBacktoDashboard()
	.clickToggleLink()
	.clickProductMenu()
	.clickAccountMenu()
	.verifyAccountsPagebalance(fromAcc)
	.verifyMiniStatementbalance(amount);
	
			
		}
		catch (Exception e) {
			throw new Exception();
		}
		
	
	}
}


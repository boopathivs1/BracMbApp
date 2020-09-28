package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC119 extends ProjectWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="TC119";
		testDescription="Brac University( One-off Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC119";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Billername,String fromAcc,String insuranceno,String amount,String Purpose,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String bracsubcat,String bracbiller) throws Exception{
		
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	.clickBillandFeesLink()
	. clicktuitionfees()
	.clickbillerNextbutton()
	.clickbillersubModule(Billername)
	.clickbillerNextbutton()
	.clickOnetimeBiller()
	.fillbillerForm("frombillonePay", fromAcc)
	.getAccountBalance()
	.fillbillerForm("BracSubcat", bracsubcat)
	.fillbillerForm("BracBiller", bracbiller)
	
	.fillbillerForm("enterPolicyno", insuranceno)
	//.fillbillerForm("enteramount", amount)
	//.fillbillerForm("Purpose", Purpose)
	.doubleScroll()
	.fillbillerForm("Onetimenext", null)
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


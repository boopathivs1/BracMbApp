package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC111 extends ProjectWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC111";
		testDescription="Utility WASA( One-off Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC111";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Billername,String fromAcc,String billno,String subcat,String formBillName,
			String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String amount,String data2) throws Exception{
			
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	.clickBillandFeesLink()
	. ClickUtilitybiller()
	.clickbillerNextbutton()
	.clickbillersubModule(Billername)
	.clickbillerNextbutton()
	.clickOnetimeBiller()
	.fillbillerForm("frombillonePay", fromAcc)
	.getAccountBalance()
	.fillbillerForm("BracSubcat",subcat)
	.fillbillerForm("BracBiller", formBillName)
	
	.fillbillerForm("enterPolicyno", billno)
	//.fillbillerForm("enteramount", amount)
	//.fillbillerForm("Purpose", Purpose)
	.singleScroll()
	.fillbillerForm("Onetimenext", null)
	.singleScroll()
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
package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC113 extends ProjectWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="TC113";
		testDescription="Carnival( One-off Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC113";
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
	.clickInternetbiller()
	.clickbillerNextbutton()
	.clickbillersubModule(Billername)
	.clickbillerNextbutton()
	.clickOnetimeBiller()
	.fillbillerForm("frombillonePay", fromAcc)
	.getAccountBalance()
	.fillbillerForm("enterPolicyno", insuranceno)
	//.fillbillerForm("clickPolicyno",null)
	
	
	//.fillbillerForm("enteramount", amount)
	.singleScroll()
	//.fillbillerForm("Purpose", Purpose)
	.fillbillerForm("Onetimenext", null)
	
	.fillbillerForm("Onetimenext", null)
	.getamt()
	.singleScroll()
	.fillbillerForm("confirmbutton", null)
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
			// TODO: handle exception
			throw new Exception();
		}
		
	
	}
}


package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC110 extends ProjectWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="TC110";
		testDescription="Utility WASA(Beneficiary Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC110";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Billername,String fromAcc,String billno,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String amount,String data2,String data1,String data3) throws Exception{
		
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
	.clickToBiller()
	.selectBiller(billno)
	.fillbillerForm("Nextbutton", null)
	.fillbillerForm("fromAccount", fromAcc)
	.getAccountBalance()
	//.fillbillerForm("enteramount", amount)
	//.fillbillerForm("Purpose", Purpose)
	.fillbillerForm("confirmbutton", null)
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


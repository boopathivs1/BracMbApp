package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC104 extends ProjectWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC104";
		testDescription="Robi ( Beneficiary Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC104";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Billername,String Mobno,String fromAcc,String amount,String contype,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String data6,String data7) throws Exception{
		
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	
	.clickBillandFeesLink()
	. clickMobilebiller()
	.clickbillerNextbutton()
	.clickbillersubModule(Billername)
	.clickbillerNextbutton()
	.clickToBiller()
	.selectBiller(Mobno)
	.fillbillerForm("Nextbutton", null)
	.fillbillerForm("fromAccount", fromAcc)
	.getAccountBalance()
	.fillbillerForm("enteramount", amount)
	.fillbillerForm("confirmbutton", null)
	.singleScroll()
	.fillbillerForm("confirmbutton", null)
	.singleScroll()
	.fillbillerForm("confirmbutton", null)
	.EnterOtp(otp)
	.submitAddBeneOtpconfirm()
	.clickmenu()
	.clickMoreMenu()
	.clickMoreMenuNext()
	.filterTransactionHistoryValue(fromAcc,toaccHistory,transtype,Benetype,channelid,Devicename)
	.verifyTransactionHistoryBillers(amount)
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


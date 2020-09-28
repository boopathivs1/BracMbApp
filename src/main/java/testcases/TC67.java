package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC67 extends ProjectWrappers{
	@BeforeClass()
	public void setData() {
		testCaseName="TC67";
		testDescription="One-Off Payment Transfer To Rocket Transfer(Rocket account)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC67";
				}
	
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Walletname,String fromAcc,String accno,String accname,String amount,String purpose,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String data1) throws Exception{

		try
		{
		
		new LoginPage(driver, test)
		.getStartApp(Devicename, versionName, udid, portnumber)
		.LoginApp(username, password)
.clickToggleLink()
.clickTransferLink()
.clickMobilewalletLink()
.clickWalletnextBtn()
.clickWalletsubModule(Walletname)
.clickWalletnextBtn()
.clickWalletOnetimepayBtn()
.fillTransferForm("fromAcc",fromAcc)
.getAccountBalance()
.fillTransferForm("enteraccountno",accno)
.fillTransferForm("enteraccountname", accname)
.fillTransferForm("enteramount",amount)
.fillTransferForm("purpose",purpose)
.clickAuthSmsbutton()
.singleScroll()
.singleScroll()
.clickPaynowbutton()
.singleScroll()
.singleScroll()



.clickWalletTransferNextbtn()


.EnterOtp(otp)
.submitAddBeneOtpconfirm()


//.clickTransferbutton()
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

///a
		}
  
		catch (Exception e) {
			// TODO: handle exception
			logoutApp();
			throw new Exception();
		}
}
}
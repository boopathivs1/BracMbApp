package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC29 extends ProjectWrappers {
	

	@BeforeClass()
	public void setData() {
		testCaseName="TC29";
		testDescription="Transfer Between My Account(With Account)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC29";
				}
	
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String selectBeneAccno,String fromAcc,String amount,String Remarks,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String data6,String data7,String data8) throws Exception{
		//String Cardnumber=regvalue(Cardno);
//	AccountBalance="100";
		try
		{
			
		
		new LoginPage(driver, test)
		.getStartApp(Devicename, versionName, udid, portnumber)
		.LoginApp(username, password)
.clickToggleLink()

.clickTransferLink()

//.clickownAccMenu()

.clickTransNextbutton()
.selectBeneficiary(selectBeneAccno)
.selectBeneNextbutton()
.fillTransferForm("fromAcc",fromAcc)
.getAccountBalance()
.fillTransferForm("enteramount",amount)
.doubleScroll()
.fillTransferForm("Remarks",Remarks)
.doubleScroll()
.fillTransferForm("confirmbutton",null)
.EnterOtp(otp)
.submitAddBeneOtpconfirm()
.singleScroll()
.clickTransferbutton()

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
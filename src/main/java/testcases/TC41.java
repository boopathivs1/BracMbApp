package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC41 extends ProjectWrappers {
	

	@BeforeClass()
	public void setData() {
		testCaseName="TC41";
		testDescription="One-Off Payment Transfer To Other Bank(BEFTN With Account)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Boopathi";
		testKeyword="TC41";
				}
	
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String selectBeneAccno,String fromAcc,String amount,String purpose,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String accname,String bankname,String branchname) throws Exception{
		//String Cardnumber=regvalue(Cardno);
//	AccountBalance="100";
		try
		{
			
		
		new LoginPage(driver, test)
		.getStartApp(Devicename, versionName, udid, portnumber)
		.LoginApp(username, password)
.clickToggleLink()

.clickTransferLink()

.clickotherAccMenu()

.clickTransNextbutton()
.clickonetimepayOther()

//.selectBeneficiary(selectBeneAccno)
//.otherBeneNextbutton()
//.selectBeneNextbutton()
.clickBEFTN()
.fillTransferForm("OtherfromAccOnepay",fromAcc)
.getAccountBalance()
.singleScroll()

.fillTransferForm("othertoaccOnepay",selectBeneAccno)
.fillTransferForm("othertoaccName",accname)
.singleScroll()
.fillTransferForm("Otherbanknameonepay",bankname)
.fillTransferForm("Otherbranchonepay",branchname)
//.fillTransferForm("otherBankName",bankname)
//.fillTransferForm("otherBranchName",branchname)


.fillTransferForm("enteramount",amount)
.fillTransferForm("purpose",purpose)
//.doubleScroll()
.singleScroll()
.singleScroll()
.fillTransferForm("confirmbutton",null)
//.clickTransferbutton()
.singleScroll()
.clickSendMoneybutton()

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
package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC32 extends ProjectWrappers {
	
	@BeforeClass
	public void setData() {
		testCaseName="TC32";
		testDescription="Beneficiary Payment Transfer Within Brac Bank(With Card)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC32";
				}
	
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String selectCardno,String fromAcc,String amount,String purpose,String toaccHistory,String transtype,String Benetype,
			String channelid,String otp,String data6,String data7,String data8) throws Exception{
		//String Cardnumber=regvalue(Cardno);
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()

	.clickTransferLink()
	.clickWithinBankMenu()
	.clickWithinBankTransNextbutton()
	//.clickWithinBankBenfTypebutton()
	.selectBeneficiaryCard(selectCardno)
	.clickWithinBankTransferNextbutton()
	.fillTransferForm("WithinBankFromAcc",fromAcc)
	.getAccountBalance()
	.fillTransferForm("enteramount",amount)
	.fillTransferForm("purpose",purpose)
//	.clickAuthSmsbutton()
	.singleScroll()
	.singleScroll()
	.clickPaynowbutton()
	.singleScroll()
	.clickConfirmbutton()
	.clickSendMoneybutton()
	.EnterOtp(otp)
	.ClickVerifybutton()
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

package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC30 extends ProjectWrappers {
	
	
	@BeforeClass()
	public void setData() {
		testCaseName="TC30";
		testDescription="Transfer Between My Account(With Card)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC30";
				}
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String selectCardno,String fromAcc,String Paymenttype,String amount,String Remarks,
			String toaccHistory,String transtype,String Benetype,
			String channelid,String otp,String data6,String data7) throws Exception{
		//String Cardnumber=regvalue(Cardno);
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			
			//.getStartApp("Xiaomi Redmi Note 8","9.0", udid, portnumber)

			.LoginApp(username, password)
	.clickToggleLink()
	
	
	
	.clickTransferLink()
	.clickownCardMenu()
	.clickTransNextbutton()
	.selectBeneficiaryCard(selectCardno)
	.ClickOwncardNextbutton()
	.fillTransferForm("OwncardFromAcc",fromAcc)
	.getAccountBalance()
	.fillTransferForm("Paymentype",Paymenttype)
	.fillTransferForm("enteramount",amount)
	.fillTransferForm("Remarks",Remarks)
	.singleScroll()
	.doubleScroll()
//	.fillTransferForm("confirmbutton",null)
	.clickOwncardTransferbutton()
	.clickOwncardVerifyTransferbutton()
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

 
package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC114 extends ProjectWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="TC114";
		testDescription="MetLife(Beneficiary Payment)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC114";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String Billername,String insuranceno,String fromAcc,String amount,String Purpose,String transtype,String Benetype,
			String channelid,String toaccHistory,String otp,String data6,String data7) throws Exception{
		
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	
	.clickBillandFeesLink()
	. clickInsurancebiller()
	.clickbillerNextbutton()
	.clickbillersubModule(Billername)
	.clickbillerNextbutton()
	.clickToBiller()
	.selectBiller(insuranceno)
	.fillbillerForm("Nextbutton", null)
	.fillbillerForm("fromAccount", fromAcc)
	.getAccountBalance()
	.fillbillerForm("enteramount", amount)
	.fillbillerForm("Purpose", Purpose)
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


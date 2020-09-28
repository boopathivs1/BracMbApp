package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC33 extends ProjectWrappers {
	
	
	@BeforeClass
	
	public void setData() {
		testCaseName="TC33";
		testDescription="One_off Payment Transfer Within Brac Bank(With Account)";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC33";
				}
	
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username
			,String password,String fromAcc,String toaccno,String amount,String purpose,String toaccHistory,String transtype,String Benetype,
			String channelid,String otp,String data6,String data7,String data8) throws Exception{
		
		try
		{
			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	.clickTransferLink()
	.clickWithinBankMenu()
	.clickWithinBankTransNextbutton()
	.clickWithinBankOnetimeTypebutton()
	.fillTransferForm("BankFromAcc",fromAcc)
	.getAccountBalance()
	.clickBenefAccountTypebutton()
	.fillTransferForm("enteraccountno",toaccno)
	.fillTransferForm("enteramount",amount)
	.fillTransferForm("OTPpurpose",purpose)
	.singleScroll()
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

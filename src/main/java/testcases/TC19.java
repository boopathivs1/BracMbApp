package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC19 extends ProjectWrappers {
	
	
	@BeforeClass()
	public void setData() {
		testCaseName="TC23,24,25";
		testDescription="Beneficiary Maintainance Add, Edit and delete Other Brac bank ";
		browserName="chrome";
		dataSheetName="BracTestData";
		category="Smoke";
		authors="Sreejith";
		testKeyword="TC19";
				}
	@Test(groups={"Smoke"},dataProvider="fetchData")
	public void login(String TestcaseName,String Devicename,String versionName,String udid,String portnumber,String username,String password,String accno,String BankName,String Bankbranch,String entermail,String otp,String shortname,String data2,String data3,String data4,String data5,String data6,String data67) throws Exception{
		String accountnumber=regvalue(accno);
		try
		{

			new LoginPage(driver, test)
			.getStartApp(Devicename, versionName, udid, portnumber)
			.LoginApp(username, password)
	.clickToggleLink()
	.clickManageBeneficiaryLink()
	.clickOtherbankLink()
	.clickNextLink()
	.deletebeneficiary(accountnumber)
	.clickOtherBankAddBeneficiaryButton()
	.clickBeneTypeButton()
	.clickTransferChannelButton()
	.SelectBeneficiaryBankdropdown(BankName)
	.SelectBeneficiaryBranchdropdown(Bankbranch)
	.EnterAccountnum(accountnumber)
	.EnterShortName(shortname)
	.EnterEmail(entermail)
	.clickSmsNextButton()
	.clickconfirm()
	.EnterOtp(otp)
	.submitAddBeneOtpconfirm();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
		}
}

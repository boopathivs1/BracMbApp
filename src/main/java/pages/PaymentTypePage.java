package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import wrappers.ProjectWrappers;

public class PaymentTypePage extends ProjectWrappers {

	
	public PaymentTypePage(AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
	}
	
	public PaymentTypePage clickWithinbankLink(){
		
		clickByXpathExplict(prop.getProperty("click.withinBank.link.xpath"));

		
		return this;
	}	
	
	public PaymentTypePage clickNextLink(){
		
		clickByXpathExplict(prop.getProperty("click.next.value.button.xpath"));

		
		return this;
	}		
	
	public PaymentTypePage fillAccountnum(String accnumber) throws InterruptedException{
		String regAccnum=regvalue(accnumber);
		enterByXpathExplict(prop.getProperty("enter.accnumber.xpath"),regAccnum);
	Thread.sleep(6000);

		
			return this;
		}
	public PaymentTypePage fillnickname(String nickname) throws InterruptedException{
		enterByXpath(prop.getProperty("enter.nickname.xpath"),nickname);
			return this;
		}public PaymentTypePage entermail(String entermail) throws InterruptedException{
			enterByXpathExplict(prop.getProperty("enter.email.withinbank.xpath"),entermail);
			return this;
			}
	
		public PaymentTypePage clickSmsNextButton() throws InterruptedException{
	
		clickByXpathExplict(prop.getProperty("click.within.sms.xpath"));
		clickByXpathExplict(prop.getProperty("click.within.nextbutton.xpath"));
	
		return this;
		}

		public PaymentTypePage clickconfirm(){


			clickByXpathExplict(prop.getProperty("click.addbene.confirm.button.xpath"));
			
				
				return this;
			}

		public PaymentTypePage EnterOtp(String otp){
String otpnumber=regvalue(otp);
enterValue(prop.getProperty("enter.otp.xpath"),otpnumber);
			
			
				return this;
			}
		public PaymentTypePage submitAddBeneOtpconfirm(){
			
						clickByXpathExplict(prop.getProperty("otp.submit.xpath"));
					
							return this;
						}
		
		public PaymentTypePage clickViewBeneButton(){

		clickByXpathExplict(prop.getProperty("click.addedBene.view.xpath"));
		return this;
	}

		
		public PaymentTypePage submitEditOtp(){
			
			clickByXpathExplict(prop.getProperty("click.Edit.otp.Verify.button.xpath"));
		
				return this;
			}
	
		public PaymentTypePage verifyBeneficiaryAdded(String accnumber){

			String  regaccnum=regvalue(accnumber);
//Boolean a=VerifyElementpresentreturn(prop.getProperty("verify.success.Beneficiarty.message.xpath"));

VerifyElementPresent(".//p[text()="+accnumber+"]","Beneficiary has added sucessfully","Beneficiary has not added successfully");
	
	
	
	
	
	return this;
	}

		
	



public PaymentTypePage clickAddBeneficiaryButton(){


	clickByXpathExplict(prop.getProperty("click.addbene.button.xpath"));
	
		
		return this;
	}
	
public PaymentTypePage clickCardTypeButton(){


	clickByXpathExplict(prop.getProperty("click.Cardtype.Card.xpath"));
	
		
		return this;
	}




public PaymentTypePage clickAddbeneNum(String accno) throws InterruptedException{
clickByXpathExplict(".//p[text()="+accno+"]");

return this;
}

public PaymentTypePage clickAddCardbeneNum(String Cardno) throws InterruptedException{
clickByXpathExplict(".//p[text()="+Cardno+"]");

return this;
}


public PaymentTypePage editbeneform(String shortname) throws InterruptedException{
clickByXpathExplict(prop.getProperty("click.edit.bene.button.xpath"));
enterByXpathExplict(prop.getProperty("enter.shortname.bene.xpath"),shortname);
clickByXpathExplict(prop.getProperty("click.within.edit.save.xpath"));
clickByXpathExplict(prop.getProperty("Click.Edit.Confirm.button.xpath"));


return this;
}

public PaymentTypePage clickOK() throws InterruptedException{

	clickByXpathExplict(prop.getProperty("click.ok.submit.xpath"));


return this;
}

public PaymentTypePage clickback() throws InterruptedException{

	clickByXpathExplict(prop.getProperty("click.Managebene.Back.button.xpath"));


return this;
}

public PaymentTypePage accnunmberverify(String accno) throws InterruptedException{

verifyTextByXpath(".//p[text()="+accno+"]",accno);
return this;



}


public PaymentTypePage Cardnunmberverify(String Cardno) throws InterruptedException{

verifyTextByXpath(".//p[text()="+Cardno+"]",Cardno);
return this;



}


	public PaymentTypePage deletebeneficiary(String accno) throws InterruptedException{
	//	locateFrame("icanvas");
	//	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);

//		Boolean a=VerifyElementpresentreturn(".//p[text()='1501200018601002']");

		Boolean a=driver.getPageSource().contains(accno);

		
		if(a){
		


		clickByXpathExplict(".//p[text()="+accno+"]");
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.delete.bene.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.delete.confirm.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.viewbene.button.xpath"));
	
	}
	else{
		booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
		
	}
	return this;
	}

	public PaymentTypePage deleteCardbeneficiary(String Cardno) throws InterruptedException{
		//	locateFrame("icanvas");
		//	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);

//			Boolean a=VerifyElementpresentreturn(".//p[text()='1501200018601002']");
		System.out.println(Cardno);

			WebElement ele = driver.findElement(By.xpath(".//p[.='"+Cardno+"']"));

			
			if(ele.isDisplayed()){
			
			clickByXpathExplict(".//p[.='"+Cardno+"']");
			Thread.sleep(4000);
			clickByXpathExplict(prop.getProperty("click.delete.bene.button.xpath"));
			clickByXpathExplict(prop.getProperty("click.delete.confirm.button.xpath"));
			clickByXpathExplict(prop.getProperty("click.viewbene.button.xpath"));
		
		}
		else{
			System.out.println("Beneficiary has not Present for deletion"+ele);
			
		}
		return this;
		}
	
	public PaymentTypePage fillCardnum(String Cardnumber) throws InterruptedException{
		String regAccnum=regvalue(Cardnumber);
		enterByXpathExplict(prop.getProperty("enter.accnumber.xpath"),regAccnum);
	Thread.sleep(6000);

		
			return this;
		}
	
public PaymentTypePage clickOtherbankLink(){
		
		clickByXpathExplict(prop.getProperty("click.OtherBank.link.xpath"));

		
		return this;
	}	
	
	
public PaymentTypePage clickBeneTypeButton(){


	clickByXpathExplict(prop.getProperty("click.bene.type.xpath"));

	
		
		return this;
	}

public PaymentTypePage deleteOtherBankbeneficiary(String accno) throws InterruptedException{
	//	locateFrame("icanvas");
	//	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);

//		Boolean a=VerifyElementpresentreturn(".//p[text()='1501200018601002']");

		Boolean a=driver.getPageSource().contains(accno);

		
		if(a){
		


		clickByXpathExplict(".//p[text()="+accno+"]");
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.delete.bene.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.delete.confirm.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.viewbene.button.xpath"));
	
	}
	else{
		booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
		
	}
	return this;
	}

public PaymentTypePage clickOtherBankAddBeneficiaryButton(){


	clickByXpathExplict(prop.getProperty("click.Otherbank.Addbene.button.xpath"));
	
		
		return this;
	}

public PaymentTypePage clickTransferChannelButton(){


	clickByXpathExplict(prop.getProperty("click.otherbank.TransferChannel.xpath"));
	
		
		return this;
	}

public PaymentTypePage SelectBeneficiaryBankdropdown(String BankName) throws InterruptedException{

//String str= "EXIM";
clickByXpathExplict(prop.getProperty("Click.Beneficiarybank.dropdown.xpath"));
ContextHandlingNative();
System.out.println(BankName);

//WebElement ele = driver.findElement(By.xpath("//*[.='"+BankName+"']"));
WebElement ele =  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+BankName+"\").instance(0))");
//Thread.sleep(4000);
//Thread.sleep(4000);
//	selectVisibileTextByXPath(prop.getProperty("Click.Beneficiarybank.dropdown.xpath"),BankName);
	
	System.out.println(ele.isDisplayed()+"value is displaying");
	ele.click();
	
	
		return this;
	}

public PaymentTypePage SelectBeneficiaryBranchdropdown(String Bankbranch) throws InterruptedException{

Thread.sleep(30000);
//String str= "EXIM";
ContextHandlingWeb();
clickByXpathExplict(prop.getProperty("Click.Beneficiarybranch.dropdown.xpath"));
Thread.sleep(3000);
ContextHandlingNative();

WebElement ele =  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+Bankbranch+"\").instance(0))");
Thread.sleep(4000);
Thread.sleep(4000);
//	selectVisibileTextByXPath(prop.getProperty("Click.Beneficiarybank.dropdown.xpath"),BankName);
	
	System.out.println(ele.isDisplayed()+"value is displaying");
	ele.click();




//System.out.println(Bankbranch);

//scrolltoElement();

//WebElement ele = driver.findElement(By.xpath("//*[.='"+BankName+"']"));


	
		return this;
	}

public PaymentTypePage EnterAccountnum(String accno) throws InterruptedException{
	String regAccnum=regvalue(accno);
	ContextHandlingWeb();
	enterByXpathExplict(prop.getProperty("Enter.Otherbank.Accountnumber.xpath"),regAccnum);
Thread.sleep(6000);

	
		return this;
	}

public PaymentTypePage EnterAccountName(String accname) throws InterruptedException{

	enterByXpathExplict(prop.getProperty("Enter.Otherbank.Accountname.xpath"),accname);
Thread.sleep(6000);
		return this;
	}

public PaymentTypePage EnterShortName(String shortname) throws InterruptedException{

	enterByXpathExplict(prop.getProperty("Enter.Otherbank.Shortname.xpath"),shortname);
Thread.sleep(6000);
		return this;
	}

public PaymentTypePage EnterEmail(String entermail) throws InterruptedException{

	enterByXpathExplict(prop.getProperty("Enter.Otherbank.Email.xpath"),entermail);
Thread.sleep(6000);
		return this;
	}

}

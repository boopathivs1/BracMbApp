package pages;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import wrappers.ProjectWrappers;

public class TransfersPage  extends ProjectWrappers {

	
	public TransfersPage (AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
	}

	
	
	
	

	
	public TransfersPage clickownAccMenu(){
		
	clickByXpathExplict(prop.getProperty("click.ownacc.menu.xpath"));
	
	return this;
}	
	
	
	
	public TransfersPage clickotherAccMenu(){
		
		clickByXpathExplict(prop.getProperty("click.brac.otherbank.menu.xpath"));
		
		return this;
	}	
	
	
	
	public TransfersPage clickTransNextbutton(){
		
	clickByXpathExplict(prop.getProperty("click.trans.next.button.xpath"));
	
	return this;
}	
	
	
	public TransfersPage clickonetimepayOther() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.onetimepay.other.tab.xpath"));
		Thread.sleep(3000);
		return this;
	}	
	
	
	
	public TransfersPage selectBeneficiary(String accno){
		String accnumber=regvalue(accno);
		clickByXpathExplict(".//p[text()="+accnumber+"]");
					
		return this;
	}	
	
	
	public TransfersPage selectBeneNextbutton(){
		
	clickByXpathExplict(prop.getProperty("select.beneficiary.next.button.xpath"));
	
	return this;
}
	
	public TransfersPage otherBeneNextbutton(){
		
	clickByXpathExplict(prop.getProperty("click.otherbank.next.btn.xpath"));
	
	return this;
}	
	
	
	
	
			public TransfersPage clickNPSB(){
		
		clickByXpathExplict(prop.getProperty("click.npsb.other.xpath"));
		
		return this;
	}	
	
	public TransfersPage clickBEFTN(){
		
	clickByXpathExplict(prop.getProperty("click.beftn.other.xpath"));
	
	return this;
}	
	
	
	
	
	public TransfersPage fillTransferForm(String fieldname,String value){
			
	switch(fieldname){  
    //Case statements  
    case  "fromAcc":
    	String fromaccount=regvalue(value);
    	
    	
    	selectVisibileTextByXPath(prop.getProperty("click.fromaccdrop.trans.xpath"),fromaccount);
break;
    case  "OwncardFromAcc":
    	String fromacc=regvalue(value);
    	
    	selectVisibileTextByXPath(prop.getProperty("click.fromaccdrop.Owncard.xpath"),fromacc);
break;


    case  "OtherbankCardLabel":
clickByXpathExplict(prop.getProperty("click.onetime.pay.card.xpath"));


break;
    case  "OtherfromAcc":
    	String otherfromacc=regvalue(value);
    	
    	
    	selectVisibileTextByXPath(prop.getProperty("other.from.acc.npsb.xpath"),otherfromacc);
break;



    case  "OtherfromAccOnepay":
    	String otherfromacconepay=regvalue(value);
    	
    	
    	selectVisibileTextByXPath(prop.getProperty("select.otherbank.onepay.fromacc.xpath"),otherfromacconepay);
break;
    case  "Otherbanknameonepay":
    	
    	
    	selectVisibileTextByXPath(prop.getProperty("select.onetime.otherbank.xpath"),value);
break;

case  "Otherbranchonepay":
    	
    	
    	selectVisibileTextByXPath(prop.getProperty("other.branch.name.xpath"),value);
break;

case  "BankFromAcc":
	String Bankfromacc=regvalue(value);
	
	selectVisibileTextByXPath(prop.getProperty("select.withinbank.onetimepay.xpath"),Bankfromacc);
break;

case  "WithinBankFromAcc":
	String withinBankfromacc=regvalue(value);
	
	selectVisibileTextByXPath(prop.getProperty("click.fromaccdrop.WithinBank.xpath"),withinBankfromacc);
break;

  case  "Paymentype":
        
        	selectVisibileTextByXPath(prop.getProperty("click.Paymenttype.Owncard.xpath"),value);
    break;

    case  "enteramount":
    	String amount=regvalue(value);
    	
    	enterByXpathExplict(prop.getProperty("enter.ownacc.payamt.xpath"),amount);
break;
    case  "othertoaccOnepay":
    	String toaccOnepay=regvalue(value);
    	
    	enterByXpathExplict(prop.getProperty("other.onepay.toacc.xpath"),toaccOnepay);
break;
    case  "othertoaccName":
    	
    	enterByXpathExplict(prop.getProperty("other.onepay.acc.name.xpath"),value);
break;

    case  "enteraccountno":
    	String accno=regvalue(value);
    	
    	enterByXpathExplict(prop.getProperty("Enter.paytoAccount"),accno);
break;

    case "Remarks":
    	
    	enterByXpathExplict(prop.getProperty("Enter.Remarks.trans.xpath"),value);
break;

    case  "OTPpurpose":
        //	String amount=regvalue(value);
        	selectVisibileTextByXPath(prop.getProperty("select.onetimepay.TransferReason.xpath"),value);
//        	enterByXpathExplict(prop.getProperty("enter.ownacc.payamt.xpath"),value);
    break;

    case  "purpose":
    //	String amount=regvalue(value);
    	selectVisibileTextByXPath(prop.getProperty("ownacc.purpose.trans.xpath"),value);
//    	enterByXpathExplict(prop.getProperty("enter.ownacc.payamt.xpath"),value);
break;
    case  "confirmbutton":
  clickByXpathExplict(prop.getProperty("ownacc.confirmbutton.xpath"));
break;



//click.fromaccdrop.trans.xpath=.//select[@id='OwnAcc_FromAccNum']
//1508101009971001
//enter.ownacc.payamt.xpath=.//input[@id='paymentAmount']
//ownacc.purpose.trans.xpath=.//select[@id='purposetransfer']
//Monthly Swap
//
//ownacc.confirmbutton.xpath=.//button[contains(@id,'confirm')]
//ownacc.transfer.button.xpath=.//button[@id='OwnAcc_TransferBtn']






    //Default case statement  
    default:System.out.println("method has not matched");  
    }  
	
	
	
	
			return this;
}
    
	

	public TransfersPage singleScroll() throws InterruptedException{
		
		bottomverticalSwipeByPercentages();
		Thread.sleep(3000);
		System.out.println("Scrolled successfully");		  
		return this;
	}
	
	
	public WalletPaymentPage single_Scroll() throws InterruptedException{
		
		bottomverticalSwipeByPercentages();
		Thread.sleep(3000);
		System.out.println("Scrolled successfully");		  
		return new WalletPaymentPage(driver, test);
	}	
	
	
	
	
	public TransfersPage doubleScroll() throws InterruptedException{
		bottomverticalSwipeByPercentages();
		System.out.println("next scroll");
		Thread.sleep(1000);
		bottomverticalSwipeByPercentages();
		System.out.println("Scrolled successfully");		  
		return this;
	}
	
	public TransfersPage getAccountBalance(){


Boolean a=VerifyElementpresentreturn(prop.getProperty("get.currentacc.balance.xpath"));
if(a){
	
	AccountBalance=getTextByXpath(prop.getProperty("get.currentacc.balance.xpath"));
	System.out.println(AccountBalance);

	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying ");

}
return this;
	}
	
//	public TransfersPage OtherBankgetAccountBalance(){
//
//
//Boolean a=VerifyElementpresentreturn(prop.getProperty("get.OtherBankcurrentacc.balance.xpath"));
//if(a){
//	
//	AccountBalance=getTextByXpath(prop.getProperty("get.OtherBankcurrentacc.balance.xpath"));
//	System.out.println(AccountBalance);
//
//	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
//}
//else{
//booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");
//
//}
//return this;
//	}
	public TransfersPage clickSendMoneybutton(){

		
	clickByXpathExplict(prop.getProperty("click.Within.sendmoney.button"));

return this;	
	
	}
	
	
	
	
	public TransfersPage clickTransferbutton(){

	
	clickByXpathExplict(prop.getProperty("ownacc.transfer.button.xpath"));

return this;	
	
	}
	public TransfersPage EnterOtp(String otp){
String otpnumber=regvalue(otp);
enterValue(prop.getProperty("enter.otp.xpath"),otpnumber);
			
			
				return this;
			}
		public TransfersPage submitAddBeneOtpconfirm(){
			
						clickByXpathExplict(prop.getProperty("otp.submit.xpath"));
					
							return this;
						}
		
	
	public DashboardPage clickmenu(){

		
	clickByXpathExplict(prop.getProperty("click.togglemenu.dashboard.xpath"));

return new DashboardPage(driver, test);	
	
	}
	public TransfersPage clickownCardMenu(){
		
		clickByXpathExplict(prop.getProperty("click.ownCard.menu.xpath"));
		
		return this;
	}	
	
	public TransfersPage selectBeneficiaryCard(String cardno){
		String Cardnumber=regvalue(cardno);
		clickByXpathExplict(".//p[text()='"+Cardnumber+"']");
					
		return this;
	}	
	public TransfersPage ClickOwncardNextbutton(){
		
		clickByXpathExplict(prop.getProperty("click.Owncard.next.button.xpath"));
		
		return this;
	}
	
	public TransfersPage clickOwncardTransferbutton(){

		 scrolldown();
		clickByXpathExplict(prop.getProperty("click.Owncard.transfer.button.xpath"));

	return this;	
		
		}
	public TransfersPage clickOwncardVerifyTransferbutton(){

		 scrolldown();
		clickByXpathExplict(prop.getProperty("click.Owncard.Verifytransfer.button.xpath"));
	
		System.out.println("ooooooooooooooooooooo");
	return this;
	
	
		
		}
	
public TransfersPage clickWithinBankMenu(){
		
		clickByXpathExplict(prop.getProperty("click.Withinbank.menu.xpath"));
		
		return this;
	}	

public TransfersPage clickWithinBankTransNextbutton(){
	
	clickByXpathExplict(prop.getProperty("click.Withinbank.Next.xpath"));
	
	return this;
}
	
public TransfersPage clickWithinBankBenfTypebutton(){
	
	clickByXpathExplict(prop.getProperty("click.Withinbank.Beneftype.xpath"));
	
	return this;
}
public TransfersPage clickWithinBankTransferNextbutton(){
	
	clickByXpathExplict(prop.getProperty("click.Withinbank.Transfer.Next.xpath"));
	
	return this;
}

public TransfersPage clickPaynowbutton(){
	
	clickByXpathExplict(prop.getProperty("click.paynow.xpath"));
	
	return this;
}

public TransfersPage clickConfirmbutton(){

	clickByXpathExplict(prop.getProperty("click.confirm.button"));
	
	return this;
}

public TransfersPage clickAuthSmsbutton(){
	
	clickByXpathExplict(prop.getProperty("click.sms.xpath"));
	
	return this;
}

public TransfersPage ClickVerifybutton(){
	
	clickByXpathExplict(prop.getProperty("click.verify.button"));
					
		return this;
	}

public TransfersPage clickWithinBankOnetimeTypebutton(){
	
	clickByXpathExplict(prop.getProperty("click.Onetimepay.xpath"));
	
	return this;
}

public TransfersPage clickBenefAccountTypebutton(){
	
	clickByXpathExplict(prop.getProperty("click.benefAccounttype.xpath"));
	
	return this;
}

public TransfersPage EnterAccountnumber(String accno){
	
		String regAccnum=regvalue(accno);
		ContextHandlingWeb();
		enterByXpathExplict(prop.getProperty("Enter.paytoAccount"),regAccnum);
	

		
			return this;

		}

public TransfersPage clickBenefCardTypebutton(){
	
	clickByXpathExplict(prop.getProperty("click.benefCardtype.xpath"));
	
	return this;
}

public WalletPaymentPage clickMobilewalletLink(){
	
	clickByXpathExplict(prop.getProperty("click.mobilewallet.xpath"));

	
	return new WalletPaymentPage(driver, test);
}	

	
}

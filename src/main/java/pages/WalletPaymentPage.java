package pages;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import wrappers.ProjectWrappers;

public class WalletPaymentPage extends ProjectWrappers {
	
	public WalletPaymentPage(AndroidDriver driver, ExtentTest test)
	{
		this.driver =driver;
		this.test =test;	
	}
	
	
	public WalletPaymentPage clickWalletnextBtn(){
		
		clickByXpathExplict(prop.getProperty("click.wallet.next.button.xpath"));

		
		return this;
	}	
	
public WalletPaymentPage clickWalletToBeneBtn(){
		
		clickByXpathExplict(prop.getProperty("click.wallet.Tobene.xpath"));

		
		return this;
	}	

public WalletPaymentPage selectBeneficiary(String accno){
	String accnumber=regvalue(accno);
	clickByXpathExplict(".//p[text()="+accnumber+"]");
				
	return this;
}

public TransfersPage clickWalletTransferNextbtn(){
	
	clickByXpathExplict(prop.getProperty("click.wallet.transfer.button.xpath"));

	
	return new TransfersPage(driver, test);
}	

public WalletPaymentPage clickWallettonextbtn(){
	
	clickByXpathExplict(prop.getProperty("click.wallet.next.tobene.xpath"));

	
	return this;
}







public WalletPaymentPage clickWalletTransextbtn(){
	
	clickByXpathExplict(prop.getProperty("click.wallet.transfer.button.xpath"));

	
	return this;
}

public WalletPaymentPage fillTransferForm(String fieldname,String value){
	
	switch(fieldname){  
   
    case  "fromAcc":
    	String fromaccount=regvalue(value);
    	
    	selectVisibileTextByXPath(prop.getProperty("select.fromaccdrop.Wallet.xpath"),fromaccount);
break;
    
    case  "enteramount":
    	String amount=regvalue(value);
    	
    	enterByXpathExplict(prop.getProperty("enter.ownacc.payamt.xpath"),amount);
break;
   
    case  "enteraccountno":
    	String accno=regvalue(value);
    	
    	enterByXpathExplict(prop.getProperty("Enter.paytoAccount"),accno);
break;

    case  "enteraccountname":
    	
    	enterByXpathExplict(prop.getProperty("Enter.accountname.xpath"),value);
break;
    case  "purpose":
   
    	selectVisibileTextByXPath(prop.getProperty("ownacc.purpose.trans.xpath"),value);

break;
    case  "confirmbutton":
  clickByXpathExplict(prop.getProperty("ownacc.confirmbutton.xpath"));
break;

    //Default case statement  
    default:System.out.println("method has not matched");  
    }  
	
			return this;
}
    
public WalletPaymentPage clickWalletsubModule(String Walletname) throws InterruptedException{
	
	
		clickByXpathExplict(".//span[text()='"+Walletname+"']");
					
		return this;
	}

public WalletPaymentPage clickPaynowbutton(){
	
	clickByXpathExplict(prop.getProperty("click.paynow.xpath"));
	
	return this;
}

public WalletPaymentPage singleScroll() throws InterruptedException{
	
	bottomverticalSwipeByPercentages();
	Thread.sleep(3000);
	System.out.println("Scrolled successfully");		  
	return this;
}

public WalletPaymentPage clickAuthSmsbutton(){
	
	clickByXpathExplict(prop.getProperty("click.sms.xpath"));
	
	return this;
}
public WalletPaymentPage clickWalletOnetimepayBtn(){
	
	clickByXpathExplict(prop.getProperty("click.wallet.Onetimepay.xpath"));

	
	return this;
}	


public WalletPaymentPage getAccountBalance(){


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


}

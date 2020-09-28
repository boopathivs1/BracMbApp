package pages;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import wrappers.ProjectWrappers;

public class BillPaymentPage extends ProjectWrappers{
	
	public BillPaymentPage (AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
}
	
	public BillPaymentPage clickMobilebiller() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.mobilebiller.xpath"));

		return this;
	}
		
	public BillPaymentPage clickbillerNextbutton() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.biller.next.button.xpath"));

		return this;
	}
	
	public BillPaymentPage clickbillersubModule(String Billername) throws InterruptedException{
		
		//	String name=regvalue(Billername);
			clickByXpathExplict(".//span[text()='"+Billername+"']");
						
			return this;
		}	
	
	public BillPaymentPage clickToBiller() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.ToBiller.xpath"));

		return this;
	}
	
	

	
	public BillPaymentPage selectBiller(String Mobno){
		String Mobnumber=regvalue(Mobno);
		clickByXpathExplict(".//span[text()='"+Mobnumber+"']");
					
		return this;
	}	
	
	public BillPaymentPage clickInsurancebiller() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.insurancebiller.xpath"));

		return this;
	}

	

	public BillPaymentPage clicktuitionfees() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.tuitionfee.xpath"));

		return this;
	}
	
	
	public BillPaymentPage clickInternetbiller() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.internet.biller.xpath"));

		return this;
	}	
	
	
	
	public BillPaymentPage clickMetlifebiller() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.metlife.xpath"));

		return this;
	}
	
	public BillPaymentPage getamt() throws InterruptedException{
	//	Thread.sleep(3000);
		BillDueAmount=getTextByXpath(prop.getProperty("insurance.getamt.xpath"));
		return this;

	}		
	public BillPaymentPage getAccountBalance(){


Boolean a=VerifyElementpresentreturn(prop.getProperty("get.currentacc.balance.xpath"));
if(a){
	
	AccountBalance=getTextByXpath(prop.getProperty("get.currentacc.balance.xpath"));
	System.out.println(AccountBalance);

	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");

}
return this;
	}
	public BillPaymentPage EnterOtp(String otp){
		String otpnumber=regvalue(otp);
		enterValue(prop.getProperty("enter.otp.xpath"),otpnumber);
					
					
						return this;
					}
	public BillPaymentPage submitAddBeneOtpconfirm(){
		
		clickByXpathExplict(prop.getProperty("otp.submit.xpath"));
	
			return this;
		}
	
	public BillPaymentPage fillbillerForm(String fieldname,String value) throws InterruptedException{
		
		switch(fieldname){  
	    //Case statements  
	    case  "fromAccount":
	    	Thread.sleep(1000);
	    	String fromAcc=regvalue(value);
	    	
	    	selectVisibileTextByXPath(prop.getProperty("select.fromaccdrop.biller.xpath"),fromAcc);
	break;
	  
	    case  "OTPfromAccount":
	    	String otpfromAcc=regvalue(value);
	    	
	    	selectVisibileTextByXPath(prop.getProperty("select.onetime.fromacc.xpath"),otpfromAcc);
	break;
	 

	    case  "EnterMobNo":
	    	enterByXpathExplict(prop.getProperty("Enter.mobNo.xpath"),value);


	break;
	    case  "ConnectionType":
	    	String conType=regvalue(value);
	    	selectVisibileTextByXPath(prop.getProperty("select.contype.xpath"),conType);
	break;

	    case  "Nextbutton":
	    	clickByXpathExplict(prop.getProperty("click.next.button"));
	
	break;
	  
	 
	    case  "enteramount":
	    	String amount=regvalue(value);
	    	
	    	enterByXpathExplict(prop.getProperty("enter.biller.amount.xpath"),amount);
	break;
	    case  "Purpose":
	    	selectVisibileTextByXPath(prop.getProperty("select.purpose.xpath"),value);
	break;
	    case  "enterPolicyno":
	    	String Policyno=regvalue(value);
	    	
	    	enterByXpathExplict(prop.getProperty("Enter.policynumber.xpath"),Policyno);
	break;

	    case  "clickPolicyno":
	    
	    clickByXpathExplict(prop.getProperty("Enter.policynumber.xpath"));	
	break;	    
	    case  "confirmbutton":
	  clickByXpathExplict(prop.getProperty("biller.confirmbutton.xpath"));
	break;
    
    case  "onetimFinalconfirmbutton":
  clickByXpathExplict(prop.getProperty("click.onetimepay.final.confirm.xpath"));
break;
	
	
	//insurance.getamt.xpath
	
	    case  "frombillonePay":
	    	String fromacconeBill=regvalue(value);
	    	selectVisibileTextByXPath(prop.getProperty("select.frombill.onetimepay.xpath"),fromacconeBill);
	break;
	    case  "Onetimenext":
	  clickByXpathExplict(prop.getProperty("click.onetime.nxt.xpath"));
	break;
	
	    case  "BracSubcat":
	    	selectVisibileTextByXPath(prop.getProperty("brac.subcat.xpath"),value);
	break;
	    case  "BracBiller":
	    	selectVisibileTextByXPath(prop.getProperty("brac.billername.xpath"),value);
	break;
	
	    case  "EnterUtilityNo":
	    	enterByXpathExplict(prop.getProperty("Enter.utilitynumber.xpath"),value);


	break;
	
	    //Default case statement  
	    default:System.out.println("method has not matched");  
	    }  
		
		
				return this;
	}
	  
	public DashboardPage clickmenu(){

		
		clickByXpathExplict(prop.getProperty("click.togglemenu.dashboard.xpath"));

	return new DashboardPage(driver, test);	
		
		}
	
	public BillPaymentPage clickOnetimeBiller() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.Onetimebiller.xpath"));

		return this;
	}
	
	public BillPaymentPage doubleScroll() throws InterruptedException{
		bottomverticalSwipeByPercentages();
		bottomverticalSwipeByPercentages();
		System.out.println("Scrolled successfully");		  
		return this;
	}
	
public BillPaymentPage singleScroll() throws InterruptedException{
		//scrolldown();
		//scrolldown();
		//Thread.sleep(3000);
		bottomverticalSwipeByPercentages();
		Thread.sleep(1000);
		System.out.println("Scrolled successfully");		  
		return this;
	}

public BillPaymentPage ClickUtilitybiller() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.utility.xpath"));

	return this;
}

public BillPaymentPage clickUtilityBillamount() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.uti;ity.billamout"));

	return this;
}
}


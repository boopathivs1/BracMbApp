package pages;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import wrappers.ProjectWrappers;

public class Accounts extends ProjectWrappers {

	
	public Accounts(AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
	}

public Accounts verifyAccountsPagebalance(String accountno){
	
	String accno=regvalue(accountno);
	clickByXpathExplict(".//p[text()='"+accno+"']");
	
	String finalAccountBalance = null;
	

//Boolean a=VerifyElementpresentreturn("(.//p[text()='"+accno+"']/following::span[@class='num'])[1]");

	try {
		readytimes();
	//	readystate();
		jqueryload();
	} catch (Exception e1) {
		reportStep("jquery wait has supporting", "FAIL");
		
		
	}
	

	
	
	Boolean a=VerifyElementpresentreturn("(.//p[contains(text(),'"+accno+"')]//following::span[@class='num'])[1]");




if(a){
//	finalAccountBalance=getTextByXpath("(.//p[text()='"+accno+"']/following::span[@class='num'])[1]");
	//(.//p[contains(text(),'1501101009971001')]//following::span[@class='num'])[1]
			
			finalAccountBalance=getTextByXpath("(.//p[contains(text(),'"+accno+"')]//following::span[@class='num'])[1]");
	reportStep("Balanec has displaying "+finalAccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balance has not displaying ");

}
//try{
		verifyNottextmatches(AccountBalance,finalAccountBalance,"Balance has been deducted in Account Balance","Balance has not been deducted in Account Balance");
//}
//catch (Exception e) {
	//reportStep("Null pointer Exception","FAIL");
//}
	
	
return this;
}

public Accounts verifyMiniStatementbalance(String amount) throws InterruptedException{
//	bottomverticalSwipeByPercentages();

	//pageScroll400();
	
//pageScroll();
//	String amt=regvalue(amount);	
	//clickByXpathExplict(prop.getProperty("click.tab.mini.xpath"));
//	Thread.sleep(2000);
	
//	Thread.sleep(2000);
	//verifyTextContainsByXpath(prop.getProperty("verify.accbalance.xpath"),amt);
return this;
}	
	


	
	
	
	
	
	
	
}

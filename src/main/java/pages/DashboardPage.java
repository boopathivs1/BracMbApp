package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import wrappers.ProjectWrappers;

public class DashboardPage extends ProjectWrappers {

	
	public DashboardPage(AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
	}
	public DashboardPage clickMoreMenu(){

		
	clickByXpathExplict(prop.getProperty("click.more.toggle.xpath"));

	
return new DashboardPage(driver, test);	
	
	}	
	public TransactionHistoryPage clickMoreMenuNext(){

		
	clickByXpathExplict(prop.getProperty("trans.history.next.button.xpath"));

	
return new TransactionHistoryPage(driver, test);
	
	}	

	
	
	public DashboardPage clickToggleLink() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("clickmenu.toggle.button.xpath"));
	Thread.sleep(5000);
	//	clickBy(prop.getProperty("clickmenu.toggle.button.xpath"));

	
	return this;
}
	public DashboardPage clickProductMenu(){
		

clickByXpathExplict(prop.getProperty("click.product.button.xpath"));
	return this;
}	
	public Accounts clickAccountMenu(){
	

clickByXpathExplict(prop.getProperty("click.account.button.xpath"));
return new Accounts(driver, test);
}	
	
public BillPaymentPage clickBillandFeesLink() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.Billandfeeslink.xpath"));
	
	//	clickBy(prop.getProperty("clickmenu.toggle.button.xpath"));

	
	return new BillPaymentPage(driver, test);
}
	

	
	
	public PaymentTypePage clickManageBeneficiaryLink(){
		
	clickByXpathExplict(prop.getProperty("click.manage.beneficiary.xpath"));

	
	return new PaymentTypePage(driver, test);
}	
	
	
	public TransfersPage clickTransferLink(){
		
	clickByXpathExplict(prop.getProperty("click.menu.transfer.button.xpath"));

	
	return new TransfersPage(driver, test);
}	
	
	
	
	
	
	
	
	
	public DashboardPage clickDashbordMenuLink(){
		
		
		clickByXpathExplict(prop.getProperty("Click.Dashboard.Burgan.menu.xpath"));

		return this;
	}
	
/*
	public HomePage logoutApp() throws InterruptedException{	
	clickByXpathExplict(prop.getProperty("Click.Logout.xpath"));
	Thread.sleep(2000);
			ContextHandlingNative();
			Thread.sleep(2000);		
		clickbyIDExplicit(prop.getProperty("Click.Native.logout.xpath"));
		return new HomePage(driver, test);
}*/
	
	public DashboardPage clickHamburger(){
		clickByXpathExplict(prop.getProperty("Click.HamburgerMenu.xpath"));
		return this;
	}
	public DashboardPage clickHamburgerMenuLink(){
		clickByXpathExplict(prop.getProperty("Click.HamburgerMenu.xpath"));
		return this;
	}

	
	
	
	
	public DashboardPage clickcreditCardtabMenuLink(){
		clickByXpathExplict(prop.getProperty("click.creditcard.tab.xpath"));
		return this;
	}public DashboardPage clickdeposittabmenuLink(){
		clickByXpathExplict(prop.getProperty("click.termdeposit.tab.xpath"));
		return this;
	}public DashboardPage clickloantabLink(){
		clickByXpathExplict(prop.getProperty("click.loan.tab.xpath"));
		return this;
	}
	
	public DashboardPage clickPrepaidCardTabLink() throws Exception{
		
		swiperigghttoleft((AppiumDriver) driver,0.9,0.01,0.5,2000);
		clickByXpathExplict(prop.getProperty("click.prepaid.tab.xpath"));
		return this;
	}
	public DashboardPage verifyAccSummary(){
		VerifyElementPresent(prop.getProperty("verify.accountsummary.xpath"),"Account summary has displaying","Account summary has not displaying");
		return this;
	}
	
	public DetailsPage clickAccSummary(){
		
		clickByXpathExplict(prop.getProperty("verify.accountsummary.xpath"));
		return new DetailsPage(driver, test);
	}
	
	
	public DashboardPage verifyCreditCardSummary(){

		VerifyElementPresent(prop.getProperty("verify.creditcard.summarytab.xpath"),"Credit Card summary has displaying","Credit card summary has not displaying");

		return this;
	}
	
public DetailsPage clickCreditCardSummary(){
		
		clickByXpathExplict(prop.getProperty("verify.accountsummary.xpath"));
		return new DetailsPage(driver, test);
	}
	
	
	
	
	
	public DashboardPage verifyDepositSummary(){

		VerifyElementPresent(prop.getProperty("verify.deposit.sumamry.xpath"),"Deposit summary has displaying","Deposit summary has not displaying");

		return this;
	}
	
public DetailsPage clickDepositSummary(){
		
		clickByXpathExplict(prop.getProperty("verify.accountsummary.xpath"));
		return new DetailsPage(driver, test);
	}
	
	
	
	public DashboardPage verifyLoanSummary(){
		VerifyElementPresent(prop.getProperty("verify.loan.summary.xpath"),"Loan summary has displaying","Loan summary has not displaying");

		return this;
	}
	
public DetailsPage clickLoanSummary(){
		
		clickByXpathExplict(prop.getProperty("verify.accountsummary.xpath"));
		return new DetailsPage(driver, test);
	}
	
	
	
	
	
	
	
	
	
	
	
}

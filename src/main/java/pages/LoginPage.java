package pages;


import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import wrappers.ProjectWrappers;

public class LoginPage extends ProjectWrappers {

	// This is to confirm you are in Login Page
	public LoginPage(AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
	}
	
	public LoginPage getStartApp(String deviceName, String version, String udid, String PortNumber) {

	launchApp(deviceName, version, udid, PortNumber);
		
		return this;
	}
	
	
	
	public DashboardPage LoginApp(String username,String Password) throws InterruptedException{
		ContextHandlingWeb();
		System.out.println("Switching done");
		enterByXpathExplict(prop.getProperty("enter.username.xpath"), username);
		enterByXpathExplict(prop.getProperty("enter.password.xpath"),Password);
//		Thread.sleep(1000);
		clickByXpathExplict(prop.getProperty("click.login.xpath"));
		
		
//
//Boolean a=VerifyElementpresentreturn(prop.getProperty("Click.No.update.xpath"));
//if(a){
//clickByXpathExplict(prop.getProperty("Click.No.update.xpath"));
//		
//}
//		verifyTextContainsExplicitWait(prop.getProperty("Verify.dashboard.title.xpath"),"Dashboard");
		return new DashboardPage(driver, test);
		}
	
	}

package testcases;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class SwitchappsActivit {

	static AndroidDriver<WebElement>  driver;
	static AndroidDriver<WebElement>  driverd1;

	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		// TODO Auto-generated method stub



		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nokia 6");
		//capabilities.setCapability("browserName", "Android");
		//capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.testleaf.leaforg");
		capabilities.setCapability("udid", "PLEGAR1762202560");

		capabilities.setCapability("appActivity","com.testleaf.leaforg.MainActivity");
	 driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		Thread.sleep(6000);
		Set< String >contextname=driver.getContextHandles();
		for(String context:contextname){
			System.out.println(context);
			if(context.contains("WEBVIEW")){
				
				driver.context(context);
			}

			System.out.println(context);
			System.out.println("return to web view");

		}
		
		Thread.sleep(4000);
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(4000);

		
	//	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("appium");
//driver.findElement(By.linkText("Create an Account")).click();
		/////////////////////////////////////////////////////////
		//	String currentactivity=driver.currentActivity();
		Activity gmail=new Activity("com.google.android.gm","com.google.android.gm.ConversationListActivityGmail");
		
		driver.startActivity(gmail);
		Thread.sleep(6000);

		//driver.findElement(By.xpath("//android.view.View['4']")).click();;

		Thread.sleep(6000);
		//		System.out.println("gmailclicked");
		///////////////////////////////////////////////////////////
		Activity leaforg=new Activity("com.google.android.contacts","com.android.contacts.activities.PeopleActivity");

		driver.startActivity(leaforg);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(6000);
	//	driver.findElement(By.id("com.sulekha.businessapp:id/btn_get_started")).click();

		Thread.sleep(6000);

		///////////////////////////




	












		///////////////////////////////////////////////////////////////
		DesiredCapabilities capabilities1 = new DesiredCapabilities();


		capabilities1.setCapability("deviceName", "Nokia 6");
		capabilities1.setCapability("browserName", "chrome");			

		AndroidDriver<WebElement>  driver2 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities1);

		driver2.get("http://www.goole.com");

		Thread.sleep(6000);
		//////////////////////////////////////////////////////////////
	
	
	
	
		DesiredCapabilities capabilitiesd1 = new DesiredCapabilities();
		capabilitiesd1.setCapability("deviceName", "Nokia 6");
		//capabilities.setCapability("browserName", "Android");
		//capabilities.setCapability("platformName", "Android");
		capabilitiesd1.setCapability("appPackage", "com.testleaf.leaforg");
		capabilitiesd1.setCapability("udid", "PLEGAR1762202560");

		capabilities1.setCapability("appActivity","com.testleaf.leaforg.MainActivity");
	 driverd1 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		Thread.sleep(6000);
		Set< String >contextnames=driverd1.getContextHandles();
		for(String context:contextnames){
			System.out.println(context);
			if(context.contains("WEBVIEW")){
				
				driverd1.context(context);
			}

			System.out.println(context);
			System.out.println("return to web view");

		}
	
	
	
	
	
	
	}
	
	
	
	
	



}
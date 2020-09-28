package testcases;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class swipetobottom {
	
//	static AppiumDriver driver;
static AndroidDriver<WebElement> driver;

static DesiredCapabilities capabilities;
	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		// TODO Auto-generated method stub

	
		capabilities = new DesiredCapabilities();
  		capabilities.setCapability("deviceName", "Redmi");
  	//	capabilities.setCapability("browserName", "Android");
  	//	capabilities.setCapability("platformVersion", "8.1.0");
  		//capabilities.setCapability("platformName", "Noughat");
  		capabilities.setCapability(MobileCapabilityType.FULL_RESET, "False");
  		capabilities.setCapability(MobileCapabilityType.NO_RESET, "True");
  		capabilities.setCapability("appPackage", "com.whatsapp");
  		capabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");

  		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		
		
//			DesiredCapabilities d = new DesiredCapabilities();
//			d.setCapability("deviceName","Nokia 6");
//		//	d.setCapability("appPackage", "com.sulekha.businessapp");
//		//d.setCapability("appActivity", "com.sulekha.businessapp.ui.activities.SplashActivity");
//			d.setCapability("appPackage", "com.google.android.contacts");
//			d.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");

		//	d.setCapability("appActivity","com.android.contacts.ContactsListActivity");

			
			
		//	d.setCapability("deviceName","Galaxy j7 Nxt");
//			d.setCapability("mobile", deviceName);
	//		d.setVersion(7.0);
	//		d.setCapability("nativeWebScreenshot", "true");
		//	 driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),d);
			//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
//	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			//driver.pressKeyCode(AndroidKeyCode.HOME)			

				System.out.println("contacts will click");
			//	driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
				
				System.out.println("contacts has clicked");
			
				Thread.sleep(15000);
				 double startPercentage=0.6;
				  
				  double endPercentage=0.60;
				  double anchorPercentage=0.5;
				  System.out.println("contacts j has clicked");
				verticalSwipeByPercentages(startPercentage, endPercentage,anchorPercentage);
				/*
				
				  Dimension size = driver.manage().window().getSize();
				  System.out.println(size);
				   
				  //Find swipe start and end point from screen's with and height.
				  //Find starty point which is at bottom side of screen.
				  int starty = (int) (size.height * 0.80);
				  //Find endy point which is at top side of screen.
				  int endy = (int) (size.height * 0.20);
				  //Find horizontal point where you wants to swipe. It is in middle of screen width.
				  int startx = size.width / 2;

				  //Swipe from Bottom to Top.
				  Thread.sleep(2000);
				  //Swipe from Top to Bottom.
				
				 
				  
				  */
	}
	
       
       
	   public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
	        Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.width * anchorPercentage);
	        int startPoint = (int) (size.height * startPercentage);
	        int endPoint = (int) (size.height * endPercentage);
	 
	        new TouchAction(driver)
	                .press(point(anchor, startPoint))
	                .waitAction(waitOptions(ofMillis(1000)))
	                .moveTo(point(anchor, endPoint))
	                .release().perform();
	        
	        
	        
	   }
	  
}
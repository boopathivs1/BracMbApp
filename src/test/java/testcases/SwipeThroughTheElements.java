package testcases;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;


public class SwipeThroughTheElements {

static AndroidDriver<WebElement>driver;	
	
	@BeforeTest
	
	public void gf() throws MalformedURLException {
		
		
		/*
		   caps.setCapability("autoGrantPermissions", true)
		    caps.setCapability("automationName", "UiAutomator2")
		
		*/
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability("deviceName","Nokia 6");
	//	d.setCapability("appPackage", "com.sulekha.businessapp");
	//d.setCapability("appActivity", "com.sulekha.businessapp.ui.activities.SplashActivity");
		d.setCapability("appPackage", "com.google.android.contacts");
		d.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");

	//	d.setCapability("appActivity","com.android.contacts.ContactsListActivity");

		
		
	//	d.setCapability("deviceName","Galaxy j7 Nxt");
//		d.setCapability("mobile", deviceName);
//		d.setVersion(7.0);
		d.setCapability("nativeWebScreenshot", "true");
		 driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),d);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	

			@Test
		  public void f() throws Exception {
				System.out.println("a");
		 AndroidElement startelement=    (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@content-desc='Alkaf']");
	  AndroidElement endelement=    (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@content-desc='Amazon Consultancy']");

		   
		 //tapByElement(startelement);
		 //testCal(); 
		
		swipeByElements(endelement,startelement);
				//
			
			}
			public static void testCal()  throws Exception 
		    {
		            String str="Rajesh";
		            //driver.scrollTo(str);
		           
		            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))");
		         Thread.sleep(4000);
		           
		       //  driver.findElementByXPath("//android.widget.TextView[@content-desc='Jero']").click();
				    
//		         driver.findElementByXPath("//android.view.ViewGroup/android.widget.TextView[@content-desc='Jero']").click();
		         
		         //   driver.findElementByAccessibilityId("Jero").click();
		            Thread.sleep(4000);
		              
		   }
		
			public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
		        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
		 
		        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
		 
		        new TouchAction(driver)
		                .press(point(startX,startY))
		                .waitAction(waitOptions(ofMillis(1000)))
		                .moveTo(point(endX, endY))
		                .release().perform();
		    }
	
			 public void tapByElement (AndroidElement androidElement) {
			        new TouchAction(driver)
			                .tap(tapOptions().withElement(element(androidElement)))
			                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
			    }
		
			 
			 
}

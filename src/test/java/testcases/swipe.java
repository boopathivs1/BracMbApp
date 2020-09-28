package testcases;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class swipe {
	  static AndroidDriver<WebElement> driver;

  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  

		
			// TODO Auto-generated method stub

		
				DesiredCapabilities d = new DesiredCapabilities();
		  		d.setCapability("deviceName", "Redmi");
			//	d.setCapability("appPackage", "com.sulekha.businessapp");
			//d.setCapability("appActivity", "com.sulekha.businessapp.ui.activities.SplashActivity");
				d.setCapability("appPackage", "com.google.android.contacts");
				d.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");

			//	d.setCapability("appActivity","com.android.contacts.ContactsListActivity");

				
				d.setCapability("autoGrantPermissions",true);

			//	d.setCapability("deviceName","Galaxy j7 Nxt");
//				d.setCapability("mobile", deviceName);
		//		d.setVersion(7.0);
				d.setCapability("nativeWebScreenshot", "true");
				 driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),d);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
//		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				//driver.pressKeyCode(AndroidKeyCode.HOME)			

					System.out.println("contacts will click");
				//	driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
					
					System.out.println("contacts has clicked");
				
					Thread.sleep(2000);
					 double startPercentage=0.6;
					  
					  double endPercentage=0.40;
					  double anchorPercentage=0.5;
					
					//verticalSwipeByPercentages(startPercentage, endPercentage,anchorPercentage);
					//Thread.sleep(4000);
					  System.out.println("size");
			verticalSwipeByPercentages(startPercentage, endPercentage,anchorPercentage);

				//	  bottomverticalSwipeByPercentages();
					 // driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
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
		  
	       
	       
		   
		   


	  
	  
	  
  
  public static void bottomverticalSwipeByPercentages() {

      Dimension size = driver.manage().window().getSize();
      int x0 = (int) (size.getWidth() * 0.2);
      int y0 = (int) (size.getHeight() * 0.2);
      int x1 = (int) (size.getWidth() * 0.5);
      int y1 = (int) (size.getHeight() * 0.9);
      TouchAction touchAction = new TouchAction(driver);
      touchAction.press(point(x1, y1)).waitAction().moveTo(point(x0, y0)).release().perform();

	   }}
      


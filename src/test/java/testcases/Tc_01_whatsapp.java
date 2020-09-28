package testcases;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class Tc_01_whatsapp {
 	static AndroidDriver<WebElement> driver;
  	static DesiredCapabilities capabilities;
  @Test
  public void f() throws Exception {
	  
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
	  		
	  		Thread.sleep(10000);
	  		System.out.println("contacts will click");
			//	driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
				
				System.out.println("contacts has clicked");
//				 driver.hideKeyboard();
//					driver.pressKey(new KeyEvent(AndroidKey.BACK));

				 
				 
				Thread.sleep(2000);
				 double startPercentage=0.6;
				  
				  double endPercentage=0.40;
				  double anchorPercentage=0.5;
				
				  
	  
				  
				//Thread.sleep(4000);
				  System.out.println("size");
				verticalSwipeByPercentages(startPercentage, endPercentage,anchorPercentage);

			bottomverticalSwipeByPercentages();
				//  driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
				
			
			//below command willl work
			swipeHorizontallefttoright((AppiumDriver) driver,0.9,0.01,0.5,2000);
				Thread.sleep(8000);
				swiperigghttoleft((AppiumDriver) driver,0.9,0.01,0.5,2000);

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//
				
				
//	  		WebElement e = driver.findElement(By.id("com.sulekha.businessapp:id/text_label"));
//	  		System.out.println(e.getText());
//	  		driver.findElement(By.id("com.sulekha.businessapp:id/btn_get_started")).click();
//	  		WebElement ed = driver.findElement(
//	  				By.xpath("//android.widget.LinearLayout[@index='0']//android.widget.TextView[@index='0']"));
//
//	  		System.out.println(ed.getText());
//	  		driver.findElement(By.id("com.sulekha.businessapp:id/ed_mobile_number")).sendKeys("7338895660");
//
//	  		// WebElement
//	  		// d=driver.findElement(By.xpath("//android.view.ViewGroup[@index='0']//android.widget.TextView[@index='0']"));
//	  		// System.out.println(d.getText());
//	  		driver.findElement(By.id("com.sulekha.businessapp:id/but_next")).click();
//
//	  		// driver.findElement(By.id("com.sulekha.businessapp:id/ed_verify_code")).sendKeys("1234");
//
//	  		// driver.findElement(By.id("com.sulekha.businessapp:id/but_verify")).click();
//
//	  		Thread.sleep(10000);
//	  		driver.findElement(By.id("com.sulekha.businessapp:id/tv_dismiss")).click();
//
//	  		WebElement h = driver.findElement(
//	  				By.xpath("//android.widget.LinearLayout[@index='0']//android.widget.TextView[@index='1']"));
//
//	  		System.out.println(h.getText());
//
//	  		// com.sulekha.businessapp:id/toolbar_actionbar
//
//	  		// TODO Auto-generated method stub

	  	}

  
  public static void swiperigghttoleft(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	    Dimension size = driver.manage().window().getSize();
	    int anchor = (int) (size.height * anchorPercentage);
	    int startPoint = (int) (size.width * startPercentage);
	    int endPoint = (int) (size.width * finalPercentage);
	    new TouchAction(driver).press(point(endPoint, anchor)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(startPoint, anchor)).release().perform();
	}
  
  
  
  public static void swipeHorizontallefttoright(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	    Dimension size = driver.manage().window().getSize();
	    int anchor = (int) (size.height * anchorPercentage);
	    int startPoint = (int) (size.width * startPercentage);
	    int endPoint = (int) (size.width * finalPercentage);
	    new TouchAction(driver).press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(endPoint, anchor)).release().perform();
	}
  public static void bottomverticalSwipeByPercentages() {

      Dimension size = driver.manage().window().getSize();
      int x0 = (int) (size.getWidth() * 0.2);
      int y0 = (int) (size.getHeight() * 0.2);
      int x1 = (int) (size.getWidth() * 0.5);
      int y1 = (int) (size.getHeight() * 0.9);
      TouchAction touchAction = new TouchAction(driver);
      touchAction.press(point(x1, y1)).waitAction().moveTo(point(x0, y0)).release().perform();

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


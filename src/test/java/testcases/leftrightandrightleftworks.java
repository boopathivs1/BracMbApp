package testcases;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class leftrightandrightleftworks {
	static AndroidDriver<WebElement>driver;	
	public static void main(String[] args) throws Exception {

	DesiredCapabilities d = new DesiredCapabilities();
	d.setCapability("deviceName","Nokia 6");
//	d.setCapability("appPackage", "com.sulekha.businessapp");
//d.setCapability("appActivity", "com.sulekha.businessapp.ui.activities.SplashActivity");
	d.setCapability("appPackage", "com.google.android.apps.photos");
	d.setCapability("appActivity","com.google.android.apps.photos.home.HomeActivity");

	 d.setCapability(MobileCapabilityType.FULL_RESET, "False");
        d.setCapability(MobileCapabilityType.NO_RESET, "True");
//	com.whatsapp.payments.ui.IndiaUpiPaymentLauncherActivity

//	d.setCapability("appActivity","com.android.contacts.ContactsListActivity");

	
	//d.setCapability("unlockType	","pattern");
	
	d.setCapability("autoGrantPermissions",true);

//	d.setCapability("deviceName","Galaxy j7 Nxt");
//	d.setCapability("mobile", deviceName);
//	d.setVersion(7.0);
	d.setCapability("nativeWebScreenshot", "true");
	 driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		
		Thread.sleep(4000);
	driver.findElement(By.xpath(".//android.view.ViewGroup[@index='9']")).click();
	Thread.sleep(4000);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	Thread.sleep(4000);


	//com.whatsapp/com.whatsapp.HomeActivity}
	swipeHorizontal((AppiumDriver) driver,0.9,0.01,0.5,2000);
	//swiperigghttoleft((AppiumDriver) driver,0.9,0.01,0.5,2000);
}
public static void swipeHorizontal(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
    Dimension size = driver.manage().window().getSize();
    int anchor = (int) (size.height * anchorPercentage);
    int startPoint = (int) (size.width * startPercentage);
    int endPoint = (int) (size.width * finalPercentage);
    new TouchAction(driver).press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(endPoint, anchor)).release().perform();
}


public static void swiperigghttoleft(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
    Dimension size = driver.manage().window().getSize();
    int anchor = (int) (size.height * anchorPercentage);
    int startPoint = (int) (size.width * startPercentage);
    int endPoint = (int) (size.width * finalPercentage);
    new TouchAction(driver).press(point(endPoint, anchor)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(startPoint, anchor)).release().perform();
}
}

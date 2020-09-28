package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Businessapp {
	static AndroidDriver<WebElement> driver;
	static DesiredCapabilities capabilities;
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		 DesiredCapabilities	capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nokia 6");
		//capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "8.1.0");
		//capabilities.setCapability("platformName", "Noughat");
		capabilities.setCapability("udid", "PLEGAR1762202560");
	//	capabilities.setCapability(MobileCapabilityType.FULL_RESET, "False");
	//	capabilities.setCapability(MobileCapabilityType.NO_RESET, "True");
		capabilities.setCapability("appPackage", "com.sulekha.businessapp");
		capabilities.setCapability("appActivity", "com.sulekha.businessapp.base.feature.splashscreen.SplashScreenActivity");

		//driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement e = driver.findElement(By.id("com.sulekha.businessapp:id/text_label"));
		System.out.println(e.getText());
		driver.findElement(By.id("com.sulekha.businessapp:id/btn_get_started")).click();
		WebElement ed = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@index='0']//android.widget.TextView[@index='0']"));

		System.out.println(ed.getText());
		driver.findElement(By.id("com.sulekha.businessapp:id/ed_mobile_number")).sendKeys("7338895660");

		// WebElement
		// d=driver.findElement(By.xpath("//android.view.ViewGroup[@index='0']//android.widget.TextView[@index='0']"));
		// System.out.println(d.getText());
		driver.findElement(By.id("com.sulekha.businessapp:id/but_next")).click();

		// driver.findElement(By.id("com.sulekha.businessapp:id/ed_verify_code")).sendKeys("1234");

		// driver.findElement(By.id("com.sulekha.businessapp:id/but_verify")).click();

		Thread.sleep(10000);
		driver.findElement(By.id("com.sulekha.businessapp:id/tv_dismiss")).click();

		WebElement h = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@index='0']//android.widget.TextView[@index='1']"));

		System.out.println(h.getText());

		// com.sulekha.businessapp:id/toolbar_actionbar

		// TODO Auto-generated method stub

	}

}

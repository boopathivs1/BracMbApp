package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class calc {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nokia 6");

	//	capabilities.setCapability("appPackage", "com.android.dialer");
		//capabilities.setCapability("appActivity","com.android.dialer.DialtactsActivity");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

		
		AndroidDriver<WebElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//WebElement ed = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']//android.widget.Button[@index='0']"));
	//	System.out.println(ed.getText());

		
		List<WebElement>f=driver.findElements(By.xpath("//android.view.ViewGroup[@index='0']//android.widget.Button"));
		
		for (WebElement webElement : f) {
			
		
		System.out.println(webElement.getText());
		}
		System.out.println(f.size());
	}

}

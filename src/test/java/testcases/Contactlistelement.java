package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class Contactlistelement {
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub






		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nokia 6");

	//	capabilities.setCapability("appPackage", "com.android.dialer");
		//capabilities.setCapability("appActivity","com.android.dialer.DialtactsActivity");
		capabilities.setCapability("appPackage", "com.google.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");

		
		AndroidDriver<WebElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Thread.sleep(4000);
		
	//	driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);

		

	//	driver.findElement(By.name("Contacts")).click();
	//	driver.findElement(By.name("Create new contact")).click();


	//	  driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("yryryrh");

		//  driver.hideKeyboard();
		//  driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("1234");


		 driver.hideKeyboard();
		//  driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("sdsds@gmail.com");

//driver.findElementById("com.android.contacts:id/menu_save").click();		
Thread.sleep(6000);
		 
//List <WebElement>a=driver.findElements(By.id("com.google.android.contacts:id/cliv_name_textview"));
//for (WebElement webElement : a) {
//System.out.println(webElement.getText());
//}



//List<WebElement> es=driver.findElements(By.xpath("//android.widget.TextView[@id='com.google.android.contacts:id/cliv_name_textview'][@index='2']"));

/*for (WebElement webElement : es) {
	System.out.println(webElement.getText());
	

		System.out.println(driver.getOrientation());
		ScreenOrientation as=driver.getOrientation();
		System.out.println(as);
*/

List <WebElement>a=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup/android.widget.TextView[@resource-id='com.google.android.contacts:id/cliv_name_textview']"));
for (WebElement webElement : a) {
System.out.println(webElement.getText());
}
		driver.findElementByAccessibilityId("ACT Customer Care").click();
		Thread.sleep(2000);
		List <WebElement>ag=driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.google.android.contacts:id/header']"));
		for (WebElement webE : ag) {
		System.out.println(webE.getText());
		}

		
		
	//if(a.equals("PORTRAIT")){
		//	driver.rotate(ScreenOrientation.LANDSCAPE);
	//	}
		
		
		
		
		
	}}


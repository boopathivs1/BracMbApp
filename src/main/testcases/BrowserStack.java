package testcases;

import org.testng.annotations.Test;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStack {
	
	
	
  @Test
  public void f() {
  
  
	   
	    
	    public static String userName = "vayanaautomation1";
	    public static String accessKey = "WGKy1waWi18dcYnPD8eC";

	    public static void main(String args[]) throws MalformedURLException, InterruptedException {
	      DesiredCapabilities caps = new DesiredCapabilities();

	      caps.setCapability("device", "Xiaomi Redmi Note 8");
	      caps.setCapability("os_version", "9.0");
	      caps.setCapability("project", "My First Project");
	      caps.setCapability("build", "My First Build");
	      caps.setCapability("name", "Bstack-[Java] Sample Test");
	      caps.setCapability("app", "bs://0d022c4db90dd8eb7d3f30d0dc3097c1b940b857");

	      AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	      /* Write your Custom code here */

	      driver.quit();
	    }
	  }
  
  
  }

}

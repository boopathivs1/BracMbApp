package testcases;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.expression.spel.ast.Projection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.ProjectWrappers;

public class BrowserStack  {
	 public static String userName = "vayanaautomation1";
	    public static String accessKey = "WGKy1waWi18dcYnPD8eC";


	@BeforeClass()
	public void setData() {
				}
	
	@Test
	public void login() throws Exception{
		  DesiredCapabilities caps = new DesiredCapabilities();
	   
	    

	      caps.setCapability("device", "Xiaomi Redmi Note 8");
	      caps.setCapability("os_version", "9.0");
	      caps.setCapability("project", "My First Project");
	      caps.setCapability("build", "My First Build");
	      caps.setCapability("browserstack.debug", "true");

	      caps.setCapability("name", "Bstack-[Java] Sample Test");
	      caps.setCapability("app", "bs://0d022c4db90dd8eb7d3f30d0dc3097c1b940b857");


	      AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	  	Set< String >contextname=driver.getContextHandles();
		for(String context:contextname){
			System.out.println(context);
			if(context.contains("WEBVIEW")){
				//"WEBVIEW"
				System.out.println("*********");
				System.out.println(context);
				driver.context(context);
			}
		}
		
		
		driver.findElement(By.xpath(".//input[@id='username']")).sendKeys("uatuser3");
		driver.findElement(By.xpath(".//input[@id='password']")).sendKeys("Brac@2020");
		
driver.findElement(By.xpath(".//a[@id='login']")).click();	
		
	      
	      
	      driver.quit();
	    }
	  }
  



package wrappers;

import io.appium.java_client.AppiumDriver;

import java.util.function.Function;
import java.util.function.Predicate; 
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.dynamic.scaffold.inline.RebaseDynamicTypeBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.relevantcodes.extentreports.ExtentTest;


import utils.Reporter;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;


public class GenericWrappers extends Reporter implements Wrappers {
public static AndroidDriver<WebElement> driver;
	//public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort,mofromX,mofromY,motoX,motoY,mtfromX,mtfromY,mttoX,mttoY,mtokx,mtoky,mthfromX,mthfromY,mthtoX,mthtoY;
public static String PayAmount;
public static String DebitAmount;
public static String referencenumber;
public static String AccountBalance;
public static String BillDueAmount="";
public static String webmode;
	
Dimension size;
	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
			
			//redmi
			mofromX = prop.getProperty("mo-FromX-Axis");
			mofromY=prop.getProperty("mo-FromY-Axis");
			motoX=prop.getProperty("mo-toX-Axis");
			motoY=prop.getProperty("mo-toY-Axis");
			
			
			//vivo
			mtfromX = prop.getProperty("mt-FromX-Axis");
			mtfromY=prop.getProperty("mt-FromY-Axis");
			mttoX=prop.getProperty("mt-toX-Axis");
			mttoY=prop.getProperty("mt-toY-Axis");
			mtokx=prop.getProperty("mt-Ok.X.button");
			mtoky=prop.getProperty("mt-Ok.y.button");
			
			
			
			

			//realme
			mthfromX = prop.getProperty("mth-FromX-Axis");
			mthfromY=prop.getProperty("mth-FromY-Axis");
			mthtoX=prop.getProperty("mth-toX-Axis");
			mthtoY=prop.getProperty("mth-toY-Axis");
			
			
			
			
			
			
			
			
			
						
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GenericWrappers(AndroidDriver  driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	public void booleanResultFail(Boolean a,String b)
	{
		if(!a){
			reportStep(b, "FAIL");
		}
		
	}

	public void clickJs(String xpath){
		try{
			Thread.sleep(2000);
	WebElement element=driver.findElement(By.xpath(xpath));

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", element);

	reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

		}
catch (Exception e) {
	reportStep("The element with xpath: "+xpath+" is clicked.", "FAIL");

}
	}	
	
	
	public void tapElement(AppiumDriver appiumDriver, WebElement element) {
		  // Locate center of element
		  Point location = element.getLocation();
		  Dimension size = element.getSize();
		  //int tapX = location.getX() + (size.getWidth() / 2);
		  //int tapY = location.getY() + (size.getHeight() / 2);
		  
		  int x = location.getX();
	        //System.out.println("Element's Position from left side Is "+xcord +" pixels.");
	        int y = location.getY();
		  
		  
		  
ContextHandlingNative();
		  // Execute tap
//		  String originalContext = appiumDriver.getContext();
	//	  appiumDriver.context("NATIVE_APP");
		  TouchAction action = new TouchAction(appiumDriver);
		  //action.longPress(longPressOptions)
		  action.tap(point(x,y)).perform();
		//  appiumDriver.context(originalContext);
		}
	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//double startPercentage=0.6;
	  
	 // double endPercentage=0.40;
	 // double anchorPercentage=0.5;
	
	//swipeHorizontallefttoright((AppiumDriver) driver,0.9,0.01,0.5,2000);
//	Thread.sleep(8000);
	//swiperigghttoleft((AppiumDriver) driver,0.9,0.01,0.5,2000);

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

	public void unloadObjects() {
		prop = null;
	}


	//public void invokeApp(String browser) {
	//	invokeApp(browser,false);
	//}

	
	/*
	
	public void invokeApp(String browser, boolean bRemote) {
		try {
			
			
			
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "Galaxy j7 Nxt");
			capabilities.setCapability("browserName", "Android");
			capabilities.setCapability("platformVersion","7.0");
			capabilities.setCapability("platformName", "Noughat");
			capabilities.setCapability("appPackage", "com.sulekha.businessapp");
			capabilities.setCapability("appActivity","com.sulekha.businessapp.ui.activities.SplashActivity");
					//"com.sulekha.businessapp.ui.activities.WelcomeScreenActivity");
			 driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
			
			
	
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			reportStep("The browser: launched successfully", "PASS");
			}
		catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	
	*/
	
	
	public void chromeapi() throws MalformedURLException {
		try {
	DesiredCapabilities capabilities1 = new DesiredCapabilities();

	
	capabilities1.setCapability("deviceName", "ZX1G224ZNM");
    capabilities1.setCapability("browserName", "chrome");			
	
	AndroidDriver<WebElement>  driver2 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities1);

  //  driver2.get("http://lsapilistings.sulekha.com/api/v1/user/mobile/9043009007/claim/unmapmobileno");
    reportStep("The chrome  launched successfully", "PASS");
	}
	catch (Exception e) {
		e.printStackTrace();
	reportStep("The chrome could not be launched", "FAIL");
	
	}}
	
	public void pageScroll400() {
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	public void scrolltoelementJs(String xpathtext) throws InterruptedException{
		//	loadingMethod(xpathtext);
	try{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath(xpathtext));

		js.executeScript("arguments[0].scrollIntoView();", Element);

		

	reportStep("Scroll to element: "+xpathtext+" is clicked.", "PASS");
		
		
		
		}
	catch (Exception e) {

		reportStep("Unable to scroll to this element: "+xpathtext+".", "FAIL");

	}
		}	

	
	public void launchApp(String deviceName,String version,String udid,String PortNumber ){
		try {
			String port= PortNumber;   
			port = port.replaceAll("[^a-zA-Z0-9]", " ");  
			String userPort = port .replaceAll("\\s", "");
			
			DesiredCapabilities	capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", deviceName);
			
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion",version);
			capabilities.setCapability("udid",udid);
//			capabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability("appPackage", "com.brmb.mobilebanking");
		capabilities.setCapability("appActivity", "com.brmb.mobilebanking.MainActivity");
		/////	capabilities.setCapability("unicodeKeyboard", true);
		////	capabilities.setCapability("resetKeyboard", true);
			//driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver = new AndroidDriver(new URL("http://0.0.0.0:"+userPort+"/wd/hub"),capabilities);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			
		 reportStep("The Brac Appication has been launched successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
		reportStep("The Brac Appication could not be launched", "FAIL");
		}
	}

	
	
	public void verifyTextContainsRegXpath(String xpath, String text){
		try {
			readywithtime(xpath);
		//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			String a=regvalue(sText);
			System.out.println("****");
			System.out.println(a);
			System.out.println(text);
			System.out.println("***");
			if (a.contains(text)){
				reportStep(" matches the value" , "PASS");
			}else{
				reportStep("does not match the value" , "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

 

	
	
public void ContextHandlingWeb(){
	
	
	try{
	Set< String >contextname=driver.getContextHandles();
	for(String context:contextname){
		System.out.println(context);
		if(context.contains("WEBVIEW")){
			//"WEBVIEW"
			System.out.println("*********");
webmode=context;
			System.out.println(context);
			driver.context(context);
		}
		Thread.sleep(1000);

	}
	reportStep("Switched to WEBVIEW Sucessfully.", "PASS");
	
	}
	catch (Exception e) {
		reportStep("Could not be Switched ", "FAIL");

		// TODO: handle exception
	}
}
	public void verifyExactTextcontainslistReg(String xpath,String Status){
		try {
			readywithtime(xpath);
		//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		
		
		
		
		
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		Thread.sleep(5000);
		//List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

		List <WebElement>  element=getlistelementXpath(xpath);

	//	Thread.sleep(15000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();
		String a=regvalue(cate);
		System.out.println("after reg from trans");
		System.out.println(a);
		System.out.println("end");		
		String str = a;
		String digits="";
		for (int i = 0; i < str.length(); i++) {
		    char chrs = str.charAt(i);
		    if (Character.isDigit(chrs)){
		        digits = digits+chrs;
		}
		    System.out.println("final digits");
		System.out.println(digits);

				}


		String		firsttwonum = digits.substring(0,2);
		System.out.println(firsttwonum);
		a1.add(firsttwonum);
	}
		int b=a1.size();
		System.out.println(b);
		System.out.println("a1 size is "+a1.size());
		Thread.sleep(5000);

		
		
		int k=0;
		for (int i = 0; i <a1.size(); i++) {
			System.out.println("iiiiiiiiiiiiii");
			System.out.println(a1.get(i));
			if(a1.get(i).contains(Status)){
				k=1;
				reportStep(" Transaction has matched in this List", "PASS");
		
				break;
		}
		}	
			if(k==0){
				reportStep(" Transaction has not matched in this List", "FAIL");
				
			}
		}
		
			
		catch (Exception e) {
			reportStep(" Transaction has not matched in this List", "FAIL");
		}
		}




	
	
	public void NativeMode(){	
	
//	try {
//			
//			 readytimes();
//			jqueryload();
//		} catch (InterruptedException e1) {
//		}
		
	
try{	
	driver.context("NATIVE_APP");
System.out.println("switch done");
reportStep("Switched to Native Sucessfully.", "PASS",false);
	}

catch (Exception e) {
reportStep("Could not be Switched Native", "FAIL",false);

// TODO: handle exception
}


}


	public void webMode(){	
		
//		try {
//			
//			 readytimes();
//			jqueryload();
//		} catch (InterruptedException e1) {
//		}
		
	
try{	
	driver.context(webmode);
System.out.println("switch done");
reportStep("Switched to webmode Sucessfully.", "PASS");
	}

catch (Exception e) {
reportStep("Could not be Switched Webmode", "FAIL");

// TODO: handle exception
}


}


	
	
	
	
	
	
	
	
	
public void ContextHandlingNative(){	
	try {
		
		 readytimes();
		//readywithtime(xpathVal);
	//	readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
	Set< String >contextname=driver.getContextHandles();
	for(String context:contextname){
		System.out.println(context);
		if(context.contains("NATIVE_APP")){
			//"WEBVIEW"
	//		System.out.println("*********");

//			System.out.println(context);
			driver.context(context);
	System.out.println("switch done");
		}
		//Thread.sleep(1000);

	}
	reportStep("Switched to Native Sucessfully.", "PASS");
	
	}
	catch (Exception e) {
		reportStep("Could not be Switched ", "FAIL");

		// TODO: handle exception
	}
	
	
	}


public void VerifyElementPresent(String xpath,String validmsg,String ErrorvalidMsg) {
	//waitForElement(xpath,2);
	
	try {
		readywithtime(xpath);
	//	readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	
	WebDriverWait wait;
	
	try {
		Thread.sleep(2000);
		 wait = new WebDriverWait(driver,60);
		//	Thread.sleep(1000);
		 WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		
	
	
	if(e.isDisplayed())
	{
		reportStep( "Element is present: " +validmsg, "PASS");

	}
		
	
	}

	
	catch (Exception e) {
		System.out.println(e);
		reportStep(""+ErrorvalidMsg+"", "FAIL");
	}
	
	
	
}
public void longpressele(String f){
	

	try {
		readytimes();
	//	readystate();
		jqueryload();
	} catch (Exception e1) {
		reportStep("jquery wait has supporting", "FAIL");
		
		
	}
	
	
	
	WebElement a=driver.findElement(By.xpath(f));
try{
TouchAction action = new TouchAction(driver).longPress(longPressOptions().withElement(element(a))
		.withDuration(Duration.ofMillis(10000))).release().perform();

driver.findElement(By.xpath(f));
Thread.sleep(5000);
} catch (Exception e) {
	// TODO: handle exception
}
}



public  static void Waitfor_Seconds()
{
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}


public static boolean waitForElement( int timeLimitInSeconds, MobileElement element){

    Boolean IsElementPresent = false;
    try{

        WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
       
        wait.until(ExpectedConditions.visibilityOf(element));
        IsElementPresent = element.isDisplayed();
        IsElementPresent = true;
    }catch(Exception e) {
        IsElementPresent = false;
        System.out.println(e.getMessage());
    }
    return IsElementPresent;
}

public void clickByXpathExplict(String xpathVal) {
	
	try {
		readywithtime(xpathVal);
	//	readystate();
		jqueryload();
	} catch (Exception e1) {
		reportStep("jquery wait has supporting", "FAIL");
		
		
	}
	
	WebDriverWait wait;
	try{	
Thread.sleep(2000);

wait = new WebDriverWait(driver,30);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
System.out.println(element+"element will click");	

waitForLoad(driver);
element.click();

reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");

	
	
//try {
//
//	jqueryload();
//} catch (Exception e1) {
//	reportStep("jquery wait has supporting", "FAIL");
//	
//	
//}

	
	
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		//System.out.println(e.getMessage());
	}
}







public void clickByXpathNative(String xpathVal) {
	WebDriverWait wait;
	try{	
Thread.sleep(2000);

wait = new WebDriverWait(driver,30);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
System.out.println(element+"element will click");	

//waitForLoad(driver);
element.click();
		reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		//System.out.println(e.getMessage());
	}
}

public void clickByXpathNativeAction(String xpathVal) {
	WebDriverWait wait;
	try{	
Thread.sleep(2000);

wait = new WebDriverWait(driver,30);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
System.out.println(element+"element will click");	

//waitForLoad(driver);
element.click();

reportStep("The element with xpath: "+xpathVal+" is clicked.", "INFO", false);
	} 	
	catch (Exception e) {

		reportStep("The element with xpath: "+xpathVal+" is clicked.", "FAIL", false);

	}
}


public void verifyNottextmatches(String a ,String b,String validmsg,String invalidmsg){
try{	
	if(!a.equalsIgnoreCase(b)) {
		reportStep(a+""+validmsg+""+b, "PASS");
		
	}
		else {
			reportStep(a+""+invalidmsg+" "+b, "FAIL");
		}
}
catch (NullPointerException e) {

	reportStep("Null pointer Exception", "FAIL");

}


}





public void pageScroll() {
	try{
JavascriptExecutor jse = driver;
jse.executeScript("window.scrollBy(0,200)", "");
reportStep("Page has sucessfully scrolled", "PASS");

	}
	catch (Exception e) {
		reportStep("Page has not sucessfully scrolled", "FAIL");
	}
}
public void dropdownSelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(2000);
	clickByXpathExplict(".//label//small[text()='"+xpath2+"']");

}

public String regvalue(String Accno){
	String Accnumber = null;
	try{
String userAccNo= Accno;   
userAccNo = userAccNo.replaceAll("[^a-zA-Z0-9]", " ");  
Accnumber = userAccNo .replaceAll("\\s","");
System.out.println(Accnumber);
	}
	
	catch (Exception e) {
		// TODO: handle exception
	}
	return Accnumber;
}

public void booleanNoElementPresentResult(Boolean a,String b)
{
	if(!a){

		reportStep(b, "INFO");
	}
	
}
public Boolean VerifyElementpresentreturn(String xpath) {
	
	Boolean B=false;
	WebDriverWait wait;
	try{
		Thread.sleep(2000);

		wait = new WebDriverWait(driver,30);
		WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

//	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{

		B=true;
		//System.out.println("*********Element is present"+e.getText()+"*********");
		reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
	}
	
	else {
	//	System.out.println("*********Element is not present"+e.getText()+"*********");
		//reportStep("The element with id: "+xpath+" is not present .", "PASS");
	}
	
	}
catch (Exception e) {
	// TODO: handle exception


}
	return B;
}
public void LogoutbooleanResult(Boolean a,String b)
{
	if(a){
		
//		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}



public void verifyTextContainsExplicitWait(String xpath, String text){
	
	WebDriverWait wait;
	try{
		Thread.sleep(2000);
		
wait = new WebDriverWait(driver,30);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		String sText = element.getText();
		
		
		
		if (sText.contains(text)){
			reportStep("The text: "+sText+" contains the value :"+text, "PASS");
		}else{
			reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}
	}
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
	
	catch (Exception e) {
		reportStep("Unknown exception occured while verify", "FAIL");
	}
}
public void verifytextmatches(String a ,String b){
if(a.equalsIgnoreCase(b)) {
reportStep(a+"Matches with the value "+b, "PASS");

}
else {
	reportStep(a+"does not Matches withe value "+b, "FAIL");
}
}
public void verifytextcontains(String a ,String b){
	if(b.contains(a)) {
		reportStep(a+" Matches with the value "+b, "PASS");
		
	}
		else {
			reportStep(a+"not Matches withe value "+b, "FAIL");
		}
		}


public void hidekeyboard(){
	try{
		driver.hideKeyboard();
		reportStep("keyboard has been hide", "PASS");
		}
	
catch (Exception e) {
	reportStep("keyboard has not been hide", "FAIL");

	
}
}

public void VerifyTextContainsCompare(String a ,String b){
	if(a.contains(b)) {
		reportStep(a+"Matches with the value "+b, "PASS");
		
	}
		else {
			reportStep(a+"not Matches withe value "+b, "FAIL");
		}
		}
public static void verticalSwipetoBottom(double startPercentage, double endPercentage, double anchorPercentage) {
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

public void enterByXpathExplict(String xpathVal, String data) {
	WebDriverWait wait;
	try{
		Thread.sleep(2000);
		 wait = new WebDriverWait(driver,30);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
		element.clear();
		element.sendKeys(data);
		driver.hideKeyboard();
		
		reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
	}
	
	
	catch (Exception e) {
	
		
		//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");
System.out.println(e);
			reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

	}
}
	
public void enterValue(String xpathVal, String data) {
	try {
		readywithtime(xpathVal);
	//	readystate();
		jqueryload();
	} catch (Exception e1) {
		reportStep("jquery wait has supporting", "FAIL");
		
		
	}
	
	WebDriverWait wait;
	try{
		Thread.sleep(2000);
		 wait = new WebDriverWait(driver,30);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
		element.clear();
		element.sendKeys(data);
		
		reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
	}
	
	
	catch (Exception e) {
	
		
		//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");
System.out.println(e);
			reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

	}
}



	public void enterById(String idValue, String data) {
		try {
	
		
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}

	
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+nameValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
		}

	}

	
	
	
	
	public void swipepage() {
		try {

	//	 driver.swipe(246, 462, 266,144,0);
	reportStep("swipe the page pass", "PASS");

} catch (NoSuchElementException e) {
	reportStep("The data: could not be entered in the field :", "FAIL");
} catch (Exception e) {
	reportStep("Unknown exception occured while entering ", "FAIL");
}

}

	
	
	
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			
			
			driver.findElement(By.xpath(xpathValue)).sendKeys(data); 
			driver.hideKeyboard();
			reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
		}

	}

	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				System.out.println();
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	public void verifyTextByXpath(String xpath, String text){
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			System.out.println(sText);
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	
	
	public void verifyTextByname(String xpath,String text){
		try {
			String sText = driver.findElementByName(xpath).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Window mismatch while verify title", "FAIL");
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyTextContainsByXpath(String xpath, String text){
		try {
			readywithtime(xpath);
		//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" matches the value" , "PASS");
			}else{
				reportStep("The text: "+sText+" did not match the value" , "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}


	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			Thread.sleep(10000);
			if (sText.contains(text)){
				
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "WARNF");
		}

	}
	
	public void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "WARN");
		}
	}


	public void clickById(String id) {
		try{
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: "+id+" is clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
	}
	
	public void clickbyIDExplicit(String id) {
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			
	wait = new WebDriverWait(driver,30);
	WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));

	System.out.println(element+"element will click");	

	element.click();
			reportStep("The element with xpath: "+id+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because Element not found Exception has occured", "FAIL");
			//System.out.println(e.getMessage());
		}
	}

	
	
	

	
	public void clickByClassName(String classVal) {
		try{
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
	}

	public void clickByName(String name) {
		try {
			
			 readytimes();
			//readywithtime(xpathVal);
		//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: "+name+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	public void clickByLink(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
	}


	public void clickByXpath(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}

	public void clickByLinkNoSnap(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS",false);
		} catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS",false);
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}		
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	hi
	 */
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	hi
	 */
	public void mouseOverByLinkText(String linkName) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	hi
	 */
	public String getTextByXpath(String xpathVal){
		try {
			readywithtime(xpathVal);
//			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		
		String bReturn = "null";
	
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			 wait = new WebDriverWait(driver,30);
			
	return	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal))).getText();
		
			//return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	
	
	
	public List returnlist(String webelemet){
		List<WebElement>ele = null;
		try{
			List<WebElement>a=driver.findElements(By.xpath(webelemet));
			System.out.println(a.size());
			reportStep("The element with xpath could be found.", "PASS");

		}
		catch (Exception e) {
			reportStep("The element with xpath could not be found.", "FAIL");
		}
		return ele;
	}
	
	public String getAttributesxpath(String xpath, String text) {
		
		String sText = null;
		try{
			sText = driver.findElementByXPath(xpath).getAttribute(text);
			reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		return sText;
	}

	
	
	
	public WebElement getelementXpath(String xpathVal){
		WebElement bReturn = null ;
		try{
			bReturn= driver.findElement(By.xpath(xpathVal));
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	
	public List<WebElement> getlistelementXpath(String xpathVal){
		List<WebElement> bReturn = null ;
		try{
			bReturn= driver.findElements(By.xpath(xpathVal));
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	
	
	
	public String verifyTextelement(WebElement ele){
		String sText=null;
		try {
			sText = ele.getText();
			//sname=ele.getText();
			System.out.println(sText);
				reportStep("The text: "+sText+" matches with the value :"+sText, "PASS");
				}
		
	catch (Exception e) {
			e.printStackTrace();
			reportStep("Unknown exception occured while verifying the text ", "FAIL");
		}
		return sText;
	}
	/**
	 * This method will return the text of the element using id as locator
	 * @param xpathVal  The id (locator) of the element
	hi
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	public WebElement getTextsById(String idVal) {
		WebElement bReturn = null;
		try{
		return driver.findElementById(idVal);
		} catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	hi
	 */
	public void selectVisibileTextById(String id, String value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");
		} catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}


	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			readywithtime(xpath);
		//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
			Thread.sleep(2000);
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);;
			reportStep("The element with xpath: "+xpath+" is selected with value :"+value, "PASS");
		} catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}

	public void selectIndexById(String id, int value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(value);
			reportStep("The element with id: "+id+" is selected with index :"+value, "PASS");
		} catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	/**
	 * This method will switch to the parent Window
	hi
	 */
	public void switchToParentWindow() {
		try {
						
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	/**
	 * This method will move the control to the last window
	hi
	 */
	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}


	/**
	 * This method will accept the alert opened
	hi
	 */
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	/**
	 * This method will return the text of the alert
	hi
	 */
	public String getAlertText() {		
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
		return text;

	}

	
	
	
	
	
	
	
	
	/**
	 * This method will dismiss the alert opened
	hi
	 */
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	
	/**
	 * This method will take snapshot of the browser
	hi
	 */
	
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("Screenshot not Support", "INFO");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "INFO");
		}
		catch (Exception e) {
			reportStep("The snapshot could not be taken", "INFO");
		}

		return number;
	}
	
	
	
	
	public void firstwindow(String primarywindow){
		try{
			driver.switchTo().window(primarywindow);

			System.out.println(driver.getTitle());
		}




		catch(WebDriverException e){
			reportStep("The window could not be switched to the first window.", "FAIL");
		}


	}


	public void lastwindowhandle(){
		try{

			System.out.println(driver.getTitle());


			Set<String> lastWindow = driver.getWindowHandles();
			for (String allWindow : lastWindow) {
				driver.switchTo().window(allWindow);
			}
			System.out.println(driver.getTitle());

		}
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}

	
	  //Tap to an element for 250 milliseconds
    public void tapByElement (AndroidElement e) {
        new TouchAction(driver)
                .tap(tapOptions().withElement(element(e)))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }
 
    //Tap by coordinates
    public void tapByCoordinates (int x,int y) {
    	try{
        new TouchAction(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();

reportStep("The element with xpath: is clicked.", "INFO", false);

    	}
    	
        catch (Exception e) {
		
        reportStep("Element location Axis could not be clicked", "FAIL",false);
        }
    }
 
    //Press by element
    public void pressByElement (AndroidElement element, long seconds) {
        new TouchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
 
    //Press by coordinates
    public void pressByCoordinates (int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x,y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
 
    
    
    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
 
        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }
 
  
 
    //Swipe by elements
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
 
    //Multitouch action by using an android element
    public void multiTouchByElement (AndroidElement androidElement) {
        TouchAction press = new TouchAction(driver)
                .press(element(androidElement))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();
 
        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }

	public void logoutApp() throws InterruptedException{	
	//clickByXpathExplict(prop.getProperty("clickmenu.toggle.button.xpath"));
	Thread.sleep(2000);
//			ContextHandlingNative();
//			Thread.sleep(2000);		
//		clickByXpathExplict(prop.getProperty("click.logout.button.xpath"));
		
		
}
	
	//Added by sreejith
	
	public void clickBy(String xpathVal) {
		
		try {
			readywithtime(xpathVal);
		//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		WebDriverWait wait;
		try{
			
	Thread.sleep(2000);
	wait = new WebDriverWait(driver,60);
	WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
	System.out.println(element+"element will click");	

	waitForLoad(driver);
	element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
			//System.out.println(e.getMessage());
		}
	}
	
// Added by sreejith	
	
	void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
		    ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		        }
		    };
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(pageLoadCondition);
		}
	
	
	
	   public  void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {

			try {
				readytimes();
//				readywithtime(xpathVal);
			//	readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}
			
		   
		   
	        Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.width * anchorPercentage);
	        int startPoint = (int) (size.height * startPercentage);
	        int endPoint = (int) (size.height * endPercentage);
	 
	        new TouchAction(driver)
	                .press(point(anchor, startPoint))
	                .waitAction(waitOptions(ofMillis(1000)))
	                .moveTo(point(anchor, endPoint))
	                .release().perform();
	     
	  
	   

			try {
	readytimes();			
			//	readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}
			
	   
	   }	
	
	   
	   
	   
	   public  void bottomverticalSwipeByPercentages() {

			try {
	readytimes();			
			//	readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}

		   
		   
		   try{
		      Dimension size = driver.manage().window().getSize();
		      int x0 = (int) (size.getWidth() * 0.2);
		      int y0 = (int) (size.getHeight() * 0.2);
		      int x1 = (int) (size.getWidth() * 0.5);
		      int y1 = (int) (size.getHeight() * 0.9);
		      TouchAction touchAction = new TouchAction(driver);
		      touchAction.press(point(x1, y1)).waitAction().moveTo(point(x0, y0)).release().perform();

//				reportStep("Page has Scrolled Sucessfully", "PASS");

}


catch (Exception e) {

//	reportStep("Page has not Scrolled Sucessfully", "FAIL");

	// TODO: handle exception
}
		   
		   
			try {
	readytimes();			
			//	readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}

		   
		   
			   }

	   
	   
	   
	   
	   
	   
	   
	public void scrolldown()
	{
		Dimension dimension = driver.manage().window().getSize();
		Double scrollheightStart= dimension.getHeight()*0.5;
		int scrollstart = scrollheightStart.intValue();
		Double scrollheightEnd= dimension.getHeight()*0.2;
		int scrollEnd = scrollheightEnd.intValue();
		
		new TouchAction(driver)
		.press(PointOption.point(0, scrollstart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
		
	}
	
	
//	public void readystate(){
//		WebDriverWait wait;
//
//		  wait = new WebDriverWait(driver, 300);
//
//	
//	wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
//	
//	
//		}
	
		public void jqueryload() throws InterruptedException{
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
		int count =0;
		if((Boolean)js.executeScript("return window.jQuery != undefined"))
		{
			while(!(Boolean) js.executeScript("return jQuery.active == 0"))
			{ 
				System.out.println("page ...loading..."+count);

				Thread.sleep(1000); 
				if(count>300) 
					break;
				count++;
				} 
			}
		
		
		}	

	
	
	public void readywithtime(String xpathVal) throws InterruptedException{
		for(int i=1;i<300;i++){
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;		
		     String loadstate = js.executeScript("return document.readyState").toString();
		     
		        
		   //     System.out.println("qqqqqqqqqqqqqq");
		        System.out.println(loadstate);
		     //   System.out.println("qqqqqqqqqqqqqq");
	if (loadstate.contains("complete")){
	Thread.sleep(1000);
	System.out.println(xpathVal);
	System.out.println(loadstate);
	System.out.println("page has loaded");
	System.out.println(i);
	break;
	}
	else{
	Thread.sleep(1000);

	System.out.println("loading page......");
	System.out.println(i);
	System.out.println(loadstate);





	//break;
	}	}

	}

	public void readytimes() throws InterruptedException{
		for(int i=1;i<120;i++){
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;		
		     String loadstate = js.executeScript("return document.readyState").toString();
		     
		        
		   //     System.out.println("qqqqqqqqqqqqqq");
		        System.out.println(loadstate);
		     //   System.out.println("qqqqqqqqqqqqqq");
	if (loadstate.contains("complete")){
	Thread.sleep(1000);
//	System.out.println(xpathVal);
	System.out.println(loadstate);
	System.out.println("page has loaded");
	System.out.println(i);
	break;
	}
	else{
	Thread.sleep(1000);

	System.out.println("loading page......");
	System.out.println(i);
	System.out.println(loadstate);





	//break;
	}	}

	}

	
	
	
	
	public List<WebElement>getElement() 
	{
		return driver.findElements(By.xpath("//android.widget.CheckedTextView[@text='TAKERHAT']"));
	}
	
	
	public void scrolltoElement() throws InterruptedException
	
	{
	System.out.println();
		while(getElement().size() == 0)
		{
			scrolldown();
		}
		
		if(getElement().size() > 0)
		{
			getElement().get(0).click();
		}
		Thread.sleep(4000);
	}
	
	public void tapElements(AppiumDriver appiumDriver, WebElement element) {
		  // Locate center of element
		  Point location = element.getLocation();
		  Dimension size = element.getSize();
		  int tapX = location.getX() + (size.getWidth() / 2);
		  int tapY = location.getY() + (size.getHeight() / 2);

		  // Execute tap
		  String originalContext = appiumDriver.getContext();
		  appiumDriver.context("NATIVE_APP");
		  TouchAction action = new TouchAction(appiumDriver);
		  action.tap(point(tapX,tapY)).perform();
		  appiumDriver.context(originalContext);
		}
	
}



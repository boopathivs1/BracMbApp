package testcases;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class pressbackbuttoncommand {
	static AndroidDriver<WebElement>driver;	

	public static void main(String[] args) throws Exception {

	driver.pressKey(new KeyEvent(AndroidKey.BACK));

}
}
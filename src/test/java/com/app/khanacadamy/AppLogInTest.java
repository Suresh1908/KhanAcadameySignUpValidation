package com.app.khanacadamy;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppLogInTest {
	@Test
	public void loginValidation() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		// capability.setCapability("deviceName", "Manzoor");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Suresh");
		capability.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
		// capability.setCapability(MobileCapabilityType.NO_RESET,"true");//it will stay
		// on homescreen
		capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true"); // it wil not ask any
																								// permission once we
																								// open app
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		Thread.sleep(10000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("Test@gmail.com");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password\")")).sendKeys("testtest");
		driver.hideKeyboard();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		String Actual = "Invalid password";

		String Expected = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Invalid password\")"))
				.getText();

		assertEquals(Actual, Expected);

	}

}

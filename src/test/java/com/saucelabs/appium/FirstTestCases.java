package com.saucelabs.appium;

import java.io.File;
import java.net.URL;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FirstTestCases {
	public WebDriver driver = null;

	@Before
	public void setUp() throws Exception {

		// set up appium
		File app = new File("H:/NewTestingProject/workspace/AppiumPractice/",
				"ContactManager.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");

		capabilities.setCapability(CapabilityType.PLATFORM, "ANDROID");

		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
				capabilities);

		System.out.println("App launched");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testCases() throws InterruptedException {
		try {
			WebElement el = driver.findElement(By.name("Add Contact"));
			el.click();
			List<WebElement> textFieldsList = driver.findElements(By
					.className("android.widget.EditText"));
			textFieldsList.get(1).sendKeys("Some Name");
			textFieldsList.get(2).sendKeys("Some@example.com");
			 driver.findElement(By.name("Save")).click();

			Thread.sleep(5000);

			// write all your tests here
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}

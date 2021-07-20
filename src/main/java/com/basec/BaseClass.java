package com.basec;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import com.pages.SamplePage;
import com.pages.SamplePaymentPage;
import com.util.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Utility {

	public SamplePage sample;
	public SamplePaymentPage samplePayment;

	public BaseClass() {
		propertyInit();
	}

	public static void intialization() {
		
		String browserName = prop.getProperty("Browser");
		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Opera")) {

			WebDriverManager.operadriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}
	@AfterSuite
	public void tearDown() {
		// closes all the browser windows opened by web driver
		driver.quit();
	}
}

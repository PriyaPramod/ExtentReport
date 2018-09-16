package com.automation.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {

	WebDriver driver;
	private String BrowserName;

	public void startBrowser(String browserName) {
		BrowserName = browserName;
		try {
			switch (browserName.toUpperCase()) {
			case "CHROME":
				System.setProperty(Constants.CHROME_KEY, Constants.CHROME_PATH);
				driver = new ChromeDriver();
				break;
			case "FIREFOX":
				System.setProperty(Constants.FIREFOX_KEY, Constants.FIREFOX_PATH);
				driver = new FirefoxDriver();
				break;
			default:
				break;
			}
			Reporter.log("pass", "Launching " + browserName + " Browser");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demo.actitime.com/");
		} catch (Exception e) {
			Reporter.log("fail", "Unable to Launch " + browserName + " Browser " + e);
		}
	}

	public void stopBrowser() {
		try {
			driver.quit();
			Reporter.log("pass", "Closed " + BrowserName + " Browser ");
		} catch (Exception e) {
			Reporter.log("fail", "Unable to close the " + BrowserName + " Browser " + e);
		}
	}
}

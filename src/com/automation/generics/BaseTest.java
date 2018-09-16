package com.automation.generics;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends Selenium {
	@BeforeSuite
	public void suiteSetUp() {
		String htmlPath = Constants.HTMLPATH + Generic.getCurrentDate() + ".html";
		Reporter.configHTML(htmlPath);
	}

	@AfterSuite
	public void suiteTearDown() {
		Reporter.flush();
	}

	@BeforeMethod
	public void methodSetUp(Method testName) {
		Reporter.createTest(testName.getName());
		Reporter.log("info", testName.getName() +" Execution started");
		startBrowser("CHROME");
	}

	@AfterMethod
	public void methodTearDown(Method testName) {
		stopBrowser();
		Reporter.log("info", testName.getName() +" Execution completed");
	}
}

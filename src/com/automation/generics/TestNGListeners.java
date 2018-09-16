package com.automation.generics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("fail", result.getName() + " test method failed");
		String screenShotPath = Constants.SCREENSHOTPATH + result.getName() + "_" + System.currentTimeMillis() + ".png";
		Object obj = result.getInstance();
		BaseTest base = (BaseTest)obj;
		Generic.takeScreenShot(base.driver, screenShotPath);
		Reporter.addScreenShotToReport(System.getProperty("user.dir")+"/"+screenShotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("error", result.getName() + " test method skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("pass", result.getName() + " test method started to execute");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("pass", result.getName() + " test method executed successfully ");
	}

}

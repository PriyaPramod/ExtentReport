package com.automation.generics;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports reports;
	private static ExtentTest test;

	public static void configHTML(String htmlPath) {
		if (reports == null) {
			htmlReporter = new ExtentHtmlReporter(htmlPath);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("Automation");
			htmlReporter.config().setReportName("TestScripts");

			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
			reports.setSystemInfo("OS", "Windows");
			reports.setSystemInfo("Browser Name", "Chrome");
			reports.setSystemInfo("Browser Version", "64");
		}
	}

	public static void createTest(String testName) {
		test = reports.createTest(testName);
	}

	public static void log(String status, String info) {
		switch (status.toUpperCase()) {
		case "PASS":
			test.pass(info);
			break;
		case "FAIL":
			test.fail(info);
			break;
		case "ERROR":
			test.error(info);
			break;
		case "INFO":
			test.info(info);
			break;

		default:
			test.warning("Invalid option: " + info);
			break;
		}
	}

	public static void flush()
	{
	 reports.flush();
	}
	
	public static void addScreenShotToReport(String imagePath)
	{
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			Reporter.log("fail", "Unable to add the screen shot to the HTML report");
		}
	}
}

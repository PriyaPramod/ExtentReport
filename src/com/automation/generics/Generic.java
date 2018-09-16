package com.automation.generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Generic {

	public static String getCurrentDate()
	{
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		return sf.format(date.getTime());
	}
	
	public static void takeScreenShot(WebDriver driver, String screenShotPath){
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenShotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			Reporter.log("fail", "Unable to take the screen shot: "+e);
		}
	}
}

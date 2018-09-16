package com.automation.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.generics.BaseTest;
import com.automation.generics.Reporter;

public class SentItem extends BaseTest{
	@Test
	public void verifyMail() {
		Reporter.log("pass", "Running verifyMail");
		Assert.fail();
	}
	
	@Test
	public void forwardMail()
	{
		Reporter.log("pass", "Running forwardMail");
	}
}

package com.automation.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.generics.BaseTest;
import com.automation.generics.Reporter;

public class Inbox extends BaseTest{
	@Test
	public void composeMail() {
		Reporter.log("pass", "Running composeMail");
	}
	
	@Test
	public void deleteMail() {
		Reporter.log("pass", "Running deleteMail");
		Assert.fail();
	}
}

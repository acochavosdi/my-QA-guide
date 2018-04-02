package com.my_qa_guide.Group_Tests.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTestExample {
	String message = ".com";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(groups = { "functest", "checkintest" })

	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = ".com";
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(groups = { "checkintest" })

	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "tutorialspoint" + ".com";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test(groups = { "functest" })

	public void testingExitMessage() {
		System.out.println("Inside testExitMessage()");
		message = "www." + "tutorialspoint" + ".com";
		Assert.assertEquals(message, messageUtil.exitMessage());
	}
}
package com.my_qa_guide.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	String message = "Manisha";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(enabled = false)
	public void ignoredTest() {
		System.out.println("Inside ignoredTest()");
		Assert.assertEquals(message, messageUtil.printMessage());
	}
}
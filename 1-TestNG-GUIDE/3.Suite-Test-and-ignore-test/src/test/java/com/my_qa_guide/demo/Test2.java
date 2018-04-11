package com.my_qa_guide.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
	String message = "Manisha";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Manisha";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}
}
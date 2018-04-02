package com.my_qa_guide.Dependeny_Test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestUsingAnnotationDependsOnGroups {
	String message = "Manisha";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test(groups = { "init" })
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "Manisha";
		Assert.assertEquals(message, messageUtil.printMessage());
	}

	@Test(dependsOnGroups = { "init.*" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Manisha";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

	@Test(groups = { "init" })
	public void initEnvironmentTest() {
		System.out.println("This is initEnvironmentTest");
	}
}
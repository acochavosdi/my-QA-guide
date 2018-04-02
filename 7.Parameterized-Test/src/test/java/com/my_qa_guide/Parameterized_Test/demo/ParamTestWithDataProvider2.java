package com.my_qa_guide.Parameterized_Test.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamTestWithDataProvider2 {

	@BeforeClass
	public void beforeClassMethod() {
		System.err.println("\n ------------- Starting ParamTestWithDataProvider2 / Using Bean ------------- \n");
	}

	@DataProvider(name = "test1")
	public static Object[][] primeNumbers() {
		return new Object[][] { { new Bean("hi I am the bean", 111) } };
	}

	@Test(dataProvider = "test1")
	public void testMethod(Bean myBean) {
		System.out.println(myBean.getVal() + " " + myBean.getI());
	}
}
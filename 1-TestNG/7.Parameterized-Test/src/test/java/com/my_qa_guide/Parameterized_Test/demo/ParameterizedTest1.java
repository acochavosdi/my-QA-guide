package com.my_qa_guide.Parameterized_Test.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest1 {

	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("\n ------------- Starting Parametrized Test using only testng.xml ------------- \n");
	}

	@Test
	@Parameters("myName")
	public void parameterTest(String myName) {
		System.out.println("Parameterized value is : " + myName);
	}
}
package com.my_qa_guide.Parameterized_Test.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamTestWithDataProvider1 {
	private PrimeNumberChecker primeNumberChecker;

	@BeforeClass
	public void beforeClassMethod() {
		System.err.println("\n ------------- Starting ParamTestWithDataProvider1 ------------- \n");
	}

	@BeforeMethod
	public void initialize() {
		primeNumberChecker = new PrimeNumberChecker();
	}

	@DataProvider(name = "test1")
	public static Object[][] primeNumbers() {
		return new Object[][] { { 2, true }, { 6, false }, { 19, true }, { 22, false }, { 23, true } };
	}

	// This test will run 4 times since we have 5 parameters defined
	@Test(dataProvider = "test1")
	public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
		System.out.println(inputNumber + " " + expectedResult);
		Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
	}
}
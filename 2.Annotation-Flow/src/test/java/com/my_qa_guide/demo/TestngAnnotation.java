package com.my_qa_guide.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestngAnnotation {
	// test case 1
	@Test
	public void testCase1() {
		System.out.println("in test case 1");
	}

	// test case 2
	@Test
	public void testCase2() {
		System.out.println("in test case 2");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("in beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("in afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("in beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("in afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("in beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in afterSuite");

		System.out.println("\n\nConclusion: \n\nFirst of all, beforeSuite() method is executed only once.\n" + "\n"
				+ "Lastly, the afterSuite() method executes only once.\n" + "\n"
				+ "Even the methods beforeTest(), beforeClass(), afterClass(), and afterTest() methods are executed only once.\n"
				+ "\n" + "beforeMethod() method executes for each test case but before executing the test case.\n"
				+ "\n" + "afterMethod() method executes for each test case but after executing the test case.\n" + "\n"
				+ "In between beforeMethod() and afterMethod(), each test case executes.");
	}

}
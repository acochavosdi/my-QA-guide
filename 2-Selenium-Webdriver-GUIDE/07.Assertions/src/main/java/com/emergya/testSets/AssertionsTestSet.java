package com.emergya.testSets;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.utils.BasicTestSet;

public class AssertionsTestSet extends BasicTestSet {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(AssertionsTestSet.class);

	/**
	 * Constants
	 */

	private static final String JQUERY_INDEX_URL = "https://jqueryui.com/";

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// ******************************************************************* //
	// ***************************** TEST ******************************** //
	// ******************************************************************* //
	// ----------- US00006 - Assertions Basics --------------------------- //
	// ------------------------------------------------------------------- //
	/**
	 * Description: Simple Test to learn Hard and Soft Assertions
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Check the page is ready with an assert true - Check the class of an
	 * element whose class is "intro" is exactly equals to "intro" with an assert
	 * equals - Use a SoftAssert and force it to activate to verify that the test
	 * does not stop - Before the "test" ends, check if any of the "soft asserts"
	 * have been activated, if so, throw the corresponding exception and stop the
	 * test
	 * 
	 * 
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @param method
	 * @throws InterruptedException
	 */
	@Test(description = "assertions")
	public void assertions(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test assertions method: " + method.getName());

		driver.get(JQUERY_INDEX_URL);
		Thread.sleep(3000);
		jqueryMainPage = new JqueryMainPage(driver);

		////////////// HARD ASSERTIONS -> Test will stop if triggered

		// AssertTrue
		assertTrue(jqueryMainPage.isReady(), "Page isn't ready");

		// AssertEquals
		assertEquals(jqueryMainPage.getClassOfAnItemWithClassEqualsToIntro(), "intro",
				"Class of the element is not 'intro'");

		////////////// SOFTASSERTIONS -> Test will not stop if triggered

		SoftAssert softAssertion = new SoftAssert();

		softAssertion.assertTrue(false,
				"Soft Assertion, it didnt passed because we force a 'false', but as u will see, test didnt stopped and next code lines will be executed");

		// assertAll()
		// If we dont want the test to end without exception ,because there are some
		// soft asserts that has been triggered. We have to call assertAll() so we dont
		// have a false positive on the test

		log.info("This mesage will be displayed because soft Assert didnt stop the test");
		softAssertion.assertAll();
		log.info(
				"This message will not be displayed because assertAll() called the asserts to force triggered exceptions");

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test assertions method: " + method.getName());

		/*
		 * TODO
		 * 
		 * assertNotEquals(actual1, actual2);
		 * 
		 * assertNotNull(object);
		 * 
		 * assertNotSame(actual, expected);
		 * 
		 */
	}
}

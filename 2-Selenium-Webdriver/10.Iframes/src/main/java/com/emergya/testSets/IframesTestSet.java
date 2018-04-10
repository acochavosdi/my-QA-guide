package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.ToolsQaIframesPage;
import com.emergya.utils.BasicTestSet;

public class IframesTestSet extends BasicTestSet {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(IframesTestSet.class);

	/**
	 * Constants
	 */

	private static final String URL_IFRAMES_TEST_PAGE = "http://toolsqa.com/iframe-practice-page/";

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
	// ----------- US00009 - Learning Iframes ---------------------------- //
	// ------------------------------------------------------------------- //

	/**
	 * 
	 * Description: Using the 3 possible methods to work with iframes
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Check the visibility of the 3 elements when we have just opened the
	 * page - Change to the first iframe with the method that accepts an integer as
	 * an argument and verify again what element is visible - Switch to the second
	 * iframe with the method that accepts a string identifier as an argument and
	 * check again wich element is visible - Switch to the first iframe with the
	 * method that accepts a WebElement as an argument and check again wich element
	 * is visible
	 * 
	 * Post steps: - Close the browser
	 * 
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * 
	 */
	@Test(description = "testingIframes")
	public void testingIframes(Method method) {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(URL_IFRAMES_TEST_PAGE);

		toolsQaIframesPage = new ToolsQaIframesPage(driver);
		assertTrue(toolsQaIframesPage.isReady(), "Page isnt ready");

		// Check the visibility of the 3 elements when we have just opened the page
		toolsQaIframesPage.checkVisibilityOfThe3Elements();

		// Change to the first iframe with the method that accepts an integer as an
		// argument and verify again what element is visible
		toolsQaIframesPage.switchToIframeNumber0ByPassingAnInteger(0);
		toolsQaIframesPage.checkVisibilityOfThe3Elements();
		toolsQaIframesPage.switchToDefaultIframe();

		// Switch to the second iframe with the method that accepts a string identifier
		// as an argument and check again wich element is visible
		toolsQaIframesPage.switchToIframeNumber1ByPassingAString("iframe2");
		toolsQaIframesPage.checkVisibilityOfThe3Elements();
		toolsQaIframesPage.switchToDefaultIframe();

		// Switch to the first iframe with the method that accepts a WebElement as an
		// argument and check again wich element is visible
		toolsQaIframesPage.switchToIframeNumber0ByUsingTheIframeWebElement();
		toolsQaIframesPage.checkVisibilityOfThe3Elements();
		toolsQaIframesPage.switchToDefaultIframe();

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());

	}

}

package com.emergya.testSets;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.utils.BasicTestSet;

public class BasicInteractionsTestSet extends BasicTestSet {
	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(BasicInteractionsTestSet.class);

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
	// ----------- US00007 - Interactions Basics ------------------------- //
	// ------------------------------------------------------------------- //
	/**
	 * Description: Using different Page Objects - Clicking by 2 different methods -
	 * Using selector properties file - Using default selenium driver methods with
	 * properties file workflow - SendKeys to an input - Using explicit wait method
	 * until certain conditions
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Check Main Page is Ready - Navigate to Draggable Page clicking with
	 * 1 type of clicking method - Check if Draggable Page is ready - Navigate to
	 * Index Page Clicking on the logo with another type of clicking method and
	 * check if it worked - Search the String "Draggable" on the search input -
	 * Check the results - Find the dragable section on the results - Click on it to
	 * navigate into the page - Check the page is ready
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @param method
	 * @throws InterruptedException
	 */
	@Test(description = "interactionsBasic")
	public void interactionsBasic(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test interactionsBasic method: "
				+ method.getName());

		driver.get(JQUERY_INDEX_URL);
		Thread.sleep(3000);
		jqueryMainPage = new JqueryMainPage(driver);

		// Check Main Page is Ready
		assertTrue(jqueryMainPage.isReady(), "Main Page isn't ready");

		// Navigate to Draggable Page clicking with 1 type of clicking method
		jqueryDraggablePage = jqueryMainPage.clickOnDraggablePageLink();
		assertNotEquals(jqueryDraggablePage, null,
				"Error Clicking on the button to navigate Jquery Draggable Page or returned Null");
		Thread.sleep(2000);

		// Check if Draggable Page is ready
		assertTrue(jqueryDraggablePage.isReady(), "Draggable Page isn't ready");
		Thread.sleep(2000);

		// Navigate to Index Page Clicking on the logo with another type of clicking
		// method and check if it worked
		jqueryDraggablePage.clickOnTheLogo();
		assertTrue(jqueryMainPage.isReady(), "Main Page isn't ready");

		// Search the String "Draggable" on the search input - Check the results - Find
		// the dragable section on the results - Click on it to navigate into the page
		// - Check the page is ready

		jqueryMainPage.searchStringOnSearchInput("Draggable");
		jqueryMainPage.waitUntilTheResultWeWantAndClickOnIt();
		assertTrue(jqueryDraggablePage.isReady(), "Draggable Page is not ready");
		Thread.sleep(2000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test interactionsBasic method: "
				+ method.getName());

	}
}

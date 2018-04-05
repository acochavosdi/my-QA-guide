package com.emergya.testSets;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.utils.BasicTestSet;

public class JqueryBasicInteractionsTestSet extends BasicTestSet {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(JqueryBasicInteractionsTestSet.class);

	/**
	 * Constants
	 */

	private static final String JQUERY_INDEX_URL = "https://jqueryui.com/";
	private static final String JQUERY_DRAGGABLE_URL = "https://jqueryui.com/draggable/";

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
	// ----------- US00007 - Interactions Test --------------------------- //
	// ------------------------------------------------------------------- //

	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: TODO
	 * 
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test(description = "interactions")
	public void interactions(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test interactions method: "
				+ method.getName());

		// Navigate to the Page
		driver.get(JQUERY_INDEX_URL);
		Thread.sleep(3000);

		// Instanciate the Page Object of the end-point we are going to work on
		jqueryMainPage = new JqueryMainPage(driver);

		// Execute isReady() method to check if the page is ready
		if (jqueryMainPage.isReady())
			log.info("Page ready");
		else {
			log.error("Page isn't ready");
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test interactions method: " + method.getName());

	}
}

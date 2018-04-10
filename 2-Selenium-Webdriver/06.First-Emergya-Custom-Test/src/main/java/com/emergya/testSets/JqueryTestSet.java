package com.emergya.testSets;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.utils.BasicTestSet;

public class JqueryTestSet extends BasicTestSet {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(JqueryTestSet.class);

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
	// ----------- US00005 - First Emergya Custom Test ------------------- //
	// ------------------------------------------------------------------- //

	/**
	 * Description: First steps with Page Object Model + Emergya Driver +
	 * BasicTestSet + Handler
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Navigate to the JqueryIndexPage - Instanciate the Page Object of the
	 * JqueryIndexPage so we can start using the Emergya WorkFlow - Check if the
	 * page is ready using a public method of the Page Object, this method must use
	 * the Custom Handler and the file.properties.
	 * 
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test(description = "firstTestWithEmergyaQA")
	public void firstTestWithEmergyaQA(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test firstTestWithEmergyaQA method: "
				+ method.getName());

		// Navigate to the Page
		driver.get(JQUERY_INDEX_URL);
		Thread.sleep(3000);

		// Instanciate the Page Object of the end-poing we are going to work on
		jqueryMainPage = new JqueryMainPage(driver);

		// Execute isReady() method to check if the page is ready
		if (jqueryMainPage.isReady())
			log.info("Page ready");
		else {
			log.error("Page isn't ready");
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test firstTestWithEmergyaQA method: "
				+ method.getName());

	}
}

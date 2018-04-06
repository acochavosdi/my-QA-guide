package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.utils.BasicTestSet;

public class ScrollingAndJavascriptTestSet extends BasicTestSet {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(ScrollingAndJavascriptTestSet.class);

	/**
	 * Constants
	 */

	private static final String INDEX_URL = "https://jqueryui.com/";

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// *********************** TEST ************************** //
	// -------------------- mYQA Gymkana --------------------- //
	// ---------- US00012 - Scroll + Injecting Javascript ---- //
	// ******************************************************* //
	/**
	 * Description: Test to show a simple scroll methods to work with them,
	 * including javascript injection
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Scroll to Bottom - Scroll to Top - Scroll to an Element - Scroll
	 * with Javascript to an offset from the current scope - Scroll with Javascript
	 * to the top of the page, getting the height of the element to work on it.
	 * 
	 * Post steps: - Close the browser
	 * 
	 * Conclusion: TODO
	 * 
	 * Acquired Knowledge: - this.scrollBottom() - this.scrollTop() -
	 * this.scrollTo(this.getElementByXPath(BOOKS_SPAN_XPATH)) - JavascriptExecutor
	 * - executeScript()
	 * 
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 *
	 */
	@Test(description = "scrollAndJavascript")
	public void scrollAndJavascript(Method method) throws InterruptedException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start scrollAndJavascript test method: "
				+ method.getName());

		driver.get(INDEX_URL);
		jqueryMainPage = new JqueryMainPage(driver);
		assertTrue(jqueryMainPage.isReady(), "Main Page not ready");

		jqueryMainPage.usingScrolling();

		log.info("[log-TestSet] " + this.getClass().getName() + " - End scrollAndJavascript test method: "
				+ method.getName());
	}
}

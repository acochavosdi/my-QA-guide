package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

/**
 * Page Object
 * 
 * @author acosanchez
 *
 */
public class JqueryMainPage extends BasePageObject {

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(JqueryMainPage.class);

	/**
	 * Item keys selector
	 */

	private static final String INTRO_PARAGRAPH_XPATH = "introSelectorXpath";
	private static final String BOOKS_SPAN_XPATH = "spanBooksXPATH";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public JqueryMainPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Check if the page is Ready
	 */
	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReadyWithEmergyaHandler method");

		boolean status = this.isElementVisibleByXPath(INTRO_PARAGRAPH_XPATH);
		if (status) {
			log.info("The page with URL: " + driver.getCurrentUrl()
					+ " is ready, checked using Emergya Handler methods");
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReadyWithEmergyaHandler method");

		return status;
	}

	public void usingScrolling() throws InterruptedException {

		// Scroll to Bottom
		this.scrollBottom();
		Thread.sleep(1500);

		// Scroll to Top
		this.scrollTop();
		Thread.sleep(1500);

		// Scroll to a WebElement
		this.scrollTo(this.getElementByXPath(BOOKS_SPAN_XPATH));
		Thread.sleep(1500);

		// Scroll with Javascript
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1500);

		// Scroll to Bottom
		this.scrollBottom();
		Thread.sleep(1500);

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1500);

		this.scrollTop();
		Thread.sleep(1500);
	}

}

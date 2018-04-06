package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Check if the element with the selector stored in "String intro_xpath", wich
	 * is defined in the own method is displayed;
	 * 
	 * @return true if displayed
	 */
	public boolean isReadyWithSeleniumDefault() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReadyWithSeleniumDefault method");

		String intro_xpath = "//p[@class='intro']";
		boolean status = driver.isElementDisplayed(By.xpath(intro_xpath));

		if (status) {
			log.info("The page with URL: " + driver.getCurrentUrl()
					+ " is ready, checked using Selenium native methods");
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReadyWithSeleniumDefault method");

		return status;
	}

	/**
	 * Check if the element with the selector stored in the "properties" file is
	 * displayed, the real selector is taken through the constant key defined at the
	 * top of this class.
	 * 
	 * @return true if displayed
	 */
	public boolean isReadyWithEmergyaHandler() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReadyWithEmergyaHandler method");

		boolean status = this.isElementVisibleByXPath(INTRO_PARAGRAPH_XPATH);
		if (status) {
			log.info("The page with URL: " + driver.getCurrentUrl()
					+ " is ready, checked using Emergya Handler methods");
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReadyWithEmergyaHandler method");

		return status;
	}

}

package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SeleniumIsEasyTestPage extends BasePageObject {

	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(SeleniumIsEasyTestPage.class);

	/*
	 * String Selector Keys
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH = "uniqueElement";
	private static final String BUTTON_TO_SHOW_THE_BASIC_TESTS_ID = "buttonToShowBasicTests";
	private static final String LINK_TO_SIMPLE_FORM_PAGE_XPATH = "linkToSimpleFormPage";

	public SeleniumIsEasyTestPage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = false;

		if (this.isElementVisibleByXPath(UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH))
			status = true;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public SeleniumIsEasySimpleFormPage goToTheSimpleFormPage() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start goToTheSimpleFormPage method");

		if (this.isElementVisibleById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID)) {
			this.getElementById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID).click();

			driver.sleep(1);
			if (this.isElementVisibleByXPath(LINK_TO_SIMPLE_FORM_PAGE_XPATH)) {

				this.getElementByXPath(LINK_TO_SIMPLE_FORM_PAGE_XPATH).click();
				log.info(
						"[log-PageObjects] " + this.getClass().getSimpleName() + " - End goToTheSimpleFormPage method");
				return new SeleniumIsEasySimpleFormPage(driver);

			}

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End goToTheSimpleFormPage method");

		return null;
	}

}

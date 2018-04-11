package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SeleniumIsEasySimpleFormPage extends BasePageObject {

	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(SeleniumIsEasySimpleFormPage.class);

	/*
	 * String Selector Keys
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH = "uniqueElement";

	public SeleniumIsEasySimpleFormPage(EmergyaWebDriver driver) {
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

}

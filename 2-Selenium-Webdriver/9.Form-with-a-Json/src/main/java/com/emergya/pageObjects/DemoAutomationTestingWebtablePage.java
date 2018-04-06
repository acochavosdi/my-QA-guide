package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class DemoAutomationTestingWebtablePage extends BasePageObject {

	/**
	 * Logger class initialization
	 */

	static Logger log = Logger.getLogger(DemoAutomationTestingWebtablePage.class);

	/**
	 * Items keys selectors
	 */

	private static final String UNIQUE_WEBTABLE_DIV_XPATH = "UniqueWebTableDiV";

	/**
	 * Constructor
	 */

	public DemoAutomationTestingWebtablePage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");
		boolean status = this.isElementVisibleByXPath(UNIQUE_WEBTABLE_DIV_XPATH);
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");
		return status;
	}

}

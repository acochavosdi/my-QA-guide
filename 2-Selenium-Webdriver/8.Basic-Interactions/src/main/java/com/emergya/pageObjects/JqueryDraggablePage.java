package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JqueryDraggablePage extends BasePageObject {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(JqueryDraggablePage.class);

	/*
	 * String Key Selector
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE = "uniqueElementOfThisPage";
	private static final String LOGO_LINK = "logoLink";

	public JqueryDraggablePage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = false;

		if (this.isElementVisibleByXPath(UNIQUE_ELEMENT_OF_THIS_PAGE))
			status = true;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public void clickOnTheLogo() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		driver.clickIfExists(By.xpath(getXPath(LOGO_LINK)));

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

	}

}

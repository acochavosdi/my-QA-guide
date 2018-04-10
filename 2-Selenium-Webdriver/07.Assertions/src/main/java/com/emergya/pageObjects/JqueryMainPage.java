package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JqueryMainPage extends BasePageObject {

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(JqueryMainPage.class);

	public JqueryMainPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Item keys selector
	 */

	private static final String UNIQUE_ELEMENT_OF_INDEX_PAGE = "uniqueItemOfThisPage";
	private static final String PARAGRAPH_WITH_CLASS_EQUALS_TO_INTRO = "paragraphWithClassIntro";

	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = false;
		if (this.isElementVisibleById(UNIQUE_ELEMENT_OF_INDEX_PAGE))
			status = true;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public String getClassOfAnItemWithClassEqualsToIntro() {

		String className = null;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start getClassOfAnItemWithClassEqualsToIntro method");

		if (this.isElementVisibleByXPath(PARAGRAPH_WITH_CLASS_EQUALS_TO_INTRO)) {
			className = this.getElementByXPath(PARAGRAPH_WITH_CLASS_EQUALS_TO_INTRO).getAttribute("class");
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End getClassOfAnItemWithClassEqualsToIntro method");

		return className;

	}

}

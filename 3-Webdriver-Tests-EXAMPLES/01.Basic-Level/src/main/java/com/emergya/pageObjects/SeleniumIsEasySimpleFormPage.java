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
	private static final String SINGLE_INPUT_INPUT_ID = "singleInputInput";
	private static final String SINGLE_INPUT_BUTTON_XPATH = "singleInputButton";
	private static final String SINGLE_INPUT_DISPLAY_ID = "singleInputDisplay";
	private static final String DOUBLE_INPUT_SUM1_ID = "sum1";
	private static final String DOUBLE_INPUT_SUM2_ID = "sum2";
	private static final String GET_TOTAL_BUTTON_XPATH = "getTotalButton";
	private static final String DOUBLE_INPUT_DISPLAY_ID = "twoFieldsDisplay";

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

	public boolean writeOnTheSingleInput(String message) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start testSingleInputSection method");

		boolean status = false;

		if (this.isElementVisibleById(SINGLE_INPUT_INPUT_ID)) {
			this.getElementById(SINGLE_INPUT_INPUT_ID).sendKeys(message);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End testSingleInputSection method");

		return status;
	}

	public boolean clickOnShowMessage() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnShowMessage method");

		boolean status = false;

		if (this.isElementVisibleByXPath(SINGLE_INPUT_BUTTON_XPATH)) {
			this.getElementByXPath(SINGLE_INPUT_BUTTON_XPATH).click();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnShowMessage method");

		return status;
	}

	public String getTheReturnedMessage() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start getTheReturnedMessage method");

		if (this.isElementVisibleById(SINGLE_INPUT_DISPLAY_ID)) {
			log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End getTheReturnedMessage method");
			return this.getElementById(SINGLE_INPUT_DISPLAY_ID).getText();
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End getTheReturnedMessage method");

		return null;

	}

	public boolean writeValueOfA(String valueA) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start writeValueOfA method");

		boolean status = false;

		if (this.isElementVisibleById(DOUBLE_INPUT_SUM1_ID)) {
			this.getElementById(DOUBLE_INPUT_SUM1_ID).sendKeys(valueA);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End writeValueOfA method");

		return status;
	}

	public boolean writeValueOfB(String valueB) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start writeValueOfB method");

		boolean status = false;

		if (this.isElementVisibleById(DOUBLE_INPUT_SUM2_ID)) {
			this.getElementById(DOUBLE_INPUT_SUM2_ID).sendKeys(valueB);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End writeValueOfB method");

		return status;
	}

	public boolean clickOnGetTotal() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnGetTotal method");

		boolean status = false;

		if (this.isElementVisibleByXPath(GET_TOTAL_BUTTON_XPATH)) {
			this.getElementByXPath(GET_TOTAL_BUTTON_XPATH).click();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnGetTotal method");

		return status;
	}

	public String getTheReturnedTotal() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start getTheReturnedTotal method");

		if (this.isElementVisibleById(DOUBLE_INPUT_DISPLAY_ID)) {
			log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End getTheReturnedTotal method");
			return this.getElementById(DOUBLE_INPUT_DISPLAY_ID).getText();
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End getTheReturnedTotal method");

		return null;

	}
}

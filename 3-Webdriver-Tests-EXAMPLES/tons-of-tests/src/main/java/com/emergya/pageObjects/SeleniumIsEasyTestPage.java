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
	private static final String LINK_TO_CHECK_BOX_PAGE_XPATH = "linkToCheckBoxPage";
	private static final String LINK_TO_RADIO_BUTTONS_PAGE_XPATH = "linkToRadioButtonsPage";
	private static final String LINK_TO_DROPDOWN_LIST_PAGE_XPATH = "linkToSelectDropDownListPage";
	private static final String LINK_TO_JAVASCRIPT_ALERTS_PAGE_XPATH = "linkToJavascriptAlertsPage";
	private static final String LINK_TO_POPUP_MODALS_PAGE_XPATH = "linkToWindowPopupModalPage";
	private static final String LINK_TO_BOOTSTRAP_ALERTS_PAGE_XPATH = "linkToBootstrapAlertsPage";
	private static final String LINK_TO_BOOTSTRAP_MODALS_PAGE_XPATH = "linkToBootstrapModalsPage";

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

	public SeleniumIsEasyCheckBoxPage goToTheCheckBoxPage() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start goToTheCheckBoxPage method");

		if (this.isElementVisibleById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID)) {
			this.getElementById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID).click();

			driver.sleep(1);
			if (this.isElementVisibleByXPath(LINK_TO_CHECK_BOX_PAGE_XPATH)) {

				this.getElementByXPath(LINK_TO_CHECK_BOX_PAGE_XPATH).click();
				log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End goToTheCheckBoxPage method");
				return new SeleniumIsEasyCheckBoxPage(driver);

			}

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End goToTheCheckBoxPage method");

		return null;
	}

	public SeleniumIsEasyRadioButtonsPage goToTheRadioButtonsPage() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start goToTheRadioButtonsPage method");

		if (this.isElementVisibleById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID)) {
			this.getElementById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID).click();

			driver.sleep(1);
			if (this.isElementVisibleByXPath(LINK_TO_RADIO_BUTTONS_PAGE_XPATH)) {

				this.getElementByXPath(LINK_TO_RADIO_BUTTONS_PAGE_XPATH).click();
				log.info("[log-PageObjects] " + this.getClass().getSimpleName()
						+ " - End goToTheRadioButtonsPage method");
				return new SeleniumIsEasyRadioButtonsPage(driver);

			}

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End goToTheRadioButtonsPage method");

		return null;
	}

}

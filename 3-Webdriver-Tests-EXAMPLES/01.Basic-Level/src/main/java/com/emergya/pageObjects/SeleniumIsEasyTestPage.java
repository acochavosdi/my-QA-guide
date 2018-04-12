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

	public BasePageObject goToAPage(String whereToGo) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start goingToAConcretePage method");

		String destinationSelector = null;

		switch (whereToGo) {
		case "US00001":
			destinationSelector = LINK_TO_SIMPLE_FORM_PAGE_XPATH;
			break;

		case "US00002":
			destinationSelector = LINK_TO_CHECK_BOX_PAGE_XPATH;
			break;

		case "US00003":
			destinationSelector = LINK_TO_RADIO_BUTTONS_PAGE_XPATH;
			break;

		case "US00004":
			destinationSelector = LINK_TO_DROPDOWN_LIST_PAGE_XPATH;
			break;

		case "US00005":
			destinationSelector = LINK_TO_JAVASCRIPT_ALERTS_PAGE_XPATH;
			break;

		case "US00006":
			destinationSelector = LINK_TO_POPUP_MODALS_PAGE_XPATH;
			break;

		case "US00007":
			destinationSelector = LINK_TO_BOOTSTRAP_ALERTS_PAGE_XPATH;
			break;
		case "US00008":
			destinationSelector = LINK_TO_BOOTSTRAP_MODALS_PAGE_XPATH;
			break;
		default:
			break;
		}

		if (this.isElementVisibleById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID)) {
			this.getElementById(BUTTON_TO_SHOW_THE_BASIC_TESTS_ID).click();

			driver.sleep(1);
			if (this.isElementVisibleByXPath(destinationSelector)) {

				this.getElementByXPath(destinationSelector).click();
				log.info("[log-PageObjects] " + this.getClass().getSimpleName()
						+ " - End goToTheRadioButtonsPage method");
				switch (whereToGo) {
				case "US00001":
					return new SeleniumIsEasySimpleFormPage(driver);
				case "US00002":
					return new SeleniumIsEasyCheckBoxPage(driver);
				case "US00003":
					return new SeleniumIsEasyRadioButtonsPage(driver);
				case "US00004":
					return new SeleniumIsEasyDropDownPage(driver);
				case "US00005":
					return new SeleniumIsEasyJavascriptAlertsPage(driver);
				case "US00006":
					// TODO
					return new SeleniumIsEasySimpleFormPage(driver);
				case "US00007":
					// TODO
					return new SeleniumIsEasySimpleFormPage(driver);
				case "US00008":
					// TODO
					return new SeleniumIsEasySimpleFormPage(driver);
				default:
					break;
				}

			}

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End goingToAConcretePage method");
		return null;

	}

}

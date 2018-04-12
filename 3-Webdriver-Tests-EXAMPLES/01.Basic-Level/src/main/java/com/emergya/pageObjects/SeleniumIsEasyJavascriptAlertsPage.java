package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SeleniumIsEasyJavascriptAlertsPage extends BasePageObject {

	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(SeleniumIsEasyJavascriptAlertsPage.class);

	/*
	 * String Selector Keys
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH = "uniqueElement";
	private static final String ALERT_BOX_BUTTON_XPATH = "alertBoxButtonToDisplay";
	private static final String CONFIRM_BOX_BUTTON_XPATH = "confirmBoxButtonToDisplay";
	private static final String CONFIRM_BOX_DISPLAY_ID = "confirmBoxDisplay";
	private static final String TEXT_ALERT_BOX_BUTTON_XPATH = "textAlertBoxButtonToDisplay";
	private static final String TEXT_ALERT_BOX_DISPLAY_ID = "textAlertBoxDisplay";

	public SeleniumIsEasyJavascriptAlertsPage(EmergyaWebDriver driver) {
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

	public boolean isAlertBoxWorking() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isAlertBoxWorking method");
		boolean status = false;

		if (this.isElementVisibleByXPath(ALERT_BOX_BUTTON_XPATH)) {
			this.getElementByXPath(ALERT_BOX_BUTTON_XPATH).click();
			Alert alert = driver.switchTo().alert();
			driver.sleep(2);
			alert.accept();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isAlertBoxWorking method");

		return status;
	}

	public boolean isConfirmBoxWorking() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isConfirmBoxWorking method");

		boolean statusForAcceptAlert = false;
		boolean statusForDismissAlert = false;

		if (this.isElementVisibleByXPath(CONFIRM_BOX_BUTTON_XPATH)) {
			this.getElementByXPath(CONFIRM_BOX_BUTTON_XPATH).click();
			Alert alert = driver.switchTo().alert();
			driver.sleep(2);
			alert.accept();

			if (this.getElementById(CONFIRM_BOX_DISPLAY_ID).getText().contains("OK!"))
				statusForAcceptAlert = true;
		}

		if (this.isElementVisibleByXPath(CONFIRM_BOX_BUTTON_XPATH)) {
			this.getElementByXPath(CONFIRM_BOX_BUTTON_XPATH).click();
			Alert alert = driver.switchTo().alert();
			driver.sleep(2);
			alert.dismiss();
			if (this.getElementById(CONFIRM_BOX_DISPLAY_ID).getText().contains("Cancel!"))
				statusForDismissAlert = true;
		}

		driver.sleep(4);
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isConfirmBoxWorking method");
		return statusForAcceptAlert && statusForDismissAlert;
	}

	public boolean isTextBoxWorking(String message) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isTextBoxWorking method");

		boolean status = false;

		if (this.isElementVisibleByXPath(TEXT_ALERT_BOX_BUTTON_XPATH)) {
			this.getElementByXPath(TEXT_ALERT_BOX_BUTTON_XPATH).click();
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(message);
			driver.sleep(2);
			alert.accept();

			if (this.getElementById(TEXT_ALERT_BOX_DISPLAY_ID).getText().contains(message))
				status = true;
		}
		driver.sleep(4);
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isTextBoxWorking method");

		return status;
	}

}

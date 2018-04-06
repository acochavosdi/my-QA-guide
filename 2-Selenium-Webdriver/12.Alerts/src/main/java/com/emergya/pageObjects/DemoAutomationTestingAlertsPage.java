package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class DemoAutomationTestingAlertsPage extends BasePageObject {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(DemoAutomationTestingAlertsPage.class);

	/**
	 * Items keys selectors.
	 */

	// GENERIC
	private static final String UNIQUE_CONTAINER_SWITCH_TO_PAGE_XPATH = "uniqueContainerSwitchToPageXPATH";

	// ALERT WITH OK
	private static final String ALERT_WITH_OK_OPTION_XPATH = "alertWithOkOptionXPATH";
	private static final String ALERT_WITH_OK_BUTTON_TO_DISPLAY_THE_ALERT_XPATH = "alertWithOkButtonToDisplayTheAlertXPATH";

	// ALERT WITH TEXT
	private static final String ALERT_WITH_TEXTBOX_OPTION_XPATH = "alertWithTextBoxOptionXPATH";
	private static final String ALERT_WITH_TEXTBOX_TO_DISPLAY_THE_ALERT_XPATH = "alertWithTextBoxDisplayTheAlertXPATH";

	// ALERT WITH OK AND CANCEL
	private static final String ALERT_WITH_OK_AND_CANCEL_OPTION_XPATH = "alertWithOkANdCancelXPATH";
	private static final String ALERT_WITH_OK_AND_CANCEL_TO_DISPLAY_THE_ALERT_XPATH = "alertWithOkAndCancelDisplayTheAlertXPATH";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DemoAutomationTestingAlertsPage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(UNIQUE_CONTAINER_SWITCH_TO_PAGE_XPATH);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;

	}

	public boolean clickOnAlertWithOk() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnAlertWithOk method");

		boolean status = false;

		if (this.isElementVisibleByXPath(ALERT_WITH_OK_OPTION_XPATH)) {
			this.getElementByXPath(ALERT_WITH_OK_OPTION_XPATH).click();
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnAlertWithOk method");

		return status;
	}

	public boolean clickOnAlertWithOkButtonToDisplay() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start clickOnAlertWithOkButtonToDisplay method");

		boolean status = false;

		try {
			if (this.isElementVisibleByXPath(ALERT_WITH_OK_BUTTON_TO_DISPLAY_THE_ALERT_XPATH)) {
				this.getElementByXPath(ALERT_WITH_OK_BUTTON_TO_DISPLAY_THE_ALERT_XPATH).click();
				Alert alert = driver.switchTo().alert();
				Thread.sleep(3000);
				alert.accept();
				Thread.sleep(3000);
				status = true;
			}
		} catch (UnhandledAlertException e) {
			log.warn(e);
		} catch (InterruptedException e) {
			log.warn(e);
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End clickOnAlertWithOkButtonToDisplay method");

		return status;
	}

	public boolean clickOnAlertWithTextBox() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnAlertWithTextBox method");

		boolean status = false;

		if (this.isElementVisibleByXPath(ALERT_WITH_TEXTBOX_OPTION_XPATH)) {
			this.getElementByXPath(ALERT_WITH_TEXTBOX_OPTION_XPATH).click();
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnAlertWithTextBox method");

		return status;
	}

	public boolean clickOnAlertWithTextBoxButtonToDisplay(String message) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start clickOnAlertWithTextBoxButtonToDisplay method");

		boolean status = false;

		try {
			if (this.isElementVisibleByXPath(ALERT_WITH_TEXTBOX_TO_DISPLAY_THE_ALERT_XPATH)) {
				this.getElementByXPath(ALERT_WITH_TEXTBOX_TO_DISPLAY_THE_ALERT_XPATH).click();
				Alert alert = driver.switchTo().alert();
				Thread.sleep(3000);
				alert.sendKeys(message);
				Thread.sleep(2000);
				alert.accept();
				Thread.sleep(3000);
				status = true;
			}
		} catch (UnhandledAlertException e) {
			log.warn(e);
		} catch (InterruptedException e) {
			log.warn(e);
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End clickOnAlertWithTextBoxButtonToDisplay method");

		return status;
	}

	public boolean clickOnAlertWithOkAndCancel() {
		log.info(
				"[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnAlertWithOkAndCancel method");

		boolean status = false;

		if (this.isElementVisibleByXPath(ALERT_WITH_OK_AND_CANCEL_OPTION_XPATH)) {
			this.getElementByXPath(ALERT_WITH_OK_AND_CANCEL_OPTION_XPATH).click();
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnAlertWithOkAndCancel method");

		return status;
	}

	public boolean clickOnAlertWithOkButtonToDisplay(String option) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start clickOnAlertWithOkButtonToDisplay method");

		boolean status = false;

		try {
			if (this.isElementVisibleByXPath(ALERT_WITH_OK_AND_CANCEL_TO_DISPLAY_THE_ALERT_XPATH)) {
				this.getElementByXPath(ALERT_WITH_OK_AND_CANCEL_TO_DISPLAY_THE_ALERT_XPATH).click();
				Alert alert = driver.switchTo().alert();
				if (option.equals("ok")) {
					Thread.sleep(3000);
					alert.accept();
					status = true;
				}
				if (option.equals("cancel")) {
					Thread.sleep(3000);
					alert.dismiss();
					status = true;
				}

			}
		} catch (UnhandledAlertException e) {
			log.warn(e);
		} catch (InterruptedException e) {
			log.warn(e);
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End clickOnAlertWithOkButtonToDisplay method");

		return status;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}
}

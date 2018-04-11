package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JqueryResizablePage extends BasePageObject {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(JqueryResizablePage.class);

	/*
	 * Key Selectors
	 */

	private static final String IFRAME_XPATH = "iframeResizableXPATH";
	private static final String RESIZABLE_BUTTON = "resizableButtonXPATH";

	public JqueryResizablePage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");
		boolean status = this.isElementVisibleByXPath(IFRAME_XPATH);
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");
		return status;
	}

	public boolean resizeTheItemByActions() throws InterruptedException {
		boolean status = false;
		log.info(
				"[log-PageObjects] " + this.getClass().getSimpleName() + " - Start dragAndDropTheItemByActions method");

		if (this.isElementVisibleByXPath(IFRAME_XPATH)) {

			WebElement frame = this.getElementByXPath(IFRAME_XPATH);
			driver.switchTo().frame(frame);
			WebElement button = this.getElementByXPath(RESIZABLE_BUTTON);

			// Using dragAndDropBy
			new Actions(driver).dragAndDropBy(button, 250, 250).build().perform();
			Thread.sleep(3000);

			// Using clickAndHold
			new Actions(driver).clickAndHold(button).moveByOffset(-100, -100).release().perform();
			Thread.sleep(3000);

			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End dragAndDropTheItemByActions method");
		return status;
	}

}

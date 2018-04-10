package com.emergya.pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class ToolsQaIframesPage extends BasePageObject {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(ToolsQaIframesPage.class);

	/*
	 * String Keys Selectors
	 */

	private static final String UNIQUE_SELECTOR_OF_THE_PAGE = "uniqueSelector";
	private static final String IFRAME1 = "iFrame1";

	private static final String ELEMENT_ON_DEFAULT_IFRAME = "elementOnDefaultIframe";
	private static final String ELEMENT_ON_IFRAME_NUMBER_0 = "elementOnIframeNumber0";
	private static final String ELEMENT_ON_IFRAME_NUMBER_1 = "elementOnIframeNumber1";

	public ToolsQaIframesPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");
		boolean status = false;

		if (this.isElementVisibleByXPath(UNIQUE_SELECTOR_OF_THE_PAGE))
			status = true;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");
		return status;
	}

	public void checkVisibilityOfThe3Elements() {

		this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		boolean elementOndefaultIsVisible = false;
		boolean elementOnIframe1IsVisible = false;
		boolean elementOnIframe2IsVisible = false;

		if (this.isElementVisibleByXPath(ELEMENT_ON_DEFAULT_IFRAME))
			elementOndefaultIsVisible = true;

		if (this.isElementVisibleByXPath(ELEMENT_ON_IFRAME_NUMBER_0))
			elementOnIframe1IsVisible = true;

		if (this.isElementVisibleByXPath(ELEMENT_ON_IFRAME_NUMBER_1))
			elementOnIframe2IsVisible = true;

		log.info("CHECKING THE VISIBILITY OF THE 3 ELEMENTS ...");
		if (elementOndefaultIsVisible)
			log.info("ELEMENT ON DEFAULT FRAME: VISIBLE");
		else {
			log.info("ELEMENT ON DEFAULT FRAME: NOT VISIBLE");
		}
		if (elementOnIframe1IsVisible)
			log.info("ELEMENT ON FRAME 0: VISIBLE");
		else {
			log.info("ELEMENT ON FRAME 0: NOT VISIBLE");
		}
		if (elementOnIframe2IsVisible)
			log.info("ELEMENT ON FRAME 1: VISIBLE");
		else {
			log.info("ELEMENT ON FRAME 1: NOT VISIBLE");
		}
	}

	public void switchToIframeNumber0ByPassingAnInteger(int numberOfIframe) {
		driver.switchTo().frame(numberOfIframe);
		log.info("SWITCHED TO IFRAME 0");

	}

	public void switchToIframeNumber1ByPassingAString(String iframeStringIdentificator) {
		driver.switchTo().frame(iframeStringIdentificator);
	}

	public void switchToIframeNumber0ByUsingTheIframeWebElement() {
		if (this.isElementVisibleById(IFRAME1)) {
			driver.switchTo().frame(IFRAME1);
			log.info("SWITCHED TO IFRAME 1");
		}
	}

	public void switchToDefaultIframe() {
		driver.switchTo().defaultContent();
		log.info("I AM ON DEFAULT IFRAME");
	}
}

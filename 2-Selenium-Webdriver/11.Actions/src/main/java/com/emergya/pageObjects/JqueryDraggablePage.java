package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JqueryDraggablePage extends BasePageObject {

	/**
	 * INDIRECT SELECTORS, BY PROPERTIES FILE
	 */

	private static final String IFRAME_XPATH = "iframeDraggableXPATH";

	/**
	 * DIRECT SELECTOS, NO PROPERTIES FILE USED
	 */

	private static final String ITEM_FOR_DRAG_ID = "draggable";

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(JqueryDraggablePage.class);

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public JqueryDraggablePage(EmergyaWebDriver driver) {
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

	public boolean dragTheItemByActions() throws InterruptedException {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start dragTheItem method");

		if (this.isElementVisibleByXPath(IFRAME_XPATH)) {
			Actions action = new Actions(driver);

			WebElement frame = this.getElementByXPath(IFRAME_XPATH);
			driver.switchTo().frame(frame);
			WebElement draggableItem = driver.findElementById(ITEM_FOR_DRAG_ID);

			action.clickAndHold(draggableItem).moveByOffset(100, 100).release().build().perform();
			Thread.sleep(5000);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End dragTheItem method");
		return status;
	}

}

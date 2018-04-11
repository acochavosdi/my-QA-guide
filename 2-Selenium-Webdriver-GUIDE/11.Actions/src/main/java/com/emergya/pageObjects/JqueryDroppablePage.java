package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JqueryDroppablePage extends BasePageObject {

	/**
	 * INDIRECT SELECTORS, BY PROPERTIES FILE
	 */

	private static final String IFRAME_XPATH = "iframeDroppableXPATH";
	private static final String ITEM_DRAGGABLE_ID = "itemForDragID";
	private static final String ITEM_DROPPABLE_ID = "itemWhereToDrop";

	/**
	 * DIRECT SELECTOS, NO PROPERTIES FILE USED
	 */

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(JqueryDroppablePage.class);

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public JqueryDroppablePage(EmergyaWebDriver driver) {
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

	public boolean dragAndDropTheItemByActions() throws InterruptedException {
		boolean status = false;
		log.info(
				"[log-PageObjects] " + this.getClass().getSimpleName() + " - Start dragAndDropTheItemByActions method");

		if (this.isElementVisibleByXPath(IFRAME_XPATH)) {

			Actions action = new Actions(driver);

			WebElement frame = this.getElementByXPath(IFRAME_XPATH);
			driver.switchTo().frame(frame);

			WebElement draggableItem = this.getElementById(ITEM_DRAGGABLE_ID);
			WebElement droppableItem = this.getElementById(ITEM_DROPPABLE_ID);

			action.dragAndDrop(draggableItem, droppableItem).build().perform();

			Thread.sleep(5000);
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End dragAndDropTheItemByActions method");
		return status;
	}

}

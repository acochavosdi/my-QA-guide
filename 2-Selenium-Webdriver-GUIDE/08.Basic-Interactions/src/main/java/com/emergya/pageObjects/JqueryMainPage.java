package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private static final String BUTTON_TO_DRAGGABLE_PAGE = "buttonToDraggablePage";
	private static final String SEARCH_INPUT = "searchInput";
	private static final String DRAGGABLE_PERMALINK = "draggablePagePermalink";
	private static final String SEARCH_SUBMIT_BUTTON = "searchSubmitButton";

	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = false;
		if (this.isElementVisibleById(UNIQUE_ELEMENT_OF_INDEX_PAGE))
			status = true;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public JqueryDraggablePage clickOnDraggablePageLink() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnDraggablePageLink method");

		if (this.isElementVisibleByXPath(BUTTON_TO_DRAGGABLE_PAGE)) {
			this.getElementByXPath(BUTTON_TO_DRAGGABLE_PAGE).click();
			return new JqueryDraggablePage(driver);
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnDraggablePageLink method");

		return null;
	}

	public void searchStringOnSearchInput(String string) throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start searchStringOnSearchInput method");

		if (this.isElementVisibleByXPath(SEARCH_INPUT)) {

			WebElement searchInput = this.getElementByXPath(SEARCH_INPUT);
			searchInput.sendKeys(string);
			log.warn("COSA1");
			// Similar to Thread.sleep(miliseconds), but driver.sleep(seconds) is in seconds
			driver.sleep(3);
			log.warn("COSA2");
			driver.clickIfExists(By.xpath(getXPath(SEARCH_SUBMIT_BUTTON)));

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End searchStringOnSearchInput method");
	}

	public JqueryDraggablePage waitUntilTheResultWeWantAndClickOnIt() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start waitUntilTheResultWeWantAndClickOnIt method");

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement draggablePermalink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getXPath(DRAGGABLE_PERMALINK))));

		if (draggablePermalink.isDisplayed()) {
			draggablePermalink.click();
			return new JqueryDraggablePage(driver);
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End waitUntilTheResultWeWantAndClickOnIt method");

		return null;

	}
}

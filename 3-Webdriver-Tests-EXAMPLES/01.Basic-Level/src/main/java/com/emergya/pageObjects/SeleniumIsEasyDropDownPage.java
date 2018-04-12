package com.emergya.pageObjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SeleniumIsEasyDropDownPage extends BasePageObject {

	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(SeleniumIsEasyDropDownPage.class);

	/*
	 * String Selector Keys
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH = "uniqueElement";
	private static final String SELECT_LIST_SELECT_ID = "selectListDemoSelect";
	private static final String SELECT_LIST_DISPLAY_XPATH = "selectListDemoDisplay";
	private static final String MULTI_SELECT_FIRST_SELECTED_BUTTON_ID = "multiSelectFirstSelectedButton";
	private static final String MULTI_SELECT_GET_ALL_SELECTED_BUTTON_ID = "multiSelectGetAllSelectedButton";
	private static final String MULTI_SELECT_DISPLAY_XPATH = "multiSelectDisplay";
	private static final String ELEMENT_CALIFORNIA = "elementCalifornia";
	private static final String ELEMENT_FLORIDA = "elementFlorida";
	private static final String ELEMENT_OHIO = "elementOhio";

	public SeleniumIsEasyDropDownPage(EmergyaWebDriver driver) {
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

	public boolean isSelectListWorkingWithThisArg(String day) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isSelectListWorkingWithThisArg method");

		boolean status = false;

		if (this.isElementVisibleById(SELECT_LIST_SELECT_ID)) {

			Select select = new Select(this.getElementById(SELECT_LIST_SELECT_ID));
			select.selectByValue(day);

			if (this.isElementVisibleByXPath(SELECT_LIST_DISPLAY_XPATH)) {
				if (this.getElementByXPath(SELECT_LIST_DISPLAY_XPATH).getText().contains(day))
					status = true;
			}

		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isSelectListWorkingWithThisArg method");

		return status;
	}

	public boolean isMultiSelectWorkingCorrectly() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isMultiSelectWorkingCorrectly method");

		WebElement element1 = this.getElementByXPath(ELEMENT_CALIFORNIA);
		WebElement element2 = this.getElementByXPath(ELEMENT_FLORIDA);
		WebElement element3 = this.getElementByXPath(ELEMENT_OHIO);

		ArrayList<String> elements = new ArrayList<>();
		elements.add(element1.getText());
		elements.add(element2.getText());
		elements.add(element3.getText());

		// SELECTING FIELDS
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3)
				.keyUp(Keys.CONTROL).build();
		seriesOfActions.perform();

		// FIRST SELECTED TEST
		boolean statusOfFirstTest = false;
		this.getElementById(MULTI_SELECT_FIRST_SELECTED_BUTTON_ID).click();
		if (this.getElementByXPath(MULTI_SELECT_DISPLAY_XPATH).getText().contains(element1.getText())) {
			statusOfFirstTest = true;
		}
		driver.sleep(3);

		// GET ALL SELECTED TEST
		boolean statusOfSecondTest = false;
		this.getElementById(MULTI_SELECT_GET_ALL_SELECTED_BUTTON_ID).click();
		boolean aux = true;
		for (String string : elements) {
			if (this.getElementByXPath(MULTI_SELECT_DISPLAY_XPATH).getText().contains(string)) {
				if (aux) {
					statusOfSecondTest = true;
				} else {
					aux = false;
				}
			} else {
				aux = false;
			}
		}
		driver.sleep(3);
		log.info(
				"[log-PageObjects] " + this.getClass().getSimpleName() + " - End isMultiSelectWorkingCorrectly method");
		return statusOfFirstTest && statusOfSecondTest;
	}

}

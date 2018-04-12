package com.emergya.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.google.common.collect.Lists;

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
	private static final String MULTI_SELECT_SELECT_ID = "multiSelectListDemoSelect";
	private static final String MULTI_SELECT_FIRST_SELECTED_BUTTON_ID = "multiSelectFirstSelectedButton";
	private static final String MULTI_SELECT_GET_ALL_SELECTED_BUTTON_ID = "multiSelectGetAllSelectedButton";
	private static final String MULTI_SELECT_DISPLAY_XPATH = "multiSelectDisplay";

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

	public boolean isFirstSelectedButtonWorkingCorrectly() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isFirstSelectedButtonWorkingCorrectly method");
		boolean status = false;

		if (this.isElementVisibleById(MULTI_SELECT_SELECT_ID)) {

			Select select = new Select(this.getElementById(MULTI_SELECT_SELECT_ID));

			select.selectByValue("California");
			select.selectByValue("Florida");
			select.selectByValue("Ohio");

			if (this.isElementVisibleById(MULTI_SELECT_FIRST_SELECTED_BUTTON_ID)) {
				this.getElementById(MULTI_SELECT_FIRST_SELECTED_BUTTON_ID).click();

				if (this.isElementVisibleByXPath(MULTI_SELECT_DISPLAY_XPATH)) {
					if (this.getElementByXPath(MULTI_SELECT_DISPLAY_XPATH).getText()
							.contains(select.getFirstSelectedOption().getText())) {
						log.info("VALUE OF FIRSTSELECTIONOPTION METHOD: " + select.getFirstSelectedOption().getText());
						log.info("VALUE OF DISPLAY: " + this.getElementByXPath(MULTI_SELECT_DISPLAY_XPATH).getText());
						status = true;
					} else {
						log.info("VALUE OF FIRSTSELECTIONOPTION METHOD: " + select.getFirstSelectedOption().getText());
						log.info("VALUE OF DISPLAY: " + this.getElementByXPath(MULTI_SELECT_DISPLAY_XPATH).getText());
						status = false;
					}
				}
			}

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isFirstSelectedButtonWorkingCorrectly method");
		return status;
	}

	public boolean isGetAllSelectedButtonWorkingCorrectly() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isGetAllSelectedButtonWorkingCorrectly method");
		boolean status = false;

		if (this.isElementVisibleById(MULTI_SELECT_SELECT_ID)) {

			Select select = new Select(this.getElementById(MULTI_SELECT_SELECT_ID));

			select.selectByValue("California");
			select.selectByValue("Florida");
			select.selectByValue("Ohio");

			if (this.isElementVisibleById(MULTI_SELECT_GET_ALL_SELECTED_BUTTON_ID)) {
				this.getElementById(MULTI_SELECT_GET_ALL_SELECTED_BUTTON_ID).click();
			}

			if (this.isElementVisibleByXPath(MULTI_SELECT_DISPLAY_XPATH)) {
				List<WebElement> elementsList = select.getAllSelectedOptions();
				boolean aux = true;

				for (WebElement webElement : elementsList) {
					if (this.getElementByXPath(MULTI_SELECT_DISPLAY_XPATH).getText().contains(webElement.getText())) {
						if (aux) {
							aux = true;
						} else {
							aux = false;
						}
					} else {
						aux = false;
					}
				}
				if (aux) {
					status = true;
				}
			}

		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isGetAllSelectedButtonWorkingCorrectlys method");
		return status;
	}
}

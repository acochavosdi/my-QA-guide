package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SeleniumIsEasyCheckBoxPage extends BasePageObject {
	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(SeleniumIsEasyCheckBoxPage.class);

	/*
	 * String Selector Keys
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH = "uniqueElement";
	private static final String SINGLE_CHECK_BOX_INPUT_ID = "singleCheckBoxInput";
	private static final String SINGLE_CHECK_BOX_CHECKER_DIV_ID = "singleCheckBoxCheckerDiv";

	private static final String MULTIPLE_CHECK_BOX_INPUT1_XPATH = "multiplCheckBoxInput1";
	private static final String MULTIPLE_CHECK_BOX_INPUT2_XPATH = "multiplCheckBoxInput2";
	private static final String MULTIPLE_CHECK_BOX_INPUT3_XPATH = "multiplCheckBoxInput3";
	private static final String MULTIPLE_CHECK_BOX_INPUT4_XPATH = "multiplCheckBoxInput4";
	private static final String MULTIPLE_CHECK_BOX_BUTTON_ID = "multipleCheckBoxButton";

	public SeleniumIsEasyCheckBoxPage(EmergyaWebDriver driver) {
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

	/*
	 * Click on the Single Check Box
	 */
	public boolean clickOnTheSingleCheckBox() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnTheSingleCheckBox method");

		boolean status = false;

		if (this.isElementVisibleById(SINGLE_CHECK_BOX_INPUT_ID)) {
			this.getElementById(SINGLE_CHECK_BOX_INPUT_ID).click();
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnTheSingleCheckBox method");

		return status;
	}

	/**
	 * Print the status of the checkbox.
	 */
	public void printStatusOfTheCheckBox() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start printStatusOfTheCheckBox method");

		if (this.isElementVisibleById(SINGLE_CHECK_BOX_CHECKER_DIV_ID)) {
			log.info("Checkbox is clicked");
		} else {
			log.info("Checkbox is not clicked");
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End printStatusOfTheCheckBox method");

	}

	/**
	 * click on the button specified on "@param". Values: 1,2,3 or 4
	 * 
	 * @param index,
	 *            the index of the button to click
	 */
	public void clickOnMultipleCheckBoxInputNumber(int index) {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start clickOnMultipleCheckBoxInputNumber method");

		switch (index) {
		case 1:
			if (this.isElementVisibleByXPath(MULTIPLE_CHECK_BOX_INPUT1_XPATH))
				this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT1_XPATH).click();
			break;

		case 2:
			if (this.isElementVisibleByXPath(MULTIPLE_CHECK_BOX_INPUT2_XPATH))
				this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT2_XPATH).click();
			break;

		case 3:
			if (this.isElementVisibleByXPath(MULTIPLE_CHECK_BOX_INPUT3_XPATH))
				this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT3_XPATH).click();
			break;

		case 4:
			if (this.isElementVisibleByXPath(MULTIPLE_CHECK_BOX_INPUT4_XPATH))
				this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT4_XPATH).click();
			break;

		default:
			log.error("Argument passed to this method incorrect, must be 1,2,3 or 4");
			break;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End clickOnMultipleCheckBoxInputNumber method");

	}

	/**
	 * Click on the Multiple Check Box Button
	 */
	public void clickOnMultipleCheckBoxButton() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start clickOnMultipleCheckBoxButton method");

		if (this.isElementVisibleById(MULTIPLE_CHECK_BOX_BUTTON_ID))
			this.getElementById(MULTIPLE_CHECK_BOX_BUTTON_ID).click();

		log.info(
				"[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnMultipleCheckBoxButton method");
	}

	/**
	 * 
	 * @return true if UncheckAll Button is only displayed when 4 inputs are
	 *         selected
	 */
	public boolean isButtonUncheckAllOnlyDisplayedWhen4InputsAreSelected() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isButtonUncheckAllOnlyDisplayedWhen4InputsAreSelected method");
		boolean status = false;

		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		if (this.isTheButtonUncheckAllDisplayed())
			status = false;
		this.clickOnMultipleCheckBoxInputNumber(1);
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		if (!this.isTheButtonUncheckAllDisplayed())
			status = false;
		this.clickOnMultipleCheckBoxInputNumber(2);
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		if (!this.isTheButtonUncheckAllDisplayed())
			status = false;
		this.clickOnMultipleCheckBoxInputNumber(3);
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		if (!this.isTheButtonUncheckAllDisplayed())
			status = false;
		this.clickOnMultipleCheckBoxInputNumber(4);
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		if (this.isTheButtonUncheckAllDisplayed())
			status = true;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isButtonUncheckAllOnlyDisplayedWhen4InputsAreSelected method");
		return status;
	}

	/**
	 * 
	 * @return true if UncheckAllButtons deselect every input
	 */
	public boolean isUncheckAllButtonDeselectingEveryInput() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isUncheckAllButtonDeselectingEveryInput method");
		boolean status = false;

		this.clickOnMultipleCheckBoxButton();
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		WebElement checkBox1 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT1_XPATH, 3);
		WebElement checkBox2 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT2_XPATH, 3);
		WebElement checkBox3 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT3_XPATH, 3);
		WebElement checkBox4 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT4_XPATH, 3);

		if (!(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected()))
			status = true;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isUncheckAllButtonDeselectingEveryInput method");
		return status;
	}

	/**
	 * 
	 * @return true if 'Check All' button select every input
	 */
	public boolean isCheckAllButtonSelectingAllInputs() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isCheckAllButtonSelectingAllInputs method");
		boolean status = false;

		WebElement checkBox1 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT1_XPATH, 3);
		WebElement checkBox2 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT2_XPATH, 3);
		WebElement checkBox3 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT3_XPATH, 3);
		WebElement checkBox4 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT4_XPATH, 3);

		this.clickOnMultipleCheckBoxInputNumber(2);
		this.clickOnMultipleCheckBoxInputNumber(3);
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();
		this.clickOnMultipleCheckBoxButton();
		this.printInfoAboutTheCheckBoxesAndTheButtonStatus();

		if (checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected())
			status = true;

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isCheckAllButtonSelectingAllInputs method");
		return status;
	}

	/**
	 * Print the status of the inputs and what button is displayed at the moment
	 */
	public void printInfoAboutTheCheckBoxesAndTheButtonStatus() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start clickOnMultipleCheckBoxInputNumber method");

		WebElement checkBox1 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT1_XPATH, 3);
		WebElement checkBox2 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT2_XPATH, 3);
		WebElement checkBox3 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT3_XPATH, 3);
		WebElement checkBox4 = this.getElementByXPath(MULTIPLE_CHECK_BOX_INPUT4_XPATH, 3);
		WebElement button = this.getElementById(MULTIPLE_CHECK_BOX_BUTTON_ID, 3);

		if (checkBox1.isSelected())
			log.info("Box 1 Active");
		else
			log.info("Box 1 Not Active");

		if (checkBox2.isSelected())
			log.info("Box 2 Active");
		else
			log.info("Box 2 Not Active");

		if (checkBox3.isSelected())
			log.info("Box 3 Active");
		else
			log.info("Box 3 Not Active");

		if (checkBox4.isSelected())
			log.info("Box 4 Active");
		else
			log.info("Box 4 Not Active");

		if (button.getAttribute("value").equals("Uncheck All"))
			log.info("Button displayed is Uncheck All");
		else
			log.info("Button displayed is Check All");
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End clickOnMultipleCheckBoxInputNumber method");
	}

	/**
	 * 
	 * @return true if the button "Uncheck All" is displayed
	 */
	public boolean isTheButtonUncheckAllDisplayed() {

		WebElement button = this.getElementById(MULTIPLE_CHECK_BOX_BUTTON_ID, 3);
		boolean status = false;
		if (button.getAttribute("value").equals("Uncheck All"))
			status = true;

		return status;
	}
}

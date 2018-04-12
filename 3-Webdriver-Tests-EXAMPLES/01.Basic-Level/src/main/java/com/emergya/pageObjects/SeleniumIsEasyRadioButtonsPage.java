package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SeleniumIsEasyRadioButtonsPage extends BasePageObject {

	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(SeleniumIsEasyRadioButtonsPage.class);

	/*
	 * String Selector Keys
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE_XPATH = "uniqueElement";
	private static final String SINGLE_RADIO_BUTTON_MALE_INPUT_XPATH = "singleRadioButtonMale";
	private static final String SINGLE_RADIO_BUTTON_FEMALE_INPUT_XPATH = "singleRadioButtonFemale";
	private static final String SINGLE_RADIO_BUTTON_CHECKED_VALUE_BUTTON_ID = "singleRadioButtonGetCheckedValueButton";
	private static final String SINGLE_RADIO_BUTTON_DISPLAY_XPATH = "singleRadioButtonDisplayParagraph";
	private static final String GROUP_RADIO_BUTTON_MALE_INPUT_XPATH = "groupRadioButtonMaleInput";
	private static final String GROUP_RADIO_BUTTON_FEMALE_INPUT_XPATH = "groupRadioButtonFemaleInput";
	private static final String GROUP_RADIO_BUTTON_RANGE1_INPUT_XPATH = "groupRadioButtonRange1";
	private static final String GROUP_RADIO_BUTTON_RANGE2_INPUT_XPATH = "groupRadioButtonRange2";
	private static final String GROUP_RADIO_BUTTON_RANGE3_INPUT_XPATH = "groupRadioButtonRange3";
	private static final String GROUP_RADIO_BUTTON_GET_VALUES_BUTTON_XPATH = "groupRadioButtonGetValuesButton";
	private static final String GROUP_RADIO_BUTTON_DISPLAY_XPATH = "groupRadioButtonDisplay";

	public SeleniumIsEasyRadioButtonsPage(EmergyaWebDriver driver) {
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

	public boolean isSingleRadioButtonWorkingWithMale() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isSingleRadioButtonWorkingWithMale method");

		String correctDisplayedString = "Radio button 'Male' is checked";

		boolean status = false;

		// Clicking on Male
		if (this.isElementVisibleByXPath(SINGLE_RADIO_BUTTON_MALE_INPUT_XPATH)) {
			this.getElementByXPath(SINGLE_RADIO_BUTTON_MALE_INPUT_XPATH).click();

			// Clicking on the button to show the display
			if (this.isElementVisibleById(SINGLE_RADIO_BUTTON_CHECKED_VALUE_BUTTON_ID)) {
				this.getElementById(SINGLE_RADIO_BUTTON_CHECKED_VALUE_BUTTON_ID).click();

				// Checking Display
				if (this.isElementVisibleByXPath(SINGLE_RADIO_BUTTON_DISPLAY_XPATH)) {
					if (this.getElementByXPath(SINGLE_RADIO_BUTTON_DISPLAY_XPATH).getText()
							.equals(correctDisplayedString)) {
						status = true;
					}
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isSingleRadioButtonWorkingWithMale method");

		return status;
	}

	public boolean isSingleRadioButtonWorkingWithFemale() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isSingleRadioButtonWorkingWithFemale method");

		String correctDisplayedString = "Radio button 'Female' is checked";

		boolean status = false;

		// Clicking on Male
		if (this.isElementVisibleByXPath(SINGLE_RADIO_BUTTON_FEMALE_INPUT_XPATH)) {
			this.getElementByXPath(SINGLE_RADIO_BUTTON_FEMALE_INPUT_XPATH).click();

			// Clicking on the button to show the display
			if (this.isElementVisibleById(SINGLE_RADIO_BUTTON_CHECKED_VALUE_BUTTON_ID)) {
				this.getElementById(SINGLE_RADIO_BUTTON_CHECKED_VALUE_BUTTON_ID).click();

				// Checking Display
				if (this.isElementVisibleByXPath(SINGLE_RADIO_BUTTON_DISPLAY_XPATH)) {
					if (this.getElementByXPath(SINGLE_RADIO_BUTTON_DISPLAY_XPATH).getText()
							.equals(correctDisplayedString)) {
						status = true;
					}
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isSingleRadioButtonWorkingWithFemale method");

		return status;
	}

	public boolean isRadioButtonsWorkingWithValues(String genre, String range) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start isRadioButtonsWorkingWithValues method");
		boolean status = false;

		String currentGenreSelector;
		String currentRangeSelector;
		String correctDisplayTextUsingGenre;
		String correctDisplayTextUsingRange;

		switch (genre) {
		case "male":
			currentGenreSelector = GROUP_RADIO_BUTTON_MALE_INPUT_XPATH;
			correctDisplayTextUsingGenre = "Sex : Male";
			break;

		case "female":
			currentGenreSelector = GROUP_RADIO_BUTTON_FEMALE_INPUT_XPATH;
			correctDisplayTextUsingGenre = "Sex : Female";
			break;
		default:
			return false;
		}

		switch (range) {
		case "range1":
			currentRangeSelector = GROUP_RADIO_BUTTON_RANGE1_INPUT_XPATH;
			correctDisplayTextUsingRange = "Age group: 0 - 5";
			break;

		case "range2":
			currentRangeSelector = GROUP_RADIO_BUTTON_RANGE2_INPUT_XPATH;
			correctDisplayTextUsingRange = "Age group: 5 - 15";
			break;

		case "range3":
			currentRangeSelector = GROUP_RADIO_BUTTON_RANGE3_INPUT_XPATH;
			correctDisplayTextUsingRange = "Age group: 15 - 50";
			break;
		default:
			return false;
		}

		if (this.isElementVisibleByXPath(currentGenreSelector)) {
			this.getElementByXPath(currentGenreSelector).click();

			if (this.isElementVisibleByXPath(currentGenreSelector)) {
				this.getElementByXPath(currentRangeSelector).click();

				if (this.isElementVisibleByXPath(GROUP_RADIO_BUTTON_GET_VALUES_BUTTON_XPATH)) {
					this.getElementByXPath(GROUP_RADIO_BUTTON_GET_VALUES_BUTTON_XPATH).click();

					if (this.isElementVisibleByXPath(GROUP_RADIO_BUTTON_DISPLAY_XPATH)) {
						WebElement display = this.getElementByXPath(GROUP_RADIO_BUTTON_DISPLAY_XPATH);

						if (display.getText().contains(correctDisplayTextUsingGenre)
								&& display.getText().contains(correctDisplayTextUsingRange)) {
							status = true;
						}
					}
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End isRadioButtonsWorkingWithValues method");
		return status;
	}
}

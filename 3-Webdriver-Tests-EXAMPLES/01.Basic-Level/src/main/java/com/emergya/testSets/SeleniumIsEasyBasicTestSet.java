package com.emergya.testSets;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.SeleniumIsEasyCheckBoxPage;
import com.emergya.pageObjects.SeleniumIsEasyDropDownPage;
import com.emergya.pageObjects.SeleniumIsEasyRadioButtonsPage;
import com.emergya.pageObjects.SeleniumIsEasySimpleFormPage;
import com.emergya.pageObjects.SeleniumIsEasyTestPage;
import com.emergya.utils.BasicTestSet;

public class SeleniumIsEasyBasicTestSet extends BasicTestSet {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(SeleniumIsEasyBasicTestSet.class);

	/*
	 * Constants
	 */

	// URLS
	private static final String SELENIUM_IS_EASY_INDEX_URL = "http://www.seleniumeasy.com/test/";

	// DATA CONSTANTS
	private static final String MESSAGE_TO_SIMPLE_FORM_SINGLE_INPUT = "Hi Mr.QA";
	private static final String VALUE_A = "3";
	private static final String VALUE_B = "4";

	public SeleniumIsEasyBasicTestSet() {
		super();
	}

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// ************************ FULL TEST SET *********************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00001 - Simple Form Demo Section -------------------- //
	// ------ US00002 - Check Box Demo Section ---------------------- //
	// ------ US00003 - Radio Buttons Demo Section ------------------ //
	// ------ US00004 - DropDown Demo Section ----------------------- //
	// ------ US00005 - Javascript Alerts Demo Section -------------- //
	// ------ US00006 - Windows PopUp Modal Demo Section ------------ //
	// ------ US00007 - Bootstrap Alerts Demo Section --------------- //
	// ------ US00008 - Bootstrap Modals Demo Section --------------- //
	// -------------------------------------------------------------- //
	// -------------------------------------------------------------- //
	// -------------------------------------------------------------- //

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00001 - Simple Form Demo Section -------------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - TODO
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "simpleFormTest")
	public void simpleFormTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		SeleniumIsEasyTestPage seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver);
		assertTrue(seleniumIsEasyTestPage.isReady(), "Index page not ready");

		SeleniumIsEasySimpleFormPage seleniumIsEasySimpleFormPage = seleniumIsEasyTestPage.goToTheSimpleFormPage();

		/*
		 * Single input Section
		 * 
		 * - Write on the input
		 * 
		 * - Press the Button
		 * 
		 * - Check if the returned message is equals to the sent message
		 */

		assertTrue(seleniumIsEasySimpleFormPage.writeOnTheSingleInput(MESSAGE_TO_SIMPLE_FORM_SINGLE_INPUT),
				"Missed input field");
		assertTrue(seleniumIsEasySimpleFormPage.clickOnShowMessage(), "Button show message not found");
		assertEquals(seleniumIsEasySimpleFormPage.getTheReturnedMessage(), MESSAGE_TO_SIMPLE_FORM_SINGLE_INPUT,
				"messages didnt match");
		/*
		 * Two input Section
		 * 
		 * - Write on Both inputs
		 * 
		 * - Press the Button
		 * 
		 * - Check if the returned total is equals to the sum of both sent values
		 */

		int number1 = Integer.parseInt(VALUE_A);
		int number2 = Integer.parseInt(VALUE_B);
		int sum = number1 + number2;

		assertTrue(seleniumIsEasySimpleFormPage.writeValueOfA(VALUE_A), "Input for value a not found");
		assertTrue(seleniumIsEasySimpleFormPage.writeValueOfB(VALUE_B), "Input for value b not found");
		assertTrue(seleniumIsEasySimpleFormPage.clickOnGetTotal(), "Button Get Total not found");
		assertEquals(Integer.parseInt(seleniumIsEasySimpleFormPage.getTheReturnedTotal()), sum,
				"Returned Total not match");

		driver.sleep(5);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00002 - Check Box Demo Section ---------------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - TODO
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "checkBoxTest")
	public void checkBoxTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		SeleniumIsEasyTestPage seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver);
		assertTrue(seleniumIsEasyTestPage.isReady(), "Index page not ready");

		SeleniumIsEasyCheckBoxPage seleniumIsEasyCheckBoxPage = seleniumIsEasyTestPage.goToTheCheckBoxPage();

		/*
		 * Single Check Box - Using the visibility of the div to check if selected.
		 */

		assertTrue(seleniumIsEasyCheckBoxPage.clickOnTheSingleCheckBox(), "Check Box not found");
		seleniumIsEasyCheckBoxPage.printStatusOfTheCheckBox();
		driver.sleep(2);
		assertTrue(seleniumIsEasyCheckBoxPage.clickOnTheSingleCheckBox(), "Check Box not found");
		seleniumIsEasyCheckBoxPage.printStatusOfTheCheckBox();
		driver.sleep(2);

		/*
		 * Multiple Check Box - Using isSelected() method.
		 */

		// Testing if Uncheck All only apperas when 4 inputs selected
		assertTrue(seleniumIsEasyCheckBoxPage.isButtonUncheckAllOnlyDisplayedWhen4InputsAreSelected(),
				"Uncheck All Button not working as client desire");

		// Testing if the Uncheck All uncheck all the inputs
		assertTrue(seleniumIsEasyCheckBoxPage.isUncheckAllButtonDeselectingEveryInput(),
				"Uncheck All Button didnt deselect the inputs");

		// Testing if the Check All check all the inputs
		assertTrue(seleniumIsEasyCheckBoxPage.isCheckAllButtonSelectingAllInputs(),
				"Check All Button didnt selected the inputs");

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00003 - Radio Buttons Demo Section ------------------ //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "radioButtonTest")
	public void radioButtonTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		SeleniumIsEasyTestPage seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver);
		assertTrue(seleniumIsEasyTestPage.isReady(), "Index page not ready");

		SeleniumIsEasyRadioButtonsPage seleniumIsEasyRadioButtonsPage = seleniumIsEasyTestPage
				.goToTheRadioButtonsPage();

		/*
		 * SINGLE RADIO BUTTON DEMO
		 */

		assertTrue(seleniumIsEasyRadioButtonsPage.isSingleRadioButtonWorkingWithMale(),
				"Single Radio Button not working well with male option");
		driver.sleep(2);
		assertTrue(seleniumIsEasyRadioButtonsPage.isSingleRadioButtonWorkingWithFemale(),
				"Single Radio Button not working well with female option");
		driver.sleep(2);

		/*
		 * GROUP RADIO BUTTONS DEMO
		 */

		assertTrue(seleniumIsEasyRadioButtonsPage.isRadioButtonsWorkingWithValues("male", "range1"),
				"Group radio button failed with male + range 0-5");
		assertTrue(seleniumIsEasyRadioButtonsPage.isRadioButtonsWorkingWithValues("male", "range2"),
				"Group radio button failed with male + range 5-15");
		assertTrue(seleniumIsEasyRadioButtonsPage.isRadioButtonsWorkingWithValues("male", "range3"),
				"Group radio button failed with male + range 15-50");
		assertTrue(seleniumIsEasyRadioButtonsPage.isRadioButtonsWorkingWithValues("female", "range1"),
				"Group radio button failed with female + range 0-5");
		assertTrue(seleniumIsEasyRadioButtonsPage.isRadioButtonsWorkingWithValues("female", "range2"),
				"Group radio button failed with female + range 5-15");
		assertTrue(seleniumIsEasyRadioButtonsPage.isRadioButtonsWorkingWithValues("female", "range3"),
				"Group radio button failed with female + range 5-50");

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00004 - DropDown Demo Section ----------------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "dropDownListTest")
	public void dropDownListTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		SeleniumIsEasyTestPage seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver);
		assertTrue(seleniumIsEasyTestPage.isReady(), "Index page not ready");

		SeleniumIsEasyDropDownPage seleniumIsEasyDropDownPage = seleniumIsEasyTestPage.goToTheDropDownPage();
		assertTrue(seleniumIsEasyDropDownPage.isReady(), "Dropdown Page not ready");

		/*
		 * SELECT LIST DEMO
		 */

		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Monday"), "Monday not working");
		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Tuesday"), "Tuesday not working");
		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Wednesday"), "Wednesday not working");
		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Thursday"), "Thursday not working");
		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Friday"), "Friday not working");
		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Saturday"), "Saturday not working");
		assertTrue(seleniumIsEasyDropDownPage.isSelectListWorkingWithThisArg("Sunday"), "Sunday not working");

		/*
		 * MULTI SELECT LIST DEMO
		 */

		// assertTrue(seleniumIsEasyDropDownPage.isFirstSelectedButtonWorkingCorrectly(),
		// "First Selected Button not working correctly");

		seleniumIsEasyDropDownPage.isGetAllSelectedButtonWorkingCorrectly();
		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00005 - Javascript Alerts Demo Section -------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "javascriptAlertsTest")
	public void javascriptAlertsTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		isReady(seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver));

		try {

		} finally {

		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00006 - Windows PopUp Modal Demo Section ------------ //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "windowsPopupModalTest")
	public void windowsPopupModalTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		isReady(seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver));

		try {

		} finally {

		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00007 - Bootstrap Alerts Demo Section --------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "bootstrapAlertsTest")
	public void bootstrapAlertsTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		isReady(seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver));

		try {

		} finally {

		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Basic Level ---------------- //
	// -------------------------------------------------------------- //
	// ------ US00008 - Bootstrap Modals Demo Section --------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "bootstrapModalsTest")
	public void bootstrapModalsTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		isReady(seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver));

		try {

		} finally {

		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// *************************** TESTS **************************** //
	// -------------------------------------------------------------- //
	// ---------------- Selenium is Easy Advanced Level ------------- //
	// -------------------------------------------------------------- //
	// ------ US00009 - Drag and Drop Demo Sectio---n --------------- //
	// -------------------------------------------------------------- //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "dragAndDrop")
	public void dragAndDrop(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		driver.get(SELENIUM_IS_EASY_INDEX_URL);
		isReady(seleniumIsEasyTestPage = new SeleniumIsEasyTestPage(driver));

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}
}

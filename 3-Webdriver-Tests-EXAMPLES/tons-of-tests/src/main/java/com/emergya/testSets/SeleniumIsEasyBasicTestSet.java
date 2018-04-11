package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

	private static final String SELENIUM_IS_EASY_INDEX_URL = "http://www.seleniumeasy.com/test/";

	/*
	 * Constructor
	 */

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
	 * Steps: -
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
	 * Steps: -
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "checkBoxTest")
	public void checkBoxTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

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
}

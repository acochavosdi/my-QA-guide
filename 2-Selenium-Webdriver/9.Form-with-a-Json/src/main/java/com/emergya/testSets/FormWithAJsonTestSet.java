package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.DemoAutomationTestingRegisterPage;
import com.emergya.utils.BasicTestSet;
import com.emergya.utils.UserBean;
import com.google.gson.Gson;

public class FormWithAJsonTestSet extends BasicTestSet {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(FormWithAJsonTestSet.class);

	/*
	 * Constants
	 */

	private static final String URL_REGISTER = "http://demo.automationtesting.in/Register.html";
	private static final String URL_WEBTABLE = "http://demo.automationtesting.in/WebTable.html";
	private static final String JSON_USER_PATH = "src/main/resources/files/json/register.json";

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// ******************************************************************* //
	// ***************************** TEST ******************************** //
	// ******************************************************************* //
	// ----------- US00008 - Register Form filled from a Json ------------ //
	// ------------------------------------------------------------------- //

	/**
	 * 
	 * TODO TODA ESTA DOCUMENTACION
	 * 
	 * Description: Test the Register Page and form of the app, using Json as an
	 * entry format with the data of a fictional user, in order to test all the
	 * possibilities when registring. (This thing about the Json probably has no
	 * sense since i've read about the data providers on TestNG, but its still
	 * something random to test)
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to the RegisterPage - Check that the form is displayed - Read the
	 * json file and fill an object with the data - Test every field of the form
	 * sending as argument the fields of the object filled with the json - TODO
	 * Check that several results are displayed
	 * 
	 * Post steps: - Close the browser
	 * 
	 * Acquired Knowledge: BufferedReader - Gson - Robot - sendKeys() -
	 * element.getAttribute().isEmpty - element.getText() -
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * 
	 */

	@Test(description = "checkingRegisterPageWithJson")
	public void checkingRegisterPageWithJson(Method method) throws InterruptedException, FileNotFoundException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start checkingRegisterPage test method: "
				+ method.getName());

		// Go to the page
		driver.navigate().to(URL_REGISTER);

		// Check if the page is ready
		isReady(demoAutomationTestingRegisterPage = new DemoAutomationTestingRegisterPage(driver));

		// Get info from the Json
		BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_USER_PATH));
		Gson gson = new Gson();
		UserBean user = gson.fromJson(bufferedReader, UserBean.class);

		// Testing Refresh Button
		assertTrue(demoAutomationTestingRegisterPage.putNameOnForm(user.getName()), "Error inserting name");
		assertTrue(demoAutomationTestingRegisterPage.pulseRefreshButton(), "Error pressing Refresh Button");
		assertTrue(demoAutomationTestingRegisterPage.checkIfNameIsEmpty(),
				"Refresh button didn't worked, name still not empty");

		// Testing Full Form
		assertTrue(demoAutomationTestingRegisterPage.putNameOnForm(user.getName()), "Error inserting name");
		assertTrue(demoAutomationTestingRegisterPage.putLastNameOnForm(user.getLastName()),
				"Error inserting lastname ");
		assertTrue(demoAutomationTestingRegisterPage.putAdressOnForm(user.getAdress()), "Error inserting lastname");
		assertTrue(demoAutomationTestingRegisterPage.putEmailOnForm(user.getEmail()), "Error inserting email");
		assertTrue(demoAutomationTestingRegisterPage.putPhoneOnForm(user.getPhone()), "Error insterting phone");
		assertTrue(demoAutomationTestingRegisterPage.putGender(user.getGender()), "Error inserting gender");
		assertTrue(demoAutomationTestingRegisterPage.putHobbies(user.getHobbies()), "Error inserting hobbies");
		assertTrue(demoAutomationTestingRegisterPage.putLanguages(user.getLanguages()), "Error selecting languages");
		assertTrue(demoAutomationTestingRegisterPage.putSkills(user.getSkills()), "Error selecting skills");
		assertTrue(demoAutomationTestingRegisterPage.PutCountry(user.getCountry()), "Error selecting country");
		assertTrue(demoAutomationTestingRegisterPage.PutSecondCountry(user.getSecondCountryTextEntry(),
				user.getSecondCountryChoose()), "Error selectin secondCountry");
		Thread.sleep(2000); // Wait a few for safe-execution of the next method
		assertTrue(demoAutomationTestingRegisterPage.PutBirthYear(user.getBirthYear()), "Error selecting year");
		assertTrue(demoAutomationTestingRegisterPage.PutBirthMonth(user.getBirthMonth()), "Error selecting month");
		assertTrue(demoAutomationTestingRegisterPage.PutBirthDay(user.getBirthDay()), "Error selecting day");
		assertTrue(demoAutomationTestingRegisterPage.putPassword(user.getPassword()), "error inserting password");
		assertTrue(demoAutomationTestingRegisterPage.putVerifiedPassword(user.getPasswordVerified()),
				"error inserting password");

		// Submit and test if register was OK
		demoAutomationTestingWebtablePage = demoAutomationTestingRegisterPage.submitRegisterForm();

		if (driver.getCurrentUrl() != URL_WEBTABLE) {
			demoAutomationTestingRegisterPage.checkErrorLabels();
			assertTrue(false,
					"Couldnt Reach the WebTable Page, so something is wrong on the form when fill the form and submit'");
		} else {
			assertTrue(demoAutomationTestingWebtablePage.isReady(), "WebTable Page Reached, but not ready");
			driver.navigate().back();
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End checkingRegisterPage test method: "
				+ method.getName());

	}
}

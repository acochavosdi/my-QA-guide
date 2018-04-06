package com.emergya.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class DemoAutomationTestingRegisterPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(DemoAutomationTestingRegisterPage.class);

	/**
	 * Items keys selectors.
	 */

	// PERSONAL
	private static final String REGISTER_FORM_XPATH = "registerFormXPATH";
	private static final String EMAIl_INPUT_XPATH = "emailInputXPATH";
	private static final String FIRSTNAME_INPUT_XPATH = "firstNameInputXPATH";
	private static final String LASTNAME_INPUT_XPATH = "lasttNameInputXPATH";
	private static final String ADRESS_TEXT_AREA_XPATH = "adressTextAreaXPATH";
	private static final String PHONE_INPUT_XPATH = "phoneInputXPATH";

	// GENRE

	private static final String MALE_INPUT_XPATH = "maleInputGenderXPATH";
	private static final String FEMALE_INPUT_XPATH = "FemaleInputGenderXPATH";

	// HOBBIES
	private static final String CRICKET_INPUT_ID = "cricketInputID";
	private static final String MOVIES_INPUT_ID = "moviesInputID";
	private static final String HOCKEY_INPUT_ID = "hockeyInputID";

	// LANGUAGE
	private static final String LANGUAGES_SELECTOR_ID = "languagesSelectorID";
	private static final String LANGUAGES_LIST_XPATH = "languagesListXPATH";

	// SKILLS
	private static final String SKILLS_ID = "skillsID";
	private static final String SKILLS_LIST_XPATH = "skillsListXPATH";

	// COUNTRIES
	private static final String COUNTRY_SELECTOR_ID = "countrySelectorID";
	private static final String COUNTRY_LIST_XPATH = "countriesListXPATH";

	// SECOND COUNTRY
	private static final String SECOND_COUNTRY_HIGHLIGHTED_LIST = "highlightedResultList";

	// BIRTH
	private static final String SELECT_YEAR_ID = "selectYearID";
	private static final String SELECT_MONTH_XPATH = "selectMonthXPATH";
	private static final String SELECT_DAY_ID = "selectDayID";

	private static final String YEARS_LIST_XPATH = "listYearsXPATH";
	private static final String MONTHS_LIST_XPATH = "listMonthsXPATH";
	private static final String DAYS_LIST_XPATH = "listDaysXPATH";

	// PASSWORDS
	private static final String FIRST_PASSWORD_ID = "firstPasswordID";
	private static final String SECOND_PASSWORD_ID = "secondPasswordID";

	// SUBMIT + REFRESH
	private static final String SUBMIT_BUTTON_ID = "submitButtonID";
	private static final String REFRESH_BUTTON_ID = "refreshButtonID";

	// UPLOAD IMAGE
	private static final String UPLOAD_IMAGE_ID = "uploadImageID";

	// ERROR LABELS

	private static final String ERROR_LABEL_CONTAINER_XPATH = "errorLabelContainerXPATH";
	private static final String EMAIL_EXISTS_CONTAINER_XPATH = "errorEmailExistsXPATH";
	private static final String PHONE_EXISTS_CONTAINER_XPATH = "errorPhoneExistsXPATH";

	private static final String SELECT_COUNTRY_SPAN_XPATH = "SelectCountrySpanSelectorXPATH";
	private static final String SELECT_COUNTRY_TEXT_ENTRY_XPATH = "SelectCountryTextEntryInputXPATH";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DemoAutomationTestingRegisterPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks that the PO is ready
	 * 
	 * @param pageObject
	 *            page object to be used
	 */
	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(REGISTER_FORM_XPATH);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public void checkIfEmailPassedIsOnTheForm(String email) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start checkIfEmailPassedIsOnTheForm method");

		if (this.getElementByXPath(EMAIl_INPUT_XPATH).getAttribute("value").equals(email)) {
			log.info("email confirmed, it works from index form");
		} else {
			log.warn("Register Form when coming from index dont send the email to the input, but test will not stop");
		}

		log.info(
				"[log-PageObjects] " + this.getClass().getSimpleName() + " - End checkIfEmailPassedIsOnTheForm method");

	}

	public boolean putNameOnForm(String name) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putNameOnForm method");

		boolean status = false;
		if (this.isElementVisibleByXPath(FIRSTNAME_INPUT_XPATH)) {
			this.getElementByXPath(FIRSTNAME_INPUT_XPATH).sendKeys(name);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putNameOnForm method");

		return status;

	}

	public boolean checkIfNameIsEmpty() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start checkIfNameIsEmpty method");
		boolean status = false;

		if (this.isElementVisibleByXPath(FIRSTNAME_INPUT_XPATH)) {
			if (this.getElementByXPath(FIRSTNAME_INPUT_XPATH).getAttribute("value").isEmpty())
				status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End checkIfNameIsEmpty method");
		return status;

	}

	public boolean putLastNameOnForm(String lastName) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putLastNameOnForm method");

		boolean status = false;
		if (this.isElementVisibleByXPath(LASTNAME_INPUT_XPATH)) {
			this.getElementByXPath(LASTNAME_INPUT_XPATH).sendKeys(lastName);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putLastNameOnForm method");

		return status;

	}

	public boolean putAdressOnForm(String adress) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putAdressOnForm method");

		boolean status = false;
		if (this.isElementVisibleByXPath(ADRESS_TEXT_AREA_XPATH)) {
			this.getElementByXPath(ADRESS_TEXT_AREA_XPATH).sendKeys(adress);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putAdressOnForm method");

		return status;

	}

	public boolean putEmailOnForm(String email) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putEmailOnForm method");

		boolean status = false;
		if (this.isElementVisibleByXPath(EMAIl_INPUT_XPATH)) {
			this.getElementByXPath(EMAIl_INPUT_XPATH).sendKeys(email);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putEmailOnForm method");

		return status;

	}

	public boolean putPhoneOnForm(String phone) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putPhoneOnForm method");

		boolean status = false;
		if (this.isElementVisibleByXPath(PHONE_INPUT_XPATH)) {
			this.getElementByXPath(PHONE_INPUT_XPATH).sendKeys(phone);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putPhoneOnForm method");

		return status;

	}

	public boolean putGender(String gender) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putGender method");
		boolean status = false;

		if (gender.equals("Male"))
			status = putMaleOnForm();
		if (gender.equals("FeMale"))
			status = putFeMaleOnForm();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putGender method");
		return status;

	}

	public boolean putMaleOnForm() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putMaleOnForm method");

		boolean status = false;
		if (this.isElementVisibleByXPath(MALE_INPUT_XPATH)) {
			this.getElementByXPath(MALE_INPUT_XPATH).click();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putMaleOnForm method");

		return status;

	}

	public boolean putFeMaleOnForm() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putFeMaleOnForm method");
		boolean status = false;

		if (this.isElementVisibleByXPath(FEMALE_INPUT_XPATH)) {
			this.getElementByXPath(FEMALE_INPUT_XPATH).click();
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putFeMaleOnForm method");
		return status;
	}

	public boolean putHobbies(String[] hobbies) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putHobbies method");
		boolean status = false;

		for (int i = 0; i < hobbies.length; i++) {
			if (hobbies[i].equals("Cricket"))
				status = putCricketOnForm();

			if (hobbies[i].equals("Movies"))
				status = putMoviesOnForm();

			if (hobbies[i].equals("Hockey"))
				status = putHockeyOnForm();
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putHobbies method");
		return status;
	}

	public boolean putCricketOnForm() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putCricketOnForm method");

		boolean status = false;
		if (this.isElementVisibleById(CRICKET_INPUT_ID)) {
			this.getElementById(CRICKET_INPUT_ID).click();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putCricketOnForm method");

		return status;

	}

	public boolean putMoviesOnForm() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putMoviesOnForm method");

		boolean status = false;
		if (this.isElementVisibleById(MOVIES_INPUT_ID)) {
			this.getElementById(MOVIES_INPUT_ID).click();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putMoviesOnForm method");

		return status;

	}

	public boolean putHockeyOnForm() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putHockeyOnForm method");

		boolean status = false;
		if (this.isElementVisibleById(HOCKEY_INPUT_ID)) {
			this.getElementById(HOCKEY_INPUT_ID).click();
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putHockeyOnForm method");

		return status;

	}

	public boolean putLanguages(String[] languages) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putLanguage method");

		boolean status = false;
		List<WebElement> listLanguages;
		if (this.isElementVisibleById(LANGUAGES_SELECTOR_ID)) {
			this.getElementById(LANGUAGES_SELECTOR_ID).click();

			listLanguages = this.getElementsByXPath(LANGUAGES_LIST_XPATH, 5);

			for (WebElement we : listLanguages) {
				for (int i = 0; i < languages.length; i++) {
					if (we.getText().equals(languages[i])) {
						we.click();
						status = true;
					}
				}
			}
		}
		if (!status)
			log.error("Language not found");
		driver.clickOnWithMouse(By.xpath("//h2"));
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putLanguage method");

		return status;
	}

	public boolean putSkills(String skills) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putSkills method");
		boolean status = false;
		List<WebElement> listSkills;
		if (this.isElementVisibleById(SKILLS_ID)) {
			listSkills = this.getElementsByXPath(SKILLS_LIST_XPATH, 5);

			for (WebElement we : listSkills) {
				if (we.getAttribute("value").equals(skills)) {
					we.click();
					status = true;
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putSkills method");
		return status;

	}

	public boolean PutCountry(String country) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start PutCountry method");
		boolean status = false;

		List<WebElement> listCountries;
		if (this.isElementVisibleById(COUNTRY_SELECTOR_ID)) {
			listCountries = this.getElementsByXPath(COUNTRY_LIST_XPATH, 5);

			for (WebElement we : listCountries) {
				if (we.getAttribute("value").equals(country)) {
					we.click();
					status = true;
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End PutCountry method");
		return status;

	}

	public boolean PutSecondCountry(String secondCountryTextEntry, String secondCountryChoose)
			throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putSecondCountry method");
		boolean status = false;
		if (this.isElementVisibleByXPath(SELECT_COUNTRY_SPAN_XPATH)) {
			this.getElementByXPath(SELECT_COUNTRY_SPAN_XPATH).click();
			if (this.isElementVisibleByXPath(SELECT_COUNTRY_TEXT_ENTRY_XPATH)) {
				this.getElementByXPath(SELECT_COUNTRY_TEXT_ENTRY_XPATH).sendKeys(secondCountryTextEntry);
				// List of the results with the textEntry
				List<WebElement> highlightedList;
				highlightedList = this.getElementsByXPath(SECOND_COUNTRY_HIGHLIGHTED_LIST, 5);
				for (WebElement we : highlightedList) {
					String currentCountry = we.getText();
					if (currentCountry.equals(secondCountryChoose)) {
						we.click();
						status = true;
						break;
					}
				}
			}

		}

		Thread.sleep(2000);
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putSecondCountry method");
		return status;

	}

	public boolean PutBirthYear(String year) throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putYear method");
		boolean status = false;

		List<WebElement> listYears;

		if (this.isElementVisibleById(SELECT_YEAR_ID)) {

			listYears = this.getElementsByXPath(YEARS_LIST_XPATH, 5);

			for (WebElement we : listYears) {
				if (we.getAttribute("value").equals(year)) {
					we.click();
					status = true;
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putYear method");
		return status;
	}

	public boolean PutBirthMonth(String month) throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putYear method");
		boolean status = false;

		List<WebElement> listYears;
		if (this.isElementVisibleByXPath(SELECT_MONTH_XPATH)) {
			listYears = this.getElementsByXPath(MONTHS_LIST_XPATH, 5);

			for (WebElement we : listYears) {
				if (we.getAttribute("value").equals(month)) {
					we.click();
					status = true;
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putYear method");
		return status;
	}

	public boolean PutBirthDay(String day) throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putYear method");
		boolean status = false;

		List<WebElement> listYears;
		if (this.isElementVisibleById(SELECT_DAY_ID)) {
			listYears = this.getElementsByXPath(DAYS_LIST_XPATH, 5);

			for (WebElement we : listYears) {
				if (we.getAttribute("value").equals(day)) {
					we.click();
					status = true;
				}
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putYear method");
		return status;
	}

	public boolean putPassword(String password) {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putPassword method");
		boolean status = false;
		if (this.isElementVisibleById(FIRST_PASSWORD_ID)) {
			this.getElementById(FIRST_PASSWORD_ID).sendKeys(password);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putPassword method");

		return status;
	}

	public boolean putVerifiedPassword(String verifiedPassword) {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start putVerifiedPassword method");
		boolean status = false;
		if (this.isElementVisibleById(SECOND_PASSWORD_ID)) {
			this.getElementById(SECOND_PASSWORD_ID).sendKeys(verifiedPassword);
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End putVerifiedPassword method");

		return status;
	}

	public DemoAutomationTestingWebtablePage submitRegisterForm() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start submitRegisterForm method");
		if (this.isElementVisibleById(SUBMIT_BUTTON_ID)) {
			this.getElementById(SUBMIT_BUTTON_ID).click();
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End submitRegisterForm method");

		return new DemoAutomationTestingWebtablePage(driver);

	}

	public boolean pulseRefreshButton() {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start pulseRefreshButton method");

		if (this.isElementVisibleById(REFRESH_BUTTON_ID)) {
			this.getElementById(REFRESH_BUTTON_ID).click();
			status = true;
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End pulseRefreshButton method");
		return status;
	}

	public boolean checkPopup() {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start checkPopup method");

		// PRESS SUBMIT BUTTON
		if (this.isElementVisibleById(SUBMIT_BUTTON_ID)) {
			this.getElementById(SUBMIT_BUTTON_ID).click();

			// CHECK POPUP
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window

			System.err.println(driver.getTitle());

			driver.switchTo().window(parentWindowHandler); // switch back to parent window
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End checkPopup method");
		return status;
	}

	public boolean uploadImage(String imageFile) throws AWTException {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start uploadImage method");

		// Click On Upload Button
		if (this.isElementVisibleById(UPLOAD_IMAGE_ID)) {
			this.getElementById(UPLOAD_IMAGE_ID).click();

			// Prepare file
			File auxfile = new File("src/main/resources/files/" + imageFile);
			String fileName = auxfile.getAbsolutePath();

			// Use the robot to perform the steps
			try {
				// Setting clipboard with file location
				setClipboardData(fileName);
				// native key strokes for CTRL, V and ENTER keys
				// Some sleep time to detect the window popup
				Thread.sleep(500);

				Robot robot = new Robot();

				// Delete the default string
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_END);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_END);
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);

				// Copy the path to the window popup
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);

				// Press enter to execute a file search
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(500);

				Thread.sleep(1000);

				status = true;
			} catch (Exception e) {
				log.error("Exception when using robot on uploadTheFileByRobot method");
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End uploadImage method");
		return status;
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	public static void setClipboardData(String string) {

		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}

	public boolean checkErrorLabels() {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start checkErrorLabels method");

		if (this.isElementVisibleByXPath(ERROR_LABEL_CONTAINER_XPATH)) {

			try {
				if (this.isElementVisibleByXPath(EMAIL_EXISTS_CONTAINER_XPATH)) {
					log.warn("The content of the web app warning is; "
							+ this.getElementByXPath(EMAIL_EXISTS_CONTAINER_XPATH).getText());
					status = true;
				}
			} catch (ElementNotFoundException e) {
				log.warn(e);
			}

			try {
				if (this.isElementVisibleByXPath(PHONE_EXISTS_CONTAINER_XPATH)) {
					log.warn("The content of the web app warning is; "
							+ this.getElementByXPath(PHONE_EXISTS_CONTAINER_XPATH).getText());
					status = true;
				}
			} catch (ElementNotFoundException e) {
				log.warn(e);
			}

		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End checkErrorLabels method");
		return status;
	}

}
